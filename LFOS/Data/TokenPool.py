from LFOS.Data.Token import *


class TokenPool(list):
    def __init__(self):
        list.__init__([])

    def append(self, p_object):
        if isinstance(p_object, Token) and p_object in self:
            p_object.fire_token(p_object.get_timestamps(), p_object.get_quantity())

    def fire_token(self, token_type, timestamp, quantity=1):
        self.append(Token(token_type, timestamp, quantity))

    def consume_token(self, token_type, quantity=1):
        if token_type in self:
            index = self.index(token_type)
            return self[index].consume_token(quantity)

        LOG(msg='Given token %s is not in the pool.' % token_type, log=Logs.ERROR)
        return None

    def query(self, token_type, required_quantity):
        return token_type in self and self[self.index(token_type)].query(required_quantity)

    def get_token_number(self, token_type):
        if token_type in self:
            index = self.index(token_type)
            return self[index].get_quantity()

        return 0

    def get_latest_timestamp(self, token_type):
        if token_type in self:
            index = self.index(token_type)
            return self[index].get_latest_timestamp()

        return None