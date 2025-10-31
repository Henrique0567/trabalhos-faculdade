//20. Implemente uma classe "Carro" com atributos para marca, modelo e métodos para acelerar e frear.
public class Exercicio20 {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla");
        
        System.out.println("Carro: " + carro.getMarca() + " " + carro.getModelo());
        System.out.println("Velocidade inicial: " + carro.getVelocidade() + " km/h");
        
        carro.acelerar(50);
        carro.acelerar(30);
        
        carro.frear(20);
        carro.frear(100); // Tentativa de frear mais que a velocidade atual
    }
}

class Carro {
    private String marca;
    private String modelo;
    private int velocidade;
    
    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = 0;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getVelocidade() {
        return velocidade;
    }
    
    public void acelerar(int incremento) {
        velocidade += incremento;
        System.out.println("Acelerando! Velocidade atual: " + velocidade + " km/h");
    }
    
    public void frear(int decremento) {
        if (velocidade >= decremento) {
            velocidade -= decremento;
            System.out.println("Freando! Velocidade atual: " + velocidade + " km/h");
        } else {
            velocidade = 0;
            System.out.println("Carro parado! Velocidade: " + velocidade + " km/h");
        }
    }
}
