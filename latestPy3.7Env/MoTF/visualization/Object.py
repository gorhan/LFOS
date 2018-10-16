
__TEMPLATE__ = '''<
<table border="0" cellborder="1" cellspacing="0" cellpadding="3">
  <tr>
    <td port="N">{name}:{node}</td>
  </tr>
  <tr>
    <td port="M" align="left">{attributes}</td>
  </tr>
  <tr>
    <td></td>
  </tr>
  <tr>
    <td port="S"></td>
  </tr>
</table>>'''


def object_node_gen(name, node, attributes):
    return __TEMPLATE__.format(name=name,
                               node=node,
                               attributes="<br/>".join([f"{key} = {value}" for key, value in attributes.items()]))
