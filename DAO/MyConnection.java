/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RESTORA.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MyConnection {
    public static final String username ="root";
    public static final String password ="";
    public static final String url ="jdbc:mysql://localhost:3306/restora";
    public static Connection con = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ""+ex,"", JOptionPane.WARNING_MESSAGE);
        }
        return con;
    }
}


// Login and Registration Database separately created on there...
