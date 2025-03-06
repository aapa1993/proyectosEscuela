
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Abraham
 */
public class CuadroMagico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el tamaño impar del cuadro mágico (3, 5, 7, ...): ");
        int n = scanner.nextInt();
        if (n % 2 == 0) {
            System.out.println("Solo se pueden generar cuadros mágicos de tamaño impar.");
            return;
        }
        int[][] cuadroMagico = generarCuadroMagico(n);
        System.out.println("\nEl cuadro mágico generado es:");
        imprimirMatriz(cuadroMagico);
        if (verificarCuadroMagico(cuadroMagico)) {
            System.out.println("¡Es un cuadro mágico válido!");
        } else {
            System.out.println("El cuadro generado NO es un cuadro mágico válido.");
        }
    }

    public static int[][] generarCuadroMagico(int n) {
        int[][] cuadro = new int[n][n];
        int fila = 0;
        int columna = n / 2;
        int num = 1;
        while (num <= n * n) {
            cuadro[fila][columna] = num;
            num++;
            int nuevaFila = (fila - 1 + n) % n;
            int nuevaColumna = (columna + 1) % n;
            if (cuadro[nuevaFila][nuevaColumna] != 0) {
                fila = (fila + 1) % n; // Si ya está ocupado, baja una fila
            } else {
                fila = nuevaFila;
                columna = nuevaColumna;
            }
        }
        return cuadro;
    }

    public static void imprimirMatriz(int[][] matriz) {

        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    public static boolean verificarCuadroMagico(int[][] cuadro) {
        int n = cuadro.length;
        int sumaMagica = n * (n * n + 1) / 2;
        // Verificar filas y columnas
        for (int i = 0; i < n; i++) {
            int sumaFila = 0, sumaColumna = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += cuadro[i][j];
                sumaColumna += cuadro[j][i];
            }
            if (sumaFila != sumaMagica || sumaColumna != sumaMagica) {
                return false;
            }
        }
        // Verificar diagonales
        int sumaDiagonalPrincipal = 0, sumaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalPrincipal += cuadro[i][i];
            sumaDiagonalSecundaria += cuadro[i][n - i - 1];
        }
        return sumaDiagonalPrincipal == sumaMagica && sumaDiagonalSecundaria == sumaMagica;
    }
}

