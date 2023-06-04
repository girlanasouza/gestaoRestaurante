import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CadastrarMesaInterface  extends JFrame{
    private BancoMesas bancoMesas;
    
    public CadastrarMesaInterface(BancoMesas bancoMesas){
        super("Cadastro de Mesa");
        this.bancoMesas=bancoMesas;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);
        setPreferredSize(maxSize);
        setResizable(true);

        JPanel principal = new JPanel();
        principal.setSize(500, 800);
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        JLabel idMesLabel = new JLabel("ID Mesa");
        JTextField idMesaField = new JTextField();
        idMesaField.setBackground(Color.RED);
        idMesaField.setEditable(true);

        JLabel numeroMesLabel = new JLabel("Número da Mesa");
        JTextField numeroMesaField = new JTextField();
        numeroMesaField.setBackground(Color.PINK);
        numeroMesaField.setEditable(true);

        JLabel dispoMesaJLabel = new JLabel("Disponibilidade da mesa");
        JTextField dispoMesaField = new JTextField();
        dispoMesaField.setBackground(Color.YELLOW);
        dispoMesaField.setEditable(true);


        JButton cadastrarItemButton = new JButton("Cadastrar Mesa");
        cadastrarItemButton.setBackground(Color.RED);
        
        cadastrarItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idConverte = idMesaField.getText();
                String numeroMesa = numeroMesaField.getText();
                String dispMesa = dispoMesaField.getText();
        
                if (numeroMesa.isEmpty() || dispMesa.isEmpty() || idConverte.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    int id = Integer.parseInt(idConverte);
                    int numMesa = Integer.parseInt(numeroMesa);
                    Mesa mesa = new Mesa(id, numMesa, dispMesa);
                    CadastrarMesaInterface.this.bancoMesas.addMesa(mesa);
                    numeroMesaField.setText("");
                    dispoMesaField.setText("");
                    JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
                }
            }
        });
        

        JButton voltaMenuButton = new JButton("Voltar Menu", null);
        voltaMenuButton.setBounds(20, 55, 220, 25);

        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarMesaInterface.this.setVisible(false);
                
            }
        });

        principal.add(idMesLabel);
        principal.add(idMesaField);
        principal.add(numeroMesLabel);
        principal.add(numeroMesaField);
        principal.add(dispoMesaJLabel);
        principal.add(dispoMesaField);
        principal.add(cadastrarItemButton);
        principal.add(voltaMenuButton);

        add(principal);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}