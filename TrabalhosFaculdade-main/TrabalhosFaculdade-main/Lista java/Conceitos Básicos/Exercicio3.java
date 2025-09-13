import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um valor para saber se é par ou impar:");
        int valor_1 = leitor.nextInt();

        float verificador = ((valor_1) % 2);

        if (verificador == 0){
            System.out.println("O valor é par.");
        } else {
            System.out.println("O valor é ímpar.");
        }

        


        leitor.close();
    }
}