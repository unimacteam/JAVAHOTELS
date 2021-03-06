import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Hotel> hotels = new ArrayList<>();
		ArrayList<String> citiesHotels = new ArrayList<>();
		ArrayList<User> users = new ArrayList<>();
		
		Server s = new Server();
		hotels = s.GetHotelsList();
		users = s.GetUsersList();
	
		for(Hotel h :hotels) {
			
			citiesHotels.add(h.getLocation());
		}
		
		//users and active users array needed, active users can be created on launch. Use // to run main without this.
		LogInGUI logInGUI = new LogInGUI();
		logInGUI.run(users, hotels);
	}
}
