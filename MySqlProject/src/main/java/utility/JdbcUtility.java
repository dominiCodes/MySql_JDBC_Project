package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtility { //Setting up the connection
	
	public static Connection connect()
	{
		//load the driver
		//estabilish connection
		Connection connection=null;
		try
		{
		Class.forName("org.postgresql.Driver");
		 connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/JavProjectJDBC","postgres","postgres");
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return connection;
	}
}
