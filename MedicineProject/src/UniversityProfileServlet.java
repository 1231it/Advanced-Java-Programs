package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UniversityProfileServlet
 */
@WebServlet("/UniversityProfileServlet")
public class UniversityProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UniversityProfileServlet() {
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

        
        out.println("<html>");

        out.println("<head>");
        out.println("<title>University Profile</title>");
        out.println("</head>");

        out.println("<body>");

    
        out.println("<h1>University Profile</h1>");

      
        out.println("<table border='1' cellpadding='10'>");

        out.println("<tr>");
        out.println("<th>University Name</th>");
        out.println("<td>Shri Vishnu Engineering College for Women</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Location</th>");
        out.println("<td>Bhimavaram, Andhra Pradesh</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Accreditation</th>");
        out.println("<td>NAAC Accredited</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th>Contact</th>");
        out.println("<td>info@svecw.edu.in</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<h2>Schools</h2>");
        out.println("<ul>");
        out.println("<li>School of Computer Science</li>");
        out.println("<li>School of Information Technology</li>");
        out.println("<li>School of Electronics</li>");
        out.println("<li>School of Electrical Engineering</li>");
        out.println("</ul>");
        out.println("<h2>Programs</h2>");
        out.println("<ul>");
        out.println("<li>B.Tech in Computer Science and Engineering</li>");
        out.println("<li>B.Tech in Information Technology</li>");
        out.println("<li>B.Tech in Electronics and Communication Engineering</li>");
        out.println("<li>B.Tech in Electrical and Electronics Engineering</li>");
        out.println("</ul>");

        
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
