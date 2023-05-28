import java.awt.Color;

import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FechamentoContaInterface extends javax.swing.JFrame {

    private JFrame frame;
    private JTextArea textArea;

    public FechamentoContaInterface() {
        try {
            // Definir o look and feel do sistema operacional
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        
        createUI();
    }

    private void createUI() {
        // Criando a janela principal
        frame = new JFrame("Fechamento do pedido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Adicionando uma área de texto para exibir os dados
        textArea = new JTextArea();
        textArea.setEditable(false); // Impedir que o texto seja editado
        
        Color cor = new Color(255, 229, 153);

        textArea.setBackground(new Color(255, 229, 153)); 
        JScrollPane scrollPane = new JScrollPane(textArea); // Adicionar um scroll à área de texto
        frame.getContentPane().add(scrollPane);
        
        JButton button = new JButton("Clique aqui");
        button.setForeground(cor);


        // Exibindo a janela
        frame.setVisible(true);
    }

    public void exibirFechamentoConta(FechamentoConta fechamentoConta) {
        textArea.setText(fechamentoConta.getDescribe());
    }
}
