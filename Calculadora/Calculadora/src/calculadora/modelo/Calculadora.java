package calculadora.modelo;

import java.util.LinkedHashMap; // para almacenar datos
import java.util.Map; // permete trabajar con pares de clave y valor
import java.util.Set;

public class Calculadora {
    private  Map<String, Operacion> operaciones = new LinkedHashMap<>();

    public Calculadora() {
        registrar(new Suma());
        registrar(new Resta());
        registrar(new Multiplicacion());
        registrar(new Division());
    }

    private void registrar(Operacion operacion) { // para incorporar las operaciones
        operaciones.put(operacion.getSimbolo(), operacion);
    }

    public Set<String> getSimbolos() { // para devuelve los símbolos
        return operaciones.keySet();
    }

    public double calcular(double a, String simbolo, double b) {
        Operacion operacion = operaciones.get(simbolo);
        if (operacion == null) {
            throw new IllegalArgumentException("Operación no detectada: " + simbolo);
        }
        return operacion.ejecutar(a, b);
    }

    public double sumar(double a, double b) {
        return calcular(a, "+", b);
    }

    public double restar(double a, double b) {
        return calcular(a, "-", b);
    }

    public double multiplicar(double a, double b) {
        return calcular(a, "*", b);
    }

    public double dividir(double a, double b) {
        return calcular(a, "/", b);
    }

    @Override
    public String toString() {
        return "Calculadora{operaciones=" + operaciones.keySet() + "}";
    }
}
