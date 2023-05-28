import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CadastrarGarcon extends JFrame{
    public CadastrarGarcon(){
        super("Cadastro de Garcon");
        this.setLayout(null); 
        this.setSize(260, 180);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JLabel title = new JLabel("Cadastro do Cliente");
        title.setBounds(0, 10, 260, 20);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);
    }
    
}
