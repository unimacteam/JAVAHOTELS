import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class LogInForm {

	private JFrame LogInFrame = new JFrame("Log In");
	private String userName = "";
	private String passCode = "";
	
	private JLabel logo = new JLabel("Log In:");
	private JLabel usernameL = new JLabel("Username:");
	private JLabel passwordL = new JLabel("Password:");
	
	private JTextField usernameT = new JTextField();
	private JTextField passwordT = new JTextField();
	
	private JButton LogInBtn = new JButton("Log In");
	
	public LogInForm() {
		LogInFrame.setBounds(200,100,400,200);
		
		Container container = LogInFrame.getContentPane();
		container.setLayout(null);
		
				//Label bounds
		logo.setBounds(60, 5, 250, 30);
		
		usernameL.setBounds(20, 30, 250, 30);
		
		passwordL.setBounds(20, 60, 250, 30);
		
		//TextField bounds
		usernameT.setBounds(65, 30, 250, 30);
				
		passwordT.setBounds(65, 60, 250, 30);
		
		//JButton bounds
		LogInBtn.setBounds(150,180,100,30);
				
				
		//button listener
				
		LogInButtonListener listener = new LogInButtonListener();
		LogInBtn.addActionListener(listener);
		
		//add to container

		container.add(logo);
		container.add(usernameL);
		container.add(passwordL);
	
		container.add(usernameT);
		container.add(passwordT);

		container.add(LogInBtn);
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
		
		}

	}

}
