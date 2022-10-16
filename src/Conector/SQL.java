package Conector;

public class SQL {
  private final String validarUsuario = "SELECT * FROM Usuario WHERE Usuario = ? AND Passw = ?;";
  private final String validarNivelRol = "SELECT Descripcion FROM Rol WHERE NivelRol = ?;";
    
  private final String grabarCliente = "INSERT INTO Clientes(NIT,Nombre,Direccion,Correo,Telefono)  VALUES(?,?,?,?,?);";
  private final String actualizarCliente = "UPDATE Clientes SET Nit= ?, Nombre= ?, Direccion= ?"
    + "Correo= ?, Telefono= ?";
    
  private final String AgregarNIT = "INSERT INTO Telefonos(NIT,TelOficina,TelCelular,TelCasa,TelConta,TelCompras,TelPagos) VALUES(?,?,?,?,?,?,?);";
  private final String EliminarNIT ="DELETE FROM Telefonos WHERE Nit =?;";  
  
  private final String insertarUsuario = "INSERT INTO Usuario(Usuario,Nombre,Direccion,Telefono,Passw.Rol) VALUES(?,?,?,?,?,?);";
       
    
    
    
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
     */
    
    public String getActualizarCliente() {
        return actualizarCliente;
    }


    public SQL() {
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

    
    
    
    public String getAgregarNIT() {
        return AgregarNIT;
    }

    public String getEliminarNIT() {
        return EliminarNIT;
    }
    

    public String getInsertarUsuario() {
        return insertarUsuario;
    }
    
    
    
    
}
