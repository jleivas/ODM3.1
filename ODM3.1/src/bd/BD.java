/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author home
 */
public class BD {
    private static Connection conn = null;
    public static String bdNombre = "localhost";
    public static String user = "root";
    public static String pass = "pass";
    
    public static Connection obtener() throws SQLException, ClassNotFoundException
    {
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://"+bdNombre+"/sdxod",user,pass);
          
        return conn;
    }
    
    public boolean esLocal(){
        if(this.bdNombre.equals("localhost"))
            return true;
        else
            return false;
    }
    
    public static void cerrar() throws SQLException
    {
        if(conn!=null)
            conn.close();
    }
    
    public static void setBd(String nombre){
        bdNombre = nombre;
        user = "root2";
        pass = "pass";
    }
}
