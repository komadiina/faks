```
Handler
BaseHandler
ConcreteHandler

Client
```


```
def File:
  field Byte[] content
  
def Filesystem:
  field List<File> files
  
interface Scanner:
  abstract method scan(File f)
  
class PUPScanner implements Scanner:
  field Scanner next;
  
  constructor (Scanner n)
    this.next = n

  @override
  method scan(File f):
    if (hasPUPs(f))
      return DANGEROUS
      
    else if (next not null):
      return next.scan(f)
      
    return NOT_DANGEROUS
    
class RootkitScanner implements Scanner:
  field Scanner next
  
  constructor (Scanner n)
    this.next = n
  
  @override
  method scan(File f):
    if (hasRootkits(f))
      return DANGEROUS
      
    else if (next not null)
      return next.scan(f)
    
    return NOT_DANGEROUS
    
class TrojanScanner implements Scanner:
  field Scanner next
  
  constructor (Scanner n)
    this.next = n
  
  @override
  method scan(File f):
    if (hasTrojans(f))
      return DANGEROUS
    
    else if (next not null)
      return next.scan(f)
      
    return NOT_DANGEROUS
      
def Antivirus implements Scanner:
  field Scanner next;
  
  constructor (Scanner n)
    this.next = n

  @Override
  method scan(File f):
    if (next not null)
      return next.scan(f)
      
    return NOT_DANGEROUS
    


// client
File malware = new File(TROJAN_CONTENT)
Antivirus av = new Antivirus(
  new PUPScanner(
    new RookitScanner(
      new TrojanScanner()
    )
  )
)

print(av.scan(malware)) // 'DANGEROUS'
```