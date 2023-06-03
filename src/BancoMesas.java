import java.util.ArrayList;

public class BancoMesas {
    private ArrayList <Mesa> mesas;

    public BancoMesas(){
        this.mesas = new ArrayList<Mesa>();
    }

    public boolean addMesa(Mesa mesa){
        if(!mesas.contains(mesa)){
            mesas.add(mesa);
            return true;
        }
        return false;
    }

    public ArrayList <Mesa> getMesa(){
        return this.mesas;
    }

    //mostrar todas as mesas
    public String getDescribe(){
        String retorno = "";
        for(Mesa mesa: mesas){
            retorno = retorno + mesa.toString();
        }
        return retorno;
    }
    
}
