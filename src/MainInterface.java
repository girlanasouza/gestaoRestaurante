import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainInterface extends javax.swing.JFrame {

    private Cardapio cardapio;
    private BancoGarcom bancoGarcom;
    private BancoMesas bancoMesas;

    public BancoGarcom getBancoGarcom(){
        return this.bancoGarcom;
    }

    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }
    public MainInterface(Cardapio cardapio,BancoGarcom bancoGarcom, BancoMesas bancoMesas) {
        super("TELA PRINCIPAL");

        this.bancoGarcom=bancoGarcom;
        this.cardapio=cardapio;
        this.bancoMesas=bancoMesas;
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
        add(title);

        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(20, 55, 220, 25);
        add(menuButton);

        JButton cadastrarCardapioButton = new JButton("Cadastrar Cardapio");
        cadastrarCardapioButton.setBounds(20, 90, 220, 25);
        add(cadastrarCardapioButton);

        JButton gerirGarcomButton= new JButton("Gerenciar Garçons");
        gerirGarcomButton.setBounds(20, 125, 220, 25);
        add(gerirGarcomButton);
        


        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cardapio != null) {
                    CardapioInterface menuInterface = new CardapioInterface(MainInterface.this.getCardapio(),MainInterface.this.getBancoMesas(), 
                    MainInterface.this.getBancoGarcom());
                    menuInterface.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Cardápio não definido.");
                }
            }
        });

        cadastrarCardapioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                CadastrarItemCardapioInterface cadastrarCardapioInterface = new CadastrarItemCardapioInterface(cardapio);
                cadastrarCardapioInterface.setVisible(true);
            }
        });

        gerirGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                GerirGarcomInterface gerirGarcomInterface = new GerirGarcomInterface(bancoGarcom);
                gerirGarcomInterface.setVisible(true);
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
