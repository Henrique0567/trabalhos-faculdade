//Numeros primos são naturais, maiores que 1, que possui apenas dois divisores, 1 e o próprio numero.

import java.util.Scanner;

public class Exercicio8 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Quantas centenas analizar? ");
        int centenas = leitor.nextInt();

        centenas *= 100; // Multiplicando centenas por 100;


        for(int i = 2; i < centenas; i++) {
            Boolean ehPrimo = true; // Demorei pra entender que precisava disso pra validar se era primo ou nao, e mais ainda para saber que ele deve ficar dentro do for
            if(i > 1){
                for(int j = 2; j < i; j++) {
                    if(((i%j) == 0)){ // verifica se é primo, se for divisivel ele fica false pra primo e para de testar já
                        ehPrimo = false;
                        break;
                    }
                }
            }
            if (ehPrimo == true) {
                        System.out.println("Encontramos um primo! " + i);
                    }
        }





        leitor.close();
    }
}
