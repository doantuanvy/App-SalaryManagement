package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException{
		String url = "jdbc:sqlserver://localhost:1433;databasename = QuanLyLuongNew";
		String user = "sa";
		String password = "3042001vy";
		con = DriverManager.getConnection(url,user, password);
	}
	public void disconnect() {
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
	}
	public static Connection getConnection() {
		return con;
	}
//	public static void main(String[] args) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		if(con!=null) {
//			System.out.println("ok");
//		}else {
//			System.out.println("NULL");
//		}
//	}
}
