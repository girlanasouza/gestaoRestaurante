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
        super("Gerenciamento de Mesas");
        this.bancoMesas=bancoMesas;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);

        setLocationRelativeTo(null);

        JPanel topoPanel = new JPanel();
        topoPanel.setBackground(Color.BLUE);

        JLabel topoLabel = new JLabel("Tela de Gerenciamento de Mesas");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));


        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


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

        topoPanel.add(topoLabel);
        corpoPanel.add(cadastrarButton);
        corpoPanel.add(removerButton);
        corpoPanel.add(alterarButton);
        panelRodape.add(voltaMenuButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);
        getContentPane().add(panelRodape, BorderLayout.SOUTH);

        setVisible(true);
    }
}