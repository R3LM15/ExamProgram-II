package BusinessLogic;

import DataAccess.DTO.HormigaDTO;
import DataAccess.HormigaDAO;
import java.sql.SQLException;

public class HormigaManager {

    private HormigaDAO hormigaDAO;

    public HormigaManager() {
        try {
            hormigaDAO = new HormigaDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean saveHormiga(Integer idSexo, Integer idProvincia, Integer idGenoAlimento, 
                               Integer idIngestaNativa, String tipoHormiga, 
                               String estado, String fechaCrea) throws Exception {
        try {
            HormigaDTO hormiga = new HormigaDTO(null, idSexo, idProvincia, idGenoAlimento, 
                                                 tipoHormiga, estado, fechaCrea);
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
            HormigaDTO hormiga = new HormigaDTO(idHormiga, idSexo, idProvincia, idGenoAlimento, 
                                                 tipoHormiga, estado, fechaCrea);
            return hormigaDAO.update(hormiga);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Métodos adicionales para manejar datos de hormigas
}
