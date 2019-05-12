import java.awt.*;

import javax.swing.*;

//GUI, might want to change
//source: https://github.com/mitchtabian/JavaTutorial10/blob/master/SignUpForm.java
public class SignUpForm {
	private JFrame signUpFrame = new JFrame("Sign up");



	public SignUpForm() {
		
		signUpFrame.setBounds(200,100,400,200);
		
		Container container = signUpFrame.getContentPane();
		container.setLayout(null);
		
	
		
		JLabel logo = new JLabel("Sign Up:");
		logo.setBounds(60, 5, 250, 30);
		
		//Labels for the form fields
		JLabel usernameL = new JLabel("Username:");
		usernameL.setBounds(20, 30, 250, 30);
		
		JLabel passwordL = new JLabel("Password:");
		passwordL.setBounds(20, 60, 250, 30);
		
		JLabel emailL = new JLabel("E-Mail:");
		emailL.setBounds(20, 90, 250, 30);
		
		JLabel nameL = new JLabel("Name:");
		nameL.setBounds(20, 120, 250, 30);
		
		JLabel surnameL = new JLabel("Family name:");
		surnameL.setBounds(20, 150, 250, 30);
		
		//TextFields
		
		JTextField usernameT = new JTextField();
		usernameT.setBounds(65, 30, 250, 30);
		
		JTextField passwordT = new JTextField();
		passwordT.setBounds(65, 60, 250, 30);
		
		JTextField emailT = new JTextField("e.g. someone@somemail.com");
		emailT.setBounds(65, 90, 250, 30);
		
		JTextField nameT = new JTextField("e.g. John");
		nameT.setBounds(65, 120, 250, 30);
		
		JTextField surnameT = new JTextField("e.g. Doe");
		surnameT.setBounds(65, 150, 250, 30);
		
		JButton SignUpBtn = new JButton("Complete Registration");
		SignUpBtn.setBounds(150,180,100,30);
		
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
		
		
		
	signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void InUsePopUp(String element){
		JOptionPane.showMessageDialog(signUpFrame, element + " already in use!");
		
	}
	
}
