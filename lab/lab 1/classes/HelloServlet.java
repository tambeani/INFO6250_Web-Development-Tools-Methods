import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class HelloServlet extends HttpServlet{

	private int count = 0;

	// init method - creates the request & response
	public void init(){}
	
	// destroy method - deletes the request & response
	public void destroy(){}
	
	// default service for GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

		// Counter
		count++;
	
		/* request - user information stored 
		   response - result information
		   Above objects are created by the Tomcat container */
		
		// Setup the content type to HTML
		response.setContentType("text/html");

		//  Use writer object to generate an output for the browser
		PrintWriter out = response.getWriter();

		// user ip address
		String ip = request.getRemoteAddr();

		// html output
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello Servlet!</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<H1>Running Servlet</H1>");
		out.println("Count = "+count);
		out.println("</BODY>");
		out.println("</HTML>");

	}		
}