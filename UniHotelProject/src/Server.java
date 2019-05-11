import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Server {

	public Server() {
		
		String file = "FilesServer/Hotels.txt";
		
		try {
			
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			
			String line = reader.readLine();
			while(line != null) {
				
				System.out.println(line);
				line = reader.readLine();
			}
			
			reader.close();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}	
}
