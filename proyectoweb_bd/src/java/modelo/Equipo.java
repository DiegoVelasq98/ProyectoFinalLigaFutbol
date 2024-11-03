/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Diego
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.sql.*; 

public class Equipo {
    
    private int cod_equipo;
    private String nom_equipo, nom_estadio,aforo,fundacion,ciudad;
   
    conexion cn;

    public Equipo(){}

    //Constructor declarando las variables, aplicando POO
    public Equipo(int cod_equipo,String nom_equipo, String nom_estadio, String aforo, String fundacion, String ciudad) {
       this.cod_equipo = cod_equipo;
        this.nom_equipo = nom_equipo;
        this.nom_estadio = nom_estadio;
        this.aforo = aforo;
        this.fundacion = fundacion;
        this.ciudad = ciudad;
    }

    public int getCod_equipo() {
        return cod_equipo;
    }

    public void setCod_equipo(int cod_equipo) {
        this.cod_equipo = cod_equipo;
    }


    public String getNom_equipo() {
        return nom_equipo;
    }

    public void setNom_equipo(String nom_equipo) {
        this.nom_equipo = nom_equipo;
    }

    public String getNom_estadio() {
        return nom_estadio;
    }

    public void setNom_estadio(String nom_estadio) {
        this.nom_estadio = nom_estadio;
    }

    public String getAforo() {
        return aforo;
    }

    public void setAforo(String aforo) {
        this.aforo = aforo;
    }

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    
    //Metodo que permite leer los datos de la tabla por medio de un TableModel
    public DefaultTableModel leer() {

        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new conexion();
            cn.abrir_conexion();

            String query = "SELECT e.codigo_equipo,e.nombre_equipo,e.nombre_estadio,e.aforo,e.anio_fundacion,e.ciudad FROM equipo as e;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"codigo_equipo", "nombre_equipo", "nombre_estadio", "aforo", "anio_fundacion", "ciudad"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[6];
            while (consulta.next()) {
                datos[0] = consulta.getString("codigo_equipo");
                datos[1] = consulta.getString("nombre_equipo");
                datos[2] = consulta.getString("nombre_estadio");
                datos[3] = consulta.getString("aforo");
                datos[4] = consulta.getString("anio_fundacion");
                datos[5] = consulta.getString("ciudad");


                tabla.addRow(datos);

            }
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tabla;

    }
   
    //Metodo de agregar, lo cual permite insertar datos a la tabla por medio de la query de Insert
    public int agregar() {

     int retorno = 0;
        try {
            PreparedStatement parametro;
            cn = new conexion();
            String query = "INSERT INTO equipo(nombre_equipo, nombre_estadio, aforo, anio_fundacion, ciudad) VALUES (?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNom_equipo());
            parametro.setString(2, getNom_estadio());
            parametro.setString(3, getAforo());
            parametro.setString(4, getFundacion());
            parametro.setString(5, getCiudad());

            parametro.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                        cn.cerrar_conexion();

           retorno = 0;
        }
         return retorno;
    
}


    
        //Metodo de modificar, lo cual permite insertar datos a la tabla por medio de la query de UPDATE

    public int modificar() {

        int retorno = 0;
        try {
            PreparedStatement parametro;
            cn = new conexion();
            String query = "UPDATE equipo SET nombre_equipo=?, nombre_estadio=?, aforo=?, anio_fundacion=?, ciudad=? WHERE codigo_equipo=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNom_equipo());
            parametro.setString(2, getNom_estadio());
            parametro.setString(3, getAforo());
            parametro.setString(4, getFundacion());
            parametro.setString(5, getCiudad());
            parametro.setInt(6, getCod_equipo());

            

            parametro.executeUpdate();
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;

    }
    
        //Metodo de eliminar, lo cual permite insertar datos a la tabla por medio de la query de DELETE

    public int eliminar() {
       
        int retorno = 0;
        try {
            PreparedStatement parametro;
            cn = new conexion();
            String query = "delete from equipo WHERE codigo_equipo=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getCod_equipo());

            

            parametro.executeUpdate();
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }



    
}
