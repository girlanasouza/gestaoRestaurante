package interfaces;

import banco.*;
import model.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RemoverItemInterface{
	private Cardapio cardapio;
    private int idItem=0;
    private ArrayList <Item> itens;
    private JFrame jframe;
    
    public ArrayList <Item>  getItens(){
        return this.itens;
    }


    public Cardapio getCardapio(){
        return this.cardapio;
    }

    public void setCardapio(Cardapio cardapio){
        this.cardapio=cardapio;
    }
    public void setIdItem(int id){
        this.idItem=id;
    }
    public int getIdItem(){
        return this.idItem;
    }    

    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Remover Item");
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
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	Font fonte2 = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
    	
    	JLabel topoLabel = new JLabel("Remocação de Itens");
    	topoLabel.setFont(fonte);
    	GroupLayout layout = new  GroupLayout(corpoPanel);
    	corpoPanel.setMinimumSize(new Dimension(1000, 400));
    	corpoPanel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
        GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
   	    
    	
    	ArrayList<Item> menu = RemoverItemInterface.this.cardapio.getCardapio();
        if(menu!=null) {
        	for(Item item :menu) {
        		JCheckBox checkBox = new JCheckBox(item.toString());
                checkBox.isBackgroundSet();
                checkBox.setBackground(Color.decode("#F29829"));
                checkBox.setFont(fonte2);
                checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
                checkBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        controlaPedido();
                    }
                    private void controlaPedido(){
                        if(checkBox.isSelected()){
                        	RemoverItemInterface.this.itens.add(item);
                        }else {
                        	RemoverItemInterface.this.itens.remove(item);
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
        JButton removerGarcomButton = new JButton("Remover");
        removerGarcomButton.setBackground(Color.decode("#F29829"));
        removerGarcomButton.setFont(fonte);
        removerGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(getItens().size()!=0) {
                    if(getItens()!=null) {
                    	for(Item i:getItens()) {
                    		RemoverItemInterface.this.getCardapio().removeItem(i.getId());
                    	}
                    }
                    
                    JOptionPane.showMessageDialog(null,"Item Removido com Sucesso");
                    RemoverItemInterface.this.setVisible(false);
            	}
            	else {
            		JOptionPane.showMessageDialog(null,"Selecione um item","Error", JOptionPane.ERROR_MESSAGE);
            	}

            }
        });
        
        JButton voltarButton = new JButton("Menu");
        voltarButton.setBackground(Color.decode("#F29829"));
        voltarButton.setFont(fonte);
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RemoverItemInterface.this.setVisible(false);
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
    					.addComponent(voltarButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					
    					.addComponent(removerGarcomButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					)

    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)

    					.addComponent(voltarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(removerGarcomButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    
    
    private void initialize() {
        jframe = new JFrame("Remover Item");
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
        
    
    public RemoverItemInterface(Cardapio cardapio) {
        this.cardapio = cardapio;
        this.itens=new  ArrayList <Item>();
   
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
    

}
