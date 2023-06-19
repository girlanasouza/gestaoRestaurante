package interfaces;

import banco.*;
import model.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RemoverGarcomInterface{
    private BancoGarcom bGarcom;
    private ArrayList <Garcom> garcons;
    private int idGarcom;
    private JFrame jframe;
    
    public ArrayList <Garcom> getGarcons(){
    	return this.garcons;
    }
    public void setGarcons(ArrayList <Garcom> garcons){
    	this.garcons=garcons;
    }
    
    public void setIdGarcom(int id){
        this.idGarcom=id;
    }
    public int getIdGarcom(){
        return this.idGarcom;
    }

    public BancoGarcom getBancoGarcom() {
        return this.bGarcom;
    }
    
    	
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Remover Garçom");
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
    	
    	JLabel topoLabel = new JLabel("Remocação de Garçons");
    	topoLabel.setFont(fonte);
    	GroupLayout layout = new  GroupLayout(corpoPanel);
    	corpoPanel.setMinimumSize(new Dimension(1000, 400));
    	corpoPanel.setLayout(layout);
    	
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
        GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
   	    
    	
        ArrayList<Garcom> bancGarcom = RemoverGarcomInterface.this.bGarcom.getGarcons();
        
        if(bancGarcom!=null) {
        	for(Garcom garcom:bancGarcom) {
        		JCheckBox checkBox = new JCheckBox(garcom.toString());
                checkBox.isBackgroundSet();
                checkBox.setFont(fonte2);
                checkBox.setBackground(Color.decode("#F29829"));
                checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
                checkBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        controlaPedido();
                    }
                    private void controlaPedido(){
                        if(checkBox.isSelected()){
                        	RemoverGarcomInterface.this.garcons.add(garcom);
                        }else{
                        	RemoverGarcomInterface.this.garcons.remove(garcom);
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
			if(getGarcons().size()!=0) {
				if(getGarcons()!=null) {
	            	for(Garcom g:getGarcons()) {
	            		RemoverGarcomInterface.this.getBancoGarcom().removeWaiter(g.getId());
	            	}
	            }
				getBancoGarcom().atualizarGarcons();
	            JOptionPane.showMessageDialog(null,"Garçom Removido com Sucesso");
	            RemoverGarcomInterface.this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null,"Por favor, selecione um garçom", "Error", JOptionPane.ERROR_MESSAGE);
			}
		
		}
        });
        
        JButton voltarButton = new JButton("Menu");
        voltarButton.setBackground(Color.decode("#F29829"));
        voltarButton.setFont(fonte);
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RemoverGarcomInterface.this.setVisible(false);
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
        jframe = new JFrame("Remover Garçom");
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

    public RemoverGarcomInterface(BancoGarcom bancoGarcom) {
        this.bGarcom = bancoGarcom;
        this.garcons=new ArrayList <Garcom>();
   
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
    

}
