package auction.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auction.dao.UserDAO;
import auction.vo.RegisterVO;


public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();   
  
    public UserUpdate() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username=(String)session.getAttribute("LOGIN_USER");
		String pwd = request.getParameter("pwd");
		int password=Integer.parseInt(pwd);
		String address = request.getParameter("address");
		String identification_no = request.getParameter("identification_no");
		int IDno=Integer.parseInt(identification_no);
		String age=request.getParameter("age");
		int Age=Integer.parseInt(age);
		String hobby=request.getParameter("hobby");
		
		
		
		RegisterVO vo = new RegisterVO(username,
		password,address,IDno,Age,hobby);
		
		
//		if(dao.username(name) ) {//判断用户是否已经注册
//			RequestDispatcher rd = 
//				request.getRequestDispatcher("login.jsp");
//			rd.forward(request, response);
//			return;
//		}
		//boolean success = dao.add(vo);//向数据库添加vo记录
		String page = "UpdateUser.jsp";
		boolean success = dao.update(vo);
		if(success)
		  page = "updateSuccess.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}}
