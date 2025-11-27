import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//27. Elabore um programa que simule uma fila de atendimento em um banco ou em um serviço de suporte. Os
// clientes podem entrar na fila e são atendidos em ordem.
public class Exercicio27 {
    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Fila de Atendimento Bancário ===");
        
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Cliente entrar na fila");
            System.out.println("2. Atender próximo cliente");
            System.out.println("3. Ver fila de espera");
            System.out.println("4. Ver clientes atendidos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    scanner.nextLine(); // Limpa o buffer
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    fila.adicionarCliente(nome, cpf);
                    break;
                case 2:
                    fila.atenderProximo();
                    break;
                case 3:
                    fila.mostrarFila();
                    break;
                case 4:
                    fila.mostrarAtendidos();
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

class Cliente {
    private String nome;
    private String cpf;
    private int senha;
    
    public Cliente(String nome, String cpf, int senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public int getSenha() { return senha; }
    
    @Override
    public String toString() {
        return "Senha " + senha + " - " + nome + " (CPF: " + cpf + ")";
    }
}

class FilaAtendimento {
    private Queue<Cliente> filaClientes;
    private Queue<Cliente> clientesAtendidos;
    private int proximaSenha;
    
    public FilaAtendimento() {
        filaClientes = new LinkedList<>();
        clientesAtendidos = new LinkedList<>();
        proximaSenha = 1;
    }
    
    public void adicionarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf, proximaSenha++);
        filaClientes.offer(cliente);
        System.out.println("Cliente " + nome + " adicionado à fila com senha " + cliente.getSenha());
    }
    
    public void atenderProximo() {
        if (filaClientes.isEmpty()) {
            System.out.println("Não há clientes na fila para atender!");
            return;
        }
        
        Cliente cliente = filaClientes.poll();
        clientesAtendidos.offer(cliente);
        System.out.println("Atendendo: " + cliente);
        System.out.println("Cliente atendido com sucesso!");
    }
    
    public void mostrarFila() {
        if (filaClientes.isEmpty()) {
            System.out.println("Fila de atendimento vazia!");
        } else {
            System.out.println("Fila de atendimento:");
            for (Cliente cliente : filaClientes) {
                System.out.println("- " + cliente);
            }
        }
    }
    
    public void mostrarAtendidos() {
        if (clientesAtendidos.isEmpty()) {
            System.out.println("Nenhum cliente foi atendido ainda!");
        } else {
            System.out.println("Clientes atendidos:");
            for (Cliente cliente : clientesAtendidos) {
                System.out.println("- " + cliente);
            }
        }
    }
}
