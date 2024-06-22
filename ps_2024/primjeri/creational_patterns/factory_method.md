```
Creator
ConcreteCreator
Product
ConcreteProduct
```

```
abstract class Vehicle

class SportsCar extends Vehicle

class Truck extends Vehicle

interface VehicleFactory
  abstract method construct()
  
class SportsCarFactory implements VehicleFactory
  method construct():
    return new SportsCar
    
class TruckFactory implements VehicleFactory
  method construct():
    return new Truck
```