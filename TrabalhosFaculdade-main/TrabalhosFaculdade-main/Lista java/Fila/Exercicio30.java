import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 30. Desenvolva um sistema de gerenciamento de fila em um parque de diversões com diferentes tipos de ingressos
// (ex: VIP, padrão). Implemente diferentes filas para diferentes prioridades.
public class Exercicio30 {
    public static void main(String[] args) {
        SistemaParqueDiversoes parque = new SistemaParqueDiversoes();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Gerenciamento de Fila - Parque de Diversões ===");
        
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Pessoa entrar na fila");
            System.out.println("2. Atender próxima pessoa");
            System.out.println("3. Ver filas");
            System.out.println("4. Ver pessoas atendidas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da pessoa: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    System.out.println("Tipos de ingresso:");
                    System.out.println("1. Padrão");
                    System.out.println("2. VIP");
                    System.out.println("3. Premium");
                    System.out.print("Escolha o tipo de ingresso: ");
                    int tipo = scanner.nextInt();
                    parque.adicionarPessoa(nome, tipo);
                    break;
                case 2:
                    parque.atenderProximaPessoa();
                    break;
                case 3:
                    parque.mostrarFilas();
                    break;
                case 4:
                    parque.mostrarAtendidas();
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

class PessoaParque {
    private String nome;
    private int tipoIngresso;
    private int senha;
    
    public PessoaParque(String nome, int tipoIngresso, int senha) {
        this.nome = nome;
        this.tipoIngresso = tipoIngresso;
        this.senha = senha;
    }
    
    public String getNome() { return nome; }
    public int getTipoIngresso() { return tipoIngresso; }
    public int getSenha() { return senha; }
    
    public String getTipoIngressoTexto() {
        switch (tipoIngresso) {
            case 1: return "Padrão";
            case 2: return "VIP";
            case 3: return "Premium";
            default: return "Desconhecido";
        }
    }
    
    @Override
    public String toString() {
        return "Senha " + senha + " - " + nome + " (" + getTipoIngressoTexto() + ")";
    }
}

class SistemaParqueDiversoes {
    private Queue<PessoaParque> filaPremium;
    private Queue<PessoaParque> filaVIP;
    private Queue<PessoaParque> filaPadrao;
    private Queue<PessoaParque> pessoasAtendidas;
    private int proximaSenha;
    
    public SistemaParqueDiversoes() {
        filaPremium = new LinkedList<>();
        filaVIP = new LinkedList<>();
        filaPadrao = new LinkedList<>();
        pessoasAtendidas = new LinkedList<>();
        proximaSenha = 1;
    }
    
    public void adicionarPessoa(String nome, int tipoIngresso) {
        if (tipoIngresso < 1 || tipoIngresso > 3) {
            System.out.println("Tipo de ingresso inválido! Use 1-3.");
            return;
        }
        
        PessoaParque pessoa = new PessoaParque(nome, tipoIngresso, proximaSenha++);
        
        switch (tipoIngresso) {
            case 1:
                filaPadrao.offer(pessoa);
                break;
            case 2:
                filaVIP.offer(pessoa);
                break;
            case 3:
                filaPremium.offer(pessoa);
                break;
        }
        
        System.out.println("Pessoa " + nome + " adicionada à fila " + pessoa.getTipoIngressoTexto() + 
                         " com senha " + pessoa.getSenha());
    }
    
    public void atenderProximaPessoa() {
        PessoaParque pessoa = null;
        String tipoFila = "";
        
 
        if (!filaPremium.isEmpty()) {
            pessoa = filaPremium.poll();
            tipoFila = "Premium";
        } else if (!filaVIP.isEmpty()) {
            pessoa = filaVIP.poll();
            tipoFila = "VIP";
        } else if (!filaPadrao.isEmpty()) {
            pessoa = filaPadrao.poll();
            tipoFila = "Padrão";
        }
        
        if (pessoa == null) {
            System.out.println("Não há pessoas nas filas para atender!");
            return;
        }
        
        pessoasAtendidas.offer(pessoa);
        System.out.println("Atendendo: " + pessoa + " (Fila " + tipoFila + ")");
        System.out.println("Pessoa atendida com sucesso!");
    }
    
    public void mostrarFilas() {
        System.out.println("\n=== FILAS DO PARQUE ===");
        
        System.out.println("Fila Premium:");
        if (filaPremium.isEmpty()) {
            System.out.println("  Vazia");
        } else {
            for (PessoaParque pessoa : filaPremium) {
                System.out.println("  - " + pessoa);
            }
        }
        
        System.out.println("Fila VIP:");
        if (filaVIP.isEmpty()) {
            System.out.println("  Vazia");
        } else {
            for (PessoaParque pessoa : filaVIP) {
                System.out.println("  - " + pessoa);
            }
        }
        
        System.out.println("Fila Padrão:");
        if (filaPadrao.isEmpty()) {
            System.out.println("  Vazia");
        } else {
            for (PessoaParque pessoa : filaPadrao) {
                System.out.println("  - " + pessoa);
            }
        }
    }
    
    public void mostrarAtendidas() {
        if (pessoasAtendidas.isEmpty()) {
            System.out.println("Nenhuma pessoa foi atendida ainda!");
        } else {
            System.out.println("Pessoas atendidas:");
            for (PessoaParque pessoa : pessoasAtendidas) {
                System.out.println("- " + pessoa);
            }
        }
    }
}
