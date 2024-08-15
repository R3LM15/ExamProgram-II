package DataAccess.DTO;

public class HormigaDTO {
    private Integer IdHormiga     ;           
    private Integer IdSexo ;           
    private Integer IdProvincia ;           
    private Integer IdGenoAlimento ;           
    private Integer IdIngestaNativa ;           
    private String TipoHormiga         ;           
    private String Estado         ;           
    private String FechaCrea  ;            

    public HormigaDTO(Integer IdHormiga  , 
                      Integer IdSexo, 
                      Integer IdProvincia, 
                      Integer IdGenoAlimento, 
                      Integer IdIngestaNativa,
                      String TipoHormiga, 
                      String Estado, 
                      String FechaCrea) {

        this.IdHormiga         = IdHormiga;
        this.IdSexo            = IdSexo;
        this.IdProvincia       = IdProvincia;
        this.IdGenoAlimento    = IdGenoAlimento;
        this.IdIngestaNativa   = IdIngestaNativa;
        this.TipoHormiga       = TipoHormiga;
        this.Estado            = Estado;
        this.FechaCrea         = FechaCrea;
    }


    public HormigaDTO(){}

    public HormigaDTO(int aInt, int aInt0, int aInt1, int aInt2, String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    


    public Integer getIdHormiga() {
        return IdHormiga;
    }


    public void setIdHormiga(Integer IdHormiga) {
        this.IdHormiga = IdHormiga;
    }


    public Integer getIdSexo() {
        return IdSexo;
    }


    public void setIdSexo(Integer idSexo) {
        IdSexo = idSexo;
    }


    public Integer getIdProvincia() {
        return IdProvincia;
    }


    public void setIdProvincia(Integer idProvincia) {
        IdProvincia = idProvincia;
    }


    public Integer getIdGenoAlimento() {
        return IdGenoAlimento;
    }


    public void setIdGenoAlimento(Integer idGenoAlimento) {
        IdGenoAlimento = idGenoAlimento;
    }


    public Integer getIdIngestaNativa() {
        return IdIngestaNativa;
    }


    public void setIdIngestaNativa(Integer idIngestaNativa) {
        IdIngestaNativa = idIngestaNativa;
    }


    public String getTipoHormiga() {
        return TipoHormiga;
    }


    public void setTipoHormiga(String tipoHormiga) {
        TipoHormiga = tipoHormiga;
    }


    public String getEstado() {
        return Estado;
    }


    public void setEstado(String estado) {
        Estado = estado;
    }


    public String getFechaCrea() {
        return FechaCrea;
    }


    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }




    @Override
    public String toString(){
        return  getClass().getName()
                + "\n IdHormiga "           + getIdHormiga()
                + "\n IdSexo "              + getIdSexo()
                + "\n IdProvincia      "    + getIdProvincia()
                + "\n IdGenoAlimento   "    + getIdGenoAlimento()
                + "\n IdIngestaNativa  "    + getIdIngestaNativa()
                + "\n TipoHormiga  "        + getTipoHormiga()
                + "\n Estado  "             + getEstado()
                + "\n FechaCrea  "          + getFechaCrea();
                
    }

}
   

  
