package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.register;
import service.registerService;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public registerController() {
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
		doGet(request, response);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		
		registerService rs=new registerService();
		register rb=new register();
		rb.setEmail(email);
		rb.setPassword(password2);
		//rs.insertUser(rb);
		rs.create(rb);
		//String ui=rs.create(rb);
		//System.out.println(ui);
	}

}
