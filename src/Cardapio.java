import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cardapio extends ConnectionBase {
	private ArrayList <Item> cardapio = new ArrayList<Item>();
	
	public boolean addItem(Item item) {
		if(!cardapio.contains(item)) {
			cardapio.add(item);
			String sql = "insert into item (nome, descricao, valor) values (?, ?, ?)";
			
			try {
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setString(1, item.getName());
                preparedStatement.setString(2, item.getDescribe());
				preparedStatement.setDouble(3, item.getValue());
                int status = preparedStatement.executeUpdate();
                
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                	if (generatedKeys.next()) {
                    int insertedIndex = generatedKeys.getInt(1);
                    item.setId(insertedIndex);
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



	public ArrayList<Item> getCardapio() {
		return cardapio;
	}
	
	public boolean removeItem(Item item) {
		if(!cardapio.contains(item)) {
			return false;
		}
		else {
			cardapio.remove(item);
		}

		return true;
	}
	
    public String describeMenu(){
        String retorno = "";

        for (Item item:cardapio){
            retorno = retorno + item.toString() + "\n";

        }

        return retorno;
    }

	
	


}
