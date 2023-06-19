package interfaces;

import banco.*;
import model.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RelatorioGarcomInterface{
    private Garcom garcom;
    private BancoGarcom bGarcom;
    private BancoPedidos bancoPedidos;
    private int idGarcom;
	private JFrame jframe;
    
    public void setIdGarcom(int id){
        this.idGarcom=id;
    }
    public int getIdGarcom(){
        return this.idGarcom;
    }
    public Garcom getGarcom() {
        return this.garcom;
    }

    public BancoGarcom getBancoGarcom() {
        return this.bGarcom;
    }
    
    public BancoPedidos getBancoPedidos() {
    	return this.bancoPedidos;
    }
    
    public int qtdPedidosGarcom(int id) {
    	int qtdPedidos=0;
    
    	for(Pedido pedido: getBancoPedidos().getPedidos()) {
    		if(pedido.getGarcom().getId()==id) {
    			qtdPedidos++;
    		}
    	}
    	
    	return qtdPedidos;
    }
    
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Relatório dos Garçons");
    	topoLabel.setFont(fonte);
    	GroupLayout layout = new  GroupLayout(topoPanel);
    	topoPanel.setMinimumSize(new Dimension(1000, 400));
    	topoPanel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.CENTER)
    			.addComponent(topoLabel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    			.addComponent(topoLabel,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    			);
    	return topoPanel;
    }
    public JPanel criarPanel(String nomeL, int idGarcom) {

    	JPanel newPanel = new JPanel();
    	GroupLayout layout = new GroupLayout(newPanel);
    	newPanel.setLayout(layout);
    	newPanel.setBackground(Color.decode("#F2EED8"));
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
    	
    	JLabel nomeJLabel = new JLabel(nomeL);
    	
    	nomeJLabel.setFont(fonte);
    	JButton nomeButton = new JButton("Relatório");
    	nomeButton.setFont(fonte);
    	nomeButton.setBackground(Color.decode("#F29829"));
    	nomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (idGarcom < 0) {
                    JOptionPane.showMessageDialog(null, "Garcom inválido!!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Garcom garcom = bGarcom.buscarGarcom(idGarcom);
                    if (garcom != null) {
                    	JDialog dialog = new JDialog();
                    	dialog.getContentPane().setBackground(Color.BLUE);
                        JOptionPane.showMessageDialog(null, garcom.toString()+", Quantidade de pedidos:"
                                +qtdPedidosGarcom(garcom.getId()), "Relatório do Garçom", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Garçom não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
     	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addGroup(
    					layout.createSequentialGroup()
    					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)					
    					.addComponent(nomeJLabel)
    					.addComponent(nomeButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    					)

    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(nomeJLabel)
    					.addComponent(nomeButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return newPanel;
    }
    
    
	private JPanel gerarCorpoPanel() {
    	JPanel corpoPanel =  new JPanel();
    	GroupLayout layout = new GroupLayout(corpoPanel);
    	
    	corpoPanel.setLayout(layout);

        GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	if(this.getBancoGarcom()!=null) {
    		
            for (Garcom garcom : getBancoGarcom().getGarcons()) {
                JPanel painel = criarPanel(garcom.getName(), garcom.getId());

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


    
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setFont(fonte);
        voltarButton.setBackground(Color.decode("#F29829"));
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RelatorioGarcomInterface.this.setVisible(false);
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
    					
    					.addComponent(voltarButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    					)
    			
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(voltarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    
    private void initialize() {
        jframe = new JFrame("Relatórios dos Garçons");
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
    
    public RelatorioGarcomInterface(BancoGarcom bancoGarcom, BancoPedidos bancoPedidos) {
        this.bGarcom = bancoGarcom;
        this.bancoPedidos=bancoPedidos;
        
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
        

}
