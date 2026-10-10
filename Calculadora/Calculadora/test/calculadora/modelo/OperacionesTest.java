package calculadora.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperacionesTest {
    @Test
    void cadaOperacionTieneSuSimbolo() {
        assertEquals("+", new Suma().getSimbolo());
        assertEquals("-", new Resta().getSimbolo());
        assertEquals("*", new Multiplicacion().getSimbolo());
        assertEquals("/", new Division().getSimbolo());
    }

    @Test
    void polimorfismoViaInterfaz() {
        Operacion op = new Multiplicacion();
        assertEquals(12.0, op.ejecutar(3, 4), 1e-9);
    }

    @Test
    void divisionDecimal() {
        assertEquals(0.5, new Division().ejecutar(1, 2), 1e-9);
    }

    @Test
    void divisionEntreCeroDirecta() {
        assertThrows(ArithmeticException.class, () -> new Division().ejecutar(1, 0));
    }

    @Test
    void toStringDeSuma() {
        assertEquals("Suma [+]", new Suma().toString());
    }
}
