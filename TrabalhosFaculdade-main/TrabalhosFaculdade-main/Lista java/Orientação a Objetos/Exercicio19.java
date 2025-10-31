//19. Faça uma classe "Livro" com atributos como título, autor e método para exibir informações.
public class Exercicio19 {
    public static void main(String[] args) {
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien");
        Livro livro2 = new Livro("Harry Potter", "J.K. Rowling");
        
        livro1.exibirInformacoes();
        livro2.exibirInformacoes();
    }
}

class Livro {
    private String titulo;
    private String autor;
    
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("---");
    }
}
