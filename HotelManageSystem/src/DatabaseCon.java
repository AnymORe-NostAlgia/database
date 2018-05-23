import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseCon {
	
	private Connection conn;
	
	public DatabaseCon() 
	{
		
		//加载MYSQL-JDBC驱动
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC加载成功");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//MYSQL url
		String url="jdbc:mysql://127.0.0.1:3306/hotelmanager?&useSSL=false&serverTimezone=GMT";
		
		//连接数据库
		try {
			
			conn=DriverManager.getConnection(url, "root", "657500811");
			System.out.println("数据库连接成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//get方法 用于其他类中进行Statement操作
	public Connection getConn()
	{
		return conn;
	}
	
}
