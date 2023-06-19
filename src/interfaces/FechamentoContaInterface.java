package interfaces;

import banco.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FechamentoContaInterface{
    private BancoPedidos bancoPedidos;
    private BancoMesas bancoMesas;
    
    private ArrayList<Pedido> pedidos;
    
    private Pedido pedido;
    private JFrame jframe;
    
    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public BancoPedidos getBancoPedidos() {
        return this.bancoPedidos;
        
    }

    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);

    	JLabel topoLabel = new JLabel("Fechamento de Conta");
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
    
    private JPanel gerarCorpoPanel(BancoPedidos bancoPedidos) {
        JPanel corpoPanel = new JPanel();
    	Font fonte1 = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
        GroupLayout layout = new GroupLayout(corpoPanel);
        corpoPanel.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);


        GroupLayout.ParallelGroup horizontalGroupPedido = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroupPedido = layout.createSequentialGroup();

   

        ButtonGroup radioGroupPedido= new ButtonGroup();
        
        if (getBancoPedidos() != null) {
        	BancoPedidos bancoPedidosVa = new BancoPedidos();
        	bancoPedidosVa=bancoPedidosVa.selectAll();
            for (Pedido pedido : bancoPedidosVa.getPedidos()) {
            	JRadioButton pedidoButton = new JRadioButton(pedido.formatCorect());
                pedidoButton.setBackground(Color.decode("#F29829"));
                pedidoButton.setFont(fonte1);
                pedidoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                pedidoButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                

                radioGroupPedido.add(pedidoButton);
                
                horizontalGroupPedido.addComponent(pedidoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                
                verticalGroupPedido.addComponent(pedidoButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE);
                
                
                pedidoButton.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        FechamentoContaInterface.this.setPedido(pedido);
                    }
                });

            }
        }

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(horizontalGroupPedido)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(verticalGroupPedido)
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
                FechamentoContaInterface.this.dispose();
               
            }
        });        
        
        JButton fecharButton = new JButton("Fechar Pedido");
        fecharButton.setFont(fonte);
        fecharButton.setBackground(Color.decode("#F29829"));
        fecharButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if(FechamentoContaInterface.this.getPedido()==null){
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um pedido", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                	
                	FecharPedidoInterface fecharPedidoInterface =  new FecharPedidoInterface(getPedido(), getBancoPedidos(), getBancoMesas());
                	fecharPedidoInterface.setVisible(true);
                	
                    FechamentoContaInterface.this.dispose();
                    
               
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
    					.addComponent(fecharButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    				
    					)
    			
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(fecharButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    private void initialize() {
        jframe = new JFrame("Fechamento de Conta");
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
        JPanel corpoPanel =  gerarCorpoPanel(getBancoPedidos());
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
   
    
    public FechamentoContaInterface(BancoPedidos bancoPedidos, BancoMesas bancoMesas) {
        this.bancoPedidos = bancoPedidos;
        this.bancoMesas=bancoMesas;
        this.pedidos= new ArrayList<Pedido>();
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
    public void dispose() {
    	jframe.dispose();
    }

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BancoMesas getBancoMesas() {
		return bancoMesas;
	}

	public void setBancoMesas(BancoMesas bancoMesas) {
		this.bancoMesas = bancoMesas;
	}
    
}
