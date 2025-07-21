package data_driven_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDataBase {

	public static void main(String[] args) throws SQLException {

		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//Connect to the database
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ninza_crm","root","root");
		
		//Create SQL Statement
	   Statement stat = conn.createStatement();
	   
	   //Execute Query
	   ResultSet result = stat.executeQuery("Select CampaignName from campaign where TargetSize=10");
	   
	   while(result.next()) {
		   System.out.println(result.getString(1));
	   }
	   
	   conn.close();
	}

}
