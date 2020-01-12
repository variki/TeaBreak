package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class pJDBCConnector {
	private static Connection con = null;
	private static Statement state = null;
	public static List<Hashtable<String, Object>> queryResult = new LinkedList<Hashtable<String, Object>>();

	public static int executeDMLQuery(String readAllLinesFromTxt, Map<String, Object> parms) throws SQLException {
		String txtString = readAllLinesFromTxt, fromString;
		for (Map.Entry<String, Object> entry : parms.entrySet()) {

			fromString = "[" + entry.getKey() + "]";
			txtString = txtString.replace(fromString, entry.getValue().toString());
		}

		getDBConnection();
		int affectedRow = executeUpdate(readAllLinesFromTxt);
		con.close();
		return affectedRow;
	}

	public static void getDBConnection() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guru99", "root", "readme@102");
	}

	public static ResultSet executeStatement(String statement) throws SQLException {
		state = con.createStatement();
		return state.executeQuery(statement);

	}

	public static int executeUpdate(String statement) throws SQLException {
		state = con.createStatement();
		return state.executeUpdate(statement);

	}

	public static void closeConnection() throws SQLException {
		if (!(con == null))
			con.close();
	}

	public static void main(String[] args) {
		try {

			executeDRLQuery("select idaavin from aavin where name ='[Name]';",
					new HashMap<String, Object>() {
						{
							put("Name", "Green");
						}
					});

			System.out.println(queryResult);
			System.out.println(queryResult.get(0).get("idaavin"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Execute the SQL query 
	 * 
	 * @param readAllLinesFromTxt
	 * @param parms
	 * @return List of Hashtable<String, Object>
	 * @throws SQLException
	 */

	public static void executeDRLQuery(String readAllLinesFromTxt, Map<String, Object> parms)
			throws SQLException {
		String sqlString = readAllLinesFromTxt, fromString;
		for (Map.Entry<String, Object> entry : parms.entrySet()) {

			fromString = "[" + entry.getKey() + "]";
			sqlString = sqlString.replace(fromString, entry.getValue().toString());
		}
		getDBConnection();
		getHashtable(queryResult, executeStatement(sqlString));
		con.close();
	}

	/**
	 * Converts ResultSet to Hashtable of List<String,Object>
	 * 
	 * @param row
	 * @param rs_SubItemType
	 * @throws SQLException
	 */

	private static void getHashtable(List<Hashtable<String, Object>> row, ResultSet resultset) throws SQLException {

		ResultSetMetaData metaData = resultset.getMetaData();
		int colCount = metaData.getColumnCount();

		while (resultset.next()) {
			Hashtable<String, Object> columns = new Hashtable<String, Object>();
			for (int i = 1; i <= colCount; i++) {
				columns.put(metaData.getColumnLabel(i), resultset.getObject(metaData.getColumnLabel(i)));
			}

			row.add(columns);
		}

	}

}
