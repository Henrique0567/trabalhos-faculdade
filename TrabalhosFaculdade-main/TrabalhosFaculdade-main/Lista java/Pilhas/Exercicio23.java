import java.util.Stack;

// 23. Escreva uma função que transforma uma expressão da forma in-fixa para a forma pós-fixa
public class Exercicio23 {
    public static void main(String[] args) {
        String expressao = "a+b*c-d";
        System.out.println("Expressão in-fixa: " + expressao);
        System.out.println("Expressão pós-fixa: " + infixaParaPosfixa(expressao));
        
        String expressao2 = "(a+b)*c";
        System.out.println("\nExpressão in-fixa: " + expressao2);
        System.out.println("Expressão pós-fixa: " + infixaParaPosfixa(expressao2));
    }
    
    public static String infixaParaPosfixa(String expressao) {
        Stack<Character> pilha = new Stack<>();
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                resultado.append(c);
            } else if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    resultado.append(pilha.pop());
                }
                pilha.pop(); // Remove o '('
            } else if (ehOperador(c)) {
                while (!pilha.isEmpty() && precedencia(pilha.peek()) >= precedencia(c)) {
                    resultado.append(pilha.pop());
                }
                pilha.push(c);
            }
        }
        
        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop());
        }
        
        return resultado.toString();
    }
    
    private static boolean ehOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
