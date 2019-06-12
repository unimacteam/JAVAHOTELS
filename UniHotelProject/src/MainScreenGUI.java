import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//ΤΟ ΚΟΜΜΑΤΙ ΜΕ ΤΙΣ ΗΜΕΡΟΜΗΝΙΕΣ ΔΕΝ ΤΟ ΠΡΟΛΑΒΑΙΝΑΜΕ ΓΙ ΑΥΤΟ ΤΟ ΑΦΗΣΑΜΕ ΕΚΤΟΣ. ΩΣΤΟΣΟ ΔΟΥΛΕΨΑΜΕ ΣΚΛΗΡΑ ΓΙΑ ΤΑ ΥΠΟΛΟΙΠΑ
public class MainScreenGUI extends JFrame {

	private JPanel contentPane;
	private JPanel filterPanel;
	private JSlider priceSlider;
	private JSlider ratingSlider;
	private JComboBox starsBox;
	private JComboBox roomSizeBox;
	private JComboBox locationBox;
	private JList hotelList;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnEnter;
	private JButton button;
	private JButton btnApply;
	private JRadioButton rdbtnGym;
	private JRadioButton rdbtnPool;
	private JRadioButton rdbtnBreakfast;
	private JRadioButton rdbtnRestaurant;
	private JRadioButton rdbtnLunch;
	private JTextField rsizeField;
	private JTextField priceField;
	private JButton detailsButton;
	private JList reservationsList;
	private ArrayList<Hotel> hotels = new ArrayList();
	private ArrayList<User> users = new ArrayList();
	private User u;
	private JPanel listPanel;
	private SpringLayout spr ;
	private JTextField PriceF;
	
	private int numberOfGuests = 1;
	private int pricePerNight;
	private int avgRating = 3;
	private ArrayList<Hotel> applicableHotels = new ArrayList<>();
	private String city;
	private int extras[] = {0, 0, 0, 0 , 0};
	private DefaultListModel listModel;
	private int maxp;
	private int minp;
	private int initp;
	private int stars;
	private DefaultListModel rsvModel;
	private ArrayList<Integer> roomSizeOfResrv;
	private ArrayList<Double> pricesOfResrv;
	
	public MainScreenGUI() {
		
	}
	
	public void run(ArrayList<Hotel> hotels, ArrayList<User> users, User u) {
		
		try {
		
			MainScreenGUI frame = new MainScreenGUI(hotels, users, u);
			frame.setVisible(true);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MainScreenGUI(ArrayList<Hotel> hotels, ArrayList<User> users, User u) {
		
		this.hotels = hotels;
		this.users = users;
		this.u = u;

		setResizable(false);
		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new LineBorder(new Color(176, 196, 222), 2));
		setContentPane(contentPane);
		spr = new SpringLayout();
		contentPane.setLayout(spr);
		
		CreateFilters();
		CreateHotelList();
		createEvents();
	}
	
	
	public void CreateFilters() {
		
		//
		filterPanel = new JPanel();
		filterPanel.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(176, 196, 222)));
		filterPanel.setForeground(new Color(176, 196, 222));
		spr.putConstraint(SpringLayout.NORTH, filterPanel, 25, SpringLayout.NORTH, contentPane);
		spr.putConstraint(SpringLayout.SOUTH, filterPanel, 0, SpringLayout.SOUTH, contentPane);
		filterPanel.setBackground(new Color(119, 136, 153));
		spr.putConstraint(SpringLayout.WEST, filterPanel, 0, SpringLayout.WEST, contentPane);
		spr.putConstraint(SpringLayout.EAST, filterPanel, 370, SpringLayout.WEST, contentPane);
		contentPane.add(filterPanel);
		filterPanel.setLayout(null);
		//JLabels
		
		JLabel lblFilters = new JLabel("FILTERS");
		lblFilters.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblFilters.setForeground(new Color(176, 196, 222));
		lblFilters.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilters.setBounds(103, 11, 139, 14);
		filterPanel.add(lblFilters);
			
		JLabel lblNewLabel = new JLabel("Price per night");
		lblNewLabel.setForeground(new Color(176, 196, 222));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(19, 46, 79, 14);
		filterPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hotel stars");
		lblNewLabel_1.setForeground(new Color(176, 196, 222));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(19, 133, 69, 14);
		filterPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rating");
		lblNewLabel_2.setForeground(new Color(176, 196, 222));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(183, 133, 59, 14);
		filterPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Room size");
		lblNewLabel_3.setForeground(new Color(176, 196, 222));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(19, 223, 79, 14);
		filterPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Services");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(176, 196, 222));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(132, 306, 79, 34);
		filterPanel.add(lblNewLabel_4);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(new Color(176, 196, 222));
		lblLocation.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblLocation.setBounds(183, 223, 79, 14);
		filterPanel.add(lblLocation);
		
		//Sliders
		maxp = -1;
		
		for (Hotel h: hotels) {
			
			if(h.getPriceFor(numberOfGuests) > maxp) {
				
				maxp = (int) h.getPriceFor(numberOfGuests) + 1;
			}
		}
		
        minp = maxp;
        for(Hotel h: hotels) {
        	
        	if(h.getPriceFor(numberOfGuests) < minp) {
            
        		minp = (int) h.getPriceFor(numberOfGuests);
        	}
        }
        initp=(minp+maxp)/2;
        pricePerNight= initp;
        
		priceSlider = new JSlider(JSlider.HORIZONTAL, minp, maxp, initp);
		priceSlider.setForeground(new Color(176, 196, 222));
		priceSlider.setBackground(new Color(119, 136, 153));
		priceSlider.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		priceSlider.setBounds(10, 71, 270, 34);
		priceSlider.setMinorTickSpacing(10);
		priceSlider.setMajorTickSpacing(50);
		priceSlider.setPaintTicks(true);
		priceSlider.setPaintLabels(true);
		filterPanel.add(priceSlider);
		
		ratingSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
		ratingSlider.setForeground(new Color(176, 196, 222));
		ratingSlider.setBackground(new Color(119, 136, 153));
		ratingSlider.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ratingSlider.setPaintTicks(true);
		ratingSlider.setPaintLabels(true);
		ratingSlider.setMinorTickSpacing(1);
		ratingSlider.setBounds(183, 144, 146, 45);
		ratingSlider.setMajorTickSpacing(1);
		ratingSlider.setPaintTicks(true);
		ratingSlider.setPaintLabels(true);
		filterPanel.add(ratingSlider);
		
		//Separator
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(553, 72, 2, -69);
		filterPanel.add(separator);
			
		//Radio buttons
		rdbtnGym = new JRadioButton("Gym");
		rdbtnGym.setForeground(new Color(176, 196, 222));
		rdbtnGym.setBackground(new Color(119, 136, 153));
		rdbtnGym.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnGym.setBounds(19, 374, 59, 23);
		filterPanel.add(rdbtnGym);
		
		rdbtnBreakfast = new JRadioButton("Breakfast");
		rdbtnBreakfast.setForeground(new Color(176, 196, 222));
		rdbtnBreakfast.setBackground(new Color(119, 136, 153));
		rdbtnBreakfast.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnBreakfast.setBounds(19, 424, 79, 23);
		filterPanel.add(rdbtnBreakfast);
		
		rdbtnRestaurant = new JRadioButton("Restaurant");
		rdbtnRestaurant.setForeground(new Color(176, 196, 222));
		rdbtnRestaurant.setBackground(new Color(119, 136, 153));
		rdbtnRestaurant.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnRestaurant.setBounds(229, 374, 88, 23);
		filterPanel.add(rdbtnRestaurant);
		
		rdbtnLunch = new JRadioButton("Lunch");
		rdbtnLunch.setForeground(new Color(176, 196, 222));
		rdbtnLunch.setBackground(new Color(119, 136, 153));
		rdbtnLunch.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnLunch.setBounds(132, 424, 79, 23);
		filterPanel.add(rdbtnLunch);
			
		rdbtnPool = new JRadioButton("Pool");
		rdbtnPool.setForeground(new Color(176, 196, 222));
		rdbtnPool.setBackground(new Color(119, 136, 153));
		rdbtnPool.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnPool.setBounds(132, 374, 69, 23);
		filterPanel.add(rdbtnPool);
		
		//Buttons
		btnApply = new JButton("Apply");
		btnApply.setBorder(null);
		btnApply.setBackground(new Color(176, 196, 222));
		btnApply.setForeground(new Color(119, 136, 153));
		btnApply.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnApply.setBounds(132, 484, 100, 23);
		filterPanel.add(btnApply);
		
		//Combo boxes
		String [] hotelStars = {"1 star", "2 star", "3 star", "4 star", "5 star"};
		starsBox = new JComboBox(hotelStars);
		starsBox.setForeground(new Color(176, 196, 222));
		starsBox.setBorder(null);
		starsBox.setBackground(new Color(240, 248, 255));
		starsBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		starsBox.setBounds(19, 158, 125, 22);
		filterPanel.add(starsBox);
		
		String [] roomSizes = {"single room", "double room", "triple room", "quadruple room"};
		roomSizeBox = new JComboBox(roomSizes);
		roomSizeBox.setForeground(new Color(176, 196, 222));
		roomSizeBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		roomSizeBox.setBounds(19, 248, 125, 22);
		filterPanel.add(roomSizeBox);

		ArrayList<String> locations = new ArrayList<String>();
		for(Hotel h: hotels) {
			
			if(!locations.contains(h.getLocation())) {
			
				locations.add(h.getLocation());
			}
		}
		
		locationBox = new JComboBox(locations.toArray());
		locationBox.setForeground(new Color(176, 196, 222));
		locationBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		locationBox.setBounds(183, 248, 125, 22);
		filterPanel.add(locationBox);
		
		//JText Fields
		PriceF = new JTextField();
		PriceF.setBounds(280, 71, 50, 22);
		PriceF.setEditable(false);
		PriceF.setForeground(new Color(176, 196, 222));
		PriceF.setText(Integer.toString(initp));
		filterPanel.add(PriceF);
	}
	
	public void CreateHotelList() {
		
		listPanel = new JPanel();
		listPanel.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(176, 196, 222)));
		listPanel.setForeground(new Color(176, 196, 222));
		spr.putConstraint(SpringLayout.NORTH, listPanel, 25, SpringLayout.NORTH, contentPane);
		spr.putConstraint(SpringLayout.SOUTH, listPanel, 0, SpringLayout.SOUTH, contentPane);
		listPanel.setBackground(new Color(240, 248, 255));
		spr.putConstraint(SpringLayout.WEST, listPanel, 0, SpringLayout.EAST, filterPanel);
		spr.putConstraint(SpringLayout.EAST, listPanel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(listPanel);
		
		listModel = new DefaultListModel();
		
		for(Hotel h: hotels) {
			
			listModel.addElement(h.getName());
		}
		
		hotelList = new JList(listModel);
		hotelList.setSelectionBackground(new Color(176, 196, 222));
		hotelList.setSelectionForeground(new Color(119, 136, 153));
		hotelList.setBorder(new LineBorder(new Color(176, 196, 222), 2));
		hotelList.setBackground(new Color(119, 136, 153));
		hotelList.setForeground(new Color(240, 248, 255));
		hotelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hotelList.setLayoutOrientation(JList.VERTICAL);
		hotelList.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(hotelList);
		listScroller.setBackground(new Color(176, 196, 222));
		listScroller.setBorder(new LineBorder(new Color(119, 136, 153)));
		listScroller.setForeground(new Color(119, 136, 153));
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Label
		JLabel lblNewLabel_5 = new JLabel("Hotels");
		lblNewLabel_5.setForeground(new Color(119, 136, 153));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		//Buttons
		btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setForeground(new Color(119, 136, 153));
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBorder(null);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBorder(null);
		btnEnter.setBackground(new Color(119, 136, 153));
		btnEnter.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnEnter.setForeground(new Color(245, 245, 245));
		
		JScrollPane rsvScroller = new JScrollPane();
		rsvScroller.setBorder(new LineBorder(new Color(176, 196, 222)));
		rsvScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		rsvScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		detailsButton = new JButton("Details of your checkouts \u2193");
		detailsButton.setForeground(new Color(245, 245, 245));;
		detailsButton.setBackground(new Color(119, 136, 153));
		detailsButton.setBorder(null);
		detailsButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("My Reservations");
		lblNewLabel_6.setForeground(new Color(119, 136, 153));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		rsizeField = new JTextField();
		rsizeField.setEditable(false);
		rsizeField.setForeground(new Color(240, 248, 255));
		rsizeField.setBackground(new Color(119, 136, 153));
		rsizeField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setEnabled(false);
		priceField.setForeground(new Color(240, 248, 255));
		priceField.setBackground(new Color(119, 136, 153));
		priceField.setColumns(10);
		
		JLabel lblRoomSize = new JLabel("Room size");
		lblRoomSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomSize.setForeground(new Color(119, 136, 153));
		lblRoomSize.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(new Color(119, 136, 153));
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		GroupLayout gl_listPanel = new GroupLayout(listPanel);
		gl_listPanel.setHorizontalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addContainerGap(539, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_listPanel.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEnter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(listScroller, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
					.addGroup(gl_listPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_listPanel.createSequentialGroup()
							.addGap(18)
							.addGap(18)
							.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_listPanel.createSequentialGroup()
									.addComponent(rsvScroller, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(detailsButton, 0, 0, Short.MAX_VALUE)
								.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(100))
						.addGroup(gl_listPanel.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_listPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblRoomSize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rsizeField))
							.addGap(18)
							.addGroup(gl_listPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(priceField))
							.addGap(56))))
		);
		gl_listPanel.setVerticalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addGap(92)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6))
					.addGap(18)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_listPanel.createSequentialGroup()
							.addComponent(listScroller, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_listPanel.createSequentialGroup()
							.addGroup(gl_listPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_listPanel.createSequentialGroup()
									.addComponent(rsvScroller, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(detailsButton)
									.addGap(22))
								.addGroup(gl_listPanel.createSequentialGroup()
									.addGap(91)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_listPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRoomSize)
								.addComponent(lblPrice))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_listPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rsizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(78)))
					.addGap(24)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		rsvModel = new DefaultListModel();
		roomSizeOfResrv = new ArrayList<>();
		pricesOfResrv = new ArrayList<>();
		
		for(Hotel h :hotels) {
			
			for(CustomersList cL :h.getCustomersList()) {
				
				System.out.println(h.getName() + " " + cL.getUsername());
				if(cL.getUsername().equals(u.getUserName())) {
					
					rsvModel.addElement(h.getName());
					roomSizeOfResrv.add(cL.getRoomSize());
					pricesOfResrv.add(cL.getPricePaid());
				}
			}
		}
		
		reservationsList = new JList(rsvModel);
		reservationsList.setSelectionForeground(new Color(119, 136, 153));
		reservationsList.setSelectionBackground(new Color(176, 196, 222));
		reservationsList.setForeground(new Color(240, 248, 255));
		reservationsList.setBorder(new LineBorder(new Color(176, 196, 222)));
		reservationsList.setBackground(new Color(119, 136, 153));
		reservationsList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rsvScroller.setViewportView(reservationsList);
		listPanel.setLayout(gl_listPanel);
		
		if(rsvModel.isEmpty()) {
			
			rsvModel.addElement("No checkouts yet");
			reservationsList.setSelectionModel(new NoSelectionModel());
			reservationsList.setSelectionMode(new NoSelectionModel().SINGLE_INTERVAL_SELECTION);
		}
		
		btnNewButton_2 = new JButton("X");
		spr.putConstraint(SpringLayout.WEST, btnNewButton_2, 940, SpringLayout.WEST, contentPane);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setForeground(new Color(119, 136, 153));
		btnNewButton_2.setBackground(new Color(176, 196, 222));
		btnNewButton_2.setBorder(null);
		spr.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, contentPane);
		spr.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.NORTH, listPanel);
		spr.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_2);
		
		button = new JButton("-");
		spr.putConstraint(SpringLayout.WEST, button, 892, SpringLayout.WEST, contentPane);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setForeground(new Color(119, 136, 153));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("Tahoma", Font.PLAIN, 36));
		button.setBackground(new Color(176, 196, 222));
		button.setBorder(null);
		spr.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, contentPane);
		spr.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.NORTH, listPanel);
		spr.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.WEST, btnNewButton_2);
		contentPane.add(button);	
		
		for(Hotel h :hotels) {
			
			applicableHotels.add(h);
		}
	}
	
	/**
	*Method for all the code creating events.
	*/
	private void createEvents() {
		
		btnNewButton_1.addActionListener(e -> {
			
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to Log out?", "Travellers_Message", dialogButton);
			
			if(dialogResult == 0) {
			 
				this.setVisible(false);
				this.dispose();
				LogInGUI logInGUI = new LogInGUI();
				logInGUI.run(users, hotels);
			}
		});
		
		btnNewButton_2.addActionListener(e -> {
			
			System.exit(0);
		});
		
		button.addActionListener(e -> {
			
			setState(JFrame.ICONIFIED);
		});
		
		
		btnApply.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				
				applicableHotels.clear();
			
				city= (String) locationBox.getSelectedItem();
				numberOfGuests = roomSizeBox.getSelectedIndex() + 1;
				stars = starsBox.getSelectedIndex() + 1;
				extras[0] = rdbtnGym.isSelected() ? 1 : 0;
				extras[1] = rdbtnPool.isSelected() ? 1 : 0;
				extras[2] = rdbtnRestaurant.isSelected() ? 1 : 0;
				extras[3] = rdbtnRestaurant.isSelected() ? 1 : 0;
				extras[4] = rdbtnLunch.isSelected() ? 1 : 0;
				applicableHotels = new ArrayList<>();
				
				for(Hotel h: hotels)
					//int myInt = myBoolean ? 1 : 0;
				{	int tempExtras[] = {0,0,0,0,0};
					tempExtras[0] = h.hasAGym() ? 1 : 0;
					tempExtras[1] = h.hasAPool() ? 1 : 0;
					tempExtras[2] = h.hasARestaurant() ? 1 : 0;
					tempExtras[3] = h.hasBreakfast() ? 1 : 0;
					tempExtras[4] = h.hasLunch() ? 1 : 0;
					boolean hasAllExtras = true;
					
					if(h.getLocation() == city && (h.GetAverageRating()>=avgRating || h.GetAverageRating() == 0) && pricePerNight >= h.getPriceFor(numberOfGuests) 
							&& h.getStars() >= stars && (h.getAllRoomsFor(numberOfGuests) - h.getReservedRoomsFor(numberOfGuests) > 0)) {
						
						for(int i = 1; i < 5; i++) {
							
							if(tempExtras[i] < extras[i]) {
								
								hasAllExtras = false;
							}
						}
						
						if(hasAllExtras) {
							
							System.out.println(h.getName());
							applicableHotels.add(h);
						}
					}
				}

				listModel.clear();
				
				for(Hotel h: applicableHotels) {
				
					listModel.addElement(h.getName());
				}
			}
		});
		
		btnEnter.addActionListener(e -> {
				
			for(Hotel h: applicableHotels) {
				
				if(h.getName().equals(hotelList.getSelectedValue())) {
					
					this.setVisible(false);
					this.dispose();
					ChosenHotelScreenGUI chosenHScrGUI = new ChosenHotelScreenGUI();
					System.out.println(h.getName());
					chosenHScrGUI.run(hotels, users, h, u);
					break;
				}
			}
		});
		
		detailsButton.addActionListener(e -> {
			
			if(rsvModel.get(0).equals("No checkouts yet")) {
				
				JOptionPane.showMessageDialog(this, "No ckeckouts to pick!", "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				if(reservationsList.getSelectedValue() == null) {
				
					JOptionPane.showMessageDialog(this, "Select one of your checkouts first!", "Travellers_Message", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					int hotelIndex = reservationsList.getSelectedIndex();
			
					rsizeField.setText(String.valueOf(roomSizeOfResrv.get(hotelIndex)));
					priceField.setText(String.valueOf(pricesOfResrv.get(hotelIndex)));
				}
			}
		});
		
		priceSlider.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
			    
				JSlider source = (JSlider)e.getSource();
			    if(!source.getValueIsAdjusting()) {
			    	
			    	pricePerNight = (int)source.getValue();
			    	PriceF.setText(Integer.toString((int) pricePerNight));
			    }
			}
		});
		
		ratingSlider.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
			    JSlider source = (JSlider)e.getSource();
			    if(!source.getValueIsAdjusting()) {
			    	
			    	avgRating = (int)source.getValue();
			    	//priceF.setText(Double.toString(pricePerNight));
			        }
			    }
		});
		
		roomSizeBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				maxp  = -1;

				numberOfGuests = roomSizeBox.getSelectedIndex() + 1;
				for(Hotel h: hotels) {
					
					if(h.getPriceFor(numberOfGuests) > maxp) {
						
						maxp = (int) h.getPriceFor(numberOfGuests);
					}
				}
				maxp++;
	            minp = maxp;
	            
	            for(Hotel h: hotels) {
	            	
	            	if(h.getPriceFor(numberOfGuests) < minp) {
	            		
	            		minp = (int) h.getPriceFor(numberOfGuests);
	            	}
	            }
	            initp=(minp+maxp)/2;
	            
	            priceSlider.setMaximum(maxp);
	            priceSlider.setMinimum(minp);
	            priceSlider.setValue(initp);
			}	
		});	
	}
	
	private static class NoSelectionModel extends DefaultListSelectionModel {

		   @Override
		   public void setAnchorSelectionIndex(final int anchorIndex) {
			   
		   }

		   @Override
		   public void setLeadAnchorNotificationEnabled(final boolean flag) {
			   
		   }

		   @Override
		   public void setLeadSelectionIndex(final int leadIndex) {
			   
		   }

		   @Override
		   public void setSelectionInterval(final int index0, final int index1) { 
			   
			   super.setSelectionInterval(-1, -1);
		   }
	}
}