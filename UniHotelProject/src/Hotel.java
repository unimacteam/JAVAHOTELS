import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel {

	private String name = "";
	private String location = "";
	private String street = "";
	private double price = 0;
	private ArrayList<Integer> roomsSize = new ArrayList<>();
	private int roomsFor1 = 0;
	private int roomsFor2 = 0;
	private int roomsFor3 = 0;
	private int roomsFor4 = 0;
	private ArrayList<Integer> resRoomsSize = new ArrayList<>();
	private int resRoomsFor1 = 0;
	private int resRoomsFor2 = 0;
	private int resRoomsFor3 = 0;
	private int resRoomsFor4 = 0;
	private int stars = 0;
	private Map<Integer, User> usersInThisHotel = new HashMap<>();
	private Map<User, Integer> ratings = new HashMap<>();
	private Map<User, String> comments = new HashMap<>();
	
	public Hotel(String name, String location, String street, double price, ArrayList<Integer> roomsSize, ArrayList<Integer> resRoomsSize, int stars) {
		
		this.name = name;
		this.location = location;
		this.street = street;
		this.price = price;
		this.roomsSize = roomsSize;
		this.resRoomsSize = resRoomsSize;
		this.stars = stars;
		
		GiveDataFromResRoomsArrayToVar();
		CreateANewTxtFileForThisHotel();
	}
	
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getStreet() {
		return street;
	}

	public double getPrice() {
		return price;
	}
	
	public ArrayList<Integer> getRoomsPersonSize() {
		return roomsSize;
	}
	
	public int getAllRooms() {
		
		int c = 0;
		
		for(Integer r :roomsSize) {
			
			c += r;
		}
		
		return c;
	}
	
	public int getAllRoomsFor1() {
		
		roomsFor1 = roomsSize.get(0);
		
		return roomsFor1;
	}
	
	public int getAllRoomsFor2() {
		
		roomsFor2 = roomsSize.get(1);
		
		return roomsFor2;
	}
	
	public int getAllRoomsFor3() {
		
		roomsFor3 = roomsSize.get(2);
		
		return roomsFor3;
	}

	public int getAllRoomsFor4() {
	
		roomsFor4 = roomsSize.get(3);
	
		return roomsFor4;
	}
	
	public ArrayList<Integer> getReservedRoomsPersonSize() {
		return resRoomsSize;
	}
	
	public int getAllResRooms() {
		
		int c = 0;
		
		c = resRoomsFor1 + resRoomsFor2 + resRoomsFor3 + resRoomsFor4;
		
		return c;
	}
	
	public void GiveDataFromResRoomsArrayToVar() {
		
		System.out.println(getName());
		resRoomsFor1 = resRoomsSize.get(0);
		resRoomsFor2 = resRoomsSize.get(1);
		resRoomsFor3 = resRoomsSize.get(2);
		resRoomsFor4 = resRoomsSize.get(3);
	}
	
	public int getReservedRoomsFor1() {
		return resRoomsFor1;
	}
	
	public int getReservedRoomsFor2() {
		return resRoomsFor2;
	}
	
	public int getReservedRoomsFor3() {
		return resRoomsFor3;
	}
	
	public int getReservedRoomsFor4() {
		return resRoomsFor4;
	}
	
	public int getStars() {
		return stars;
	}

	public Map<User, Integer> getRatings() {
		return ratings;
	}
	
	public void AddRatingOfUser(User u, int rate) {
		
		System.out.println(u.getUserName() + rate);
		ratings.put(u, rate);
	}
	
	public void AddCommentOfUser(User u, String comment) {
		
		comments.put(u, comment);
	}
	
	public double GetAverageRating() {
		
		//cR = countRate
		double cR = 0, aR = 0;
		
		//ratings
		System.out.println(cR);
		for(Map.Entry<User, Integer> r :ratings.entrySet()) {
			
			cR += r.getValue();
			System.out.println(r.getValue());
		}
		
		aR = cR / ratings.size();
		String txt = new DecimalFormat("##.#").format(aR);
		aR = Double.parseDouble(txt);
		
		return aR;
	}
	
	public int UserReservedAtThisHotelAndReturnFreeRooms(User u, Hotel h, int numOfPersons) {
		
		int roomsLeft = 0;
		int c = 0;
		
		usersInThisHotel.put(numOfPersons, u);
		
		if(numOfPersons == 1) {
			
			resRoomsFor1++;
			c = resRoomsFor1;
		}
		else if(numOfPersons == 2) {
			
			resRoomsFor2++;
			c = resRoomsFor2;
		}
		else if(numOfPersons == 3) {
			
			resRoomsFor3++;
			c = resRoomsFor3;
		}
		else if(numOfPersons == 4) {
			
			resRoomsFor4++;
			c = resRoomsFor4;
		}
		
		System.out.println(resRoomsFor1 + " | " + resRoomsFor2 + " | " + resRoomsFor3 + " | " + resRoomsFor4);
		
		roomsLeft = getAllRooms() - getAllResRooms();
		
		ReloadDataInHotelFile(u, h);
		
		return roomsLeft;
	}
	
	public void ReloadDataInHotelFile(User u, Hotel h) {
		
		String fileHotel = "FilesServer/Hotels.txt";
		ArrayList<String> allDataOfFileHotels = new ArrayList<>();
		
		try {
				
			FileReader frH = new FileReader(fileHotel);
			BufferedReader readerH = new BufferedReader(frH);
			
			boolean checkH = false;
			String lineH = readerH.readLine();
			while(lineH != null) {
				
				if(checkH) {

					if(lineH.contains(h.getName())) {
						
						String newLineH = "  " + h.getName() + "  |  " + h.getLocation() + "  |  " + h.getStreet() + "  |  " + h.getPrice() + "  |  " + h.getAllRoomsFor1()
										  + " , " + h.getAllRoomsFor2() + " , " + h.getAllRoomsFor3() + " , " + h.getAllRoomsFor4() + "  |  " + "$" + h.getReservedRoomsFor1()
										  + " , " + h.getReservedRoomsFor2() + " , " + h.getReservedRoomsFor3() + ", " + h.getReservedRoomsFor4() + "$" + "  |  " 
										  + h.getStars() + "  |";
						lineH = newLineH;
					}
				}
				
				allDataOfFileHotels.add(lineH);

				lineH = readerH.readLine();
				checkH = true;
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileHotel, false));
			
			for(String l :allDataOfFileHotels) {
				
				bw.write(l + System.lineSeparator());
			}

			readerH.close();
			
			bw.close();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void CreateANewTxtFileForThisHotel() {
		
		String txtName = "C:\\Users\\Billy\\git\\JAVAHOTELS\\UniHotelProject\\FilesServer\\HotelsFiles\\" + getName() + "_RatesAndComms.txt";
		
		File check = new File(txtName);
		
		if(!check.exists()) {
			
			try {
			
				File f = new File(txtName);
				FileWriter writer = new FileWriter(f);
				writer.write("  User    |    Rating    |      Comment      |");
				
				writer.close();
			}
			catch(IOException e) {
			
				e.printStackTrace();
			}
		}
		else {
			
			System.out.println("EXISTS");
		}
	}
	
	public void WriteRatingAndComment(Hotel h, User u, int uRating, String uComment) {
		
		String fileHotel = "FilesServer\\HotelsFiles\\" + h.getName() + "_RatesAndComms.txt";
		ArrayList<String> allDataOfTheRatesOfThisHotel = new ArrayList<>();
		boolean userRCFound = false;
		boolean userRCNotFound = false;
		
		try {
				
			FileReader frHRC = new FileReader(fileHotel);
			BufferedReader readerHRC = new BufferedReader(frHRC);
			
			boolean checkH = false;
			String lineHRC = readerHRC.readLine();
			while(lineHRC != null) {
				
				if(lineHRC.contains(u.getUserName())) {
					
					userRCFound = true;
					
					String newLineHRC = "  " + u.getUserName() + "  |  " + uRating + "  |  " + uComment + "  |";
					lineHRC = newLineHRC;
				}
				else {
					
					userRCNotFound = true;
				}
				
				//if(!userRCNotFound) {
					
				allDataOfTheRatesOfThisHotel.add(lineHRC);
				//}
				
				lineHRC = readerHRC.readLine();
				checkH = true;
			}
			
			System.out.println("UC" + userRCFound);
			
			if(!userRCFound) {
				
				AddRatingOfUser(u, uRating);
				AddCommentOfUser(u, uComment);
				
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(fileHotel, true));
				bw1.append(System.lineSeparator() + "  " + u.getUserName() + "  |  " + uRating + "  |  " + uComment + "  |");
				
				bw1.close();
			}
			else {
				
				System.out.println("Already user " + u.getUserName() + " has already made a rate and a comment");
				BufferedWriter bw2 = new BufferedWriter(new FileWriter(fileHotel, false));
				
				int c = 0;
				for(String l :allDataOfTheRatesOfThisHotel) {
					
					c++;
					if(c != allDataOfTheRatesOfThisHotel.size()) {
						
						bw2.write(l + System.lineSeparator());
					}
					else {
						
						bw2.write(l);
					}
				}
				
				bw2.close();
			}
			
			/*for(String l :allDataOfTheRatesOfThisHotel) {
				
				bw.write(l + System.lineSeparator());
			}*/

			readerHRC.close();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
}
