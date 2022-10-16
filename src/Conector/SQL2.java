package Conector;

public class SQL2 {
    private final String validarUsuario = "SELECT * FROM Usuario WHERE Usuario = ? AND Passw = ?;";
    private final String validarNivelRol = "SELECT Descripcion FROM Rol WHERE NivelRol = ?;";
    
    private final String grabarCliente = "INSERT INTO Clientes(NIT,Nombre,Direccion,Correo,Telefono) VALUES(?,?,?,?,?);";
    private final String actualizarCliente = "UPDATE Clientes SET Nit= ?, Nombre= ?, Direccion= ?"
    + "Correo= ?, Telefono= ?";

    /**     
    * SELECT * FROM      * Retorna los datos de * si existen de la BBDD 
    * @return ResulSet con todos los datos de      
    */
    public String getGrabarCliente() {
        return grabarCliente;
    }
    
    /**     
     * SELECT * FROM      
     * Retorna los datos de 
     * si existen de la BBDD -- @return ResulSet con todos los datos de      
     * @return 
     */
    
    public String getActualizarCliente() {
        return actualizarCliente;
    }


    public SQL2() {
    }
    
    /**
     * SELECT * FROM Usuario WHERE Usuario = ? AND Passw = ?
     * Retorna los datos de usuario y password si existen de la BBDD
     * @return ResultSet con todos los datos de Usuario y password
     */
    public String getValidarUsuario() {
        return validarUsuario;
    }
    
    /**
     * SELECT * FROM Rol WHERE NivelRol = ?
     * Retorna los datos de Nivel rol si existen de la BBDD
     * @return ResulSet con todos los datos de NivelRol
     */
    public String getValidarNivelRol() {
        return validarNivelRol;
    }
    
    
    
    
}
