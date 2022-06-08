

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// take out the request parameters from request
		String username = request.getParameter("user");
		String password = request.getParameter("pword");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String validationResult = null;
		
		if("admin".equals(username) && "admin".equals(password)) {
			// 1st way - out print
//			out.println("<h3>Login Succesffully!</h3>");
//			response.sendRedirect("LoginSuccessFile.html"); // this places a new request to the file specified
			// here a dummy response is sent back to the client and a new request is placed from the client to the LoginSuccessFile.html
			// we are redirecting to a static page, means we are losing the dynamism
			// so lets redirect to a dynamic page say anotehr servlet
			
			validationResult = "Login Success!!";
//			request.setAttribute("user", username); // name-value pair inside the request
			
			// going for a wider scope to hold the user data - session
			HttpSession session = request.getSession();
			session.setAttribute("user", username); // put the name-value pair in the session
			
		} else {
			// 2nd way - sendRedirect to another html file
//			out.println("<h3>Login Failed.</h3>");
//			response.sendRedirect("LoginFailedFile.html");
			
			validationResult = "Login Failed";
		}
		// a request attribute is a name/value pari that holds data
		// you could add any number of request attributes
		
		// 3rd way
		// we no longer need the LoginFailedFile.html and LoginSuccessFile.html
		request.setAttribute("loginStatus", validationResult);
//		response.sendRedirect("LoginStatus");
		
		// 4th way - use RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("LoginStatus"); //this is internal
		rd.forward(request, response); // here the current servlets request and response if forwarded to LoginStatus
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
