import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class CadastrarItemCardapioInterface extends JFrame {
    private Cardapio cardapio;

    public CadastrarItemCardapioInterface(Cardapio cardapio) {
        super("Cadastro de Cardápio");
        this.cardapio = cardapio;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Color cor = new Color(247, 246, 245);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);
        setPreferredSize(maxSize);
        setResizable(true);

        JPanel principal = new JPanel();
        principal.setSize(500, 800);
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        JLabel nomeItem = new JLabel("Nome do Item");
        JTextField itemField = new JTextField();
        itemField.setBackground(Color.PINK);
        itemField.setEditable(true);

        JLabel descricaoItem = new JLabel("Descrição do Item");
        JTextField descricaoItemField = new JTextField();
        descricaoItemField.setBackground(Color.YELLOW);
        descricaoItemField.setEditable(true);

        JLabel valueItem = new JLabel("Valor do Item");
        JTextField valueItemField = new JTextField();
        valueItemField.setBackground(Color.GREEN);
        valueItemField.setEditable(true);

        JButton cadastrarItemButton = new JButton("Cadastrar item");
        cadastrarItemButton.setBackground(Color.RED);

        cadastrarItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = itemField.getText();
                String descricao = descricaoItemField.getText();
                String valorText = valueItemField.getText();
        
                if (nome.isEmpty() || descricao.isEmpty() || valorText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    double valor = Double.parseDouble(valorText);
                    Item item = new Item(nome, descricao, valor);
                    cardapio.addItem(item);
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

        principal.add(nomeItem);
        principal.add(itemField);
        principal.add(descricaoItem);
        principal.add(descricaoItemField);
        principal.add(valueItem);
        principal.add(valueItemField);
        principal.add(cadastrarItemButton);
        principal.add(imprimirCardapioButton);
        principal.add(voltaMenuButton);

        add(principal);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
