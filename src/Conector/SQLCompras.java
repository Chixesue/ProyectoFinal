package Conector;

public class SQLCompras {
    
    private final String ValidarClienteCompras = "SELECT * FROM Clientes WHERE NIT = ?";
    private final String ValidarProductoCompras = "SELECT * FROM Inventario WHERE Codigo = ?";
  
    /**     
    * SELECT * FROM Clientes WHERE NIT =?   
    * Retorna los datos de Clientes si existen de la BBDD 
    * @return ResulSet con todos los datos de Clientes    
    */
    public String getValidarClienteCompras() {
        return ValidarClienteCompras;
    }

    /**     
    * SELECT * FROM Inventario WHERE Codigo = ?
    * Retorna los datos de Inventario si existen de la BBDD 
    * @return ResulSet con todos los datos de Inventario    
    */
    public String getValidarProductoCompras() {
        return ValidarProductoCompras;
    }
}
