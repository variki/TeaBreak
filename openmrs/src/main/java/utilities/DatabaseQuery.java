package utilities;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.Status;

import common.pJDBCConnector;
import testBase.TestBase;

public class DatabaseQuery extends TestBase {
	private static Map<String, Object> parms;
	public static TextFileReader txtFile;

	public DatabaseQuery(String fileName) {
		txtFile = new TextFileReader(Constants.DB_PATH +"\\"+ fileName + ".txt");
	}
	/**
	 * This is used to insert data to Customer table 
	 * 
	 * @param custName
	 * @param gender
	 * @param DOB
	 * @param Address
	 * @param city
	 * @param state
	 * @param pin
	 * @param mobNumber
	 * @param email
	 * @throws SQLException
	 */

	public static void insertDataToCustomer(final String custName, final String gender, final String DOB,
			final String Address, final String city, final String state, final String pin, final String mobNumber,
			final String email,final String customerID) {

		new DatabaseQuery(new Object() {
		}.getClass().getEnclosingMethod().getName());
		parms = new HashMap<String, Object>() {
			{
				put("Customer_Name", custName);
				put("Gender", gender);
				put("Date_Of_Birth", DOB);
				put("Address", Address);
				put("City", city);
				put("State", state);
				put("Pin", pin);
				put("Mobile_Number", mobNumber);
				put("E-Mail", email);
				put("Customer_Id",customerID);

			}
		};
		System.out.println();
	  if(pJDBCConnector.executeDMLQuery(txtFile.readFileAsString(), parms)>0);
	  {
		  log.info("Successfully added customer data to DB");
		  pNode.log(Status.INFO,"Successfully added customer data to DB");
	  }
	  
	}
	
	

}
