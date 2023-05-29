import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainInterface extends javax.swing.JFrame {

    private Cardapio cardapio;

    public MainInterface() {
        super("TELA PRINCIPAL");
        setLayout(null);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Tela Principal");
        title.setBounds(0, 10, 500, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        JButton bMenu = new JButton("Menu");
        bMenu.setBounds(20, 55, 220, 25);
        add(bMenu);

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

        setVisible(true);
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }
}
