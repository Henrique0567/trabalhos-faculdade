import java.util.Stack;
import java.util.Scanner;

// 25. Crie um aplicativo de lista de tarefas onde os usuários podem adicionar, remover e marcar tarefas como
// concluídas. Use uma pilha para implementar a lista.
public class Exercicio25 {
    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Lista de Tarefas ===");
        
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover última tarefa");
            System.out.println("3. Marcar última tarefa como concluída");
            System.out.println("4. Ver todas as tarefas");
            System.out.println("5. Ver tarefas pendentes");
            System.out.println("6. Ver tarefas concluídas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    scanner.nextLine(); // Limpa o buffer
                    String tarefa = scanner.nextLine();
                    lista.adicionarTarefa(tarefa);
                    break;
                case 2:
                    lista.removerUltimaTarefa();
                    break;
                case 3:
                    lista.marcarComoConcluida();
                    break;
                case 4:
                    lista.mostrarTodasTarefas();
                    break;
                case 5:
                    lista.mostrarTarefasPendentes();
                    break;
                case 6:
                    lista.mostrarTarefasConcluidas();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

class Tarefa {
    private String descricao;
    private boolean concluida;
    
    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public boolean isConcluida() {
        return concluida;
    }
    
    public void marcarConcluida() {
        this.concluida = true;
    }
    
    @Override
    public String toString() {
        return (concluida ? "[✓] " : "[ ] ") + descricao;
    }
}

class ListaTarefas {
    private Stack<Tarefa> tarefasPendentes;
    private Stack<Tarefa> tarefasConcluidas;
    
    public ListaTarefas() {
        tarefasPendentes = new Stack<>();
        tarefasConcluidas = new Stack<>();
    }
    
    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefasPendentes.push(novaTarefa);
        System.out.println("Tarefa adicionada: " + descricao);
    }
    
    public void removerUltimaTarefa() {
        if (tarefasPendentes.isEmpty()) {
            System.out.println("Não há tarefas para remover!");
            return;
        }
        
        Tarefa tarefaRemovida = tarefasPendentes.pop();
        System.out.println("Tarefa removida: " + tarefaRemovida.getDescricao());
    }
    
    public void marcarComoConcluida() {
        if (tarefasPendentes.isEmpty()) {
            System.out.println("Não há tarefas pendentes!");
            return;
        }
        
        Tarefa tarefa = tarefasPendentes.pop();
        tarefa.marcarConcluida();
        tarefasConcluidas.push(tarefa);
        System.out.println("Tarefa concluída: " + tarefa.getDescricao());
    }
    
    public void mostrarTodasTarefas() {
        System.out.println("\n=== TODAS AS TAREFAS ===");
        System.out.println("Pendentes:");
        for (Tarefa tarefa : tarefasPendentes) {
            System.out.println("  " + tarefa);
        }
        System.out.println("Concluídas:");
        for (Tarefa tarefa : tarefasConcluidas) {
            System.out.println("  " + tarefa);
        }
    }
    
    public void mostrarTarefasPendentes() {
        System.out.println("\n=== TAREFAS PENDENTES ===");
        if (tarefasPendentes.isEmpty()) {
            System.out.println("Nenhuma tarefa pendente!");
        } else {
            for (Tarefa tarefa : tarefasPendentes) {
                System.out.println("  " + tarefa);
            }
        }
    }
    
    public void mostrarTarefasConcluidas() {
        System.out.println("\n=== TAREFAS CONCLUÍDAS ===");
        if (tarefasConcluidas.isEmpty()) {
            System.out.println("Nenhuma tarefa concluída!");
        } else {
            for (Tarefa tarefa : tarefasConcluidas) {
                System.out.println("  " + tarefa);
            }
        }
    }
}
