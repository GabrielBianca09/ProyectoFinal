package SQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Coneccion {
    private static String url="";
    private static String root="";
    private static String clave="";

    public static Connection objetenerConeccion(){
        return DriverManager.getConnection(url,root,clave);
    }
}
