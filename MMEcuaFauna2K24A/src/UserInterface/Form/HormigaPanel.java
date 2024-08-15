package UserInterface.Form;

import BusinessLogic.HormigaService;
import DataAccess.DTO.HormigaDTO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HormigaPanel extends JPanel {

    private JTextField txtIdSexo;
    private JTextField txtIdProvincia;
    private JTextField txtIdGenoAlimento;
    private JTextField txtIdIngestaNativa;
    private JTextField txtTipoHormiga;
    private JTextField txtEstado;
    private JTextField txtFechaCrea;
    private JButton btnSave;

    private HormigaService hormigaService;

    public HormigaPanel() {
        setLayout(new GridLayout(8, 2, 10, 10));
        hormigaService = new HormigaService();

        // Crear campos de texto y etiquetas
        add(new JLabel("IdSexo:"));
        txtIdSexo = new JTextField();
        add(txtIdSexo);

        add(new JLabel("IdProvincia:"));
        txtIdProvincia = new JTextField();
        add(txtIdProvincia);

        add(new JLabel("IdGenoAlimento:"));
        txtIdGenoAlimento = new JTextField();
        add(txtIdGenoAlimento);

        add(new JLabel("IdIngestaNativa:"));
        txtIdIngestaNativa = new JTextField();
        add(txtIdIngestaNativa);

        add(new JLabel("TipoHormiga:"));
        txtTipoHormiga = new JTextField();
        add(txtTipoHormiga);

        add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        add(txtEstado);

        add(new JLabel("FechaCrea:"));
        txtFechaCrea = new JTextField();
        add(txtFechaCrea);

        // Botón para guardar
        btnSave = new JButton("Guardar");
        add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveHormiga();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
    }

    private void saveHormiga() throws HeadlessException, Exception {
        HormigaDTO hormiga = new HormigaDTO(
                null, // IdHormiga se maneja automáticamente por la base de datos
                Integer.parseInt(txtIdSexo.getText()),
                Integer.parseInt(txtIdProvincia.getText()),
                Integer.parseInt(txtIdGenoAlimento.getText()),
                Integer.parseInt(txtIdIngestaNativa.getText()),
                txtTipoHormiga.getText(),
                txtEstado.getText(),
                txtFechaCrea.getText()
        );

        if (hormigaService.saveHormiga(hormiga)) {
            JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos.");
        }
    }
}
