import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RealizarPedidoInterface extends JFrame {
    private BancoMesas mesas;

    public RealizarPedidoInterface(BancoMesas mesas){
        super("Realizar Pedido");
        this.mesas=mesas;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Color cor = new Color(247, 246, 245);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize); //setando o tamanho 

        setResizable(true); 
        
        JPanel principalPanel = new JPanel();

        principalPanel.setSize(500, 500);

        principalPanel.setLayout((new BoxLayout(principalPanel, BoxLayout.Y_AXIS)));

        JLabel titleJLabel = new JLabel("Realizar Pedido");

        titleJLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        principalPanel.add(titleJLabel, BorderLayout.CENTER);

        if(mesas!=null){
            ArrayList<Mesa>

        }
    }
}
