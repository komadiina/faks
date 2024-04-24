public class B implements Data {
	public String type;
	public Double value;
	public Double size;
		
	public B(String type, Double value, Double size) {
		this.type = type;
		this.value = value;
		this.size = size;
	}
		
	@Override
	public String getType() { return this.type; }
	
	@Override
	public Double getValue() { return this.value; }
	
	public String toString() {
		return String.format("%1$s -> %2$.2f | HashCode: %1$H", getType(), getValue(), Integer.toHexString(hashCode()));
	}	
}