package model;

public class Garcom {
	
	private String name;
	private int id;
	private String address;
	

	public Garcom(){
		this.name=null;
		this.id=-1;
		this.address=null;
	}
	public Garcom(String name, int id) {
		this.name=name;
		this.id=id;
		this.address=null;
	}
	
	public Garcom(String name, int id, String address) {
		this.name=name;
		this.id=id;
		this.address=address;
	}
	
	public Garcom(String name, String address) {
		this.name=name;
		this.address=address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getAddress() {
		return this.address;
		
	}
	
	public void setName(String name) {
		this.name=name;

	}
	
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public boolean equals(Garcom g) {
		if(this.id==g.id) {
			return true;
		}

		return false;
	}
	
	public void editarGarcom(String newName, int newId, String newAddress) {
	    setName(newName);
	    setId(newId);
	    setAddress(newAddress);
	}
	
	public String toString() {
	    StringBuilder describe = new StringBuilder();
	    describe.append("Garçom: ").append(getName()).append(", ").append(this.getId()).append(" ");
	    return describe.toString();
	}

	

}
