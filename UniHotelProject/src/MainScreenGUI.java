import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class MainScreenGUI extends JFrame {

	//CONTAINER PANEL
	private JPanel mainPanel = new JPanel();
	
	//FILTERS PANEL
	private JPanel filterPanel = new JPanel();
	
	//SHOWROOM PANEL
	private JPanel shwRPanel = new JPanel();
	
	//HOTELS PANEL LIST
	private ArrayList<JPanel> hotelsListPanel = new ArrayList<>();
	
	//ARRAYLIST
	private ArrayList<Hotel> hotels = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	
	public MainScreenGUI(ArrayList<Hotel> hotels, ArrayList<User> users) {
		
		this.hotels = hotels;
		this.users = users;
		
		this.setContentPane(mainPanel);
		
		this.setSize(1300, 900);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CreateFilters();
		CreateShowRoom();
	}
	
	public void CreateFilters() {
		
		filterPanel.setBounds(20, 20, mainPanel.getWidth() - 30, 121);
		filterPanel.setBorder(new LineBorder(Color.RED));
		
		mainPanel.add(filterPanel);
	}
	
	public void CreateShowRoom() {
		
		int cH = hotels.size();
		int hC = 0;
		
		shwRPanel.setBounds(20, 200, filterPanel.getWidth(), cH * 300);
		shwRPanel.setBackground(Color.WHITE);
		shwRPanel.setBorder(new LineBorder(Color.BLUE));
		shwRPanel.setLayout(new GridBagLayout());
	
		JScrollPane scrollPaneShwR = new JScrollPane(shwRPanel);
		scrollPaneShwR.setBackground(Color.BLACK);
		scrollPaneShwR.setPreferredSize(new Dimension(shwRPanel.getWidth(), shwRPanel.getHeight()));
		mainPanel.add(scrollPaneShwR);
		
		for(Hotel h :hotels) {
			
			hC++;
			ListInHotel(h, hC);
		}
		
		scrollPaneShwR.setSize(shwRPanel.getWidth(), shwRPanel.getHeight());
	}
	
	public void ListInHotel(Hotel h, int hotelCounter) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel hotelPanel = new JPanel();
		hotelPanel.setName(h.getName());

		if(hotelCounter == 1) {
			
			//hotelPanel.setBounds(1, 40, shwRPanel.getWidth() - 2, 200);
			hotelPanel.setPreferredSize(new Dimension(500, 200));
			gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 0;
		}
		else {
			
			//hotelPanel.setBounds(1, ((hotelCounter - 1) * 240) + 40, shwRPanel.getWidth() - 2, 200);
			hotelPanel.setPreferredSize(new Dimension(500, 200));
			gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = hotelCounter;
		}
		
		hotelPanel.setBackground(Color.ORANGE);
		hotelPanel.setBorder(new LineBorder(Color.GREEN));;
		
		shwRPanel.add(hotelPanel, gbc);
		hotelsListPanel.add(hotelPanel);
		//System.out.println(hotelCounter);
	}
}
