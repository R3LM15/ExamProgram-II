package DataAccess;

import DataAccess.DTO.HormigaDTO;
import Framework.MMException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class HormigaDAO extends SQLiteDataHelper implements IDAO<HormigaDTO>{

    @Override
    public boolean create(HormigaDTO entity) throws Exception {
        String query = " INSERT INTO Hormiga (IdSexo ,IdProvincia ,IdGenoAlimento,IdIngestaNativa,TipoHormiga,Estado ) VALUES (?,?,?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdSexo());
            pstmt.setInt(2, entity.getIdProvincia());
            pstmt.setInt(3, entity.getIdGenoAlimento());
            pstmt.setInt(4, entity.getIdIngestaNativa());
            pstmt.setString(5, entity.getEstado());
            pstmt.setString(6, entity.getFechaCrea());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<HormigaDTO> readAll() throws Exception {
        List <HormigaDTO> lst = new ArrayList<>();
        String query =" SELECT ROW_NUMBER () OVER ( ORDER BY IdHormiga ) RowNum "
                     +" ,IdHormiga          "
                     +" ,IdSexo             "
                     +" ,IdProvincia        "
                     +" ,IdGenoAlimento     "
                     +" ,IdIngestaNativa    "
                     +" ,TipoHormiga        "
                     +" ,Estado             "
                     +" ,FechaCrea          "
                     +" FROM    Hormiga     "
                     +" WHERE   Estado ='A' ";  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                HormigaDTO u = new HormigaDTO(rs.getInt(1), 
                                              rs.getInt(2),
                                              rs.getInt(3), 
                                              rs.getInt(4),
                                              rs.getInt(5),
                                              rs.getString(6), 
                                              rs.getString(7), 
                                              rs.getString(8));// FechaModifica
                lst.add(u);
            }
        } 
        catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean update(HormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Hormiga SET IdSexo = ?, IdProvincia = ?, IdGenoAlimento = ?, IdIngestaNativa = ?, TipoHormiga = ? , Estado = ?,FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdSexo());
            pstmt.setInt(2, entity.getIdProvincia());
            pstmt.setInt(3, entity.getIdGenoAlimento());
            pstmt.setInt(4, entity.getIdIngestaNativa());
            pstmt.setString(5, entity.getTipoHormiga());
            pstmt.setString(6, entity.getEstado());
            pstmt.setString(5, dtf.format(now).toString());
            pstmt.setInt(6, entity.getIdHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE Hormiga SET Estado = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public HormigaDTO readBy(Integer id) throws Exception {
        HormigaDTO u = new HormigaDTO();
        String query = 
         " SELECT RowNum        "
        +"     ,IdHormiga       "
        +"     ,IdSexo          "
        +"     ,IdProvincia     "
        +"     ,IdGenoAlimento  "
        +"     ,IdIngestaNativa "
        +"     ,TipoHormiga     "
        +"     ,Estado          "
        +"     ,FechaCrea       "
        +"     ,FechaModifica   "
        +" FROM (                   "
        +"     SELECT ROW_NUMBER() OVER (ORDER BY IdHormiga) AS RowNum "
        +"     ,IdHormiga       "
        +"     ,IdSexo          "
        +"     ,IdProvincia     "
        +"     ,IdGenoAlimento  "
        +"     ,IdIngestaNativa "
        +"     ,TipoHormiga     "
        +"     ,Estado          "
        +"     ,FechaCrea       "
        +"     ,FechaModifica   "  
        +"     FROM Hormiga       "
        +"     WHERE Estado = 'A'   "
        +" ) sub                    "
        +" WHERE RowNum = " + id.toString();  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            //System.out.println(query);
            while (rs.next()) {
                u = new HormigaDTO( rs.getInt(1), 
                                    rs.getInt(2),
                                    rs.getInt(3), 
                                    rs.getInt(4),
                                    rs.getInt(5),
                                    rs.getString(6), 
                                    rs.getString(7), 
                                    rs.getString(8));
            }
        } 
        catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return u; 
    }

    public Integer getRowCount()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg "
                     +" FROM    UserLogin         "
                     +" WHERE   Estado ='A'      ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "getRowCount()");
        }
        return 0;
    }

    
}
