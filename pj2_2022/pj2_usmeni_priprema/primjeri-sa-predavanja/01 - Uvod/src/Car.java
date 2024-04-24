
public class Car
{
	private boolean started;

	public void start(){
		started = true;
	}

	public void stop(){
		started = false;
	}

	public static void main(String[] args) {		
        Car vw = new Car();
        
        vw.start();
        System.out.println(vw.started);
        
        vw.stop();
        System.out.println(vw.started);
        
		Car audi = null;
		audi.start();
	}
}
