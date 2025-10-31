//18. Escreva uma classe "Conta Bancária" com métodos para depositar, sacar e verificar saldo.
public class Exercicio18 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000.0);
        
        System.out.println("Saldo inicial: " + conta.verificarSaldo());
        
        conta.depositar(500.0);
        System.out.println("Após depósito: " + conta.verificarSaldo());
        
        conta.sacar(200.0);
        System.out.println("Após saque: " + conta.verificarSaldo());
        
        conta.sacar(2000.0); // Tentativa de saque maior que o saldo
    }
}

class ContaBancaria {
    private double saldo;
    
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }
    
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }
    
    public double verificarSaldo() {
        return saldo;
    }
}
