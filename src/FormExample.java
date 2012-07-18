import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormExample extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
    
    //get an output stream from the response object
    PrintWriter out = response.getWriter();    
   
    //display the form 
    out.println("<html>");
    out.println("<body>");
    out.println("<form method=post action=\"/formExample\">");
    out.println("What's your name? <input type=text name=guestname size=20><br>");
    out.println("<input type=submit value=Submit>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
    
    //get an output stream from the response object
    PrintWriter out = response.getWriter();    
    
    //display the form 
    out.println("<html>");
    out.println("<body>");
    out.println("Hello " + request.getParameter("guestname"));
    out.println("</body>");
    out.println("</html>");
  }
}
