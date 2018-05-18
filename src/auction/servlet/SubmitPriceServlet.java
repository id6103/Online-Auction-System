package auction.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import auction.dao.UserDAO;


public class SubmitPriceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String buyName=(String)session.getAttribute("LOGIN_USER");
		String p = request.getParameter("myPrice");		
		int myPrice = Integer.parseInt(p);
		String o = request.getParameter("productId");		
		int productId = Integer.parseInt(o);
		String productName = request.getParameter("productName");	
		
		
		boolean success=dao.submitPrice(productId,buyName,myPrice,productName);
		
		// 4. 向结果jsp页面传值，必须在页面跳转之前
		request.setAttribute("productId", productId);     
		
		// 5. 跳转页面
		if(success)
		request.getRequestDispatcher("addPrice.jsp")
			.forward(request, response);
		
	}
}