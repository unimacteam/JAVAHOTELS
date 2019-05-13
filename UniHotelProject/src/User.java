import java.util.ArrayList;

public class User {
	
	private String userName = "";
	private String passCode = "";
	private String email = "";
	private String name = "";
	private String surname = "";
	
	private ArrayList<Hotel> hotelList = new ArrayList<>();

	
	
	public User(String userName, String passCode, String email, String name, String surname) {
		
		this.userName = userName;
		this.passCode = passCode;
		this.email = email;
		this.name = name;
		this.surname = surname;
	}

	
	
	
	public void PushHotelListInUser(Hotel h) {
		
		hotelList.add(h);
	}

	
	public void LogIn(ArrayList<User> users)
	{
		
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassCode() {
		return passCode;
	}



	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}






