package auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auction.dao.UserDAO;
import auction.vo.ProductVO;
import auction.vo.RecordVO;

public class ProductDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p = request.getParameter("productId");
		String a = request.getParameter("action");
		int action = Integer.parseInt(a);
		
		int productId = Integer.parseInt(p);
		
		//UserDAO dao = new UserDAO();
		ProductVO vo = dao.queryByProductId(productId);
		List<RecordVO> arrayRVO=dao.queryRecordByProductId(productId);
		int max=dao.maxPrice(productId);
		String buyName=dao.maxBuyer(productId,max);
		
		//dao.endAuction(buyName, max, productId);
	   
		// 4. 向结果jsp页面传值，必须在页面跳转之前
	    request.setAttribute("PRODUCT_DETAIL",vo);
	    request.setAttribute("RECORD_DETAIL",arrayRVO);
	    request.setAttribute("ACTION", action);
	    request.setAttribute("MAXPRICE",max);
	    request.setAttribute("BUYNAME", buyName);
		
		// 5. 跳转页面
		request.getRequestDispatcher("productDesc.jsp")
			.forward(request, response);
		
	}
}