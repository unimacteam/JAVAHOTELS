	import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

//ΕΔΩ, ΓΙΑ ΝΑ ΣΥΝΔΕΘΕΙ Ο ΧΡΗΣΤΗΣ ΠΡΕΠΕΙ ΝΑ ΕΧΕΙ ΔΙΚΑΙΩΜΑ ADMINER ΚΑΙ ΑΥΤΟ ΓΙΝΕΤΑΙ ΑΜΑ ΣΥΝΔΕΘΕΙ ΜΕ ΕΝΑΝ ΛΟΓΑΡΙΑΣΜΟ ΑΠΟ ΤΟ USERS, ΜΕ STATUS "A"(ΒΛΕΠΕ Users.txt)

	public class AdminScreenGUI extends JFrame {

		private JPanel contentPane;
		private JTextField nameField;
		private JTextField locationField;
		private JTextField streetField;
		private JTextField r1PriceField;
		private JTextField r2PriceField;
		private JTextField r3PriceField;
		private JTextField r4PriceField;
		private JTextField rooms1Field;
		private JTextField rooms2Field;
		private JTextField rooms3Field;
		private JTextField rooms4Field;
		private JTextField rsvRoom1Field;
		private JTextField rsvRoom2Field;
		private JTextField rsvRoom3Field;
		private JTextField rsvRoom4Field;
		private Hotel h;
		private String name;
		private String location;
		private String street;
		private double r1Price;
		private double r2Price;
		private double r3Price;
		private double r4Price;
		private int rooms1;
		private int rooms2;
		private int rooms3;
		private int rooms4;
		private int rsvRoom1;
		private int rsvRoom2;
		private int rsvRoom3;
		private int rsvRoom4;
		private int stars;
		private String details;
		private String pool;
		private String gym;
		private String restaurant;
		private String breakfast;
		private String lunch;
		private JComboBox starsComboBox;
		private JTextArea detailsField;
		private JRadioButton poolRBtn;
		private JRadioButton gymRBtn;
		private JRadioButton restaurantRBtn;
		private JRadioButton breakfastRBtn;
		private JRadioButton lunchRBtn;
		private JButton enterBtn;
		private ArrayList<Hotel> hotels;
		private ArrayList<User> users;
		
		public AdminScreenGUI() {
		
		}
		
		public void run(ArrayList<Hotel> hotels, ArrayList<User> users) {
			
			try {

				AdminScreenGUI frame = new AdminScreenGUI(hotels, users);
				frame.setVisible(true);
			}
			catch (Exception e) {
			
				e.printStackTrace();
			}
		}

		/**
		 * Create the frame.
		 */
		public AdminScreenGUI(ArrayList<Hotel> hotels, ArrayList<User> users) {
			
			this.hotels = hotels;
			this.users = users;
			
			setResizable(false);
			setUndecorated(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 657, 381);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(240, 248, 255));
			contentPane.setBorder(new LineBorder(new Color(176, 196, 222), 2));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			nameField = new JTextField();
			nameField.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			nameField.setCaretColor(new Color(188, 143, 143));
			nameField.setForeground(new Color(112, 128, 144));
			nameField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			nameField.setBackground(new Color(176, 196, 222));
			nameField.setBounds(161, 50, 96, 20);
			contentPane.add(nameField);
			nameField.setColumns(10);
			
			locationField = new JTextField();
			locationField.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			locationField.setCaretColor(new Color(188, 143, 143));
			locationField.setForeground(new Color(112, 128, 144));
			locationField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			locationField.setBackground(new Color(176, 196, 222));
			locationField.setBounds(328, 50, 96, 20);
			contentPane.add(locationField);
			locationField.setColumns(10);
			
			streetField = new JTextField();
			streetField.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			streetField.setCaretColor(new Color(188, 143, 143));
			streetField.setForeground(new Color(112, 128, 144));
			streetField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			streetField.setBackground(new Color(176, 196, 222));
			streetField.setColumns(10);
			streetField.setBounds(491, 50, 96, 20);
			contentPane.add(streetField);
			
			String [] starsList = {"1", "2", "3", "4", "5"};
			starsComboBox = new JComboBox(starsList);
			starsComboBox.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			starsComboBox.setForeground(new Color(112, 128, 144));
			starsComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			starsComboBox.setBackground(new Color(176, 196, 222));
			starsComboBox.setBounds(605, 50, 40, 20);
			contentPane.add(starsComboBox);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setForeground(new Color(188, 143, 143));
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel.setBounds(161, 25, 48, 14);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Location");
			lblNewLabel_1.setForeground(new Color(188, 143, 143));
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(328, 25, 48, 14);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Street");
			lblNewLabel_2.setForeground(new Color(188, 143, 143));
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(493, 27, 48, 14);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblStars = new JLabel("Stars");
			lblStars.setForeground(new Color(188, 143, 143));
			lblStars.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblStars.setBounds(610, 27, 48, 14);
			contentPane.add(lblStars);
			
			r1PriceField = new JTextField();
			r1PriceField.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			r1PriceField.setCaretColor(new Color(188, 143, 143));
			r1PriceField.setForeground(new Color(112, 128, 144));
			r1PriceField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			r1PriceField.setBackground(new Color(176, 196, 222));
			r1PriceField.setBounds(129, 99, 48, 20);
			contentPane.add(r1PriceField);
			r1PriceField.setColumns(10);
			
			r2PriceField = new JTextField();
			r2PriceField.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			r2PriceField.setCaretColor(new Color(188, 143, 143));
			r2PriceField.setForeground(new Color(112, 128, 144));
			r2PriceField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			r2PriceField.setBackground(new Color(176, 196, 222));
			r2PriceField.setColumns(10);
			r2PriceField.setBounds(129, 124, 48, 20);
			contentPane.add(r2PriceField);
			
			r3PriceField = new JTextField();
			r3PriceField.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			r3PriceField.setCaretColor(new Color(188, 143, 143));
			r3PriceField.setForeground(new Color(112, 128, 144));
			r3PriceField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			r3PriceField.setBackground(new Color(176, 196, 222));
			r3PriceField.setColumns(10);
			r3PriceField.setBounds(129, 149, 48, 20);
			contentPane.add(r3PriceField);
			
			r4PriceField = new JTextField();
			r4PriceField.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			r4PriceField.setCaretColor(new Color(188, 143, 143));
			r4PriceField.setForeground(new Color(112, 128, 144));
			r4PriceField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			r4PriceField.setBackground(new Color(176, 196, 222));
			r4PriceField.setColumns(10);
			r4PriceField.setBounds(129, 174, 48, 20);
			contentPane.add(r4PriceField);
			
			JLabel lblRoomPrice = new JLabel("single room  price");
			lblRoomPrice.setForeground(new Color(188, 143, 143));
			lblRoomPrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblRoomPrice.setBounds(12, 102, 88, 14);
			contentPane.add(lblRoomPrice);
			
			JLabel lblRoomsPrice = new JLabel("double room price                           /person");
			lblRoomsPrice.setForeground(new Color(188, 143, 143));
			lblRoomsPrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblRoomsPrice.setBounds(12, 127, 206, 14);
			contentPane.add(lblRoomsPrice);
			
			JLabel lblRoomsPrice_1 = new JLabel("triple room price                             /person");
			lblRoomsPrice_1.setForeground(new Color(188, 143, 143));
			lblRoomsPrice_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblRoomsPrice_1.setBounds(12, 152, 204, 14);
			contentPane.add(lblRoomsPrice_1);
			
			JLabel lblQuadrupleRoomPrice = new JLabel("quadruple room price                      /person");
			lblQuadrupleRoomPrice.setForeground(new Color(188, 143, 143));
			lblQuadrupleRoomPrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblQuadrupleRoomPrice.setBounds(12, 177, 205, 14);
			contentPane.add(lblQuadrupleRoomPrice);
			
			JLabel lblSingleRooms = new JLabel("single rooms  ");
			lblSingleRooms.setForeground(new Color(188, 143, 143));
			lblSingleRooms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblSingleRooms.setBounds(243, 102, 68, 14);
			contentPane.add(lblSingleRooms);
			
			JLabel lblDoubleRooms = new JLabel("double rooms");
			lblDoubleRooms.setForeground(new Color(188, 143, 143));
			lblDoubleRooms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblDoubleRooms.setBounds(243, 127, 68, 14);
			contentPane.add(lblDoubleRooms);
			
			JLabel lblTripleRooms = new JLabel("triple rooms");
			lblTripleRooms.setForeground(new Color(188, 143, 143));
			lblTripleRooms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblTripleRooms.setBounds(243, 152, 59, 14);
			contentPane.add(lblTripleRooms);
			
			JLabel lblQuadrupleRooms = new JLabel("quadruple rooms");
			lblQuadrupleRooms.setForeground(new Color(188, 143, 143));
			lblQuadrupleRooms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblQuadrupleRooms.setBounds(243, 177, 85, 14);
			contentPane.add(lblQuadrupleRooms);
			
			rooms1Field = new JTextField();
			rooms1Field.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			rooms1Field.setCaretColor(new Color(188, 143, 143));
			rooms1Field.setForeground(new Color(112, 128, 144));
			rooms1Field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			rooms1Field.setBackground(new Color(176, 196, 222));
			rooms1Field.setColumns(10);
			rooms1Field.setBounds(336, 99, 48, 20);
			contentPane.add(rooms1Field);
			
			rooms2Field = new JTextField();
			rooms2Field.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			rooms2Field.setCaretColor(new Color(188, 143, 143));
			rooms2Field.setForeground(new Color(112, 128, 144));
			rooms2Field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			rooms2Field.setBackground(new Color(176, 196, 222));
			rooms2Field.setColumns(10);
			rooms2Field.setBounds(336, 124, 48, 20);
			contentPane.add(rooms2Field);
			
			rooms3Field = new JTextField();
			rooms3Field.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			rooms3Field.setCaretColor(new Color(188, 143, 143));
			rooms3Field.setForeground(new Color(112, 128, 144));
			rooms3Field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			rooms3Field.setBackground(new Color(176, 196, 222));
			rooms3Field.setColumns(10);
			rooms3Field.setBounds(336, 149, 48, 20);
			contentPane.add(rooms3Field);
			
			rooms4Field = new JTextField();
			rooms4Field.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			rooms4Field.setCaretColor(new Color(188, 143, 143));
			rooms4Field.setForeground(new Color(112, 128, 144));
			rooms4Field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			rooms4Field.setBackground(new Color(176, 196, 222));
			rooms4Field.setColumns(10);
			rooms4Field.setBounds(336, 174, 48, 20);
			contentPane.add(rooms4Field);
			
			JLabel lblSingleReservedRooms = new JLabel("single reserved rooms  ");
			lblSingleReservedRooms.setForeground(new Color(188, 143, 143));
			lblSingleReservedRooms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblSingleReservedRooms.setBounds(442, 102, 119, 14);
			contentPane.add(lblSingleReservedRooms);
			
			JLabel lblDoubleReservedRooms = new JLabel("double reserved rooms");
			lblDoubleReservedRooms.setForeground(new Color(188, 143, 143));
			lblDoubleReservedRooms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblDoubleReservedRooms.setBounds(442, 127, 119, 14);
			contentPane.add(lblDoubleReservedRooms);
			
			JLabel lblTripleReservedRooms = new JLabel("triple reserved rooms");
			lblTripleReservedRooms.setForeground(new Color(188, 143, 143));
			lblTripleReservedRooms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblTripleReservedRooms.setBounds(442, 152, 119, 14);
			contentPane.add(lblTripleReservedRooms);
			
			JLabel lblQuadrupleReservedRooms = new JLabel("quadruple reserved rooms");
			lblQuadrupleReservedRooms.setForeground(new Color(188, 143, 143));
			lblQuadrupleReservedRooms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblQuadrupleReservedRooms.setBounds(442, 177, 119, 14);
			contentPane.add(lblQuadrupleReservedRooms);
			
			rsvRoom1Field = new JTextField();
			rsvRoom1Field.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			rsvRoom1Field.setCaretColor(new Color(188, 143, 143));
			rsvRoom1Field.setForeground(new Color(112, 128, 144));
			rsvRoom1Field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			rsvRoom1Field.setBackground(new Color(176, 196, 222));
			rsvRoom1Field.setColumns(10);
			rsvRoom1Field.setBounds(571, 99, 48, 20);
			contentPane.add(rsvRoom1Field);
			
			rsvRoom2Field = new JTextField();
			rsvRoom2Field.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			rsvRoom2Field.setCaretColor(new Color(188, 143, 143));
			rsvRoom2Field.setForeground(new Color(112, 128, 144));
			rsvRoom2Field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			rsvRoom2Field.setBackground(new Color(176, 196, 222));
			rsvRoom2Field.setColumns(10);
			rsvRoom2Field.setBounds(571, 124, 48, 20);
			contentPane.add(rsvRoom2Field);
			
			rsvRoom3Field = new JTextField();
			rsvRoom3Field.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			rsvRoom3Field.setCaretColor(new Color(188, 143, 143));
			rsvRoom3Field.setForeground(new Color(112, 128, 144));
			rsvRoom3Field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			rsvRoom3Field.setBackground(new Color(176, 196, 222));
			rsvRoom3Field.setColumns(10);
			rsvRoom3Field.setBounds(571, 149, 48, 20);
			contentPane.add(rsvRoom3Field);
			
			rsvRoom4Field = new JTextField();
			rsvRoom4Field.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			rsvRoom4Field.setCaretColor(new Color(188, 143, 143));
			rsvRoom4Field.setForeground(new Color(112, 128, 144));
			rsvRoom4Field.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			rsvRoom4Field.setBackground(new Color(176, 196, 222));
			rsvRoom4Field.setColumns(10);
			rsvRoom4Field.setBounds(571, 174, 48, 20);
			contentPane.add(rsvRoom4Field);
			
			poolRBtn = new JRadioButton("Pool");
			poolRBtn.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			poolRBtn.setForeground(new Color(188, 143, 143));
			poolRBtn.setBackground(new Color(176, 196, 222));
			poolRBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			poolRBtn.setBounds(42, 265, 109, 23);
			contentPane.add(poolRBtn);
			
			gymRBtn = new JRadioButton("Gym");
			gymRBtn.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			gymRBtn.setForeground(new Color(188, 143, 143));
			gymRBtn.setBackground(new Color(176, 196, 222));
			gymRBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			gymRBtn.setBounds(192, 265, 109, 23);
			contentPane.add(gymRBtn);
			
			restaurantRBtn = new JRadioButton("Restaurant");
			restaurantRBtn.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			restaurantRBtn.setForeground(new Color(188, 143, 143));
			restaurantRBtn.setBackground(new Color(176, 196, 222));
			restaurantRBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			restaurantRBtn.setBounds(336, 265, 109, 23);
			contentPane.add(restaurantRBtn);
			
			breakfastRBtn = new JRadioButton("Breakfast");
			breakfastRBtn.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			breakfastRBtn.setForeground(new Color(188, 143, 143));
			breakfastRBtn.setBackground(new Color(176, 196, 222));
			breakfastRBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			breakfastRBtn.setBounds(493, 265, 109, 23);
			contentPane.add(breakfastRBtn);
			
			lunchRBtn = new JRadioButton("Lunch");
			lunchRBtn.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			lunchRBtn.setForeground(new Color(188, 143, 143));
			lunchRBtn.setBackground(new Color(176, 196, 222));
			lunchRBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lunchRBtn.setBounds(42, 304, 109, 23);
			contentPane.add(lunchRBtn);
			
			detailsField = new JTextArea();
			detailsField.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(188, 143, 143)));
			detailsField.setCaretColor(new Color(188, 143, 143));
			detailsField.setForeground(new Color(112, 128, 144));
			detailsField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			detailsField.setBackground(new Color(176, 196, 222));
			detailsField.setColumns(10);
			detailsField.setBounds(180, 310, 320, 55);
			contentPane.add(detailsField);
			
			JLabel lblDetails = new JLabel("Details of this hotel");
			lblDetails.setForeground(new Color(188, 143, 143));
			lblDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
			lblDetails.setBounds(30, 335, 141, 33);
			contentPane.add(lblDetails);
			
			JLabel lblNewLabel_3 = new JLabel("Services");
			lblNewLabel_3.setForeground(new Color(188, 143, 143));
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(243, 225, 141, 33);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("HOTEL ENTRY");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setForeground(new Color(188, 143, 143));
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
			lblNewLabel_4.setBounds(10, 25, 128, 45);
			contentPane.add(lblNewLabel_4);
			
			JButton xBtn = new JButton("X");
			xBtn.setForeground(new Color(188, 143, 143));
			xBtn.setBackground(new Color(176, 196, 222));
			xBtn.setBorder(null);
			xBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			xBtn.setBounds(615, 0, 42, 23);
			contentPane.add(xBtn);
			xBtn.addActionListener(e -> {
				
				System.exit(0);
			});
			
			JButton minBtn = new JButton("-");
			minBtn.setForeground(new Color(188, 143, 143));
			minBtn.setBackground(new Color(176, 196, 222));
			minBtn.setBorder(null);
			minBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
			minBtn.setBounds(577, 0, 42, 23);
			contentPane.add(minBtn);
			minBtn.addActionListener(e -> {
				
				setState(JFrame.ICONIFIED);
			});
			
			JButton logoutBtn = new JButton("Log out");
			logoutBtn.setForeground(new Color(255, 218, 185));
			logoutBtn.setBackground(new Color(176, 196, 222));
			logoutBtn.setBorder(null);
			logoutBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			logoutBtn.setBounds(558, 347, 89, 23);
			contentPane.add(logoutBtn);
			logoutBtn.addActionListener(e -> {
			
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to Log out?", "Travellers_Message", dialogButton);
			
				if(dialogResult == 0) {
			 
					this.setVisible(false);
					this.dispose();
					LogInGUI logInGUI = new LogInGUI();
					logInGUI.run(users, hotels);
				}
			});
			
			enterBtn = new JButton("Enter");
			enterBtn.setForeground(new Color(112, 128, 144));
			enterBtn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			enterBtn.setBackground(new Color(188, 143, 143));
			enterBtn.setBorder(null);
			enterBtn.setBounds(558, 315, 89, 23);
			contentPane.add(enterBtn);
			enterBtn.addActionListener(e -> {
					
				if(DataCheck()) {
				
					name = nameField.getText();
					location = locationField.getText();
					street = streetField.getText();
					String starsString = (String) starsComboBox.getSelectedItem();
					stars = Integer.parseInt(starsString);
					ArrayList<Double> rPriceList = new ArrayList<>();
					r1Price = Double.parseDouble(r1PriceField.getText().trim());
					r2Price = Double.parseDouble(r2PriceField.getText().trim());
					r3Price = Double.parseDouble(r3PriceField.getText().trim());
					r4Price = Double.parseDouble(r4PriceField.getText().trim());
					rPriceList.add(r1Price);
					rPriceList.add(r2Price);
					rPriceList.add(r3Price);
					rPriceList.add(r4Price);
					ArrayList<Integer> roomsList = new ArrayList<>();
					rooms1 = Integer.parseInt(rooms1Field.getText().trim());
					rooms2 = Integer.parseInt(rooms2Field.getText().trim());
					rooms3 = Integer.parseInt(rooms3Field.getText().trim());
					rooms4 = Integer.parseInt(rooms4Field.getText().trim());
					roomsList.add(rooms1);
					roomsList.add(rooms2);
					roomsList.add(rooms3);
					roomsList.add(rooms4);
					ArrayList<Integer> resRoomsList = new ArrayList<>();
					rsvRoom1 = Integer.parseInt(rsvRoom1Field.getText().trim());
					rsvRoom2 = Integer.parseInt(rsvRoom2Field.getText().trim());
					rsvRoom3 = Integer.parseInt(rsvRoom3Field.getText().trim());
					rsvRoom4 = Integer.parseInt(rsvRoom4Field.getText().trim());
					resRoomsList.add(rsvRoom1);
					resRoomsList.add(rsvRoom2);
					resRoomsList.add(rsvRoom3);
					resRoomsList.add(rsvRoom4);
					details = detailsField.getText();
					
					ArrayList<String> extras = new ArrayList<>();
					
					if(poolRBtn.isSelected()) {
						
						pool = "Y";
					}
					else {
						
						pool = "N";
					}
					
					if(gymRBtn.isSelected()) {
						
						gym = "Y";
					}
					else {
						
						gym = "N";
					}

					if(restaurantRBtn.isSelected()) {
	
						restaurant = "Y";
					}
					else {
	
						restaurant = "N";
					}
					
					if(breakfastRBtn.isSelected()) {
						
						breakfast = "Y";
					}
					else {
	
						breakfast = "N";
					}
					
					if(lunchRBtn.isSelected()) {
						
						lunch = "Y";
					}
					else {
	
						lunch = "N";
					}
					
					extras.add(pool);
					extras.add(gym);
					extras.add(restaurant);
					extras.add(breakfast);
					extras.add(lunch);
					
					boolean noOtherLikeThat = false;
					
					h = new Hotel(name, location, street, rPriceList, roomsList, resRoomsList, stars, extras);
					for(Hotel h1 :hotels) {
						
						System.out.println(h1.getName() + " " + h.getName());
						if(h1.getName().equals(h.getName())) {

							System.out.println("In");
							noOtherLikeThat = true;
							break;
						}
					}
					
					if(!noOtherLikeThat) {
						
						hotels.add(h);
						h.WriteDetailsOfThisHotel(h, details);
						WriteToHotelsTxtFile();
						JOptionPane.showMessageDialog(this, "Hotel " + h.getName() + " has registered!", "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else {
						
						JOptionPane.showMessageDialog(this, "There is, already, a hotel named " + h.getName(), "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
						
						JOptionPane.showMessageDialog(this, "Invalid data!", "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
					}
				});
		}

		private boolean DataCheck() {
			
			if(r1PriceField.getText().trim().equals("") || r2PriceField.getText().trim().equals("") || r3PriceField.getText().trim().equals("") || 
					r4PriceField.getText().trim().equals("") || rooms1Field.getText().trim().equals("") || rooms2Field.getText().trim().equals("") 
					|| rooms3Field.getText().trim().equals("") || rooms4Field.getText().trim().equals("") || rsvRoom1Field.getText().trim().equals("") 
					|| rsvRoom2Field.getText().trim().equals("") || rsvRoom3Field.getText().trim().equals("") || rsvRoom4Field.getText().trim().equals("") 
					|| nameField.getText().trim().equals("") || locationField.getText().trim().equals("") || streetField.getText().trim().equals("") || 
					detailsField.getText().trim().equals("")) {
				
				return false;
			}
			if(streetField.getText().trim().equals("")) {
				
				return false;
			}
			else if(!isNumeric(rooms1Field.getText().trim()) || !isNumeric(rooms2Field.getText().trim()) || !isNumeric(rooms3Field.getText().trim())
					|| !isNumeric(rooms4Field.getText().trim()) || !isNumeric(rsvRoom1Field.getText().trim()) || !isNumeric(rsvRoom2Field.getText().trim())
					|| !isNumeric(rsvRoom3Field.getText().trim()) || !isNumeric(rsvRoom4Field.getText().trim()) || !isNumeric(r1PriceField.getText().trim())
					|| !isNumeric(r2PriceField.getText().trim()) || !isNumeric(r3PriceField.getText().trim()) || !isNumeric(r4PriceField.getText().trim())) {
				
				return false;
			}
			else if (Integer.parseInt(rooms1Field.getText().trim()) < Integer.parseInt(rsvRoom1Field.getText().trim()) ||
					Integer.parseInt(rooms2Field.getText().trim()) < Integer.parseInt(rsvRoom2Field.getText().trim()) ||
					Integer.parseInt(rooms3Field.getText().trim()) < Integer.parseInt(rsvRoom3Field.getText().trim()) ||
					Integer.parseInt(rooms4Field.getText().trim()) < Integer.parseInt(rsvRoom4Field.getText().trim())) {
				
				return false;
			}
			
			return true;
		}
		
		public static boolean isNumeric(String strNum) {
			
		    try {
		    	
		        double d = Double.parseDouble(strNum);
		    }
		    catch (NumberFormatException | NullPointerException nfe) {
		      
		    	return false;
		    }
		    
		    return true;
		}
		
		public void WriteToHotelsTxtFile() {
			
			String fileHotel = "FilesServer\\Hotels.txt";
			
			try {
				
				System.out.println("In");
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(fileHotel, true));
				bw1.append(System.lineSeparator() + "  " + name + "  |  " + location + "  |  " + street + "  |  " + r1Price + " , " + r2Price + " , " + r3Price 
						   + " , " + r4Price + "  |  " + rooms1 + " , " + rooms2 + " , " + rooms3 + " , " + rooms4 + "  |  $" + rsvRoom1 + " , " + rsvRoom2 
						   + " , " + rsvRoom3 + " , " + rsvRoom4 + "$  |  " + stars + "  |  " + pool + "  |  " + gym + "  |  " + restaurant 
						   + "  |  " + breakfast + "  |  " + lunch + "  |  ");
					
				bw1.close();
			
			}
			catch(IOException e) {
				
				e.printStackTrace();
			}
		}
		
		/*public void ReadTheHotelsFromTxtFile() {
			
			String fileHotels = "FilesServer/Hotels.txt";
			hotels.clear();
			
			try { 

				FileReader frH = new FileReader(fileHotels);
				BufferedReader readerH = new BufferedReader(frH);

				boolean checkH = false;
				String lineH = readerH.readLine();
				while(lineH != null) {

					if(checkH) {

						CreateHotels(lineH);
					}

					lineH = readerH.readLine();
					checkH = true;
				}

				readerH.close();
			}
			catch(IOException e) {

				e.printStackTrace();
			}
		}
		
		public void CreateHotels(String line) {
			
			String name = "";
			String location = "";
			String street = "";
			ArrayList<Double> price = new ArrayList<>();
			ArrayList<Integer> roomsSize = new ArrayList<>();
			ArrayList<Integer> resRoomsSize = new ArrayList<>();
			int stars = 0;
			ArrayList<String> extra = new ArrayList<>();
			
			line = line.replaceAll("\\s+", "");
				
			name = line.substring(0, line.indexOf("|"));
			line = line.replaceFirst(name + "\\|", "");
			
			location = line.substring(0, line.indexOf("|"));
			line = line.replaceFirst(location + "\\|", "");
				
			street = line.substring(0, line.indexOf("|"));
			line = line.replaceFirst(street + "\\|", "");
				
			if(street.contains("_")) {
				
				String streetName = street.substring(0, street.indexOf("_"));
				String streetNum = street.substring(street.indexOf("_") + 1, street.length());
				street = streetName + " " + streetNum;
			}
			
			for(int i = 0; i < 4; i++) {
				
				if(i < 3) {
					
					price.add(Double.parseDouble(line.substring(0, line.indexOf(","))));
					String pricS = line.substring(0, line.indexOf(","));
					line = line.replaceFirst(pricS + ",", "");
				}
				else {
					
					price.add(Double.parseDouble(line.substring(0, line.indexOf("|"))));
					String pricS = line.substring(0, line.indexOf("|"));
					line = line.replaceFirst(pricS + "\\|", "");
				}
			}
			
			for(int i = 0; i < 4; i++) {
				
				if(i < 3) {
					
					roomsSize.add(Integer.parseInt(line.substring(0, line.indexOf(","))));
					String sizePersons = line.substring(0, line.indexOf(","));;
					line = line.replaceFirst(sizePersons + ",", "");
				}
				else {
					
					roomsSize.add(Integer.parseInt(line.substring(0, line.indexOf("|"))));
					String sizePersons = line.substring(0, line.indexOf("|"));;
					line = line.replaceFirst(sizePersons + "\\|", "");
				}
			}
			
			for(int i = 0; i < 4; i++) {
				
				int front = 0;
				int back = 0;
				String dollarCheckF = "";
				String dollarCheckL = "";
				String changeCategSymbolChecker = "";
				
				if(i == 0) {
					
					front = 1;
					back = line.indexOf(",");
					dollarCheckF = "\\$";
					changeCategSymbolChecker = ",";
				}
				else if(i > 0 && i < 3) {
					
					front = 0;
					back = line.indexOf(",");
					changeCategSymbolChecker = ",";
				}
				else if(i == 3) {
					
					front = 0;
					back = line.indexOf("|") - 1;
					dollarCheckL = "\\$";
					changeCategSymbolChecker = "\\|";
				}

				resRoomsSize.add(Integer.parseInt(line.substring(front, back)));
				String resSizePersons = line.substring(front, back);
				line = line.replaceFirst(dollarCheckF + resSizePersons + dollarCheckL + changeCategSymbolChecker, "");
			}

			stars = Integer.parseInt(line.substring(0, line.indexOf("|")));
			String starsString = line.substring(0, line.indexOf("|"));
			line = line.replaceFirst(starsString + "\\|", "");
			
			String pool = line.substring(0, line.indexOf("|"));
			extra.add(pool);
			line = line.replaceFirst(pool + "\\|", "");
			
			String gym = line.substring(0, line.indexOf("|"));
			extra.add(gym);
			line = line.replaceFirst(gym + "\\|", "");
			
			String restau = line.substring(0, line.indexOf("|"));
			extra.add(restau);
			line = line.replaceFirst(restau + "\\|", "");
			
			String breakf = line.substring(0, line.indexOf("|"));
			extra.add(breakf);
			line = line.replaceFirst(breakf + "\\|", "");
			
			String lunch = line.substring(0, line.indexOf("|"));
			extra.add(lunch);
			line = line.replaceFirst(lunch + "\\|", "");
		
			Hotel h = new Hotel(name, location, street, price, roomsSize, resRoomsSize, stars, extra);

			hotels.add(h);
		}*/
	}
