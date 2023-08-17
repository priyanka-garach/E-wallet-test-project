package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DBUtils {
	public static void main(String[] args) {
		try {
			System.out.println(getPasswordforSubAgentOnboard("256720000116"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String getOTP(String phone) throws SQLException {
		Map<Object, Object> data = new HashMap<Object, Object>();
		ConnectionManager conn = new ConnectionManager();
		conn.connect("MobifinEliteTransactionEngine_Tangerine?characterEncoding=utf8");
		ResultSet rs;
		rs = conn.getConnection()
				.prepareStatement("SELECT message FROM TBLVendorTransactionDetail WHERE ReceiverDetail LIKE '%" + phone
						+ "%'" + " AND Message LIKE 'Received UGX :%' ORDER BY EventTime DESC LIMIT 1")
				.executeQuery();
		rs.next();
		String result = rs.getString("Message");
		// System.out.println(result);
		Pattern pattern = Pattern.compile("(\\d{50})");
		java.util.regex.Matcher matcher = pattern.matcher(result);
		if (matcher.find()) {
			result = matcher.group(0);
		}
		conn.getConnection().close();
		return result;
	}

	public static String getMpinforCustomerOnboard(String phone) throws SQLException {
		Map<Object, Object> data = new HashMap<Object, Object>();
		ConnectionManager conn = new ConnectionManager();
		conn.connect("MobifinEliteTransactionEngine_Tangerine?characterEncoding=utf8");
		ResultSet rs;
		rs = conn.getConnection()
				.prepareStatement("SELECT message FROM TBLVendorTransactionDetail WHERE ReceiverDetail LIKE '%" + phone
						+ "%'" + " ORDER BY EventTime DESC LIMIT 10")
				.executeQuery();
		rs.next();
		String result = rs.getString("Message");
		String[] res = result.split("[.]", 0);
		System.out.println(res[1]);
		Pattern pattern = Pattern.compile("(\\d{4})");
		java.util.regex.Matcher matcher = pattern.matcher(res[1]);
		if (matcher.find()) {
			result = matcher.group(0);
		}
		conn.getConnection().close();
		return result;
	}

	public static String getPasswordforSubAgentOnboard(String phone) throws SQLException {
		Map<Object, Object> data = new HashMap<Object, Object>();
		ConnectionManager conn = new ConnectionManager();
		conn.connect("MobifinEliteTransactionEngine_Tangerine?characterEncoding=utf8");
		ResultSet rs;
		rs = conn.getConnection()
				.prepareStatement("SELECT message FROM TBLVendorTransactionDetail WHERE ReceiverDetail LIKE '%" + phone
						+ "%'" + " ORDER BY EventTime DESC LIMIT 10")
				.executeQuery();
		rs.next();
		String result = rs.getString("Message");
		String[] res = result.split("[.]", 0);
		System.out.println(res[1]);
		String[] res2 = res[1].split("PASSWORD ", 0);
		result = res2[1];
		conn.getConnection().close();
		return result;
	}

	public static String getOTPforCustomerOnboard(String phone) throws SQLException {
		Map<Object, Object> data = new HashMap<Object, Object>();
		ConnectionManager conn = new ConnectionManager();
		conn.connect("MobifinEliteTransactionEngine_Tangerine?characterEncoding=utf8");
		ResultSet rs;
		rs = conn.getConnection()
				.prepareStatement("SELECT message FROM TBLVendorTransactionDetail WHERE ReceiverDetail LIKE '%" + phone
						+ "%'" + " ORDER BY EventTime DESC LIMIT 10")
				.executeQuery();
		rs.next();
		String result = rs.getString("Message");
		Pattern pattern = Pattern.compile("(\\d{4})");
		java.util.regex.Matcher matcher = pattern.matcher(result);
		if (matcher.find()) {
			result = matcher.group(0);
		}
		conn.getConnection().close();
		return result;
	}

	public static String getOTPforWithdrawCash() throws SQLException {
		Map<Object, Object> data = new HashMap<Object, Object>();
		ConnectionManager conn = new ConnectionManager();
		conn.connect("MobifinEliteTransactionEngine_Tangerine?characterEncoding=utf8");
		ResultSet rs;
		rs = conn.getConnection().prepareStatement(
				"SELECT message FROM TBLVendorTransactionDetail WHERE Message LIKE 'Cash withdrawal of UGX :%' ORDER BY EventTime DESC LIMIT 1")
				.executeQuery();
		rs.next();
		String result = rs.getString("Message");
		// System.out.println(result);
		Pattern pattern = Pattern.compile("(\\d{4})");
		java.util.regex.Matcher matcher = pattern.matcher(result);
		if (matcher.find()) {
			result = matcher.group(0);
		}
		conn.getConnection().close();
		return result;
	}

	public static String getMessageforInviteFriends(String phone) throws SQLException {
		// Map<Object, Object> data = new HashMap<Object, Object>();
		ConnectionManager conn = new ConnectionManager();
		conn.connect("MobifinEliteTransactionEngine_Tangerine?characterEncoding=utf8");
		ResultSet rs;
		rs = conn.getConnection()
				.prepareStatement("SELECT message FROM TBLVendorTransactionDetail WHERE ReceiverDetail LIKE '%" + phone
						+ "%'"
						+ " AND Message LIKE 'The request Link has been sent to%' ORDER BY EventTime DESC LIMIT 1")
				.executeQuery();
		rs.next();
		String result = rs.getString("Message");

		conn.getConnection().close();
		return result;
	}

	public static String getValuefromMessage(String phone) throws SQLException {
		// Map<Object, Object> data = new HashMap<Object, Object>();
		ConnectionManager conn = new ConnectionManager();
		conn.connect("MobifinEliteTransactionEngine_Tangerine?characterEncoding=utf8");
		ResultSet rs;
		rs = conn.getConnection()
				.prepareStatement("SELECT message FROM TBLVendorTransactionDetail WHERE ReceiverDetail LIKE '%" + phone
						+ "%'" + " AND Message LIKE 'Received UGX :%' ORDER BY EventTime DESC LIMIT 1")
				.executeQuery();
		rs.next();
		String result = rs.getString("Message");

		conn.getConnection().close();
		return result;
	}
}

class ConnectionManager {
	private static final String JDBC_URL = "jdbc:mysql://172.29.8.13:6055";
	private static final String USERNAME = "elite_ro";
	private static final String PASSWORD = "kxcZ27!Y6n";
	private static final String CLASS_NAME = "com.mysql.jdbc.Driver";

	private Connection connection = null;

	public Connection connect(String database) {
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver class could not loaded");
			e.printStackTrace();
		}
		try {
			System.out.println("Connecting to the database...");
			this.connection = DriverManager.getConnection(JDBC_URL + "/" + database, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return this.connection;
	}

	public Connection getConnection() {
		return connection;
	}
}
