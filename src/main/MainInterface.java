package main;

import banco.*;
import interfaces.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainInterface {

    private Cardapio cardapio;
    private BancoGarcom bancoGarcom;
    private BancoMesas bancoMesas;
    private BancoPedidos bancoPedidos;
    private JFrame jframe;
   
    
    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void setBancoGarcom(BancoGarcom bancoGarcom){
        this.bancoGarcom=bancoGarcom;
    }

    public BancoPedidos getBancoPedidos(){
        return this.bancoPedidos;
    }

    public void setBancoPedidos(BancoPedidos bancoPedidos){
        this.bancoPedidos=bancoPedidos;
    }

    public BancoGarcom getBancoGarcom(){
        return this.bancoGarcom;
    }

    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }
    

    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Tela Inicial");
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
    	JPanel corpoPanel =  new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
    	
    	GroupLayout layout = new  GroupLayout(corpoPanel);
    	
    	corpoPanel.setLayout(layout);
    
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
    	JButton menuButton = new JButton("Cardápio");
    	menuButton.setFont(fonte);
    	menuButton.setBackground(Color.decode("#F29829"));
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cardapio != null) {
                    CardapioInterface menuInterface = new CardapioInterface(MainInterface.this.getCardapio(),MainInterface.this.getBancoMesas(), 
                    MainInterface.this.getBancoGarcom(), MainInterface.this.getBancoPedidos());
                    menuInterface.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Cardápio não definido.");
                }
            }
        });   
    	
    	JButton gerenciarCardapioButton = new JButton("Gerenciar Cardapio");
    	gerenciarCardapioButton.setFont(fonte);
    	gerenciarCardapioButton.setBackground(Color.decode("#F29829"));
    	gerenciarCardapioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                GerirCardapioInterface gerirCardapioInterface = new GerirCardapioInterface(cardapio);
                gerirCardapioInterface.setVisible(true);
            }
        });
    	
    	JButton gerirGarcomButton= new JButton("Gerenciar Garçons");
    	gerirGarcomButton.setFont(fonte);
    	gerirGarcomButton.setBackground(Color.decode("#F29829"));
        gerirGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                GerirGarcomInterface gerirGarcomInterface = new GerirGarcomInterface(bancoGarcom, bancoPedidos);
                gerirGarcomInterface.setVisible(true);
            }
        });
    	
        
        JButton acompanharPedidos = new JButton("Acompanhar Pedidos");
        acompanharPedidos.setFont(fonte);
        acompanharPedidos.setBackground(Color.decode("#F29829"));
        acompanharPedidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                AcompanhamentoPedidoInterface acompanhamentoPedidoInterface = new AcompanhamentoPedidoInterface(getBancoPedidos());
                acompanhamentoPedidoInterface.setVisible(true);
            }
        });
        
        JButton fecharContaButton = new JButton("Fechar Conta");
        fecharContaButton.setFont(fonte);
        fecharContaButton.setBackground(Color.decode("#F29829"));
        fecharContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	FechamentoContaInterface fechamentoContaInterface = new FechamentoContaInterface(getBancoPedidos(), getBancoMesas());
            	fechamentoContaInterface.setVisible(true);
            }
        });
        
        JButton mesaButton = new JButton("Gerenciar Mesas");
        mesaButton.setFont(fonte);
        mesaButton.setBackground(Color.decode("#F29829"));
        mesaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                GerirMesaInterface gerirMesaInterface = new GerirMesaInterface(getBancoMesas());
                gerirMesaInterface.setVisible(true);
            }
        });
        
        
        JButton acompanharButton = new JButton("Acompanhar pedidos");
        acompanharButton.setFont(fonte);
        acompanharButton.setBackground(Color.decode("#F29829"));
        acompanharButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
            	AcompanhamentoPedidoInterface acompanhamentoPedidoInterface = new AcompanhamentoPedidoInterface(getBancoPedidos());
            	acompanhamentoPedidoInterface.setVisible(true);
            }
        });


    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addGroup(
    					layout.createSequentialGroup()
    					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)					
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    					.addComponent(gerenciarCardapioButton,GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
    					.addComponent(gerirGarcomButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)

    					.addComponent(mesaButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)

    					.addComponent(acompanharButton,GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
    					.addComponent(fecharContaButton,GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)

    					)	
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
    					.addComponent(gerenciarCardapioButton,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
    					.addComponent(gerirGarcomButton,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)

    					.addComponent(mesaButton,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)

    					.addComponent(acompanharButton,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
    					.addComponent(fecharContaButton,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
    					.addComponent(acompanharButton,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
    					)			
    			);
    	
    	
    	return corpoPanel;
		
	}
    
    private JPanel gerarRodapePanel() {
    	JPanel rodapePanel = new JPanel();

    	GroupLayout layout = new  GroupLayout(rodapePanel);
    	
    	rodapePanel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	rodapePanel.setBackground(Color.decode("#F2EED8"));

    	return rodapePanel;
    }
    
    private void initialize() {
        jframe = new JFrame("Tela Principal");
        jframe.setSize(1200, 900);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBackground(Color.decode("#FFFFFF"));
        jframe.setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.decode("#FFFFFF"));

        jPanel.setSize(1200, 900);

        GroupLayout layout = new GroupLayout(jPanel);

        jPanel.setLayout(layout);


        JPanel topoPanel = gerarTopoPanel();
        topoPanel.setBackground(Color.decode("#F2EED8"));
        JPanel corpoPanel =  gerarCorpoPanel();
        corpoPanel.setBackground(Color.decode("#F2EED8"));
        JPanel rodapePanel = gerarRodapePanel();
        rodapePanel.setBackground(Color.decode("#F2EED8"));

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(topoPanel)
                        .addComponent(corpoPanel)

        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(topoPanel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addComponent(corpoPanel, GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE)
        );


        jframe.add(jPanel);
    }

    
    public MainInterface(Cardapio cardapio,BancoGarcom bancoGarcom, 
    		BancoMesas bancoMesas, BancoPedidos bancoPedidos) {
    	this.cardapio=cardapio;
    	this.bancoGarcom = bancoGarcom;
    	this.bancoMesas=bancoMesas;
    	this.bancoPedidos=bancoPedidos;
        
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
}
