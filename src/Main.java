
public class Main {
	
	public static void main(String args[]) {
		Garcon waiter1 = new Garcon ("Girlana", 1, "Barbosa Fillho");
		Garcon waiter2 = new Garcon ("Girlana", 2, "Barbosa Fillho");
		Garcon waiter3 = new  Garcon ("natan", 3, "rua oito");
		Item item1 = new Item("Carbonara", "Carbonara com bacon fresco", 30);
		Item item2 = new Item("Tartare de Salmão", "Tartare de salmão com gema", 50);
		

		Mesa mesa1 = new Mesa(101, false);
		
		Cardapio cardapio1 = new Cardapio();

		Pedido pedido1 = new Pedido(mesa1, waiter2);
		pedido1.addItensMenu(item1);
		pedido1.addItem(item2);

		FechamentoConta fechamentoConta = new FechamentoConta(pedido1, 100.2);

		CardapioInterface cardapioInterface = new CardapioInterface();

		cardapioInterface.setVisible(true);


//		System.out.println(fechamentoConta.getDescribe());
//		FechamentoContaInterface garconInterface = new FechamentoContaInterface();
//	    garconInterface.exibirFechamentoConta(fechamentoConta);

		
	}

}
