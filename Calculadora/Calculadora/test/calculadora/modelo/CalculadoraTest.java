package calculadora.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void sumaDosNumeros() {
        assertEquals(9.0, calculadora.sumar(6, 3), 1e-9);
    }

    @Test
    void sumaConNegativos() {
        assertEquals(-2.0, calculadora.sumar(1, -3), 1e-9);
    }

    @Test
    void restaDosNumeros() {
        assertEquals(-2.0, calculadora.restar(2, 4), 1e-9);
    }

    @Test
    void multiplicaDosNumeros() {
        assertEquals(6.0, calculadora.multiplicar(2, 3), 1e-9);
    }

    @Test
    void multiplicaPorCero() {
        assertEquals(0.0, calculadora.multiplicar(9, 0), 1e-9);
    }

    @Test
    void divideDosNumeros() {
        assertEquals(2.5, calculadora.dividir(5, 2), 1e-9);
    }

    @Test
    void divisionEntreCeroLanzaExcepcion() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> calculadora.dividir(5, 0));
        assertEquals("No se puede dividir entre cero", ex.getMessage());
    }

    @Test
    void calcularConSimboloValido() {
        assertEquals(9.0, calculadora.calcular(4, "+", 5), 1e-9);
    }

    @Test
    void calcularConSimboloInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcular(1, "%", 2));
    }

    @Test
    void exponeLasCuatroOperaciones() {
        assertEquals(4, calculadora.getSimbolos().size());
    }

    @Test
    void toStringListaLosSimbolos() {
        assertTrue(calculadora.toString().contains("+"));
    }
}
