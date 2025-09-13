import java.util.Scanner;


public class Exercicio7 {

    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
    
        System.out.println("Sua lista tem quantos valores? ");
        int n = leitor.nextInt(); // A ideia era saber quantos valores a lista tem para criar uma Array do tamanho exato, e fazer o loop terminar sozinho.
        System.out.printf("Digite os %d valores. \n", n);

        double[] valores = new double[n]; //Aqui ele recebe o TAMANHO E NAO O INDEX

        for(int i = 0; i < n ; i++) { // AQUI É INDEX
            valores[i] = leitor.nextDouble();
        }
        

        double soma = 0.0;

        for(int i = 0; i < n; i++) {
            soma += valores[i];
        }

        double media = ((soma)/(n));
        System.out.printf("A média é %.2f", media);


        leitor.close();
    }
}