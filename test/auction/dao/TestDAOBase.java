package auction.dao;



import java.sql.Connection;

import org.junit.Test;
import auction.dao.DAOBase;;

public class TestDAOBase{
	@Test
	public void main(){
		DAOBase a=new DAOBase();
		//测试与数据库的连接
		Connection conn=a.getConn();
		
		//测试关闭数据库
		a.close(conn);
	}
		

}
