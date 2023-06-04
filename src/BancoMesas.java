import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BancoMesas extends ConnectionBase{
    private ArrayList <Mesa> mesas;

    public BancoMesas(){
        this.mesas = new ArrayList<Mesa>();
    }

    public boolean addMesa(Mesa mesa){
        if(!mesas.contains(mesa)){
            mesas.add(mesa);
            String sql = "insert into mesa (numero, disponivel) values (?, ?)";

            try {
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setInt(1, mesa.getNumberTable());
                preparedStatement.setString(2, mesa.getAvaliableTable());
                int status = preparedStatement.executeUpdate();
                
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                	if (generatedKeys.next()) {
                    int insertedIndex = generatedKeys.getInt(1);
                    mesa.setId(insertedIndex);
                }
                preparedStatement.close();

                return status!=0;
            } catch (SQLException e) {
                System.out.println(e);
            }



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
