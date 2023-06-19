package main;
import banco.*;

public class Main {
    public static void main(String args[]) {
	    BancoMesas bancoMesas = new BancoMesas();
	    bancoMesas = bancoMesas.selectAll();
	    
	    
	    Cardapio cardapio1 = new Cardapio();
	    cardapio1 = cardapio1.selectAll();
	
	    BancoPedidos bancoPedidos = new BancoPedidos();
	    bancoPedidos=bancoPedidos.selectAll();

	    BancoGarcom bancoGarcom = new BancoGarcom();
	    bancoGarcom = bancoGarcom.selectAll();
        
        MainInterface f1 = new MainInterface(cardapio1, bancoGarcom,bancoMesas, bancoPedidos);
        f1.setVisible(true);


    }

}