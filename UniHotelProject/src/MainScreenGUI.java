import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


public class MainScreenGUI extends JFrame {

	private JPanel contentPane;
	private JPanel filterPanel;
	private JSlider slider;
	private JSlider slider_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JList hotelList;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton button;
	private JButton btnNewButton;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnLunch;
	private JRadioButton rdbtnLunch_1;
	private JRadioButton rdbtnLunch_2;
	private ArrayList<Hotel> hotels = new ArrayList();
	private ArrayList<User> users = new ArrayList();
	private JPanel listPanel;
	private SpringLayout spr ;
	
	public MainScreenGUI() {
		
	}
	
	public void run(ArrayList<Hotel> hotels, ArrayList<User> users) {
		
		try {
		
			MainScreenGUI frame = new MainScreenGUI(hotels, users);
			frame.setVisible(true);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MainScreenGUI(ArrayList<Hotel> hotels, ArrayList<User> users) {
		
		this.hotels = hotels;
		this.users = users;
		
		setResizable(false);
		setUndecorated(true);
		this.hotels = hotels;
		this.users = users;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 575);
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
		
		slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
		slider.setForeground(new Color(176, 196, 222));
		slider.setBackground(new Color(119, 136, 153));
		slider.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		slider.setBounds(10, 71, 270, 34);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		filterPanel.add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("rating");
		lblNewLabel_2.setForeground(new Color(176, 196, 222));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(183, 133, 59, 14);
		filterPanel.add(lblNewLabel_2);
		
		slider_1 = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
		slider_1.setForeground(new Color(176, 196, 222));
		slider_1.setBackground(new Color(119, 136, 153));
		slider_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setBounds(183, 144, 146, 45);
		slider_1.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		filterPanel.add(slider_1);
		
		JLabel lblNewLabel_3 = new JLabel("Room size");
		lblNewLabel_3.setForeground(new Color(176, 196, 222));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(19, 223, 79, 14);
		filterPanel.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(553, 72, 2, -69);
		filterPanel.add(separator);
		
		rdbtnNewRadioButton = new JRadioButton("Gym");
		rdbtnNewRadioButton.setForeground(new Color(176, 196, 222));
		rdbtnNewRadioButton.setBackground(new Color(119, 136, 153));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(19, 374, 59, 23);
		filterPanel.add(rdbtnNewRadioButton);
		
		rdbtnLunch = new JRadioButton("Breakfast");
		rdbtnLunch.setForeground(new Color(176, 196, 222));
		rdbtnLunch.setBackground(new Color(119, 136, 153));
		rdbtnLunch.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnLunch.setBounds(19, 424, 79, 23);
		filterPanel.add(rdbtnLunch);
		
		rdbtnLunch_1 = new JRadioButton("Restaurant");
		rdbtnLunch_1.setForeground(new Color(176, 196, 222));
		rdbtnLunch_1.setBackground(new Color(119, 136, 153));
		rdbtnLunch_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnLunch_1.setBounds(229, 374, 88, 23);
		filterPanel.add(rdbtnLunch_1);
		
		rdbtnLunch_2 = new JRadioButton("Lunch");
		rdbtnLunch_2.setForeground(new Color(176, 196, 222));
		rdbtnLunch_2.setBackground(new Color(119, 136, 153));
		rdbtnLunch_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnLunch_2.setBounds(132, 424, 79, 23);
		filterPanel.add(rdbtnLunch_2);
		
		btnNewButton = new JButton("Apply");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setForeground(new Color(119, 136, 153));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(132, 484, 100, 23);
		filterPanel.add(btnNewButton);
		
		String [] hotelStars = {"1 star", "2 star", "3 star", "4 star", "5 star"};
		comboBox = new JComboBox(hotelStars);
		comboBox.setForeground(new Color(176, 196, 222));
		comboBox.setBorder(null);
		comboBox.setBackground(new Color(240, 248, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox.setBounds(19, 158, 125, 22);
		filterPanel.add(comboBox);
		
		String [] roomSizes = {"single room", "double room", "triple room", "quadruple room"};
		comboBox_1 = new JComboBox(roomSizes);
		comboBox_1.setForeground(new Color(176, 196, 222));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_1.setBounds(19, 248, 125, 22);
		filterPanel.add(comboBox_1);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Pool");
		rdbtnNewRadioButton_1.setForeground(new Color(176, 196, 222));
		rdbtnNewRadioButton_1.setBackground(new Color(119, 136, 153));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(132, 374, 69, 23);
		filterPanel.add(rdbtnNewRadioButton_1);
		
		JLabel lblFilters = new JLabel("FILTERS");
		lblFilters.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblFilters.setForeground(new Color(176, 196, 222));
		lblFilters.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilters.setBounds(103, 11, 139, 14);
		filterPanel.add(lblFilters);
		
		JLabel lblNewLabel_4 = new JLabel("Services");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(176, 196, 222));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(132, 306, 79, 34);
		filterPanel.add(lblNewLabel_4);
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
		DefaultListModel listModel = new DefaultListModel();
		
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
		
		JLabel lblNewLabel_5 = new JLabel("Hotels");
		lblNewLabel_5.setForeground(new Color(119, 136, 153));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setForeground(new Color(128, 128, 128));
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBorder(null);
		
		btnNewButton_3 = new JButton("Enter");
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(119, 136, 153));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_3.setForeground(new Color(245, 245, 245));
		GroupLayout gl_listPanel = new GroupLayout(listPanel);
		gl_listPanel.setHorizontalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addContainerGap(339, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_listPanel.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_listPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(listScroller, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_listPanel.setVerticalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addGap(92)
					.addComponent(lblNewLabel_5)
					.addGap(18)
					.addComponent(listScroller, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		listPanel.setLayout(gl_listPanel);
		
		btnNewButton_2 = new JButton("X");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setForeground(new Color(119, 136, 153));
		btnNewButton_2.setBackground(new Color(176, 196, 222));
		btnNewButton_2.setBorder(null);
		spr.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, contentPane);
		spr.putConstraint(SpringLayout.WEST, btnNewButton_2, 740, SpringLayout.WEST, contentPane);
		spr.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.NORTH, listPanel);
		spr.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_2);
		
		button = new JButton("-");
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setForeground(new Color(119, 136, 153));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("Tahoma", Font.PLAIN, 36));
		button.setBackground(new Color(176, 196, 222));
		button.setBorder(null);
		spr.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, contentPane);
		spr.putConstraint(SpringLayout.WEST, button, 692, SpringLayout.WEST, contentPane);
		spr.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.NORTH, listPanel);
		spr.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.WEST, btnNewButton_2);
		contentPane.add(button);	
	}
	
	/**
	*Method for all the code creating events.
	*/
	private void createEvents() {
		
		btnNewButton_1.addActionListener(e -> {
			
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to Log out?", "Title on Box", dialogButton);
			
			if(dialogResult == 0) {
			 
				this.setVisible(false);
				this.dispose();
				LogInGUI logInGUI = new LogInGUI();
				logInGUI.run(users, null, hotels);
			}
		});
		
		btnNewButton_2.addActionListener(e -> {
			
			System.exit(0);
		});
		
		button.addActionListener(e -> {
			
			setState(JFrame.ICONIFIED);
		});
	}
}