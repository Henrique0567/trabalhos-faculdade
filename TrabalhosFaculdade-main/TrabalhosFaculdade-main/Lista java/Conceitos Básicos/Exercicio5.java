import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Qual seu nome? ");
        String nome = leitor.nextLine();

        System.out.println("Saudações "+ nome);


        leitor.close();
    }
}