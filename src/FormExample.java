import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormExample extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
    request.getRequestDispatcher("form.jsp").forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
    request.getRequestDispatcher("table.jsp").forward(request, response);
  }
}



