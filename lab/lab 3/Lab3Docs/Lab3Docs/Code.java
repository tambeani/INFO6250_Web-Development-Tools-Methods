import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
---------------------------
res.setContentType("text/html");
PrintWriter out = res.getWriter();

---------------------------
out.println("<html>");
out.println("<head><title>Question 1</title></head>");
out.println("<body>");
out.println("<form method='post' action='question.html'>");

---------------------------

out.println("<h2>Question 1. Choose the appropriate data type for this field: isSwimmer</h2>");
out.println("<input type='radio' name='answer' value='a' />A) double<br/>");
out.println("<input type='radio' name='answer' value='b' />B) boolean<br/>");
out.println("<input type='radio' name='answer' value='c' />C) string<br/>");
out.println("<input type='radio' name='answer' value='d' />D) int<br/>");
out.println("<input type='hidden' name='qn' value='1'/>");

---------------------------

out.println("<h2>Question 2. What is a correct syntax to output \"Hello World\" in Java?</h2>");
out.println("<input type='radio' name='answer' value='a' />A) System.out.println(\"Hello World\");<br/>");
out.println("<input type='radio' name='answer' value='b' />B) echo(\"Hello World\");<br/>");
out.println("<input type='radio' name='answer' value='c' />C) print (\"Hello World\");<br/>");
out.println("<input type='radio' name='answer' value='d' />D) Console.WriteLine(\"Hello World\");<br/>");
out.println("<input type='hidden' name='qn' value='2'/>");
---------------------------

out.println("<h2>Question 3. Which data type is used to create a variable that should store text?</h2>"); 
out.println("<input type='radio' name='answer' value='a' />A) String <br>");
out.println("<input type='radio' name='answer' value='b' />B) Txt <br>");
out.println("<input type='radio' name='answer' value='c' />C) myString <br>");
out.println("<input type='radio' name='answer' value='d' />D) string <br>");
out.println("<input type='hidden' name='qn' value='3'/>");

---------------------------


			out.println("<h2>Question 4. What guarantees type-safety in a collection?</h2>");
			out.println("<input type='radio' name='answer' value='a' />A) Generics<br/>");
			out.println("<input type='radio' name='answer' value='b' />B) Abstract classes<br/>");
			out.println("<input type='radio' name='answer' value='c' />C) Interfaces<br/>");
			out.println("<input type='radio' name='answer' value='d' />D) Collection<br/>");
			out.println("<input type='hidden' name='qn' value='4'/>");
---------------------------

			out.println("<h2>Question 5. How do you create a variable with the numeric value 5?</h2>"); 
			out.println("<input type='radio' name='answer' value='a' />A) x=5; <br>");
			out.println("<input type='radio' name='answer' value='b' />B) float x=5; <br>");
			out.println("<input type='radio' name='answer' value='c' />C) int x=5; <br>");
			out.println("<input type='radio' name='answer' value='d' />D) num x = 5 <br>");
			out.println("<input type='hidden' name='qn' value='5'/>");
---------------------------


			out.println("<h2>Test is complete. Please click below to see your results.</h2>");
			out.println("<input type='hidden' name='qn' value='done'/>");


---------------------------

out.println("<h2>Here is your Quiz Results.</h2>");

---------------------------

out.println("<input type='submit' value='Submit Question'/>");
out.println("</form>");
out.println("</body>");
out.println("</html>");
---------------------------
---------------------------