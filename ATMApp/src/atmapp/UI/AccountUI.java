package atmapp.UI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class AccountUI extends JFrame {
	
	//get dimension of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		public int screenWidth = (int)screenSize.getWidth();
		public int screenHeight = (int)screenSize.getHeight();
		
		public AccountUI(String name, int balance) {
			//setting things up for the mainScreen
			setSize(screenWidth, screenHeight);
			setBackground(Color.lightGray);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			
			//setting up the uppertext
			add(upperText(name), BorderLayout.NORTH);
			
			//displaying the balance
			JLabel balanceDisplay = new JLabel("your balance: $" + balance);
			balanceDisplay.setSize(200,30);
			balanceDisplay.setLocation(700,300);
			
			//setting up the transaction button
			JButton transactionButton = new JButton("Make new Transaction");
			transactionButton.setSize(200,30);
			transactionButton.setLocation(700,360);
			
			//adding components to the ui
			add(balanceDisplay);
			add(transactionButton);
			
			//always as last
			setVisible(true);
			
			
		}
		
		//setting up the upperText JPanel
		public JPanel upperText(String name) {
			
			JPanel upperText = new JPanel();
			upperText.setSize(screenWidth, 300);
			
			//creating the text 
			JLabel text = new JLabel("Welcome " + name);
			text.setFont(new Font("Verdana", 1, 20));
			
			upperText.add(text);
			upperText.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
			 
			return upperText;
				
		}

}
