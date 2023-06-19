package interfaces;

import banco.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlterarSituaçãoPedidoInterface {
	private Pedido pedidoAlteradoPedido;
	private int idPedidoAlterado;
    private BancoPedidos bancoPedidos;
    private Pedido pedido;
	private JFrame jframe;
	private JTextField situacaoField;
    private JComboBox<String> comboBox;
	
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Alterar Situação Pedido");
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

        GroupLayout.ParallelGroup horizontalGroupMesas = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.SequentialGroup verticalGroupMesas = layout.createSequentialGroup();

        ButtonGroup checkBoxPedido = new ButtonGroup();

        if (getBancoPedidos().getPedidos() != null) {
        	BancoPedidos bancoPedidos = new BancoPedidos().selectAll();
            for (Pedido pedido : bancoPedidos.getPedidos()) {
                JRadioButton radioButton = new JRadioButton(pedido.formatCorect() + ", Situação: " + pedido.getSituacao());
                radioButton.setBackground((Color.decode("#F29829")));
                radioButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                radioButton.setFont(fonte);
                checkBoxPedido.add(radioButton);


                GroupLayout.SequentialGroup horizontalGroupRadioButton = layout.createSequentialGroup();

                horizontalGroupRadioButton.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
 
                horizontalGroupMesas.addGroup(horizontalGroupRadioButton);

                verticalGroupMesas.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                       );

                radioButton.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        AlterarSituaçãoPedidoInterface.this.setPedido(pedido);
                    }
                });
            }
        }

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(horizontalGroupMesas)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(verticalGroupMesas)
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
            	AlterarSituaçãoPedidoInterface.this.setVisible(false);
               
            }
        });
    	
    	JButton alterarButton = new JButton("Alteração");
    	alterarButton.setFont(fonte);
    	alterarButton.setBackground(Color.decode("#F29829"));
    	alterarButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	if(getPedido()!=null) {
    	    		AlteraçãoRealPedidoInterface alteraçãoRealPedidoInterface = new AlteraçãoRealPedidoInterface(getBancoPedidos(), getPedido());
    	    		alteraçãoRealPedidoInterface.setVisible(true);
        	        AlterarSituaçãoPedidoInterface.this.setVisible(false);
    	    	}
    	    	else {
    	    		JOptionPane.showMessageDialog(null, "Por favor, selecione um Pedido", "ERROR", JOptionPane.ERROR_MESSAGE);     
        	        
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
        jframe = new JFrame("Alterar Situaçao Pedido");
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
        
    
    public AlterarSituaçãoPedidoInterface(BancoPedidos bancoPedidos) {
        this.setBancoPedidos(bancoPedidos);

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

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

}
