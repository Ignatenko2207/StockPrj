package privateOrder.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionToDB {

	
	private static final String DBURL = "jdbc:postgresql://localhost:5432/StockDB";
	private static final String DBUser = "postgres";
	private static final String DBUserPassword = "248842";

	private static Logger log = Logger.getLogger(ConnectionToDB.class.getName());

	public static Connection getConnectionDB() throws Exception {

		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection(DBURL, DBUser, DBUserPassword);
			if (connection != null) {
				log.log(Level.INFO, "Connection is established!");
				return connection;
				
			} else {
				throw new Exception("Connection is not established!");
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new Exception("Connection is not established!");
		}
	}

}
