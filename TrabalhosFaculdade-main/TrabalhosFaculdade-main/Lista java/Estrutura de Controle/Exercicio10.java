import java.util.Scanner;

//10. Escreva um programa que imprima a sequência de Fibonacci com N termos, onde N é fornecido pelo usuário.
public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de termos da sequência de Fibonacci: ");
        int n = scanner.nextInt();
        
        System.out.println("Sequência de Fibonacci com " + n + " termos:");
        
        int primeiro = 0, segundo = 1;
        
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                System.out.print(i + " ");
            } else {
                int proximo = primeiro + segundo;
                System.out.print(proximo + " ");
                primeiro = segundo;
                segundo = proximo;
            }
        }
        
        scanner.close();
    }
}
