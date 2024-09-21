package in.JDBCUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

import javax.management.InvalidApplicationException;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.mysql.cj.xdevapi.PreparableStatement;


public class JDBCUtil {
	
	//task to get the  properties the application file and loading the driver with connection 
	public static Connection getJdbcCOnnection() throws IOException, SQLException {
		FileInputStream FIS=new FileInputStream("Application.properties");
		Properties P= new Properties();
		P.load(FIS);
		
		String url=P.getProperty("url");
		String user=P.getProperty("user");
		String password=P.getProperty("password");

		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		
		Connection connection=DriverManager.getConnection(url,user,password);
		return connection;
	
	}
	
	public static void closeResource(Connection connection, PreparedStatement preparedStatement) throws SQLException {

		if(connection!=null) {
			connection.close();
		}
		if(preparedStatement!=null) {
			preparedStatement.close();
	     }
	}

}
