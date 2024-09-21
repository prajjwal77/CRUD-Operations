package InsertMysqlQuerry;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import in.JDBCUtil.JDBCUtil;

public class InsertMysqlQuerry {
	 public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtil.getJdbcCOnnection();
			if(connection!=null) {
				String mysqlQuery="INSERT into project(student_id,name,age) values (?,?,?)";
				preparedStatement=connection.prepareStatement(mysqlQuery);
				if(preparedStatement!=null) {
					preparedStatement.setInt(1,3);
					preparedStatement.setString(2,"Sunak");
					preparedStatement.setInt(3,35);
				
					int rowaffected=preparedStatement.executeUpdate();
					if(rowaffected==1)
					{
						System.out.println("Row Inserted");
						}
					else {
						System.out.println("Row Not Inserted");
					}
				}
			}
		}
		catch(IOException | SQLException e) {
			e.printStackTrace();
		}  
		finally 
		{
			try {
			JDBCUtil.closeResource(connection, preparedStatement);
		        }
		         catch (SQLException e) {
			     
			     e.printStackTrace();
		          }
		}
	}
}
