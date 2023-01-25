import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ServletPart3 extends HttpServlet{
	
	public void init(){}

	public void destroy(){}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		
		//HttpHeaders headers = new HttpHeaders();
		Map<String,String> headers = new HashMap<>();
		for(Enumeration<String> names = request.getParameterNames(); names.hasMoreElements();){
			String name = (String) names.nextElement();
			headers.put(name,(String) request.getParameter(name));
		}

		PrintWriter out = response.getWriter();
		printHeaders(headers, out);

	}

	public void printHeaders(Map<String,String> headers, PrintWriter out){
		out.println("<HTML>");
		out.println("<style>table, th, td {border:1px solid black;}</style>");
		out.println("<BODY>");
		out.print("<H1>Form details</H1>");
		out.print("<TABLE><TR><TH>name</TH><TH>value</TH></TR>");
		for(String key:headers.keySet()){
			out.println("<TR><TD>"+key+"</TD>" + "<TD>"+headers.get(key)+"</TD>"+"</TR>");
		}
		out.println("</TABLE>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}