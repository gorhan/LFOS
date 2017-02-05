from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Log import LOG, Logs


class TokenPool:
    MAX_TOKEN_AMOUNT = 100

    def __init__(self):
        self.__pool = dict()

    def add_token(self, token_type, timestamp=Time(0), quantity=0):
        assert isinstance(timestamp, Time)

        if token_type in self.__pool:
            self.__pool[token_type].append([timestamp, quantity])
            self.__sort_token_wrt_timestamp()
            LOG(msg='Token Update=%s(%d) at %r' % (token_type, quantity, timestamp))
        else:
            self.__pool[token_type] = [[timestamp, quantity]]
            LOG(msg='Token Added=%s(%d) at %r' % (token_type, quantity, timestamp))

        return True

    def __sort_token_wrt_timestamp(self):
        for _, pair in self.__pool.items():
            pair.sort(key=lambda p: p[0])

    def add_token_list(self, token_lst):
        for list_or_token_type in token_lst:
            if type(list_or_token_type) is str:
                self.add_token(list_or_token_type)
            elif type(list_or_token_type) is list or type(list_or_token_type) is tuple:
                self.add_token(list_or_token_type[0], list_or_token_type[1], list_or_token_type[2])

    def get_num_tokens(self, target_token_type, latest_timestamp=None):
        return sum([pair[1] for token_type, pair in self.__pool.items() if token_type == target_token_type and (latest_timestamp is None or pair[0] <= latest_timestamp)])

    def get_token_timestamps(self, target_token_type, latest_timestamp=None):
        return [pair for pair in self.__pool[target_token_type] if (latest_timestamp is None or pair[0] <= latest_timestamp)]

    def remove_token(self, token_type, quantity=1, latest_timestamp=None, remove=False):
        num_tokens = self.get_num_tokens(token_type, latest_timestamp)
        if num_tokens < quantity:
            LOG(msg='Insufficient number of tokens in the pool. Required: %d, Available: %d.' % (quantity, num_tokens))
            return []

        if not remove:
            return True

        timestamp_quantity = self.get_token_timestamps(token_type, latest_timestamp)
        timestamp_quantity.sort(key=lambda lst: lst[0])

        pairs = {}
        for pair in timestamp_quantity:
            if quantity <= pair[1]:
                pair[1] -= quantity
                break

            pos = self.__pool[token_type].index(pair)
            pairs[token_type] = self.__pool[token_type].pop(pos)

        return pairs

    def clear_tokens(self):
        self.__pool = {}
        LOG(msg='Token pool has been flushed...')

    def query(self, query_tuples):
        for q_tuple in query_tuples:
            if self.remove_token(q_tuple[0], q_tuple[1], q_tuple[2]):
                return q_tuple

        return []

    def get_latest_token(self, target_token_type):
        return self.get_token_timestamps(target_token_type)[-1]

    def get_tokens_as_dict(self):
        return self.__pool

    def __iter__(self):
        for token_type, pair in self.__pool.items():
            yield token_type, pair

    def __repr__(self):
        return '%s' % '\n'.join('%s fired at %r --> #tokens=%d' % (token_type, Time.decode(pair[0]), pair[1]) for token_type, pair in self.__pool.items())

    def __str__(self):
        return '%s' % '\n'.join('%s fired at %r --> #tokens=%d' % (token_type, Time.decode(pair[0]), pair[1]) for token_type, pair in self.__pool.items())
