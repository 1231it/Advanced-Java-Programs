package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SoftwareRequirementServlet
 */
@WebServlet("/SoftwareRequirementServlet")
public class SoftwareRequirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoftwareRequirementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Software Requirement Details</title>");
		out.println("</head>");

		out.println("<body>");

		out.println("<h1>Software Requirement Details</h1>");

		out.println("<table border='1' cellpadding='10'>");

		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<td>" + name + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>Description</th>");
		out.println("<td>" + description + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>Category</th>");
		out.println("<td>" + category + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>Gender</th>");
		out.println("<td>" + gender + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>Email</th>");
		out.println("<td>" + email + "</td>");
		out.println("</tr>");

		out.println("</table>");

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
