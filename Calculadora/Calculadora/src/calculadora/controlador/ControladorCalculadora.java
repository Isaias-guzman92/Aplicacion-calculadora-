package calculadora.controlador;

import calculadora.modelo.Calculadora;
import calculadora.vista.VentanaCalculadora;


public class ControladorCalculadora {
    private Calculadora modelo; // limita el acceso
    private VentanaCalculadora vista;

    public void setModelo(Calculadora modelo) { // para asignar al controlador el objeto Calculadora
        this.modelo = modelo;
    }

    public void setVista(VentanaCalculadora vista) { // asigna la ventana grafica
        this.vista = vista;
    }

    private void calcular() {
        try {
            double a = Double.parseDouble(vista.getTextoA());//para obtener el objeto y lo convierte en número
            double b = Double.parseDouble(vista.getTextoB());
            double resultado = modelo.calcular(a, vista.getOperacion(), b);
            vista.setResultado(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            vista.mostrarError("Ingresa números en ambos lugares .");
        } catch (ArithmeticException | IllegalArgumentException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void iniciar() { //
        if (modelo == null || vista == null) {
            throw new IllegalStateException("Ingresa números en ambos lugares .");
        }
        vista.agregarListenerCalcular(e -> calcular());
        vista.setVisible(true);
    }

    @Override
    public String toString() {
        return "ControladorCalculadora{modelo=" + modelo + "}";
    }
}
