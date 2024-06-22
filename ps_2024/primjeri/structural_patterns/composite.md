```
Component
Leaf
Composite

Client
```

```
interface FileSystemElement:
  method display():
    print("FileSystemElement")
    
class File implements FileSystemElement:
  method display():
    print(os.getMetadata(this))
    
class Image extends File:
  method display():
    super.display()
    print(os.getResolution(this))

class Directory extends File:
  field FileSystemElement[] content

  method display():
    super.display()
    
    foreach item in this.content:
      item.display()
```