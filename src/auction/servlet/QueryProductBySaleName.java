package auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auction.dao.UserDAO;
import auction.vo.ProductVO;

public class QueryProductBySaleName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String saleName = (String) session.getAttribute("LOGIN_USER");
		String a = request.getParameter("action");
		int action = Integer.parseInt(a);
		//UserDAO dao = new UserDAO();
		List<ProductVO> array = null;
		if (action == 1) {
			//查询我的拍卖
			array = dao.queryBySaleName(saleName);
		} else if (action == 2) {
			//查询我参与的拍卖（拍卖中）
			//array = dao.queryMyProduct(saleName);
		} else {
			////查询我参与的拍卖（已结束）
			array = dao.queryByBuyName(saleName);
		}

		// 4. 向结果jsp页面传值，必须在页面跳转之前
		request.setAttribute("QUERYPRODUCT_RES", array);
		request.setAttribute("ACTION", action);

		// 5. 跳转页面
		request.getRequestDispatcher("myAuction.jsp")
				.forward(request, response);

	}
}