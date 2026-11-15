package gestores;

import Clases.Hotel.Hotel;
import Clases.Hotel.Servicios.EmpleadoServicio;
import Clases.Hotel.Servicios.Servicio;
import Clases.Hotel.Servicios.Servicios_X_Cliente;
import Clases.Persona.Empleados.Empleado;
import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Clases.Hotel.Reservas.Reserva;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;

public class GestorHotel {
    private Gestor<Reserva>reservaGestor;
    private Gestor<Habitacion>habitacionGestor;
    private Gestor<Pasajero>huespedes;
    private Gestor<Empleado>empleadoGestor;
    private Gestor<Servicio>servicioGestor;
    private Gestor<Hotel>hoteles;
    private Gestor<Servicios_X_Cliente>serviciosXClienteGestor;

    public GestorHotel() {
        this.empleadoGestor =new Gestor<Empleado>();
        this.habitacionGestor =new Gestor<Habitacion>();
        this.huespedes =new Gestor<Pasajero>();
        this.reservaGestor =new Gestor<Reserva>();
        this.servicioGestor=new Gestor<Servicio>();
        this.hoteles=new Gestor<Hotel>();
        this.serviciosXClienteGestor=new Gestor<Servicios_X_Cliente>();
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



    public Habitacion buscarHabitacion(int id)throws Dato_No_Encontrado_Exeption {
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

    public void actualizarHotel(int id,Hotel h)throws Datos_Duplicados_Exeption,Dato_No_Encontrado_Exeption{
        hoteles.actualizar(h,id);
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

        public void agregarHotel(Hotel h)throws Datos_Duplicados_Exeption{
        hoteles.agregar(h);
    }

    public Hotel BuscarHotel(int id)throws Dato_No_Encontrado_Exeption{
        return hoteles.buscar(id);
    }

    public void eliminarHotel(int id)throws Dato_No_Encontrado_Exeption{
        Hotel h=hoteles.buscar(id);
        hoteles.eliminar(id);
    }

    public boolean existeHabitacion(int id)throws Dato_No_Encontrado_Exeption{
        for (Habitacion h:habitacionGestor.getLista()){
            if(h.getId()==id){
                return true;
            }
        }
        return false;
    }

    public boolean existeHotel(int id)throws Dato_No_Encontrado_Exeption{
        for (Hotel h:hoteles.getLista()){
            if(h.getId()==id){
                return true;
            }
        }
        return false;
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

   public void mostrarhuespedes(){
        for (Pasajero p:huespedes.getLista()){
            System.out.println(p.toString());
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

   public void listarHoteles(){
        for (Hotel h:hoteles.getLista()){
            System.out.println(h.toString());
        }
   }

   public boolean existePasajero(int id){
        for (Pasajero p:huespedes.getLista()){
            if(p.getId()==id){
                return true;
            }
        }
        return false;
   }

   public Pasajero buscarPasajero(int id)throws Dato_No_Encontrado_Exeption{
        for (Pasajero p:huespedes.getLista()){
            if(p.getId()==id){
                return p;
            }
        }
        throw new Dato_No_Encontrado_Exeption(id);
   }



    public Gestor<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(Gestor<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public void mostrarEmpleados(){
        for (Empleado e:getEmpleadoGestor().getLista()){
            System.out.println(e.toString());
        }
    }

    public void mostrarReservas(){
        for (Reserva r:getReservaGestor().getLista()){
            System.out.println(r.toString());
        }
    }

    public void agregarServicioCliente(Servicios_X_Cliente s)throws Datos_Duplicados_Exeption{
        serviciosXClienteGestor.agregar(s);
    }

    public Servicios_X_Cliente buscarServicioCliente(int id)throws Dato_No_Encontrado_Exeption{
        for (Servicios_X_Cliente s:serviciosXClienteGestor.getLista()){
            if(s.getId()==id){
                return s;
            }
        }
        throw new Dato_No_Encontrado_Exeption(id);
    }

    public void EliminarServicioCliente(int id)throws Dato_No_Encontrado_Exeption{
        Servicios_X_Cliente buscar=serviciosXClienteGestor.buscar(id);
        serviciosXClienteGestor.eliminar(id);
    }


    public void mostrarServiciosCliente(){
        for (Servicios_X_Cliente s:serviciosXClienteGestor.getLista()){
            System.out.println(s);
        }
    }

    public void agregarConsumo(int idRegistro, int idServicio)
            throws Dato_No_Encontrado_Exeption, Datos_Invalidos_Exeption {
        if (idRegistro < 0 || idServicio < 0) {
            throw new Datos_Invalidos_Exeption("los id no pueden ser negativos");
        }
        Servicios_X_Cliente registro = serviciosXClienteGestor.buscar(idRegistro);
        Servicio servicio = servicioGestor.buscar(idServicio);
        registro.agregarConsumo(servicio);
    }


}
