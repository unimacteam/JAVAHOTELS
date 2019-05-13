import java.text.DecimalFormat;
import java.util.ArrayList;

public class Hotel {

	private String name = "";
	private String location = "";
	private String street = "";
	private double price = 0;
	private ArrayList<Integer> ratings = new ArrayList<>();
	
	public Hotel(String name, String location, String street, double price) {
		
		this.name = name;
		this.location = location;
		this.street = street;
		this.price = price;
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

	public ArrayList<Integer> getRatings() {
		return ratings;
	}
	
	public void PushRating(int rate) {
		
		ratings.add(rate);
	}
	
	public double GetAverageRating() {
		//cR = countRate
		double cR = 0, aR = 0;
		
		for(Integer r :ratings) {
			
			cR += r;
		}
		
		aR = cR / ratings.size();
		String txt = new DecimalFormat("##.#").format(aR);
		aR = Double.parseDouble(txt);
		
		return aR;
	}
}
