import java.awt.BorderLayout;
// import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SelecionarMesaInterface extends JFrame {
    private BancoMesas mesas;

    public BancoMesas getBancoMesas(){
        return this.mesas;
    }

    public SelecionarMesaInterface(BancoMesas mesas){
        super("Selecionar Mesa");
        this.mesas=mesas;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
            

        }
    }
}
