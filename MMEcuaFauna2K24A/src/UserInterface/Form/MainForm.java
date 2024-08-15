package UserInterface.Form;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import UserInterface.CustomerControl.PatLabelText;
//import UserInterface.CustomerControl.PatTextBox;


public class MainForm extends JFrame{
    MenuPanel  pnlMenu = new MenuPanel();
    JPanel     pnlMain = new MainPanel();
 
    public MainForm(String tilteApp) {

        Pantalla1(tilteApp);
        
        

    }


    private void Pantalla1(String titulo) {
            setTitle(titulo);
    
        // Configurar el layout del JFrame
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        // Configurar GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes

        // Crear un panel gris para el cuadrado
        JPanel gray1Panel = new JPanel();
        gray1Panel.setBackground(Color.LIGHT_GRAY);
        gray1Panel.setPreferredSize(new Dimension(500, 100)); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 10; // Altura adicional para el botón
        gbc.gridwidth = 0; // El panel gris ocupa el ancho completo (ajustar según necesidad)
        add(gray1Panel, gbc);

        JPanel gray2Panel = new JPanel();
        gray2Panel.setBackground(Color.LIGHT_GRAY);
        gray2Panel.setPreferredSize(new Dimension(500, 100)); 
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipady = 10; // Altura adicional para el botón
        gbc.gridwidth = 0; // El panel gris ocupa el ancho completo (ajustar según necesidad)
        add(gray2Panel, gbc);

     
        // Crear y agregar los botones
        JButton btnHome = new JButton("hhh");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 10;  // Coloca btnHome debajo del panel gris
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(btnHome, gbc);

        JButton btnTwo = new JButton("Button Two");
        gbc.gridx = 1; // Coloca btnTwo en la columna 1
        gbc.gridy = 1; // Mismo nivel que btnHome
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(btnTwo, gbc);

        JButton btnThree = new JButton("Button Three");
        gbc.gridx = 0;
        gbc.gridy = 2; // Coloca btnThree debajo de btnHome
        gbc.ipady = 10; // Altura adicional para el botón
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(btnThree, gbc);

        JButton btnFour = new JButton("Button Four");
        gbc.gridx = 1; // Coloca btnFour en la columna 1
        gbc.gridy = 2; // Mismo nivel que btnThree
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(btnFour, gbc);

        JButton btnfive = new JButton("Button five");
        gbc.gridx = 0;
        gbc.gridy = 3; // Coloca btnThree debajo de btnHome
        gbc.ipady = 10; // Altura adicional para el botón
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(btnfive, gbc);

        JButton btnsix = new JButton("Button six");
        gbc.gridx = 1; // Coloca btnFour en la columna 1
        gbc.gridy = 2; // Mismo nivel que btnThree
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(btnsix, gbc);

        // Configurar la ventana
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
            







        }   
      

    
      






}