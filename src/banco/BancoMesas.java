package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexaoBanco.ConnectionBase;

import model.*;


public class BancoMesas extends ConnectionBase{
    private ArrayList <Mesa> mesas;

    public BancoMesas(){
        this.mesas = new ArrayList<Mesa>();
    }
    
    
    public void atualizarStatusMesa(Mesa mesa) {
    	for(Mesa m:getMesas()) {
    		if(m.equals(mesa)) {
    			m.setStatus(false);
    		}
    	}
    }
    
    public BancoMesas selectAll() {
        String sql = "SELECT * FROM mesa";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Mesa mesa = new Mesa();
                mesa.setId(resultSet.getInt("id"));
                mesa.setAvaliableTable(resultSet.getBoolean("disponivel"));
                mesa.setNumberTable(resultSet.getInt("numero"));
                mesas.add(mesa);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return this;
    }
    
    public BancoMesas updateBancoDeMesasAll() {
        String sql = "SELECT * FROM mesa";
        this.mesas = new ArrayList<Mesa>();
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Mesa mesa = new Mesa();
                mesa.setId(resultSet.getInt("id"));
                mesa.setAvaliableTable(resultSet.getBoolean("disponivel"));
                mesa.setNumberTable(resultSet.getInt("numero"));
                mesas.add(mesa);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return this;
    }

    public boolean addMesa(Mesa mesa){
        if(!mesas.contains(mesa)){
            mesas.add(mesa);
            String sql = "insert into mesa (numero, disponivel) values (?, ?)";

            try {
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setInt(1, mesa.getNumberTable());
                preparedStatement.setBoolean(2, mesa.getAvaliableTable());
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
    
    public boolean removerMesa(int numeroMesa) {
        for (Mesa mesa : getMesas()) {
            if (mesa.getNumberTable() == numeroMesa) {
                getMesas().remove(mesa);
                String sql = "DELETE FROM mesa WHERE numero = ?";

                try {
                    PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                    preparedStatement.setInt(1, mesa.getNumberTable());
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
    
    public boolean mudarNumero(int idMesa) {
        String sql = "UPDATE mesa SET numero = ? WHERE id = ?";
        for (Mesa mesa : getMesas()) {
        	if (mesa.getId() == idMesa) {
                try {
                	PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            		preparedStatement.setInt(1, mesa.getNumberTable()); // Assuming you want to set it as true (disponivel) here
            		preparedStatement.setInt(2, idMesa);
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

    public ArrayList <Mesa> getMesas(){
        return this.mesas;
    }
    public Mesa getMesa(int numMesa) {
    	for(Mesa mesa:getMesas()) {
    		if(mesa.getNumberTable()==numMesa) {
    			return mesa;
    		}
    	}
    	return null;
    }
    
    public String getDescribe(){
        String retorno = "";
        for(Mesa mesa: mesas){
            retorno = retorno + mesa.toString();
        }
        return retorno;
    }
    
    public Mesa buscarMesaBase(int numeroMesa) {
    	 String sql = "SELECT * FROM mesa WHERE numero=?";
         Mesa mesa = new Mesa();
         try {
             PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             preparedStatement.setInt(1, numeroMesa);
             
             ResultSet resultSet = preparedStatement.executeQuery();

             if (resultSet.next()) {

                 mesa.setId(resultSet.getInt("id"));
                 mesa.setAvaliableTable(resultSet.getBoolean("disponivel"));
                 mesa.setNumberTable(resultSet.getInt("numero"));
                 mesas.add(mesa);
             }

             preparedStatement.close();

         } catch (SQLException e) {
             System.out.println(e);
         }
         
         return mesa;

    }
    
    public Mesa buscarMesa(int id) {
        for (Mesa mesa : getMesas()) {
            if (mesa.getId() == id) {
                return mesa;
            }
        }
        return null;
    }
    
    public Mesa buscarMesaNumero(int numero) {
        for (Mesa mesa : getMesas()) {
            if (mesa.getNumberTable() == numero) {
                return mesa;
            }
        }
        return null;
    }
    
}