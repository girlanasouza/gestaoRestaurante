import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoverGarcomInterface extends JFrame {
    private Garcom garcom;
    private BancoGarcom bGarcom;
    private int idGarcom=0;

    public void setIdGarcom(int id){
        this.idGarcom=id;
    }
    public int getIdGarcom(){
        return this.idGarcom;
    }
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

        Color corTopo = new Color(173, 216, 230);
        Color corCorpo = new Color(245, 255, 250);

        JPanel topoPanel = new JPanel();
        topoPanel.setBackground(corTopo);

        JLabel topoLabel = new JLabel("Tela de Remoção de Garçom");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setBackground(corCorpo);
        corpoPanel.setLayout(new BoxLayout(corpoPanel, BoxLayout.Y_AXIS));

        JPanel rodapePanel = new JPanel();
        rodapePanel.setBackground(corCorpo);
        rodapePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel idGarcomJLabel = new JLabel("Id Garcom");
        JTextField idGarcomField = new JTextField();
        idGarcomField.setBackground(corCorpo);
        idGarcomField.setHorizontalAlignment(SwingConstants.CENTER);
        idGarcomField.setPreferredSize(new Dimension(100, 50));

        idGarcomField.setEditable(true);

        JButton mostrarButton = new JButton("Mostrar Garçom");
        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverGarcomInterface.this.setIdGarcom(Integer.parseInt(idGarcomField.getText()));
                Garcom garcom = bGarcom.buscarGarcom(getIdGarcom());
                if (garcom != null) {
                    JOptionPane.showMessageDialog(RemoverGarcomInterface.this, garcom.toString(), "Informações do Garçom", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(RemoverGarcomInterface.this, "Garçom não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton removerGarcomButton = new JButton("Remover Garcom");
        removerGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverGarcomInterface.this.getBancoGarcom().removeWaiter(getIdGarcom());
                idGarcomField.setText("");
                JOptionPane.showMessageDialog(null,"Garçom Removido com Sucesso");

            }
        });

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverGarcomInterface.this.setVisible(false);
            }
        });



        topoPanel.add(topoLabel);

        corpoPanel.add(idGarcomJLabel);
        corpoPanel.add(idGarcomField);
        corpoPanel.add(mostrarButton);

        rodapePanel.add(voltarButton);
        rodapePanel.add(removerGarcomButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
