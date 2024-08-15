package UserInterface.Form;

import javax.swing.*;
import java.awt.*;

public class GrayPanel extends JPanel {
    public GrayPanel(String mmCedula, String mmNombre) {
        // Configurar el panel gris
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridBagLayout());

        // Crear las etiquetas
        JLabel lblCedula = new JLabel("Cédula:");
        JLabel lblNombre = new JLabel("Nombres:");

        JLabel lblCedulaValue = new JLabel(mmCedula);
        JLabel lblNombreValue = new JLabel(mmNombre);

        // Configurar GridBagConstraints
        GridBagConstraints gbcGray = new GridBagConstraints();
        gbcGray.insets = new Insets(5, 100, 5, 100); // Espaciado dentro del panel gris
        gbcGray.anchor = GridBagConstraints.WEST;

        // Añadir componentes al panel gris
        gbcGray.gridx = 0;
        gbcGray.gridy = 0;
        add(lblCedula, gbcGray);

        gbcGray.gridx = 1;
        add(lblCedulaValue, gbcGray);

        gbcGray.gridx = 0;
        gbcGray.gridy = 1;
        add(lblNombre, gbcGray);

        gbcGray.gridx = 1;
        add(lblNombreValue, gbcGray);
    }
}
