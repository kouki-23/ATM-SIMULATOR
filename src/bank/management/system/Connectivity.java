
package bank.management.system;

import java.sql.*;

public class Connectivity {
    Connection c;
    Statement s;
    public Connectivity() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "qwerty123");
        s= c.createStatement();
        } catch (Exception e) {
            System.out.println("e");
        }
        
        
    }
   
}
