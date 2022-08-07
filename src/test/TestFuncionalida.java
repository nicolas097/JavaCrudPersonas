/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import clases.Persona;
import datos.PersonaDAO;
import java.util.List;

/**
 *
 * @author nikko
 */
public class TestFuncionalida {
    public static void main(String[] args) {
        
        String mensaje = "";
        PersonaDAO pDAO = new PersonaDAO();
        String nombre = pDAO.getNombreComunaFN(2);
        System.out.println("Nombre de la comuna : " + nombre );
    }
}
//        pDAO.Listar();
//
//        if(pDAO.Actualizar(p2)){
//            mensaje = "Se modifico el usuario";
//            System.out.println(mensaje);
//        }else{
//            mensaje = "No se ha modificado nada";
//            System.out.println(mensaje);
//        }
//        
//        if(pDAO.insertar(p1)){
//            mensaje = "Se inserto alggo";
//            System.out.println(mensaje);
//        }else{
//            mensaje = "No se ha insertado nada";
//            System.out.println(mensaje);
//        }
//        Persona pEliminar = new Persona(7);
//
//       if (pDAO.Eliminar(pEliminar)){
//           mensaje = "Se eliminó la persona";
//           System.out.println(mensaje);
//       }else{
//           mensaje = "no se eliminó persona";
//           System.out.println(mensaje);
//       }
//     
////     
////      
////        
////        
//////
//////
//////
//////       Persona p1 = new Persona( 8, "Joe Dohn", "Smith Witson", 6);
//////       pDAO.insertar(p1);
//////
//////
//////
//////        Persona p2 = new Persona(7,"Jorge","Poblete",5);
////////        
//////        if(pDAO.Actualizar(p2)){
//////            mensaje = "Se modifico el usuario";
//////            System.out.println(mensaje);
//////        }else{
//////            mensaje = "No se ha modificado nada";
//////            System.out.println(mensaje);
//////        }
//////
//////        if(pDAO.insertar(p1)){
//////            mensaje = "Se inserto alggo";
//////            System.out.println(mensaje);
//////        }else{
//////            mensaje = "No se ha insertado nada";
//////            System.out.println(mensaje);
//////        }
//////        Persona pEliminar = new Persona(7);
//////
//////       if (pDAO.Eliminar(pEliminar)){
//////           mensaje = "Se eliminó la persona";
//////           System.out.println(mensaje);
//////       }else{
//////           mensaje = "no se eliminó persona";
//////           System.out.println(mensaje);
//////       }
//////
//////
//////
//////
//////}
////////
//////    }

