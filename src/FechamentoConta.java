public class FechamentoConta {

    private Pedido pedido;
    private double totalRecebido;

    public FechamentoConta(Pedido pedido, double totalRecebido){
        this.pedido=pedido;
        this.totalRecebido=totalRecebido;
    }

    public double getTotalConta(){
        return this.pedido.getTotalConta();
    }

    public double getTotalGorjeta(){
        return getTotalConta() * 0.15;
    }

    public double getTotalRecebido(){
        return this.totalRecebido;
    }

    public double getTotalTroco(){
        return getTotalRecebido()-getTotalConta() ;

    }

    public String getDescribe(){
        return this.pedido.getDescribe()+"\nTotal de gorjeta: "+getTotalGorjeta()+"\n"+"Total recebido: "+getTotalRecebido()
        +"\n"+"Total do troco: "+getTotalTroco();

    }
    
    
}
