import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CardapioInterface extends JFrame {
    private Cardapio cardapio;

    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public CardapioInterface(Cardapio cardapio) {
        super("Cardápio");
        this.cardapio = cardapio;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);
        
        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);


        JPanel principal = new JPanel();
        principal.setSize(500, 500);
        principal.setLayout((new BoxLayout(principal, BoxLayout.Y_AXIS)));

        JLabel title = new JLabel("Cardápio");
        title.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        JPanel painelCardapio = new JPanel();
        painelCardapio.setBackground(Color.YELLOW);
        painelCardapio.add(title, BorderLayout.CENTER);
        painelCardapio.add(title);

        JPanel panelEsquerda = new JPanel();
        panelEsquerda.setBackground(Color.PINK);
        panelEsquerda.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel labelEsquerda = new JLabel("Área Esquerda");
        labelEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
        panelEsquerda.add(labelEsquerda, BorderLayout.CENTER);
        

        JPanel panelDireita = new JPanel();
        panelDireita.setBackground(Color.BLUE);
        panelDireita.setLayout(new BorderLayout());

        JLabel labelDireita = new JLabel("Área Direita");
        labelDireita.setHorizontalAlignment(SwingConstants.CENTER);
        panelDireita.add(labelDireita, BorderLayout.CENTER);
        

        JPanel panelMeio = new JPanel();
        panelMeio.setBackground(Color.GREEN);
        panelMeio.setLayout(new BoxLayout(panelMeio, BoxLayout.Y_AXIS));


        if (cardapio != null) {
            ArrayList<Item> opcoesCardapio = cardapio.getCardapio();
            for (Item item : opcoesCardapio) {
                JCheckBox checkBox = new JCheckBox(item.getDescribe());
                checkBox.isBackgroundSet();
                checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
                checkBox.setBorder(BorderFactory.createEmptyBorder(50  ,50,50,50));
                panelMeio.add(checkBox);
            }
        }

        JButton voltaMenuButton = new JButton("Voltar Menu", null);
        voltaMenuButton.setBounds(20, 55, 220, 25);

        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardapioInterface.this.setVisible(false);
               
            }
        });

        JButton realizarPedidButton = new JButton("Realizar Pedido", null);
        realizarPedidButton.setBounds(20, 55, 220, 25);
        
        principal.add(painelCardapio);
        principal.add(panelMeio);
        principal.add(panelDireita);
        principal.add(panelEsquerda);

        
        panelEsquerda.add(voltaMenuButton);
        panelEsquerda.add(realizarPedidButton);
        add(principal);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
