
__TEMPLATE__ = '''<
<table border="0" cellborder="1" cellspacing="0" cellpadding="3">
  <tr>
    <td port="N">{name}:{node}</td>
  </tr>
  <tr port="M"><td>
    <table border="0" cellborder="0" cellspacing="0" cellpadding="0">
{attributes}
    </table></td>
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
                               attributes="\n".join([f"<tr><td align=\"left\">{key} = {value}</td></tr>" for key, value in attributes.items()]))
