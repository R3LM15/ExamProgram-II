package UserInterface.Form;



import UserInterface.IAStyle;
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
            FirstPanel.setPreferredSize(new Dimension(580,75));

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
            Image resizedLogoImage = logoImage.getScaledInstance(50, 45, Image.SCALE_SMOOTH); // Ajustar tamaño (ancho, alto)
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
            createButton.setPreferredSize(new Dimension(350, 50)); // Ajuste del tamaño del botón
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
    fourthPanel.setBackground(Color.WHITE);
    fourthPanel.setPreferredSize(new Dimension(580, 150));


    JButton button1 = new JButton("Botón 1");

    JButton createButton1 = new JButton("Crear Hormiga larva");
    createButton1.setBackground(Color.DARK_GRAY);
    createButton1.setForeground(Color.WHITE);
    createButton1.setPreferredSize(new Dimension(350, 50)); // Ajuste del tamaño del botón
    createButton1.setFocusPainted(false); // Elimina el borde de enfoque del botón


    fourthPanel.add(button1);




    gbc.gridy = 3;
    gbc.weighty = 0.1;
    frame.add(fourthPanel, gbc);



/* 
// Configurar un GridLayout de 2 filas y 2 columnas
fourthPanel.setLayout(new GridLayout(2, 2, 10, 10)); // Espaciado entre botones

// Crear botones
JButton button1 = new JButton("Botón 1");
JButton button2 = new JButton("Botón 2");

// Botones desplegables (de derecha)
JButton dropDownButton1 = new JButton("Botón 3");
JButton dropDownButton2 = new JButton("Botón 4");

// Configurar el menú desplegable para el primer botón
JPopupMenu dropDownMenu1 = new JPopupMenu();
JMenuItem option1 = new JMenuItem("Opción 1");
JMenuItem option2 = new JMenuItem("Opción 2");
dropDownMenu1.add(option1);
dropDownMenu1.add(option2);
dropDownButton1.addActionListener(e -> dropDownMenu1.show(dropDownButton1, 0, dropDownButton1.getHeight()));

// Configurar el menú desplegable para el segundo botón
JPopupMenu dropDownMenu2 = new JPopupMenu();
JMenuItem option3 = new JMenuItem("Opción 3");
JMenuItem option4 = new JMenuItem("Opción 4");
dropDownMenu2.add(option3);
dropDownMenu2.add(option4);
dropDownButton2.addActionListener(e -> dropDownMenu2.show(dropDownButton2, 0, dropDownButton2.getHeight()));

// Añadir botones al panel
fourthPanel.add(button1);
fourthPanel.add(button2);
fourthPanel.add(dropDownButton1);
fourthPanel.add(dropDownButton2);

// Añadir el cuarto panel a la ventana
gbc.gridy = 3;
gbc.weighty = 0.1;
frame.add(fourthPanel, gbc);

*/



















            // Mostrar la ventana
            frame.pack();
            frame.setVisible(true);



















            
        });
    }















    public static void createAndShowGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}