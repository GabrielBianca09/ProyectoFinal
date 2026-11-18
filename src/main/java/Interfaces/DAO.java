package Interfaces;

import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Error_De_Acceso_A_Datos_Exeption;

import java.util.List;
//se usa para la persistencia de jdbc.
public interface DAO <T>{
   void agregar(T element)throws Error_De_Acceso_A_Datos_Exeption;
   void actualizar(T element, int id)throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption;
   void eliminar(int id)throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption;
   T buscarPorId(int id)throws Error_De_Acceso_A_Datos_Exeption, Dato_No_Encontrado_Exeption;
   List<T> listar()throws Error_De_Acceso_A_Datos_Exeption;
}
