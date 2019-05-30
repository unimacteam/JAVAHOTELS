
public class RatesAndComms {

	private String userName;
	private int rating = 0;
	private String comment = "";
	
	public RatesAndComms(String userName, int rating, String comment) {
		
		this.userName = userName;
		this.rating = rating;
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public int getRating() {
		return rating;
	}

	public String getComment() {
		return comment;
	}
}