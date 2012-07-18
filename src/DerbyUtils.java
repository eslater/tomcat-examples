import java.sql.*;
import java.util.ArrayList;

public class DerbyUtils {

  //derby config
  private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver"; 
  private static final String CONNECTION_URL = "jdbc:derby:Databases/dbDemo;create=false";

  public static boolean loadDB() {
    try {
      Class.forName(DRIVER); //load derby driver
    } catch(java.lang.ClassNotFoundException e) {
      System.out.println("failed to load Derby embedded driver " + e.toString());
      return false;
    }
    return true;
  }

  public static boolean insertName(String name) {
     try {
      Connection conn = DriverManager.getConnection(CONNECTION_URL);
      PreparedStatement psInsert = conn.prepareStatement("insert into Person(name) values '" + name + "'");
      psInsert.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static ArrayList<String> getNames() {
    ArrayList<String> nameList = new ArrayList<String>(); 
    try {
      Connection conn = DriverManager.getConnection(CONNECTION_URL);
      Statement select = conn.createStatement();
      ResultSet results  = select.executeQuery("select name from Person");
      while (results.next()){
        nameList.add(results.getString(1));
      }
    } catch (Throwable e) {
      e.printStackTrace();
    } 
    return nameList;
  }
}
