import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ServletPart2 extends HttpServlet{
	
	public void init(){}

	public void destroy(){}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		
		//HttpHeaders headers = new HttpHeaders();
		Map<String,String> headers = new HashMap<>();
		for(Enumeration<?> names = request.getHeaderNames(); names.hasMoreElements();){
			String name = (String) names.nextElement();
			for(Enumeration<?> values = request.getHeaders(name); values.hasMoreElements();){
				headers.put(name,(String) values.nextElement());
			}
		}
		PrintWriter out = response.getWriter();

		printHeaders(headers, out);

	}

	public void printHeaders(Map<String,String> headers, PrintWriter out){
		out.println("<HTML>");
		out.println("<style>table, th, td {border:1px solid black;}</style>");
		out.println("<BODY>");
		out.print("<H1>HTTP Request Headers</H1>");
		out.print("<TABLE><TR><TH>name</TH><TH>value</TH></TR>");
		for(String key:headers.keySet()){
			out.println("<TR><TD>"+key+"</TD>" + "<TD>"+headers.get(key)+"</TD>"+"</TR>");
		}
		out.println("</TABLE>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
}