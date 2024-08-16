package UserInterface.Form;

import DataAccess.DTO.MMHormigaDTO;
import DataAccess.MMHormigaDAO;
import UserInterface.MMStyle;
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

    private DefaultTableModel tableModel;
    private JTable table; 
    private int currentID; 

    private String MMselectedGenoAlimento = "<GenoAlimento>";
    private String MMselectedIngestaNativa = "<IngestaNativa>";

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

        ImageIcon logoIcon = new ImageIcon(MMStyle.URL_LOGO);
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

        String[] columnNames = {"ID", "Sexo", "Provincia", "GenoAlimento", "IngestaNativa", "TipoHormiga", "Estado"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel); 
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

        JButton leftButton1 = new JButton(MMselectedGenoAlimento);
        leftButton1.setBackground(Color.GRAY);
        leftButton1.setForeground(Color.WHITE);
        leftButton1.setPreferredSize(new Dimension(150, 50));
        leftButton1.setFocusPainted(false);

        JButton leftButton2 = new JButton(MMselectedIngestaNativa);
        leftButton2.setBackground(Color.GRAY);
        leftButton2.setForeground(Color.WHITE);
        leftButton2.setPreferredSize(new Dimension(150, 50));
        leftButton2.setFocusPainted(false);

        JPopupMenu popupMenu1 = new JPopupMenu();
        JMenuItem option1_1 = new JMenuItem("<GenoAlimento>");
        JMenuItem option1_2 = new JMenuItem("XY");
        JMenuItem option1_3 = new JMenuItem("XX"); 
        popupMenu1.add(option1_1);
        popupMenu1.add(option1_2);
        popupMenu1.add(option1_3);

        JPopupMenu popupMenu2 = new JPopupMenu();
        JMenuItem option2_1 = new JMenuItem("<IngestaNativa>");
        JMenuItem option2_2 = new JMenuItem("Carnivoro");
        JMenuItem option2_3 = new JMenuItem("Herbivoro");
        JMenuItem option2_4 = new JMenuItem("Omnivoro");
        JMenuItem option2_5 = new JMenuItem("Insectivoros");
        popupMenu2.add(option2_1);
        popupMenu2.add(option2_2);
        popupMenu2.add(option2_3);
        popupMenu2.add(option2_4);
        popupMenu2.add(option2_5);

        ActionListener updateSelectedOption = e -> {
            JMenuItem source = (JMenuItem) e.getSource();
            String selectedOption = source.getText();

            if (source.getParent() == popupMenu1) {
                MMselectedGenoAlimento = selectedOption;
                leftButton1.setText(MMselectedGenoAlimento);
            } else if (source.getParent() == popupMenu2) {
                MMselectedIngestaNativa = selectedOption;
                leftButton2.setText(MMselectedIngestaNativa);
            }
        };

        option1_1.addActionListener(updateSelectedOption);
        option1_2.addActionListener(updateSelectedOption);
        option1_3.addActionListener(updateSelectedOption);
        option2_1.addActionListener(updateSelectedOption);
        option2_2.addActionListener(updateSelectedOption);
        option2_3.addActionListener(updateSelectedOption);
        option2_4.addActionListener(updateSelectedOption);
        option2_5.addActionListener(updateSelectedOption);

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

        createButton1.addActionListener(e -> {
            updateColumnWithText(3, MMselectedGenoAlimento);
            checkAndUpdateRow();
        });

        createButton2.addActionListener(e -> {
            updateColumnWithText(4, MMselectedIngestaNativa);
            checkAndUpdateRow();
        });

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

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MMsaveData();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MMdeleteSelectedRow();
            }
        });

        fifthPanel.add(saveButton);
        fifthPanel.add(exitButton);

        gbc.gridy = 3;
        gbc.weighty = 0.1;
        add(fifthPanel, gbc);

        currentID = 1; 

        createButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de crear una hormiga larva?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                addNewHormiga();
            }
        });
    }

    private void addNewHormiga() {
        int newID = currentID++;

        String sexo = "asexual";
        String provincia = getRandomProvincia();
        String genoAlimento = MMselectedGenoAlimento;
        String ingestaNativa = MMselectedIngestaNativa;
        String tipoHormiga = "larva";
        String estado = "viva";

        tableModel.addRow(new Object[] { newID, sexo, provincia, genoAlimento, ingestaNativa, tipoHormiga, estado });
    }

    // Método para obtener una provincia aleatoria
    private String getRandomProvincia() {
        String[] provincias = {"Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora-Chinchipe"};
        Random random = new Random();
        return provincias[random.nextInt(provincias.length)];
    }

    private void updateColumnWithText(int columnIndex, String text) {
        int selectedRow = table.getSelectedRow(); 
        if (selectedRow != -1) { 
            String estado = (String) tableModel.getValueAt(selectedRow, 6); 
    
            if ("Muerta".equals(estado)) {
                JOptionPane.showMessageDialog(this, "No se puede modificar una hormiga cuyo estado es 'Muerta'.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                tableModel.setValueAt(text, selectedRow, columnIndex); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila en la tabla para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para verificar y actualizar la fila según las selecciones
    private void checkAndUpdateRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String genoAlimento = (String) tableModel.getValueAt(selectedRow, 3);
            String ingestaNativa = (String) tableModel.getValueAt(selectedRow, 4);
    
            if ("XY".equals(genoAlimento)) {
                tableModel.setValueAt("Macho", selectedRow, 1); // Actualizar el sexo a "Macho"
                tableModel.setValueAt("Zangano", selectedRow, 5); // Actualizar el tipo de hormiga a "Zangano"
            }
    
            // Verificar y actualizar el estado según ingestaNativa
            if ("Carnivoro".equals(ingestaNativa) || "Herbivoro".equals(ingestaNativa) || "Omnivoro".equals(ingestaNativa)) {
                tableModel.setValueAt("Viva", selectedRow, 6); 
            } else if ("Insectivoros".equals(ingestaNativa)) {
            } else {
                // Si ingestaNativa está vacía, mantener el estado en "Viva"
                if (ingestaNativa == null || ingestaNativa.trim().isEmpty()) {
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila en la tabla para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para guardar los datos en la base de datos
    private void MMsaveData() {
        int response = JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de guardar todo el hormiguero en la base de datos?", "Confirmación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    
        if (response == JOptionPane.YES_OPTION) {
            MMHormigaDAO dao = new MMHormigaDAO();
            try {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String fechaCrea = now.format(formatter);
    
                for (int row = 0; row < tableModel.getRowCount(); row++) {
                    String idHormigaText = tableModel.getValueAt(row, 0).toString().trim();
                    String sexoText = tableModel.getValueAt(row, 1).toString().trim();
                    String provinciaText = tableModel.getValueAt(row, 2).toString().trim();
                    String genoAlimentoText = tableModel.getValueAt(row, 3).toString().trim();
                    String ingestaNativaText = tableModel.getValueAt(row, 4).toString().trim();
                    String tipoHormiga = tableModel.getValueAt(row, 5).toString().trim();
                    String estado = tableModel.getValueAt(row, 6).toString().trim();
    
                    int idHormiga;
                    int idSexo = MMgetSexoId(sexoText);
                    int idProvincia = MMgetProvinciaId(provinciaText);
                    int idGenoAlimento = MMgetGenoAlimentoId(genoAlimentoText);
                    int idIngestaNativa = MMgetIngestaNativaId(ingestaNativaText);
    
                    try {
                        idHormiga = Integer.parseInt(idHormigaText);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Uno o más campos numéricos tienen un formato inválido. Asegúrate de que los campos numéricos contengan solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
    
                    MMHormigaDTO dto = new MMHormigaDTO(idHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa, tipoHormiga, estado, fechaCrea);
    
                    if (tipoHormiga.isEmpty() || estado.isEmpty() || idSexo == -1 || idProvincia == -1 || idGenoAlimento == -1 || idIngestaNativa == -1) {
                        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de texto y selecciona opciones válidas.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        dao.create(dto);
                    }
                }
                JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Guardado cancelado.");
        }
    }
    
    
    private void MMdeleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int response = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que deseas eliminar esta fila?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Fila eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila en la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    class CustomTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) {
            String estado = (String) getValueAt(row, 6);
            if ("Muerta".equals(estado)) {
                return false;
            }
            return super.isCellEditable(row, column);
        }
    }


    private int MMgetSexoId(String sexo) {
        switch (sexo) {
            case "Macho":
                return 1;
            case "Hembra":
                return 2;
            case "Asexual":
                return 3;
            default:
                return -1; 
        }
    }
    
    private int MMgetProvinciaId(String provincia) {
        switch (provincia) {
            case "Azuay":
                return 1;
            case "Bolívar":
                return 2;
            case "Cañar":
                return 3;
            case "Carchi":
                return 4;
            case "Chimborazo":
                return 5;
            case "Cotopaxi":
                return 6;
            case "Guayas":
                return 7;
            case "Imbabura":
                return 8;
            case "Loja":
                return 9;
            case "Los Ríos":
                return 10;
            case "Manabí":
                return 11;
            case "Morona Santiago":
                return 12;
            case "Napo":
                return 13;
            case "Pastaza":
                return 14;
            case "Pichincha":
                return 15;
            case "Santa Elena":
                return 16;
            case "Santo Domingo de los Tsáchilas":
                return 17;
            case "Tungurahua":
                return 18;
            case "Zamora-Chinchipe":
                return 19;
            case "Galápagos":
                return 20;
            case "Esmeraldas":
                return 21;
            case "Sucumbíos":
                return 22;
            case "Orellana":
                return 23;
            case "Isabela":
                return 24;
            default:
                return -1; 
        }
    }
    
    private int MMgetGenoAlimentoId(String genoAlimento) {
        switch (genoAlimento) {
            case "X":
                return 1;
            case "XX":
                return 2;
            case "XY":
                return 3;
            default:
                return -1; 
        }
    }
    
    private int MMgetIngestaNativaId(String ingestaNativa) {
        switch (ingestaNativa) {
            case "Carnivoro":
                return 1;
            case "Herbivoro":
                return 2;
            case "Omnivoro":
                return 3;
            case "Insectivoros":
                return 4;
            default:
                return -1; 
        }
    }
    
}
