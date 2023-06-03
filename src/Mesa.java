
public class Mesa {
	private int numberTable;
	private boolean avaliableTable; // se mesa disponivel retorna true senão false

	public Mesa(int numberTable, boolean avaliableTable){
		this.numberTable = numberTable;
		this.avaliableTable=avaliableTable;
	}
	
	public boolean verifyAvaliableTable() {
		if(this.avaliableTable!=true) {
			return false;
		}

		return true;
		
	}

	public void mesaDisponivel(){
        setAvaliableTable(true);
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
		if(getAvaliableTable()==true){
			return ", mesa disponível";
		}
		return ", mesa não disponível";

	}

	public String toString(){
		String retorno = "Número de mesa: "+getNumberTable()+"\n"+verify()+"\n";

		return retorno;

	}
	
	

}
