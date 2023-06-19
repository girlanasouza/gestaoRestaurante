package interfaces;

import banco.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AlterarGarcomInterface {
    private BancoGarcom bancoGarcom;
    private Garcom garcom;
    private JTextField nomeField, endField;
    
	private JFrame jframe;

    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Alterar Garçom");
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
    	
 
    	PanelTField nomeGarcomPanel = gerarComponente("Nome Garçom");
    	this.setNomeField(nomeGarcomPanel.tField);
    	PanelTField endGarcomPanel = gerarComponente("Endereço do Garçom");
    	this.setEndField(endGarcomPanel.tField);
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addComponent(nomeGarcomPanel.panel)
    			.addComponent(endGarcomPanel.panel)
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    			.addComponent(nomeGarcomPanel.panel)
    			.addComponent(endGarcomPanel.panel)
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
            	AlterarGarcomInterface.this.setVisible(false);
               
            }
        });
    	

    	JButton alterarButton = new JButton("Alterar");
    	alterarButton.setFont(fonte);
    	alterarButton.setBackground(Color.decode("#F29829"));
    	alterarButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	
    	    	if(AlterarGarcomInterface.this.getNomeField().getText().isEmpty()||AlterarGarcomInterface.this.getEndField().getText().isEmpty()) {
        	    	JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos", "Error", JOptionPane.ERROR_MESSAGE);
    	    	}else if (AlterarGarcomInterface.this.getNomeField().getText().matches(".*\\d.*")) {
    	            JOptionPane.showMessageDialog(null, "O nome não pode conter números!", "Error", JOptionPane.ERROR_MESSAGE);
    	        } else if (AlterarGarcomInterface.this.getEndField().getText().matches(".*\\d.*")) {
    	            JOptionPane.showMessageDialog(null, "O endereço não pode conter números!", "Error", JOptionPane.ERROR_MESSAGE);
    	        } 
    	    	else {
    	    		getBancoGarcom().buscarGarcom(getGarcom().getId()).setName(AlterarGarcomInterface.this.getNomeField().getText());
        	    	

        	    	getBancoGarcom().buscarGarcom(getGarcom().getId()).setAddress(AlterarGarcomInterface.this.getEndField().getText());
        	    	

        	    	
        	    	getBancoGarcom().atualizarGarcom(getGarcom().getId());
        	    	
        	    	getNomeField().setText("");
        	    	
        	    	getEndField().setText("");
        	    	
        	    	
        	    	JOptionPane.showMessageDialog(null, "Garçom Alterado com Sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);

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
        jframe = new JFrame("Alterar Garçom");
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
        
    
    public AlterarGarcomInterface(BancoGarcom bancoGarcom, Garcom garcom) {
        this.setBancoGarcom(bancoGarcom);
        this.setGarcom(garcom);
        initialize();   
    }
    
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    public JTextField getNomeField() {
		return nomeField;
	}
	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	private class PanelTField{
    	public JPanel panel;
    	public JTextField tField;
    	
    	
    }

    public BancoGarcom getBancoGarcom() {
        return this.bancoGarcom;
    }

	public JTextField getEndField() {
		return endField;
	}

	public void setEndField(JTextField endField) {
		this.endField = endField;
	}

	public void setBancoGarcom(BancoGarcom bancoGarcom) {
		this.bancoGarcom = bancoGarcom;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
    

}
