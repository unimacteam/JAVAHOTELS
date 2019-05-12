import java.util.ArrayList;

public class User {
	
	private String userName = "";
	private String passCode = "";
	private String email = "";
	private String name = "";
	private String surname = "";
	
	private ArrayList<Hotel> hotelList = new ArrayList<>();

	public void PushHotelListInUser(Hotel h) {
		
		hotelList.add(h);
	}

	
	public void SignUp(ArrayList<User> users)
	{	
		//while attempting to sign up
		while (true)
		{
			SignUpForm signUpForm = new SignUpForm();
			
			//check if username or email are in use
			boolean inUse = false;
			
			for (User u: users)
			{
				if (signUpForm.getUserName().equals(u.getUserName()))
					{
					signUpForm.InUsePopUp("Username");
					inUse = true;
					break;
					}
				else if (signUpForm.getEmail().equals(u.getEmail()))
					{
					signUpForm.InUsePopUp("E-mail");
					inUse = true;
					break;
					}
			
			}
			
			if (!inUse)
				{
				userName = signUpForm.getUserName();
				passCode = signUpForm.getPassCode();
				email = signUpForm.getEmail();
				name = signUpForm.getName();
				surname = signUpForm.getSurname();
				users.add(this);
				break;
				}
		}
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






