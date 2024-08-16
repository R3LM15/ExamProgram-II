package BusinessLogic;


import DataAccess.DTO.MMHormigaDTO;
import DataAccess.MMHormigaDAO;

public class HormigaService {

    private MMHormigaDAO hormigaDAO;

    public HormigaService() {
        try {
            hormigaDAO = new MMHormigaDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean saveHormiga(MMHormigaDTO hormiga) throws Exception {
        return hormigaDAO.create(hormiga);
    }

    // Métodos adicionales para la lógica de negocio
}
