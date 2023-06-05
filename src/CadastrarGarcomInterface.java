import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CadastrarGarcomInterface  extends JFrame{
    private BancoGarcom bancoGarcom;

    public BancoGarcom getBancoGarcom(){
        return this.bancoGarcom;
    }
    public CadastrarGarcomInterface(BancoGarcom bancoGarcom){
        super("Cadastrar Garçom"); 
        this.bancoGarcom = bancoGarcom;
        

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);
        
        Color cor = new Color (255,192,203);

        JPanel principal = new JPanel();
        principal.setSize(maxSize);
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        
        
        setLocationRelativeTo(null);

        JButton voltaMenuButton = new JButton("Voltar", null);
        voltaMenuButton.setBounds(20, 55, 220, 25);

        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarGarcomInterface.this.setVisible(false);
               
            }
        });

        JLabel nomeGarcomJLabel = new JLabel("Nome Garcom");
        JTextField nomeGarcomField = new JTextField();
        nomeGarcomField.setBackground(cor);
        nomeGarcomField.setHorizontalAlignment(SwingConstants.CENTER);
        nomeGarcomField.setEditable(true);

        JLabel idGarcomJLabel = new JLabel("ID Garcom");
        JTextField idGarcomField = new JTextField();
        idGarcomField.setBackground(cor);
        idGarcomField.setHorizontalAlignment(SwingConstants.CENTER);
        idGarcomField.setEditable(true);

        JLabel enderecoGarcomJLabel = new JLabel("Endereço do Garcom");
        JTextField enderecoGarcomField = new JTextField();
        enderecoGarcomField.setBackground(cor);
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
        

        JButton imprimirBancoGarcomButton = new JButton("Imprimir Banco Garcom");
        imprimirBancoGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, bancoGarcom.getDrescribe());
            }
        });

        
        principal.add(nomeGarcomJLabel);
        principal.add(nomeGarcomField);

        principal.add(idGarcomJLabel);
        principal.add(idGarcomField);

        principal.add(enderecoGarcomJLabel);
        principal.add(enderecoGarcomField);
        // principal.add(corpoPanel);
        // principal.add(rodPanel);

        principal.add(voltaMenuButton);
        principal.add(cadastrarGarcomButton);
        principal.add(imprimirBancoGarcomButton);

        this.add(principal);
        setVisible(true);
    }
}
