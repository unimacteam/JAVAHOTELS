import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Hotel> hotels = new ArrayList<>();
		ArrayList<User> users = new ArrayList<>();
		
		Server s = new Server();
		hotels = s.GetHotelsList();
		users = s.GetUsersList();
	
		/*hotels = s.GetHotelsList();
	
		for(Hotel h :hotels) {
			
			System.out.println(h.getName());
		}*/
		
		
		
		//users and active users array needed, active users can be created on launch. Use // to run main without this.
		LogInForm logInForm = new LogInForm(users, null);
		new MainScreenGUI(hotels, users);
	}
}
