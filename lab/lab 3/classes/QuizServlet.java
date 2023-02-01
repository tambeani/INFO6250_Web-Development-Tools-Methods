import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

public class QuizServlet extends HttpServlet{

    ArrayList<String> answersList = new ArrayList<>();

    public void init(){
        answersList.add("a");
        answersList.add("b");
        answersList.add("c");
        answersList.add("d");
        answersList.add("e");
    }

    public void destroy(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        handler(request,response);
    }

    public void doPost(HttpServletRequest request,  HttpServletResponse response)throws IOException{
        handler(request,response);
    }

    public void handler(HttpServletRequest request,  HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Creating a session object
        HttpSession session = request.getSession();

        session.setMaxInactiveInterval(60*60); // 1hr 

        // Read hidden varaible
        String qnum = request.getParameter("qn");

        out.println("<html>");
        out.println("<head><title>Question 1</title></head>");
        out.println("<body>");
        out.println("<form method='post' action='question.html'>");

        if(qnum==null){
            
            String answer = request.getParameter("answer");
            out.println("<h1>Session ID:"+session.getId()+"</h1>");
            session.setAttribute("a1",answer);

            // Display question 1
            out.println("<h2>Question 1. Choose the appropriate data type for this field: isSwimmer</h2>");
            out.println("<input type='radio' name='answer' value='a' />A) double<br/>");
            out.println("<input type='radio' name='answer' value='b' />B) boolean<br/>");
            out.println("<input type='radio' name='answer' value='c' />C) string<br/>");
            out.println("<input type='radio' name='answer' value='d' />D) int<br/>");

            // Update hidden variable qn
            out.println("<input type='hidden' name='qn' value='1'/>");

        }else if(qnum.equals("1")){

            String answer = request.getParameter("answer");
            out.println("<h1>Session ID:"+session.getId()+"</h1>");
            session.setAttribute("a2",answer);

            //Display question 2
            out.println("<h2>Question 2. What is a correct syntax to output \"Hello World\" in Java?</h2>");
            out.println("<input type='radio' name='answer' value='a' />A) System.out.println(\"Hello World\");<br/>");
            out.println("<input type='radio' name='answer' value='b' />B) echo(\"Hello World\");<br/>");
            out.println("<input type='radio' name='answer' value='c' />C) print (\"Hello World\");<br/>");
            out.println("<input type='radio' name='answer' value='d' />D) Console.WriteLine(\"Hello World\");<br/>");
            out.println("<input type='hidden' name='qn' value='2'/>");

            // Update hidden variable qn
            out.println("<input type='hidden' name='qn' value='2'/>");

        }else if(qnum.equals("2")){

            String answer = request.getParameter("answer");
            out.println("<h1>Session ID:"+session.getId()+"</h1>");
            session.setAttribute("a3",answer);

            //Display question 3
            out.println("<h2>Question 3. Which data type is used to create a variable that should store text?</h2>"); 
            out.println("<input type='radio' name='answer' value='a' />A) String <br>");
            out.println("<input type='radio' name='answer' value='b' />B) Txt <br>");
            out.println("<input type='radio' name='answer' value='c' />C) myString <br>");
            out.println("<input type='radio' name='answer' value='d' />D) string <br>");
            out.println("<input type='hidden' name='qn' value='3'/>");

            // Update hidden variable qn
            out.println("<input type='hidden' name='qn' value='3'/>");

        }else if(qnum.equals("3")){

            String answer = request.getParameter("answer");
            out.println("<h1>Session ID:"+session.getId()+"</h1>");
            session.setAttribute("a4",answer);

            //Display question 4
            out.println("<h2>Question 4. What guarantees type-safety in a collection?</h2>");
			out.println("<input type='radio' name='answer' value='a' />A) Generics<br/>");
			out.println("<input type='radio' name='answer' value='b' />B) Abstract classes<br/>");
			out.println("<input type='radio' name='answer' value='c' />C) Interfaces<br/>");
			out.println("<input type='radio' name='answer' value='d' />D) Collection<br/>");
			out.println("<input type='hidden' name='qn' value='4'/>");

            // Update hidden variable qn
            out.println("<input type='hidden' name='qn' value='4'/>");
            
        }else if(qnum.equals("4")){

            String answer = request.getParameter("answer");
            out.println("<h1>Session ID:"+session.getId()+"</h1>");
            session.setAttribute("a5",answer);

            //Display question 5
            out.println("<h2>Question 5. How do you create a variable with the numeric value 5?</h2>"); 
			out.println("<input type='radio' name='answer' value='a' />A) x=5; <br>");
			out.println("<input type='radio' name='answer' value='b' />B) float x=5; <br>");
			out.println("<input type='radio' name='answer' value='c' />C) int x=5; <br>");
			out.println("<input type='radio' name='answer' value='d' />D) num x = 5 <br>");
			out.println("<input type='hidden' name='qn' value='5'/>");

            // Update hidden variable qn
            out.println("<input type='hidden' name='qn' value='5'/>");
            
        }else if(qnum.equals("5")){

            out.println("<h1>Session ID:"+session.getId()+"</h1>");
            out.println("<h2>Test is complete. Please click below to see your results.</h2>");
			out.println("<input type='hidden' name='qn' value='done'/>");

        }else if(qnum.equals("done")){
            out.println("<h1>Session ID:"+session.getId()+"</h1>");
            out.println("<h2>Here is your Quiz Results.</h2>");
            out.println("Answer 1:"+session.getAttribute("a1")+"</br>");
            out.println("Answer 2:"+session.getAttribute("a2")+"</br>");
            out.println("Answer 3:"+session.getAttribute("a3")+"</br>");
            out.println("Answer 4:"+session.getAttribute("a4")+"</br>");
            out.println("Answer 5:"+session.getAttribute("a5")+"</br>");
        }
        
        if(!"done".equals(qnum))
            out.println("<input type='submit' value='submit'/>");

        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}