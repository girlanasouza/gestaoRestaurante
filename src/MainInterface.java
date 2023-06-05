import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainInterface extends javax.swing.JFrame {

    private Cardapio cardapio;
    private BancoGarcom bancoGarcom;
    private BancoMesas bancoMesas;
    private BancoPedidos bancoPedidos;

    public BancoPedidos getBancoPedidos(){
        return this.bancoPedidos;
    }

    public void setBancoPedidos(BancoPedidos bancoPedidos){
        this.bancoPedidos=bancoPedidos;
    }

    public BancoGarcom getBancoGarcom(){
        return this.bancoGarcom;
    }

    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }
    public MainInterface(Cardapio cardapio,BancoGarcom bancoGarcom, BancoMesas bancoMesas, BancoPedidos bancoPedidos) {
        super("TELA INICIAL");

        this.bancoGarcom=bancoGarcom;
        this.cardapio=cardapio;
        this.bancoMesas=bancoMesas;
        this.bancoPedidos=bancoPedidos;
        setLayout(null);
        // setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);
        
        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);


        JLabel title = new JLabel("Tela Principal");
        title.setBounds(0, 10, 500, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);

        JButton menuButton = new JButton("Realizar Pedido");
        menuButton.setBounds(20, 55, 220, 25);
        this.add(menuButton);

        JButton cadastrarCardapioButton = new JButton("Gerenciar Cardapio");
        cadastrarCardapioButton.setBounds(20, 90, 220, 25);
        this.add(cadastrarCardapioButton);

        JButton gerirGarcomButton= new JButton("Gerenciar Garçons");
        gerirGarcomButton.setBounds(20, 125, 220, 25);
        this.add(gerirGarcomButton);
        
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cardapio != null) {
                    CardapioInterface menuInterface = new CardapioInterface(MainInterface.this.getCardapio(),MainInterface.this.getBancoMesas(), 
                    MainInterface.this.getBancoGarcom(), MainInterface.this.getBancoPedidos());
                    menuInterface.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Cardápio não definido.");
                }
            }
        });

        cadastrarCardapioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                GerirCardapioInterface gerirCardapioInterface = new GerirCardapioInterface(cardapio);
                gerirCardapioInterface.setVisible(true);
                // CadastrarItemCardapioInterface cadastrarCardapioInterface = new CadastrarItemCardapioInterface(cardapio);
                // cadastrarCardapioInterface.setVisible(true);
            }
        });

        gerirGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                GerirGarcomInterface gerirGarcomInterface = new GerirGarcomInterface(bancoGarcom);
                gerirGarcomInterface.setVisible(true);
            }
        });


        JButton acompanharPedidos = new JButton("Acompanhar Pedidos");
        acompanharPedidos.setBounds(20, 155, 220, 25);
        this.add(acompanharPedidos);

        acompanharPedidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                AcompanhamentoPedidoInterface acompanhamentoPedidoInterface = new AcompanhamentoPedidoInterface(getBancoPedidos());
                acompanhamentoPedidoInterface.setVisible(true);
            }
        });

        JButton mesaButton = new JButton("Gerenciar Mesas");
        mesaButton.setBounds(20, 185, 220, 25);
        this.add(mesaButton);

        mesaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                GerirMesaInterface gerirMesaInterface = new GerirMesaInterface(getBancoMesas());
                if(getBancoMesas()!=null){
                    System.out.println("Banco de mesas não está  vazio!");
                }
                gerirMesaInterface.setVisible(true);
            }
        });



        setVisible(true);
        setLocationRelativeTo(null);
        // setVisible(true);
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void setBancoGarcom(BancoGarcom bancoGarcom){
        this.bancoGarcom=bancoGarcom;
    }
}
