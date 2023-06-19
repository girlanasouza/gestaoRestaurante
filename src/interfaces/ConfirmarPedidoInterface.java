package interfaces;

import banco.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ConfirmarPedidoInterface{
    private ArrayList<Item> itens;
    private BancoMesas bancoMesas;
    private BancoGarcom bancoGarcom;
    private BancoPedidos bancoPedidos;
    private Mesa mesa;
    private Garcom garcom;
    private JFrame jframe;
    
    public void setBancoPedidos(BancoPedidos bancoPedidos) {
        this.bancoPedidos = bancoPedidos;
    }

    public BancoPedidos getBancoPedidos() {
        return this.bancoPedidos;
    }

    public void setPedidoBanco(Pedido pedido) {
        if (this.bancoPedidos != null) {
            this.bancoPedidos.inserirPedido(pedido);
        } else {
            JOptionPane.showMessageDialog(null, "Banco de Pedidos não inicializado!");
        }
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return this.mesa;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public Garcom getGarcom() {
        return this.garcom;
    }

    public BancoMesas getBancoMesas() {
        return this.bancoMesas;
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }

    public BancoGarcom getBancoGarcom() {
        return this.bancoGarcom;
    }
    
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Confirmar Pedido");
    	topoLabel.setFont(fonte);
    	GroupLayout layout = new  GroupLayout(topoPanel);
    	topoPanel.setMinimumSize(new Dimension(1000, 400));
    	topoPanel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addComponent(topoLabel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    			.addComponent(topoLabel,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    			);
    	return topoPanel;
    }
    
    private JPanel gerarCorpoPanel() {
        JPanel corpoPanel = new JPanel();

        GroupLayout layout = new GroupLayout(corpoPanel);
        corpoPanel.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);


    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
    	
        GroupLayout.ParallelGroup horizontalGroupMesas = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroupMesas = layout.createSequentialGroup();

        GroupLayout.ParallelGroup horizontalGroupGarcoms = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroupGarcoms = layout.createSequentialGroup();
        
        JLabel labelMesa = new JLabel("Escolha uma mesa");
        labelMesa.setFont(fonte);
        JLabel labelGarcom = new JLabel("Escolha um garçom");
        labelGarcom.setFont(fonte);

        horizontalGroupMesas.addComponent(labelMesa);
        horizontalGroupGarcoms.addComponent(labelGarcom);

        verticalGroupMesas.addComponent(labelMesa);
        verticalGroupGarcoms.addComponent(labelGarcom);

        ButtonGroup checkBoxGroupMesa = new ButtonGroup();
        ButtonGroup checkBoxGroupGarcom = new ButtonGroup();

        ArrayList<Mesa> mesas = getBancoMesas().getMesas();
        ArrayList<Garcom> garcons = getBancoGarcom().getGarcons();

        if (mesas != null) {
            for (Mesa mesa : mesas) {
                if (mesa.disponivelMesa()){
                    JRadioButton radioButton = new JRadioButton(mesa.toString()+mesa.verify());
                    radioButton.setBackground((Color.decode("#F29829")));
                    radioButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    radioButton.setFont(fonte);
                    checkBoxGroupMesa.add(radioButton);
                    
                    horizontalGroupMesas.addComponent(radioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                    
                    verticalGroupMesas.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE);
                    
                    radioButton.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            ConfirmarPedidoInterface.this.setMesa(mesa);
                        }
                    });
                }
            }
        }

        for (Garcom garcom : garcons) {
            JRadioButton radioGarcomButton = new JRadioButton(garcom.toString());
            radioGarcomButton.setBackground((Color.decode("#F29829")));
            radioGarcomButton.setFont(fonte);
            radioGarcomButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            checkBoxGroupGarcom.add(radioGarcomButton);
            horizontalGroupGarcoms.addComponent(radioGarcomButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            verticalGroupGarcoms.addComponent(radioGarcomButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE);

            radioGarcomButton.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    ConfirmarPedidoInterface.this.setGarcom(garcom);
                }
            });
        }
        

        layout.setHorizontalGroup(
        	    layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        	        .addGroup(horizontalGroupMesas)
        	        .addGroup(horizontalGroupGarcoms)
        	);

        	layout.setVerticalGroup(
        	    layout.createSequentialGroup()
        	        .addGroup(verticalGroupMesas)
        	        .addGap(20)
        	        .addGroup(verticalGroupGarcoms)
        	);

        return corpoPanel;
    }


    private JPanel gerarRodapePanel() {
    	JPanel rodapePanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);

    	JButton menuButton = new JButton("Menu");
    	menuButton.setFont(fonte);
    	menuButton.setBackground(Color.decode("#F29829"));
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConfirmarPedidoInterface.this.setVisible(false);
               
            }
        });
        

        JButton confirmarPedidoButton = new JButton("Confirmar Pedido");
        confirmarPedidoButton.setFont(fonte);
        confirmarPedidoButton.setBackground(Color.decode("#F29829"));
        confirmarPedidoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((getMesa() == null) || (getGarcom() == null)) {
                    JOptionPane.showMessageDialog(null, "Selecione as opções desejadas!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Pedido pedidoFeito = new Pedido(getItens(), getMesa(), getGarcom(), "Feito");
                    pedidoFeito.getTotalConta();
                    
                    if (getBancoPedidos() != null) {
                        if (pedidoFeito.getMesa() != null) {
                            pedidoFeito.getMesa().setStatus(false);
                            getBancoMesas().atualizarStatusMesa(pedidoFeito.getMesa());
                        }
                        getBancoPedidos().inserirPedido(pedidoFeito);
//                        getBancoMesas().atualizarMesa(getMesa().getId());
                        
                        JOptionPane.showMessageDialog(null, "Id: "+pedidoFeito.getId() +" "+ pedidoFeito.formatCorect(), "Descrição do Pedido", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Pedido Realizado com Sucesso!");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Banco de Pedidos não inicializado!");
                    }
                }
            }
        });



    	GroupLayout layout = new  GroupLayout(rodapePanel);
    	
    	rodapePanel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addGroup(
    					layout.createSequentialGroup()
    					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)					
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    					.addComponent(confirmarPedidoButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					)
    			
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(confirmarPedidoButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    
    private void initialize() {
        jframe = new JFrame("Confirmar Pedido");
        jframe.setSize(1200, 900);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setBackground(Color.decode("#FFFFFF"));
        jframe.setLocationRelativeTo(null);
        

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.decode("#FFFFFF"));
        
        GroupLayout layout = new GroupLayout(jPanel);

        jPanel.setLayout(layout);

        jPanel.setSize(1200, 900);
        
        JPanel topoPanel = gerarTopoPanel();
        topoPanel.setBackground(Color.decode("#F2EED8"));
        JPanel corpoPanel =  gerarCorpoPanel();
        corpoPanel.setBackground(Color.decode("#F2EED8"));
        JPanel rodapePanel = gerarRodapePanel();
        rodapePanel.setBackground(Color.decode("#F2EED8"));
        
        JScrollPane scrollPane = new JScrollPane(corpoPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(topoPanel)
                        .addComponent(scrollPane)
                        .addComponent(rodapePanel)

        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(topoPanel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rodapePanel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        );
        
        
        

        jframe.add(jPanel);
        
        jframe.add(jPanel);
    	
    }
        
    
    public ConfirmarPedidoInterface(ArrayList<Item> itens, BancoMesas bancoMesas, BancoGarcom bancoGarcom,
            BancoPedidos bancoPedidos) {
        this.itens = itens;
        this.bancoMesas = bancoMesas;
        this.bancoGarcom = bancoGarcom;
        this.bancoPedidos = bancoPedidos;

        
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
}
