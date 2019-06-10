import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;

public class SignUpGUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JButton signUpButton;
	private JButton closeButton;
	private JButton minimizeButton;
	private JButton backToLogIn;
	
	private ArrayList<User> users;
	private User activeUser;
	private User userWantToSignUp;
	
	private ArrayList<Hotel> hotels;
	
	private String userName = "";
	private char[] passFromField = null;
	private String passCode = "";
	private String email = "";
	private String name = "";
	private String surname = "";
	private JLabel lblNewLabel_1;
	
	//Just for creating the SignUpGUI object
	public SignUpGUI() {
	
	}
	
	/**
	 * Launch the application.
	 */	
	public void run(ArrayList<User> users, ArrayList<Hotel> hotels) {
		
		try {
			
			SignUpGUI frame = new SignUpGUI(users, hotels);
			frame.setVisible(true);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public SignUpGUI(ArrayList<User> users, ArrayList<Hotel> hotels) {
		
		this.users = users;
		this.hotels = hotels;
		
		setUndecorated(true);
		setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		
		initComponents();
		createEvents();
	}
	
	/**
	*Method for all the code initializing and creating components.
	*/
	private void initComponents() {
		
		setTitle("Sign-up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 764, 517);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(0, 0, 324, 517);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TravellerS");
		lblNewLabel.setForeground(new Color(173, 216, 230));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 46));
		lblNewLabel.setBounds(0, 0, 325, 253);
		panel.add(lblNewLabel);
		
		JPanel signUpForm = new JPanel();
		signUpForm.setBackground(new Color(245, 245, 245));
		signUpForm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		signUpForm.setForeground(new Color(119, 136, 153));
		signUpForm.setBorder(new MatteBorder(2, 0, 2, 2, (Color) new Color(119, 136, 153)));
		signUpForm.setBounds(322, 0, 442, 517);
		contentPane.add(signUpForm);
		signUpForm.setLayout(null);
		
		emailTextField = new JTextField();
		emailTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(119, 136, 153)));
		emailTextField.setForeground(new Color(0, 0, 0));
		emailTextField.setColumns(10);
		emailTextField.setBounds(136, 323, 220, 33);
		signUpForm.add(emailTextField);
		
		JLabel lblUser = new JLabel("USERNAME");
		lblUser.setForeground(new Color(112, 128, 144));
		lblUser.setBackground(new Color(0, 0, 0));
		lblUser.setBounds(136, 229, 156, 14);
		signUpForm.add(lblUser);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(119, 136, 153));
		lblPassword.setBounds(136, 367, 156, 14);
		signUpForm.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(119, 136, 153)));
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setBounds(136, 392, 220, 33);
		signUpForm.add(passwordField);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(new Color(119, 136, 153));
		lblEmail.setBounds(136, 298, 156, 14);
		signUpForm.add(lblEmail);
		
		nameTextField = new JTextField();
		nameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(119, 136, 153)));
		nameTextField.setForeground(new Color(0, 0, 0));
		nameTextField.setColumns(10);
		nameTextField.setBounds(136, 116, 220, 33);
		signUpForm.add(nameTextField);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBackground(new Color(188, 143, 143));
		lblName.setForeground(new Color(119, 136, 153));
		lblName.setBounds(136, 91, 156, 14);
		signUpForm.add(lblName);
		
		surnameTextField = new JTextField();
		surnameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(119, 136, 153)));
		surnameTextField.setForeground(new Color(0, 0, 0));
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(136, 185, 220, 33);
		signUpForm.add(surnameTextField);
		
		JLabel lblSurname = new JLabel("SURNAME");
		lblSurname.setBackground(new Color(188, 143, 143));
		lblSurname.setForeground(new Color(119, 136, 153));
		lblSurname.setBounds(136, 160, 156, 14);
		signUpForm.add(lblSurname);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(338, 96, -172, 2);
		signUpForm.add(separator);
		
		signUpButton = new JButton("Sign up");
		signUpButton.setForeground(new Color(112, 128, 144));
		signUpButton.setBackground(new Color(169, 169, 169));
		signUpButton.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
		signUpButton.setBounds(203, 436, 89, 30);
		signUpForm.add(signUpButton);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(136, 254, 220, 33);
		signUpForm.add(usernameTextField);
		usernameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(119, 136, 153)));
		usernameTextField.setToolTipText("example: JaxTeller26");
		usernameTextField.setForeground(new Color(0, 0, 0));
		usernameTextField.setColumns(10);
		
		closeButton = new JButton("X");
		closeButton.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		closeButton.setForeground(new Color(245, 245, 245));
		closeButton.setBackground(new Color(119, 136, 153));
		closeButton.setBorder(null);
		closeButton.setBounds(403, 0, 39, 23);
		signUpForm.add(closeButton);
		
		minimizeButton = new JButton("-");
		minimizeButton.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		minimizeButton.setForeground(new Color(245, 245, 245));
		minimizeButton.setBorder(null);
		minimizeButton.setBackground(new Color(119, 136, 153));
		minimizeButton.setBounds(364, 2, 39, 21);
		signUpForm.add(minimizeButton);
		
		lblNewLabel_1 = new JLabel("Sign-up");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(new Color(119, 136, 153));
		lblNewLabel_1.setBounds(192, 27, 149, 33);
		signUpForm.add(lblNewLabel_1);
		
		backToLogIn = new JButton("Back");
		backToLogIn.setForeground(new Color(128, 128, 128));
		backToLogIn.setBackground(new Color(217, 217, 217));
		backToLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		backToLogIn.setBorder(null);
		backToLogIn.setBounds(340, 475, 100, 25);
		signUpForm.add(backToLogIn);
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
	
	/**
	*Method for all the code creating events.
	*/
	private void createEvents() {
		
		signUpButton.addActionListener(e -> {
			
			userName = usernameTextField.getText().trim();
			passFromField = passwordField.getPassword();
			passCode = new String(passFromField);
			email = emailTextField.getText().trim();
			name = nameTextField.getText().trim();
			surname = surnameTextField.getText().trim();
			
			if(this.SignUp(users)) {
		
				this.setVisible(false);
				this.dispose();
				LogInGUI logInGUI = new LogInGUI();
				logInGUI.run(users, null, hotels);
			}
		});
		
		backToLogIn.addActionListener(e -> {
			
			this.setVisible(false);
			this.dispose();
			LogInGUI logInGUI = new LogInGUI();
			logInGUI.run(users, null, hotels);
		});
		
		closeButton.addActionListener(e -> {
			
			System.exit(0);
		});
		
		minimizeButton.addActionListener(e -> {
			
			setState(JFrame.ICONIFIED);
		});	
	}
	
	public boolean SignUp(ArrayList<User> users) {
		
		boolean inUseUserN = false;
		boolean inUseUserE = false;
		boolean emptyField = false;
		ArrayList<String> emptyFields = new ArrayList<>();
		boolean signUpSuccessful = false;
		
		//while attempting to sign up
			
			//check if username or email are in use		
			
		for (User u: users) {
			
			if (userName.equals(u.getUserName())) {
				
				this.UsernameInUsePopUp();
				usernameTextField.setText("");
				inUseUserN = true;
				break;
			}
			else if (email.equals(u.getEmail())) {
				
				this.EmailInUsePopUp();
				emailTextField.setText("");
				inUseUserE = true;
				break;
			}
			}
		if (name.equals(""))
			emptyFields.add("NAME");
		if (surname.equals(""))
			emptyFields.add("SURNAME");
		if (userName.equals(""))
			emptyFields.add("USERNAME");
		if (email.equals(""))
			emptyFields.add("EMAIL");
		if (passCode.equals(""))
			emptyFields.add("PASSWORD");
	
		
		if (!emptyFields.isEmpty())
			EmptyFieldsPopUp(emptyFields);
		
		
		//if everything ok, register new user
		if (!inUseUserN && !inUseUserE && emptyFields.isEmpty()) {
			
			User newUser = new User(userName, passCode, email, name, surname); 
			users.add(newUser);
			JOptionPane.showMessageDialog(this, "Sign Up successful!");
			WriteUsersDataInFile(newUser);
			signUpSuccessful = true;
		}
		
		return signUpSuccessful;
	}
	
	public void WriteUsersDataInFile(User u) {
		
		String fileUsers = "FilesServer/Users.txt";
		
		try {
				
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileUsers, true));
			bw.append(System.lineSeparator() + "  " + u.getUserName() + "  |  " + u.getPassCode() + 
            		  "  |  " + u.getName() + "  |  " + u.getSurname() + "  |  " + u.getEmail() + "  |");
            bw.close();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void UsernameInUsePopUp() {
		
		if(!(usernameTextField.getText()=="")) {
			
			JOptionPane.showMessageDialog(null, "Username already in use!");
		}
		
	}
	public void EmailInUsePopUp() {
		
		if(!(emailTextField.getText()=="")) {
			
			JOptionPane.showMessageDialog(null, "Email already in use!");
		}
	}
	
public void EmptyFieldsPopUp(ArrayList<String> EmptyFields) {
			
	String message = new String("The following fields are empty:\n");
	
	for(String s: EmptyFields)
		message += s + "\n";
	JOptionPane.showMessageDialog(null, message);
		
		
	}
	
	public User GetUserThatWantsToSignUp() {
		
		return userWantToSignUp;
	}
}