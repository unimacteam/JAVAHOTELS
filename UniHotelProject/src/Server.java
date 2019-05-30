import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Server {
	
	private ArrayList<Hotel> hotels = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<User> activeUsers = new ArrayList<>();

	public Server() {
		
		//READ HOTELS DATA FROM FILESERVER
		String fileHotels = "FilesServer/Hotels.txt";

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

		//READ USERS DATA FROM FILESERVER
		String fileUsers = "FilesServer/Users.txt";

		try { 

			FileReader frU = new FileReader(fileUsers);
			BufferedReader readerU = new BufferedReader(frU);

			boolean checkU = false;
			String lineU = readerU.readLine();
			while(lineU != null) {

				if(checkU) {
					
					CreateUsers(lineU);
				}

				lineU = readerU.readLine();
				checkU = true;
			}

			readerU.close();
		}
		catch(IOException e) {

			e.printStackTrace();
		}
		
		Check();
		
		//CONNECT FILES TO PROGRAMM, SO IT CAN WRITE DATA TO THEM
		//new SignUpForm(users, activeUsers);
	}
	
	
	public void CreateHotels(String line) {
		
		String name = "";
		String location = "";
		String street = "";
		double price = 0;
		ArrayList<Integer> roomsSize = new ArrayList<>();
		ArrayList<Integer> resRoomsSize = new ArrayList<>();
		int stars = 0;
		
		line = line.replaceAll("\\s+", "");
			
		name = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(name + "\\|", "");
		
		location = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(location + "\\|", "");
			
		street = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(street + "\\|", "");
			
		if(street.contains("_")) {
				
			String streetName = street.substring(0, street.indexOf("_"));
			String streetNum = street.substring(street.indexOf("_") + 1, street.length());
			street = streetName + " " + streetNum;
		}
		
		price = Double.parseDouble(line.substring(0, line.indexOf("|")));
		String pricS = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(pricS + "\\|", "");
	
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
		line = line.replaceAll(stars + "\\|", "");
			
		Hotel h = new Hotel(name, location, street, price, roomsSize, resRoomsSize, stars);

		hotels.add(h);
	}
	
	public void CreateUsers(String line) {

		String userName = "";
		String password = "";
		String name = "";
		String lastName = "";
		String email = "";

		line = line.replaceAll("\\s+", "");

		userName = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(userName + "\\|", "");

		password = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(password + "\\|", "");

		name = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(name + "\\|", "");

		lastName = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(lastName + "\\|", "");

		email = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(email + "\\|", "");

		User u = new User(userName, password, email, name, lastName);
		users.add(u);
	}

	public ArrayList<Hotel> GetHotelsList() {

		return hotels;
	}

	public ArrayList<User> GetUsersList() {

		return users;
	}
	
	//CLASS ONLY FOR CHECKS OF OTHER FUNCTIONS
	public void Check() {
		
		Hotel h = hotels.get(0);
			
			System.out.println("Free Rooms " + h.UserReservedAtThisHotelAndReturnFreeRooms(users.get(0), h, 3) + " | " + h.getName());
			h.WriteRatingAndComment(h, users.get(0), 3, "JJ");
			System.out.println("Rates: " + h.GetAverageRating());
	}
}
