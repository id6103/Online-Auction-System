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
			//��ѯ�ҵ�����
			array = dao.queryBySaleName(saleName);
		} else if (action == 2) {
			//��ѯ�Ҳ���������������У�
			//array = dao.queryMyProduct(saleName);
		} else {
			////��ѯ�Ҳ�����������ѽ�����
			array = dao.queryByBuyName(saleName);
		}

		// 4. ����jspҳ�洫ֵ��������ҳ����ת֮ǰ
		request.setAttribute("QUERYPRODUCT_RES", array);
		request.setAttribute("ACTION", action);

		// 5. ��תҳ��
		request.getRequestDispatcher("myAuction.jsp")
				.forward(request, response);

	}
}