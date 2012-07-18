import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SelectExample extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {

    //get an output stream from the response object 
    PrintWriter out = response.getWriter();    

    //initialize derby
    DerbyUtils.loadDB();
  
    //retrieve names from database
    ArrayList<String> names = DerbyUtils.getNames(); 
 
    //display names retrieved from database 
    out.println("<html>");
    out.println("<body>");
    out.println("<ul>");
    for (String name : names ) {  
      out.println("<li>" + name + "</li>");
    }
    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");
  }

}



