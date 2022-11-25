
package Conector;


public class SQLInventario {

    // AGREGAR PRODUCTO
    private final String GrabarProducto = "insert into Inventario (Codigo,Nombre,Unidades,PrecCosto,PrecVenta,Descripcion)"
               + "values(?,?,?,?,?,?);";

    
    public String getGrabarProducto() {
        return GrabarProducto;
    }
    
    
}
