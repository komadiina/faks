```
Context
FlyweightFactory
Flyweight

Client
```

```
class Sprite:
  field String path
  field String name

class Particle:
  field float x, y
  field Sprite sprite
    
class MovingParticle:
  field float speed
  field Particle* baseParticle
  
  method move(dx, dy):
    baseParticle.x += dx
    baseParticle.y += dy
    this.speed += sqrt(dx**dx + dy**dy) * (dx + dy > 0 ? +1 : -1)
    
  method getSprite():
    return baseParticle.sprite
  
class MovingParticleFactory:
  field MovingParticle[] cache
  
  method get(part):
    if cache.contains(part):
      return cache.get(part)
    
    cache.add(new MovingParticle(part))
    
    return cache.get(part)
```