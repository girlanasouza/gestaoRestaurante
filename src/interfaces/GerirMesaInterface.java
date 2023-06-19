package interfaces;

import banco.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GerirMesaInterface{
	private BancoMesas bancoMesas;
	private  JFrame jframe;

    public void setBancoMesas(BancoMesas bancoMesas){
        this.bancoMesas=bancoMesas;
    }
    public BancoMesas getBancoMesas(){
        return this.bancoMesas;
    }
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Gerenciar Mesas");
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
    	
        
        JButton cadastrarButton = new JButton("Cadastrar Mesa");    	
        cadastrarButton.setFont(fonte);
    	cadastrarButton.setBackground(Color.decode("#F29829"));
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarMesaInterface cadastrarMesaInterface = new CadastrarMesaInterface(getBancoMesas());
                
                cadastrarMesaInterface.setVisible(true);
            }
        });
            
        JButton removerButton = new JButton("Remover Mesa");
        removerButton.setFont(fonte);
        removerButton.setBackground(Color.decode("#F29829"));
        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 RemoverMesaInterface removerGarcomInterface = new RemoverMesaInterface(getBancoMesas());
                 removerGarcomInterface.setVisible(true);
            }
        });
        
        
        JButton alterarButton = new JButton("Alterar Mesa");      
        alterarButton.setFont(fonte);
        alterarButton.setBackground(Color.decode("#F29829"));
        alterarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SelecionarMesaInterface selecionarMesaInterface = new SelecionarMesaInterface(getBancoMesas());
            	selecionarMesaInterface.setVisible(true);

            	GerirMesaInterface.this.setVisible(false);
            }
        });
        
        JButton voltaMenuButton = new JButton("Voltar Menu");
        voltaMenuButton.setFont(fonte);
        voltaMenuButton.setBackground(Color.decode("#F29829"));
        voltaMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	GerirMesaInterface.this.setVisible(false);
            }
        });
        
        

    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addGroup(
    					layout.createSequentialGroup()
    					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)		
    					.addComponent(cadastrarButton,GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
    					.addComponent(removerButton,GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
    					.addComponent(alterarButton,GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
    					.addComponent(voltaMenuButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					)	
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(cadastrarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(removerButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(alterarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(voltaMenuButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					)				
    			);
    	
    	
    	return corpoPanel;
		
	}
    
    private void initialize() {
        jframe = new JFrame("Gerenciamento de Mesa");
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
    
    public GerirMesaInterface(BancoMesas bancoMesas) {
        this.bancoMesas=bancoMesas;
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
}
