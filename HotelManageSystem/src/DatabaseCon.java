import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseCon {
	
	private Connection conn;
	
	public DatabaseCon() 
	{
		
		//����MYSQL-JDBC����
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC���سɹ�");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//MYSQL url
		String url="jdbc:mysql://127.0.0.1:3306/hotelmanager?&useSSL=false&serverTimezone=GMT";
		
		//�������ݿ�
		try {
			
			conn=DriverManager.getConnection(url, "root", "657500811");
			System.out.println("���ݿ����ӳɹ�");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//get���� �����������н���Statement����
	public Connection getConn()
	{
		return conn;
	}
	
}
