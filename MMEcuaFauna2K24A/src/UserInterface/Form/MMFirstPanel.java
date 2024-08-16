package UserInterface.Form;

import java.awt.*;
import javax.swing.*;

public class MMFirstPanel extends JPanel {

    public MMFirstPanel() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(580, 75));

        String mmcedula = "1723451747";
        String mmnombres = "Mateo Molina Moises Estrella";

        JLabel lblCedula = new JLabel("Cédula:");
        JLabel lblNombre = new JLabel("Nombres:");

        JTextField tfCedula = new JTextField(mmcedula);
        tfCedula.setEditable(false);
        tfCedula.setBackground(Color.GRAY);
        tfCedula.setBorder(BorderFactory.createEmptyBorder());

        JTextField tfNombre = new JTextField(mmnombres);
        tfNombre.setEditable(false);
        tfNombre.setBackground(Color.GRAY);
        tfNombre.setBorder(BorderFactory.createEmptyBorder());

        GridBagConstraints gbcGray = new GridBagConstraints();
        gbcGray.insets = new Insets(5, 5, 5, 5);
        gbcGray.anchor = GridBagConstraints.WEST;
        gbcGray.fill = GridBagConstraints.HORIZONTAL;

        gbcGray.gridx = 0;
        gbcGray.gridy = 0;
        add(lblCedula, gbcGray);

        gbcGray.gridx = 1;
        gbcGray.weightx = 1.0;
        add(tfCedula, gbcGray);

        gbcGray.gridy = 1;
        gbcGray.gridx = 0;
        add(lblNombre, gbcGray);

        gbcGray.gridx = 1;
        gbcGray.weightx = 1.0;
        add(tfNombre, gbcGray);
    }
}
