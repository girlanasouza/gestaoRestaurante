import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
    	
        Item item1 = new Item("Carbonara", "Carbonara com bacon fresco", 30);
        Item item2 = new Item("Tartare de Salmão", "Tartare de salmão com gema", 50);
        Item item3 = new Item("Pizza de Banana", "Pizza de banana da terra com canela", 50);
        
        
        Mesa mesa1 = new Mesa(1,101, "false");
        Mesa mesa2 = new Mesa(2,102, "true");
        Mesa mesa3 = new Mesa(3,103, "true");

        BancoMesas bancoMesas = new BancoMesas();
        bancoMesas.addMesa(mesa1);
        bancoMesas.addMesa(mesa2);
        bancoMesas.addMesa(mesa3);

        Cardapio cardapio1 = new Cardapio();
        
        cardapio1.addItem(item2);
        cardapio1.addItem(item1);
        cardapio1.addItem(item3);

        Garcom garcom = new Garcom("ANA", 0, "jaru");
        ArrayList <Item> itens = new ArrayList<Item>();
        itens.add(item2);
        itens.add(item3);

        Pedido pedido1 = new Pedido(itens, mesa1, garcom,"Feito");
//        pedido1.addItem(item1);
//        pedido1.addItem(item2);

//        FechamentoConta fechamentoConta = new FechamentoConta(pedido1, 100.2);

        // System.out.println(bancoMesas.getDescribe());


        BancoPedidos bancoPedidos = new BancoPedidos();
        bancoPedidos.inserirPedido(pedido1);
        
//        if(bancoPedidos.inserirPedido(pedido1)==true) {
//        	System.out.println("Consegui inserir!");
//        }else {
//        	System.out.println("Não consegui inserir!");
//        }

        // System.out.println(pedido1.getDescribe());
         System.out.println(bancoPedidos.toString());

        BancoGarcom bancoGarcom = new BancoGarcom();
        bancoGarcom = bancoGarcom.selectAll();
//
        MainInterface f1 = new MainInterface(cardapio1, bancoGarcom,bancoMesas, bancoPedidos);
//        System.out.println(bancoPedidos.toString());

        // f1.setCardapio(cardapio1); // Pass the Cardapio object to MainInterface
        f1.setVisible(true);

        // System.out.println(bancoPedidos.toString());

       
    //    System.out.println(cardapio1.describeMenu());
    }

}
