//14. Escreva um programa que receba um array de números inteiros e imprima os elementos sem repetição.

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        int[] numeros = {1, 2, 3, 2, 4, 1, 5, 3, 6, 2, 7, 1, 8, 4, 9};
        
        System.out.print("Array original: ");
        exibirArray(numeros);
        
        System.out.print("Elementos únicos (usando HashSet): ");
        exibirElementosUnicosHashSet(numeros);
        
        System.out.print("Elementos únicos (usando algoritmo próprio): ");
        exibirElementosUnicos(numeros);
        
        scanner.close();
    }
    
    
    public static void exibirElementosUnicosHashSet(int[] array) {
        Set<Integer> elementosUnicos = new HashSet<>();
        
        
        for (int numero : array) {
            elementosUnicos.add(numero);
        }
        
        
        for (int elemento : elementosUnicos) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
    
    
    public static void exibirElementosUnicos(int[] array) {
        List<Integer> elementosUnicos = new ArrayList<>();
        
        for (int numero : array) {
            
            if (!elementosUnicos.contains(numero)) {
                elementosUnicos.add(numero);
            }
        }
        
        
        for (int i = 0; i < elementosUnicos.size(); i++) {
            System.out.print(elementosUnicos.get(i));
            if (i < elementosUnicos.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
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
