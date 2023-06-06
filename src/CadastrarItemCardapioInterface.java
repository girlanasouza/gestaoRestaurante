import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CadastrarItemCardapioInterface extends JFrame {
    private Cardapio cardapio;

    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public CadastrarItemCardapioInterface(Cardapio cardapio) {
        super("Cadastro de Cardápio");
        this.cardapio = cardapio;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension maxSize = new Dimension(500, 800);
        setSize(maxSize);
        setPreferredSize(maxSize);
        setResizable(true);
        
        Color corTopo = new Color(173,216,230);
        Color corCorpo = new Color (245,255,250);
        
        JPanel topoPanel = new JPanel();
        topoPanel.setBackground(corTopo);

        JLabel topoLabel = new JLabel("Tela de Cadastro de item");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setBackground(corCorpo);
        corpoPanel.setLayout(new BoxLayout(corpoPanel, BoxLayout.Y_AXIS));
        
        JPanel rodapePanel = new JPanel();
        rodapePanel.setBackground(corCorpo);
        rodapePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JLabel nomeItem = new JLabel("Nome do Item");
        nomeItem.setBackground(corTopo);
        JTextField itemField = new JTextField();
        itemField.setBackground(corCorpo);
        itemField.setHorizontalAlignment(SwingConstants.CENTER);
        itemField.setEditable(true);

        JLabel descricaoItem = new JLabel("Descrição do Item");

        JTextField descricaoItemField = new JTextField();
        descricaoItemField.setBackground(corCorpo);
        descricaoItemField.setHorizontalAlignment(SwingConstants.CENTER);
        descricaoItemField.setEditable(true);


        JLabel valueItem = new JLabel("Valor do Item");

        JTextField valueItemField = new JTextField();
        valueItemField.setBackground(corCorpo);
        valueItemField.setHorizontalAlignment(SwingConstants.CENTER);
        valueItemField.setEditable(true);

        JButton cadastrarItemButton = new JButton("Cadastrar item");

        cadastrarItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = itemField.getText();
                String descricao = descricaoItemField.getText();
                String valorText = valueItemField.getText();
        
                if (nome.isEmpty() || descricao.isEmpty() || valorText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    double valor = Double.parseDouble(valorText);
                    //arrumar id
                    Item item = new Item(nome, descricao, valor);
                    cardapio.addItem(item);
                    itemField.setText("");
                    descricaoItemField.setText("");
                    valueItemField.setText("");
                    JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
                }
            }
        });
        

        JButton imprimirCardapioButton = new JButton("Imprimir Cardápio");
        imprimirCardapioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, cardapio.describeMenu());
            }
        });

        JButton voltaMenuButton = new JButton("Voltar Menu", null);
        voltaMenuButton.setBounds(20, 55, 220, 25);

        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarItemCardapioInterface.this.setVisible(false);
               
            }
        });
        topoPanel.add(topoLabel);
        corpoPanel.add(nomeItem);
        corpoPanel.add(itemField);
        corpoPanel.add(descricaoItem);
        corpoPanel.add(descricaoItemField);
        corpoPanel.add(valueItem);
        corpoPanel.add(valueItemField);
        rodapePanel.add(cadastrarItemButton);
        rodapePanel.add(imprimirCardapioButton);
        rodapePanel.add(voltaMenuButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);
    }
}
