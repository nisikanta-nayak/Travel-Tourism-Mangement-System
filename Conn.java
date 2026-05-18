package travel.management.systrm;

//Add pakage for mysql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//This class was not going to run
//other classes make objective of this class
//we use Java Database connectivity(JDBC)Concept
public class Conn {
    //Object for connection and statement
    Connection c;
    Statement s;
    Conn(){
        //It may give error during run time so we use try and catch block
        try {
            //Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating connection stream with mysql
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "000999@Ni");
            //Creating Statement Stream
            //statement created using of connection
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
