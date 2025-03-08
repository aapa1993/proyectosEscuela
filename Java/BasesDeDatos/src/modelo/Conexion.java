/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Abraham
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;//Recibe 
import java.sql.Statement;//instrucción

public class Conexion {
    
    Connection conexion = null;
    
    //Abre la conexión
    private void conectarVeterinaria(){
        try {
            String url = "jdbc:mysql://localhost:3306/veterinaria";
            String usuario = "root";
            String password = "pipeaapa23usher2020";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
        }
    }
    
    //Cierra la conexión
    public void cerrarVeterinaria() throws SQLException{
        conexion.close();
    }
    
    //Recibe las consultas de las bases de datos
    public ResultSet obtenerTodoPropietario(){
        conectarVeterinaria();
        ResultSet resultado = null;
        try {
            Statement instruccion = conexion.createStatement();
            String query = "select *from propietario";
            resultado = instruccion.executeQuery(query);
        } catch (Exception e) {
        }
        return resultado;
    }
}
