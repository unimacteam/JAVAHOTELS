import java.util.ArrayList;

public class User {
	
	private String userName = "";
	private String passCode = "";
	private String name = "";
	private String surname = "";
	private int age;
	private String email = "";
	private ArrayList<Hotel> hotelList = new ArrayList<>();

	public void PushHotelListInUser(Hotel h) {
		
		hotelList.add(h);
	}
}
