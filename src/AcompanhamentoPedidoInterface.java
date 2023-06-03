import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AcompanhamentoPedidoInterface extends JFrame {
    private Pedido pedido;
    private BancoPedidos bancoPedidos;


    public void setPedido(Pedido pedido){
        bancoPedidos = new BancoPedidos();

        this.bancoPedidos.inserirPedido(pedido);
    }

    public Pedido getPedido(){
        return this.pedido;
    }

    public AcompanhamentoPedidoInterface(Pedido pedido){
        super("Confirmar Pedido");
        this.pedido=pedido;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension maxSize = new Dimension(500, 800);

        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);

        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.ORANGE);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        JPanel panelHead = new JPanel();
        panelHead.setBackground(Color.ORANGE);
        panelHead.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelBody = new JPanel();
        panelBody.setBackground(Color.GREEN);
        panelBody.setMinimumSize(new Dimension(500, 600));
        panelBody.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel pedidosJLabel = new JLabel("");


        JPanel panelRodape = new JPanel();
        panelRodape.setBackground(Color.PINK);
        panelRodape.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel labelEsquerda = new JLabel("Área Esquerda");
        labelEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
        panelRodape.add(labelEsquerda, BorderLayout.CENTER);
        

        JButton voltaMenuButton = new JButton("Voltar");
        voltaMenuButton.setBounds(20, 175, 220, 25);
        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AcompanhamentoPedidoInterface.this.setVisible(false);
            }
        });

        panelPrincipal.add(panelHead);
        panelPrincipal.add(panelBody);
        panelPrincipal.add(panelRodape);
        panelRodape.add(voltaMenuButton);
        

        getContentPane().setLayout(new BorderLayout());
        // getContentPane().add(panelBody, BorderLayout.NORTH);
        getContentPane().add(panelRodape, BorderLayout.SOUTH);

        this.add(panelPrincipal);

        setVisible(true);
    }

}
