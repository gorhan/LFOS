from LFOS.Log import LOG, Logs


class Token(object):
    def __init__(self, token_type, timestamp, quantity=1):
        self.token_type = token_type
        self.quantity = quantity

        self.timestamps = list()
        if type(timestamp) is list:
            self.timestamps += timestamp
            self.timestamps.sort()
        else:
            self.timestamps += [timestamp] * quantity

    def fire_token(self, timestamp, quantity=1):
        if type(timestamp) is list:
            self.timestamps += timestamp
            self.timestamps.sort()
        else:
            self.timestamps += [timestamp] * quantity
        self.quantity += quantity

    def consume_token(self, quantity=1):
        if quantity > self.quantity:
            LOG(msg='Insufficient number of tokens belonging to %s. #tokens=%d' % (self.token_type, self.quantity), log=Logs.ERROR)
            return None
        elif quantity == self.quantity:
            self.quantity
            LOG(msg='All tokens belonging to %s is consumed. #tokens=%d' % (self.token_type, self.quantity), log=Logs.INFO)
        else:
            self.quantity -= quantity
            self.timestamps = self.timestamps[quantity:]
            LOG(msg='Tokens belonging to %s is consumed. #tokens=%d' % (self.token_type, self.quantity), log=Logs.INFO)

        return self.token_type

    def get_quantity(self):
        return self.quantity

    def get_timestamps(self):
        return self.timestamps

    def query(self, required_quantity):
        return self.quantity >= required_quantity

    def __eq__(self, other):
        if isinstance(other, str):
            return self.token_type == other
        elif isinstance(other, Token):
            return self.token_type == other.token_type

        LOG(msg='Invalid == check.', log=Logs.ERROR)
        return False

    def __str__(self):
        return '(%s, %s, %d)' % (self.token_type, ', '.join(self.timestamps), self.quantity)

    def __repr__(self):
        return '(%s, %s, %d)' % (self.token_type, ', '.join(self.timestamps), self.quantity)