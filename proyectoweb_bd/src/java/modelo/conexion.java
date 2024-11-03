
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    
    
    public Connection conexionBD;
    
    
    //jdbc:mysql://localhost:3306/?user=root
    
    //Datos de la conexion a Workbench
    private final String puerto ="3306";
    private final String bd= "ligadefutbolproyecto";
   
    private final String urlConexion= String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC", puerto, bd);
    
    
    private final String usuario= "root";
   
    private final String password="diego1234";
    
    private final String jdbc= "com.mysql.cj.jdbc.Driver";
    
    
        //Metodo para abrir conexion a la BD

   public void abrir_conexion(){
            try{
                Class.forName(jdbc);
                conexionBD = DriverManager.getConnection(urlConexion,usuario,password);
        System.out.println("Conexion exitosa");
                
            }catch(ClassNotFoundException | SQLException ex){
                    System.out.println("Error: " + ex.getMessage());
            }
    
    
    
    
}
   
   
           //Metodo para cerrar conexion a la BD al momento de salir y terminar el programa

   public void cerrar_conexion(){
       
       try{
           
           conexionBD.close();
           
           
           
       }catch(SQLException ex){
       
      
           System.out.println("Error: " + ex.getMessage());
           
   }
   
   
   
}

}
