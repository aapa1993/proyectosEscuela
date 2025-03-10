/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Propietario;
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
    
    public void agregarPropietario(Propietario x) {
        try {
            conectarVeterinaria();
            Statement instruccion = conexion.createStatement();
            String query = "insert into propietario(nombre,apellidoM,apellidoP,fechaNacimiento,calle,numero,colonia,codigoPostal,referencias)"
                    + " values('"+x.nombre+"','"+x.apellidoM+"','"+x.apellidoP+"','"+x.fechaNacimiento+"','"+x.calle+"',"+x.numero+",'"+x.colonia+"','"+x.codigoPostal+"','"+x.referencias+"')";
            instruccion.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Propietario agregado con éxito");
            instruccion.close();
            cerrarVeterinaria();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());

        }
    }
}
