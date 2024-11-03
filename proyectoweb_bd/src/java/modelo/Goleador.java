/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedHashMap;

public class Goleador {

    private int codigoGoleador, codigoJugador, totalGoles;
    conexion cn;

    public Goleador() {}

    public Goleador(int codigoGoleador, int codigoJugador, int totalGoles) {
        this.codigoGoleador = codigoGoleador;
        this.codigoJugador = codigoJugador;
        this.totalGoles = totalGoles;
    }

    public int getCodigoGoleador() {
        return codigoGoleador;
    }

    public void setCodigoGoleador(int codigoGoleador) {
        this.codigoGoleador = codigoGoleador;
    }

    public int getCodigoJugador() {
        return codigoJugador;
    }

    public void setCodigoJugador(int codigoJugador) {
        this.codigoJugador = codigoJugador;
    }

    public int getTotalGoles() {
        return totalGoles;
    }

    public void setTotalGoles(int totalGoles) {
        this.totalGoles = totalGoles;
    }

    // Método para leer los datos de la tabla goleador
    public DefaultTableModel leer() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new conexion();
            cn.abrir_conexion();
            String query = "SELECT g.codigo_goleador, g.codigo_jugador, g.total_goles, j.nombre AS nombre_jugador " +
                           "FROM goleador AS g INNER JOIN jugador AS j ON g.codigo_jugador = j.codigo_jugador;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"codigo_goleador", "codigo_jugador", "total_goles", "nombre_jugador"};
            tabla.setColumnIdentifiers(encabezado);

            String datos[] = new String[4];
            while (consulta.next()) {
                datos[0] = consulta.getString("codigo_goleador");
                datos[1] = consulta.getString("codigo_jugador");
                datos[2] = consulta.getString("total_goles");
                datos[3] = consulta.getString("nombre_jugador");
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
            cn = new conexion();
            String query = "INSERT INTO goleador (codigo_jugador, total_goles) VALUES (?, ?);";
            cn.abrir_conexion();
            PreparedStatement parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getCodigoJugador());
            parametro.setInt(2, getTotalGoles());
            retorno = parametro.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = 0;
        } finally {
            cn.cerrar_conexion();
        }
        return retorno;
    }

    
    
    public int modificar() {
        int retorno = 0;
        try {
            cn = new conexion();
            String query = "UPDATE goleador SET codigo_jugador = ?, total_goles = ? WHERE codigo_goleador = ?;";
            cn.abrir_conexion();
            PreparedStatement parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getCodigoJugador());
            parametro.setInt(2, getTotalGoles());
            parametro.setInt(3, getCodigoGoleador());
            retorno = parametro.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = 0;
        } finally {
            cn.cerrar_conexion();
        }
        return retorno;
    }

    public int eliminar() {
        int retorno = 0;
        try {
            cn = new conexion();
            String query = "DELETE FROM goleador WHERE codigo_goleador = ?;";
            cn.abrir_conexion();
            PreparedStatement parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getCodigoGoleador());
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
