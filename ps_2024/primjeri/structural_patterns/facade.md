```
Facade
AdditionalFacade
Service

Client
```

```
class FormValidator:
  method validate():
    // ...
    
class ReceiptGrabber:
  method grab():
    // ...
    
class BankDetailsProcessor:
  method process():
    // ...
    
class PaymentService:
  private field PaymentMethod method
  
  constructor (PaymentMethd)

  method pay(bill):
    FormValidator fv = new FormValidator()
    ReceiptGrabber rg = new ReceiptGrabber()
    BankDetailsProcessor bdp = new BankDetailsProcessor()
    
    if (fv.validate(bill)):
      Receipt r = rg.grab(bill)
      
      BankDetails bd = input()
      
      if (bdp.process(bd))
        this.method.pay(bill)


// client:
Bill electricityBill = new ElectricityBill()
PaymentService ps = new PaymentService(new CreditCard())

ps.pay(electricityBill)

// instead of
Bill electricityBill = new ElectricityBill()
PaymentMethod method = new CreditCard()
FormValidator fv = new FormValidator()
ReceiptGrabber rg = new ReceiptGrabber()
BankDetailsProcessor bdp = new BankDetailsProcessor()

if (fv.validate(bill)):
  Receipt r = rg.grab(bill)
  
  BankDetails bd = input()
  
  if (bdp.process(bd))
    this.method.pay(bill)
```