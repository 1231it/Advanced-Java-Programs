package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrentDateServlet
 */
@WebServlet("/CurrentDateServlet")
public class CurrentDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");

	        // Create writer to send output to browser
	        PrintWriter out = response.getWriter();
	        response.setIntHeader("refresh",2);

		
		  Date date = new Date();

	       
	        out.println("<html>");

	        out.println("<head>");
	        out.println("<title>Current Date</title>");
	        out.println("</head>");

	        out.println("<body>");

	        // Heading
	        out.println("<h1>Current Server Date and Time</h1>");

	        // Display current date
	        out.println("<p>Current Date: " + date + "</p>");

	        // HTML ends here
	        out.println("</body>");
	        out.println("</html>");
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
