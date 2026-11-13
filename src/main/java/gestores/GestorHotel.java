package gestores;

import Clases.Hotel.Servicios.EmpleadoServicio;
import Clases.Hotel.Servicios.Servicio;
import Clases.Persona.Empleados.Empleado;
import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Clases.Hotel.Reservas.Reserva;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;

public class GestorHotel {
    private Gestor<Reserva>reservaGestor;
    private Gestor<Habitacion>habitacionGestor;
    private Gestor<Pasajero>huespedes;
    private Gestor<Empleado>empleadoGestor;
    private Gestor<Servicio>servicioGestor;

    public GestorHotel() {
        this.empleadoGestor =new Gestor<Empleado>();
        this.habitacionGestor =new Gestor<Habitacion>();
        this.huespedes =new Gestor<Pasajero>();
        this.reservaGestor =new Gestor<Reserva>();
        this.servicioGestor=new Gestor<Servicio>();
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

    public Gestor<Servicio> getServicioGestor() {
        return servicioGestor;
    }

    public void setServicioGestor(Gestor<Servicio> servicioGestor) {
        this.servicioGestor = servicioGestor;
    }

    public void agregarHabitacion(Habitacion h)throws Datos_Duplicados_Exeption {
        habitacionGestor.agregar(h);
    }
    public void agregarCliente(Pasajero p)throws Datos_Duplicados_Exeption, Datos_Invalidos_Exeption {
        huespedes.agregar(p);
    }
    public void agregarEmpleado(Empleado e)throws Datos_Duplicados_Exeption{
        empleadoGestor.agregar(e);
    }
    public void agregarReserva(Reserva r)throws Datos_Duplicados_Exeption{
        reservaGestor.agregar(r);
    }


    public Habitacion buscar(int id)throws Dato_No_Encontrado_Exeption {
       Habitacion h=habitacionGestor.buscar(id);
       return h;
    }

    public Pasajero buscarCliente(int id)throws Dato_No_Encontrado_Exeption {
        return huespedes.buscar(id);
    }

    public Empleado buscarEmpleado(int id)throws Dato_No_Encontrado_Exeption{
        return empleadoGestor.buscar(id);
    }

    public Reserva buscarReserva(int id)throws Dato_No_Encontrado_Exeption {
        return reservaGestor.buscar(id);
    }


    public void eliminarHabitacion(int id)throws Dato_No_Encontrado_Exeption{
        habitacionGestor.eliminar(id);
    }

    public void eliminarReserva(int id)throws Dato_No_Encontrado_Exeption{
        reservaGestor.eliminar(id);
    }

    public void eliminarHuesped(int id)throws Dato_No_Encontrado_Exeption{
        huespedes.eliminar(id);
    }

    public void eliminarEmpleado(int id)throws Dato_No_Encontrado_Exeption{
        empleadoGestor.eliminar(id);
    }
    //falta metodo para actualizar los datos.........

    public void actualizarHabitacion(int id,Habitacion h)throws Dato_No_Encontrado_Exeption{
        habitacionGestor.actualizar(h,id);
    }

    public void actualizarReserva(int id,Reserva r)throws Dato_No_Encontrado_Exeption{
        reservaGestor.actualizar(r,id);
    }

    public void actualizarCliente(int id,Pasajero p)throws Dato_No_Encontrado_Exeption{
        huespedes.actualizar(p,id);
    }

    public void actualizarEmpleado(int id,Empleado e)throws Dato_No_Encontrado_Exeption{
        empleadoGestor.actualizar(e,id);
    }

    public void agregarServicio(Servicio s)throws Datos_Invalidos_Exeption,Datos_Duplicados_Exeption{
        servicioGestor.agregar(s);
    }
    public void eliminarServicio(int id)throws Dato_No_Encontrado_Exeption{
        servicioGestor.eliminar(id);
    }
    public Servicio buscarServicio(int id)throws Dato_No_Encontrado_Exeption {
       return servicioGestor.buscar(id);
    }

    public void actualizarServicio(int id,Servicio s)throws Dato_No_Encontrado_Exeption{
        servicioGestor.actualizar(s,id);
    }

   public void mostrarHabitaciones(){
        for (Habitacion h:habitacionGestor.getLista()){
            System.out.println(h.toString());
        }
   }

   public void mostrarServicios(){
        for (Servicio s:servicioGestor.getLista()){
            System.out.println(s.toString());
        }
   }

   public double calcularSueldo(Empleado e){
        double total=e.getSalarioBase();
        for (Servicio s:servicioGestor.getLista()){
            for (EmpleadoServicio es:s.getEmpleadosxServicio()){
                if(es.getEmpleado().getId()==e.getId()){
                    total+=es.getSalario_adicional();
                }
            }
        }
        return total;
   }
}
