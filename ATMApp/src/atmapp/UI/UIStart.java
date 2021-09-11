package atmapp.UI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import atmapp.dbConnection.*;
public class UIStart extends JFrame{
	
	private DatabaseAccesClass db = new DatabaseAccesClass();
	//get dimension of the screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int screenWidth = (int)screenSize.getWidth();
	public int screenHeight = (int)screenSize.getHeight();
	
	public UIStart() {
		
		//setting things up for the mainScreen
		setSize(screenWidth, screenHeight);
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//setting up the uppertext
		add(upperText(), BorderLayout.NORTH);
		
		//Setting up the LOGIN form
		JLabel Login = new JLabel("Log In");
		Login.setSize(200,30);
		Login.setLocation(700,300);
		
		JTextField userName = new JTextField("username");
		userName.setSize(200,30);
		userName.setLocation(700,340);
		
		
		JPasswordField password = new JPasswordField("password");
		password.setSize(200,30);
		password.setLocation(700,380);
		
		JButton loginButton = new JButton("Log in");
		loginButton.setSize(100,30);
		loginButton.setLocation(700,420);
		
		
		//Setting up the Sign Up form
		JLabel signUp = new JLabel("Sign up");
		signUp.setSize(200,30);
		signUp.setLocation(700,460);
				
		JTextField newUserName = new JTextField("new username");
		newUserName.setSize(200,30);
		newUserName.setLocation(700,500);
		
		JTextField newLastName = new JTextField("new lastname");
		newLastName.setSize(200,30);
		newLastName.setLocation(700,540);
				
				
		JPasswordField newPassword = new JPasswordField(" new password");
		newPassword.setSize(200,30);
		newPassword.setLocation(700,580);
		
		JTextField newBalance = new JTextField("current balance");
		newBalance.setSize(200,30);
		newBalance.setLocation(700,620);
		
		JButton signUpButton = new JButton("sign up");
		signUpButton.setSize(100,30);
		signUpButton.setLocation(700,660);
		
		//action for signup and getting the data in the boxes plus
		//putting it in the banking database
		
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String name = newUserName.getText();
				String lastName = newLastName.getText();
				int balance = Integer.parseInt(newBalance.getText());
				
				try {
					db.insertInDatabase(name, lastName, balance);
				}catch(Exception e1) {
					System.out.println(e1);
				}
						
			}
		});
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userName.getText();
				String passw = password.getText();
				
				
				String userChek;
			}
		});
		
		
		//adding the form to the UI
		add(Login);
		add(userName);
		add(password);
		add(loginButton);
		
		add(signUp);
		add(newUserName);
		add(newLastName);
		add(newPassword);
		add(newBalance);
		add(signUpButton);
		
		//must be the last item
		setVisible(true);
		
	}
	
	
	//setting up the upperText JPanel
	public JPanel upperText() {
		
		JPanel upperText = new JPanel();
		upperText.setSize(screenWidth, 300);
		
		//creating the text 
		JLabel text = new JLabel("Welcome to this ATM please Log in or Sign up");
		text.setFont(new Font("Verdana", 1, 20));
		
		upperText.add(text);
		upperText.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
		 
		return upperText;
			
	}

}
