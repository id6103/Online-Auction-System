package auction.dao;



import java.sql.Connection;

import org.junit.Test;
import auction.dao.DAOBase;;

public class TestDAOBase{
	@Test
	public void main(){
		DAOBase a=new DAOBase();
		//���������ݿ������
		Connection conn=a.getConn();
		
		//���Թر����ݿ�
		a.close(conn);
	}
		

}
