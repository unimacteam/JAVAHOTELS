import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;

public class FilterPanel {

		String city;
		float ratings;// this or better
		float pricePerNight;
		String  roomType;
		/*
		String dateOfArrival;
		String dateOfDeparture;
		int noOfRooms;
		String location;
		ArrayList<String> extraFilters;
		*/
		private JFrame filterFrame = new JFrame();
		private JLabel logo = new JLabel("Filters:");
		private JLabel cityL = new JLabel("City:");
		private JLabel roomTypeL = new JLabel("Room:");
		private JLabel pricePerNightL= new JLabel("Price/Night");
		private JLabel ratingsL= new JLabel("Guest ratings");
		
		private JComboBox cityList;
		private JComboBox roomTypeList;
		private JComboBox pricePerNightList;
		private JComboBox ratingsList;

		
		
		/*
		private JSpinner pricePerNightSpinner = new JSpinner();
		private JSpinner ratingsSpinner = new JSpinner();

		
		
		private JSlider pricePerNightSlider= new JSlider();
		private JSlider ratingsSlider= new JSlider();

		*/
	
		


		public FilterPanel(ArrayList<String> citiesAL) {
			
			Container container = filterFrame.getContentPane();
			container.setLayout(null);
			
			filterFrame.setBounds(200,100,400,350);
			
			//Label bounds

			logo.setBounds(180, 5, 250, 30);
			
			cityL.setBounds(20, 30, 250, 30);
			
			roomTypeL.setBounds(20, 60, 250, 30);
			
			
			pricePerNightL.setBounds(20, 90, 250, 30);
			
			
			ratingsL.setBounds(20, 120, 250, 30);
			
			//Combo box bounds
			
			cityList.setBounds(100, 30, 250, 30);
			
			
			roomTypeList.setBounds(100, 60, 250, 30);
			
			pricePerNightList.setBounds(100, 90, 250, 30);
			
			ratingsList.setBounds(100, 120, 250, 30);
			
			
			
			
			
			container.add(logo);
			container.add(cityL);
			container.add(roomTypeL);
			container.add(pricePerNightL);
			container.add(ratingsL);
			container.add(cityList);
			container.add(roomTypeList);
			container.add(pricePerNightList);
			container.add(ratingsList);
			
			filterFrame.setVisible(true);
			
			filterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
















}




