```
Component
ConcreteComponent
BaseDecorator
ConcreteDecorator

Client
```

```
interface ContentSource:
  method writeData(Byte[] data) -> void
  method readData() -> Byte[]
  
interface Cryptography:
  method encrypt(Byte[] data) -> Byte[]:
    // logic
    
  method decrypt(Byte[] data) -> Byte[]:
    // logic

class File implements ContentSource:
  field Byte[] content
  
class FileDecorator implements ContentSource:
  field ContentSource wrappee
  
  constructor (ContentSource source):
    this.wrappee = source
  
  @override
  method writeData(Byte[] data) -> void:
    wrappee.writeData(data)
    
  @override
  method readData() -> Byte[]
    return wrappee.readData()
    
class FileEncryptor extends FileDecorator implements Cryptography:
  method readData() -> Byte[]
    return wrappee.readData()
  
  method writeData(Byte[] data) -> void:
    wrappee.writeData(Cryptography.encrypt(data))
    
class FileDecryptor extends FileDecorator implements Cryptography:
  method readData() -> Byte[]:
    return Cryptography.decrypt(wrappee.readData())
  
  method writeData(Byte[] data) -> void:
    return wrappee.readData()
```


ili neki slican primjer sa babuskama:
```
interface Package:
  method unpack() -> Package
  method pack() -> Package
  
class Babushka implements Package:
  field String color
  
  
  
class BabushkaDecorator implements Package:
  private field Package wrappee
  
  constructor (Babushka b):
    this.wrappee = b
    
class RedBabushka extends BabushkaDecorator:
  method unpack() -> Package:
    return this.wrappee
    
  method pack() -> Package:
    this.color = "red"
    return this
  
class BlueBabushka extends BabushkaDecorator:
  method unpack() -> Package: 
    return this.wrappee
    
  method pack() -> Package:
    this.color = "blue"
    return this
    
class GreenBabushka extends BabushkaDecorator:
  method unpack() -> Package:
    return this.wrappee
    
  method pack() -> Package:
    this.color = "green"
    return this
```