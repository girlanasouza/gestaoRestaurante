import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;



public class GerirCardapioInterface extends JFrame{
	private Cardapio cardapio;
	public Cardapio getCardapio(){
        return this.cardapio;
    }
	public GerirCardapioInterface(Cardapio cardapio) {
		super("Gerenciamento de Cardápio");
		this.cardapio=cardapio;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension maxSize = new Dimension(500, 800);
        setSize(maxSize);
        setPreferredSize(maxSize);
        setResizable(true);
        
        Color corTopo = new Color(173,216,230);
        Color corCorpo = new Color (245,255,250);
		
		JPanel topoPanel = new JPanel();
        topoPanel.setBackground(corTopo);

        JLabel topoLabel = new JLabel("Tela de Cadastro de Gerenciamento de Cardápio");
        topoLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        

        JPanel corpoPanel = new JPanel();
        corpoPanel.setSize(500, 500);
        corpoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        corpoPanel.setBackground(corCorpo);
        
        JPanel rodapePanel = new JPanel();
        rodapePanel.setBackground(Color.RED);
        rodapePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rodapePanel.setBackground(corCorpo);

		JButton cadastrarItemButton = new JButton("Cadastrar item");
//		cadastrarItemButton.setBackground(corTopo);
//		cadastrarItemButton.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        cadastrarItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				CadastrarItemCardapioInterface cadastrarCardapioInterface = new CadastrarItemCardapioInterface(GerirCardapioInterface.this.getCardapio());
                cadastrarCardapioInterface.setVisible(true);
                
            }
        });

		JButton removerItemButton = new JButton("Remover item");
        removerItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				GerirCardapioInterface.this.setVisible(false);
                
            }
        });

		JButton alterarItem = new JButton("Alterar item");
        alterarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				GerirCardapioInterface.this.setVisible(false);
                
            }
        });

		JButton voltarMenu = new JButton("Voltar ao menu");
        voltarMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				GerirCardapioInterface.this.setVisible(false);
                
            }
        });

		topoPanel.add(topoLabel);

		corpoPanel.add(cadastrarItemButton);
		corpoPanel.add(removerItemButton);
		corpoPanel.add(alterarItem);

		rodapePanel.add(voltarMenu);

		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topoPanel, BorderLayout.NORTH);
        getContentPane().add(corpoPanel, BorderLayout.CENTER);
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);

		setLocationRelativeTo(null);
        setVisible(true);
        
		
	}

}
