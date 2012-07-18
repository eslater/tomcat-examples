import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertExample extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {

    //get an output stream from the response object    
    PrintWriter out = response.getWriter();    
   
    //display the form 
    out.println("<html>");
    out.println("<body>");
    out.println("<form method=post action=\"/insert\">");
    out.println("What's your name? <input type=test name=guestname size=20><br>");
    out.println("<input type=submit value=Submit>");
    out.println("</body>");
    out.println("</html>");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {

    //get an output stream from the response object    
    PrintWriter out = response.getWriter();    
  
    //retrieve inputs from the request
    String guestname = request.getParameter("guestname");

    //initialize derby 
    DerbyUtils.loadDB();

    //insert name into databse  
    boolean insertSuccess = DerbyUtils.insertName(guestname); 


    //display success message if insert succeeeds, display error message otherwise
    if (insertSuccess){
      out.println("<html>");
      out.println("<body>");
      out.println("Hello " + guestname + "! You have been inserted into the database!");
      out.println("</body>");
      out.println("</html>");
    } else {
      out.println("<html>");
      out.println("<body>");
      out.println("Failed to insert into database. Check logs for errors.");
      out.println("</body>");
      out.println("</html>");
    }
  }
}



