import java.util.Stack;
import java.util.Scanner;

// 24. Desenvolva um programa que simule um sistema de reserva de assentos em um teatro. Use uma pilha para
// controlar os assentos disponíveis.
public class Exercicio24 {
    public static void main(String[] args) {
        SistemaReservaTeatro teatro = new SistemaReservaTeatro(10);
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Reserva de Teatro ===");
        
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Reservar assento");
            System.out.println("2. Cancelar última reserva");
            System.out.println("3. Ver assentos disponíveis");
            System.out.println("4. Ver assentos ocupados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    scanner.nextLine(); // Limpa o buffer
                    String nome = scanner.nextLine();
                    teatro.reservarAssento(nome);
                    break;
                case 2:
                    teatro.cancelarUltimaReserva();
                    break;
                case 3:
                    teatro.mostrarAssentosDisponiveis();
                    break;
                case 4:
                    teatro.mostrarAssentosOcupados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

class SistemaReservaTeatro {
    private Stack<Integer> assentosDisponiveis;
    private Stack<String> reservas;
    private boolean[] assentosOcupados;
    private int totalAssentos;
    
    public SistemaReservaTeatro(int totalAssentos) {
        this.totalAssentos = totalAssentos;
        this.assentosOcupados = new boolean[totalAssentos];
        this.assentosDisponiveis = new Stack<>();
        this.reservas = new Stack<>();
        
        // Inicializa todos os assentos como disponíveis
        for (int i = totalAssentos - 1; i >= 0; i--) {
            assentosDisponiveis.push(i);
        }
    }
    
    public void reservarAssento(String nome) {
        if (assentosDisponiveis.isEmpty()) {
            System.out.println("Não há assentos disponíveis!");
            return;
        }
        
        int assento = assentosDisponiveis.pop();
        assentosOcupados[assento] = true;
        reservas.push(nome + " - Assento " + (assento + 1));
        
        System.out.println("Reserva realizada! " + nome + " - Assento " + (assento + 1));
    }
    
    public void cancelarUltimaReserva() {
        if (reservas.isEmpty()) {
            System.out.println("Não há reservas para cancelar!");
            return;
        }
        
        String ultimaReserva = reservas.pop();
        // Extrai o número do assento da string
        String[] partes = ultimaReserva.split(" - Assento ");
        int numeroAssento = Integer.parseInt(partes[1]) - 1;
        
        assentosOcupados[numeroAssento] = false;
        assentosDisponiveis.push(numeroAssento);
        
        System.out.println("Reserva cancelada: " + ultimaReserva);
    }
    
    public void mostrarAssentosDisponiveis() {
        System.out.println("Assentos disponíveis: " + assentosDisponiveis.size());
        System.out.print("Números: ");
        for (int i = 0; i < totalAssentos; i++) {
            if (!assentosOcupados[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
    
    public void mostrarAssentosOcupados() {
        System.out.println("Reservas realizadas:");
        for (String reserva : reservas) {
            System.out.println("- " + reserva);
        }
    }
}
