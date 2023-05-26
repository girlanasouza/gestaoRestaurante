
public class Item {
	private String name;
	private String describe;
	private double value;
	
	public Item(String name, String describe, double value) {
		this.name=name;
		this.describe=describe;
		this.value=value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescribe() {
		return this.describe;
	}
	
	public double getValue() {
		return this.value;
	}

}
