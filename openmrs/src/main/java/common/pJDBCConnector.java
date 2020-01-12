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

import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import testBase.TestBase;

public class pJDBCConnector extends TestBase {
	private static Connection con = null;
	private static Statement state = null;
	public static List<Hashtable<String, Object>> queryResult = new LinkedList<Hashtable<String, Object>>();

	public static int executeDMLQuery(String readAllLinesFromTxt, Map<String, Object> parms) {
		String txtString = readAllLinesFromTxt, fromString;
		int affectedRow = 0;
		for (Map.Entry<String, Object> entry : parms.entrySet()) {

			fromString = "[" + entry.getKey() + "]";
			txtString = txtString.replace(fromString, entry.getValue().toString());
		}

		try {
			getDBConnection();
			affectedRow = executeUpdate(txtString);
			con.close();
		} catch (SQLException e) {

			log.info(e);
			String code = "<b>" + "TEST CASE" +"<b>"+ currentTestName + "\n" + "Reason:" + e.getMessage();
			Markup m = MarkupHelper.createCodeBlock(code);
			pNode.fail(m);

		}
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
		executeDRLQuery("select idaavin from aavin where name ='[Name]';", new HashMap<String, Object>() {
			{
				put("Name", "Green");
			}
		});

		System.out.println(queryResult);
		System.out.println(queryResult.get(0).get("idaavin"));

	}

	/**
	 * Execute Data retrival Languate Query
	 * 
	 * @param readAllLinesFromTxt
	 * @param parms
	 */

	public static void executeDRLQuery(String readAllLinesFromTxt, Map<String, Object> parms) {
		String sqlString = readAllLinesFromTxt, fromString;
		for (Map.Entry<String, Object> entry : parms.entrySet()) {

			fromString = "[" + entry.getKey() + "]";
			sqlString = sqlString.replace(fromString, entry.getValue().toString());
		}

		try {
			getDBConnection();
			getHashtable(queryResult, executeStatement(sqlString));
			con.close();
		} catch (SQLException e) {

			log.info(e);
			String code = "<b>" + "TEST CASE" + currentTestName + "\n" + "Reason:" + e.getMessage();
			Markup m = MarkupHelper.createCodeBlock(code);
			pNode.fail(m);

		}

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
