import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Server {

	public Server() {
		
		String file = "FilesServer/Hotels.txt";
		
		try { 
			
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			
			boolean check = false;
			String line = reader.readLine();
			while(line != null) {
				
				if(check) {
					
					CreateHotels(line);
				}
				
				line = reader.readLine();
				check = true;
			}
			
			reader.close();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void CreateHotels(String line) {
		
		String name = "";
		String location = "";
		String street = "";
		double price = 0;
		
		line = line.replaceAll("\\s+", "");
			
		name = line.substring(0, line.indexOf(","));
		line = line.replaceAll(name + ",", "");
			
		location = line.substring(0, line.indexOf(","));
		line = line.replaceAll(location + ",", "");
			
		street = line.substring(0, line.indexOf(","));
		line = line.replaceAll(street + ",", "");
			
		if(street.contains("_")) {
				
			String streetName = street.substring(0, street.indexOf("_"));
			String streetNum = street.substring(street.indexOf("_") + 1, street.length());
			street = streetName + " " + streetNum;
		}
		
		String pricS = "";
		price = Double.parseDouble(line.substring(0, line.indexOf(",")));
		pricS = line.substring(0, line.indexOf(","));
		line = line.replaceAll(pricS + ",", "");
			
		System.out.println(name + ' ' + location + ' ' + street + ' ' + price);
	}
}
