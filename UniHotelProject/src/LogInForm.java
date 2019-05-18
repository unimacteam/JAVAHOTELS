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
	User activeUser;
	private User userThatSendFromSignUp;
	
	private JLabel logo = new JLabel("Log In:");
	private JLabel usernameL = new JLabel("Username:");
	private JLabel passwordL = new JLabel("Password:");
	private JLabel doNotHaveAnAccountL = new JLabel ("Do not have an account?");
	
	private JTextField usernameT = new JTextField();
	private JTextField passwordT = new JTextField();
	
	private JButton LogInBtn = new JButton("Log In");
	private JButton	doNotHaveAnAccountBtn = new JButton("Sign Up");
	
	public LogInForm(ArrayList<User> users, User activeUser)  {
		
		this.users = users;
		this.activeUser = activeUser;
		
		if(activeUser==null) {
			
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
		else
		
			this.activeUser=activeUser;
		}
	

	public String getUserName() {
		return userName;
	}

	public String getPassCode() {
		return passCode;
	}
	
	class LogInButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			userName = usernameT.getText();
			passCode = passwordT.getText();
			
			if(this.LogIn(users, activeUser)) {
				
					LogInFrame.setVisible(false);
					LogInFrame.dispose();
			}
			
			//System.out.println(userName + " " + passCode);
		}
		
		public boolean LogIn(ArrayList<User> users, User currentUser) {	
			
			boolean logInSuccessful = false;
			boolean userFound = false;
			boolean passwdFound = false;
				
			//check if username and password match
			for(User u: users) {
				
				if(userName.equals(u.getUserName())) {
					
					userFound = true;
					
					if(passCode.equals(u.getPassCode())) {
						
						passwdFound = true;
						activeUser=u;
						logInSuccessful = true;
						JOptionPane.showMessageDialog(LogInFrame, "Logged in as: " + u.getUserName()+ ".");
						break;
					}
				}
				
			}
				
			if(!logInSuccessful) {
			
				if(!userFound) {
					
					WrongUsernamePopUp();
				}
				else {
					
					if(!passwdFound) {
						
						PasswdDoesntMatchUsernamePopUp();
					}
				}
			}
				
			return logInSuccessful;
		}
		
		public void WrongUsernamePopUp() {
			
			JOptionPane.showMessageDialog(LogInFrame, "Username didn't found");
		}
		
		public void PasswdDoesntMatchUsernamePopUp() {
			
			JOptionPane.showMessageDialog(LogInFrame, "Wrong password!");
		}
	}
	
	class DoNotHaveAnAccountButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			SignUpForm signUF = new SignUpForm(users);
			userThatSendFromSignUp = signUF.GetUserThatWantsToSignUp();
			LogInFrame.setVisible(false);
			LogInFrame.dispose();
		}
	}
	
	public User GetUserThatWantToSignUpFromLogInForm() {
		
			return userThatSendFromSignUp;
	}
}
	
	

	
