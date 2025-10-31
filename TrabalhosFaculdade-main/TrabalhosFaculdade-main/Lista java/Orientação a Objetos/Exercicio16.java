//16. Implemente uma classe "Pessoa" com atributos como nome, idade e método para exibir os dados.
public class Exercicio16 {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João", 25);
        Pessoa pessoa2 = new Pessoa("Maria", 30);
        
        pessoa1.exibirDados();
        pessoa2.exibirDados();
    }
}

class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public void exibirDados() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}
