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

    public void setPedidoBanco(Pedido pedido) {
        if (this.bancoPedidos != null) {
            this.bancoPedidos.inserirPedido(pedido);
        } else {
            JOptionPane.showMessageDialog(null, "Banco de Pedidos não inicializado!");
        }
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
        Color color = new Color(255,235,205);

        setSize(maxSize);

        setPreferredSize(maxSize);

        setResizable(true);

        setLocationRelativeTo(null);

        Color corTopo = new Color(173,216,230);
        Color corCorpo = new Color (245,255,250);
		
		JPanel topoPanel = new JPanel();
        topoPanel.setBackground(corTopo);

        JLabel topoLabel = new JLabel("Confirmação de Pedido");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));

        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        corpoPanel.setBackground(corCorpo);
        
        JPanel rodapePanel = new JPanel();
        rodapePanel.setBackground(Color.RED);
        rodapePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rodapePanel.setBackground(corCorpo);
        
        ButtonGroup checkBoxGroupMesa = new ButtonGroup();
        ButtonGroup checkBoxGroupGarcom = new ButtonGroup();

        for(Mesa mesa:getBancoMesas().getMesa()){
            if(mesa.verifyAvaliableTable()){
                JRadioButton radioButton = new JRadioButton(mesa.toString());
                radioButton.setBackground(color);
                checkBoxGroupMesa.add(radioButton);
                
                corpoPanel.add(radioButton);  

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
            radioGarcomButton.setBackground(color);
            checkBoxGroupGarcom.add(radioGarcomButton);
            corpoPanel.add(radioGarcomButton);
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
                if ((ConfirmarPedidoInterface.this.getMesa() == null) || (ConfirmarPedidoInterface.this.getGarcom() == null)) {
                    JOptionPane.showMessageDialog(null, "Selecione as opções desejadas!");
                } else {
                    Pedido pedidoFeito = new Pedido(ConfirmarPedidoInterface.this.getItens(), ConfirmarPedidoInterface.this.getMesa(), ConfirmarPedidoInterface.this.getGarcom(), "Feito");
                    ConfirmarPedidoInterface.this.setPedidoBanco(pedidoFeito);  
                    JOptionPane.showMessageDialog(null, "Pedido Realizado com Sucesso!");
                    System.out.println(pedidoFeito.getTotalConta());
                    ConfirmarPedidoInterface.this.setVisible(false);
                }
            }
        });

        confirmarPedidButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (ConfirmarPedidoInterface.this.bancoPedidos != null) {
                    System.out.println(ConfirmarPedidoInterface.this.bancoPedidos.toString());
                } else {
                    System.out.println("Banco de Pedidos não inicializado!");
                }
            }
        });
        confirmarPedidButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ConfirmarPedidoInterface.this.bancoPedidos != null) {
                    System.out.println(ConfirmarPedidoInterface.this.bancoPedidos.toString());
                } else {
                    System.out.println("Banco de Pedidos não inicializado!");
                }
            }
        });




        topoPanel.add(topoLabel);
        rodapePanel.add(voltaMenuButton);
        rodapePanel.add(confirmarPedidButton);

		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);
        

        setVisible(true);
    }
    
}
