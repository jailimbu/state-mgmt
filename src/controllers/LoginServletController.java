package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

/**
 * Servlet implementation class loginController
 */
@WebServlet(name = "LoginServletController", urlPatterns = {"/LoginServlet"})
public class LoginServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        
        if(userName.equals("admin") && password.equals("test123"))
        {
        	User userObj = new User();
        	userObj.setUserName(userName);
        	userObj.setPassword(password);
        	
            HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
            response.sendRedirect("welcome.jsp");
        }
        else
        {
			javax.servlet.RequestDispatcher rd =  request.getRequestDispatcher("/login.jsp");
			request.setAttribute("msg","Incorrect Username Password");
			rd.forward(request, response);
        }
        	
    }

}
