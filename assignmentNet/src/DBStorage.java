    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author User
 */
public class DBStorage {

	public static DBStorage instance;
        public Connection con;
        private Statement st;
	private ResultSet rs;
	
	public synchronized static DBStorage getInstance(){
		if(instance == null){
			instance = new DBStorage();
		}
		return instance;
	}
        
        public DBStorage() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/courseregistration", "root", "242015");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public ResultSet getData(String query) {
		try {

			st = (Statement) con.createStatement();

			rs = st.executeQuery(query);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
}
