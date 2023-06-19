package interfaces;

import banco.*;
import model.*;




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelecionarGarcomInterface {
    private BancoGarcom bancoGarcom;
	private JFrame jframe;
	private Garcom garcom;

    public BancoGarcom getBancoGarcom() {
        return this.bancoGarcom;
    }
    
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Alteração de Garçom");
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
    	
        GroupLayout.ParallelGroup horizontalGroupMesas = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        GroupLayout.SequentialGroup verticalGroupMesas = layout.createSequentialGroup();

        
        JLabel labelMesa = new JLabel("Escolha um Garçom");
        labelMesa.setFont(fonte);
  
        horizontalGroupMesas.addComponent(labelMesa);

        verticalGroupMesas.addComponent(labelMesa);

        ButtonGroup checkBoxGroupMesa = new ButtonGroup();
      
        if (getBancoGarcom().getGarcons() != null) {
            for (Garcom garcom : getBancoGarcom().getGarcons()) {
				JRadioButton radioButton = new JRadioButton(garcom.toString());
				radioButton.setBackground((Color.decode("#F29829")));
				radioButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				radioButton.setFont(fonte);
				checkBoxGroupMesa.add(radioButton);
				
				horizontalGroupMesas.addComponent(radioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
				
				verticalGroupMesas.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE);
				
				radioButton.addItemListener(new ItemListener() {
				    @Override
				    public void itemStateChanged(ItemEvent e) {
				    	SelecionarGarcomInterface.this.setGarcom(garcom);
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
                SelecionarGarcomInterface.this.setVisible(false);
               
            }
        });
        

        JButton alterarPedidoButton = new JButton("Alterar");
        alterarPedidoButton.setFont(fonte);
        alterarPedidoButton.setBackground(Color.decode("#F29829"));
        alterarPedidoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(getGarcom()!=null) {
            	   AlterarGarcomInterface alterarGarcomInterface = new AlterarGarcomInterface(getBancoGarcom(), getGarcom());
                   alterarGarcomInterface.setVisible(true);
                   SelecionarGarcomInterface.this.setVisible(false);
               }else {
                   JOptionPane.showMessageDialog(null, "Por favor, selecione um Garçom", "Error", JOptionPane.ERROR_MESSAGE);
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
    					.addComponent(alterarPedidoButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					)
    			
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(alterarPedidoButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    private void initialize() {
        jframe = new JFrame("Alterar Garçom");
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
    	
    }
    public SelecionarGarcomInterface(BancoGarcom bancoGarcom){
        this.bancoGarcom=bancoGarcom;
        initialize(); 
    }

    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }

	public Garcom getGarcom() {
		return garcom;
	}


	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
    

    

}
