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
	    //是否生成新的拍卖
	    boolean success=dao.addAuction(vo);
	    //测试查找最高价
	    int max=dao.maxPrice(2);
	    //找出价最高的卖家
		dao.maxBuyer(2,max);
	    //结束拍卖
		dao.endAuction("f", max, 2);
		//用户登录
		LoginUserVO pvo=new LoginUserVO("fjc","123");
		dao.login(pvo);
		
	}
	

}
