import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//26. Crie um programa que simule uma fila de impressão. Os usuários podem adicionar documentos para impressão,
// que são processados um por um na ordem em que foram adicionados.
public class Exercicio26 {
    public static void main(String[] args) {
        FilaImpressao fila = new FilaImpressao();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Fila de Impressão ===");
        
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Adicionar documento à fila");
            System.out.println("2. Processar próximo documento");
            System.out.println("3. Ver fila de impressão");
            System.out.println("4. Ver documentos processados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do documento: ");
                    scanner.nextLine(); // Limpa o buffer
                    String documento = scanner.nextLine();
                    fila.adicionarDocumento(documento);
                    break;
                case 2:
                    fila.processarProximo();
                    break;
                case 3:
                    fila.mostrarFila();
                    break;
                case 4:
                    fila.mostrarProcessados();
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

class FilaImpressao {
    private Queue<String> filaDocumentos;
    private Queue<String> documentosProcessados;
    
    public FilaImpressao() {
        filaDocumentos = new LinkedList<>();
        documentosProcessados = new LinkedList<>();
    }
    
    public void adicionarDocumento(String documento) {
        filaDocumentos.offer(documento);
        System.out.println("Documento '" + documento + "' adicionado à fila de impressão.");
    }
    
    public void processarProximo() {
        if (filaDocumentos.isEmpty()) {
            System.out.println("Não há documentos na fila para processar!");
            return;
        }
        
        String documento = filaDocumentos.poll();
        documentosProcessados.offer(documento);
        System.out.println("Processando documento: " + documento);
        System.out.println("Documento impresso com sucesso!");
    }
    
    public void mostrarFila() {
        if (filaDocumentos.isEmpty()) {
            System.out.println("Fila de impressão vazia!");
        } else {
            System.out.println("Fila de impressão:");
            int posicao = 1;
            for (String documento : filaDocumentos) {
                System.out.println(posicao + ". " + documento);
                posicao++;
            }
        }
    }
    
    public void mostrarProcessados() {
        if (documentosProcessados.isEmpty()) {
            System.out.println("Nenhum documento foi processado ainda!");
        } else {
            System.out.println("Documentos processados:");
            for (String documento : documentosProcessados) {
                System.out.println("- " + documento);
            }
        }
    }
}
