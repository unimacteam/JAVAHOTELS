import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FilterPanel {

		String city;
		double ratings;// this or better
		double pricePerNight;
		String  roomType;
		ArrayList<Hotel> applicableHotels;
		int numberOfGuests;
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
		
		private JTextField priceF = new JTextField();
		
		private JComboBox cityList;
		private JComboBox roomTypeList ;
		//private JComboBox pricePerNightList;
		
		
		
		private JSlider pricePerNightSlider;
		int minp;
		int maxp;
		int initp;
		
		
		private JComboBox ratingsList;

		private JButton applyFiltersBtn = new JButton("Apply Filters");
		
		
		
		
//		private JSlider ratingsSlider= new JSlider();
		
	
		


		public FilterPanel(ArrayList<String> citiesAL, ArrayList<Hotel> HotelsList) {
			
			Container container = filterFrame.getContentPane();
			container.setLayout(null);
			applicableHotels = new ArrayList<>();
			filterFrame.setBounds(200,100,400,350);
			
			
			//Calculate max and min for slider (initial)
			maxp  =-1;
			
			for (Hotel h: HotelsList)
			{	if(h.getPriceFor(1)>maxp)
				maxp=(int) h.getPriceFor(1) + 1;
			}
		
            minp = maxp;
            for (Hotel h: HotelsList)
            {    if(h.getPriceFor(1)<minp)
                minp=(int) h.getPriceFor(1);
            }
            initp=minp;
			
		
			pricePerNightSlider = new JSlider(JSlider.HORIZONTAL, 	minp, maxp, initp);
			
			
			//Label bounds

			logo.setBounds(180, 5, 250, 30);
			
			cityL.setBounds(20, 30, 250, 30);
			
			roomTypeL.setBounds(20, 60, 250, 30);
			
			
			pricePerNightL.setBounds(20, 90, 250, 30);
			priceF.setBounds(350, 90, 100, 30);
			priceF.setEditable(false);
			ratingsL.setBounds(20, 120, 250, 30);
			
			//Combo box contents
			cityList = new JComboBox<>(citiesAL.toArray());
			Integer[] rt = {1,2,3,4};
			roomTypeList = new JComboBox<>(rt);
			
			//pricePerNightList = new JComboBox<>(ppn);
			Integer[] rat = {0,5,8,9,10};
			ratingsList = new JComboBox<>(rat);

			
			//Combo box and slider bounds
			
			cityList.setBounds(100, 30, 250, 30);
			
			roomTypeList.setBounds(100, 60, 250, 30);
			
			pricePerNightSlider.setBounds(100, 190, 250, 30);
			
			ratingsList.setBounds(100, 120, 250, 30);
			
			//button bounds
			
			applyFiltersBtn.setBounds(100, 150, 250, 30);
			
			
			//button listener
			applyFiltersBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{	city= (String) cityList.getSelectedItem();
					ratings = (Integer) ratingsList.getSelectedItem();
					//pricePerNight = (Integer) pricePerNightList.getSelectedItem();
					numberOfGuests = (Integer) roomTypeList.getSelectedItem();
					
					for(Hotel h: HotelsList)
					{
						if ((h.getLocation()==city&&h.GetAverageRating()>=ratings&&pricePerNight>=h.getPriceFor(numberOfGuests))) 
						{
							
							 if ((h.getAllRoomsFor(numberOfGuests)-h.getReservedRoomsFor(numberOfGuests)>0))
								applicableHotels.add(h);
							
						}
					}
					System.out.println("Applicable hotels:");
				
						System.out.println(applicableHotels.isEmpty());
				}
			});
			
			//slider change listener
			
			
			
		
			pricePerNightSlider.addChangeListener(new ChangeListener(){
				public void stateChanged(ChangeEvent e) {
				    JSlider source = (JSlider)e.getSource();
				    if (!source.getValueIsAdjusting()) {
				    	pricePerNight = (int)source.getValue();
				    	priceF.setText(Double.toString(pricePerNight));
				        }
				    }
				});
			
			pricePerNightSlider.setBounds(180, 50, 250, 30);
				container.add(pricePerNightSlider);
			
				
				
				
				
			roomTypeList.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					maxp  =-1;
			
					int nOG;
					nOG = (Integer) roomTypeList.getSelectedItem();
					for (Hotel h: HotelsList)
					{	if(h.getPriceFor(nOG)>maxp)
							maxp=(int) h.getPriceFor(nOG) + 1;
					}
		            minp = maxp;
		            for (Hotel h: HotelsList)
		            {    if(h.getPriceFor(nOG)<minp)
		                minp=(int) h.getPriceFor(nOG);
		            }
		            initp=minp;
		            pricePerNightSlider = new JSlider(JSlider.HORIZONTAL, 	minp, maxp, initp);
		            System.out.println("new slider created");
				}	
				
			});
			container.add(logo);
			container.add(cityL);
			container.add(roomTypeL);
			container.add(pricePerNightL);
			container.add(ratingsL);
			container.add(cityList);
			container.add(roomTypeList);
			container.add(pricePerNightSlider);
			container.add(ratingsList);
			container.add(applyFiltersBtn);
			container.add(priceF);
			
			filterFrame.setVisible(true);
			
			filterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

}


