import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//GUI, might want to change
//source: https://github.com/mitchtabian/JavaTutorial10/blob/master/SignUpForm.java
public class SignUpForm {
	private JFrame signUpFrame = new JFrame("Sign Up");
	private String userName = "";
	private String passCode = "";
	private String email = "";
	private String name = "";
	private String surname = "";
	
	private JLabel logo = new JLabel("Sign Up:");
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
	private JButton SignUpBtn = new JButton("Complete Registration");



	public SignUpForm() {
		
		signUpFrame.setBounds(200,100,400,200);
		
		Container container = signUpFrame.getContentPane();
		container.setLayout(null);
		
	
		
	
		logo.setBounds(60, 5, 250, 30);
		
		//Label bounds
	
		usernameL.setBounds(20, 30, 250, 30);
		
		passwordL.setBounds(20, 60, 250, 30);
		
		
		emailL.setBounds(20, 90, 250, 30);
		
		
		nameL.setBounds(20, 120, 250, 30);
		

		surnameL.setBounds(20, 150, 250, 30);
		
		//TextField bounds
		
		
		usernameT.setBounds(65, 30, 250, 30);
		
	
		passwordT.setBounds(65, 60, 250, 30);
		
		emailT.setBounds(65, 90, 250, 30);
		
		nameT.setBounds(65, 120, 250, 30);
		
		surnameT.setBounds(65, 150, 250, 30);
		
		//JButton bounds
		SignUpBtn.setBounds(150,180,100,30);
		
		
		//button listener
		
		SignUpButtonListener listener = new SignUpButtonListener();
		SignUpBtn.addActionListener(listener);
		
		
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
		
	
	signUpFrame.setVisible(true);
			
	signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void InUsePopUp(String element){
		JOptionPane.showMessageDialog(signUpFrame, element + " already in use!");
		
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

	class SignUpButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			userName = usernameT.getText();
			passCode = passwordT.getText();
			email = emailT.getText();
			name = nameT.getText();
			surname = surnameT.getText();
		}
	}
}


