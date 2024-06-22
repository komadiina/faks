```
Abstraction
Implementation
Refined Abstraction (optional)
ConcreteImplementation
```


```
abstract class OS:
  field GUI gui
  
  constructor (GUI gui):
    this.gui = gui
  
  abstract method render(GUI gui)

class Windows extends OS:
  method render():
    gui.useWinAPI()
    gui.setMaterialStyle()
  
class Mac extends OS:
  method render():
    gui.useX11()
    gui.setRoundButtons()
  
class Linux extends OS:
  method render():
    gui.useX11()

interface GUI:
  method setRoundButtons()
  method useX11()
  method useWinAPI()
  method setMaterialStyle()
  
class WindowsGUI implements GUI:
  method useWinAPI():
    this.setAPI(WinAPI)
    
  method setMaterialStyle():
    this.setStyle(Material)
    
class MacGUI implements GUI:
  method useX11():
    this.setRenderer(X11)
    
  method setRoundButtons():
    this.useRoundButtons = true
    
class LinuxGUI implements GUI:
  method useX11():
    this.setRenderer(X11)
    
    
// client
OS os = new WindowsOS(new WindowsGUI)
os.render()
```