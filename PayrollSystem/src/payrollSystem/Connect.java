package payrollSystem;

import java.sql.*;

public class Connect {
    
    public Connection c;
    public Statement s;
 
    public Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///payrollsystem","root","Vrushabh@1508");
            s = c.createStatement();
            
        
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
 