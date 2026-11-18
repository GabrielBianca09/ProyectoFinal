package SQL;

import Clases.Hotel.Hotel;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Error_De_Acceso_A_Datos_Exeption;
import Interfaces.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDao implements DAO<Hotel> {

    private static final String SQL_INSERTAR =
            "INSERT INTO hoteles (nombre_hotel, direccion_hotel, numero_contacto_hotel) " +
                    "VALUES (?, ?, ?)";

    private static final String SQL_ACTUALIZAR =
            "UPDATE hoteles SET nombre_hotel = ?, direccion_hotel = ?, " +
                    "numero_contacto_hotel = ? WHERE id_hotel = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM hoteles WHERE id_hotel = ?";

    private static final String SQL_BUSCAR_POR_ID =
            "SELECT * FROM hoteles WHERE id_hotel = ?";

    private static final String SQL_LISTAR =
            "SELECT * FROM hoteles ORDER BY id_hotel";


    @Override
    public void agregar(Hotel element) throws Error_De_Acceso_A_Datos_Exeption {
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_INSERTAR)) {

                ps.setString(1, element.getNombreHotel());
                ps.setString(2, element.getDireccionHotel());
                ps.setString(3, element.getNumeroContactoHotel());

                ps.executeUpdate();

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }

    }

    @Override
    public void actualizar(Hotel element, int id) throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption {

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_ACTUALIZAR)) {

            ps.setString(1, element.getNombreHotel());
            ps.setString(2, element.getDireccionHotel());
            ps.setString(3, element.getNumeroContactoHotel());
            ps.setInt(4, element.getId_hotel());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Dato_No_Encontrado_Exeption(element.getId_hotel());
            }

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(int id) throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption {

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_ELIMINAR)) {

            Hotel h = buscarPorId(id);

            ps.setInt(1, h.getId_hotel());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Dato_No_Encontrado_Exeption(h.getId_hotel());
            }

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }

    }

    @Override
    public Hotel buscarPorId(int id) throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption {
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_BUSCAR_POR_ID)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return agregarHotel(rs);
                }

                throw new Dato_No_Encontrado_Exeption(id);
            }

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }
    }

    @Override
    public List<Hotel> listar() throws Error_De_Acceso_A_Datos_Exeption {
        List<Hotel> lista = new ArrayList<>();

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_LISTAR);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(agregarHotel(rs));
            }

            return lista;

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }
    }

    public Hotel agregarHotel(ResultSet rs) throws SQLException {


        String nombre = rs.getString("nombre_hotel");
        String direccion = rs.getString("direccion_hotel");
        String numeroContacto = rs.getString("numero_contacto_hotel");
        int idHotel = rs.getInt("id_hotel");

        return new Hotel(idHotel,nombre,direccion,numeroContacto);
    }
}
