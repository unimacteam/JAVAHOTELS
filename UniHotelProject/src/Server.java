import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
		
		//CONNECT FILES TO PROGRAMM, SO IT CAN WRITE DATA TO THEM
		//new SignUpForm(users, activeUsers);
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
	}
	
	public void CreateUsers(String line) {

		String userName = "";
		String password = "";
		String name = "";
		String lastName = "";
		String email = "";
		String status = "";

		line = line.replaceAll("\\s+", "");

		userName = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(userName + "\\|", "");

		password = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(password + "\\|", "");

		name = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(name + "\\|", "");

		lastName = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(lastName + "\\|", "");

		email = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(email + "\\|", "");
		
		status = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(status + "\\|", "");

		User u = new User(userName, password, email, name, lastName, status);
		users.add(u);
	}

	public ArrayList<Hotel> GetHotelsList() {

		return hotels;
	}

	public ArrayList<User> GetUsersList() {

		return users;
	}
}
