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
		Map<String,String> parameters = new HashMap<>();
		parameters.put("email",request.getParameter("email"));
		parameters.put("pswd",request.getParameter("pswd"));
		parameters.put("cnfpwd",request.getParameter("cnfpwd"));
		parameters.put("pic",request.getParameter("pic"));
		parameters.put("gender",request.getParameter("gender"));
		parameters.put("country",request.getParameter("country"));
		parameters.put("hobby",request.getParameter("hobby"));
		parameters.put("address",request.getParameter("address"));

		//HttpHeaders headers = new HttpHeaders();
		Map<String,String[]> parameter = request.getParameterMap();

		//HttpHeaders headers = new HttpHeaders();
		Map<String,String> headers = new HashMap<>();
		for(Enumeration<String> names = request.getParameterNames(); names.hasMoreElements();){
			String name = (String) names.nextElement();
			headers.put(name,(String) request.getParameter(name));
		}
		
		PrintWriter out = response.getWriter();
		printHeaders(parameters,parameter,headers,out);

	}

	public void printHeaders(Map<String,String> parameters, Map<String,String[]> parameter,Map<String,String> headers, PrintWriter out){
		out.println("<HTML>");
		out.println("<style>table, th, td {border:1px solid black;}</style>");
		out.println("<BODY>");
		out.print("<H1>Form details using getParameter()</H1>");
		out.print("<TABLE><TR><TH>name</TH><TH>value</TH></TR>");
		for(String key:parameters.keySet()){
			out.println("<TR><TD>"+key+"</TD>" + "<TD>"+parameters.get(key)+"</TD>"+"</TR>");
		}
		out.println("</TABLE>");

		out.print("<H1>Form details using getParameterMap()</H1>");
		out.print("<TABLE><TR><TH>name</TH><TH>value</TH></TR>");
		for(String key:parameter.keySet()){
			out.println("<TR><TD>"+key+"</TD>" + "<TD>"+parameters.get(key)+"</TD>"+"</TR>");
		}
		out.println("</TABLE>");

		out.print("<H1>Form details using getParameterNames()</H1>");
		out.print("<TABLE><TR><TH>name</TH><TH>value</TH></TR>");
		for(String key:headers.keySet()){
			out.println("<TR><TD>"+key+"</TD>" + "<TD>"+parameters.get(key)+"</TD>"+"</TR>");
		}
		out.println("</TABLE>");

		out.println("</BODY>");
		out.println("</HTML>");
	}

}