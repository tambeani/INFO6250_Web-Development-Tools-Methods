import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.NoSuchMethodException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;

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
		out.print("<H1>All getX() methods for HttpServletRequest & ServletRequest class</H1>");
		out.print("<TABLE><TR><TH>methodName</TH><TH>returnType</TH><TH>value</TH></TR>");

		Class c = request.getClass();
      	Method[] methods = c.getMethods();
		  for (int i = 0; i < methods.length; i++) {
			if(!methods[i].getName().contains("get")) continue;
			try{
			Object[] type = methods[i].getParameterTypes();
			if(type.length == 0){
				out.println("<TR><TD>"+methods[i].getName()+"</TD>" +"<TD>"+ methods[i].getReturnType() +"</TD>"+"<TD>"+methods[i].invoke(request)+"</TD>"+"</TR>");
			}
			else if(type.length == 1){
				out.println("<TR><TD>"+methods[i].getName()+"</TD>" +"<TD>"+ methods[i].getReturnType() +"</TD>"+"<TD>"+methods[i].invoke(request,(Object) type)+"</TD>"+"</TR>");
			}else{
				out.println("<TR><TD>"+methods[i].getName()+"</TD>" +"<TD>"+ methods[i].getReturnType() +"</TD>"+"<TD>"+methods[i].invoke(request,type)+"</TD>"+"</TR>");
			}
			}catch(Exception e){
				//out.println("<TR><TD>"+methods[i].getName()+"</TD>" +"<TD>"+ methods[i].getReturnType() +"</TD>"+"<TD>"+e.getMessage()+"</TD>"+"</TR>");
			}
		}

		out.println("</BODY>");
		out.println("</HTML>");
	}

}