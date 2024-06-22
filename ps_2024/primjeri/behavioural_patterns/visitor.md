```
Visitor
ConcreteVisitor
Element
ConcreteElement
```

```
// Element
interface Node:
  abstract void accept(Visitor vst)
  
// ConcreteElement
class TreeNode implements Node:
  int num
  TreeNode* left, right

  constructor (int n):
    this.num = n

  @override
  void accept(Visitor vst):
    return vst.visit(this)
    
  void inorder(Visitor vst):
    this.accept(vst)
    this.left.inorder(vst)
    this.right.inorder(vst)

// Visitor
interface Visitor:
  abstract void visit(Node element)
  
// ConcreteVisitor
class Multiplier implements Visitor:
  @override
  void visit(TreeNode element):
    if (element not null)
      element.num *= 2
    
// client
TreeNode root = new TreeNode(1)
root.left = new TreeNode(2)
root.right = new TreeNode(3)
Visitor v = new Multiplier()
root.inorder(v)
```