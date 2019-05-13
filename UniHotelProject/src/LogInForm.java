import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;





public class LogInForm {

	private JFrame LogInFrame = new JFrame("Log In");
	private String userName = "";
	private String passCode = "";
	
	ArrayList<User> users;
	ArrayList<User> activeUsers;
	
	private JLabel logo = new JLabel("Log In:");
	private JLabel usernameL = new JLabel("Username:");
	private JLabel passwordL = new JLabel("Password:");
	private JLabel doNotHaveAnAccountL = new JLabel ("Do not have an account?");
	
	private JTextField usernameT = new JTextField();
	private JTextField passwordT = new JTextField();
	
	private JButton LogInBtn = new JButton("Log In");
	private JButton	doNotHaveAnAccountBtn = new JButton("Sign Up");
	
	public LogInForm(ArrayList<User> users, ArrayList<User> activeUsers)  {
		
		this.users = users;
		this.activeUsers = activeUsers;
		
		LogInFrame.setBounds(200,100,400,250);
		
		Container container = LogInFrame.getContentPane();
		container.setLayout(null);
		
				//Label bounds
		logo.setBounds(200, 5, 250, 30);
		
		doNotHaveAnAccountL.setBounds(150, 120, 250, 30);
		
		usernameL.setBounds(20, 30, 250, 30);
		
		passwordL.setBounds(20, 60, 250, 30);
		
		//TextField bounds
		usernameT.setBounds(100, 30, 250, 30);
		
		passwordT.setBounds(100, 60, 250, 30);
		
		//JButton bounds
		LogInBtn.setBounds(170,90,100,30);
		doNotHaveAnAccountBtn.setBounds(120,150,200,30);		
				
		//button listener
				
		LogInButtonListener listener = new LogInButtonListener();
		LogInBtn.addActionListener(listener);
		DoNotHaveAnAccountButtonListener listener2 = new DoNotHaveAnAccountButtonListener();
		doNotHaveAnAccountBtn.addActionListener(listener2);
		
		//add to container

		container.add(logo);
		container.add(usernameL);
		container.add(passwordL);
		container.add(doNotHaveAnAccountL);
		container.add(usernameT);
		container.add(passwordT);

		container.add(LogInBtn);
		container.add(doNotHaveAnAccountBtn);
		
		
		LogInFrame.setVisible(true);
		LogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public String getUserName() {
		return userName;
	}

	public String getPassCode() {
		return passCode;
}
	
	
	
	class LogInButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			userName = usernameT.getText();
			passCode = passwordT.getText();
			this.LogIn(users, activeUsers);
			LogInFrame.setVisible(false);
			LogInFrame.dispose();
		
		}
		

		
		public void LogIn(ArrayList<User> users,ArrayList<User> activeUsers)
		{	boolean logInSuccessful = false;
		
				
			
				//check if username and password match
				for (User u: users)
				{
					if (userName.equals(u.getUserName()))
						{
							if (passCode.equals(u.getPassCode()))
							{
								activeUsers.add(u);
								logInSuccessful = true;
								JOptionPane.showMessageDialog(LogInFrame, "Logged in as: " + u.getUserName()+ ".");
								break;
							}
						}
				
				}
				if (!logInSuccessful)
					this.WrongPasswordPopUp();
			
				
					
			}
		
		public void WrongPasswordPopUp()
		{
			JOptionPane.showMessageDialog(LogInFrame, "Username and password do not match");
		}
		}
	
	class DoNotHaveAnAccountButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			new SignUpForm(users, activeUsers);
			LogInFrame.setVisible(false);
			LogInFrame.dispose();
		}
	}
	}
	
