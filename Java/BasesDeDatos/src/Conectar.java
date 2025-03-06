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
import java.sql.ResultSetMetaData;

public class Conectar {
    public static void main(String []args){
        try{
            String url = "jdbc:mysql://localhost:3306/veterinaria";//Dirección del servidor, puerto que lo escucha y nombre de la base de datos
            String usuario = "root";//usuario que se conecta
            String password = "pipeaapa23usher2020";//contraseña del usuario que se conecta
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,usuario,password);
            System.out.println("Conectado");
            
            Statement instruccion = conexion.createStatement();
            String query = "select *from propietario";
            ResultSet resultado = instruccion.executeQuery(query);
            
            ResultSetMetaData metaData = resultado.getMetaData();
            int numCol = metaData.getColumnCount();
            
            System.out.println("\nTablas:");
            while(resultado.next()){
                for (int i = 1; i <= numCol; i++) {
                    String nombreColumna = metaData.getColumnName(i);
                    String valor = resultado.getString(i);
                    System.out.print(nombreColumna + ": " + valor + " | ");
                }
                System.out.println();
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
