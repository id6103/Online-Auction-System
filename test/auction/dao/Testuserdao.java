package auction.dao;

import static org.junit.Assert.*;
import auction.dao.*;
import auction.vo.LoginUserVO;
import auction.vo.ProductVO;


import org.junit.Test;

public class Testuserdao {
	@Test
	public void testuserdao(){
		ProductVO vo=new ProductVO("f","f","f","f",1);
	    UserDAO dao=new UserDAO();
	    //�Ƿ������µ�����
	    boolean success=dao.addAuction(vo);
	    //���Բ�����߼�
	    int max=dao.maxPrice(2);
	    //�ҳ�����ߵ�����
		dao.maxBuyer(2,max);
	    //��������
		dao.endAuction("f", max, 2);
		//�û���¼
		LoginUserVO pvo=new LoginUserVO("fjc","123");
		dao.login(pvo);
		
	}
	

}
