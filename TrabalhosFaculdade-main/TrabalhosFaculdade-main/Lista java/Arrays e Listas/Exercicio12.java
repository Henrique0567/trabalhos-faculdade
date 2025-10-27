//12. Implemente um programa que verifique se um array está ordenado de forma crescente.

import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int[] arrayOrdenado = {1, 3, 5, 7, 9, 11, 13, 15};
        
        
        int[] arrayNaoOrdenado = {5, 2, 8, 1, 9, 3, 7, 4};
        
        
        System.out.print("Array 1: ");
        exibirArray(arrayOrdenado);
        if (verificarOrdenacao(arrayOrdenado)) {
            System.out.println("O array está ordenado de forma crescente.");
        } else {
            System.out.println("O array NÃO está ordenado de forma crescente.");
        }
        
        System.out.println();
        
        
        System.out.print("Array 2: ");
        exibirArray(arrayNaoOrdenado);
        if (verificarOrdenacao(arrayNaoOrdenado)) {
            System.out.println("O array está ordenado de forma crescente.");
        } else {
            System.out.println("O array NÃO está ordenado de forma crescente.");
        }
        
        scanner.close();
    }
    
    
    public static boolean verificarOrdenacao(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false; 
            }
        }
        return true; 
    }
    
    
    public static void exibirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
