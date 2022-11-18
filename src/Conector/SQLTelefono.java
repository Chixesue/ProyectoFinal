package Conector;

public class SQLTelefono {
  
      private String AgregarNIT = "INSERT INTO Telefonos(NIT,TelOficina,TelCelular,TelCasa,TelConta,TelCompras,TelPagos) VALUES(?,?,?,?,?,?,?);";
      private String EliminarNIT ="DELETE FROM Telefonos WHERE Nit =?;";  
   
  
  
  public String getAgregarNIT() {
        return AgregarNIT;
    }

    public String getEliminarNIT() {
        return EliminarNIT;
    }

    
    
    
}
