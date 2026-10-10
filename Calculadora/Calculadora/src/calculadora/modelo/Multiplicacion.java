package calculadora.modelo;

public class Multiplicacion implements Operacion {
    @Override
    public double ejecutar(double a, double b) {
        return a * b;
    }

    @Override
    public String getSimbolo() {
        return "*";
    }

    @Override
    public String toString() {
        return "Multiplicacion [" + getSimbolo() + "]";
    }
}
