/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dales
 */
public class Conexion {
    Connection con=null;
    
    public Conexion(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/acortador_urls","root","");
        }catch(ClassNotFoundException | SQLException e){
            //System.out.println("error conexion"+e.getMessage());
        }
    }
    public Connection getConnection(){
        return con;
    }
}
