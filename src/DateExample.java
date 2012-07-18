import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DateExample extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {

    //get an output stream from the response object
    PrintWriter out = response.getWriter();

    //get the time now!
    Date date = new Date();

    //display the date
    out.println("<html>");
    out.println("<body>");
    out.println("Hello! the time is now " + date.toString());
    out.println("</body>");
    out.println("</html>");
  }


}



