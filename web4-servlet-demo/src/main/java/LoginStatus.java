

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginStatus
 */
public class LoginStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStatus() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// here we will try to take out the request attribute "loginStatus" from the request
		String status = (String) request.getAttribute("loginStatus");
		
		HttpSession session = request.getSession();
		String getUser = (String) session.getAttribute("user");
		
		// now print the status to the response
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h2>"+status+"</h2>");
		
//		String getUser = (String) request.getAttribute("user");
		if(getUser != null) {
			out.println("<h4> Welcome " +getUser+ "!!</h4>");
			out.println("<a href=\"Logout\"> Logout</a>");
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
