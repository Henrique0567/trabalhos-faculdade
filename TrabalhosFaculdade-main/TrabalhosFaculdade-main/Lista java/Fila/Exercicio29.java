import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 29. Elabore um sistema de suporte técnico onde as chamadas dos clientes são enfileiradas. Implemente prioridades
// para algumas chamadas e processe-as de acordo.
public class Exercicio29 {
    public static void main(String[] args) {
        SistemaSuporteTecnico suporte = new SistemaSuporteTecnico();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Suporte Técnico ===");
        
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Registrar chamada");
            System.out.println("2. Atender próxima chamada");
            System.out.println("3. Ver fila de chamadas");
            System.out.println("4. Ver chamadas atendidas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    scanner.nextLine(); // Limpa o buffer
                    String nome = scanner.nextLine();
                    System.out.print("Digite o problema: ");
                    String problema = scanner.nextLine();
                    System.out.println("Prioridades:");
                    System.out.println("1. Baixa");
                    System.out.println("2. Normal");
                    System.out.println("3. Alta");
                    System.out.println("4. Crítica");
                    System.out.print("Escolha a prioridade: ");
                    int prioridade = scanner.nextInt();
                    suporte.registrarChamada(nome, problema, prioridade);
                    break;
                case 2:
                    suporte.atenderProximaChamada();
                    break;
                case 3:
                    suporte.mostrarFila();
                    break;
                case 4:
                    suporte.mostrarAtendidas();
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

class ChamadaSuporte implements Comparable<ChamadaSuporte> {
    private String nomeCliente;
    private String problema;
    private int prioridade;
    private int numeroChamada;
    
    public ChamadaSuporte(String nomeCliente, String problema, int prioridade, int numeroChamada) {
        this.nomeCliente = nomeCliente;
        this.problema = problema;
        this.prioridade = prioridade;
        this.numeroChamada = numeroChamada;
    }
    
    public String getNomeCliente() { return nomeCliente; }
    public String getProblema() { return problema; }
    public int getPrioridade() { return prioridade; }
    public int getNumeroChamada() { return numeroChamada; }
    
    public String getPrioridadeTexto() {
        switch (prioridade) {
            case 1: return "Baixa";
            case 2: return "Normal";
            case 3: return "Alta";
            case 4: return "Crítica";
            default: return "Desconhecida";
        }
    }
    
    @Override
    public int compareTo(ChamadaSuporte outra) {
        // Prioridade maior (4) vem primeiro que prioridade menor (1)
        return Integer.compare(outra.prioridade, this.prioridade);
    }
    
    @Override
    public String toString() {
        return "Chamada #" + numeroChamada + " - " + nomeCliente + 
               " (" + getPrioridadeTexto() + "): " + problema;
    }
}

class SistemaSuporteTecnico {
    private Queue<ChamadaSuporte> filaChamadas;
    private Queue<ChamadaSuporte> chamadasAtendidas;
    private int proximoNumero;
    
    public SistemaSuporteTecnico() {
        filaChamadas = new PriorityQueue<>();
        chamadasAtendidas = new PriorityQueue<>();
        proximoNumero = 1;
    }
    
    public void registrarChamada(String nome, String problema, int prioridade) {
        if (prioridade < 1 || prioridade > 4) {
            System.out.println("Prioridade inválida! Use 1-4.");
            return;
        }
        
        ChamadaSuporte chamada = new ChamadaSuporte(nome, problema, prioridade, proximoNumero++);
        filaChamadas.offer(chamada);
        System.out.println("Chamada registrada: " + chamada);
    }
    
    public void atenderProximaChamada() {
        if (filaChamadas.isEmpty()) {
            System.out.println("Não há chamadas na fila para atender!");
            return;
        }
        
        ChamadaSuporte chamada = filaChamadas.poll();
        chamadasAtendidas.offer(chamada);
        System.out.println("Atendendo: " + chamada);
        System.out.println("Chamada atendida com sucesso!");
    }
    
    public void mostrarFila() {
        if (filaChamadas.isEmpty()) {
            System.out.println("Fila de chamadas vazia!");
        } else {
            System.out.println("Fila de chamadas (ordenada por prioridade):");
            for (ChamadaSuporte chamada : filaChamadas) {
                System.out.println("- " + chamada);
            }
        }
    }
    
    public void mostrarAtendidas() {
        if (chamadasAtendidas.isEmpty()) {
            System.out.println("Nenhuma chamada foi atendida ainda!");
        } else {
            System.out.println("Chamadas atendidas:");
            for (ChamadaSuporte chamada : chamadasAtendidas) {
                System.out.println("- " + chamada);
            }
        }
    }
}
