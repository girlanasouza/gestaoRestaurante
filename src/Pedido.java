import java.util.ArrayList;

public class Pedido {
    private ArrayList<Item> itens = new ArrayList<>();
    private double totalConta=0;
    private Mesa table;
    private Garcom garcom;


    public boolean addItensMenu(Item item){
        if(!itens.contains(item)){
            itens.add(item);
            return true;
        }
        
        return false;
        
    }
    
    public boolean addItem(Item item) {

		if(!itens.contains(item)) {
			itens.add(item);
			return true;
		}
		return false;
	}

    public Pedido(Mesa table, Garcom garcom){
        this.table=table;
        this.garcom=garcom;
    }

    public void setgarcom(Garcom garcom){
        this.garcom = garcom;
    }

    public void setTable(Mesa table){
        this.table=table;
    }

    public Mesa getTable(){
        return this.table;
    }

    public Garcom getGarcom(){
        return this.garcom;
    }
    
    
    public String getDescribe(){
        String retorno = "";

        for(Item item:itens){
            retorno = retorno + item.toString()+"\n";
            this.totalConta+=item.getValue();
        }
        retorno=retorno+this.garcom.toString()+table.toString()+"Total da conta: "+this.totalConta;
        return retorno;
    }

    public double getTotalConta(){
        return this.totalConta;
    }





}
