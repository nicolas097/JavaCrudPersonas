package clases;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Persona {
    
    private int idPersona ;
    private String nombres;
    private String apelidos;
    private int idComuna;
   

 
    public Persona() {
        
    }
    
    
    public Persona (int idPersona){
        this.idPersona = idPersona;
    }

    public Persona( String nombres, String apelidos, int idComuna) {
        this.nombres = nombres;
        this.apelidos = apelidos;
        this.idComuna = idComuna;
    }

    public Persona(int idPersona, String nombres, String apelidos, int idComuna) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apelidos = apelidos;
        this.idComuna = idComuna;
    }
    
    


    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombres=" + nombres + ", apelidos=" + apelidos + ", idComuna=" + idComuna + '}';
    }

 
    
    
    
    
}
