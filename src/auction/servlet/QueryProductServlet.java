package auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auction.dao.UserDAO;
import auction.vo.ProductVO;

public class QueryProductServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		String sPage = request.getParameter("page");
		
		int page = Integer.parseInt(sPage);
		
		
		List<ProductVO> array = dao.queryByKeyword(keyword, page,1);
		//List<ProductVO> array = dao.queryBySaleName("fjc", 1);
	    int totalPage=dao.totalPage(keyword);
		
		// 4. ����jspҳ�洫ֵ��������ҳ����ת֮ǰ
	    request.setAttribute("KEYWORD", keyword);
		request.setAttribute("QUERYPRODUCT_RES", array);
		request.setAttribute("PAGE_NUM", page);//ת��ΪInteger
		request.setAttribute("TOTAL_PAGE_NUM", totalPage);
		
		// 5. ��תҳ��
		request.getRequestDispatcher("queryProduct.jsp")
			.forward(request, response);
		
	}
}