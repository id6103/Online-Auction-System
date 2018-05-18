//connect with mysql
package auction.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOBase {
	public String url = "jdbc:mysql://localhost:3306/auction";
	public String user = "root";
	public String pwd = "123456";
	public String driver = "com.mysql.jdbc.Driver";
	
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver);//加载类库
			//获取连接
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close (Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
