// import java.awt.Color;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import javax.swing.*;


public class MenuInterface extends JFrame{
	private Cardapio cardapio;

	public Cardapio getCardapio(){
		return this.cardapio;
	}
	
	public MenuInterface() {
		super("Cadárpio");
		setLayout(null);
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel title = new JLabel("Cardápio");
		title.setBounds(0, 10, 500, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);
        
        
		
	}

}
