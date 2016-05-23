
class TaskCredential(object):
    NONAME_TASK_TYPE_COUNTER = 0

    def __init__(self, _name, _type):
        if not _type:
            _type = 'TASKTYPE_%d' % TaskCredential.NONAME_TASK_TYPE_COUNTER
            TaskCredential.NONAME_TASK_TYPE_COUNTER += 1

        self.type = _type
        self.name = _name

    def set_task_type(self, _type):
        self.type = _type

    def get_task_type(self):
        return self.type

    def set_task_name(self, _name):
        self.name = _name

    def get_task_name(self):
        return self.name

    def get_credential(self):
        return 'TASK: %s -- TYPE: %s' % (self.name, self.type)