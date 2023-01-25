import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ServletPart5 extends HttpServlet{
	
	public void init(){}

	public void destroy(){}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		printHeaders(request, response,out);
	}

	public void printHeaders(HttpServletRequest request, HttpServletResponse response,PrintWriter out){
		
		out.println("<HTML>");
		out.println("<style>table, th, td {border:1px solid black;}</style>");
		out.println("<BODY>");
		out.print("<H1>All getX() methods for HttpServletRequest class</H1>");
		out.print("<TABLE><TR><TH>methodName</TH><TH>returnType</TH><TH>value</TH></TR>");
		
		//methods - boolean
		out.println("<TR><TD>"+"getAuthType()"+"</TD>" +"<TD>"+ "boolean" +"</TD>"+"<TD>"+request.getAuthType()+"</TD>"+"</TR>");
		
		//methods - string
		out.println("<TR><TD>"+"getMethod()"+"</TD>" +"<TD>"+ "string" +"</TD>"+"<TD>"+request.getMethod()+"</TD>"+"</TR>");
		
		out.println("</TABLE>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}