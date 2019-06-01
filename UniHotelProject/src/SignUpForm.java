import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

//GUI, might want to change
//source: https://github.com/mitchtabian/JavaTutorial10/blob/master/this.java
public class SignUpForm {
	private JFrame signUpFrame = new JFrame("Sign Up");
	private String userName = "";
	private String passCode = "";
	private String email = "";
	private String name = "";
	private String surname = "";
	
	ArrayList<User> users;
	//User activeUser;
	private User userWantToSignUp;
	
	private JLabel logo = new JLabel("Sign Up:");
	private JLabel haveAnAccountL = new JLabel ("Already have an account?");
	
	private JLabel usernameL = new JLabel("Username:");
	private JLabel passwordL = new JLabel("Password:");
	private JLabel emailL = new JLabel("E-Mail:");
	private JLabel nameL = new JLabel("Name:");
	private JLabel surnameL = new JLabel("Family name:");
	
	private JTextField usernameT = new JTextField();
	private JTextField passwordT = new JTextField();
	private JTextField emailT = new JTextField("e.g. someone@somemail.com");
	private JTextField nameT = new JTextField("e.g. John");
	private JTextField surnameT = new JTextField("e.g. Doe");
	
	private JButton	haveAnAccountBtn = new JButton("Log In");
	private JButton SignUpBtn = new JButton("Complete Registration");



	public SignUpForm(ArrayList<User> users) {
		
		this.users = users;
		//this.activeUsers = activeUsers;
		
		signUpFrame.setBounds(200,100,400,350);
		
		Container container = signUpFrame.getContentPane();
		container.setLayout(null);
		
	
		
		//Label bounds
		logo.setBounds(180, 5, 250, 30);
		
		usernameL.setBounds(20, 30, 250, 30);
		
		passwordL.setBounds(20, 60, 250, 30);
		
		
		emailL.setBounds(20, 90, 250, 30);
		
		
		nameL.setBounds(20, 120, 250, 30);
		

		surnameL.setBounds(20, 150, 250, 30);
		
		haveAnAccountL.setBounds(150, 210, 250, 30);
		//TextField bounds
		
		
		usernameT.setBounds(100, 30, 250, 30);
		
	
		passwordT.setBounds(100, 60, 250, 30);
		
		emailT.setBounds(100, 90, 250, 30);
		
		nameT.setBounds(100, 120, 250, 30);
		
		surnameT.setBounds(100, 150, 250, 30);
		
		//JButton bounds
		SignUpBtn.setBounds(120,180,200,30);
		haveAnAccountBtn.setBounds(120,240,200,30);
		
		//button listeners
		
		SignUpButtonListener listener = new SignUpButtonListener();
		SignUpBtn.addActionListener(listener);
		HaveAnAccountButtonListener listener2 = new HaveAnAccountButtonListener();
		haveAnAccountBtn.addActionListener(listener2);
		
		
		
		//add to container
		container.add(logo);
		container.add(usernameL);
		container.add(passwordL);
		container.add(emailL);
		container.add(nameL);
		container.add(surnameL);
		container.add(usernameT);
		container.add(passwordT);
		container.add(emailT);
		container.add(nameT);
		container.add(surnameT);
		container.add(SignUpBtn);
		container.add(haveAnAccountL);
		container.add(haveAnAccountBtn);
		
	
		signUpFrame.setVisible(true);
			
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassCode() {
		return passCode;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	

	class SignUpButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			User newUser = new User(userName, passCode, email, name, surname);
			boolean foundUser = false;
			
			userName = usernameT.getText();
			passCode = passwordT.getText();
			email = emailT.getText();
			name = nameT.getText();
			surname = surnameT.getText();
			this.SignUp(users);
			
			signUpFrame.setVisible(false);
			signUpFrame.dispose();
		}
		
		public void SignUp(ArrayList<User> users) {
			
			boolean inUse = false;
			
			//while attempting to sign up
				
				//check if username or email are in use
				
			for (User u: users) {
					
				if (userName.equals(u.getUserName())) {
		
					this.UsernameInUsePopUp();
					usernameT.setText("");
					inUse = true;
					break;
				}
				else if (email.equals(u.getEmail())) {
					
					this.EmailInUsePopUp();
					emailT.setText("");
					inUse = true;
					break;
				}
			}
			
			//if everything ok, register new user
			if (!inUse) {
					
				User newUser = new User(userName,passCode, email, name,surname);
				users.add(newUser);
				WriteUsersDataInFile(newUser);
				JOptionPane.showMessageDialog(signUpFrame, "Sign Up successful!");
				new LogInForm(users, newUser);
			}
		}
		
		public void WriteUsersDataInFile(User u) {
			
			String fileUsers = "FilesServer/Users.txt";
			
			try {
					
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileUsers, true));
				bw.append(System.lineSeparator() + "  " + u.getUserName() + "  |  " + u.getPassCode() + 
	            		  "  |  " + u.getName() + "  |  " + u.getSurname() + "  |  " + u.getEmail() + "  |  ");
	            bw.close();
			}
			catch(IOException e) {
				
				e.printStackTrace();
			}
		}
	
		public void UsernameInUsePopUp(){
			
			if(!(usernameT.getText()=="")) {
				
				JOptionPane.showMessageDialog(null, "Username already in use!");
			}
		
		}
		
		public void EmailInUsePopUp() {
			
			if(!(emailT.getText()=="")) {
				
				JOptionPane.showMessageDialog(null, "Email already in use!");
			}
		}
	}
	
	class HaveAnAccountButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			new LogInForm(users, null);
			signUpFrame.setVisible(false);
			signUpFrame.dispose();
		}
	}
	
	public User GetUserThatWantsToSignUp() {
		
		return userWantToSignUp;
	}
}

