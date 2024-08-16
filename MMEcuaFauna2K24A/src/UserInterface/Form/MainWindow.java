package UserInterface.Form;



import UserInterface.IAStyle;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class MainWindow {
    
    public static String mmcedula = "1723451747" ;
    public static String mmnombres = "Mateo Molina Moises Estrella";

    public MainWindow(String aplicación_de_Datos_de_Hormiga) {
    }

    public static void main(String[] args ) {
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
JPanel FirstPanel = new JPanel();
FirstPanel.setBackground(Color.LIGHT_GRAY);
FirstPanel.setLayout(new GridBagLayout());
FirstPanel.setPreferredSize(new Dimension(580, 75));

// Etiquetas para el número de cédula y nombres
JLabel lblCedula = new JLabel("Cédula:");
JLabel lblNombre = new JLabel("Nombres:");

// Crear JTextField no editables para mmCedula y mmNombre
JTextField tfCedula = new JTextField(mmcedula);
tfCedula.setEditable(false); // Hacer que el campo no sea editable
tfCedula.setBackground(Color.GRAY); // Poner un fondo para que parezca más uniforme
tfCedula.setBorder(BorderFactory.createEmptyBorder()); // Quitar el borde para una apariencia más limpia

JTextField tfNombre = new JTextField(mmnombres);
tfNombre.setEditable(false); // Hacer que el campo no sea editable
tfNombre.setBackground(Color.GRAY); // Poner un fondo para que parezca más uniforme
tfNombre.setBorder(BorderFactory.createEmptyBorder()); // Quitar el borde para una apariencia más limpia

// Configurar el GridBagConstraints para los componentes dentro del panel gris
GridBagConstraints gbcGray = new GridBagConstraints();
gbcGray.insets = new Insets(5, 5, 5, 5); // Espaciado dentro del panel gris
gbcGray.anchor = GridBagConstraints.WEST; // Alinear al oeste (izquierda)
gbcGray.fill = GridBagConstraints.HORIZONTAL; // Hacer que los campos de texto ocupen el espacio horizontal

// Añadir componentes al panel gris
gbcGray.gridx = 0; // Columna 0
gbcGray.gridy = 0; // Fila 0
FirstPanel.add(lblCedula, gbcGray);

gbcGray.gridx = 1; // Columna 1
gbcGray.weightx = 1.0; // Hacer que tfCedula ocupe el espacio restante
FirstPanel.add(tfCedula, gbcGray);

gbcGray.gridy = 1; // Fila 1
gbcGray.gridx = 0; // Columna 0
FirstPanel.add(lblNombre, gbcGray);

gbcGray.gridx = 1; // Columna 1
gbcGray.weightx = 1.0; // Hacer que tfNombre ocupe el espacio restante
FirstPanel.add(tfNombre, gbcGray);

// Añadir el panel gris a la ventana
gbc.gridx = 0;
gbc.gridy = 0;
gbc.weightx = 1.0;
gbc.weighty = 0.1; // Porcentaje de espacio vertical
frame.add(FirstPanel, gbc);

//---------------------------------------------------------------------------------------------------------

            // Crear el segundo panel 
            JPanel secondPanel = new JPanel();
            //secondPanel.setBackground(Color.white); 
            secondPanel.setPreferredSize(new Dimension(600, 50));

            // Usar un BorderLayout para organizar los componentes
            secondPanel.setLayout(new BorderLayout(10, 10)); // Espaciado entre los componentes

            // Crear un panel para el logo y el texto
            JPanel leftPanel = new JPanel();
            //leftPanel.setBackground(Color.WHITE);
            leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10)); // Alineación a la izquierda con espaciado

            // Cargar y redimensionar el logo
            ImageIcon logoIcon = new ImageIcon(IAStyle.URL_LOGO); // Cambia el path a tu imagen
            Image logoImage = logoIcon.getImage();
            Image resizedLogoImage = logoImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Ajustar tamaño (ancho, alto)
            ImageIcon resizedLogoIcon = new ImageIcon(resizedLogoImage);

            JLabel logoLabel = new JLabel(resizedLogoIcon);

            // Etiqueta de texto
            JLabel textLabel = new JLabel("Hormiguero virtual");
            textLabel.setForeground(Color.BLUE);

            // Añadir componentes al panel izquierdo
            leftPanel.add(logoLabel);
            leftPanel.add(textLabel);

            // Crear un panel para el botón
            JPanel rightPanel = new JPanel();
            rightPanel.setBackground(Color.white);
            rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0)); // Alineación a la derecha con espaciado

            JButton createButton = new JButton("Crear Hormiga larva");
            createButton.setBackground(Color.DARK_GRAY);
            createButton.setForeground(Color.WHITE);
            createButton.setPreferredSize(new Dimension(300, 50)); // Ajuste del tamaño del botón
            createButton.setFocusPainted(false); // Elimina el borde de enfoque del botón

            // Añadir el botón al panel derecho
            rightPanel.add(createButton);

            // Añadir los paneles al segundo panel usando BorderLayout
            secondPanel.add(leftPanel, BorderLayout.WEST);
            secondPanel.add(rightPanel, BorderLayout.EAST);

            // Añadir el segundo panel a la ventana
            gbc.gridy = 1;
            gbc.weighty = 0.1;
            frame.add(secondPanel, gbc);

//---------------------------------------------------------------------------------------------------------

// Crear el tercer panel
JPanel thirdPanel = new JPanel();
//thirdPanel.setBackground(Color.WHITE);
thirdPanel.setPreferredSize(new Dimension(580, 150));

// Configurar un GridLayout de 3 filas y 6 columnas
thirdPanel.setLayout(new GridLayout(3, 6, 5, 5)); // Espaciado entre celdas (horizontal, vertical)

// Crear y añadir los componentes de la matriz
for (int i = 0; i < 18; i++) {
    JButton cellButton = new JButton("Texto " + (i + 1));
    cellButton.setPreferredSize(new Dimension(90, 40)); // Ajustar el tamaño del botón si es necesario
    cellButton.setFocusPainted(false); // Eliminar el borde de enfoque del botón

    cellButton.setBackground(Color.GRAY);
    cellButton.setForeground(Color.WHITE);

    thirdPanel.add(cellButton);
}

// Añadir el tercer panel a la ventana
gbc.gridy = 2;
gbc.weighty = 0.1;
frame.add(thirdPanel, gbc);

//---------------------------------------------------------------------------------------
       
       // Crear el cuarto panel
       JPanel fourthPanel = new JPanel();
       fourthPanel.setPreferredSize(new Dimension(580, 150));
       fourthPanel.setLayout(new GridBagLayout());
       GridBagConstraints gbcFourth = new GridBagConstraints();
       gbcFourth.insets = new Insets(10, 5, 10, 5); // Espaciado entre los componentes
       
       // Botones en la parte izquierda
       JButton leftButton1 = new JButton("<GenoAlimento>");
       leftButton1.setBackground(Color.GRAY);
       leftButton1.setForeground(Color.WHITE);
       leftButton1.setPreferredSize(new Dimension(150, 50));
       leftButton1.setFocusPainted(false);
       
       JButton leftButton2 = new JButton("<IngestaNativa>");
       leftButton2.setBackground(Color.GRAY);
       leftButton2.setForeground(Color.WHITE);
       leftButton2.setPreferredSize(new Dimension(150, 50));
       leftButton2.setFocusPainted(false);
       
       // Crear JPopupMenu para leftButton1
       JPopupMenu popupMenu1 = new JPopupMenu();
       JMenuItem option1_1 = new JMenuItem("Opción 1.1");
       JMenuItem option1_2 = new JMenuItem("Opción 1.2");
       popupMenu1.add(option1_1);
       popupMenu1.add(option1_2);
       
       // Crear JPopupMenu para leftButton2
       JPopupMenu popupMenu2 = new JPopupMenu();
       JMenuItem option2_1 = new JMenuItem("Opción 2.1");
       JMenuItem option2_2 = new JMenuItem("Opción 2.2");
       popupMenu2.add(option2_1);
       popupMenu2.add(option2_2);
       
       // Asociar el popup menu a leftButton1 usando ActionListener
       leftButton1.addActionListener(e -> {
           popupMenu1.show(leftButton1, 0, leftButton1.getHeight());
       });
       
       // Asociar el popup menu a leftButton2 usando ActionListener
       leftButton2.addActionListener(e -> {
           popupMenu2.show(leftButton2, 0, leftButton2.getHeight());
       });
       
       // Botones en la parte derecha
       JButton createButton1 = new JButton("Alimentar Con GenoAlimento");
       createButton1.setBackground(Color.DARK_GRAY);
       createButton1.setForeground(Color.WHITE);
       createButton1.setPreferredSize(new Dimension(300, 50));
       createButton1.setFocusPainted(false);
       
       JButton createButton2 = new JButton("Alimentar Con IngestaNativa");
       createButton2.setBackground(Color.DARK_GRAY);
       createButton2.setForeground(Color.WHITE);
       createButton2.setPreferredSize(new Dimension(300, 50));
       createButton2.setFocusPainted(false);
       
       // Configurar GridBagConstraints para los botones de la izquierda
       gbcFourth.gridx = 0;
       gbcFourth.gridy = 0;
       gbcFourth.weightx = 0.5;
       gbcFourth.fill = GridBagConstraints.VERTICAL;
       gbcFourth.anchor = GridBagConstraints.WEST;
       fourthPanel.add(leftButton1, gbcFourth);
       
       gbcFourth.gridy = 1;
       fourthPanel.add(leftButton2, gbcFourth);
       
       // Configurar GridBagConstraints para los botones de la derecha
       gbcFourth.gridx = 1;
       gbcFourth.gridy = 0;
       gbcFourth.weightx = 0.5;
       gbcFourth.fill = GridBagConstraints.VERTICAL;
       gbcFourth.anchor = GridBagConstraints.EAST;
       fourthPanel.add(createButton1, gbcFourth);
       
       gbcFourth.gridy = 1;
       fourthPanel.add(createButton2, gbcFourth);
       
       // Añadir el cuarto panel a la ventana
       gbc.gridy = 3;
       gbc.weighty = 0.1;
       frame.add(fourthPanel, gbc);

//----------------------------------------------------------------------


// Crear el quinto panel
// Crear el quinto panel
        JPanel fifthPanel = new JPanel();
        fifthPanel.setBackground(Color.LIGHT_GRAY);
        fifthPanel.setPreferredSize(new Dimension(580, 75));
        fifthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Alinear en el centro, con espaciado

        // Crear un color celeste apagado
        Color lightBlue = new Color(173, 216, 230); // Light Blue color

        // Crear un borde azul más oscuro
        Border border = BorderFactory.createLineBorder(new Color(70, 130, 180), 2); // Darker Blue color, 2px width

        // Crear los botones
        JButton saveButton = new JButton("Guardar");
        saveButton.setBackground(lightBlue);
        saveButton.setForeground(Color.BLACK);
        saveButton.setPreferredSize(new Dimension(150, 50));
        saveButton.setFocusPainted(false); // Quitar borde de enfoque
        saveButton.setBorder(border); // Aplicar borde

        JButton exitButton = new JButton("Salir");
        exitButton.setBackground(lightBlue);
        exitButton.setForeground(Color.BLACK);
        exitButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setFocusPainted(false); // Quitar borde de enfoque
        exitButton.setBorder(border); // Aplicar borde

        // Añadir los botones al panel
        fifthPanel.add(saveButton);
        fifthPanel.add(exitButton);

        // Añadir el quinto panel a la ventana
        gbc.gridy = 4; // Ajusta el índice de fila según sea necesario
        gbc.weighty = 0.1;
        frame.add(fifthPanel, gbc);


            // Mostrar la ventana
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);



















            
        });
    }















    public static void createAndShowGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}