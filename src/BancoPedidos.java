import java.util.*;

public class BancoPedidos extends ConnectionBase{
    private  ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public boolean inserirPedido(Pedido pedido){
        if(!pedidos.contains(pedido)){
            pedidos.add(pedido);
            return true;
        }
        return false;

    }

    public void setPedidos(ArrayList<Pedido> pedidos){
        this.pedidos=pedidos;
    }

    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }

  

    public String toString(){
        String retorno="";
        for(Pedido pedido:this.getPedidos()){
            retorno+=pedido.getDescribe();
        }
        return retorno;
    }
    
}
