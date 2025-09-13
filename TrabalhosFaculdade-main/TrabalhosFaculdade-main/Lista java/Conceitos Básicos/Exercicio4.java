import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        
        double pi = 3.14;

        Scanner leitor = new Scanner(System.in);

        System.out.println("Me diga o raio do seu círculo: ");
        
        double raio_1 = leitor.nextInt();
        double calculo_area = (pi) * (Math.pow(raio_1, 2)); // Math.pow(base, expoente); eu utilizei neste caso dentro da variavel pois eu nao preciso guardar isso.

        System.out.println("A área do seu círculo é: " + calculo_area);

        leitor.close();
    }
}