import java.util.Stack;

//  21. Escreva um programa que utilize uma pilha para inverter os caracteres de uma string. A ideia é empilhar os
// caracteres da string original e, em seguida, desempilhá-los para formar a string invertida.
public class Exercicio21 {
    public static void main(String[] args) {
        String texto = "Hello World";
        System.out.println("Texto original: " + texto);
        System.out.println("Texto invertido: " + inverterString(texto));
    }
    
    public static String inverterString(String texto) {
        Stack<Character> pilha = new Stack<>();
        
        // Empilha cada caractere
        for (int i = 0; i < texto.length(); i++) {
            pilha.push(texto.charAt(i));
        }
        
        // Desempilha para formar a string invertida
        StringBuilder resultado = new StringBuilder();
        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop());
        }
        
        return resultado.toString();
    }
}
