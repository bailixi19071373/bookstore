package com.mtw.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mtw.common.ResultCode;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			ResultCode code = new UserService().checkLogin(
					new User(username, password));
			switch(code) {
			case SUCCESS:
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(request, response);
			break;
			case ERROR_USER:
				request.setAttribute("info", "用户名或者密码不正确");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				break;
			case ERROR_SYSTEM:
				request.setAttribute("info", "系统内部异常");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				break;
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
