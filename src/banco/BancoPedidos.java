package banco;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import conexaoBanco.ConnectionBase;


import model.*;


public class BancoPedidos extends ConnectionBase{
    private  ArrayList<Pedido> pedidos;
    
    public  BancoPedidos() {
    	this.pedidos= new ArrayList<Pedido>();
    }

    public boolean inserirPedido(Pedido pedido) {
        if (!pedidos.contains(pedido)) {
            this.pedidos.add(pedido);
            String sql = "INSERT INTO pedidos (mesa, garcom, situacao, conta, idG) VALUES (?, ?, ?, ?,?)";

            try {
                PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, pedido.getMesa().getNumberTable());
                preparedStatement.setString(2, pedido.getGarcom().getName());
                preparedStatement.setString(3, pedido.getSituacao());
                preparedStatement.setDouble(4, pedido.getValorConta());
                preparedStatement.setInt(5, pedido.getGarcom().getId());
                
                int status = preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int insertedIndex = generatedKeys.getInt(1);
                    pedido.setId(insertedIndex);
                }
                preparedStatement.close();
                
                sql = "UPDATE mesa SET disponivel = 0 WHERE id = ?";

                preparedStatement = conexao.prepareStatement(sql);
        		preparedStatement.setInt(1, pedido.getMesa().getId()); 
        		
        		status = preparedStatement.executeUpdate();

                return status != 0;
            } catch (SQLException e) {
                System.out.println(e);
            }

            return true;
        }
        return false;
    }

    public void setPedidos(ArrayList<Pedido> pedidos){
        this.pedidos=pedidos;
    }

    public ArrayList<Pedido> getPedidos(){
    	if(this.pedidos == null) this.selectAll();
        return this.pedidos;
    }
    
    public BancoPedidos selectAll() {
        String sql = "SELECT * FROM pedidos";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String garcomNome = resultSet.getString("garcom");
                int idG = resultSet.getInt("idG");
                String situacao = resultSet.getString("situacao");
                int mesaNumero = resultSet.getInt("mesa");
                Double valorConta =  resultSet.getDouble("conta");
                
                Mesa mesa = new Mesa(idG,mesaNumero);
                Garcom garcom = new Garcom(garcomNome, idG);
                Pedido pedido = new Pedido(null, mesa, garcom, situacao);

                
                pedido.setId(id);
             
                pedido.setValorConta(valorConta);

                pedidos.add(pedido);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return this;
    }

    public boolean removerPedido(Pedido pedido) {
       
        String sql = "UPDATE mesa SET disponivel = ? WHERE id = ?"; 
        
        BancoMesas bancoMesas = new BancoMesas();
        Mesa mesa = bancoMesas.buscarMesaBase(pedido.getMesa().getNumberTable());
        
        int idMesa = mesa.getId();
        
        if(idMesa < 0) return false;

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, idMesa);
            
            int status = preparedStatement.executeUpdate();
            
            preparedStatement.close();
            
            if(status == 0) return false;
            
            sql = "DELETE FROM pedidos WHERE id = ?";
            
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, pedido.getId());
            status = preparedStatement.executeUpdate();
            preparedStatement.close();
            
            return status != 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        getPedidos().remove(pedido);
        return true;
            
    }
    
    public void atualizarPedidos() {
    	this.pedidos = new ArrayList<Pedido>();
        String sql = "SELECT * FROM pedidos";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String garcomNome = resultSet.getString("garcom");
                int idG = resultSet.getInt("idG");
                
                BancoMesas bancoMesas = new BancoMesas();
                Mesa mesa =  bancoMesas.buscarMesa(idG);
                
                String situacao = resultSet.getString("situacao");
               
                Double valorConta =  resultSet.getDouble("conta");
                
                Garcom garcom = new Garcom(garcomNome, idG);
                Pedido pedido = new Pedido(null, mesa, garcom, situacao);

                
                pedido.setId(id);
             
                pedido.setValorConta(valorConta);

                pedidos.add(pedido);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        
    }
    
    
    public boolean mudarSituacao(Pedido pedidoIn) {
        String sql = "UPDATE pedidos SET situacao = ? WHERE id = ?";
        try {
        	PreparedStatement preparedStatement = conexao.prepareStatement(sql);
    		preparedStatement.setString(1, pedidoIn.getSituacao()); 
    		preparedStatement.setInt(2, pedidoIn.getId());
    		int status = preparedStatement.executeUpdate();
    		
            preparedStatement.close();

            return status != 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    
    }
    
    public Pedido buscarPedido(int idPedido){
    	this.atualizarPedidos();
    	for (Pedido pedido : getPedidos()) {
            if (pedido.getId() == idPedido) {
            	return pedido;
            }
    	}
    	return null;
    
    }
    
    

    public String toString(){
        String retorno="";
        if(this.getPedidos()!=null) {
            for(Pedido pedido:this.getPedidos()){
                retorno+=pedido.formatCorect();
            }
        }
        

        return retorno;
    }
    
}
