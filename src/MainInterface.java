import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainInterface extends javax.swing.JFrame {

    private Cardapio cardapio;

    public MainInterface() {
        super("TELA PRINCIPAL");
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

        JButton bMenu = new JButton("Menu");
        bMenu.setBounds(20, 55, 220, 25);
        add(bMenu);

        JButton bCadastrarCardapio = new JButton("Cadastrar Cardapio");
        bCadastrarCardapio.setBounds(20, 90, 220, 25);
        add(bCadastrarCardapio);
        


        bMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cardapio != null) {
                    CardapioInterface menuInterface = new CardapioInterface(cardapio);
                    menuInterface.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Cardápio não definido.");
                }
            }
        });

        bCadastrarCardapio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                CadastrarItemCardapioInterface cadastrarCardapioInterface = new CadastrarItemCardapioInterface(cardapio);
                cadastrarCardapioInterface.setVisible(true);
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
        // setVisible(true);
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }
}
