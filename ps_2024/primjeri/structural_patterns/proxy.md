```
ServiceInterface
Service
Proxy

Client
```

```
class Request:
  string[] headers
  string body
  
class Response:  
  string[] headers
  string? body
  
  int statusCode
  string statusText

interface RequestProcessor:
  abstract method process()

class Server:
  int port
  
  def accept(Request req):
    return this.process(req)
  
  @override
  def process(Request req) -> Response:
    // ...

class ProxyServer:
  Server* server
  int port = server.getPort() + 1
  
  @override
  def accept(Request req) -> Response:
    if (isCached(IP(req)))
      timeout(req, 333)
      
    checkSQLInjection(req)
    verifyAuth(req)
    verifyBody(req)
     
     return server.accept(req)
```