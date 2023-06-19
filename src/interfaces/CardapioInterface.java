package interfaces;

import banco.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.*;

public class CardapioInterface{
    private Cardapio cardapio;
    private ArrayList <Item> itens;
    private BancoMesas bancoMesas;
    private BancoGarcom  bancoGarcom;
    private BancoPedidos bancoPedidos;
    private JFrame jframe;
	    
    public ArrayList<Item> getItens(){
        return this.itens;
    }

    public void setItens(ArrayList<Item> itens){
        this.itens=itens;
    }

    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }

    public BancoGarcom getBancoGarcom(){
        return this.bancoGarcom;
    }
    public BancoPedidos getBancoPedidos(){
        return this.bancoPedidos;
    }
    
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Cardápio");
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
    
    private JPanel gerarCorpoPanel(Cardapio cardapio) {
        JPanel corpoPanel = new JPanel();

        GroupLayout layout = new GroupLayout(corpoPanel);
        corpoPanel.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);

        GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();

        if (cardapio != null) {
            ArrayList<Item> opcoesCardapio = cardapio.getCardapio();
            for (Item item : opcoesCardapio) {
                JCheckBox checkBox = new JCheckBox(item.toString());
                checkBox.setBackground(Color.decode("#F29829"));
                checkBox.setFont(fonte);
                checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
                checkBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        controlaPedido();
                    }

                    private void controlaPedido() {
                        if (checkBox.isSelected()) {
                            CardapioInterface.this.itens.add(item);
                        } else {
                            CardapioInterface.this.itens.remove(item);
                        }
                    }
                });

                horizontalGroup.addComponent(checkBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                verticalGroup.addComponent(checkBox, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE);
            }
        }

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(horizontalGroup)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(verticalGroup)
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
                CardapioInterface.this.setVisible(false);
               
            }
        });
        
        JButton realizarPedidoButton = new JButton("Realizar Pedido", null);
        realizarPedidoButton.setFont(fonte);
        realizarPedidoButton.setBackground(Color.decode("#F29829"));
        realizarPedidoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(CardapioInterface.this.getItens().size()==0){
                    JOptionPane.showMessageDialog(null, "Selecione as opções desejadas!");
                }
                else{
                    ConfirmarPedidoInterface confirmarPedidoInterface =  new ConfirmarPedidoInterface(CardapioInterface.this.getItens(), CardapioInterface.this.getBancoMesas(),
                    CardapioInterface.this.getBancoGarcom(), CardapioInterface.this.getBancoPedidos());
                    CardapioInterface.this.setVisible(false);
                    confirmarPedidoInterface.setVisible(true);
               
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
    					.addComponent(realizarPedidoButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					)

    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(realizarPedidoButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    
    private void initialize() {
        jframe = new JFrame("Cardápio");
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
        JPanel corpoPanel =  gerarCorpoPanel(getCardapio());
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
        
    public CardapioInterface(Cardapio cardapio, BancoMesas bancoMesas, BancoGarcom bancoGarcons, BancoPedidos bancoPedidos) {
        itens = new ArrayList<Item>();
        this.cardapio = cardapio;
        this.bancoMesas=bancoMesas;
        this.bancoGarcom = bancoGarcons;
        this.bancoPedidos=bancoPedidos;
        initialize();
    }
    public void setVisible(boolean b) {
    	if(b) {
    		this.cardapio = new Cardapio().selectAll();
    		this.bancoMesas = new BancoMesas().selectAll();
    		this.bancoPedidos = new BancoPedidos().selectAll();
    		this.bancoGarcom = new BancoGarcom().selectAll();
    	}
    	jframe.setVisible(b);
    }
    
}
