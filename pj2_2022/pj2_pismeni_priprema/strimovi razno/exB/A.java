public class A implements Data {
	public String type;
	public Double value;
	public String color;
	
	public A(String type, Double value, String color) {
		this.type = type; this.value = value; this.color = color;
	}
	
	@Override
	public String getType() { return this.type; }
	
	@Override
	public Double getValue() { return this.value; }
	
	public String toString() {
		return String.format("%1$s -> %2$.2f | HashCode: %1$H", getType(), getValue(), Integer.toHexString(hashCode()));
	}	
}