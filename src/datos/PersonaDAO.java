package datos;

import clases.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT P.IDPERSONA, P.NOMBRES, P.APELLIDOS, P.IDCOMUNA, C.NOMBRECOMUNA FROM PERSONA P INNER JOIN COMUNA C ON C.IDCOMUNA = P.IDCOMUNA ORDER BY 1 ASC";

    private static final String SQL_INSERT = "INSERT INTO PERSONA (IDPERSONA, NOMBRES, APELLIDOS, IDCOMUNA)VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE PERSONA SET NOMBRES = ?, APELLIDOS = ?, IDCOMUNA = ? WHERE IDPERSONA = ? ";

    private static final String SQL_DELETE = "DELETE FROM PERSONA WHERE IDPERSONA = ?";
    //Consulta de base de datos con inner join 
    public void Listar() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDPERSONA");
                String Nombres = rs.getString("NOMBRES");
                String Apellidos = rs.getString("APELLIDOS");
                int idComuna = rs.getInt("IDCOMUNA");
                String NombreComuna = getNombreComuna(idComuna);
                System.out.println("Persona = " + " IDPERSONA : " + id
                        + " NOMBRES : " + Nombres
                        + " APELLIDOS : " + Apellidos
                        + " NOMBRE COMUNA : " + NombreComuna);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (Exception e) {
            }
        }

    }

    public boolean insertar(Persona p) {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setInt(1, p.getIdPersona());
            pst.setString(2, p.getNombres());
            pst.setString(3, p.getApelidos());
            pst.setInt(4, p.getIdComuna());
            pst.execute();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }
    
    
    public boolean Actualizar( Persona p){
        Connection conn = null;
        PreparedStatement pst = null;
        
        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(SQL_UPDATE);
            pst.setString(1, p.getNombres());
            pst.setString(2, p.getApelidos());
            pst.setInt(3, p.getIdComuna());
            pst.setInt(4, p.getIdPersona());
            pst.execute();
            return true;
            
        } catch ( SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }
    
    
    
    public boolean Eliminar(Persona p){
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, p.getIdPersona());
            pst.execute();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                pst.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return false;
    }

    //Retorna un valor desde la base de datos de tipo String en esta caso el nombre de la comuna
    public String getNombreComuna(int idComuna) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombreComuna = "";
        String sql = "SELECT NOMBRECOMUNA FROM COMUNA WHERE IDCOMUNA =" + idComuna;
        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                nombreComuna = rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return nombreComuna;
    }

}
