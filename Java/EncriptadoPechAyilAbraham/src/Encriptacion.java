/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abraham
 */
public class Encriptacion {
        String texto2;

    public Encriptacion(String texto) {
        cambiarCaracteres(texto);
    }

    public Encriptacion() {
    }

    //Función para cambiar los caracteres
    private String cambiarCaracteres(String texto) {
        char letras[] = texto.toCharArray();
        texto2 = "";
        for (int i = 0; i < letras.length; i++) {
            switch (letras[i]) {
                case '#': letras[i] = 'A'; break;
                case '!': letras[i] = 'B'; break;
                case '"': letras[i] = 'C'; break;
                case '%': letras[i] = 'D'; break;
                case '&': letras[i] = 'E'; break;
                case '^': letras[i] = 'F'; break;
                case '(': letras[i] = 'G'; break;
                case ')': letras[i] = 'H'; break;
                case '{': letras[i] = 'I'; break;
                case '[': letras[i] = 'J'; break;
                case '}': letras[i] = 'K'; break;
                case ']': letras[i] = 'L'; break;
                case '*': letras[i] = 'M'; break;
                case '>': letras[i] = 'N'; break;
                case ',': letras[i] = 'Ñ'; break;
                case '<': letras[i] = 'O'; break;
                case '?': letras[i] = 'P'; break;
                case '-': letras[i] = 'Q'; break;
                case '¿': letras[i] = 'R'; break;
                case '=': letras[i] = 'S'; break;
                case '/': letras[i] = 'T'; break;
                case '@': letras[i] = 'U'; break;
                case 'Ä': letras[i] = 'V'; break;
                case ':': letras[i] = 'W'; break;
                case ';': letras[i] = 'X'; break;
                case '+': letras[i] = 'Y'; break;
                case '_': letras[i] = 'Z'; break;
                case '€': letras[i] = ' '; break;
                case '.': letras[i] = '0'; break;
                case '°': letras[i] = '3'; break;
                case '|': letras[i] = '4'; break;
                case '〜': letras[i] = '6'; break;
                case '¬': letras[i] = '7'; break;
                //
                case 'A': letras[i] = '#';break;
                case 'B': letras[i] = '!'; break;
                case 'C': letras[i] = '"'; break;
                case 'D': letras[i] = '%'; break;
                case 'E': letras[i] = '&'; break;
                case 'F': letras[i] = '^'; break;
                case 'G': letras[i] = '('; break;
                case 'H': letras[i] = ')'; break;
                case 'I': letras[i] = '{'; break;
                case 'J': letras[i] = '['; break;
                case 'K': letras[i] = '}'; break;
                case 'L': letras[i] = ']'; break;
                case 'M': letras[i] = '*'; break;
                case 'N': letras[i] = '>'; break;
                case 'Ñ': letras[i] = ','; break;
                case 'O': letras[i] = '<'; break;
                case 'P': letras[i] = '?'; break;
                case 'Q': letras[i] = '-'; break;
                case 'R': letras[i] = '¿'; break;
                case 'S': letras[i] = '='; break;
                case 'T': letras[i] = '/'; break;
                case 'U': letras[i] = '@'; break;
                case 'V': letras[i] = 'Ä'; break;
                case 'W': letras[i] = ':'; break;
                case 'X': letras[i] = ';'; break;
                case 'Y': letras[i] = '+'; break;
                case 'Z': letras[i] = '_'; break;
                case ' ': letras[i] = '€'; break;
                case '0': letras[i] = '.'; break;
                case '1': letras[i] = 'a'; break;
                case '2': letras[i] = 'i'; break;
                case '3': letras[i] = '°'; break;
                case '4': letras[i] = '|'; break;
                case '5': letras[i] = 'e'; break;
                case '6': letras[i] = '〜'; break;
                case '7': letras[i] = '¬'; break;
                case '8': letras[i] = 'o'; break;
                case '9': letras[i] = 'u'; break;
                case 'Á': letras[i] = 'É'; break;
                case 'É': letras[i] = 'Á'; break;
                case 'Í': letras[i] = 'Ó'; break;
                case 'Ó': letras[i] = 'Ú'; break;
                case 'Ú': letras[i] = 'z'; break;
                case 'a': letras[i] = '1'; break;
                case 'b': letras[i] = 'y'; break;
                case 'c': letras[i] = 'x'; break;
                case 'd': letras[i] = 'w'; break;
                case 'e': letras[i] = '5'; break;
                case 'f': letras[i] = 'v'; break;
                case 'g': letras[i] = 't'; break;
                case 'h': letras[i] = 's'; break;
                case 'i': letras[i] = '2'; break;
                case 'j': letras[i] = 'r'; break;
                case 'k': letras[i] = 'q'; break;
                case 'l': letras[i] = 'p'; break;
                case 'm': letras[i] = 'n'; break;
                case 'n': letras[i] = 'm'; break;
                case 'ñ': letras[i] = 'á'; break;
                case 'o': letras[i] = '8'; break;
                case 'p': letras[i] = 'l'; break;
                case 'q': letras[i] = 'k'; break;
                case 'r': letras[i] = 'j'; break;
                case 's': letras[i] = 'h'; break;
                case 't': letras[i] = 'g'; break;
                case 'u': letras[i] = '9'; break;
                case 'v': letras[i] = 'ø'; break;
                case 'w': letras[i] = 'd'; break;
                case 'x': letras[i] = 'c'; break;
                case 'y': letras[i] = 'b'; break;
                case 'z': letras[i] = 'ð'; break;
                case 'á': letras[i] = '÷'; break;
                case 'é': letras[i] = 'í'; break;
                case 'í': letras[i] = 'ß'; break;
                case 'ó': letras[i] = 'ú'; break;
                case 'ú': letras[i] = 'Æ'; break;
                case 'ü': letras[i] = 'Ö'; break;
                case 'ö': letras[i] = 'Ü'; break;
                case 'À': letras[i] = 'ù'; break;
                case 'È': letras[i] = 'ò'; break;
                case 'Ì': letras[i] = 'à'; break;
                case 'Ò': letras[i] = 'ì'; break;
                case 'Ù': letras[i] = 'è'; break;
            }
            texto2 += letras[i];
        }
        return texto2;
    }
    
//Función para invertir los caracteres
    public String invertirCaracteres(String texto) {
        char letras[] = texto.toCharArray();
        String descifrar = "";
        for (int i = 0; i < letras.length; i++) {
            switch (letras[i]) {
                case '#': letras[i] = 'A';break;
                case '!': letras[i] = 'B'; break;
                case '"': letras[i] = 'C'; break;
                case '%': letras[i] = 'D'; break;
                case '&': letras[i] = 'E'; break;
                case '^': letras[i] = 'F'; break;
                case '(': letras[i] = 'G'; break;
                case ')': letras[i] = 'H'; break;
                case '{': letras[i] = 'I'; break;
                case '[': letras[i] = 'J'; break;
                case '}': letras[i] = 'K'; break;
                case ']': letras[i] = 'L'; break;
                case '*': letras[i] = 'M'; break;
                case '>': letras[i] = 'N'; break;
                case ',': letras[i] = 'Ñ'; break;
                case '<': letras[i] = 'O'; break;
                case '?': letras[i] = 'P'; break;
                case '-': letras[i] = 'Q'; break;
                case '¿': letras[i] = 'R'; break;
                case '=': letras[i] = 'S'; break;
                case '/': letras[i] = 'T'; break;
                case '@': letras[i] = 'U'; break;
                case 'Ä': letras[i] = 'V'; break;
                case ':': letras[i] = 'W'; break;
                case ';': letras[i] = 'X'; break;
                case '+': letras[i] = 'Y'; break;
                case '_': letras[i] = 'Z'; break;
                case '€': letras[i] = ' '; break;
                case '.': letras[i] = '0'; break;
                case 'a': letras[i] = '1'; break;
                case 'i': letras[i] = '2'; break;
                case '°': letras[i] = '3'; break;
                case '|': letras[i] = '4'; break;
                case 'e': letras[i] = '5'; break;
                case '〜': letras[i] = '6'; break;
                case '¬': letras[i] = '7'; break;
                case 'o': letras[i] = '8'; break;
                case 'u': letras[i] = '9'; break;
                case 'É': letras[i] = 'Á'; break;
                case 'Á': letras[i] = 'É'; break;
                case 'Ó': letras[i] = 'Í'; break;
                case 'Ú': letras[i] = 'Ó'; break;
                case 'z': letras[i] = 'Ú'; break;
                case '1': letras[i] = 'a'; break;
                case 'y': letras[i] = 'b'; break;
                case 'x': letras[i] = 'c'; break;
                case 'w': letras[i] = 'd'; break;
                case '5': letras[i] = 'e'; break;
                case 'v': letras[i] = 'f'; break;
                case 't': letras[i] = 'g'; break;
                case 's': letras[i] = 'h'; break;
                case '2': letras[i] = 'i'; break;
                case 'r': letras[i] = 'j'; break;
                case 'q': letras[i] = 'k'; break;
                case 'p': letras[i] = 'l'; break;
                case 'n': letras[i] = 'm'; break;
                case 'm': letras[i] = 'n'; break;
                case 'á': letras[i] = 'ñ'; break;
                case '8': letras[i] = 'o'; break;
                case 'l': letras[i] = 'p'; break;
                case 'k': letras[i] = 'q'; break;
                case 'j': letras[i] = 'r'; break;
                case 'h': letras[i] = 's'; break;
                case 'g': letras[i] = 't'; break;
                case '9': letras[i] = 'u'; break;
                case 'ø': letras[i] = 'v'; break;
                case 'd': letras[i] = 'w'; break;
                case 'c': letras[i] = 'x'; break;
                case 'b': letras[i] = 'y'; break;
                case 'ð': letras[i] = 'z'; break;
                case '÷': letras[i] = 'á'; break;
                case 'í': letras[i] = 'é'; break;
                case 'ß': letras[i] = 'í'; break;
                case 'ú': letras[i] = 'ó'; break;
                case 'Æ': letras[i] = 'ú'; break;
                case 'Ö': letras[i] = 'ü'; break;
                case 'Ü': letras[i] = 'ö'; break;
                case 'ù': letras[i] = 'À'; break;
                case 'ò': letras[i] = 'È'; break;
                case 'à': letras[i] = 'Ì'; break;
                case 'ì': letras[i] = 'Ò'; break;
                case 'è': letras[i] = 'Ù'; break;
                //Otra parte
                case 'A': letras[i] = '#';break;
                case 'B': letras[i] = '!'; break;
                case 'C': letras[i] = '"'; break;
                case 'D': letras[i] = '%'; break;
                case 'E': letras[i] = '&'; break;
                case 'F': letras[i] = '^'; break;
                case 'G': letras[i] = '('; break;
                case 'H': letras[i] = ')'; break;
                case 'I': letras[i] = '{'; break;
                case 'J': letras[i] = '['; break;
                case 'K': letras[i] = '}'; break;
                case 'L': letras[i] = ']'; break;
                case 'M': letras[i] = '*'; break;
                case 'N': letras[i] = '>'; break;
                case 'Ñ': letras[i] = ','; break;
                case 'O': letras[i] = '<'; break;
                case 'P': letras[i] = '?'; break;
                case 'Q': letras[i] = '-'; break;
                case 'R': letras[i] = '¿'; break;
                case 'S': letras[i] = '='; break;
                case 'T': letras[i] = '/'; break;
                case 'U': letras[i] = '@'; break;
                case 'V': letras[i] = 'Ä'; break;
                case 'W': letras[i] = ':'; break;
                case 'X': letras[i] = ';'; break;
                case 'Y': letras[i] = '+'; break;
                case 'Z': letras[i] = '_'; break;
                case ' ': letras[i] = '€'; break;
                case '0': letras[i] = '.'; break;
                case '3': letras[i] = '°'; break;
                case '4': letras[i] = '|'; break;
                case '6': letras[i] = '〜'; break;
                case '7': letras[i] = '¬'; break;
                case 'Í': letras[i] = 'Ó'; break;
                case 'f': letras[i] = 'v'; break;
                case 'ñ': letras[i] = 'á'; break;
                case 'é': letras[i] = 'í'; break;
                case 'ó': letras[i] = 'ú'; break;
                case 'ü': letras[i] = 'Ö'; break;
                case 'ö': letras[i] = 'Ü'; break;
                case 'À': letras[i] = 'ù'; break;
                case 'È': letras[i] = 'ò'; break;
                case 'Ì': letras[i] = 'à'; break;
                case 'Ò': letras[i] = 'ì'; break;
                case 'Ù': letras[i] = 'è'; break;

            }
            descifrar += letras[i];
        }
        return descifrar;
    }
}
