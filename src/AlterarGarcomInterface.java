import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlterarGarcomInterface extends JFrame {
    private BancoGarcom bGarcom;
    private Garcom garcom;


    public BancoGarcom getBancoGarcom() {
        return this.bGarcom;
    }

    public Garcom getGarcom(){
        return this.garcom;
    }

    public void setGarcom(Garcom garcom){
        this.garcom=garcom;
    }

    public AlterarGarcomInterface() {
        super("Altera Garçom");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);
        setSize(maxSize);
        setPreferredSize(maxSize);
        setResizable(true);
        setLocationRelativeTo(null);

        JPanel topoPanel = new JPanel();
        topoPanel.setBackground(Color.BLUE);

        JLabel topoLabel = new JLabel("Tela de Alteração de Garçom");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel idLabel = new JLabel("ID do Garçom:");
        JTextField idField = new JTextField(10);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                int idC = Integer.parseInt(id);
                AlterarGarcomInterface.this.setGarcom( AlterarGarcomInterface.this.getBancoGarcom().buscarGarcom(idC));;
            }
        });

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField(20);

        JLabel enderecoLabel = new JLabel("Endereço:");
        JTextField enderecoField = new JTextField(20);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar a lógica para salvar as alterações no garçom.
            }
        });

        corpoPanel.add(idLabel);
        corpoPanel.add(idField);
        corpoPanel.add(buscarButton);
        corpoPanel.add(nomeLabel);
        corpoPanel.add(nomeField);
        corpoPanel.add(enderecoLabel);
        corpoPanel.add(enderecoField);
        corpoPanel.add(salvarButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
}
