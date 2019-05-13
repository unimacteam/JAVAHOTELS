import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Server {
	
	private ArrayList<Hotel> hotels = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();

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
		
		//MAIN SCREEN CALL
		new MainScreenGUI(hotels, users);
	}
	
	
	public void CreateHotels(String line) {
		
		String name = "";
		String location = "";
		String street = "";
		double price = 0;
		
		line = line.replaceAll("\\s+", "");
			
		name = line.substring(0, line.indexOf(","));
		line = line.replaceAll(name + ",", "");
			
		location = line.substring(0, line.indexOf(","));
		line = line.replaceAll(location + ",", "");
			
		street = line.substring(0, line.indexOf(","));
		line = line.replaceAll(street + ",", "");
			
		if(street.contains("_")) {
				
			String streetName = street.substring(0, street.indexOf("_"));
			String streetNum = street.substring(street.indexOf("_") + 1, street.length());
			street = streetName + " " + streetNum;
		}
		
		String pricS = "";
		price = Double.parseDouble(line.substring(0, line.indexOf(",")));
		pricS = line.substring(0, line.indexOf(","));
		line = line.replaceAll(pricS + ",", "");
			
		Hotel h = new Hotel(name, location, street, price);

		hotels.add(h);
	}
	
	public void CreateUsers(String line) {

		String userName = "";
		String password = "";
		String name = "";
		String lastName = "";
		String email = "";

		line = line.replaceAll("\\s+", "");

		userName = line.substring(0, line.indexOf(","));
		line = line.replaceAll(userName + ",", "");

		password = line.substring(0, line.indexOf(","));
		line = line.replaceAll(password + ",", "");

		name = line.substring(0, line.indexOf(","));
		line = line.replaceAll(name + ",", "");

		lastName = line.substring(0, line.indexOf(","));
		line = line.replaceAll(lastName + ",", "");

		email = line.substring(0, line.indexOf(","));
		line = line.replaceAll(email + ",", "");

		/*User u = new User(userName, password, name, lastName, email);
		users.add(u);
		*/
	}

	public ArrayList<Hotel> GetHotelsList() {

		return hotels;
	}

	public ArrayList<User> GetUsersList() {

		return users;
	}
}
