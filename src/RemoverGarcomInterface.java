import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoverGarcomInterface extends JFrame {
    private Garcom garcom;
    private BancoGarcom bGarcom;

    public Garcom getGarcom() {
        return this.garcom;
    }

    public BancoGarcom getBancoGarcom() {
        return this.bGarcom;
    }

    public RemoverGarcomInterface(BancoGarcom bancoGarcom) {
        super("Remover Garçom");
        this.bGarcom = bancoGarcom;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);

        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(Color.WHITE);
        panelCentral.add(panelPrincipal, BorderLayout.CENTER);

        JPanel panelRodape = new JPanel();
        panelRodape.setBackground(Color.PINK);
        panelRodape.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel idGarcomJLabel = new JLabel("Id Garcom");
        JTextField idGarcomField = new JTextField();
        idGarcomField.setBackground(Color.YELLOW);
        idGarcomField.setEditable(true);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setBounds(20, 175, 220, 25);
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverGarcomInterface.this.setVisible(false);
            }
        });

        // JButton pesquisarGarcomButton = ;

        panelPrincipal.add(idGarcomJLabel);
        panelPrincipal.add(idGarcomField); // Adiciona o campo de texto ao painel principal

        panelRodape.add(voltarButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelCentral, BorderLayout.CENTER);
        getContentPane().add(panelRodape, BorderLayout.SOUTH);

        setVisible(true);
    }
}
