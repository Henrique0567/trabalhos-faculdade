//11. Crie um programa que encontre o valor máximo em um array de inteiros.

import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
    
        int[] numeros = {15, 8, 23, 4, 42, 11, 7, 19, 35, 2};
        
       
        int maximo = numeros[0]; 
        
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }
        
        
        System.out.print("Array: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Valor máximo encontrado: " + maximo);
        
        scanner.close();
    }
}
