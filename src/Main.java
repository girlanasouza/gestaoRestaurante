
public class Main {
	
	public static void main(String args[]) {
		Garcon waiter1 = new Garcon ("Girlana", 1, "Barbosa Fillho");
		Garcon waiter2 = new Garcon ("Girlana", 2, "Barbosa Fillho");
		Item item1 = new Item("Carbonara", "Carbonara com bacon fresco", 30);
		Item item2 = new Item("Tartare de Salmão", "Tartare de salmão com gema", 50);
		

		Mesa mesa1 = new Mesa(101, false);

		System.out.println(mesa1.toString());
		
		Cardapio cardapio1 = new Cardapio();

		Pedido pedido1 = new Pedido(mesa1, waiter2);
		pedido1.addItensMenu(item1);
		pedido1.addItem(item2);

		System.out.println(pedido1.getDescribe());

		
		// cardapio1.addItem(item1);
		// cardapio1.addItem(item2);

		// System.out.println(cardapio1.describeMenu());

		// cardapio1.describeMenu();

		// FunctionGarcon function = new FunctionGarcon();

		// System.out.println(waiter1.toString());
		
		// if (function.registerWaiter(waiter1)==true){
		// 	System.out.println("consegui!");
		// }
		// else {
		// 	System.out.println("não consegui!");
		// }
		
		// if (function.removeWaiter(waiter2.getId())==true){
		// 	System.out.println("consegui!");
		// }
		// else {
		// 	System.out.println("não consegui!");
		// }
	}

}
