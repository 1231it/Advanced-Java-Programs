package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomRollServlet
 */
@WebServlet("/RandomRollServlet")
public class RandomRollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomRollServlet() {
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

        // Generate random roll number from 1 to 60
        int roll = (int)(Math.random() * 60) + 1;

        // HTML starts here
        out.println("<html>");

        out.println("<head>");

        // Refresh page every 4 seconds
        out.println("<meta http-equiv='refresh' content='4'>");

        out.println("<title>Random Roll Number</title>");
        out.println("</head>");

        out.println("<body>");

        // Heading
        out.println("<h1>Random Roll Number</h1>");

        // Display generated roll number
        out.println("<h2>Roll Number: " + roll + "</h2>");

        out.println("<p>Page refreshes every 4 seconds.</p>");

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
