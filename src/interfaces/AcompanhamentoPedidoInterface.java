package interfaces;

import banco.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class AcompanhamentoPedidoInterface{

    private BancoPedidos bancoPedidos;
	private JFrame jframe;

    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Acompanhamento de Pedidos");
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
    
    public JPanel criarPanel(String nomeL, int idPedido) {

    	JPanel newPanel = new JPanel();
    	GroupLayout layout = new GroupLayout(newPanel);
    	newPanel.setLayout(layout);
    	newPanel.setBackground(Color.decode("#F2EED8"));
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
    	
    	JLabel situaJLabel = new JLabel(nomeL);
    	
    	situaJLabel.setFont(fonte);
    	JButton situaButton = new JButton("Situação");
    	situaButton.setFont(fonte);
    	situaButton.setBackground(Color.decode("#F29829"));
    	situaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pedido pedido = getBancoPedidos().buscarPedido(idPedido);
	            if (pedido != null) {
	            	JDialog dialog = new JDialog();
	            	dialog.getContentPane().setBackground(Color.BLUE);
	                JOptionPane.showMessageDialog(null, "Pedido "+pedido.getSituacao(), "Relatório do Pedido", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Pedido não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }
				
			}
        });
    	
     	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addGroup(
    					layout.createSequentialGroup()
    					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)					
    					.addComponent(situaJLabel)
    					.addComponent(situaButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    					)

    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(situaJLabel)
    					.addComponent(situaButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return newPanel;
    }
    
    
    private JPanel gerarCorpoPanel() {
        JPanel corpoPanel = new JPanel();

        GroupLayout layout = new GroupLayout(corpoPanel);
        corpoPanel.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();

        if(this.getBancoPedidos()!=null) {
        	
        	BancoPedidos bancoPedidos = new BancoPedidos().selectAll();
    		
            for (Pedido pedido : bancoPedidos.getPedidos()) {
                JPanel painel = criarPanel(pedido.formatCorect(), pedido.getId());

                horizontalGroup.addComponent(painel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                verticalGroup.addComponent(painel, GroupLayout.DEFAULT_SIZE, 80, GroupLayout.PREFERRED_SIZE);
               
                
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
                AcompanhamentoPedidoInterface.this.setVisible(false);
               
            }
        });
        
    	JButton alterarButton = new JButton("Alterar Situação");
    	alterarButton.setFont(fonte);
    	alterarButton.setBackground(Color.decode("#F29829"));
    	alterarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AlterarSituaçãoPedidoInterface alterarSituaçãoPedidoInterface = new AlterarSituaçãoPedidoInterface(getBancoPedidos());
            	alterarSituaçãoPedidoInterface.setVisible(true);
            	AcompanhamentoPedidoInterface.this.setVisible(false);
               
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
    					.addComponent(alterarButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					)
    			
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(alterarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    
    
    private void initialize() {
        jframe = new JFrame("Acompanhamento de pedidos");
        jframe.setSize(1000, 900);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setBackground(Color.decode("#FFFFFF"));
        jframe.setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.decode("#FFFFFF"));

        jPanel.setSize(1000, 900);

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
                        .addComponent(rodapePanel)

        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(topoPanel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addComponent(corpoPanel, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rodapePanel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        );
        
        
        

        jframe.add(jPanel);
    }

    public AcompanhamentoPedidoInterface(BancoPedidos bancoPedidos){
        this.setBancoPedidos(bancoPedidos);
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
	public BancoPedidos getBancoPedidos() {
		return bancoPedidos;
	}
	public void setBancoPedidos(BancoPedidos bancoPedidos) {
		this.bancoPedidos = bancoPedidos;
	}

    

}
