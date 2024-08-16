package UserInterface.Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MMLoginPanel extends JPanel {

    public static boolean login = false;
    private JTextField tfCedula;
    private JTextField tfNombre;
    private JButton btnLogin;

    // Aquí se definen los datos de acceso válidos para la validación.
   
    public MMLoginPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel lblCedula = new JLabel("Cédula:");
        JLabel lblNombre = new JLabel("Nombres:");

        tfCedula = new JTextField();
        tfNombre = new JTextField();

        tfCedula.setPreferredSize(new Dimension(200, 30));
        tfNombre.setPreferredSize(new Dimension(200, 30));

        // Los campos de texto deben ser editables para el login.
        tfCedula.setEditable(true);
        tfNombre.setEditable(true);
        
        btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.DARK_GRAY);
        btnLogin.setForeground(Color.WHITE);
        
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 100, 5, 100);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblCedula, gbc);

        gbc.gridx = 1;
        add(tfCedula, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        add(lblNombre, gbc);

        gbc.gridx = 1;
        add(tfNombre, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        add(btnLogin, gbc);

        // Acción para el botón de login.
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        String cedula = tfCedula.getText().trim();
        String nombre = tfNombre.getText().trim();

        // Verifica si los datos ingresados son correctos
        if (MMMainWindow.VALID_CEDULA.equals(cedula) && MMMainWindow.VALID_NOMBRES.equals(nombre)) {
            JOptionPane.showMessageDialog(this, "Login exitoso. Puedes acceder al resto de la aplicación.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Cédula o nombres incorrectos. Por favor, inténtalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


