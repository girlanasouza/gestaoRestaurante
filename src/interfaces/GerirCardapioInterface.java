package interfaces;

import banco.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GerirCardapioInterface{
	private Cardapio cardapio;
	private JFrame jframe;
	
	
	public Cardapio getCardapio(){
        return this.cardapio;
    }
	
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Gerenciar Cardápio");
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
    	JPanel corpoPanel =  new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.PLAIN, 18);
    	
    	GroupLayout layout = new  GroupLayout(corpoPanel);
    	
    	corpoPanel.setLayout(layout);
    
    	layout.setAutoCreateContainerGaps(true);
    	
    	layout.setAutoCreateGaps(true);
    	
    	JButton cadastrarItemButton = new JButton("Cadastrar");
    	cadastrarItemButton.setFont(fonte);
    	cadastrarItemButton.setBackground(Color.decode("#F29829"));
    	cadastrarItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				CadastrarItemCardapioInterface cadastrarCardapioInterface = new CadastrarItemCardapioInterface(GerirCardapioInterface.this.getCardapio());
                cadastrarCardapioInterface.setVisible(true);
                GerirCardapioInterface.this.setVisible(false);
            }
        });
    	
    
    	JButton removerItemButton = new JButton("Remover item");
    	removerItemButton.setFont(fonte);
    	removerItemButton.setBackground(Color.decode("#F29829"));
        removerItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverItemInterface removerItemInterface = new RemoverItemInterface(GerirCardapioInterface.this.getCardapio());
            	removerItemInterface.setVisible(true);
                
            }
        });
        
        JButton alterarItem = new JButton("Alterar item");
        alterarItem.setFont(fonte);
        alterarItem.setBackground(Color.decode("#F29829"));
        alterarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SelecionarItemInterface selecionarItemInterface = new SelecionarItemInterface(getCardapio());
            	selecionarItemInterface.setVisible(true);
				GerirCardapioInterface.this.setVisible(false);
                
            }
        });
        
        JButton voltarMenu = new JButton("Voltar ao menu");
        voltarMenu.setFont(fonte);
        voltarMenu.setBackground(Color.decode("#F29829"));
        voltarMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				GerirCardapioInterface.this.setVisible(false);
                
            }
        });
        
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addGroup(
    					layout.createSequentialGroup()
    					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)					
    					.addComponent(cadastrarItemButton,GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
    					.addComponent(removerItemButton,GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
    					.addComponent(alterarItem,GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
    					.addComponent(voltarMenu,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					)	
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(cadastrarItemButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(removerItemButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(alterarItem,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(voltarMenu,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)			
    			);
    	
    	
    	return corpoPanel;
		
	}
    
    private void initialize() {
        jframe = new JFrame("Gerenciamento do Cardápio");
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

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(topoPanel)
                        .addComponent(corpoPanel)

        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(topoPanel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addComponent(corpoPanel, GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE)
        );

        jframe.add(jPanel);
    	
    }
    
    public GerirCardapioInterface(Cardapio cardapio) {
		this.cardapio=cardapio;
	
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
}
