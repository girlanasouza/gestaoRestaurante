package interfaces;

import banco.*;
import model.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GerirGarcomInterface{
	private BancoGarcom bGarcom;
    private Garcom garcom;
    private BancoPedidos bancoPedidos;
    private JFrame jframe;

    public BancoGarcom getBancoGarcom() {
        return this.bGarcom;
    }

    public Garcom getGarcom(){
        return this.garcom;
    }
	
    private JPanel gerarTopoPanel() {
    	JPanel topoPanel = new JPanel();
    	Font fonte = new Font("Noto Serif CJK SC", Font.BOLD, 30);
    	JLabel topoLabel = new JLabel("Gerenciar Garçom");
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
    	
   
    	JButton cadastrarButton = new JButton("Cadastrar Garçom");
    	cadastrarButton.setFont(fonte);
    	cadastrarButton.setBackground(Color.decode("#F29829"));
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarGarcomInterface cadastrarGarcomInterface = new CadastrarGarcomInterface(bGarcom);
                GerirGarcomInterface.this.setVisible(false);
                cadastrarGarcomInterface.setVisible(true);
                
            }
        });
    
        JButton removerButton = new JButton("Remover Garçom");
        removerButton.setFont(fonte);
        removerButton.setBackground(Color.decode("#F29829"));
        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoverGarcomInterface removerGarcomInterface = new RemoverGarcomInterface(bGarcom);
                removerGarcomInterface.setVisible(true);
                GerirGarcomInterface.this.setVisible(false);
            }
        });

        
        JButton alterarButton = new JButton("Alterar Garçom");
        alterarButton.setFont(fonte);
        alterarButton.setBackground(Color.decode("#F29829"));
        alterarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelecionarGarcomInterface selecionarGarcomInterface = new SelecionarGarcomInterface(getBancoGarcom());
                selecionarGarcomInterface.setVisible(true);
                GerirGarcomInterface.this.setVisible(false);
            }
        });
        
        JButton relatorioButton = new JButton("Relatórios");
        relatorioButton.setFont(fonte);
        relatorioButton.setBackground(Color.decode("#F29829"));
        relatorioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	RelatorioGarcomInterface relatorioGarcomInterface = new RelatorioGarcomInterface(GerirGarcomInterface.this.getBancoGarcom(),GerirGarcomInterface.this.getBancoPedidos());
            	relatorioGarcomInterface.setVisible(true);
            	GerirGarcomInterface.this.setVisible(false);
            }
        });
        
        JButton imprimirBancoGarcomButton = new JButton("Imprimir Garçons");
        imprimirBancoGarcomButton.setFont(fonte);
        imprimirBancoGarcomButton.setBackground(Color.decode("#F29829"));
        imprimirBancoGarcomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, getBancoGarcom().getDrescribe());
            }
        });

        JButton voltarMenu = new JButton("Menu");
        voltarMenu.setFont(fonte);
        voltarMenu.setBackground(Color.decode("#F29829"));
        voltarMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	GerirGarcomInterface.this.setVisible(false);
                
            }
        });
        
    	
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addGroup(
    					layout.createSequentialGroup()
    					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)		
    					.addComponent(cadastrarButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					.addComponent(removerButton,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
    					.addComponent(alterarButton,GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
    					.addComponent(relatorioButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    					.addComponent(imprimirBancoGarcomButton,GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
    					.addComponent(voltarMenu,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    					)	
    			);
    	layout.setVerticalGroup(
    			layout.createSequentialGroup().addGroup(
    					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(cadastrarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(removerButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(alterarButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(relatorioButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)

    					.addComponent(imprimirBancoGarcomButton,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
    					.addComponent(voltarMenu,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)

    					)				
    			);
    	
    	
    	return corpoPanel;
		
	}
    
    private void initialize() {
        jframe = new JFrame("Gerenciar Garçom");
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
    
    public GerirGarcomInterface(BancoGarcom bancoGarcom, BancoPedidos bancoPedidos) {
        this.bGarcom=bancoGarcom;
        this.bancoPedidos=bancoPedidos;
        initialize();
       
        
    }
    public void setVisible(boolean b) {
    	jframe.setVisible(b);
    }
    
	public BancoPedidos getBancoPedidos() {
		return bancoPedidos;
	}

	public void setBancoPedidos(BancoPedidos bancoPedidos) {
		this.bancoPedidos = bancoPedidos;
	}

    

}
