/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuadroMagico2;

import java.util.Scanner;

/**
 *
 * @author Abraham
 */
public class CuadroMagicoDos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        //Solicitar al usuario el tamaño del cuadrado mágico
        System.out.print("Ingrese el tamaño del cuadrado mágico(debe ser un número impar): ");
        int n = scanner.nextInt();
        
        if (n%2==0) {
            System.out.println("El número debe ser impar");
        }
        
        int[][] cuadrado = new int[n][n];
        
        //Inicializar matriz vacía de NxN en ceros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cuadrado[i][j] = 0;
            }
        }
        
        //Mostrar el cuadrado vacío
        System.out.println("Cuadrado mágico vació:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cuadrado[i][j]);
            }
            System.out.println("");
        }
        
        //Permitir al usuario ingresar valores en la matriz
        System.out.println("Ingrese los valores del cuadrado mágico");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Ingrese el valor ["+i+"]["+j+"]: ");
                cuadrado[i][j] = scanner.nextInt();
            }
        }
        
        //Calcular la suma esperada para cada fila, columna y diagonal
        int sumaMagica = (n *(n*n+1))/2;
        
        //Verificar si el cuadrado es mágico
        boolean esMagico = true;
        
        //Verificar filas y columnas
        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            int sumaColumna = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += cuadrado[i][j];
                sumaColumna += cuadrado[j][i];
            }
            if (sumaFila != sumaMagica || sumaColumna != sumaMagica){
                esMagico = false;
            }
        }
        
        //Verificar diagonales
        int sumaDiagonal1 = 0;        
        int sumaDiagonal2 = 0;
        
        for (int i = 0; i < n; i++) {
            sumaDiagonal1 += cuadrado[i][i];            
            sumaDiagonal2 += cuadrado[i][n-i-1];
        }
        
        if (sumaDiagonal1 != sumaMagica || sumaDiagonal2 != sumaMagica){
            esMagico = false;
        }
        
        //Mostrar resultado
        if(esMagico){
            System.out.println("¡Felicidades! El cuadrado es mágico");
        }else{
            System.out.println("El cuadrado ingresado no es mágico");

        }
    }
}
