import java.util.ArrayList;

public class BancoGarcom {
    private ArrayList<Garcom> gargons = new ArrayList<Garcom>();


    public boolean inserirGarcom(Garcom garcom){
        if(!gargons.contains(garcom)){
            this.gargons.add(garcom);
            return true;
        }
        return false;
    }

    public String getDrescribe(){
        String retorno = "";
        for(Garcom garcom:this.gargons){
            retorno += garcom.toString();
        }
        return retorno;

    }

    public ArrayList<Garcom> getGacons(){
        return this.gargons;
    }
}
