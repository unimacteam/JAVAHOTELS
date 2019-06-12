import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel {

	private String name = "";
	private String location = "";
	private String street = "";
	private ArrayList<Double> price = new ArrayList<>();
	private ArrayList<Integer> roomsSize = new ArrayList<>();
	private ArrayList<Integer> resRoomsSize = new ArrayList<>();
	private int resRoomsFor1 = 0;
	private int resRoomsFor2 = 0;
	private int resRoomsFor3 = 0;
	private int resRoomsFor4 = 0;
	private int stars = 0;
	private ArrayList<String> extras = new ArrayList<>();
	private String details = "";
	private Map<Integer, User> usersInThisHotel = new HashMap<>();
	private ArrayList<RatesAndComms> ratingsAndComms = new ArrayList<>();
	private ArrayList<CustomersList> customersList = new ArrayList<>();
	
	public Hotel(String name, String location, String street, ArrayList<Double> price, ArrayList<Integer> roomsSize, ArrayList<Integer> resRoomsSize, int stars, ArrayList<String> extras) {
		
		this.name = name;
		this.location = location;
		this.street = street;
		this.price = price;
		this.roomsSize = roomsSize;
		this.resRoomsSize = resRoomsSize;
		this.stars = stars;
		this.extras = extras;
		
		GiveDataFromResRoomsArrayToVar();
		CreateTHREETxtFilesForThisHotel();
		ReadTheRatingsFromTxtFile();
		ReadDataFromDetailsTxt();
		ReadDataFromCustomersListTXTFile();
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

	public ArrayList<Double> getPrice() {
		return price;
	}
	
	public double getPriceFor(int i) {
		return price.get(i-1);
	}

	public ArrayList<Integer> getRoomsPersonSize() {
		return roomsSize;
	}
	
	public int getAllRooms() {
		
		int c = 0;
		
		for(Integer r :roomsSize) {
			
			c += r;
		}
		
		return c;
	}
	
	public int getAllRoomsFor(int i) {

		return roomsSize.get(i-1);
	}
	
	public ArrayList<Integer> getReservedRoomsPersonSize() {
		return resRoomsSize;
	}
	
	public int getAllResRooms() {
		
		int c = 0;
		
		c = resRoomsFor1 + resRoomsFor2 + resRoomsFor3 + resRoomsFor4;
		
		return c;
	}
	
	public void GiveDataFromResRoomsArrayToVar() {
		
		resRoomsFor1 = resRoomsSize.get(0);
		resRoomsFor2 = resRoomsSize.get(1);
		resRoomsFor3 = resRoomsSize.get(2);
		resRoomsFor4 = resRoomsSize.get(3);
	}
	
	public int getReservedRoomsFor(int i) {
		
		if(i == 1) {	
			
			return resRoomsFor1;
		}
		else if(i == 2) {
		
			return resRoomsFor2;
		}
		else if(i == 3) {
		
			return resRoomsFor3;
		}
		else if( i==4 ) {
			
			return resRoomsFor4;
		}

		return -1;
	}

	public int getStars() {
		return stars;
	}
	
	public ArrayList<String> getAllExtras() {
		return extras;
	}
	
	public boolean hasAPool() {
		
		boolean c = false;
		
		if(extras.get(0).equals("Y")) {
			c = true;
		}
		else if(extras.get(0).equals("N")) {
			c = false;
		}
		
		return c;
	}
	
	public boolean hasAGym() {
		
		boolean c = false;
		
		if(extras.get(1).equals("Y")) {
			c = true;
		}
		else if(extras.get(1).equals("N")) {
			c = false;
		}
		
		return c;
	}
	
	public boolean hasARestaurant() {
		
		boolean c = false;
		
		if(extras.get(2).equals("Y")) {
			c = true;
		}
		else if(extras.get(2).equals("N")) {
			c = false;
		}
		
		return c;
	}

	public boolean hasBreakfast() {
	
		boolean c = false;
		
		if(extras.get(3).equals("Y")) {
			
			c = true;
		}
		else if(extras.get(3).equals("N")) {
		
			c = false;
		}
		
		return c;
	}

	public boolean hasLunch() {
	
		boolean c = false;
		
		if(extras.get(4).equals("Y")) {
			c = true;
		}
		else if(extras.get(4).equals("N")) {
			c = false;
		}
		
		return c;
	}
	
	public String getDetails() {
		return details;
	}
	
	public double GetAverageRating() {
		
		//cR = countRate
		double cR = 0, aR = 0;
		
		//ratings
		if(ratingsAndComms.size() != 0) {
			
			for(RatesAndComms rAc :ratingsAndComms) {
				
				cR += rAc.getRating();
			}
		
			aR = cR / ratingsAndComms.size();
			String txt = new DecimalFormat("##.#").format(aR);
			aR = Double.parseDouble(txt);
		}
		else {
			
			System.out.println("NO RATINGS FOUND");
		}
		
		return aR;
	}
	
	public int GetFreeRoomsFor(int i) {
		
		//LEFT HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if(i == 1) {	
			
			return (roomsSize.get(i - 1) - resRoomsFor1);
		}
		else if(i == 2) {
		
			return (roomsSize.get(i - 1) - resRoomsFor2);
		}
		else if(i == 3) {
		
			return (roomsSize.get(i - 1) - resRoomsFor3);
		}
		else if( i==4 ) {
			
			return (roomsSize.get(i - 1) - resRoomsFor4);
		}
		
		return -1;
	}
	
	public void UserReservedAtThisHotel(User u, Hotel h, int numOfPersons) {
		
		if(numOfPersons == 1) {
			
			if(resRoomsFor1 < getAllRoomsFor(1)) {
				
				resRoomsFor1++;
				usersInThisHotel.put(numOfPersons, u);
			}
		}
		else if(numOfPersons == 2) {
			
			if(resRoomsFor2 < getAllRoomsFor(2)) {
			
				resRoomsFor2++;
				usersInThisHotel.put(numOfPersons, u);
			}
		}
		else if(numOfPersons == 3) {
			
			if(resRoomsFor3 < getAllRoomsFor(3)) {
				
				resRoomsFor3++;
				usersInThisHotel.put(numOfPersons, u);
			}
		}
		else if(numOfPersons == 4) {
			
			if(resRoomsFor4 < getAllRoomsFor(4)) {
				
				resRoomsFor4++;
				usersInThisHotel.put(numOfPersons, u);
			}
		}
		
		ReloadDataInHotelFile(u, h);
	}
	
	public void ReloadDataInHotelFile(User u, Hotel h) {
		
		String fileHotel = "FilesServer/Hotels.txt";
		ArrayList<String> allDataOfFileHotels = new ArrayList<>();
		
		try {
				
			FileReader frH = new FileReader(fileHotel);
			BufferedReader readerH = new BufferedReader(frH);
			
			boolean checkH = false;
			String lineH = readerH.readLine();
			while(lineH != null) {
				
				if(checkH) {

					if(lineH.contains(h.getName())) {
						
						String newLineH = "  " + h.getName() + "  |  " + h.getLocation() + "  |  " + h.getStreet() + "  |  " + h.getPriceFor(1) + ", " + h.getPriceFor(2) + ", " 
										  + h.getPriceFor(3) + ", " + h.getPriceFor(4) + "  |  " + h.getAllRoomsFor(1) + " , " + h.getAllRoomsFor(2) + " , " + h.getAllRoomsFor(3) 
										  + " , " + h.getAllRoomsFor(4) + "  |  " + "$" + h.getReservedRoomsFor(1) + " , " + h.getReservedRoomsFor(2) + " , " 
										  + h.getReservedRoomsFor(3) + ", " + h.getReservedRoomsFor(4) + "$" + "  |  " + h.getStars() + "  |  " + h.getAllExtras().get(0) 
										  + "  |  " + h.getAllExtras().get(1) + "  |  "  + h.getAllExtras().get(2) + "  |  " + h.getAllExtras().get(3) + "  |  " 
										  + h.getAllExtras().get(4) + "  |  ";
						lineH = newLineH;
					}
				}
				
				allDataOfFileHotels.add(lineH);

				lineH = readerH.readLine();
				checkH = true;
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileHotel, false));
			
			for(String l :allDataOfFileHotels) {
				
				bw.write(l + System.lineSeparator());
			}

			readerH.close();
			
			bw.close();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void CreateTHREETxtFilesForThisHotel(){
		
		//CREATION OF TXT FILE FOR RATES AND COMMS
		String txtOneName = "FilesServer\\HotelsFiles\\" + getName() + "_RatesAndComms.txt";
		
		File checkOne = new File(txtOneName);
		
		if(!checkOne.exists()) {
			
			try {
			
				File f = new File(txtOneName);
				FileWriter writer = new FileWriter(f);
				writer.write("  User    |    Rating    |      Comment      |");
				
				writer.close();
			}
			catch(IOException e) {
			
				e.printStackTrace();
			}
		}
		
		//CREATION OF TXT FILE FOR THE DETAILS
		String txtTwoName = "FilesServer\\HotelsFiles\\" + getName() + "_Details.txt";
				
		File checkTwo = new File(txtTwoName);
				
		if(!checkTwo.exists()) {
					
			try {
				
				File f = new File(txtTwoName);
				FileWriter writer = new FileWriter(f);
				writer.write("");
				
				writer.close();
			}	
			catch(IOException e) {
			
				e.printStackTrace();
			}
		}
		
		////CREATION OF TXT FILE FOR THE LIST OF CUSTOMERS
		String txtThreeName = "FilesServer\\HotelsFiles\\" + getName() + "_CustomersList.txt";
			
		File checkThree = new File(txtThreeName);
				
		if(!checkThree.exists()) {
					
			try {	
				
				File f = new File(txtThreeName);
				FileWriter writer = new FileWriter(f);
				writer.write("  CustomerUserName   |    CustomerFullName    |    Email    |    RoomSize    |    FinalPrice    |");
			
				writer.close();
			}
			catch(IOException e) {
					
				e.printStackTrace();
			}
		}
	}
	
	public void WriteRatingAndComment(Hotel h, User u, int uRating, String uComment) {
		
		String fileHotel = "FilesServer\\HotelsFiles\\" + h.getName() + "_RatesAndComms.txt";
		ArrayList<String> allDataOfTheRatesOfThisHotel = new ArrayList<>();
		boolean userRCFound = false;
		
		try {
				
			FileReader frHRC = new FileReader(fileHotel);
			BufferedReader readerHRC = new BufferedReader(frHRC);
			
			boolean checkH = false;
			String lineHRC = readerHRC.readLine();
			while(lineHRC != null) {
				
				if(lineHRC.contains(u.getUserName())) {
					
					userRCFound = true;
					
					String newLineHRC = "  " + u.getUserName() + "  |  " + uRating + "  |  $" + uComment + "$  |";
					lineHRC = newLineHRC;
				}
				
				allDataOfTheRatesOfThisHotel.add(lineHRC);
				
				lineHRC = readerHRC.readLine();
				checkH = true;
			}
			
			if(!userRCFound) {
				
				System.out.println("In");
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(fileHotel, true));
				bw1.append(System.lineSeparator() + "  " + u.getUserName() + "  |  " + uRating + "  |  $" + uComment + "$  |");
				
				bw1.close();
			}
			else {
				
				System.out.println("User " + u.getUserName() + " has already made a rate and a comment");
				BufferedWriter bw2 = new BufferedWriter(new FileWriter(fileHotel, false));
				
				int c = 0;
				for(String l :allDataOfTheRatesOfThisHotel) {
					
					c++;
					if(c != allDataOfTheRatesOfThisHotel.size()) {
						
						bw2.write(l + System.lineSeparator());
					}
					else {
						
						bw2.write(l);
					}
				}
				
				bw2.close();
			}

			readerHRC.close();
			
			ReadTheRatingsFromTxtFile();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void ReadTheRatingsFromTxtFile() {
		
		String fileHotelsRC = "FilesServer/HotelsFiles/" + getName() + "_RatesAndComms.txt";
		ratingsAndComms.clear();
		
		try { 

			FileReader frHRC = new FileReader(fileHotelsRC);
			BufferedReader readerHRC = new BufferedReader(frHRC);

			boolean checkHRC = false;
			String lineHRC = readerHRC.readLine();
			while(lineHRC != null) {

				if(checkHRC) {

					CreateHotelsRC(lineHRC);
				}

				lineHRC = readerHRC.readLine();
				checkHRC = true;
			}

			readerHRC.close();
		}
		catch(IOException e) {

			e.printStackTrace();
		}
	}
	
	public void CreateHotelsRC(String line) {
		
		String userName;
		int rating = 0;
		String comment = "";
		
		comment = line.substring(line.indexOf("$") + 1, line.lastIndexOf("$"));
		line = line.replaceAll("\\$" + comment + "\\$", "");
		
		line = line.replaceAll("\\s+", "");
		
		userName = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(userName + "\\|", "");
		
		rating = Integer.parseInt(line.substring(0, line.indexOf("|")));
		String rateS = line.substring(0, line.indexOf("|"));
		line = line.replaceAll(rateS + "\\|", "");
		
		RatesAndComms rAc = new RatesAndComms(userName, rating, comment);
		
		ratingsAndComms.add(rAc);
	}
	
	public ArrayList<RatesAndComms> getRatesAndComms() {
		
		return ratingsAndComms;
	}
	
	public void WriteDetailsOfThisHotel(Hotel h, String details) {
		
		String fileHotelD = "FilesServer\\HotelsFiles\\" + h.getName() + "_Details.txt";
		
		try {
			
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(fileHotelD, false));
			bw1.append(details);
			bw1.close();
			
			ReadDataFromDetailsTxt();
		}
		catch(IOException e) {

			e.printStackTrace();
		}
	}
	
	public void ReadDataFromDetailsTxt() {
		
		String fileHotelDetails = "FilesServer/HotelsFiles/" + getName() + "_Details.txt";
		ArrayList<String> detailsArray = new ArrayList<>();
		int check = 0;
		int c = 0;

		try { 

			FileReader frHD = new FileReader(fileHotelDetails);
			BufferedReader readerHD = new BufferedReader(frHD);

			String lineHD = readerHD.readLine();
			while(lineHD != null) {

				detailsArray.add(lineHD);

				lineHD = readerHD.readLine();
			}
			
			for(String d :detailsArray) {
					
				if(c == 0) {
					
					details = details + d;
				}
				else {
						
					details = details + System.lineSeparator() + d;
				}
				c++;
			}
			readerHD.close();
		}
		catch(IOException e) {

			e.printStackTrace();
		}
	}
	
	public ArrayList<CustomersList> getCustomersList() {
		
		return customersList;
	}
	
	public void WriteToCustomersListTXTFile(Hotel h, User u, int roomSize, double price) {
		
		String fileCustomerList = "FilesServer\\HotelsFiles\\" + h.getName() + "_CustomersList.txt";
		
		try {
	
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileCustomerList, true));
			bw.append(System.lineSeparator() + "  " + u.getUserName() + "  |  " + u.getSurname() + " " + u.getName() + "  |  " + u.getEmail() + "  |  " + roomSize + "  |  " + price + "  |");
			bw.close();
			
			ReadDataFromCustomersListTXTFile();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	public void ReadDataFromCustomersListTXTFile() {
		
		String fileCL = "FilesServer/HotelsFiles/" + getName() + "_CustomersList.txt";
		customersList.clear();
		
		try { 

			FileReader frCL = new FileReader(fileCL);
			BufferedReader readerCL = new BufferedReader(frCL);

			boolean checkCL = false;
			String lineCL = readerCL.readLine();
			while(lineCL != null) {

				if(checkCL) {

					CreateCL(lineCL);
				}

				lineCL = readerCL.readLine();
				checkCL = true;
			}

			readerCL.close();
		}
		catch(IOException e) {

			e.printStackTrace();
		}
	}
	
	public void CreateCL(String line) {
		
		String username = "";
		String fullName = "";
		String email = "";
		int roomSize = 0;
		double price = 0;
		
		line = line.replaceAll("\\s+", "");
		
		username = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(username + "\\|", "");
		
		fullName = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(fullName + "\\|", "");
		
		email = line.substring(0, line.indexOf("|"));
		line = line.replaceFirst(email + "\\|", "");
		
		String roomSizeString = line.substring(0, line.indexOf("|"));
		roomSize = Integer.parseInt(roomSizeString);
		line = line.replaceFirst(roomSizeString + "\\|", "");
		
		String priceString = line.substring(0, line.indexOf("|"));
		price = Double.parseDouble(priceString);
		line = line.replaceFirst(priceString + "\\|", "");
		
		CustomersList cL = new CustomersList(username, fullName, email, roomSize, price);
		
		customersList.add(cL);
	}
}
