package calculadora.modelo;

public class Division implements Operacion {
    @Override
    public double ejecutar(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;
    }

    @Override
    public String getSimbolo() {
        return "/";
    }

    @Override
    public String toString() {
        return "Division [" + getSimbolo() + "]";
    }
}
