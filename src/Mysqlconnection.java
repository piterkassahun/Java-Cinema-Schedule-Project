import java.sql.Connection;
import java.sql.DriverManager;

public class Mysqlconnection {
    public static Connection getconnection() throws Exception{
        String dbroot="jdbc:mysql://";
        String hostname="localhost:3306/";
        String dbname="cinema_schedule_project";
        String dburl=dbroot+hostname+dbname;

        String hostusername="root";
        String hostpassword="Ant@784301";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection myconn=(Connection) DriverManager.getConnection(dburl,hostusername,hostpassword);
        return myconn;
    }
}
