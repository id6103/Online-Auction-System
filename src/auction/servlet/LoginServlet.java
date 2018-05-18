package auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auction.dao.UserDAO;
import auction.vo.LoginUserVO;
import auction.vo.ProductVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = "welcome.jsp";
		HttpSession session = request.getSession();
		List<ProductVO> arr = dao.isOnSale();

		if (session.getAttribute("LOGIN_USER") != null) {

			if (null != request.getParameter("usr")) {
				page = "loggedIn.jsp";
			}
		} else {
			String usr = request.getParameter("usr");
			String pwd = request.getParameter("pwd");
			LoginUserVO vo = new LoginUserVO(usr, pwd);
			String saleName = (String) session.getAttribute("LOGIN_USER");
			boolean success = dao.login(vo);

			// List<ProductVO> arr = dao.queryBySaleName(saleName);
			if (!success) {
				page = "login.jsp";
			} else {

				session.setAttribute("LOGIN_USER", usr);

			}
		}
		request.setAttribute("ALL_PRODUCT", arr);
		request.getRequestDispatcher(page).forward(request, response);
	}

}
