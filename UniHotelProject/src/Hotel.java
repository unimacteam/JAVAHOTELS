import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel {

	private String name = "";
	private String location = "";
	private String street = "";
	private double price = 0;
	private int numRooms = 0;
	private int reservedRooms = 0;
	private int stars = 0;
	private ArrayList<User> usersInThisHotel = new ArrayList<>();
	private Map<User, Integer> ratings = new HashMap<>();
	private Map<User, String> comments = new HashMap<>();
	
	public Hotel(String name, String location, String street, double price, int numRooms, int reservedRooms, int stars) {
		
		this.name = name;
		this.location = location;
		this.street = street;
		this.price = price;
		this.numRooms = numRooms;
		this.reservedRooms = reservedRooms;
		this.stars = stars;
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
	
	public int getNumOfAllRooms() {
		return numRooms;
	}
	
	public int getNumOfResRooms() {
		return reservedRooms;
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
			System.out.println(r.getKey().getName());
		}
		
		aR = cR / ratings.size();
		String txt = new DecimalFormat("##.#").format(aR);
		aR = Double.parseDouble(txt);
		
		return aR;
	}
	
	public int UserReservedAtThisHotelAndReturnFreeRooms(User u) {
		
		usersInThisHotel.add(u);
		reservedRooms++;
		
		return (numRooms - reservedRooms);
	}
}
