package interfaces;

import banco.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CadastrarMesaInterface{
	private BancoMesas bancoMesas;   
	private JFrame jframe;
	private JTextField numeroField;
	
    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Cadastrar Mesa");
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
    	
 
    	PanelTField numMesaPanel = gerarComponente("Número mesa");
    	this.setNumeroField(numMesaPanel.tField);
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addComponent(numMesaPanel.panel)
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    			.addComponent(numMesaPanel.panel)
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
            	CadastrarMesaInterface.this.setVisible(false);
               
            }
        });
        
    	JButton cadastrarMesaButton = new JButton("Cadastrar Mesa");
    	cadastrarMesaButton.setFont(fonte);
    	cadastrarMesaButton.setBackground(Color.decode("#F29829"));
    	cadastrarMesaButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        String numeroMesa = CadastrarMesaInterface.this.getNumeroField().getText();
    	        if (numeroMesa.isEmpty()) {
    	            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Error", JOptionPane.ERROR_MESSAGE);
    	        } else {
    	            try {
    	                int numMesa = Integer.parseInt(numeroMesa);
    	                if (numMesa <= 0) {
    	                    JOptionPane.showMessageDialog(null, "O número da mesa deve ser maior que zero!", "Error", JOptionPane.ERROR_MESSAGE);
    	                    return;
    	                }
    	               
    	                if(CadastrarMesaInterface.this.bancoMesas.buscarMesaNumero(numMesa)==null) {
        	                Mesa mesa = new Mesa(numMesa);
        	                CadastrarMesaInterface.this.bancoMesas.addMesa(mesa);
        	                getNumeroField().setText("");
        	                JOptionPane.showMessageDialog(null, "Mesa cadastrada com sucesso!");
        	                CadastrarMesaInterface.this.setVisible(false);
    	                }else {
    	                	 JOptionPane.showMessageDialog(null, "Mesa já está cadastrada, por favor digite outro valor!");
         	                
    	                }

    	            } catch (NumberFormatException ex) {
    	                JOptionPane.showMessageDialog(null, "O número da mesa deve ser um valor inteiro!", "Error", JOptionPane.ERROR_MESSAGE);
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
    					.addComponent(cadastrarMesaButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					)
    			
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(cadastrarMesaButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
    }
    
    private void initialize() {
        jframe = new JFrame("Cadastrar Mesa");
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
    
    public CadastrarMesaInterface(BancoMesas bancoMesas){
        
        this.bancoMesas=bancoMesas;

        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }


	public JTextField getNumeroField() {
		return numeroField;
	}
	public void setNumeroField(JTextField numeroField) {
		this.numeroField = numeroField;
	}

	private class PanelTField{
    	public JPanel panel;
    	public JTextField tField;
    	
    	
    }
    

}
