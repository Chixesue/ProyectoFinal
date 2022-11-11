
package Conector;

public class SQLRol {
    
    private final String BuscarRol = "select Descripcion, NivelRol from Rol where CodigoRol = ? ";
    private final String GrabarRol = "insert into Rol values (?,?,?)";
    
    public String getBuscarRol() {
        return BuscarRol;
    }
    
    public String getGrabarRol(){
        return GrabarRol;
    }
    
    
}
