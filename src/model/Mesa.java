package model;

public class Mesa {
    private int id;
    private int numberTable;
    private boolean disponivel; 

    public Mesa() {
        this.id = -1;
        this.numberTable = -1;
        this.disponivel = true;
    }
    
    public Mesa(int numberTable) {
        this.id = -1;
        this.numberTable = numberTable;
        this.disponivel = true;
    }
    public Mesa(int id, int numberTable) {
    	  this.id = id;
          this.numberTable = numberTable;
    }

    public Mesa(int id, int numberTable, boolean disponivel) {
        this.id = id;
        this.numberTable = numberTable;
        this.disponivel = disponivel;
    }
    
    public Mesa(int numberTable, boolean disponivel) {
        this.numberTable = numberTable;
        this.disponivel = disponivel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void mesaDisponivel() {
    	this.disponivel=true;
    }

    public void setNumberTable(int numberTable) {
        this.numberTable = numberTable;
    }

    public void setAvaliableTable( boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getNumberTable() {
        return this.numberTable;
    }

    public boolean getAvaliableTable() {
        return this.disponivel;
    }

    public boolean disponivelMesa() {
        if (this.disponivel) {
            return true;
        }
        return false;
    }
    public String verify() {
        if (this.disponivel) {
            return ", mesa disponível";
        }
        return ", mesa não disponível";
    }
    public void setStatus(boolean disponivel) {
    	this.disponivel=disponivel;
    }
    
    public String toString() {
        String retorno = "Mesa: " + getNumberTable();
        return retorno;
    }
    
    public boolean equals(Mesa mesa) {
    	if(this.id!=mesa.id) {
    		return false;
    	}
    	if(this.disponivel!=mesa.disponivel) {
    		return false;
    	}
    	if(this.numberTable!=mesa.numberTable) {
    		return false;
    	}
    	return true;
    }
}
