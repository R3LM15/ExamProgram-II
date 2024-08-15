package UserInterface.Form;



import java.awt.*;
import javax.swing.*;


public class MainWindow {
    
    public static String mmcedula = "1723451747" ;
    public static String mmnombres = "Mateo Molina Moises Estrella";

    public MainWindow(String aplicación_de_Datos_de_Hormiga) {
    }

    public static void main(String[] args) {
        // Ejecutar en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crear la ventana principal
            JFrame frame = new JFrame("Ventana con Menú Seccionado");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 800); // Tamaño de la ventana
            frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
            frame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 30, 10, 30); // Espaciado entre los paneles y los márgenes de la ventana
            

            //---------------------------------------------------------------------------------------------------------
            // Crear el Primer panel 
            JPanel FirstPanel = new JPanel();
            FirstPanel.setBackground(Color.LIGHT_GRAY);
            FirstPanel.setLayout(new GridBagLayout());
            FirstPanel.setPreferredSize(new Dimension(580, 100));



          
            // Etiquetas para el número de cédula y nombres
            JLabel lblCedula = new JLabel("Cédula:");
            JLabel lblNombre = new JLabel("Nombres:");
            JLabel mmCedula = new JLabel(mmcedula);
            JLabel mmNombre = new JLabel(mmnombres);


            
            // Configurar el GridBagConstraints para los componentes dentro del panel gris
            GridBagConstraints gbcGray = new GridBagConstraints();
            gbcGray.insets = new Insets(5, 100, 5, 100); // Espaciado dentro del panel gris
            gbcGray.anchor = GridBagConstraints.WEST;

            FirstPanel.add(lblCedula, gbcGray);
            FirstPanel.add(mmCedula, gbcGray);
            gbcGray.gridy = 1;
            FirstPanel.add(lblNombre, gbcGray);
            FirstPanel.add(mmNombre, gbcGray);

            // Añadir el panel gris a la ventana
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 0.1; // Porcentaje de espacio vertical
            frame.add(FirstPanel, gbc);




            //---------------------------------------------------------------------------------------------------------

            // Crear el segundo panel (vacío por ahora)
            JPanel secondPanel = new JPanel();
            secondPanel.setBackground(Color.WHITE);
            secondPanel.setPreferredSize(new Dimension(600, 150));


           

            secondPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 60, 10)); // Usar FlowLayout para alinear elementos

            // Cargar el logo
            ImageIcon logoIcon = new ImageIcon("Logo.png"); // Cambia el path a tu imagen
            JLabel logoLabel = new JLabel(logoIcon);

            // Crear el texto y el botón
            JLabel textLabel = new JLabel("Hormiguero virtual");
            textLabel.setForeground(Color.blue);


            JButton createButton = new JButton("Crear Hormiga larva");
            createButton.setBackground(Color.DARK_GRAY);
            createButton.setForeground(Color.WHITE);
            createButton.setPreferredSize(new Dimension(300, 40));
            createButton.setFocusPainted(false); // Elimina el borde de enfoque del botón

            // Añadir componentes al segundo panel
            secondPanel.add(logoLabel);
            secondPanel.add(textLabel);
            secondPanel.add(createButton);






            // Añadir el segundo panel a la ventana
            gbc.gridy = 1;
            gbc.weighty = 0.1;
            frame.add(secondPanel, gbc);



             //---------------------------------------------------------------------------------------------------------

            // Crear el tercer panel (vacío por ahora)
            JPanel thirdPanel = new JPanel();
            thirdPanel.setBackground(Color.WHITE);
            thirdPanel.setPreferredSize(new Dimension(580, 150));

            // Añadir el tercer panel a la ventana
            gbc.gridy = 2;
            gbc.weighty = 0.1;
            frame.add(thirdPanel, gbc);

            // Crear el cuarto panel (vacío por ahora)
            JPanel fourthPanel = new JPanel();
            fourthPanel.setBackground(Color.WHITE);
            fourthPanel.setPreferredSize(new Dimension(580, 150));

            // Añadir el cuarto panel a la ventana
            gbc.gridy = 3;
            gbc.weighty = 0.1;
            frame.add(fourthPanel, gbc);

            // Mostrar la ventana
            frame.pack();
            frame.setVisible(true);
        });
    }

    public static void createAndShowGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}