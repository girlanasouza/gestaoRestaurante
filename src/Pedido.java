import java.util.ArrayList;

public class Pedido {
    private ArrayList<Item> itens = new ArrayList<>();
    private double totalConta=0;
    private Mesa mesa;
    private Garcom garcom;
    private String situacao;

    public Pedido(ArrayList<Item> itens, Mesa mesa, Garcom garcom, String situacao){
        itens = new ArrayList<>();
        this.mesa=mesa;
        this.garcom=garcom;
        this.situacao=situacao;
    }
    
    public void setgarcom(Garcom garcom){
        this.garcom = garcom;
    }

    public Garcom getGarcom(){
        return this.garcom;
    }

    public void setMesa(Mesa mesa){
        this.mesa=mesa;
    }

    public Mesa getMesa(){
        return this.mesa;
    }

    public void setSitucao(String situacao){
        this.situacao=situacao;
    }

    public String getSituacao(){
        return this.situacao;
    }

    public boolean addItemPedido(Item item){
        if(!itens.contains(item)){
            itens.add(item);
            return true;
        }
        return false;
        
    }

    public void removeItemPedido(Item item){
        for(Item i:itens){
            if(i.equals(item)){
                itens.remove(i);
            }
        }
    }
    
    public boolean addItem(Item item) {

		if(!itens.contains(item)) {
			itens.add(item);
			return true;
		}
		return false;
	}

    public Pedido(Mesa mesa, Garcom garcom){
        this.mesa=mesa;
        this.garcom=garcom;
    }    
    
    public String getDescribe(){
        String retorno = "";

        for(Item item:itens){
            retorno = retorno + item.toString()+"\n";
            this.totalConta+=item.getValue();
        }
        retorno=retorno+this.garcom.toString()+mesa.toString()+"Total da conta: "+this.totalConta+"\n"+getSituacao();
        return retorno;
    }

    public double getTotalConta(){
        return this.totalConta;
    }

}
