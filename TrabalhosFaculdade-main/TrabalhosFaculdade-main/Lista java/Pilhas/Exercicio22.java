import java.util.Stack;
import java.util.Scanner;

//22. Crie um simulador simples de histórico de navegação de um navegador web. Use uma pilha para armazenar as
// URLs visitadas, implementando a funcionalidade de avançar e voltar nas páginas visitadas.
public class Exercicio22 {
    public static void main(String[] args) {
        NavegadorWeb navegador = new NavegadorWeb();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Simulador de Navegador Web ===");
        
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Visitar nova página");
            System.out.println("2. Voltar");
            System.out.println("3. Avançar");
            System.out.println("4. Ver histórico");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL: ");
                    scanner.nextLine(); // Limpa o buffer
                    String url = scanner.nextLine();
                    navegador.visitarPagina(url);
                    break;
                case 2:
                    navegador.voltar();
                    break;
                case 3:
                    navegador.avancar();
                    break;
                case 4:
                    navegador.mostrarHistorico();
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

class NavegadorWeb {
    private Stack<String> historico;
    private Stack<String> futuro;
    private String paginaAtual;
    
    public NavegadorWeb() {
        historico = new Stack<>();
        futuro = new Stack<>();
        paginaAtual = null;
    }
    
    public void visitarPagina(String url) {
        if (paginaAtual != null) {
            historico.push(paginaAtual);
        }
        paginaAtual = url;
        futuro.clear(); // Limpa o histórico futuro
        System.out.println("Visitando: " + url);
    }
    
    public void voltar() {
        if (historico.isEmpty()) {
            System.out.println("Não há páginas anteriores!");
            return;
        }
        
        if (paginaAtual != null) {
            futuro.push(paginaAtual);
        }
        paginaAtual = historico.pop();
        System.out.println("Voltando para: " + paginaAtual);
    }
    
    public void avancar() {
        if (futuro.isEmpty()) {
            System.out.println("Não há páginas futuras!");
            return;
        }
        
        if (paginaAtual != null) {
            historico.push(paginaAtual);
        }
        paginaAtual = futuro.pop();
        System.out.println("Avançando para: " + paginaAtual);
    }
    
    public void mostrarHistorico() {
        System.out.println("Página atual: " + (paginaAtual != null ? paginaAtual : "Nenhuma"));
        System.out.println("Histórico: " + historico);
        System.out.println("Futuro: " + futuro);
    }
}
