package auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auction.dao.UserDAO;
import auction.vo.RegisterVO;

//import demo.QueryUserVO;
//import demo.UserDao;

public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		int password=Integer.parseInt(pwd);
		String address = request.getParameter("address");
		String identification_no = request.getParameter("identification_no");
		int IDno=Integer.parseInt(identification_no);
		String age=request.getParameter("age");
		int Age=Integer.parseInt(age);
		String hobby=request.getParameter("hobby");
		
		
		
		RegisterVO vo = new RegisterVO(
		name, password,address,IDno,Age,hobby);
		
		
		if(dao.username(name)==false) {//判断用户是否已经注册
			RequestDispatcher rd = 
				request.getRequestDispatcher("UserRegister.jsp");
			rd.forward(request, response);
			return;
		}	
		//boolean success = dao.add(vo);//向数据库添加vo记录
		else{
			
		boolean success = dao.insert(vo);
		String page = "UserRegister.jsp";
		if(success)
			page = "RegisterOk.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);}}
		
		
	}


