import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ConfirmarPedidoInterface extends JFrame {
    private ArrayList<Item> itens;
    private BancoMesas bancoMesas;
    private BancoGarcom bancoGarcom;
    private BancoPedidos bancoPedidos;
    private Mesa mesa;
    private Garcom garcom;

    public void setBancoPedidos(BancoPedidos bancoPedidos){
        this.bancoPedidos=bancoPedidos;
    }
    public BancoPedidos getBancoPedidos(){
        return this.bancoPedidos;
    }

    public void setPedidoBanco(Pedido pedido){
        this.bancoPedidos.inserirPedido(pedido);
    }
    public void setMesa(Mesa mesa){
        this.mesa=mesa;
    }

    public Mesa getMesa(){
        return this.mesa;
    }


    public void setGarcom(Garcom garcom){
        this.garcom=garcom;
    }

    public Garcom getGarcom(){
        return this.garcom;
    }

    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }

    public ArrayList<Item> getItens(){
        return this.itens;
    }
    public BancoGarcom getBancoGarcom (){
        return this.bancoGarcom;
    }


    public ConfirmarPedidoInterface(ArrayList<Item> itens, BancoMesas bancoMesas, BancoGarcom bancoGarcom, 
    BancoPedidos bancoPedidos){
        super("Acompanhamento de Pedido");
        this.itens = itens;
        this.bancoMesas=bancoMesas;
        this.bancoGarcom=bancoGarcom;
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
        panelBody.setMinimumSize(new Dimension(500, 600));
        panelBody.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panelRodape = new JPanel();
        panelRodape.setBackground(Color.PINK);
        panelRodape.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel labelEsquerda = new JLabel("Área Esquerda");
        labelEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
        panelRodape.add(labelEsquerda, BorderLayout.CENTER);
        
        ButtonGroup checkBoxGroupMesa = new ButtonGroup();
        ButtonGroup checkBoxGroupGarcom = new ButtonGroup();

        for(Mesa mesa:getBancoMesas().getMesa()){
            if(mesa.verifyAvaliableTable()){
                JRadioButton radioButton = new JRadioButton(mesa.toString());
                checkBoxGroupMesa.add(radioButton);
                panelHead.add(radioButton);  

                radioButton.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        ConfirmarPedidoInterface.this.setMesa(mesa);
                    }
                });
            }
        }


        for(Garcom garcom:getBancoGarcom().getGacons()){
            JRadioButton radioGarcomButton = new JRadioButton(garcom.toString());
            checkBoxGroupGarcom.add(radioGarcomButton);
            panelBody.add(radioGarcomButton);
            radioGarcomButton.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    ConfirmarPedidoInterface.this.setGarcom(garcom);
                }
            });


        }

        JButton voltaMenuButton = new JButton("Voltar");
        voltaMenuButton.setBounds(20, 175, 220, 25);
        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConfirmarPedidoInterface.this.setVisible(false);
            }
        });

        JButton confirmarPedidButton = new JButton("Confirmar Pedido");
        confirmarPedidButton.setBounds(20, 205, 220, 25);
        confirmarPedidButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if((ConfirmarPedidoInterface.this.getMesa()==null)||(ConfirmarPedidoInterface.this.getGarcom()==null)){
                    JOptionPane.showMessageDialog(null, "Selecione as opções desejadas!");
                }
                else{
                    Pedido pedidoFeito = new Pedido(ConfirmarPedidoInterface.this.getItens(), ConfirmarPedidoInterface.this.getMesa(), ConfirmarPedidoInterface.this.getGarcom(), "Feito");
//                    ConfirmarPedidoInterface.this.setPedidoBanco(pedido);
//                    ConfirmarPedidoInterface.this.bancoPedidos.inserirPedido(pedidoFeito);
                    JOptionPane.showMessageDialog(null, "Pedido Realizado com Sucesso!");
                    ConfirmarPedidoInterface.this.setVisible(false);
                    
                }
                
            }
        });
        
        confirmarPedidButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for(Pedido p: ConfirmarPedidoInterface.this.bancoPedidos.getPedidos()){
                    System.out.println(p.getDescribe());
                }
            }
        });



        panelPrincipal.add(panelHead);
        panelPrincipal.add(panelBody);
        panelPrincipal.add(panelRodape);
        panelRodape.add(voltaMenuButton);
        panelRodape.add(confirmarPedidButton);

        getContentPane().setLayout(new BorderLayout());
        // getContentPane().add(panelBody, BorderLayout.NORTH);
        getContentPane().add(panelRodape, BorderLayout.SOUTH);

        this.add(panelPrincipal);

        setVisible(true);
    }
    
}
