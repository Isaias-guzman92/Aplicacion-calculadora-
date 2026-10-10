package calculadora;

import calculadora.controlador.ControladorCalculadora;
import calculadora.modelo.Calculadora;
import calculadora.vista.VentanaCalculadora;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora modelo = new Calculadora();
            VentanaCalculadora vista = new VentanaCalculadora(modelo.getSimbolos());

            ControladorCalculadora controlador = new ControladorCalculadora();
            controlador.setModelo(modelo);
            controlador.setVista(vista);
            controlador.iniciar();
        });
    }
}
