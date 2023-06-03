// import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FechamentoContaInterface extends javax.swing.JFrame {
	private Cardapio cardapio;

	public Cardapio getCardapio(){
		return this.cardapio;
	}

	public FechamentoContaInterface(Cardapio cardapio){
		super("Fechamento de Conta");
		setLayout(null);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel title = new JLabel("Fechamento de conta");
		title.setBounds(0, 10, 500, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);

		JButton bMenu = new JButton("Menu", null);
		bMenu.setBounds(20, 55, 220, 25);
		add(bMenu);
		

		bMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CardapioInterface menuInterface = new CardapioInterface(cardapio);
			menuInterface.setVisible(true);
			}
		});
		

		setVisible(true);
	}
}
