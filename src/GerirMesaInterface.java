import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GerirMesaInterface extends JFrame{

    private BancoMesas bancoMesas;

    public void setBancoMesas(BancoMesas bancoMesas){
        this.bancoMesas=bancoMesas;
    }
    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }

    public GerirMesaInterface(BancoMesas bancoMesas) {
        super("Gerenciar Mesa");
        this.bancoMesas=bancoMesas;
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

        JButton cadastrarButton = new JButton("Cadastrar Mesa");
        cadastrarButton.setBounds(20, 55, 220, 25);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarMesaInterface cadastrarMesaInterface = new CadastrarMesaInterface(getBancoMesas());
                
                cadastrarMesaInterface.setVisible(true);
            }
        });

        JButton removerButton = new JButton("Remover Mesa");
        removerButton.setBounds(20, 115, 220, 25);

        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // RemoverGarcomInterface removerGarcomInterface = new RemoverGarcomInterface(bGarcom);
                // removerGarcomInterface.setVisible(true);
            }
        });


        JButton alterarButton = new JButton("Alterar Mesa");
        alterarButton.setBounds(20, 85, 220, 25);


        JButton voltaMenuButton = new JButton("Voltar Menu");
        voltaMenuButton.setBounds(20, 175, 220, 25);
        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GerirMesaInterface.this.setVisible(false);
            }
        });

        panelPrincipal.add(cadastrarButton);
        panelPrincipal.add(removerButton);
        panelPrincipal.add(alterarButton);
        panelRodape.add(voltaMenuButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelCentral, BorderLayout.CENTER);
        getContentPane().add(panelRodape, BorderLayout.SOUTH);

        setVisible(true);
    }
}