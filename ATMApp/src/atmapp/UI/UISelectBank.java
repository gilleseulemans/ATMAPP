package atmapp.UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class UISelectBank extends JFrame{
	
	//get dimension of the screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int screenWidth = (int)screenSize.getWidth();
	public int screenHeight = (int)screenSize.getHeight();
	
	//Creating a jPanel for displaying the text 
	
	
	
	public UISelectBank() {
		
		//setting things up for the mainScreen
		setSize(screenWidth, screenHeight);
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//adding the upperText JPanel
		add(upperText(), BorderLayout.NORTH);
		
		
		//adding all the bankButtons needed
		JButton bankButton1 = new JButton("ING");
		bankButton1.setSize(100,50);
		bankButton1.setLocation(300,300);
		
		JButton bankButton2 = new JButton("KBC");
		bankButton2.setSize(100,50);
		bankButton2.setLocation(700,300);
		
		JButton bankButton3 = new JButton("Belfius");
		bankButton3.setSize(100,50);
		bankButton3.setLocation(1100,300);
		
		//adding all buttons
		add(bankButton1);
		add(bankButton2);
		add(bankButton3);
		
		//must be the last item
		setVisible(true);
	
	}
	
	
	//setting up the upperText JPanel
	public JPanel upperText() {
		
		JPanel upperText = new JPanel();
		upperText.setSize(screenWidth, 300);
		
		//creating the text 
		JLabel text = new JLabel("Welcome to this ATM please select your bank");
		text.setFont(new Font("Verdana", 1, 20));
		
		upperText.add(text);
		upperText.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
		 
		return upperText;
			
	}
	
	
	
	
	
	
}
