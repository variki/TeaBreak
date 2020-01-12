package utilities;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import common.pJDBCConnector;

public class DBQuery extends Constants {
	private static Map<String, Object> parms;

	public DBQuery(String fileName) {
		new TextFileReader(DB_PATH + fileName + ".txt");
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
			final String Address, final String city, final String state, final int pin, final int mobNumber,
			final String email) throws SQLException {

		new DBQuery(new Object() {
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

			}
		};
	  pJDBCConnector.executeDMLQuery(TextFileReader.readAllLinesFromTxt(), parms);
	  
	}

}
