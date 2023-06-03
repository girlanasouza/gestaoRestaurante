import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GerirGarcomInterface extends JFrame {
    private BancoGarcom bGarcom;
    private Garcom garcom;


    public BancoGarcom getBancoGarcom() {
        return this.bGarcom;
    }

    public Garcom getGarcom(){
        return this.garcom;
    }

    public GerirGarcomInterface(BancoGarcom bancoGarcom) {
        super("Gerir Garçom");
        this.bGarcom=bancoGarcom;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);

        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(Color.WHITE);
        panelCentral.add(panelPrincipal, BorderLayout.CENTER);

        JPanel panelRodape = new JPanel();
        panelRodape.setBackground(Color.PINK);
        panelRodape.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton cadastrarButton = new JButton("Cadastrar Garçom");
        cadastrarButton.setBounds(20, 55, 220, 25);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarGarcomInterface cadastrarGarcomInterface = new CadastrarGarcomInterface(bGarcom);
                cadastrarGarcomInterface.setVisible(true);
            }
        });

        JButton removerButton = new JButton("Remover Garçom");
        removerButton.setBounds(20, 115, 220, 25);
        removerButton.setBackground(Color.MAGENTA);

        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverGarcomInterface removerGarcomInterface = new RemoverGarcomInterface(bGarcom);
                removerGarcomInterface.setVisible(true);
            }
        });


        JButton alterarButton = new JButton("Alterar Garçom");
        alterarButton.setBounds(20, 85, 220, 25);

        JButton relatorioButton = new JButton("Relatórios de Garçom");
        relatorioButton.setBounds(20, 145, 220, 25);

        JButton voltaMenuButton = new JButton("Voltar Menu");
        voltaMenuButton.setBounds(20, 175, 220, 25);
        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GerirGarcomInterface.this.setVisible(false);
            }
        });

        panelPrincipal.add(cadastrarButton);
        panelPrincipal.add(removerButton);
        panelPrincipal.add(alterarButton);
        panelPrincipal.add(relatorioButton);
        panelRodape.add(voltaMenuButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelCentral, BorderLayout.CENTER);
        getContentPane().add(panelRodape, BorderLayout.SOUTH);

        setVisible(true);
    }
}
