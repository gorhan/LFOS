
from FeatureModel import Model

m = Model('Root')
m.add_feature(parent='Root', children=['NewNode-1%d' % (id+1) for id in range(3)], max=4, min=2)
m.add_feature(parent='Root', children=['NewNode-2%d' % (id+1) for id in range(7)], max=4, min=2)
m.add_feature(parent='Root', children=['NewNode-3%d' % (id+1) for id in range(4)], max=4, min=4)
m.add_feature(parent='NewNode-23', children=['NewNode-23%d' % (id+1) for id in range(5)], max=1, min=1)
m.instantiate()


from FeatureModel import Model
s = Model('S')
s.add_feature(parent='S', children=['D', 'E'], min=1, max=2)
s.add_feature(parent='S', children=['A', 'B', 'C'], min=2, max=2)
s.add_feature(parent='B', children=['BA', 'BB', 'BC', 'BD', 'BE', 'BF'], min=2, max=5)
s.instantiate()