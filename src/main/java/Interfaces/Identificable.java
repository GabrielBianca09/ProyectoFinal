package Interfaces;
//todas mis clases la implementan para que el gestor me permita buscar y actualizar todo lo que la implemente.
public interface Identificable {
    int getId();
    void actualizarDatos(Identificable NuevosDatos);
}
