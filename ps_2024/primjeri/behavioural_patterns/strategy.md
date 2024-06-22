```
Context
Strategy
ConcreteStrategies

Client
```


```
// Strategy
interface Comparator<T>:
  abstract int compare(T a, T b)
  
// ConcreteStrategy
class IntegerComparator implements Comparator<int>:
  @override
  int compare(int a, int b):
    return clip(a - b, -1, 1)
    
  int clip(int value, int a, int b):
    if (a - b > upper)
      return upper
    else if (a - b < lower)
      return lower
    else 
      return a - b

// Context
class IntegerPair:
  int a, b
  Comparator<int> comp
  
  constructor (int a, int b):
    this.a = a
    this.b = b
  
  int compare():
    return comp.compare(this.a, this.b)
    
  void setComparator(Comparator<int> c):
    this.comp = c
    
// Client
IntegerPair pair = new IntegerPair(5, 10)
pair.setComparator(new IntegerComparator())
print(pair.compare())
```

