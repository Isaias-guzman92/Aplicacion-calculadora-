package calculadora.modelo;

public interface Operacion {
    double ejecutar(double a, double b);

    String getSimbolo();
}
