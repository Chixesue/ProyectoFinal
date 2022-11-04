
package Conector;

public class SQLRol {
    
    private final String BuscarRol = "select Descripcion, NivelRol from Rol where CodigoRol = ? ";
    
    
    public String getBuscarRol() {
        return BuscarRol;
    }
    
    
}
