package privateOrder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import privateOrder.domain.Good;



public class GoodDAO {

	private static Logger log = Logger.getLogger(GoodDAO.class.getName());
	
	public static void createGood(String name, String group, String maker, String code, String description, int sizeL,
								int sizeH, int sizeW, int price, String accOwner) throws Exception {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		String sql = "INSERT INTO goods (name, goodgroup, maker, code, description, owner, sizel, sizeh, sizew, price) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		connection = ConnectionToDB.getConnectionDB();
		if (connection == null) {
			log.log(Level.SEVERE, "Method create. Connection is not established!");
			return;
		}
				
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, group);
			statement.setString(3, maker);
			statement.setString(4, code);
			statement.setString(5, description);
			statement.setString(6, accOwner);
			statement.setInt(7, sizeL);
			statement.setInt(8, sizeH);
			statement.setInt(9, sizeW);
			statement.setInt(10, price);
			statement.executeUpdate();
		} finally {
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
	}

	public static Good getGood(String name, String maker, String code, int price, String accOwner) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rSet = null;
		Good good = new Good();
		
		String sql = "SELECT * FROM goods WHERE owner = '"+accOwner+"' AND name = '"+name+"' AND maker = '"+maker+"' AND code = '"+code+"' AND price = '"+price+"'";
		connection = ConnectionToDB.getConnectionDB();
		if (connection == null) {
			log.log(Level.SEVERE, "Method getGood. Connection is not established!");
			return good;
		}
		
		try {
			statement = connection.prepareStatement(sql);
			rSet = statement.executeQuery();
			while(rSet.next()){
				good.group = rSet.getString("goodgroup");
				good.name = rSet.getString("name");
				good.maker = rSet.getString("maker");
				good.code = rSet.getString("code");
				good.description = rSet.getString("description");
				good.sizeL = rSet.getInt("sizel");
				good.sizeH = rSet.getInt("sizeh");
				good.sizeW = rSet.getInt("sizew");
				good.price = rSet.getInt("price");
				good.accOwner = rSet.getString("owner");
				good.goodID = rSet.getInt("id");
			}
			
		} finally {
			if(rSet!=null){
				rSet.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		return good;
	}

	public static void editGood(String name, String maker, String code, int price, String accOwner, 
			String newName, String newGroup, String newMaker, String newCode, String newDescription, int newSizeL,
			int newSizeH, int newSizeW, int newPrice, String newAccOwner) throws Exception {

		Good editedGood = getGood(name, maker, code, price, accOwner);
		if (editedGood.accOwner==null) {
			log.log(Level.SEVERE, "Method editGood. Good "+name+" was not found in DB!");
			return;
		}
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		String sql = "UPDATE goods SET (name, goodgroup, maker, code, description, owner, sizel, sizeh, sizew, price) VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?) WHERE id='"+editedGood.goodID+"'";
		
		connection = ConnectionToDB.getConnectionDB();
		if (connection == null) {
			log.log(Level.SEVERE, "Method editGood. Connection is not established!");
			return;
		}
				
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, newName);
			statement.setString(2, newGroup);
			statement.setString(3, newMaker);
			statement.setString(4, newCode);
			statement.setString(5, newDescription);
			statement.setString(6, newAccOwner);
			statement.setInt(7, newSizeL);
			statement.setInt(8, newSizeH);
			statement.setInt(9, newSizeW);
			statement.setInt(10, newPrice);
			statement.executeUpdate();
		} finally {
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		
		
	}

	public static void deleteGood(String name, String maker, String code, int price, String accOwner) throws Exception {

		Good deleteddGood = getGood(name, maker, code, price, accOwner);
		if (deleteddGood.accOwner==null) {
			log.log(Level.SEVERE, "Method deleteGood. Good "+name+" was not found in DB!");
			return;
		}
		
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM goods WHERE id='"+deleteddGood.goodID+"'";
		
		connection = ConnectionToDB.getConnectionDB();
		if (connection == null) {
			log.log(Level.SEVERE, "Method deleteGood. Connection is not established!");
			return;
		}
				
		try {
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} finally {
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
	}
	
	public static ArrayList<Good> getGoodsByAccount(String accOwner) throws Exception{
		ArrayList<Good> goods = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rSet = null;
		String sql = "SELECT * FROM goods WHERE owner = '"+accOwner+"'";
		connection = ConnectionToDB.getConnectionDB();
		if (connection == null) {
			log.log(Level.SEVERE, "Method deleteGood. Connection is not established!");
			return goods;
		}
				
		try {
			statement = connection.prepareStatement(sql);
			rSet = statement.executeQuery();
			while(rSet.next()){
				Good good = new Good();
				good.group = rSet.getString("goodgroup");
				good.name = rSet.getString("name");
				good.maker = rSet.getString("maker");
				good.code = rSet.getString("code");
				good.description = rSet.getString("description");
				good.sizeL = rSet.getInt("sizel");
				good.sizeH = rSet.getInt("sizeh");
				good.sizeW = rSet.getInt("sizew");
				good.price = rSet.getInt("price");
				good.accOwner = rSet.getString("owner");
				goods.add(good);
			}
			
		} finally{
			if(rSet!=null){
				rSet.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		return goods;
	}
	
	public static ArrayList<Good> getGoodsByFiltr(String filtr) throws Exception{
		ArrayList<Good> goods = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rSet = null;
		String sql = "SELECT * FROM goods"+filtr; // filtr=""; filtr = " WHERE someCond = '"+cond+"'" AND someCond2 = '"+cond2+"'"...
		connection = ConnectionToDB.getConnectionDB();
		if (connection == null) {
			log.log(Level.SEVERE, "Method deleteGood. Connection is not established!");
			return goods;
		}
		try {
			statement = connection.prepareStatement(sql);
			rSet = statement.executeQuery();
			while(rSet.next()){
				Good good = new Good();
				good.group = rSet.getString("goodgroup");
				good.name = rSet.getString("name");
				good.maker = rSet.getString("maker");
				good.code = rSet.getString("code");
				good.description = rSet.getString("description");
				good.sizeL = rSet.getInt("sizel");
				good.sizeH = rSet.getInt("sizeh");
				good.sizeW = rSet.getInt("sizew");
				good.price = rSet.getInt("price");
				good.accOwner = rSet.getString("owner");
				goods.add(good);
			}
			
		} finally{
			if(rSet!=null){
				rSet.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		return goods;
	}
}
