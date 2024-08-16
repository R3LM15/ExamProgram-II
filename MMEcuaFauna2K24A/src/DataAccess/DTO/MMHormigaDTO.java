package DataAccess.DTO;

public class MMHormigaDTO {
    private Integer idHormiga;
    private Integer idSexo;
    private Integer idProvincia;
    private Integer idGenoAlimento;
    private Integer idIngestaNativa;
    private String tipoHormiga;
    private String estado;
    private String fechaCrea;
    private String fechaModifica; // Si es necesario

    public MMHormigaDTO(Integer idHormiga,Integer idSexo, Integer idProvincia, Integer idGenoAlimento, Integer idIngestaNativa, String tipoHormiga, String estado, String fechaCrea) {
        this.idHormiga = idHormiga;
        this.idSexo = idSexo;
        this.idProvincia = idProvincia;
        this.idGenoAlimento = idGenoAlimento;
        this.idIngestaNativa = idIngestaNativa;
        this.tipoHormiga = tipoHormiga;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = null; // O inicializar si es necesario
    }

    // Getters y Setters
    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }
    
    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdGenoAlimento() {
        return idGenoAlimento;
    }

    public void setIdGenoAlimento(Integer idGenoAlimento) {
        this.idGenoAlimento = idGenoAlimento;
    }

    public Integer getIdIngestaNativa() {
        return idIngestaNativa;
    }

    public void setIdIngestaNativa(Integer idIngestaNativa) {
        this.idIngestaNativa = idIngestaNativa;
    }

    public String getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }
}
