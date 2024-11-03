/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Diego
 */
public class Presidente {
    
    private int cod, equipopresi;
    private String dpi, nombre1, nombre2,nombre3,apellido1, apellido2,fechana, correo,ciudad,eleccion;
    conexion cn;
    
    public Presidente(){}

    public Presidente(int cod, int equipopresi, String dpi, String nombre1, String nombre2, String nombre3, String apellido1, String apellido2, String fechana, String correo, String ciudad, String eleccion) {
        this.cod = cod;
        this.equipopresi = equipopresi;
        this.dpi = dpi;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.nombre3 = nombre3;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechana = fechana;
        this.correo = correo;
        this.ciudad = ciudad;
        this.eleccion = eleccion;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getEquipopresi() {
        return equipopresi;
    }

    public void setEquipopresi(int equipopresi) {
        this.equipopresi = equipopresi;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
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

    public String getFechana() {
        return fechana;
    }

    public void setFechana(String fechana) {
        this.fechana = fechana;
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

    public String getEleccion() {
        return eleccion;
    }

    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }

    
    
    
    
    public LinkedHashMap<String, String> drop_presi() {
        LinkedHashMap<String, String> droposicion = new LinkedHashMap<>();
        try {
            cn = new conexion();
            String query = "SELECT codigo_equipo as id, nombre_equipo FROM equipo;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);

            while (consulta.next()) {
                droposicion.put(consulta.getString("id"), consulta.getString("nombre_equipo"));
            }
            cn.cerrar_conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return droposicion;
    }
    
    
    
    
    
    public DefaultTableModel leer() {
    DefaultTableModel tabla = new DefaultTableModel();

    try {
        cn = new conexion();
        cn.abrir_conexion();
        
       String query = "SELECT p.id_presidente AS id_presi, p.dpi, p.nombre1, p.nombre2, p.nombre3, p.apellido1, p.apellido2, p.fecha_nacimiento, p.correo_electronico, p.ciudad_residencia, p.anio_eleccion, e.codigo_equipo, e.nombre_equipo AS equipo FROM presidente AS p INNER JOIN equipo AS e ON p.codigo_equipo = e.codigo_equipo;";
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);

        String encabezado[] = {"id_presi", "dpi", "nombre1", "nombre2", "nombre3", "apellido1", "apellido2", "fecha_nacimiento", "correo_electronico", "ciudad_residencia", "anio_eleccion", "codigo_equipo", "equipo"};
        tabla.setColumnIdentifiers(encabezado);

        String datos[] = new String[13];
        
        while (consulta.next()) {
            datos[0] = consulta.getString("id_presi");
            datos[1] = consulta.getString("dpi");
            datos[2] = consulta.getString("nombre1");
            datos[3] = consulta.getString("nombre2");
            datos[4] = consulta.getString("nombre3");
            datos[5] = consulta.getString("apellido1");
            datos[6] = consulta.getString("apellido2");
            datos[7] = consulta.getString("fecha_nacimiento");
            datos[8] = consulta.getString("correo_electronico");
            datos[9] = consulta.getString("ciudad_residencia");
            datos[10] = consulta.getString("anio_eleccion");
            datos[11] = consulta.getString("codigo_equipo");
            datos[12] = consulta.getString("equipo");
            tabla.addRow(datos);
        }

        cn.cerrar_conexion();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return tabla;
}

    
    
    public boolean verificarDPI(String dpi) {
    boolean existe = false;
    try {
        cn = new conexion();
        String query = "SELECT COUNT(*) AS total FROM presidente WHERE dpi = ?;";
        cn.abrir_conexion();
        PreparedStatement parametro = cn.conexionBD.prepareStatement(query);
        parametro.setString(1, dpi);
        ResultSet consulta = parametro.executeQuery();

        if (consulta.next()) {
            existe = consulta.getInt("total") > 0;
        }
        cn.cerrar_conexion();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return existe;
}

    
    
    
    public int agregar() {
    int retorno = 0;
    
    if (verificarDPI(getDpi())) {
        System.out.println("Error: El DPI ingresado ya existe y no se puede duplicar.");
        return retorno; 
    }
    try {
        PreparedStatement parametro;
        cn = new conexion();
        String query = "INSERT INTO presidente(dpi, nombre1, nombre2, nombre3, apellido1, apellido2, fecha_nacimiento, correo_electronico, ciudad_residencia, anio_eleccion, codigo_equipo) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        
        parametro.setString(1, getDpi()); 
        parametro.setString(2, getNombre1()); 
        parametro.setString(3, getNombre2());
        parametro.setString(4, getNombre3()); 
        parametro.setString(5, getApellido1()); 
        parametro.setString(6, getApellido2()); 
        parametro.setString(7, getFechana()); 
        parametro.setString(8, getCorreo()); 
        parametro.setString(9, getCiudad()); 
        parametro.setString(10,getEleccion()); 
        parametro.setInt(11, getEquipopresi());

        retorno = parametro.executeUpdate(); 

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        retorno = 0; 
        cn.cerrar_conexion(); 
    }
    return retorno; 
}

    
   
    

public int modificar() {
    int retorno = 0;
    try {
        PreparedStatement parametro;
        cn = new conexion();
       String query = "UPDATE presidente SET dpi=?, nombre1=?, nombre2=?, nombre3=?, apellido1=?, apellido2=?, fecha_nacimiento=?, correo_electronico=?, ciudad_residencia=?, anio_eleccion=?, codigo_equipo=? WHERE id_presidente=?";
        
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        
        // Establecer parámetros de la consulta
        parametro.setString(1, getDpi());
        parametro.setString(2, getNombre1());
        parametro.setString(3, getNombre2());
        parametro.setString(4, getNombre3());
        parametro.setString(5, getApellido1());
        parametro.setString(6, getApellido2());
        parametro.setString(7, getFechana());
        parametro.setString(8, getCorreo());
        parametro.setString(9, getCiudad());
        parametro.setString(10, getEleccion());
        parametro.setInt(11, getEquipopresi());
        parametro.setInt(12, this.getCod()); 

        // Ejecutar la actualización y obtener el número de filas afectadas
        retorno = parametro.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        retorno = 0; // Se mantiene retorno en 0 si hay un error
    } finally {
        cn.cerrar_conexion(); // Cierra la conexión independientemente de si hubo error o no
    return retorno; // Devuelve el número de filas afectadas o 0 si hubo un error
}
    
}



   
   public int eliminar() {
    int retorno = 0;
    try {
        PreparedStatement parametro;
        cn = new conexion();
        String query = "DELETE FROM presidente WHERE id_presidente = ? "; 
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        
        parametro.setInt(1, this.getCod()); 
        retorno = parametro.executeUpdate(); 

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        retorno = 0;
    } finally {
        cn.cerrar_conexion(); 
    }
    return retorno; 
}


    
}
