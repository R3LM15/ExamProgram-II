package BusinessLogic;


import DataAccess.DTO.HormigaDTO;
import DataAccess.HormigaDAO;

public class HormigaService {

    private HormigaDAO hormigaDAO;

    public HormigaService() {
        try {
            hormigaDAO = new HormigaDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean saveHormiga(HormigaDTO hormiga) throws Exception {
        return hormigaDAO.create(hormiga);
    }

    // Métodos adicionales para la lógica de negocio
}
