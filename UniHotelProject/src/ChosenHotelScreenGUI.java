import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class ChosenHotelScreenGUI extends JFrame {

	private JPanel contentPane;
	private JTextField cardField;
	private ArrayList<Hotel> hotels = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	private Hotel h;
	private User u;
	private JButton backBtn;
	private JButton xBtn;
	private JButton btnNewButton;
	private JButton checkoutBtn;
	private JButton minBtn;
	private JComboBox comboBox;
	private JList userRList;
	private JScrollPane scroller;
	
	public ChosenHotelScreenGUI() {
		
	}
	
	/**
	 * Launch the application.
	 */
	public void run(ArrayList<Hotel> hotels, ArrayList<User> users, Hotel h, User u) {
		
		try {
			
			ChosenHotelScreenGUI frame = new ChosenHotelScreenGUI(hotels, users, h, u);
			frame.setVisible(true);
		}
		catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ChosenHotelScreenGUI(ArrayList<Hotel> hotels, ArrayList<User> users, Hotel h, User u) {
		
		this.hotels = hotels;
		this.users = users;
		this.h = h;
		this.u = u;
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new LineBorder(new Color(240, 248, 255), 3));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		backBtn = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.WEST, backBtn, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, backBtn, 47, SpringLayout.WEST, contentPane);
		backBtn.setBackground(new Color(240, 248, 255));
		backBtn.setForeground(new Color(176, 196, 222));
		backBtn.setBorder(null);
		backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(backBtn);
		
		JLabel nameLbl = new JLabel(h.getName());
		sl_contentPane.putConstraint(SpringLayout.WEST, nameLbl, 101, SpringLayout.EAST, backBtn);
		sl_contentPane.putConstraint(SpringLayout.NORTH, backBtn, 12, SpringLayout.NORTH, nameLbl);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameLbl, 18, SpringLayout.NORTH, contentPane);
		nameLbl.setForeground(new Color(70, 130, 180));
		nameLbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nameLbl);
		
		JLabel locLbl = new JLabel("Location: "+ h.getLocation());
		sl_contentPane.putConstraint(SpringLayout.NORTH, locLbl, 21, SpringLayout.SOUTH, nameLbl);
		sl_contentPane.putConstraint(SpringLayout.WEST, locLbl, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, locLbl, -400, SpringLayout.EAST, contentPane);
		locLbl.setHorizontalAlignment(SwingConstants.CENTER);
		locLbl.setForeground(new Color(70, 130, 180));
		locLbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		contentPane.add(locLbl);
		
		JLabel strLbl = new JLabel("Street: " + h.getStreet());
		sl_contentPane.putConstraint(SpringLayout.NORTH, strLbl, 10, SpringLayout.SOUTH, locLbl);
		sl_contentPane.putConstraint(SpringLayout.WEST, strLbl, 10, SpringLayout.WEST, locLbl);
		sl_contentPane.putConstraint(SpringLayout.EAST, strLbl, -410, SpringLayout.EAST, contentPane);
		strLbl.setHorizontalAlignment(SwingConstants.CENTER);
		strLbl.setForeground(new Color(70, 130, 180));
		strLbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(strLbl);
		
		xBtn = new JButton("X");
		sl_contentPane.putConstraint(SpringLayout.NORTH, xBtn, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, xBtn, -40, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, xBtn, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, xBtn, 0, SpringLayout.EAST, contentPane);
		xBtn.setForeground(new Color(70, 130, 180));
		xBtn.setBackground(new Color(240, 248, 255));
		xBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		xBtn.setBorder(null);
		contentPane.add(xBtn);
		
		JLabel servLbl = new JLabel("Services");
		sl_contentPane.putConstraint(SpringLayout.NORTH, servLbl, 105, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, servLbl, 85, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, servLbl, 85, SpringLayout.SOUTH, contentPane);
		servLbl.setForeground(new Color(70, 130, 180));
		servLbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(servLbl);
		
		DefaultListModel includeModel = new DefaultListModel();
		DefaultListModel notIncludeModel = new DefaultListModel();
		DefaultListModel servicesModel = new DefaultListModel();
		
		if(h.hasAGym()) {
		
			servicesModel.addElement("Gym");
		}
		System.out.println(h.hasAGym() + " " + h.hasAPool());
		if(h.hasAPool()) {
			
			servicesModel.addElement("Pool");
		}
		if(h.hasARestaurant()) {
		
			servicesModel.addElement("Restaurant");
		}
		
		if(h.hasBreakfast()) {
			
			includeModel.addElement("Breakfast");
		}
		else { 
			
			notIncludeModel.addElement("Breakfast");
		}
		
		if(h.hasLunch()) {
			
			includeModel.addElement("Lunch");
		}
		else {
			
			notIncludeModel.addElement("Lunch");
		}
		
		if(servicesModel.isEmpty()) {
			
			servicesModel.addElement("No Service Found");
		}
		
		if(includeModel.isEmpty()) {
			
			includeModel.addElement("No Food Is Included");
		}

		if(notIncludeModel.isEmpty()) {
	
			notIncludeModel.addElement("Every Food Is Included");
		}
	
		JList servicesList = new JList(servicesModel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, servicesList, 412, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, servicesList, -100, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, servicesList, 40, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, servicesList, -300, SpringLayout.EAST, strLbl);
		servicesList.setSelectionForeground(new Color(240, 248, 255));
		servicesList.setSelectionBackground(new Color(0, 120, 215));
		servicesList.setForeground(new Color(70, 130, 180));
		servicesList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		servicesList.setBackground(new Color(240, 248, 255));
		contentPane.add(servicesList);
		
		JLabel detLbl = new JLabel("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, detLbl, 140, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, detLbl, -40, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, detLbl, 0, SpringLayout.EAST, locLbl);
		detLbl.setHorizontalAlignment(SwingConstants.CENTER);
		detLbl.setForeground(new Color(70, 130, 180));
		detLbl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(detLbl);
		
		JTextArea detTxt = new JTextArea(h.getDetails());
		detTxt.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, detTxt, 165, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, detTxt, -360, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, detLbl, 0, SpringLayout.NORTH, detTxt);
		sl_contentPane.putConstraint(SpringLayout.WEST, detTxt, 40, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, detTxt, -100, SpringLayout.EAST, locLbl);
		detTxt.setForeground(new Color(70, 130, 180));
		detTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		detTxt.setBackground(new Color(240, 248, 255));
		contentPane.add(detTxt);
		
		JLabel lblFood = new JLabel("Food");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblFood, -240, SpringLayout.NORTH, detTxt);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFood, -360, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblFood, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblFood, -100, SpringLayout.EAST, contentPane);
		lblFood.setForeground(new Color(70, 130, 180));
		lblFood.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblFood);
		
		JPanel rsvPanel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, rsvPanel, 400, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, rsvPanel, 200, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, rsvPanel, -50, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, rsvPanel, -500, SpringLayout.EAST, contentPane);
		rsvPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		rsvPanel.setBackground(new Color(240, 248, 255));
		contentPane.add(rsvPanel);
		rsvPanel.setLayout(null);
		
		JLabel lblReservation = new JLabel("RESERVATION");
		lblReservation.setForeground(new Color(70, 130, 180));
		lblReservation.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservation.setBounds(30, 0, 140, 26);
		rsvPanel.add(lblReservation);
		
		JLabel lblPeople = new JLabel("People");
		lblPeople.setForeground(new Color(70, 130, 180));
		lblPeople.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPeople.setBounds(10, 37, 48, 14);
		rsvPanel.add(lblPeople);
		
		Vector freeRooms = new Vector();
		
		if(h.GetFreeRoomsFor(1) > 0) {
			
			freeRooms.add(1);
		}
		
		if(h.GetFreeRoomsFor(2) > 0) {
			
			freeRooms.add(2);
		}

		if(h.GetFreeRoomsFor(3) > 0) {
	
			freeRooms.add(3);
		}

		if(h.GetFreeRoomsFor(4) > 0) {
	
			freeRooms.add(4);
		}
		
		comboBox = new JComboBox(freeRooms);
		comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox.setForeground(new Color(70, 130, 180));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(70, 34, 50, 20);
		rsvPanel.add(comboBox);
		
		JLabel lblCard = new JLabel("Card");
		lblCard.setForeground(new Color(70, 130, 180));
		lblCard.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCard.setBounds(10, 77, 41, 14);
		rsvPanel.add(lblCard);
		
		cardField = new JTextField();
		cardField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		cardField.setForeground(new Color(70, 130, 180));
		cardField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cardField.setBounds(61, 74, 119, 20);
		rsvPanel.add(cardField);
		cardField.setColumns(10);
		
		checkoutBtn = new JButton("Checkout");
		checkoutBtn.setBackground(new Color(70, 130, 180));
		checkoutBtn.setBorder(null);
		checkoutBtn.setForeground(new Color(240, 248, 255));
		checkoutBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		checkoutBtn.setBounds(60, 125, 84, 23);
		rsvPanel.add(checkoutBtn);
		
		JLabel lblIncludes = new JLabel("Includes:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIncludes, 105, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblIncludes, -290, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIncludes, 250, SpringLayout.NORTH, contentPane);
		lblIncludes.setForeground(new Color(240, 248, 255));
		lblIncludes.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblIncludes);
		
		JLabel lblDoesntInclude = new JLabel("Doesn't include:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIncludes, 160, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDoesntInclude, 250, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDoesntInclude, -40, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDoesntInclude, 0, SpringLayout.SOUTH, contentPane);
		lblDoesntInclude.setForeground(new Color(240, 248, 255));
		lblDoesntInclude.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblDoesntInclude);
		
		JList includeList = new JList(includeModel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, includeList, 300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, includeList, 60, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, includeList, -240, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, includeList, -690, SpringLayout.EAST, contentPane);
		includeList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		includeList.setBackground(new Color(240, 248, 255));
		includeList.setForeground(new Color(70, 130, 180));
		includeList.setSelectionForeground(new Color(240, 248, 255));
		contentPane.add(includeList);
		
		JList notIncludeList = new JList(notIncludeModel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, notIncludeList, 300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, notIncludeList, -240, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, notIncludeList, -520, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, notIncludeList, 230, SpringLayout.WEST, contentPane);
		notIncludeList.setSelectionForeground(new Color(240, 248, 255));
		notIncludeList.setSelectionBackground(new Color(0, 120, 215));
		notIncludeList.setForeground(new Color(70, 130, 180));
		notIncludeList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		notIncludeList.setBackground(new Color(240, 248, 255));
		contentPane.add(notIncludeList);
		
		String stringStars = "";
		
		for(int i = 0; i < h.getStars(); i++) {
			
			stringStars += "*";
		}
		
		JLabel starLabel = new JLabel("Stars: " + stringStars);
		sl_contentPane.putConstraint(SpringLayout.WEST, starLabel, 190, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, starLabel, 100, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, starLabel, 0, SpringLayout.NORTH, locLbl);
		starLabel.setHorizontalAlignment(SwingConstants.CENTER);
		starLabel.setForeground(new Color(70, 130, 180));
		starLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contentPane.add(starLabel);
		
		JLabel avgRLbl = new JLabel("Average rating: " + h.GetAverageRating());
		sl_contentPane.putConstraint(SpringLayout.WEST, avgRLbl, 6, SpringLayout.EAST, locLbl);
		sl_contentPane.putConstraint(SpringLayout.EAST, avgRLbl, -150, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, avgRLbl, 0, SpringLayout.NORTH, strLbl);
		avgRLbl.setHorizontalAlignment(SwingConstants.CENTER);
		avgRLbl.setForeground(new Color(70, 130, 180));
		avgRLbl.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contentPane.add(avgRLbl);
		
		JLabel lblUsersRatings = new JLabel("Users ratings");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsersRatings, -300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUsersRatings, 550, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblUsersRatings, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblUsersRatings, 0, SpringLayout.EAST, contentPane);
		lblUsersRatings.setForeground(new Color(70, 130, 180));
		lblUsersRatings.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contentPane.add(lblUsersRatings);
		
		JLabel lblUsersComments = new JLabel("Users comments");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsersComments, 160, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUsersComments, 710, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblUsersComments, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblUsersComments, 0, SpringLayout.EAST, contentPane);
		lblUsersComments.setForeground(new Color(70, 130, 180));
		lblUsersComments.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contentPane.add(lblUsersComments);
		
		DefaultListModel model = new DefaultListModel();
		
		userRList = new JList();
		userRList.setBackground(new Color(240, 248, 255));
		
		scroller = new JScrollPane(userRList);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scroller, 165, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scroller, 500, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scroller, -210, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scroller, -195, SpringLayout.EAST, contentPane);
		scroller.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroller);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		textArea.setBackground(new Color(240, 248, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 400, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 470, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -100, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -50, SpringLayout.EAST, contentPane);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("See the Comment");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 260, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 710, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -300, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -70, SpringLayout.EAST, contentPane);
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(70, 130, 180)));
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setForeground(new Color(70, 130, 180));
		contentPane.add(btnNewButton);
		
		minBtn = new JButton("-");
		sl_contentPane.putConstraint(SpringLayout.EAST, nameLbl, -54, SpringLayout.WEST, minBtn);
		sl_contentPane.putConstraint(SpringLayout.NORTH, minBtn, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, minBtn, -40, SpringLayout.WEST, xBtn);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, minBtn, 0, SpringLayout.SOUTH, xBtn);
		sl_contentPane.putConstraint(SpringLayout.EAST, minBtn, 0, SpringLayout.WEST, xBtn);
		minBtn.setForeground(new Color(70, 130, 180));
		minBtn.setFont(new Font("Tahoma", Font.PLAIN, 32));
		minBtn.setBorder(null);
		minBtn.setBackground(new Color(240, 248, 255));
		contentPane.add(minBtn);
		
		createEvents();
	}
	
	private void createEvents() {
		
		backBtn.addActionListener(e -> {
			
			this.setVisible(false);
			this.dispose();
			MainScreenGUI mainScreenGUI = new MainScreenGUI();
			mainScreenGUI.run(hotels, users, u);
		});
		
		xBtn.addActionListener(e -> {
			
			System.exit(0);
		});
		
		minBtn.addActionListener(e -> {
			
			setState(JFrame.ICONIFIED);
		});
	}
}