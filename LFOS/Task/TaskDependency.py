from LFOS.Data.Token import Token
from LFOS.Log import LOG, Logs


class TaskDependency(dict):
    def __init__(self):
        super(TaskDependency, self).__init__({})

    def add_task_dependecy(self, task, req_n_tokens):
        if task in self:
            LOG(msg='%s is already in the list of dependent tasks.' % task.get_credential(), log=Logs.WARN)
            return False

        self[task] = req_n_tokens
        LOG(msg='%s is added to the list of dependent tasks.' % task.get_credential(), log=Logs.INFO)
        return True

    def remove_task_dependecy(self, task):
        if task in self:
            self.pop(task)
            LOG(msg='%s is removed from the list of dependent tasks.' % task.get_credential(), log=Logs.INFO)
            return True

        LOG(msg='%s is not in the list of dependent tasks.' % task.get_credential(), log=Logs.WARN)
        return False

    def get_required_token_number(self, task):
        if task in self:
            return self[task]

        LOG(msg='%s is not in the list of dependent tasks.' % task.get_credential(), log=Logs.WARN)
        return 0

    def get_dependent_tasks(self):
        return self.keys()

    def has_dependency(self):
        return False if len(self) == 0 else True