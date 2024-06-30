/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;
import java.sql.*;
/**
 *
 * @author bhadoriya
 */
public class ConnectionProvider {
    public static Connection getCon(){
         Connection con;
        try{
              Class.forName("oracle.jdbc.driver.OracleDriver");
              con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","shivani");
             }
        catch(Exception e){
            return null;
        }
        return con;
    }
}
