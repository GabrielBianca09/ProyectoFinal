package Interfaces;

import Exepciones.DatoNoEncontrado;
import Exepciones.ErrorDeAcceso;

import java.util.List;

public interface DAO <T>{
   void agregar(T element)throws ErrorDeAcceso;
   void actualizar(T element)throws ErrorDeAcceso, DatoNoEncontrado;
   void eliminar(T element )throws ErrorDeAcceso,DatoNoEncontrado;
   T buscarPorId(int id)throws ErrorDeAcceso,DatoNoEncontrado;
   List<T> listar()throws ErrorDeAcceso;
}
