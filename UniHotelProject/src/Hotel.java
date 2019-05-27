import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	private int roomsFor2 = 0;
	private int roomsFor3 = 0;
	private int roomsFor4 = 0;
	private ArrayList<Integer> resRoomsSize = new ArrayList<>();
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
	
	public int getAllRoomsFor2() {
		
		roomsFor2 = roomsSize.get(0);
		
		return roomsFor2;
	}
	
	public int getAllRoomsFor3() {
		
		roomsFor3 = roomsSize.get(1);
		
		return roomsFor3;
	}

	public int getAllRoomsFor4() {
	
		roomsFor4 = roomsSize.get(2);
	
		return roomsFor4;
	}
	
	public ArrayList<Integer> getReservedRoomsPersonSize() {
		return resRoomsSize;
	}
	
	public int getAllResRooms() {
		
		int c = 0;
		
		c = resRoomsFor2 + resRoomsFor3 + resRoomsFor4;
		
		return c;
	}
	
	public void GiveDataFromResRoomsArrayToVar() {
		
		System.out.println(getName());
		resRoomsFor2 = resRoomsSize.get(0);
		resRoomsFor3 = resRoomsSize.get(1);
		resRoomsFor4 = resRoomsSize.get(2);
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
		
		ratings.put(u, rate);
	}
	
	public void AddCommentOfUser(User u, String comment) {
		
		comments.put(u, comment);
	}
	
	public double GetAverageRating() {
		
		//cR = countRate
		double cR = 0, aR = 0;
		
		//ratings
		for(Map.Entry<User, Integer> r :ratings.entrySet()) {
			
			cR += r.getValue();
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
		
		if(numOfPersons == 2) {
			
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
		
		System.out.println(resRoomsFor2 + " | " + resRoomsFor3 + " | " + resRoomsFor4);
		
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
						
						String newLineH = "  " + h.getName() + "  |  " + h.getLocation() + "  |  " + h.getStreet() + "  |  " + h.getPrice() + "  |  " + h.getAllRoomsFor2()
										  + " , " + h.getAllRoomsFor3() + " , " + h.getAllRoomsFor4() + "  |  " + "$" + h.getReservedRoomsFor2() + " , "
										  + h.getReservedRoomsFor3() + ", " + h.getReservedRoomsFor4() + "$" + "  |  " + h.getStars() + "  |";
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
}
