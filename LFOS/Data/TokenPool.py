from LFOS.Data.Token import *


class TokenPool(list):
    def __init__(self):
        list.__init__([])

    def add_token(self, token_type, timestamp, quantity=1):
        self += [Token(token_type, timestamp)] * quantity
        return True

    def add_token_list(self, token_lst):
        for item in token_lst:
            self.append(item)

    def remove_token(self, token_type, quantity=1):
        relevant_tokens, num_relevant_tokens = self.get_tokens(token_type)
        if num_relevant_tokens < quantity:
            LOG(msg='Insufficient number of tokens in the pool. Required: %d, Available: %d.' % (quantity, num_relevant_tokens))
            return list()

        relevant_tokens.sort(key=lambda token: token.get_timestamp())
        tokens = list()
        for index in range(quantity):
            index = self.index(relevant_tokens[index])
            tokens.append(self.pop(index))

        return tokens

    def query(self, required_token_types):
        reserved = list()
        for token_type, quantity in required_token_types:
            if self.get_tokens(token_type)[1] < quantity:
                reserved += self.remove_token(token_type, quantity)
            else:
                self.add_token_list(reserved)
                return list()

        return reserved

    def get_latest_token(self, token_type):
        relevant_tokens, _ = self.get_tokens(token_type)
        if not relevant_tokens:
            return None

        relevant_tokens.sort(key=lambda token: token.get_timestamp())
        return relevant_tokens[-1]

    def get_tokens(self, token_type):
        tokens = [token for token in self if token.get_token_type() == token_type]
        return tokens, len(tokens)

    def __repr__(self):
        return '%s' % '\n'.join(['%3d. %s' % (ind+1, str(token)) for ind, token in enumerate(self)])

    def __str__(self):
        return '%s' % '\n'.join(['%3d. %s' % (ind + 1, str(token)) for ind, token in enumerate(self)])
