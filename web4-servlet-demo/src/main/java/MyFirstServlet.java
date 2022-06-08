

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyFirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// since this is the first servlet, we are going to write output to the response
		// first, connect a PrintWriter stream to the response
		PrintWriter out = response.getWriter();
		
		// this is needed if the html isn't setting your HTML element tag
		response.setContentType("text/html");
		
		// now you could write your output to the stream
		out.println("<h1>CANADA!!</h2>");
		out.println("<h2> Hello World! </h2>");
		out.println("<h2> This is my first Servlet!! </h2>"); //<h2> is an HTML tag
		out.println("<p> The quick brown fox jumps over the lazy dog. </p>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
