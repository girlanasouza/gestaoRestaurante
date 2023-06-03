import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BancoGarcom extends ConnectionBase{
    private ArrayList<Garcom> gargons = new ArrayList<Garcom>();
    
    public BancoGarcom() {
    	
    }
    
    public BancoGarcom selectAll() {
    	String sql = "select * from garcom";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
            	Garcom garcom = new Garcom();
            	garcom.setId(resultSet.getInt("id"));
            	garcom.setName(resultSet.getString("nome"));
            	garcom.setAddress(resultSet.getString("endereco"));
            	gargons.add(garcom);
            }
           
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
		return this;
    	
    }

    public boolean inserirGarcom(Garcom garcom){
        if(!gargons.contains(garcom)){
            this.gargons.add(garcom);

            String sql = "insert into garcom (nome, endereco) values (?, ?)";

            try {
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setString(1, garcom.getName());
                preparedStatement.setString(2, garcom.getAddress());
                int status = preparedStatement.executeUpdate();
                
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                	if (generatedKeys.next()) {
                    int insertedIndex = generatedKeys.getInt(1);
                    garcom.setId(insertedIndex);
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


    public boolean removeWaiter(int id) {
	    for (Garcom g : gargons) {
	        if (g.getId()==id) {
	            gargons.remove(g);  
                String sql = "DELETE FROM garcom WHERE id like ?";

	            try {
	                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
	                preparedStatement.setInt(1, g.getId());
	                int status = preparedStatement.executeUpdate();

	                preparedStatement.close();

	                return status!=0;
	            } catch (SQLException e) {
	                System.out.println(e);
	            }
	            
	            return true;
	        }
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
