package model;

public class Item {
	private int id;
	private String name;
	private String describe;
	private double value;
	
	public Item() {
		this.id=-1;
		this.name="";
		this.describe="";
		this.value=0;
	}
	public Item(String name, String describe, double value) {
		this.name=name;
		this.describe=describe;
		this.value=value;
	}

	
	public Item(int id,String name, String describe, double value) {
		this.id=id;
		this.name=name;
		this.describe=describe;
		this.value=value;
	}

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public String getDescribe() {
		return this.describe;
	}
	
	public void setDescribe(String describe) {
		this.describe=describe;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void setValue(Double value) {
		this.value=value;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setId(String describe) {
		this.describe = describe;
	}
	
	public void setValue(int value) {
		this.value=value;
	}
	
	public String toString() {
	    String retorno = "ID: " + getId() + 
	                     ", " + getName() + 
	                     ", " + getDescribe() + 
	                     ", Valor: " + getValue() ;
	    return retorno;
	}

	public boolean isBlank() {
		return name.isEmpty() && describe.isEmpty() && value == 0;
	}

	public boolean equals(Item item){
		if(this.name!=item.name){
			return false;
		}
		if(this.describe!=item.describe){
			return false;
		}
		if(this.value!=item.value){
			return false;
		}
		return true;

	}
	
	
}