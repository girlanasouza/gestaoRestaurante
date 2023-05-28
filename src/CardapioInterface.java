import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CardapioInterface extends JFrame {
	
	public CardapioInterface() {
		super("Cardápio");
		Color cor = new Color(255, 229, 153);
		setLayout(null);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Cardápio");
		title.setBounds(0, 10, 500, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);

		JButton bMenu = new JButton("Cardápio");
		bMenu.setBounds(20, 55, 220, 25);
		bMenu.setBackground(cor);
		add(bMenu);

		bMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Jedi Academy v1.0 !!");
			}
		});

		setVisible(true);
	}

}
