import java.sql.*;

public class DerbyTest {

  public static void main(String[] args) {

    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    String dbName= "dbDemo";
    String connectionURL = "jdbc:derby:" + dbName + ";create=true";

    String createString = "CREATE TABLE Person "
      +  "(person_id INT NOT NULL GENERATED ALWAYS AS IDENTITY, " 
      +  "name VARCHAR(32) NOT NULL) " ;

    try {
      Class.forName(driver); 
    } catch(java.lang.ClassNotFoundException e) {
      System.out.println("failed to load Derby embedded driver " + e.toString());
    }

    try {
      Connection conn = DriverManager.getConnection(connectionURL);
      
      Statement createTable  = conn.createStatement();
      createTable.execute(createString);

      PreparedStatement psInsert = conn.prepareStatement("insert into Person(name) values 'TestName'");
      psInsert.executeUpdate(); 

      Statement select = conn.createStatement();
      ResultSet people = select.executeQuery("select name from Person");

      System.out.println("people toString()" + people.toString());   

      while (people.next()) {
        System.out.println("Pulled this name from db: " + people.getString(1));
      }
    } catch (Throwable e) {   
      System.out.println("JDBC Error: " + e.toString());
    }

  }
}
