import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Hotel> hotels = new ArrayList<>();
		
		Server s = new Server();
	
		/*hotels = s.GetHotelsList();
	
		for(Hotel h :hotels) {
			
			System.out.println(h.getName());
		}*/
		
		
		LogInForm logInForm = new LogInForm(s.GetUsersList(), null);
		//Use // to run main without this.
		
		FilterPanel filters = new FilterPanel(s.getCitiesList(), s.GetHotelsList());
	}
}
