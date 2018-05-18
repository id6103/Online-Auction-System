package auction.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auction.dao.UserDAO;


public class EndAuction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String o = request.getParameter("productId");		
		int productId = Integer.parseInt(o);
		
		//UserDAO dao = new UserDAO();
		int max=dao.maxPrice(productId);
		String buyName=dao.maxBuyer(productId,max);
		
		boolean success=dao.endAuction(buyName, max, productId);
		
		// 4. ����jspҳ�洫ֵ��������ҳ����ת֮ǰ
             
		
		// 5. ��תҳ��
		if(success)
		request.getRequestDispatcher("endSuccess.jsp")
			.forward(request, response);
		
	}
}