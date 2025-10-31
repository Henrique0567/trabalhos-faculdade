//17. Crie uma classe "Círculo" com métodos para calcular área e circunferência.
public class Exercicio17 {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5.0);
        
        System.out.println("Raio: " + circulo.getRaio());
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Circunferência: " + circulo.calcularCircunferencia());
    }
}

class Circulo {
    private double raio;
    
    public Circulo(double raio) {
        this.raio = raio;
    }
    
    public double getRaio() {
        return raio;
    }
    
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
    
    public double calcularCircunferencia() {
        return 2 * Math.PI * raio;
    }
}
