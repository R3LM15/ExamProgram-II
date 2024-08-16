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

public class HormigaDAO extends SQLiteDataHelper implements IDAO<HormigaDTO> {

    @Override
    public boolean create(HormigaDTO entity) throws Exception {
        String query = "INSERT INTO Hormiga (IdSexo, IdProvincia, IdGenoAlimento, IdIngestaNativa, TipoHormiga, Estado, FechaCrea) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdSexo());
            pstmt.setInt(2, entity.getIdProvincia());
            pstmt.setInt(3, entity.getIdGenoAlimento());
            pstmt.setInt(4, entity.getIdIngestaNativa());
            pstmt.setString(5, entity.getTipoHormiga());
            pstmt.setString(6, entity.getEstado());
            pstmt.setString(7, entity.getFechaCrea());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<HormigaDTO> readAll() throws Exception {
        List<HormigaDTO> lst = new ArrayList<>();
        String query = "SELECT IdSexo, IdProvincia, IdGenoAlimento, IdIngestaNativa, TipoHormiga, Estado, FechaCrea FROM Hormiga WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                HormigaDTO u = new HormigaDTO(
                    rs.getInt("IdSexo"),
                    rs.getInt("IdProvincia"),
                    rs.getInt("IdGenoAlimento"),
                    rs.getInt("IdIngestaNativa"),
                    rs.getString("TipoHormiga"),
                    rs.getString("Estado"),
                    rs.getString("FechaCrea")
                );
                lst.add(u);
            }
        } catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(HormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Hormiga SET IdSexo = ?, IdProvincia = ?, IdGenoAlimento = ?, IdIngestaNativa = ?, TipoHormiga = ?, Estado = ?, FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdSexo());
            pstmt.setInt(2, entity.getIdProvincia());
            pstmt.setInt(3, entity.getIdGenoAlimento());
            pstmt.setInt(4, entity.getIdIngestaNativa());
            pstmt.setString(5, entity.getTipoHormiga());
            pstmt.setString(6, entity.getEstado());
            pstmt.setString(7, dtf.format(now).toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Hormiga SET Estado = ? WHERE IdHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public HormigaDTO readBy(Integer id) throws Exception {
        HormigaDTO u = null;
        String query = "SELECT IdHormiga, IdSexo, IdProvincia, IdGenoAlimento, IdIngestaNativa, TipoHormiga, Estado, FechaCrea, FechaModifica " +
                       "FROM Hormiga " +
                       "WHERE IdHormiga = ? AND Estado = 'A'";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                u = new HormigaDTO(
                    rs.getInt("IdSexo"),
                    rs.getInt("IdProvincia"),
                    rs.getInt("IdGenoAlimento"),
                    rs.getInt("IdIngestaNativa"),
                    rs.getString("TipoHormiga"),
                    rs.getString("Estado"),
                    rs.getString("FechaCrea")
                );
            }
        } catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return u;
    }

    public Integer getRowCount() throws Exception {
        String query = "SELECT COUNT(*) AS TotalReg FROM Hormiga WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("TotalReg");
            }
        } catch (SQLException e) {
            throw new MMException(e.getMessage(), getClass().getName(), "getRowCount()");
        }
        return 0;
    }
}
