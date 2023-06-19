package model;
import java.util.ArrayList;
import conexaoBanco.ConnectionBase;

public class Pedido extends ConnectionBase {
    private ArrayList<Item> itens;
    private Mesa mesa;
    private Garcom garcom;
    private String situacao;
    private int id;
    private Double valorConta=0.0;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.mesa = null;
        this.garcom = null;
        this.situacao = "";
    }

    public Pedido(ArrayList<Item> itens, Mesa mesa, Garcom garcom, String situacao) {
        this.itens = itens;
        this.mesa = mesa;
        this.garcom = garcom;
        this.situacao = situacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public Garcom getGarcom() {
        return this.garcom;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return this.mesa;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public boolean addItemPedido(Item item) {
        if (!itens.contains(item)) {
            itens.add(item);
            return true;
        }
        return false;
    }

    public void removeItemPedido(Item item) {
        itens.remove(item);
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }

    public boolean addItem(Item item) {
        if (!itens.contains(item)) {
            itens.add(item);
            return true;
        }
        return false;
    }
    public String getDescribe() {
        StringBuilder retorno = new StringBuilder();
        retorno.append(this.getId()).append(" ");

        if (itens != null) {
            for (Item item : itens) {
                retorno.append(item.toString()).append(" ");
            }
        }

        if (garcom != null) {
            retorno.append(garcom.toString());
        }

        if (mesa != null) {
            retorno.append(mesa.toString());
        }

        retorno.append("Total da conta: R$").append(getValorConta()).append(" ");

        return retorno.toString();
    }

    public String toString() {
        String retorno = "";

        if (itens != null) {
            for (Item item : itens) {
                retorno += item.toString() + " ";
            }
        }

        if (garcom != null) {
            retorno += garcom.getName();
        }

        if (mesa != null) {
            retorno += mesa.getNumberTable();
        }

        retorno += "Valor conta: " + getValorConta() + " ";

        return retorno;
    }
    

    
    public String formatCorect() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Garçom: ").append(this.getGarcom().getName()).append(", ")
               .append("Mesa: ").append(this.getMesa().getNumberTable()).append(", ")
               .append("Valor da Conta: ").append(this.getValorConta());

        return retorno.toString();
    }

    
    public double getTotalConta() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValue();
        }
        setValorConta(total);
        return total;
    }
    
    
    public String fechaPedido() {
    	String retorno = "";
    	retorno = "Garçom:"+this.getGarcom().getName()+"\n" 
    	+"Mesa: "+this.getMesa().getNumberTable()+"\n"
    	+"Valor da Conta: "+this.getValorConta();
    	;

    	return retorno;
    }

	public Double getValorConta() {
		return valorConta;
	}

	public void setValorConta(Double valorConta) {
		this.valorConta = valorConta;
	}
}
