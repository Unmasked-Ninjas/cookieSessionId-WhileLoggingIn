package sandbox.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SiteController
 */
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SiteController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		response.getWriter().print(password);
		if(username.equals("itstean") && password.equals("1234")) {
			//invilidate session 
			request.getSession().invalidate();
			
			HttpSession newsession = request.getSession(true);
			newsession.setMaxInactiveInterval(30);
			Cookie cUsername = new Cookie("username", username);
			response.addCookie(cUsername);
			response.sendRedirect("memberarea.jsp");
			
		}
		else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
