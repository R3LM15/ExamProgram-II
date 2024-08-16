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
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class MMRegisto extends JPanel {

    // Variables para el JTable
    private DefaultTableModel tableModel;
    private int currentID; // Variable para almacenar el ID secuencial

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

        // Crear el JTable y el modelo
        String[] columnNames = {"ID", "Sexo", "Provincia", "GenoAlimento", "IngestaNativa", "TipoHormiga", "Estado"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        table.setGridColor(Color.DARK_GRAY);
        table.setBackground(Color.GRAY);
        table.setForeground(Color.WHITE);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(580, 150));

        gbc.gridy = 1;
        gbc.weighty = 0.3;
        add(scrollPane, gbc);

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
                updateColumnWithText(3, selectedOption); // Columna "GenoAlimento"
            } else if (source.getParent() == popupMenu2) {
                updateColumnWithText(4, selectedOption); // Columna "IngestaNativa"
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

        // Inicializar el ID secuencial
        currentID = 1; // O cualquier valor inicial que desees

        // ActionListener para el botón "Crear Hormiga larva"
        createButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de crear una hormiga larva?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                addNewHormiga();
            }
        });
    }

    // Método para agregar una nueva hormiga con datos predeterminados
    private void addNewHormiga() {
        // Incrementar el ID secuencial
        int newID = currentID++;

        // Datos predeterminados
        String sexo = "asexual";
        String provincia = getRandomProvincia();
        String genoAlimento = "";
        String ingestaNativa = "";
        String tipoHormiga = "larva";
        String estado = "viva";

        // Agregar la nueva fila al modelo de la tabla
        tableModel.addRow(new Object[] { newID, sexo, provincia, genoAlimento, ingestaNativa, tipoHormiga, estado });
    }

    // Método para obtener una provincia aleatoria
    private String getRandomProvincia() {
        String[] provincias = {"Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora-Chinchipe"};
        Random random = new Random();
        return provincias[random.nextInt(provincias.length)];
    }

    // Método para actualizar la columna con la opción seleccionada
    private void updateColumnWithText(int columnIndex, String text) {
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            tableModel.setValueAt(text, row, columnIndex);
        }
    }

    // Método para guardar los datos en la base de datos
    private void saveData() {
        HormigaDAO dao = new HormigaDAO();
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaCrea = now.format(formatter);

            for (int row = 0; row < tableModel.getRowCount(); row++) {
                String idHormigaText = tableModel.getValueAt(row, 0).toString().trim();
                String idSexoText = tableModel.getValueAt(row, 1).toString().trim();
                String idProvinciaText = tableModel.getValueAt(row, 2).toString().trim();
                String idGenoAlimentoText = tableModel.getValueAt(row, 3).toString().trim();
                String idIngestaNativaText = tableModel.getValueAt(row, 4).toString().trim();
                String tipoHormiga = tableModel.getValueAt(row, 5).toString().trim();
                String estado = tableModel.getValueAt(row, 6).toString().trim();

                int idHormiga;
                int idSexo;
                int idProvincia;
                int idGenoAlimento;
                int idIngestaNativa;

                // Intentar convertir los textos a enteros
                try {
                    idHormiga = Integer.parseInt(idHormigaText);
                    idSexo = Integer.parseInt(idSexoText);
                    idProvincia = Integer.parseInt(idProvinciaText);
                    idGenoAlimento = Integer.parseInt(idGenoAlimentoText);
                    idIngestaNativa = Integer.parseInt(idIngestaNativaText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Uno o más campos numéricos tienen un formato inválido. Asegúrate de que los campos numéricos contengan solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear el objeto DTO con la fecha actual
                HormigaDTO dto = new HormigaDTO(idHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa, tipoHormiga, estado, fechaCrea);

                // Verificar que los campos numéricos no estén vacíos
                if (tipoHormiga.isEmpty() || estado.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de texto.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dao.create(dto);
                    JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
