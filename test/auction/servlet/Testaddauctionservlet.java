package auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import auction.dao.UserDAO;
import auction.vo.ProductVO;


public class Testaddauctionservlet {
  @Test

		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			        HttpSession session = request.getSession();
			        String saleName=(String)session.getAttribute("LOGIN_USER");
		            String productName = request.getParameter("productName");
				    String productDesc = request.getParameter("productDesc");
				    String p=request.getParameter("startPrice");
				    int startPrice=Integer.parseInt(p);
				    String img="./images/1.jpg";
				    
				    ProductVO vo=new ProductVO(productName,productDesc,img,saleName,startPrice);
				    UserDAO dao=new UserDAO();
				    boolean success=dao.addAuction(vo);

		    if(success)
			request.getRequestDispatcher("addSuccess.jsp").forward(request, response);
		}

	  
  }

