package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	private static BufferedReader reader = null;
	private static FileReader fileTxt = null;
	
	
	public TextFileReader(String fileName)
	{
		try {
			 fileTxt = new FileReader(fileName);
			 reader = new BufferedReader(fileTxt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String readAllLinesFromTxt()
	{
		String value = "",tempString="";
		try {
			while((tempString = reader.readLine()) != null)
			{
				value = value +"/n"+tempString;
			}
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	
}
