import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CadastrarGarcomInterface  extends JFrame{
    private BancoGarcom bancoGarcom;

    public BancoGarcom getBancoGarcom(){
        return this.bancoGarcom;
    }
    public CadastrarGarcomInterface(BancoGarcom bancoGarcom){
        super("Cadastro de Garçom"); 
        this.bancoGarcom = bancoGarcom;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);
        
        
        Color corTopo = new Color(173,216,230);
        Color corCorpo = new Color (245,255,250);
        
        JPanel topoPanel = new JPanel();
        topoPanel.setBackground(corTopo);

        JLabel topoLabel = new JLabel("Tela de Cadastro de Garçom");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setBackground(corCorpo);
        corpoPanel.setLayout(new BoxLayout(corpoPanel, BoxLayout.Y_AXIS));
        
        JPanel rodapePanel = new JPanel();
        rodapePanel.setBackground(corCorpo);
        rodapePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        

        JLabel nomeGarcomJLabel = new JLabel("Nome Garcom");
        JTextField nomeGarcomField = new JTextField();
        nomeGarcomField.setBackground(corCorpo);
        nomeGarcomField.setHorizontalAlignment(SwingConstants.CENTER);
        nomeGarcomField.setEditable(true);

        JLabel idGarcomJLabel = new JLabel("ID Garcom");
        JTextField idGarcomField = new JTextField();
        idGarcomField.setBackground(corCorpo);
        idGarcomField.setHorizontalAlignment(SwingConstants.CENTER);
        idGarcomField.setEditable(true);

        JLabel enderecoGarcomJLabel = new JLabel("Endereço do Garcom");
        JTextField enderecoGarcomField = new JTextField();
        enderecoGarcomField.setBackground(corCorpo);
        enderecoGarcomField.setHorizontalAlignment(SwingConstants.CENTER);
        enderecoGarcomField.setEditable(true);

        JButton cadastrarGarcomButton = new JButton("Cadastrar Garcom");
        cadastrarGarcomButton.setBounds(20, 55, 220, 25);

        cadastrarGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nomeGarcomField.getText().isEmpty() || idGarcomField.getText().isEmpty() || enderecoGarcomField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    int id = Integer.parseInt(idGarcomField.getText());
                    Garcom garcom = new Garcom(nomeGarcomField.getText(), id, enderecoGarcomField.getText());
                    bancoGarcom.inserirGarcom(garcom);
                    nomeGarcomField.setText("");
                    idGarcomField.setText("");
                    enderecoGarcomField.setText("");
                    JOptionPane.showMessageDialog(null, "Garcom Cadastrado com Sucesso!");
                }
            }
        });
        
        JButton voltaMenuButton = new JButton("Voltar", null);
        voltaMenuButton.setBounds(20, 55, 220, 25);

        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarGarcomInterface.this.setVisible(false);
               
            }
        });

        JButton imprimirBancoGarcomButton = new JButton("Imprimir Banco Garcom");
        imprimirBancoGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, bancoGarcom.getDrescribe());
            }
        });

        topoPanel.add(topoLabel);
        corpoPanel.add(nomeGarcomJLabel);
        corpoPanel.add(nomeGarcomField);

        corpoPanel.add(idGarcomJLabel);
        corpoPanel.add(idGarcomField);

        corpoPanel.add(enderecoGarcomJLabel);
        corpoPanel.add(enderecoGarcomField);
        // principal.add(corpoPanel);
        // principal.add(rodPanel);

        rodapePanel.add(voltaMenuButton);
        rodapePanel.add(cadastrarGarcomButton);
        rodapePanel.add(imprimirBancoGarcomButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);
    }
}
