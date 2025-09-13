import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in); // Para criar classe: NomeDaClasse NomeDaVariavel = new NomeClasse(FonteDosDados)

        System.out.println("Digite dois valores para serem somados: ");
        int valor_1 = leitor.nextInt();
        int valor_2 = leitor.nextInt();

        System.out.println((valor_1) + (valor_2));




        leitor.close();
    }
}