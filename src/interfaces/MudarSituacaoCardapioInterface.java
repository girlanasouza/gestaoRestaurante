package interfaces;

import banco.*;
import model.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MudarSituacaoCardapioInterface {
	private Pedido pedidoAlteradoPedido;
	private int idPedidoAlterado;
    private BancoPedidos bancoPedidos;
    private Pedido pedido;
	private JFrame jframe;
	private JTextField situacaoField;
	
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Alterar Situação");
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
    
    private PanelTField gerarComponente(String nomeLabel) {
    	PanelTField panelTField = new PanelTField();
    	JPanel panel = new JPanel();
    	panel.setBackground(Color.decode("#F2EED8"));
    	
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
    	
    	JLabel nomeComponente =  new JLabel(nomeLabel);
    	nomeComponente.setFont(fonte);
    	
    	JTextField campo = new JTextField();

    	campo.setFont(fonte);
    	campo.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	GroupLayout layout = new  GroupLayout(panel);
    	
    	panel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(nomeComponente)
    			.addComponent(campo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addComponent(nomeComponente)
    			.addComponent(campo, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    			);
    	
    	panelTField.panel = panel;
    	panelTField.tField=campo;
    	return panelTField;
    }
    
    
    private JPanel gerarCorpoPanel() {
    	JPanel corpoPanel =  new JPanel();
    	
    	GroupLayout layout = new GroupLayout(corpoPanel);
    	
    	corpoPanel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
 
    	PanelTField situacaoPanel = gerarComponente("Situação do pedido");
    	this.setSituacaoField(situacaoPanel.tField);
    	
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addComponent(situacaoPanel.panel)
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    			.addComponent(situacaoPanel.panel)
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
            	MudarSituacaoCardapioInterface.this.setVisible(false);
               
            }
        });
    	
    	JButton alterarButton = new JButton("Alterar");
    	alterarButton.setFont(fonte);
    	alterarButton.setBackground(Color.decode("#F29829"));
    	alterarButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	
    	    	getBancoPedidos().buscarPedido(getPedido().getId());
    	    	

    	        Pedido pedido = getPedido();
    	        pedido.setSituacao(MudarSituacaoCardapioInterface.this.situacaoField.getText());
    	        getBancoPedidos().mudarSituacao(pedido);
    	        
    	        getBancoPedidos().atualizarPedidos();
    	        
    	        getSituacaoField().setText("");
    	        
    	        JOptionPane.showMessageDialog(null, "Pedido Alterado com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    	        
    	        
    	        MudarSituacaoCardapioInterface.this.setVisible(false);
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
    					.addComponent(alterarButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
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
        jframe = new JFrame("Alterar Situação");
        jframe.setSize(1000, 900);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setBackground(Color.decode("#FFFFFF"));
        jframe.setLocationRelativeTo(null);
        

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.decode("#FFFFFF"));
        
        GroupLayout layout = new GroupLayout(jPanel);

        jPanel.setLayout(layout);

        jPanel.setSize(1000, 900);
        
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
        
    
    public MudarSituacaoCardapioInterface(BancoPedidos bancoPedidos, Pedido pedido) {
        this.setBancoPedidos(bancoPedidos);
        this.setPedido(pedido);
        initialize();   
    }
    
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }

	public JTextField getSituacaoField() {
		return situacaoField;
	}

	public void setSituacaoField(JTextField situacaoField) {
		this.situacaoField = situacaoField;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BancoPedidos getBancoPedidos() {
		return bancoPedidos;
	}

	public void setBancoPedidos(BancoPedidos bancoPedidos) {
		this.bancoPedidos = bancoPedidos;
	}

	public Pedido getPedidoAlteradoPedido() {
		return pedidoAlteradoPedido;
	}

	public void setPedidoAlteradoPedido(Pedido pedidoAlteradoPedido) {
		this.pedidoAlteradoPedido = pedidoAlteradoPedido;
	}

	public int getIdPedidoAlterado() {
		return idPedidoAlterado;
	}

	public void setIdPedidoAlterado(int idPedidoAlterado) {
		this.idPedidoAlterado = idPedidoAlterado;
	}

	private class PanelTField{
    	public JPanel panel;
    	public JTextField tField;
    	
    	
    }
    

}
