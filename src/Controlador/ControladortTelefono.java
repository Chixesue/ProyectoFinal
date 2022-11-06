package Controlador;

import Conector.Conector;
import Conector.SQL;
import Modelo.ModeloTelefono;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladortTelefono implements ActionListener{

    ModeloTelefono ModeloT;
    PreparedStatement ps;
    ResultSet resultado;
    Conector conector = new Conector();
    SQL sql = new SQL();

    public ControladortTelefono(ModeloTelefono ModeloT) {
        this.ModeloT = ModeloT;
    }
    
  
    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getActionCommand().equals(ModeloT.getVistaT().bntGrabar.getActionCommand())){
    if(!InsertarNIT()){
        conector.mensaje("Se inserto la informacion con exito!","Felicidades", 1);
        limpiar();
    } else{
        conector.mensaje("Hubo un error en la conexion, Intentelo de nuevo","Error", 0);
    }       
} else if (e.getActionCommand().equals(ModeloT.getVistaT().btnEliminar.getActionCommand())){
    if(!EliminarNIT()){
        conector.mensaje("Se Elimino la informacion con exito!", "Felicidades", 1);
        
        limpiar();
    }else {
        conector.mensaje("Hubo un error en la conexion, Intente Nuevamente", "Error", 0);
    }
} else if (e.getActionCommand().equals(ModeloT.getVistaT().btnSalir.getActionCommand())){
    Salir();
}
    
    }
   
  public boolean InsertarNIT(){
  boolean resultado; 
  try{
      conector.conectar();
      ps = (PreparedStatement) conector.preparar(sql.getAgregarNIT());
      ps.setString(1,ModeloT.getVistaT().txtNit.getText());
      ps.setString(2,ModeloT.getVistaT().txtOficina.getText());
      ps.setString(3,ModeloT.getVistaT().txtCelular.getText());
      ps.setString(4,ModeloT.getVistaT().txtCasa.getText());
      ps.setString(5,ModeloT.getVistaT().txtConta.getText());
      ps.setString(6,ModeloT.getVistaT().txtCompras.getText());
      ps.setString(7,ModeloT.getVistaT().txtPagos.getText());
      resultado = ps.execute();
  } catch (SQLException ex){
      resultado = true;
  }
  conector.desconectar();
  return  resultado;
  }  
  
  public boolean EliminarNIT(){
    boolean resultado;
    try{
    conector.conectar();
    ps = (PreparedStatement) conector.preparar(sql.getEliminarNIT());
    ps.setString(1, ModeloT.getVistaT().txtNit.getText());
    resultado = ps.execute();
    } catch (SQLException ex){
        resultado = true;
    }
    conector.desconectar();
    return resultado; 
  }
  
  
  
  
  public void limpiar(){
      ModeloT.getVistaT().txtCasa.setText("");
      ModeloT.getVistaT().txtCelular.setText("");
      ModeloT.getVistaT().txtCompras.setText("");
      ModeloT.getVistaT().txtConta.setText("");
       ModeloT.getVistaT().txtNit.setText("");
      ModeloT.getVistaT().txtOficina.setText("");
      ModeloT.getVistaT().txtPagos.setText("");
  }
  
  public void Salir(){
 ModeloT.getVistaT().dispose();
  }
  
  
}
