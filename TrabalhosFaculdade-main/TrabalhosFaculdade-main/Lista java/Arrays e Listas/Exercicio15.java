//15. Crie um programa que inverta a ordem dos elementos em um array.

import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.print("Array original: ");
        exibirArray(numeros);
        
        
        inverterArray(numeros);
        
        System.out.print("Array invertido: ");
        exibirArray(numeros);
        
        
        System.out.println("\n--- Outro exemplo ---");
        String[] palavras = {"Java", "Programação", "Arrays", "Inversão"};
        
        System.out.print("Array de strings original: ");
        exibirArrayString(palavras);
        
        inverterArrayString(palavras);
        
        System.out.print("Array de strings invertido: ");
        exibirArrayString(palavras);
        
        scanner.close();
    }
    
    
    public static void inverterArray(int[] array) {
        int inicio = 0;
        int fim = array.length - 1;
        
        while (inicio < fim) {
            
            int temp = array[inicio];
            array[inicio] = array[fim];
            array[fim] = temp;
            
            
            inicio++;
            fim--;
        }
    }
    
    
    public static void inverterArrayString(String[] array) {
        int inicio = 0;
        int fim = array.length - 1;
        
        while (inicio < fim) {
            
            String temp = array[inicio];
            array[inicio] = array[fim];
            array[fim] = temp;
            
          
            inicio++;
            fim--;
        }
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
    
   
    public static void exibirArrayString(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
