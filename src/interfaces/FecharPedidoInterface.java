package interfaces;

import banco.*;
import model.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FecharPedidoInterface {
	private Pedido pedido;
	private JFrame jframe;
    private JTextField recebidoField, qtdPField;
    private JComboBox<String> comboBox;
    private BancoPedidos bancoPedidos;
    private BancoMesas bancoMesas;
    
	private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Fechar Pedido");
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
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addComponent(nomeComponente)
    			.addComponent(campo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    			.addComponent(nomeComponente)
    			.addComponent(campo, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    			);
    	
    	panelTField.panel = panel;
    	panelTField.tField=campo;
    	return panelTField;
    }
	private JPanel gerarCorpoPanel() {
    	JPanel corpoPanel =  new JPanel();

    	
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
    	GroupLayout layout = new GroupLayout(corpoPanel);
    	
    	corpoPanel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);

    	
    	JTextArea textArea = new JTextArea();
    	textArea.setText(this.getPedido().formatCorect());
    	textArea.setFont(fonte);
    	textArea.setEditable(false);

    	JScrollPane scrollPane = new JScrollPane(textArea);
    	
    	
    	PanelTField recebidoPanel = gerarComponente("Dinheiro Recebido");
    	
    	this.setRecebidoField(recebidoPanel.tField);
    	
    	
    	PanelTField qtdPPanel = gerarComponente("Quantidade de Pessoas");
    	this.setQtdPField(qtdPPanel.tField);
    	
    	 JComboBox<String> comboBox = new JComboBox<>();
    	 comboBox.setFont(fonte);
    	 comboBox.setBackground(Color.decode("#FFFFFF"));
         comboBox.addItem("Dinheiro");
         comboBox.addItem("Cartão de Crédito");
         comboBox.addItem("Cartão de Débito");
         comboBox.addItem("Pix");
         
         comboBox.setSelectedIndex(0); 
         
         setComboBox(comboBox);
         
         
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addComponent(scrollPane,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    			.addComponent(qtdPPanel.panel)
    			.addComponent(recebidoPanel.panel)
    			.addComponent(comboBox,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    			.addComponent(scrollPane,GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
    			.addComponent(qtdPPanel.panel)
    			.addComponent(recebidoPanel.panel)
    			.addComponent(comboBox,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
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
            	FecharPedidoInterface.this.dispose();
               
            }
        });
        
    	JButton finalizarButton = new JButton("Finalizar");
    	finalizarButton.setFont(fonte);
    	finalizarButton.setBackground(Color.decode("#F29829"));
    	finalizarButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        if (FecharPedidoInterface.this.getRecebidoField().getText().isEmpty() || FecharPedidoInterface.this.getQtdPField().getText().isEmpty()) {
    	            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Error", JOptionPane.ERROR_MESSAGE);
    	        } else {
    	            try {
    	                double valorConta = Double.parseDouble(FecharPedidoInterface.this.getRecebidoField().getText());
    	                int qtdPessoas = Integer.parseInt(FecharPedidoInterface.this.getQtdPField().getText());
    	                
    	                if (valorConta < FecharPedidoInterface.this.getPedido().getValorConta()) {
    	                    JOptionPane.showMessageDialog(null, "O valor passado não é suficiente!", "Error", JOptionPane.ERROR_MESSAGE);
    	                } else if (qtdPessoas <= 0) {
    	                    JOptionPane.showMessageDialog(null, "A quantidade de pessoas deve ser maior que zero!", "Error", JOptionPane.ERROR_MESSAGE);
    	                } else {
    	                    double valorContaPessoa = valorConta / qtdPessoas;
    	                    double troco = valorConta - FecharPedidoInterface.this.getPedido().getValorConta();
    	                    
    	                    FecharPedidoInterface.this.getRecebidoField().setText("");
    	                    
    	                    BancoPedidos bancoPedidos = getBancoPedidos();
    	                    
    	                    bancoPedidos.removerPedido(FecharPedidoInterface.this.getPedido());
    	        
    	                    
    	                    JOptionPane.showMessageDialog(
    	                        null,
    	                        FecharPedidoInterface.this.getPedido().formatCorect() + 
    	                        "\nValor por Pessoa: R$" + valorContaPessoa +
    	                        "\nTroco: R$" + troco +
    	                        "\nPagamento: " + (String) getComboBox().getSelectedItem(),
    	                        "Pedido finalizado com sucesso!",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                    );
    	                    
    	                    JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!");
    	                    FecharPedidoInterface.this.dispose();
    	                }
    	            } catch (NumberFormatException ex) {
    	                JOptionPane.showMessageDialog(null, "Os campos devem conter valores numéricos válidos!", "Error", JOptionPane.ERROR_MESSAGE);
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
    					.addComponent(finalizarButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    					)
    			
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(finalizarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    
    private void initialize() {
        jframe = new JFrame("Fechar Pedido");
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
    
    public FecharPedidoInterface(Pedido pedido, BancoPedidos bancoPedidos, BancoMesas bancoMesas) {
        this.pedido=pedido;
        this.bancoPedidos=bancoPedidos;
        this.bancoMesas = bancoMesas;
        
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
	public JTextField getRecebidoField() {
		return recebidoField;
	}
	public void setRecebidoField(JTextField recebidoField) {
		this.recebidoField = recebidoField;
	}


	public Pedido getPedido() {
		return this.pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public BancoPedidos getBancoPedidos() {
		return bancoPedidos;
	}
	public void setBancoPedidos(BancoPedidos bancoPedidos) {
		this.bancoPedidos = bancoPedidos;
	}

	public BancoMesas getBancoMesas() {
		return bancoMesas;
	}
	public void setBancoMesas(BancoMesas bancoMesas) {
		this.bancoMesas = bancoMesas;
	}
	
    public void dispose() {
    	jframe.dispose();
    }
    
	public JTextField getQtdPField() {
		return qtdPField;
	}
	public void setQtdPField(JTextField qtdPField) {
		this.qtdPField = qtdPField;
	}

	private class PanelTField{
    	public JPanel panel;
    	public JTextField tField;
    	
    	
    }

    

}


