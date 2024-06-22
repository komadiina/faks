```
Prototype
ConcretePrototype
[...SubclassPrototype]

Client
```


```
// Prototype
class File:
  field metadata, content
  
  copy constructor File(File f):
    this.metadata = f.metadata
    this.content = f.content
  
  method clone():
    return new File(this)
    
// ConcretePrototype
class Image extends Prototype:
  field resolution
  
  copy constructor Image(Image i):
    super(i)
    this.resolution = i.resolution
    
  method clone():
    return new Image(i)
    
// SubclassPrototype
class BitmapImage extends Image:
  field bpp;
  
  copy constructor BitmapImage(BitmapImage bi):
    super(bi)
    this.bpp = bi.bpp;
    
  method clone():
    return new BitmapImage(this)
```