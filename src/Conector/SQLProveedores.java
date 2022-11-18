
package Conector;

public class SQLProveedores {
   

  private final String grabarProveedor = "INSERT INTO Proveedores(NIT,Nombre,Direccion,Correo,Telefono)  VALUES(?,?,?,?,?);";
  private final String eliminarProveedor = "DELETE FROM Proveedores WHERE Nit =?";
    
  
 
    public String getGrabarProveedor() {
        return grabarProveedor;
    }

    public String getEliminarProveedor() {
        return eliminarProveedor;
    }

 
    
    
}
