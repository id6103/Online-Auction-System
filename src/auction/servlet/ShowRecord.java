package auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import auction.dao.UserDAO;
import auction.vo.RecordVO;


public class ShowRecord extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String buyName=(String)session.getAttribute("LOGIN_USER");
	
		
		//UserDAO dao = new UserDAO();
		List<RecordVO> arr=dao.queryMyProduct(buyName);
		
		// 4. ����jspҳ�洫ֵ��������ҳ����ת֮ǰ
		request.setAttribute("RECORD", arr);     
		
		// 5. ��תҳ��
		request.getRequestDispatcher("showRecord.jsp")
			.forward(request, response);
		
	}
}