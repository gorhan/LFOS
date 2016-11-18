from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Log import LOG, Logs


class TokenPool:
    MAX_TOKEN_AMOUNT = 100

    def __init__(self):
        self.__pool = dict()

    def add_token(self, token_type, timestamp, quantity=1):
        assert isinstance(timestamp, Time)

        if (token_type, timestamp) in self.__pool:
            self.__pool[token_type, timestamp] += quantity
            LOG(msg='Token Update=%s(%d) at %r' % (token_type, quantity, timestamp))
        else:
            self.__pool[token_type, timestamp] = quantity
            LOG(msg='Token Added=%s(%d) at %r' % (token_type, quantity, timestamp))

        return True

    def add_token_list(self, token_lst):
        for token_type, quantity, timestamp in token_lst:
            self.add_token(token_type, timestamp, quantity)

    def get_num_tokens(self, target_token_type, latest_timestamp=None):
        return sum([quantity for pair, quantity in self.__pool.items() if pair[0] == target_token_type and (latest_timestamp is None or pair[1] <= latest_timestamp)])

    def get_token_timestamp_pairs(self, target_token_type, latest_timestamp=None):
        return [pair for pair in self.__pool.keys() if pair[0] == target_token_type and (latest_timestamp is None or pair[1] <= latest_timestamp)]

    def remove_token(self, token_type, quantity=1, latest_timestamp=None, remove=False):
        num_tokens = self.get_num_tokens(token_type, latest_timestamp)
        if num_tokens < quantity:
            LOG(msg='Insufficient number of tokens in the pool. Required: %d, Available: %d.' % (quantity, num_tokens))
            return []

        if not remove:
            return True

        relevant_keys = self.get_token_timestamp_pairs(token_type, latest_timestamp)
        relevant_keys.sort(key=lambda lst: lst[1], reverse=True)

        pairs = {}
        for pair in relevant_keys:
            if quantity <= self.__pool[pair]:
                self.__pool[pair] -= quantity
                break

            pairs[pair] = self.__pool.pop(pair)

        return pairs

    def query(self, query_tuples):
        for q_tuple in query_tuples:
            if self.remove_token(q_tuple[0], q_tuple[1], q_tuple[2]):
                return q_tuple

        return []

    def get_latest_token(self, target_token_type):
        return sorted(self.get_token_timestamp_pairs(target_token_type), key=lambda pair: pair[1])[-1]

    def get_tokens(self, token_type=None):
        tokens = [token for token in self if token_type is None or token.get_token_type() == token_type]
        return tokens, len(tokens)

    def __iter__(self):
        for pair, quantity in self.__pool.items():
            yield pair, quantity

    def __repr__(self):
        return '%s' % '\n'.join('%r --> #tokens=%d' % (pair, quantity) for pair, quantity in self.__pool.items())

    def __str__(self):
        return '%s' % '\n'.join('%r --> #tokens=%d' % (pair, quantity) for pair, quantity in self.__pool.items())
