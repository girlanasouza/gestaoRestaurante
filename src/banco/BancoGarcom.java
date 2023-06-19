package banco;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexaoBanco.ConnectionBase;


import model.*;



public class BancoGarcom extends ConnectionBase {
    private ArrayList<Garcom> gargons = new ArrayList<Garcom>();

    public BancoGarcom() {

    }

    public BancoGarcom selectAll() {
        String sql = "SELECT * FROM garcom";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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

    public boolean inserirGarcom(Garcom garcom) {
        if (!gargons.contains(garcom)) {
            this.gargons.add(garcom);

            String sql = "INSERT INTO garcom (nome, endereco) VALUES (?, ?)";

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

                return status != 0;
            } catch (SQLException e) {
                System.out.println(e);
            }

            return true;
        }
        return false;
    }
    
    
    public boolean atualizarGarcom(int idGarcom) {
        String sql = "UPDATE garcom SET nome = ?, endereco = ? WHERE id = ?";
        for (Garcom garcom : getGarcons()) {
        	if (garcom.getId() == idGarcom) {
                try {
                	PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            		preparedStatement.setString(1, garcom.getName()); 
            		preparedStatement.setString(2, garcom.getAddress());
            		preparedStatement.setInt(3, idGarcom);
            		
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
    
    public boolean removeWaiter(int id) {
        for (Garcom g : gargons) {
            if (g.getId() == id) {
                gargons.remove(g);
                String sql = "DELETE FROM garcom WHERE id = ?";

                try {
                    PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                    preparedStatement.setInt(1, g.getId());
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

    public boolean alterarGarcom(int id, String novoNome) {
        for (Garcom garcom : getGarcons()) {
            if (garcom.getId() == id) {
                garcom.setName(novoNome);

                String sql = "UPDATE garcom SET nome = ?, endereco = ? WHERE id = ?";

                try {
                    PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                    preparedStatement.setString(1, garcom.getName());
                    preparedStatement.setString(2, garcom.getAddress());
                    preparedStatement.setInt(3, garcom.getId());
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
    
    
    public void atualizarGarcons() {
    	this.gargons = new ArrayList<Garcom>();
        String sql = "SELECT * FROM garcom";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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
        
    }

    public Garcom buscarGarcom(int id) {
        for (Garcom garcom : getGarcons()) {
            if (garcom.getId() == id) {
                return garcom;
            }
        }
        return null;
    }

    public String getDrescribe() {
        String retorno = "";
        for (Garcom garcom : this.gargons) {
            retorno += garcom.toString();
        }
        return retorno;
    }

    public ArrayList<Garcom> getGarcons() {
        return this.gargons;
    }
}