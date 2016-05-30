from LFOS.Log import LOG, Logs


class Token(object):
    def __init__(self, token_type, timestamp):
        self.token_type = token_type
        self.timestamp = timestamp

    def set_timestamp(self, timestamp):
        self.timestamp = timestamp

    def set_token_type(self, token_type):
        self.token_type = token_type

    def get_timestamp(self):
        return self.timestamp

    def get_token_type(self):
        return self.token_type

    def __eq__(self, other):
        if isinstance(other, str):
            return self.token_type == other
        elif isinstance(other, Token):
            return self.token_type == other.token_type

        LOG(msg='Invalid \"==\" check.', log=Logs.ERROR)
        return False

    def __str__(self):
        return '(%s, %s)' % (self.token_type, self.timestamp)

    def __repr__(self):
        return '(%s, %s)' % (self.token_type, self.timestamp)