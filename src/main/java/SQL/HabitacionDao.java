package SQL;

import Clases.Hotel.Habitacion;
import Clases.Hotel.Hotel;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Error_De_Acceso_A_Datos_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import Interfaces.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDao implements DAO<Habitacion> {

    private static final String SQL_INSERTAR =
            "INSERT INTO habitaciones (capacidad_ocupantes, id_hotel, estado_habitacion, tipo_habitacion) " +
                    "VALUES (?, ?, ?, ?)";

    private static final String SQL_ACTUALIZAR =
            "UPDATE habitaciones SET capacidad_ocupantes = ?, id_hotel = ?, " +
                    "estado_habitacion = ?, tipo_habitacion = ? " +
                    "WHERE numero_habitacion = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM habitaciones WHERE numero_habitacion = ?";

    private static final String SQL_BUSCAR_POR_ID =
            "SELECT h.*, ho.nombre_hotel, ho.direccion_hotel, ho.numero_contacto_hotel " +
                    "FROM habitaciones h " +
                    "INNER JOIN hoteles ho ON h.id_hotel = ho.id_hotel " +
                    "WHERE h.numero_habitacion = ?";

    private static final String SQL_LISTAR =
            "SELECT h.*, ho.nombre_hotel, ho.direccion_hotel, ho.numero_contacto_hotel " +
                    "FROM habitaciones h " +
                    "INNER JOIN hoteles ho ON h.id_hotel = ho.id_hotel " +
                    "ORDER BY h.numero_habitacion";

    @Override
    public void agregar(Habitacion element)
            throws Error_De_Acceso_A_Datos_Exeption {

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_INSERTAR)) {

            ps.setInt(1, element.getCapacidadOcupantes());
            ps.setInt(2, element.getHotel().getId_hotel());
            ps.setString(3, element.getEstadoHabitacion().name());
            ps.setString(4, element.getTipoHabitacion().name());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }
    }

    @Override
    public void actualizar(Habitacion element, int id)
            throws Error_De_Acceso_A_Datos_Exeption,
            Dato_No_Encontrado_Exeption {

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_ACTUALIZAR)) {

            ps.setInt(1, element.getCapacidadOcupantes());
            ps.setInt(2, element.getHotel().getId_hotel());
            ps.setString(3, element.getEstadoHabitacion().name());
            ps.setString(4, element.getTipoHabitacion().name());
            ps.setInt(5, id);

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Dato_No_Encontrado_Exeption(id);
            }

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }
    }
    @Override
    public void eliminar(int id) throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption {

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_ELIMINAR)) {

            Habitacion h = buscarPorId(id);

            ps.setInt(1, h.getId());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Dato_No_Encontrado_Exeption(h.getId());
            }

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }
    }

    @Override
    public Habitacion buscarPorId(int id) throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption {
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_BUSCAR_POR_ID)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return agregar(rs);
                }

                throw new Dato_No_Encontrado_Exeption(id);
            }

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }
    }

    @Override
    public List<Habitacion> listar() throws Error_De_Acceso_A_Datos_Exeption {
        List<Habitacion> lista = new ArrayList<>();

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_LISTAR);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(agregar(rs));
            }
        return lista;
    } catch (SQLException e){
        throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e.getCause());}
    }

    public Habitacion agregar(ResultSet rs) throws SQLException {

        int numeroHabitacion = rs.getInt("numero_habitacion");
        int capacidadOcupantes = rs.getInt("capacidad_ocupantes");
        Hotel hotel = agregarHotel(rs);
        EstadoHabitacion estadoHabitacion = EstadoHabitacion.valueOf(rs.getString("estado_habitacion"));
        Tipo_Habitacion tipoHabitacion = Tipo_Habitacion.valueOf(rs.getString("tipo_habitacion"));

        return new Habitacion(numeroHabitacion,capacidadOcupantes,hotel,estadoHabitacion,tipoHabitacion);



    }

    public Hotel agregarHotel(ResultSet rs) throws SQLException {


        String nombre = rs.getString("nombre_hotel");
        String direccion = rs.getString("direccion_hotel");
        String numeroContacto = rs.getString("numero_contacto_hotel");
        int idHotel = rs.getInt("id_hotel");

        return new Hotel(idHotel,nombre,direccion,numeroContacto);
    }

    public void reservarHabitacion(int id)
            throws Error_De_Acceso_A_Datos_Exeption,
            Habitacion_No_Disponible_Exeption {

        String sql = "UPDATE habitaciones " +
                "SET estado_habitacion = 'RESERVADA' " +
                "WHERE numero_habitacion = ? " +
                "AND estado_habitacion = 'DISPONIBLE'";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Habitacion_No_Disponible_Exeption(
                        EstadoHabitacion.RESERVADA, id
                );
            }

        } catch (SQLException e) {
            throw new Error_De_Acceso_A_Datos_Exeption(e.getMessage(), e);
        }
    }
}