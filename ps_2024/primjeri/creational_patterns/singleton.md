```
Singleton
Client
```


```
class DirectorSingleton:
  class Director:
    public field name, surname
    
  private static field instance
  
  public static getInstance():
    if this.instance is null:
      this.instance = new Director("Unique", "Director")
    
    return this.instance  
```