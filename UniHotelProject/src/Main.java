import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Hotel> hotels = new ArrayList<>();
		
		Server s = new Server();
	
		hotels = s.GetHotelsList();
	
		for(Hotel h :hotels) {
			
			System.out.println(h.getName());
		}
	}
}
