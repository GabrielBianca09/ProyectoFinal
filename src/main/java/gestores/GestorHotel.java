package gestores;

import Clases.Hotel.Hotel;
import Clases.Persona.Admin.Administrador;
import Clases.Persona.Empleados.Empleado;
import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Clases.Hotel.Reservas.Reserva;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
//aca se usa el gestor generico para hacer todas las funciones de cada clase.
//funciones de creacion,eliminacion,actualizacion,busqueda,verificar existencia, listarDatos,validacion de credenciales(administrador).
public class GestorHotel {
    private Gestor<Reserva>reservaGestor;
    private Gestor<Habitacion>habitacionGestor;
    private Gestor<Pasajero>huespedes;
    private Gestor<Empleado>empleadoGestor;
    private Gestor<Hotel>hoteles;
    private Gestor<Administrador>administradorGestor;

    public GestorHotel() {
        this.empleadoGestor =new Gestor<Empleado>();
        this.habitacionGestor =new Gestor<Habitacion>();
        this.huespedes =new Gestor<Pasajero>();
        this.reservaGestor =new Gestor<Reserva>();
        this.hoteles=new Gestor<Hotel>();
        this.administradorGestor=new Gestor<Administrador>();
    }

    public Gestor<Empleado> getEmpleadoGestor() {
        return empleadoGestor;
    }

    public void setEmpleadoGestor(Gestor<Empleado> empleadoGestor) {
        this.empleadoGestor = empleadoGestor;
    }

    public Gestor<Habitacion> getHabitacionGestor() {
        return habitacionGestor;
    }

    public void setHabitacionGestor(Gestor<Habitacion> habitacionGestor) {
        this.habitacionGestor = habitacionGestor;
    }

    public Gestor<Pasajero> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(Gestor<Pasajero> huespedes) {
        this.huespedes = huespedes;
    }

    public Gestor<Reserva> getReservaGestor() {
        return reservaGestor;
    }

    public void setReservaGestor(Gestor<Reserva> reservaGestor) {
        this.reservaGestor = reservaGestor;
    }
    // ==================== AGREGAR ====================

    public void agregarHabitacion(Habitacion h) throws Datos_Duplicados_Exeption {
        habitacionGestor.agregar(h);
    }

    public void agregarCliente(Pasajero p) throws Datos_Duplicados_Exeption, Datos_Invalidos_Exeption {
        huespedes.agregar(p);
    }

    public void agregarEmpleado(Empleado e) throws Datos_Duplicados_Exeption {
        empleadoGestor.agregar(e);
    }

    public void agregarReserva(Reserva r) throws Datos_Duplicados_Exeption {
        reservaGestor.agregar(r);
    }

    public void agregarHotel(Hotel h) throws Datos_Duplicados_Exeption {
        hoteles.agregar(h);
    }

    public void agregarAdministardor(Administrador a) throws Datos_Duplicados_Exeption {
        administradorGestor.agregar(a);
    }


// ==================== BUSCAR ====================

    public Habitacion buscarHabitacion(int id) throws Dato_No_Encontrado_Exeption {
        return habitacionGestor.buscar(id);
    }

    public Pasajero buscarCliente(int id) throws Dato_No_Encontrado_Exeption {
        return huespedes.buscar(id);
    }

    public Pasajero buscarPasajero(int id) throws Dato_No_Encontrado_Exeption {
        for (Pasajero p : huespedes.getLista()) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new Dato_No_Encontrado_Exeption(id);
    }

    public Empleado buscarEmpleado(int id) throws Dato_No_Encontrado_Exeption {
        return empleadoGestor.buscar(id);
    }

    public Reserva buscarReserva(int id) throws Dato_No_Encontrado_Exeption {
        return reservaGestor.buscar(id);
    }

    public Hotel BuscarHotel(int id) throws Dato_No_Encontrado_Exeption {
        return hoteles.buscar(id);
    }

    public Administrador buscarAdministrador(int idadmin) throws Dato_No_Encontrado_Exeption {
        for (Administrador a : administradorGestor.getLista()) {
            if (a.getId() == idadmin) {
                return a;
            }
        }
        return null;
    }


// ==================== VALIDAR EXISTENCIA ====================

    public boolean existeHabitacion(int id) throws Dato_No_Encontrado_Exeption {
        for (Habitacion h : habitacionGestor.getLista()) {
            if (h.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean existeHotel(int id) throws Dato_No_Encontrado_Exeption {
        for (Hotel h : hoteles.getLista()) {
            if (h.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean existePasajero(int id) {
        for (Pasajero p : huespedes.getLista()) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }


// ==================== ACTUALIZAR ====================

    public void actualizarHabitacion(int id, Habitacion h) throws Dato_No_Encontrado_Exeption {
        habitacionGestor.actualizar(h, id);
    }

    public void actualizarReserva(int id, Reserva r) throws Dato_No_Encontrado_Exeption {
        reservaGestor.actualizar(r, id);
    }

    public void actualizarCliente(int id, Pasajero p) throws Dato_No_Encontrado_Exeption {
        huespedes.actualizar(p, id);
    }

    public void actualizarEmpleado(int id, Empleado e) throws Dato_No_Encontrado_Exeption {
        empleadoGestor.actualizar(e, id);
    }

    public void actualizarHotel(int id, Hotel h) throws Datos_Duplicados_Exeption, Dato_No_Encontrado_Exeption {
        hoteles.actualizar(h, id);
    }


// ==================== ELIMINAR ====================

    public void eliminarHabitacion(int id) throws Dato_No_Encontrado_Exeption {
        habitacionGestor.eliminar(id);
    }

    public void eliminarReserva(int id) throws Dato_No_Encontrado_Exeption {
        reservaGestor.eliminar(id);
    }

    public void eliminarHuesped(int id) throws Dato_No_Encontrado_Exeption {
        huespedes.eliminar(id);
    }

    public void eliminarEmpleado(int id) throws Dato_No_Encontrado_Exeption {
        empleadoGestor.eliminar(id);
    }

    public void eliminarHotel(int id) throws Dato_No_Encontrado_Exeption {
        Hotel h = hoteles.buscar(id);
        hoteles.eliminar(id);
    }

    public void eliminarAdministrador(int idadmin) throws Dato_No_Encontrado_Exeption {
        Administrador a = buscarAdministrador(idadmin);
        administradorGestor.eliminar(a.getId());
    }


// ==================== MOSTRAR / LISTAR ====================

    public void mostrarHabitaciones() {
        for (Habitacion h : habitacionGestor.getLista()) {
            System.out.println(h.toString());
        }
    }

    public void mostrarhuespedes() {
        for (Pasajero p : huespedes.getLista()) {
            System.out.println(p.toString());
        }
    }

    public void mostrarEmpleados() {
        for (Empleado e : getEmpleadoGestor().getLista()) {
            System.out.println(e.toString());
        }
    }

    public void mostrarReservas() {
        for (Reserva r : getReservaGestor().getLista()) {
            System.out.println(r.toString());
        }
    }

    public void listarHoteles() {
        for (Hotel h : hoteles.getLista()) {
            System.out.println(h.toString());
        }
    }

    public void mostrarAdministrador() {
        for (Administrador a : administradorGestor.getLista()) {
            System.out.println(a);
        }
    }


// ==================== ADMINISTRADORES ====================

    public Administrador ValidacionAdministrador(String nombre, String clave) throws Dato_No_Encontrado_Exeption {
        for (Administrador a : administradorGestor.getLista()) {
            if (a.validarClave(clave, nombre)) {
                return a;
            }
        }
        throw new Datos_Invalidos_Exeption("clave o usuario incorrecto");
    }


// ==================== GETTERS Y SETTERS ====================

    public Gestor<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(Gestor<Hotel> hoteles) {
        this.hoteles = hoteles;
    }





}
