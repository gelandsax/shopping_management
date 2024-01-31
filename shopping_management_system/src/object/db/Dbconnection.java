package object.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

//连接oracle数据库
public final class Dbconnection {
    public static Connection getconnection(){
        Connection conn = null;

        String user   = "manager";
        String passwd = "123456";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,passwd);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
