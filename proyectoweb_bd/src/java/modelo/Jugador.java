/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Diego
 */
    
import java.util.LinkedHashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
public class Jugador {
    
    
    private int cod_jugador, equipo, posicion;
    private String nombre1, nombre2,nombre3,apellido1, apellido2, correo,ciudad,fechana;
    private conexion cn;
    
    public Jugador(){}

    public Jugador(int cod_jugador, int equipo, int posicion, String nombre1, String nombre2, String nombre3, String apellido1, String apellido2, String correo, String ciudad, String fechana) {
        this.cod_jugador = cod_jugador;
        this.equipo = equipo;
        this.posicion = posicion;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.nombre3 = nombre3;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.ciudad = ciudad;
        this.fechana = fechana;
    }

    public int getCod_jugador() {
        return cod_jugador;
    }

    public void setCod_jugador(int cod_jugador) {
        this.cod_jugador = cod_jugador;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechana() {
        return fechana;
    }

    public void setFechana(String fechana) {
        this.fechana = fechana;
    }
    



    public LinkedHashMap<String, String> drop_posicion() {
        LinkedHashMap<String, String> droposicion = new LinkedHashMap<>();
        try {
            cn = new conexion();
            String query = "SELECT codigo_posicion as codigo, nombre_posicion FROM posicion;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);

            while (consulta.next()) {
                droposicion.put(consulta.getString("codigo"), consulta.getString("nombre_posicion"));
            }
            cn.cerrar_conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return droposicion;
    }

    public LinkedHashMap<String, String> drop_equipo() {
        LinkedHashMap<String, String> dropequipo = new LinkedHashMap<>();
        try {
            cn = new conexion();
            String query = "SELECT codigo_equipo as codigo, nombre_equipo FROM equipo;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);

            while (consulta.next()) {
                dropequipo.put(consulta.getString("codigo"), consulta.getString("nombre_equipo"));
            }
            cn.cerrar_conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dropequipo;
    }


    
    
    
    
    
    
    
    public DefaultTableModel leer() {

        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new conexion();
            cn.abrir_conexion();
            
         String query = "SELECT j.codigo_jugador AS id, j.nombre1, j.nombre2, j.nombre3, j.apellido1, j.apellido2, j.correo_electronico, j.ciudad_residencia, j.fecha_nacimiento, p.nombre_posicion AS posicion, e.nombre_equipo AS equipo FROM jugador AS j INNER JOIN posicion AS p ON j.codigo_posicion = p.codigo_posicion INNER JOIN equipo AS e ON j.codigo_equipo = e.codigo_equipo;";
ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
String encabezado[] = {"id", "nombre1", "nombre2", "nombre3", "apellido1", "apellido2", "correo_electronico", "ciudad_residencia", "fecha_nacimiento", "posicion", "equipo"};
tabla.setColumnIdentifiers(encabezado);
String datos[] = new String[11];  
 
while (consulta.next()) {

    datos[0] = consulta.getString("id"); // j.codigo_jugador
    datos[1] = consulta.getString("nombre1"); // j.nombre1
    datos[2] = consulta.getString("nombre2"); // j.nombre2
    datos[3] = consulta.getString("nombre3"); // j.nombre3
    datos[4] = consulta.getString("apellido1"); // j.apellido1
    datos[5] = consulta.getString("apellido2"); // j.apellido2
    datos[6] = consulta.getString("correo_electronico"); // j.correo_electronico
    datos[7] = consulta.getString("ciudad_residencia"); // j.ciudad_residencia
    datos[8] = consulta.getString("fecha_nacimiento"); // j.fecha_nacimiento
    datos[9] = consulta.getString("posicion"); // p.nombre_posicion
    datos[10] = consulta.getString("equipo"); // e.nombre_equipo 



              
                tabla.addRow(datos);

            }
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tabla;

    }
    
    
    
    
    public int agregar() {

     int retorno = 0;
        try {
            PreparedStatement parametro;
            cn = new conexion();
            String query = "INSERT INTO jugador(nombre1,nombre2,nombre3,apellido1,apellido2,correo_electronico,ciudad_residencia,fecha_nacimiento,codigo_posicion,codigo_equipo) VALUES(?,?,?,?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNombre1());
            parametro.setString(2, getNombre2());
            parametro.setString(3, getNombre3());
            parametro.setString(4, getApellido1());
            parametro.setString(5, getApellido2());
            parametro.setString(6, getCorreo());
            parametro.setString(7, getCiudad());
            parametro.setString(8, getFechana());
            parametro.setInt(9, getPosicion());
            parametro.setInt(10, getEquipo());

            

            parametro.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                        cn.cerrar_conexion();

           retorno = 0;
        }
         return retorno;
    }
         
         public int modificar() {

     int retorno = 0;
        try {
            PreparedStatement parametro;
            cn = new conexion();
            String query = "UPDATE jugador SET nombre1=?, nombre2=?, nombre3=?, apellido1=?, apellido2=?, correo_electronico=?, ciudad_residencia=?, fecha_nacimiento=?, codigo_posicion=?, codigo_equipo=? WHERE codigo_jugador=?";
        
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        
        parametro.setString(1, getNombre1());
        parametro.setString(2, getNombre2());
        parametro.setString(3, getNombre3());
        parametro.setString(4, getApellido1());
        parametro.setString(5, getApellido2());
        parametro.setString(6, getCorreo());
        parametro.setString(7, getCiudad());
        parametro.setString(8, getFechana());
        parametro.setInt(9, getPosicion());
        parametro.setInt(10, getEquipo());
        parametro.setInt(11, getCod_jugador());

            parametro.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                        cn.cerrar_conexion();

           retorno = 0;
        }
         return retorno;
         
    
}


    

         
         
         public int eliminar() {

     int retorno = 0;
        try {
            PreparedStatement parametro;
            cn = new conexion();
            String query = "DELETE FROM jugador WHERE codigo_jugador = ?";
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
          
            parametro.setInt(1, this.getCod_jugador());
           

            

            parametro.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                        cn.cerrar_conexion();

           retorno = 0;
        }
         return retorno;
    
    
}
         
}
