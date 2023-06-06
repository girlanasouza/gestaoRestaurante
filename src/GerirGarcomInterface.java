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


        Color corTopo = new Color(173,216,230);
        Color corCorpo = new Color (245,255,250);
		

        JPanel topoPanel = new JPanel();
        topoPanel.setBackground(corTopo);

        JLabel topoLabel = new JLabel("Tela de Gerenciamento de Garçons");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        

        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        
        JPanel rodapePanel = new JPanel();
        rodapePanel.setBackground(corCorpo);
        rodapePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));


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

        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverGarcomInterface removerGarcomInterface = new RemoverGarcomInterface(bGarcom);
                removerGarcomInterface.setVisible(true);
            }
        });


        JButton alterarButton = new JButton("Alterar Garçom");
        alterarButton.setBounds(20, 85, 220, 25);

        alterarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AlterarGarcomInterface alterarGarcomInterface = new AlterarGarcomInterface();
                alterarGarcomInterface.setVisible(true);
            }
        });

     
        JButton relatorioButton = new JButton("Relatórios de Garçom");
        relatorioButton.setBounds(20, 145, 220, 25);

        JButton voltaMenuButton = new JButton("Voltar Menu");
        voltaMenuButton.setBounds(20, 175, 220, 25);
        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                GerirGarcomInterface.this.setVisible(false);
            }
        });

        topoPanel.add(topoLabel);

        corpoPanel.add(cadastrarButton);
        corpoPanel.add(removerButton);
        corpoPanel.add(alterarButton);
        corpoPanel.add(relatorioButton);
        rodapePanel.add(voltaMenuButton);

		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
