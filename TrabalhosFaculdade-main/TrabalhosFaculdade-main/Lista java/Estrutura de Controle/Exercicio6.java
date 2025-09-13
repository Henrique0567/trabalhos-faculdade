import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);

        System.out.println("Iniciar Loop? ");
        String bool_1 = leitor.nextLine();

        if (bool_1.equals("sim")) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("Loop não iniciado.");
        }

        leitor.close();
    }
}