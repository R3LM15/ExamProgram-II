package BusinessLogic;

import DataAccess.DTO.MMHormigaDTO;
import DataAccess.MMHormigaDAO;
import java.sql.SQLException;

public class HormigaManager {

    private MMHormigaDAO hormigaDAO;

    public HormigaManager() {
        try {
            hormigaDAO = new MMHormigaDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean saveHormiga(Integer idHormiga, Integer idSexo, Integer idProvincia, Integer idGenoAlimento, 
                               Integer idIngestaNativa, String tipoHormiga, 
                               String estado, String fechaCrea) throws Exception {
        try {
            MMHormigaDTO hormiga = new MMHormigaDTO(idHormiga, idSexo, idProvincia, idGenoAlimento, 
                                                 idIngestaNativa, tipoHormiga, estado, fechaCrea);
            return hormigaDAO.create(hormiga);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateHormiga(Integer idHormiga, Integer idSexo, Integer idProvincia, 
                                  Integer idGenoAlimento, Integer idIngestaNativa, 
                                  String tipoHormiga, String estado, String fechaCrea) throws Exception {
        try {
            MMHormigaDTO hormiga = new MMHormigaDTO(idHormiga, idSexo, idProvincia, idGenoAlimento, 
                                                 idIngestaNativa, tipoHormiga, estado, fechaCrea);
            return hormigaDAO.update(hormiga);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Métodos adicionales para manejar datos de hormigas
}
