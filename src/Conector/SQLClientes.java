
package Conector;

public class SQLClientes {
    
    private final String grabarCliente = "INSERT INTO Clientes(NIT,Nombre,Direccion,Correo,Telefono)  VALUES(?,?,?,?,?);";
    private final String actualizarCliente = "UPDATE Clientes SET Nombre= ?, Direccion= ?, Correo= ?, Telefono= ? WHERE NIT = ?";

    /**     
    * SELECT * FROM      
    * Retorna los datos de * si existen de la BBDD 
    * @return ResulSet con todos los datos de      
    */
    public String getGrabarCliente() {
        return grabarCliente;
    }
    
    /**     
     * SELECT * FROM      
     * Retorna los datos de * si existen de la BBDD -- 
     * @return ResulSet con todos los datos de      
     */
    
    public String getActualizarCliente() {
        return actualizarCliente;
    }
    
    
    
}
