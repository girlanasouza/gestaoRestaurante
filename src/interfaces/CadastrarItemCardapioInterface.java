package interfaces;

import banco.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CadastrarItemCardapioInterface {
    private Cardapio cardapio;
    private JFrame jframe;
    private JTextField nomeField, descField, valorField;
    
    public Cardapio getCardapio(){
        return this.cardapio;
    }

    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Cadastrar Item");
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
    
    private JPanel gerarRodapePanel() {
    	JPanel rodapePanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);

    	JButton menuButton = new JButton("Menu");
    	menuButton.setFont(fonte);
    	menuButton.setBackground(Color.decode("#F29829"));
    	menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarItemCardapioInterface.this.setVisible(false);
               
            }
        });
        
    	JButton cadastrarButton = new JButton("Cadastrar");
    	cadastrarButton.setFont(fonte);
    	cadastrarButton.setBackground(Color.decode("#F29829"));
    	cadastrarButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        String nome = CadastrarItemCardapioInterface.this.getNomeField().getText();
    	        String descricao = CadastrarItemCardapioInterface.this.getDescField().getText();
    	        String valorText = CadastrarItemCardapioInterface.this.getValorField().getText();

    	        if (nome.isEmpty() || descricao.isEmpty() || valorText.isEmpty()) {
    	            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Error", JOptionPane.ERROR_MESSAGE);
    	        } else if (nome.matches(".*\\d.*")) {
    	            JOptionPane.showMessageDialog(null, "O nome não pode conter números!", "Error", JOptionPane.ERROR_MESSAGE);
    	        } else if (descricao.matches(".*\\d.*")) {
    	            JOptionPane.showMessageDialog(null, "A descrição não pode conter números!", "Error", JOptionPane.ERROR_MESSAGE);
    	        } else {
    	            try {
    	                double valor = Double.parseDouble(valorText);
    	                if (valor <= 0) {
    	                    JOptionPane.showMessageDialog(null, "O valor deve ser maior que zero!", "Error", JOptionPane.ERROR_MESSAGE);
    	                    return;
    	                }

    	                Item item = new Item(nome, descricao, valor);
    	                cardapio.addItem(item);
    	                CadastrarItemCardapioInterface.this.getNomeField().setText("");
    	                CadastrarItemCardapioInterface.this.getDescField().setText("");
    	                CadastrarItemCardapioInterface.this.getValorField().setText("");

    	                JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");

    	                CadastrarItemCardapioInterface.this.setVisible(false);
    	            } catch (NumberFormatException ex) {
    	                JOptionPane.showMessageDialog(null, "O valor deve ser numérico!", "Error", JOptionPane.ERROR_MESSAGE);
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
    					.addComponent(cadastrarButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    					)
    			
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(menuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(cadastrarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)
    			
    			);
    	return rodapePanel;
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
    	
    	PanelTField nomeItemPanel = gerarComponente("Nome item");
    	this.setNomeField(nomeItemPanel.tField);
    	PanelTField descItemPanel = gerarComponente("Descrição item");
    	this.setDescField(descItemPanel.tField);
    	PanelTField valorItemPanel = gerarComponente("Valor item");
    	this.setValorField(valorItemPanel.tField);
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addComponent(nomeItemPanel.panel)
    			.addComponent(descItemPanel.panel)
    			.addComponent(valorItemPanel.panel)
    				
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup()
    			.addComponent(nomeItemPanel.panel)
    			.addComponent(descItemPanel.panel)
    			.addComponent(valorItemPanel.panel)
    			);
    	
    	
    	return corpoPanel;
		
	}
    private void initialize() {
        jframe = new JFrame("Cadastrar Item");
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


    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }

    public CadastrarItemCardapioInterface(Cardapio cardapio) {
        this.cardapio = cardapio;
        
        initialize();
       
    }
    public JTextField getNomeField() {
		return nomeField;
	}
	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}
	public JTextField getDescField() {
		return descField;
	}
	public void setDescField(JTextField descField) {
		this.descField = descField;
	}
	public JTextField getValorField() {
		return valorField;
	}
	public void setValorField(JTextField valorField) {
		this.valorField = valorField;
	}
	private class PanelTField{
    	public JPanel panel;
    	public JTextField tField;
    	
    	
    }
    

}

