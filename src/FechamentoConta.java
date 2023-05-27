public class FechamentoConta {

    private Pedido pedido;

    public FechamentoConta(Pedido pedido){
        this.pedido=pedido;
    }

    public double getTotalConta(){
        return this.pedido.getTotalConta();
    }

    public double getTotalGorjeta(){
        return getTotalConta() * 0.15;
    }

    public String getDescribe(){
        return "Total de gorjeta: "+getTotalGorjeta();
    }
    
    
}
