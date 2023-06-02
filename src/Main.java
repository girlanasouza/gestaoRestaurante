public class Main {

    public static void main(String args[]) {
        Garcon waiter1 = new Garcon("Girlana", 1, "Barbosa Fillho");
        Garcon waiter2 = new Garcon("Girlana", 2, "Barbosa Fillho");
        Garcon waiter3 = new Garcon("natan", 3, "rua oito");
        Item item1 = new Item("Carbonara", "Carbonara com bacon fresco", 30);
        Item item2 = new Item("Tartare de Salmão", "Tartare de salmão com gema", 50);

        Item item3 = new Item("", "", 0);

        if (item3.isBlank()) {
            System.out.println("O item está vazio");
        } else {
            System.out.println("O item não está vazio");
        }
        
        Mesa mesa1 = new Mesa(101, false);
        Mesa mesa2 = new Mesa(102, true);

        BancoMesas bancoMesas = new BancoMesas();
        bancoMesas.addMesa(mesa1);
        bancoMesas.addMesa(mesa2);

        Cardapio cardapio1 = new Cardapio();
        
        cardapio1.addItem(item2);
        cardapio1.addItem(item1);

        Pedido pedido1 = new Pedido(mesa1, waiter2);
        pedido1.addItensMenu(item1);
        pedido1.addItem(item2);

        FechamentoConta fechamentoConta = new FechamentoConta(pedido1, 100.2);

        System.out.println(bancoMesas.getDescribe());

        MainInterface f1 = new MainInterface();
        f1.setCardapio(cardapio1); // Pass the Cardapio object to MainInterface
        f1.setVisible(true);
       
       System.out.println(cardapio1.describeMenu());
    }

}
