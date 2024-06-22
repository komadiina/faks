```
Builder
ConcreteBuilder
Product
Director

Client
```

```
class House:
  field color
  field garageDoor
  field[] windows
  
abstract interface HouseBuilder:
  protected field house

  abstract method setColor()
  abstract method setGarageDoor()
  abstract method setWindows()
  
  abstract method reset()
  method getResult() default:
    return this.house
  
class TinyHouseBuilder implements HouseBuilder:
  method setColor():
    this.house.color = gray
    
  method setGarageDoor():
    this.house.garageDoor = false
    
  method setWindows():
    this.house.windows = [tinyWindow, tinyWindow]
    
  method reset():
    this.house = new House
    
class MansionBuilder implements HouseBuilder:
  method setColor():
    this.house.color = white
  
  method setGarageDoor():
    this.house.garageDoor = true
  
  method setWindows():
    this.house.windows = [hugeWindow, hugeWindow, hugeWindow]
  
  method reset():
    this.house = new House
    
class HouseDirector:
  method buildTinyHouse():
    tBuilder = new TinyHouseBuilder
    
    tBuilder.setGarageDoor()
    tBuilder.setWindows()
    tBuilder.setColor()
    
    return tBuilder.getResult()
    
  method buildMansion():
    mBuilder = new MansionBuilder
    
    mBuilder.setGarageDoor()
    mBuilder.setWindows()
    mBuilder.setColor()
    
    return mBuilder.getResult()
```