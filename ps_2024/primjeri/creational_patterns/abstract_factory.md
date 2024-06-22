```
AbstractFactory
ConcreteFactory [1..N]
AbstractProduct [1..N]
ConcreteProduct [1..N]

Client
```

```
abstract interface FurnitureFactory:
  method construct()
  
abstract class Chair
abstract class Table
abstract class Desk

class AntiqueChair
class AntiqueTable
class AntiqueDesk

class ModernChair
class ModernTable
class ModernDesk
  
class Antique implements FurnitureFactory:
  method construct():
    return new {AntiqueChair, AntiqueTable, AntiqueDesk}
    
class Modern implements FurnitureFactory:
  method construct():
    return new {ModernChair, ModernTable, ModernDesk}
```