//9. Faça um programa que conte a quantidade de vogais em uma string.

public class Exercicio9 {
    public static void main(String[] args) {
        String frase = "Exemplo de frase para contar vogais";
        int quantidadeVogais = contarVogais(frase);
        System.out.println("A quantidade de vogais na frase é: " + quantidadeVogais);
    }

    public static int contarVogais(String str) {
        int contador = 0;
        String vogais = "aeiouAEIOU";

        for (int i = 0; i < str.length(); i++) {
            char caractere = str.charAt(i);
            if (vogais.indexOf(caractere) != -1) {
                contador++;
            }
        }
        return contador;
    }
}
