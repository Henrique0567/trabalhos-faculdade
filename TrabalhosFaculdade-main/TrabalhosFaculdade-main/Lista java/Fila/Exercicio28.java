import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//28. Crie um sistema que gerencie a fila de espera de um restaurante. Os clientes entram na fila para conseguir uma
//mesa e são chamados quando uma mesa fica disponível.
public class Exercicio28 {
    public static void main(String[] args) {
        SistemaRestaurante restaurante = new SistemaRestaurante(5); 
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Fila de Restaurante ===");
        
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Cliente entrar na fila");
            System.out.println("2. Mesa ficar disponível");
            System.out.println("3. Ver fila de espera");
            System.out.println("4. Ver mesas ocupadas");
            System.out.println("5. Ver mesas disponíveis");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    System.out.print("Digite o número de pessoas: ");
                    int pessoas = scanner.nextInt();
                    restaurante.adicionarCliente(nome, pessoas);
                    break;
                case 2:
                    System.out.print("Digite o número da mesa que ficou disponível: ");
                    int mesa = scanner.nextInt();
                    restaurante.liberarMesa(mesa);
                    break;
                case 3:
                    restaurante.mostrarFila();
                    break;
                case 4:
                    restaurante.mostrarMesasOcupadas();
                    break;
                case 5:
                    restaurante.mostrarMesasDisponiveis();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

class ClienteRestaurante {
    private String nome;
    private int numeroPessoas;
    private int senha;
    
    public ClienteRestaurante(String nome, int numeroPessoas, int senha) {
        this.nome = nome;
        this.numeroPessoas = numeroPessoas;
        this.senha = senha;
    }
    
    public String getNome() { return nome; }
    public int getNumeroPessoas() { return numeroPessoas; }
    public int getSenha() { return senha; }
    
    @Override
    public String toString() {
        return "Senha " + senha + " - " + nome + " (" + numeroPessoas + " pessoas)";
    }
}

class Mesa {
    private int numero;
    private boolean ocupada;
    private ClienteRestaurante cliente;
    
    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.cliente = null;
    }
    
    public int getNumero() { return numero; }
    public boolean isOcupada() { return ocupada; }
    public ClienteRestaurante getCliente() { return cliente; }
    
    public void ocupar(ClienteRestaurante cliente) {
        this.ocupada = true;
        this.cliente = cliente;
    }
    
    public void liberar() {
        this.ocupada = false;
        this.cliente = null;
    }
}

class SistemaRestaurante {
    private Queue<ClienteRestaurante> filaEspera;
    private Mesa[] mesas;
    private int proximaSenha;
    
    public SistemaRestaurante(int totalMesas) {
        filaEspera = new LinkedList<>();
        mesas = new Mesa[totalMesas];
        proximaSenha = 1;
        
        for (int i = 0; i < totalMesas; i++) {
            mesas[i] = new Mesa(i + 1);
        }
    }
    
    public void adicionarCliente(String nome, int numeroPessoas) {
        ClienteRestaurante cliente = new ClienteRestaurante(nome, numeroPessoas, proximaSenha++);
        filaEspera.offer(cliente);
        System.out.println("Cliente " + nome + " adicionado à fila com senha " + cliente.getSenha());
        
      
        alocarMesa();
    }
    
    public void liberarMesa(int numeroMesa) {
        if (numeroMesa < 1 || numeroMesa > mesas.length) {
            System.out.println("Número de mesa inválido!");
            return;
        }
        
        Mesa mesa = mesas[numeroMesa - 1];
        if (!mesa.isOcupada()) {
            System.out.println("Mesa " + numeroMesa + " já está disponível!");
            return;
        }
        
        System.out.println("Mesa " + numeroMesa + " liberada. Cliente " + mesa.getCliente().getNome() + " saiu.");
        mesa.liberar();
        
        // Tenta alocar mesa para próximo cliente
        alocarMesa();
    }
    
    private void alocarMesa() {
        if (filaEspera.isEmpty()) {
            return;
        }
        
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                ClienteRestaurante cliente = filaEspera.poll();
                mesa.ocupar(cliente);
                System.out.println("Cliente " + cliente.getNome() + " (senha " + cliente.getSenha() + 
                                 ") alocado na mesa " + mesa.getNumero());
                return;
            }
        }
    }
    
    public void mostrarFila() {
        if (filaEspera.isEmpty()) {
            System.out.println("Fila de espera vazia!");
        } else {
            System.out.println("Fila de espera:");
            for (ClienteRestaurante cliente : filaEspera) {
                System.out.println("- " + cliente);
            }
        }
    }
    
    public void mostrarMesasOcupadas() {
        System.out.println("Mesas ocupadas:");
        boolean temOcupadas = false;
        for (Mesa mesa : mesas) {
            if (mesa.isOcupada()) {
                System.out.println("Mesa " + mesa.getNumero() + ": " + mesa.getCliente());
                temOcupadas = true;
            }
        }
        if (!temOcupadas) {
            System.out.println("Nenhuma mesa ocupada.");
        }
    }
    
    public void mostrarMesasDisponiveis() {
        System.out.println("Mesas disponíveis:");
        boolean temDisponiveis = false;
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                System.out.println("Mesa " + mesa.getNumero() + ": Disponível");
                temDisponiveis = true;
            }
        }
        if (!temDisponiveis) {
            System.out.println("Nenhuma mesa disponível.");
        }
    }
}

