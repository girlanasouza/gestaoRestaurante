package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexaoBanco.ConnectionBase;

import model.*;

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
                
                
                preparedStatement.close();

                return status!=0;
            } catch (SQLException e) {
                System.out.println(e);
            }
			
			
			return true;
		}
		return false;
	}

	public Cardapio selectAll() {
        String sql = "SELECT * FROM item";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("nome"));
                item.setDescribe(resultSet.getString("descricao"));
                item.setValue(resultSet.getDouble("valor"));
                cardapio.add(item);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return this;
    }
	
	public ArrayList<Item> getCardapio() {
		return this.cardapio;
	}
	
	public boolean removeItem(int id) {
		for (Item i : cardapio) {
	        if (i.getId()==id) {
	            cardapio.remove(i);  
                String sql = "DELETE FROM item WHERE id like ?";

	            try {
	                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
	                preparedStatement.setInt(1, i.getId());
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
	
	
    public boolean atualizarPedido(int idPedido) {
        String sql = "UPDATE item SET nome = ?, descricao = ?, valor = ? WHERE id = ?";
        for (Item item : getCardapio()) {
        	if (item.getId() == idPedido) {
                try {
                	PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            		preparedStatement.setString(1, item.getName()); 
            		preparedStatement.setString(2, item.getDescribe());
            		preparedStatement.setDouble(3, item.getValue());

            		preparedStatement.setInt(4, idPedido);
            		
            		int status = preparedStatement.executeUpdate();

                    preparedStatement.close();

                    return status != 0;
                } catch (SQLException e) {
                    System.out.println(e);
                }
                return true;
            }
        
        }
        return false;
    }


	public Item buscarItem(int id){
		for (Item i : cardapio) {
	        if (i.getId()==id) {
				return i;
			}
		}
		return null;
	}
	
    public String toString(){
        String retorno = "";

        for (Item item:cardapio){
            retorno = retorno + item.toString() + "\n";

        }

        return retorno;
    }

	
	


}
