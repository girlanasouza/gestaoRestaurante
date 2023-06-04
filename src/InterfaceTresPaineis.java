import java.awt.*;
import javax.swing.*;

public class InterfaceTresPaineis extends JFrame {

    public InterfaceTresPaineis() {
        super("Interface com Três Painéis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Painel 1
        JPanel painel1 = new JPanel();
        painel1.setBackground(Color.RED);
        painel1.setPreferredSize(new Dimension(200, 200));
        
        // Painel 2
        JPanel painel2 = new JPanel();
        painel2.setBackground(Color.GREEN);
        painel2.setPreferredSize(new Dimension(200, 200));
        
        // Painel 3
        JPanel painel3 = new JPanel();
        painel3.setBackground(Color.BLUE);
        painel3.setPreferredSize(new Dimension(200, 200));
        
        // Layout para os painéis
        JPanel paineisContainer = new JPanel();
        paineisContainer.setLayout(new BoxLayout(paineisContainer, BoxLayout.X_AXIS));
        paineisContainer.add(painel1);
        paineisContainer.add(painel2);
        paineisContainer.add(painel3);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(paineisContainer, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfaceTresPaineis();
            }
        });
    }
}
