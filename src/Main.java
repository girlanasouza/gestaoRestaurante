public class Main {

    public static void main(String args[]) {
        Garcom waiter1 = new Garcom("Girlana", 1, "Barbosa Fillho");
        Garcom waiter2 = new Garcom("Girlana", 2, "Barbosa Fillho");
        Garcom waiter3 = new Garcom("natan", 3, "rua oito");
        Item item1 = new Item("Carbonara", "Carbonara com bacon fresco", 30);
        Item item2 = new Item("Tartare de Salmão", "Tartare de salmão com gema", 50);
        Item item3 = new Item("Pizza de Banana", "Pizza de banana da terra com canela", 50);
        
        Mesa mesa1 = new Mesa(101, false);
        Mesa mesa2 = new Mesa(102, true);
        Mesa mesa3 = new Mesa(103, true);

        BancoMesas bancoMesas = new BancoMesas();
        bancoMesas.addMesa(mesa1);
        bancoMesas.addMesa(mesa2);
        bancoMesas.addMesa(mesa3);

        Cardapio cardapio1 = new Cardapio();
        
        cardapio1.addItem(item2);
        cardapio1.addItem(item1);
        cardapio1.addItem(item3);

        Pedido pedido1 = new Pedido(mesa1, waiter2);
        pedido1.addItem(item1);
        pedido1.addItem(item2);

        FechamentoConta fechamentoConta = new FechamentoConta(pedido1, 100.2);

        System.out.println(bancoMesas.getDescribe());



        BancoGarcom bancoGarcom = new BancoGarcom();
        bancoGarcom.inserirGarcom(waiter3);
        bancoGarcom.inserirGarcom(waiter1);
        MainInterface f1 = new MainInterface(cardapio1, bancoGarcom,bancoMesas);
        // f1.setCardapio(cardapio1); // Pass the Cardapio object to MainInterface
        f1.setVisible(true);

        System.out.println(bancoGarcom.getDrescribe());

       
    //    System.out.println(cardapio1.describeMenu());
    }

}
