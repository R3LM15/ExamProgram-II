package UserInterface.Form;

import java.awt.*;
import javax.swing.*;

public class MMMainWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MMEcuaFauna2K24A");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 800);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 30, 10, 30);

            // Crear y añadir los paneles
            JPanel MMfirstPanel = new MMFirstPanel();
            JPanel MMregistro = new MMRegisto();

            gbc.gridy = 0;
            gbc.weighty = 0.1;
            frame.add(MMfirstPanel, gbc);

            gbc.gridy = 1;
            gbc.weighty = 0.3;
            frame.add(MMregistro, gbc);

            // Configurar la ventana
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
