//13. Escreva um programa que calcule a média dos valores em uma lista.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Exercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        List<Double> numeros = new ArrayList<>();
        numeros.add(10.5);
        numeros.add(15.2);
        numeros.add(8.7);
        numeros.add(22.1);
        numeros.add(12.3);
        numeros.add(18.9);
        numeros.add(5.4);
        
        
        double media = calcularMedia(numeros);
        
        
        System.out.print("Lista de números: ");
        exibirLista(numeros);
        System.out.println("Média dos valores: " + String.format("%.2f", media));
        
        
        System.out.println("\n--- Versão com Array ---");
        double[] arrayNumeros = {10.5, 15.2, 8.7, 22.1, 12.3, 18.9, 5.4};
        double mediaArray = calcularMediaArray(arrayNumeros);
        
        System.out.print("Array de números: ");
        exibirArray(arrayNumeros);
        System.out.println("Média dos valores: " + String.format("%.2f", mediaArray));
        
        scanner.close();
    }
    
    
    public static double calcularMedia(List<Double> lista) {
        if (lista.isEmpty()) {
            return 0.0;
        }
        
        double soma = 0.0;
        for (double numero : lista) {
            soma += numero;
        }
        
        return soma / lista.size();
    }
    
    
    public static double calcularMediaArray(double[] array) {
        if (array.length == 0) {
            return 0.0;
        }
        
        double soma = 0.0;
        for (double numero : array) {
            soma += numero;
        }
        
        return soma / array.length;
    }
    
    
    public static void exibirLista(List<Double> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
            if (i < lista.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    
    public static void exibirArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
