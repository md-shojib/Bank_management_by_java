import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn{
    Connection connection;
    Statement statement;
    public Conn(){
        String url = "jdbc:mysql://localhost:3306/bankmanagementsystem"; //
        String user = "root"; 
        String password = ""; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            statement = connection.createStatement();
            /* String query = "SELECT * FROM fontdetails"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                
                System.out.println(resultSet.getString("fontname")); 
            }
               */  
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
