package Controlador;

import Conector.Conector;
import Conector.SQLProveedores;
import Modelo.ModeloProveedores;
import Vistas.VistaProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ControladorProveedores implements ActionListener, KeyListener, FocusListener{

    ModeloProveedores modeloP;
    VistaProveedores vistaP;
    SQLProveedores sql = new SQLProveedores();
    Conector conector = new Conector();
    PreparedStatement ps;
    ResultSet resultado;

    public ControladorProveedores(ModeloProveedores modeloP, VistaProveedores vistaP) {
        this.modeloP = modeloP;
        this.vistaP = vistaP;
    }

    public ControladorProveedores(ModeloProveedores modeloP) {
        this.modeloP = modeloP;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
 if(e.getActionCommand().equals(modeloP.getVistaP().btnBuscar.getActionCommand())){
           modeloP.setModeloTabla(llenarModelo());
       }else if  (e.getActionCommand().equals(modeloP.getVistaP().btnGrabar.getActionCommand())) {
            if (!GrabarProveedor()) {
                conector.mensaje("Se grabo la informacion con exito!", "Felicidades", 1);
                limpiar();
       
            } else {
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
        } else if (e.getActionCommand().equals(modeloP.getVistaP().btnEliminar.getActionCommand())) {
            if(!EliminarProveedor()){
                conector.mensaje("Se Elimino la informacion con exito!", "Felicidades", 1);
       
                limpiar();
            }else{
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
            
        } else if (e.getActionCommand().equals(modeloP.getVistaP().btnSalir.getActionCommand())) {
            Salir();
        }
    }
          
  public DefaultTableModel llenarModelo() {
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            modelo.setColumnIdentifiers(new Object[]{"NIT","Nombre","Direccion","Correo","Telefono"});
            if(this.modeloP.getVistaP().txtNit.getText().isEmpty()){
                ps = (PreparedStatement) conector.preparar("SELECT * FROM Proveedores");
            }else{
                ps = (PreparedStatement) conector.preparar("SELECT * FROM Proveedores where NIT LIKE ?");
                ps.setString(1, "%" + this.modeloP.getVistaP().txtNit.getText()+ "%");
            }
            resultado = ps.executeQuery();
            while(resultado.next()){
                modelo.addRow(new Object[]{resultado.getString(1),resultado.getString(2),
                    resultado.getString(3),resultado.getString(4),resultado.getString(5)});
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return modelo;
   }

    public boolean GrabarProveedor() {
        boolean resultado;
        try{
            conector.conectar();
            ps = (PreparedStatement) conector.preparar(sql.getGrabarProveedor());
            ps.setString(1, modeloP.getVistaP().txtNit.getText());
            ps.setString(2, modeloP.getVistaP().txtNombre.getText());
            ps.setString(3, modeloP.getVistaP().txtDireccion.getText());
            ps.setString(4, modeloP.getVistaP().txtCorreo.getText());
            ps.setString(5, modeloP.getVistaP().txtTelefono.getText());
            resultado = ps.execute();
        }catch (SQLException ex){
            resultado = true;
        }
        conector.desconectar();
        return resultado;
    }

    public boolean EliminarProveedor() {
   boolean resultado;
   try{
       conector.conectar();
       ps= conector.preparar(sql.getEliminarProveedor());
       ps.setString(1, modeloP.getVistaP().txtNit.getText());
       resultado = ps.execute();
   } catch (SQLException ex){
       resultado = true;
   }
   conector.desconectar();
   return resultado;
    }

    public void Salir() {
       modeloP.getVistaP().dispose();
    }  

       public void limpiar() {
        modeloP.getVistaP().txtNit.setText("");
        modeloP.getVistaP().txtNombre.setText("");
        modeloP.getVistaP().txtDireccion.setText("");
        modeloP.getVistaP().txtCorreo.setText("");
        modeloP.getVistaP().txtTelefono.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
   
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
   
    }

    @Override
    public void focusGained(FocusEvent e) {
    
    }

    @Override
    public void focusLost(FocusEvent e) {
     if (e.getComponent().equals(modeloP.getVistaP().txtNit)){
         this.modeloP.setModeloTabla(llenarModelo());
     }
    }
    
    
    
}
