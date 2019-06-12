import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class LogInGUI extends JFrame {
	
	private String userName = "";
	private char[] passFromField = null;
	private String passCode;
	
	private ArrayList<User> users;
	private User currentUser;
	private User userThatSendFromSignUp;
	
	//It was created only cause, MainScreenGUI needs both, users and hotels arrays. Server was created in main so i pass the arrayList of hotels, which hotels i found, in main and they are here only for that
	private ArrayList<Hotel> hotels;
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton button;
	
	//Just for creating the LogInGUI object
	public LogInGUI() {
		
	}
	
	/**
	 * Launch the application.
	 */ 
	public void run(ArrayList<User> users, ArrayList<Hotel> hotels) {
		
		try {
			
			LogInGUI frame = new LogInGUI(users, hotels);
			frame.setVisible(true);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public LogInGUI(ArrayList<User> users, ArrayList<Hotel> hotels) {
		
		this.users = users;
		this.hotels = hotels;
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 413);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(119, 136, 153));
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new LineBorder(new Color(119, 136, 153), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(119, 136, 153));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(119, 136, 153)));
		textField.setBounds(68, 135, 199, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(119, 136, 153));
		lblNewLabel.setBounds(68, 104, 190, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(119, 136, 153));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPassword.setBounds(68, 189, 190, 20);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(119, 136, 153));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(119, 136, 153)));
		passwordField.setBounds(68, 220, 199, 29);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("Log in");
		btnNewButton.setForeground(new Color(119, 136, 153));
		btnNewButton.setBorder(new LineBorder(new Color(119, 136, 153), 2, true));
		btnNewButton.setBounds(109, 260, 114, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton(">>Don't have an account?");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(new Color(119, 136, 153));
		btnNewButton_1.setBounds(68, 300, 200, 20);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Log-in");
		lblNewLabel_1.setForeground(new Color(119, 136, 153));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(123, 23, 83, 35);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("X");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(119, 136, 153));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setForeground(new Color(245, 245, 245));
		btnNewButton_2.setBounds(296, 0, 43, 20);
		contentPane.add(btnNewButton_2);
		
		button = new JButton("-");
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setForeground(new Color(245, 245, 245));
		button.setBorder(null);
		button.setBackground(new Color(119, 136, 153));
		button.setBounds(257, 0, 43, 20);
		contentPane.add(button);
		
		createEvents();
	}
	
	private void createEvents() {
		
		btnNewButton.addActionListener(e -> {
			
			userName = textField.getText();
			passFromField = passwordField.getPassword();
			passCode = new String(passFromField);
			
			if(this.LogIn(users)) {
				
				if(currentUser.getStatus().equals("U")) {
					
					this.setVisible(false);
					this.dispose();
					//Hotels array is here only for this part
					JOptionPane.showMessageDialog(this, "Logged in as: " + currentUser.getUserName()+ ".", "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
					MainScreenGUI mainScreenGUI = new MainScreenGUI();
					mainScreenGUI.run(hotels, users, currentUser);
				}
				else {
					
					this.setVisible(false);
					this.dispose();
					JOptionPane.showMessageDialog(this, "Hello Admin. Logged in as: " + currentUser.getUserName()+ ".", "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
					AdminScreenGUI adminScreenGUI = new AdminScreenGUI();
					adminScreenGUI.run(hotels, users);
				}
			}
		});
		
		btnNewButton_1.addActionListener(e -> {
			
			SignUpGUI signUpGUI = new SignUpGUI();
			signUpGUI.run(users, hotels);
			userThatSendFromSignUp = signUpGUI.GetUserThatWantsToSignUp();
			this.setVisible(false);
			this.dispose();
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				System.exit(0);
			}
		});
		
		button.addActionListener(e -> {
			
			setState(JFrame.ICONIFIED);
		});
	}
		
	public boolean LogIn(ArrayList<User> users) {	
			
		boolean logInSuccessful = false;
		boolean userFound = false;
		boolean passwdFound = false;
				
		//check if username and password match
		for(User u: users) {
				
			if(userName.equals(u.getUserName())) {
					
				userFound = true;
					
				if(passCode.equals(u.getPassCode())) {
				
					passwdFound = true;
					currentUser = u;
					logInSuccessful = true;
					break;
				}
			}
		}
				
		if(!logInSuccessful) {
			
			if(!userFound) {
				
				textField.setText("");
				passwordField.setText("");
				WrongUsernamePopUp();
			}
			else {
					
				if(!passwdFound) {
						
					passwordField.setText("");
					PasswdDoesntMatchUsernamePopUp();
				}
			}
		}
				
		return logInSuccessful;
	}
		
	public void WrongUsernamePopUp() {
			
		JOptionPane.showMessageDialog(this, "Username didn't found", "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
	}
		
	public void PasswdDoesntMatchUsernamePopUp() {
			
		JOptionPane.showMessageDialog(this, "Wrong password!", "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
	}

	public User GetUserThatWantToSignUpFromLogInForm() {
		
			return userThatSendFromSignUp;
	}
}