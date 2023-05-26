

public class Garcon {
	
	private String name;
	private int id;
	private String address;
	

	public Garcon(String name, int id, String address) {
		this.name=name;
		this.id=id;
		this.address=address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String Address() {
		return this.address;
		
	}
	
	public void setName(String name) {
		this.name=name;

	}
	
	public boolean equals(Garcon g) {
		if(this.id==g.id) {
			return true;
		}

		return false;
	}
	


	
	
	
	

}
