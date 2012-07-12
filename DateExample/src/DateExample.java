import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DateExample extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {

    PrintWriter out = response.getWriter();

    Date date = new Date();

    out.println("<html>");
    out.println("<head>");
    out.println("<body>");
    out.println(date.toString());
    out.println("</head>");
    out.println("</body>");
    out.println("</html>");
  }
}



