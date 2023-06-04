import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class AcompanhamentoPedidoInterface extends JFrame {
    private Pedido pedido;
    private BancoPedidos bancoPedidos;
    private JTable tabelaPedidos;
    private DefaultTableModel tableModel;

    public void setPedido(Pedido pedido){
        bancoPedidos = new BancoPedidos();
        this.bancoPedidos.inserirPedido(pedido);
        // Atualiza a tabela após inserir o pedido
        atualizarTabelaPedidos();
    }

    public Pedido getPedido(){
        return this.pedido;
    }

    public AcompanhamentoPedidoInterface(BancoPedidos bancoPedidos){
        super("Confirmar Pedido");
        this.bancoPedidos=bancoPedidos;

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
        panelBody.setLayout(new BorderLayout());

        JPanel panelRodape = new JPanel();
        panelRodape.setBackground(Color.PINK);
        panelRodape.setLayout(new FlowLayout(FlowLayout.RIGHT));

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Número");
        tableModel.addColumn("Mesa");
        tableModel.addColumn("Situação");

        tabelaPedidos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);
        panelBody.add(scrollPane, BorderLayout.CENTER);

        JLabel labelEsquerda = new JLabel("Área Esquerda");
        labelEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
        panelRodape.add(labelEsquerda, BorderLayout.CENTER);

        JButton voltaMenuButton = new JButton("Voltar");
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
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);

        setVisible(true);
    }
    
    private void atualizarTabelaPedidos() {
        // Limpa os dados da tabela
        tableModel.setRowCount(0);

        // Obtém os pedidos do banco de pedidos
        ArrayList<Pedido> pedidos = bancoPedidos.getPedidos();

        // Adiciona os pedidos à tabela
        for (Pedido pedido : pedidos) {
            tableModel.addRow(new Object[]{pedido.getMesa(), pedido.getDescribe(), pedido.getSituacao()});
        }
    }
}
