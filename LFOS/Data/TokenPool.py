from LFOS.Data.Token import *


class TokenPool(list):
    def __init__(self):
        list.__init__([])

    def add_token(self, token_type, timestamp, quantity=1):
        self += [Token(token_type, timestamp)] * quantity
        return True

    def remove_token(self, token_type, quantity=1):
        relevant_tokens, num_relevant_tokens = self.get_tokens(token_type)
        if num_relevant_tokens < quantity:
            LOG(msg='Insufficient number of tokens in the pool. Required: %d, Available: %d.' % (quantity, num_relevant_tokens))
            return False

        relevant_tokens.sort(key=lambda token: token.get_timestamp())
        for index in range(quantity):
            index = self.index(relevant_tokens[index])
            self.pop(index)

        return True

    def query(self, token_type, required_quantity):
        return self.get_token_number(token_type) >= required_quantity

    def query(self, required_token_types):
        for token_type, quantity in required_token_types:
            if token_type in self and self.get_tokens(token_type)[1] < quantity:
                return False

        return True

    def get_latest_token(self, token_type):
        relevant_tokens, _ = self.get_tokens(token_type)
        if not relevant_tokens:
            return None

        relevant_tokens.sort(key=lambda token: token.get_timestamp())
        return relevant_tokens[-1]

    def get_tokens(self, token_type):
        tokens = [token for token in self if token.get_token_type() == token_type]
        return token, len(tokens)

    def __repr__(self):
        return '%s' % '\n'.join(['%3d. %s' % (ind+1, str(token)) for ind, token in enumerate(self)])

    def __str__(self):
        return '%s' % '\n'.join(['%3d. %s' % (ind + 1, str(token)) for ind, token in enumerate(self)])
