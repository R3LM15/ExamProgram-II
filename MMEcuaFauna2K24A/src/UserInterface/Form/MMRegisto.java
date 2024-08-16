package UserInterface.Form;

import DataAccess.DTO.HormigaDTO;
import DataAccess.HormigaDAO;
import UserInterface.IAStyle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.Border;

public class MMRegisto extends JPanel {

    // Crear una matriz para almacenar los JTextField
    private JTextField[][] textFields;

    public MMRegisto() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 30, 10, 30);

        // Crear el segundo panel
        JPanel secondPanel = new JPanel();
        secondPanel.setPreferredSize(new Dimension(600, 50));
        secondPanel.setLayout(new BorderLayout(10, 10));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        ImageIcon logoIcon = new ImageIcon(IAStyle.URL_LOGO);
        Image logoImage = logoIcon.getImage();
        Image resizedLogoImage = logoImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoIcon = new ImageIcon(resizedLogoImage);

        JLabel logoLabel = new JLabel(resizedLogoIcon);
        JLabel textLabel = new JLabel("Hormiguero virtual");
        textLabel.setForeground(Color.BLUE);

        leftPanel.add(logoLabel);
        leftPanel.add(textLabel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        JButton createButton = new JButton("Crear Hormiga larva");
        createButton.setBackground(Color.DARK_GRAY);
        createButton.setForeground(Color.WHITE);
        createButton.setPreferredSize(new Dimension(300, 50));
        createButton.setFocusPainted(false);

        rightPanel.add(createButton);

        secondPanel.add(leftPanel, BorderLayout.WEST);
        secondPanel.add(rightPanel, BorderLayout.EAST);

        gbc.gridy = 0;
        gbc.weighty = 0.1;
        add(secondPanel, gbc);

        // Crear el tercer panel
        JPanel thirdPanel = new JPanel();
        thirdPanel.setPreferredSize(new Dimension(580, 150));
        thirdPanel.setLayout(new GridLayout(3, 6, 5, 5)); // Aumentar filas para incluir encabezados

        // Configurar el borde gris oscuro
        Border darkGrayBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);

        // Encabezados para la primera fila
        String[] headers = {"Sexo", "Provincia", "GenoAlimento", "IngestaNativa", "TipoHormiga", "Estado"};

        for (String header : headers) {
            JLabel headerLabel = new JLabel(header);
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            headerLabel.setBackground(Color.LIGHT_GRAY);
            headerLabel.setOpaque(true); // Necesario para que el fondo se muestre
            headerLabel.setBorder(darkGrayBorder);
            thirdPanel.add(headerLabel);
        }

        // Inicializar la matriz de JTextField con 2 filas
        textFields = new JTextField[2][6];

        // Agregar JTextField a partir de la segunda fila
        for (int row = 0; row < 2; row++) { // Cambiar a 2 filas
            for (int col = 0; col < 6; col++) {
                JTextField cellTextField = new JTextField("");
                cellTextField.setBackground(Color.GRAY);
                cellTextField.setForeground(Color.WHITE);
                cellTextField.setPreferredSize(new Dimension(90, 40));
                cellTextField.setHorizontalAlignment(JTextField.CENTER);
                cellTextField.setBorder(darkGrayBorder); // Aplicar el borde gris oscuro

                textFields[row][col] = cellTextField;
                thirdPanel.add(cellTextField);
            }
        }

        gbc.gridy = 1;
        gbc.weighty = 0.3;
        add(thirdPanel, gbc);

        // Crear el cuarto panel
        JPanel fourthPanel = new JPanel();
        fourthPanel.setPreferredSize(new Dimension(580, 150));
        fourthPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcFourth = new GridBagConstraints();
        gbcFourth.insets = new Insets(10, 5, 10, 5);

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

        JPopupMenu popupMenu1 = new JPopupMenu();
        JMenuItem option1_1 = new JMenuItem("Opción 1.1");
        JMenuItem option1_2 = new JMenuItem("Opción 1.2");
        popupMenu1.add(option1_1);
        popupMenu1.add(option1_2);

        JPopupMenu popupMenu2 = new JPopupMenu();
        JMenuItem option2_1 = new JMenuItem("Opción 2.1");
        JMenuItem option2_2 = new JMenuItem("Opción 2.2");
        popupMenu2.add(option2_1);
        popupMenu2.add(option2_2);

        // ActionListener para actualizar la columna correspondiente
        ActionListener updateColumn = e -> {
            JMenuItem source = (JMenuItem) e.getSource();
            String selectedOption = source.getText();

            // Determine which button was clicked and which column to update
            if (source.getParent() == popupMenu1) {
                updateColumnWithText(2, selectedOption); // Columna "GenoAlimento"
            } else if (source.getParent() == popupMenu2) {
                updateColumnWithText(3, selectedOption); // Columna "IngestaNativa"
            }
        };

        option1_1.addActionListener(updateColumn);
        option1_2.addActionListener(updateColumn);
        option2_1.addActionListener(updateColumn);
        option2_2.addActionListener(updateColumn);

        leftButton1.addActionListener(e -> popupMenu1.show(leftButton1, 0, leftButton1.getHeight()));
        leftButton2.addActionListener(e -> popupMenu2.show(leftButton2, 0, leftButton2.getHeight()));

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

        gbcFourth.gridx = 0;
        gbcFourth.gridy = 0;
        gbcFourth.weightx = 0.5;
        gbcFourth.fill = GridBagConstraints.VERTICAL;
        gbcFourth.anchor = GridBagConstraints.WEST;
        fourthPanel.add(leftButton1, gbcFourth);

        gbcFourth.gridy = 1;
        fourthPanel.add(leftButton2, gbcFourth);

        gbcFourth.gridx = 1;
        gbcFourth.gridy = 0;
        gbcFourth.weightx = 0.5;
        gbcFourth.fill = GridBagConstraints.VERTICAL;
        gbcFourth.anchor = GridBagConstraints.EAST;
        fourthPanel.add(createButton1, gbcFourth);

        gbcFourth.gridy = 1;
        fourthPanel.add(createButton2, gbcFourth);

        gbc.gridy = 2;
        gbc.weighty = 0.3;
        add(fourthPanel, gbc);

        // Crear el quinto panel
        JPanel fifthPanel = new JPanel();
        fifthPanel.setBackground(Color.LIGHT_GRAY);
        fifthPanel.setPreferredSize(new Dimension(580, 75));
        fifthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        Color lightBlue = new Color(173, 216, 230);
        Border border = BorderFactory.createLineBorder(new Color(70, 130, 180), 2);

        JButton saveButton = new JButton("GUARDAR");
        saveButton.setBackground(lightBlue);
        saveButton.setForeground(Color.BLACK);
        saveButton.setPreferredSize(new Dimension(150, 50));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(border);

        JButton exitButton = new JButton("ELIMINAR");
        exitButton.setBackground(lightBlue);
        exitButton.setForeground(Color.BLACK);
        exitButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setFocusPainted(false);
        exitButton.setBorder(border);

        // Agregar el ActionListener para el botón "GUARDAR"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        fifthPanel.add(saveButton);
        fifthPanel.add(exitButton);

        gbc.gridy = 3;
        gbc.weighty = 0.1;
        add(fifthPanel, gbc);
    }

    // Método para actualizar la columna con la opción seleccionada
    private void updateColumnWithText(int columnIndex, String text) {
        for (int row = 0; row < textFields.length; row++) {
            textFields[row][columnIndex].setText(text);
        }
    }

    // Método para guardar los datos en la base de datos
    private void saveData() {
        HormigaDAO dao = new HormigaDAO();
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaCrea = now.format(formatter);
            
            for (int row = 0; row < textFields.length; row++) {
                String idSexoText = textFields[row][0].getText().trim();
                String idProvinciaText = textFields[row][1].getText().trim();
                String idGenoAlimentoText = textFields[row][2].getText().trim();
                String idIngestaNativaText = textFields[row][3].getText().trim();
                String tipoHormiga = textFields[row][4].getText().trim();
                String estado = textFields[row][5].getText().trim();
        
                // Verificar que los campos no estén vacíos y contengan solo números válidos
                if (idSexoText.isEmpty() || idProvinciaText.isEmpty() || idGenoAlimentoText.isEmpty() || idIngestaNativaText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                int idSexo;
                int idProvincia;
                int idGenoAlimento;
                int idIngestaNativa;
                try {
                    idSexo = Integer.parseInt(idSexoText);
                    idProvincia = Integer.parseInt(idProvinciaText);
                    idGenoAlimento = Integer.parseInt(idGenoAlimentoText);
                    idIngestaNativa = Integer.parseInt(idIngestaNativaText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Uno o más campos numéricos tienen un formato inválido. Asegúrate de que los campos numéricos contengan solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                // Verificar que tipoHormiga y estado no estén vacíos
                if (tipoHormiga.isEmpty() || estado.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de texto.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                // Crear el objeto DTO con la fecha actual
                HormigaDTO dto = new HormigaDTO(idSexo, idProvincia, idGenoAlimento, idIngestaNativa, tipoHormiga, estado, fechaCrea);
        
                // Guardar en la base de datos
                dao.create(dto);
            }
        
            JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

