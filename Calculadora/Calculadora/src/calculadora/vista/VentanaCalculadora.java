package calculadora.vista;

import javax.swing.BorderFactory; //Crea bordes para paneles y componentes.
import javax.swing.ImageIcon; // Carga una imagen desde un archivo.
import javax.swing.JButton;   //Crea botones que el usuario puede pulsar.
import javax.swing.JComboBox; // Crea una lista desplegable.
import javax.swing.JFrame; // Crear la ventana principal.
import javax.swing.JLabel; // Muestra texto o etiquetas.
import javax.swing.JOptionPane; // Muestra cuadros de diálogo.
import javax.swing.JPanel; // Agrupa componentes en una sección.
import javax.swing.JTextField; // Permite introducir o mostrar texto en un campo.
import java.awt.BorderLayout; // Distribuye componentes en cinco zonas: norte, sur, este, oeste y centro.
import java.awt.Color; // Define colores.
import java.awt.Dimension; // Define el tamaño de un componente.
import java.awt.Font; // Define el tipo de letra.
import java.awt.FlowLayout; // Coloca los componentes uno junto a otro
import java.awt.Graphics; // Permite dibujar sobre un componente.
import java.awt.Image; // Representa una imagen.
import java.awt.event.ActionListener; // Permite ejecutar una acción cuando el usuario pulsa un botón
import java.net.URL; // Ubicación del archivo de la imagen dentro del proyecto.
import java.util.Collection; // Gurpo de elementos

public class VentanaCalculadora extends JFrame {
    private final JTextField campoA = new JTextField(8);
    private final JTextField campoB = new JTextField(8);
    private final JComboBox<String> comboOperacion;
    private final JButton botonCalcular = new JButton("Calcular");
    private final JLabel etiquetaResultado = new JLabel("Resultado: ");

    public VentanaCalculadora(Collection<String> simbolos) {
        super("Calculadora");
        comboOperacion = new JComboBox<>(simbolos.toArray(new String[0]));

        // Panel de fondo con la imagen fondo_2.png
        PanelFondo fondo = new PanelFondo("fondo_2.png");
        fondo.setLayout(new BorderLayout());
        fondo.setPreferredSize(new Dimension(500, 200));
        setContentPane(fondo);

        // Panel central transparente para que se vea la imagen detrás
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 12));
        panel.setOpaque(false);
        panel.add(campoA);
        panel.add(comboOperacion);
        panel.add(campoB);
        panel.add(botonCalcular);

        // Botón azul
        botonCalcular.setBackground(new Color(25, 118, 210));
        botonCalcular.setForeground(Color.WHITE);
        botonCalcular.setFont(new Font("Arial", Font.BOLD, 14));
        botonCalcular.setOpaque(true);
        botonCalcular.setBorderPainted(false);
        botonCalcular.setFocusPainted(false);

        // Etiqueta de resultado legible sobre la imagen
        etiquetaResultado.setForeground(Color.WHITE);
        etiquetaResultado.setFont(new Font("Arial", Font.BOLD, 28));
        etiquetaResultado.setHorizontalAlignment(JLabel.CENTER);
        etiquetaResultado.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 12));

        add(panel, BorderLayout.NORTH);
        add(etiquetaResultado, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public String getTextoA() {
        return campoA.getText().trim();
    }

    public String getTextoB() {
        return campoB.getText().trim();
    }

    public String getOperacion() {
        return (String) comboOperacion.getSelectedItem();
    }

    public void setResultado(String texto) {
        etiquetaResultado.setText("Resultado: " + texto);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void agregarListenerCalcular(ActionListener listener) {
        botonCalcular.addActionListener(listener);
    }

    @Override
    public String toString() {
        return "VentanaCalculadora{titulo=" + getTitle() + "}";
    }

    //Panel que dibuja una imagen escalada como fondo.
    private static class PanelFondo extends JPanel {
        private Image imagen;

        PanelFondo(String nombreArchivo) {
            URL url = VentanaCalculadora.class.getResource(nombreArchivo);
            if (url != null) {
                imagen = new ImageIcon(url).getImage();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}