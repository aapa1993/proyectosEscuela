/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abraham
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conectar {
    public static void main(String []args){
        try{
            String url = "jdbc:mysql://127.0.0.1:3306/escuela";//Dirección del servidor, puerto que lo escucha y nombre de la base de datos
            String usuario = "root";//usuario que se conecta
            String password = "pipeaapa23usher2020";//contraseña del usuario que se conecta
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,password);
            System.out.println("Conectado");
            
            Statement instruccion = conexion.createStatement();
            String query = "select *from alumno";
            ResultSet resultado = instruccion.executeQuery(query);
            
            while(resultado.next()){
                String nombre = resultado.getString("nombre");
                System.out.println("Nombre: " + nombre);
            }
            
            resultado.close();
            instruccion.close();
            conexion.close();
            System.out.println("\nDesconectado");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
