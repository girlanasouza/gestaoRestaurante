
public class Mesa {
	private int numberTable;
	private boolean avaliableTable; // se mesa disponivel retorna true senão false

	public Mesa(int numberTable, boolean avaliableTable){
		this.numberTable = numberTable;
		this.avaliableTable=avaliableTable;
	}
	
	public boolean verifyAvaliableTable() {
		if(this.avaliableTable=!true) {
			return true;
		}
		else {
			return false;
		}
	}

	public void setNumberTable(int numberTable){
		this.numberTable=numberTable;
	}

	public void setAvaliableTable(boolean avaliableTable){
		this.avaliableTable=avaliableTable;
	}

	public int getNumberTable(){
		return this.numberTable;
	}

	public boolean getAvaliableTable(){
		return this.avaliableTable;
	}

	public String verify(){
		if(avaliableTable==true){
			return "mesa disponível";
		}
		else{
			return "mesa não disponível";
		}
	}

	public String toString(){
		String retorno = "Número de mesa: "+getNumberTable()+"\n";

		return retorno;

	}
	
	

}
