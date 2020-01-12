package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.xmlbeans.impl.store.Path;

public class TextFileReader {
	private String fileName;
	private static BufferedReader reader;
	private static FileReader fileTxt;
	
	
	public TextFileReader(String fileName)
	{
		this.fileName = fileName;
		try {
			 fileTxt = new FileReader(fileName);
			 reader = new BufferedReader(fileTxt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String readAllLinesFromTxt()
	{
		String value = "",tempString="";
		try {
			while((tempString = reader.readLine()) != null)
			{
				value = value+tempString;
			}
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	public String readFileAsString()
	{
		String value = "";
	
		try {
			value = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	

	
}
