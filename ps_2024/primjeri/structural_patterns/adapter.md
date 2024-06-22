```
ClientInterface
Adapter
Service

Client
```


```
class Data
class CSVData extends Data
class XMLData extends XMLData

class Adapter:
  field warehouse
  
  constructor (Warehouse wh)
    this.warehouse = wh
  
  method save(Data d):
    if d not instanceof CSVData:
      wh.save(toCSV(d))
    else wh.save(d)

  private method toCSV(Data d) -> CSVData:
    // conversion logic

class Warehouse:
  constructor (WarehouseType type):
    this.warehouse = instantiate(type)
    
  method save(CSVData d):
    this.warehouse.save(d)


// client:
wh = new WarehouseAdapter()

data = new XMLData("...")
data.saveTo(wh) // converts to XMLData

data = new CSVData("...")
data.saveTo(wh) // passes data directly to warehouse
```