    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nikko
 */
public class Conexion {
    private static Connection conn = null;
    private static String login = "crudPersona";
    private static String clave = "123";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    
    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,login,clave);
            conn.setAutoCommit(false);
            if (conn != null){
                System.out.println("Conexion exitosa.....");
            }else{
                System.out.println("Conexion erronea ");
            }
        } catch ( ClassNotFoundException | SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "conexion erronea");
        }
        return conn;
    }
    
    
    
    public void desconexion(){
        try {
            conn.close();
        } catch (Exception e) 
        {
            System.out.println("Error al desconectar .. "+e.getMessage());
            
        }
    }
    
    public static void close (ResultSet rs)throws SQLException{
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(PreparedStatement pstm)throws SQLException{
        pstm.close();
    }
    
    public static void close(Connection conn)throws SQLException{
        conn.close();
    }
    
    
      public static void main (String[] args){
        Conexion c = new Conexion();
        c.getConnection();
        
      }
}
