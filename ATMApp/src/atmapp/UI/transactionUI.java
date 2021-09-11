package atmapp.UI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class transactionUI extends JFrame{
	
	//get dimension of the screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int screenWidth = (int)screenSize.getWidth();
	public int screenHeight = (int)screenSize.getHeight();
	
	public transactionUI() {
		
		//setting things up for the mainScreen
		setSize(screenWidth, screenHeight);
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//setting up the uppertext
		add(upperText(), BorderLayout.NORTH);
		
		//Setting up the transaction form
		JLabel amount = new JLabel("Amount");
		amount.setSize(200,30);
		amount.setLocation(700,300);
		
		JTextField money = new JTextField("give the amount");
		money.setSize(200,30);
		money.setLocation(700,340);
		
		JLabel person = new JLabel("To which person?");
		person.setSize(200,30);
		person.setLocation(700,380);
		
		JTextField name = new JTextField("name");
		name.setSize(200,30);
		name.setLocation(700,420);
				
		//setting up the transactionButton
		JButton transactionButton = new JButton("make transaction");
		transactionButton.setSize(150,30);
		transactionButton.setLocation(700,460);
		
		
		//adding the form to the UI
		add(amount);
		add(money);
		add(person);
		add(name);
		add(transactionButton);

		
		//must be the last item
		setVisible(true);
		
	}
	
	
	//setting up the upperText JPanel
	public JPanel upperText() {
		
		JPanel upperText = new JPanel();
		upperText.setSize(screenWidth, 300);
		
		//creating the text 
		JLabel text = new JLabel("Maka a transaction");
		text.setFont(new Font("Verdana", 1, 20));
		
		upperText.add(text);
		upperText.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
		 
		return upperText;
			
	}

}