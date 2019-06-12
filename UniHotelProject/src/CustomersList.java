
public class CustomersList {

	private String username = "";
	private String userFullName = "";
	private String email = "";
	private int roomSize = 0;
	private double pricePaid = 0;
	
	public CustomersList(String username, String userFullName, String email, int roomSize, double pricePaid) {
		
		this.username = username;
		this.userFullName = userFullName;
		this.email = email;
		this.roomSize = roomSize;
		this.pricePaid = pricePaid;
	}

	public String getUsername() {
		return username;
	}

	public String getUserFullName() {
		return userFullName;
	}
	
	public String getEmail() {
		return email;
	}

	public int getRoomSize() {
		return roomSize;
	}

	public double getPricePaid() {
		return pricePaid;
	}
}
