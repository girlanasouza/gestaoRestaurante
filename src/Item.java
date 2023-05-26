
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
		String retorno = "Nome do prato: "+getName()+"\n"+"Descrição: "+getDescribe()+"\n"+
	"Valor: "+getValue()+"\n";
		return retorno;
	}
	
	

}
