import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoverItemInterface extends JFrame {
    private Cardapio cardapio;
    private int idItem=0;

    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public void setCardapio(Cardapio cardapio){
        this.cardapio=cardapio;
    }
    public void setIdItem(int id){
        this.idItem=id;
    }
    public int getIdItem(){
        return this.idItem;
    }

    public RemoverItemInterface(Cardapio cardapio) {
        super("Remover Item");
        this.cardapio = cardapio;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);

        Color corTopo = new Color(173, 216, 230);
        Color corCorpo = new Color(245, 255, 250);

        JPanel topoPanel = new JPanel();
        topoPanel.setBackground(corTopo);

        JLabel topoLabel = new JLabel("Tela de Remoção de Item");
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

        JButton mostrarButton = new JButton("Mostrar Item");
        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverItemInterface.this.setIdItem(Integer.parseInt(idGarcomField.getText()));
                Item item = cardapio.buscarItem(getIdItem());
                if (item != null) {
                    JOptionPane.showMessageDialog(RemoverItemInterface.this, item.toString(), "Informações do Item", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(RemoverItemInterface.this, "Item não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton removerGarcomButton = new JButton("Remover Item");
        removerGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverItemInterface.this.getCardapio().removeItem(getIdItem());
                idGarcomField.setText("");
                JOptionPane.showMessageDialog(null,"Item Removido com Sucesso");

            }
        });

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverItemInterface.this.setVisible(false);
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
