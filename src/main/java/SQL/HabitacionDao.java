package SQL;

import Clases.Hotel.Habitacion;
import Clases.Hotel.Hotel;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Error_De_Acceso_A_Datos_Exeption;
import Interfaces.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HabitacionDao implements DAO<Habitacion> {

    private static final String SQL_INSERTAR = "INSERT INTO habitaciones (capacidad_ocupantes, id_hotel, " + "estado_habitacion, tipo_habitacion) VALUES (?, ?, ?, ?)";

    @Override
    public void agregar(Habitacion element) throws Error_De_Acceso_A_Datos_Exeption {
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_INSERTAR)){
            ps.setInt(1,element.getCapacidadOcupantes());
            ps.setInt(2, element.getHotel().getId_hotel());
            ps.setString(3,element.getEstadoHabitacion().name());
            ps.setString(4,element.getTipoHabitacion().name());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void actualizar(Habitacion element) throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption {

    }

    @Override
    public void eliminar(Habitacion element) throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption {

    }

    @Override
    public Habitacion buscarPorId(int id) throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption {
        return null;
    }

    @Override
    public List<Habitacion> listar() throws Error_De_Acceso_A_Datos_Exeption {
        return List.of();
    }
}
