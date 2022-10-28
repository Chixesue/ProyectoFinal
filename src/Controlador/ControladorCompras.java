package Controlador;

import Conector.Conector;
import Conector.SQLCompras;
import Modelo.ModeloCompras;
import Vistas.VistaCompras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;

public class ControladorCompras implements ActionListener, FocusListener{
    
    ModeloCompras modeloCo;
    VistaCompras vistaCo;
    SQLCompras sql = new SQLCompras();
    Conector conector = new Conector();
    PreparedStatement ps;
    ResultSet resultado;

    public ControladorCompras(ModeloCompras modeloCO, VistaCompras vistaCo) {
        this.modeloCo = modeloCO;
        this.vistaCo = vistaCo;
    }

    public ControladorCompras(ModeloCompras modeloCO) {
        this.modeloCo = modeloCO;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(modeloCo.getVistaCo().btnBuscarCliente.getActionCommand())){
           GuardarDatosClientes(modeloCo.getVistaCo().txtNitCompras);
       }if(e.getActionCommand().equals(modeloCo.getVistaCo().btnBuscarProducto.getActionCommand())){
           GuardarDatosProducto(modeloCo.getVistaCo().txtCodProducto);
       }else if  (e.getActionCommand().equals(modeloCo.getVistaCo().btnAgregar.getActionCommand())) {
            if (!GrabarCompra()) {
                conector.mensaje("Se grabo la informacion con exito!", "Felicidades", 1);
                limpiar();
       
            } else {
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
        } else if (e.getActionCommand().equals(modeloCo.getVistaCo().btnEditar.getActionCommand())) {
            if(!actualizarCompra()){
                conector.mensaje("Se actualizo la informacion con exito!", "Felicidades", 1);
                limpiar();
            }else{
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
            
        } else if (e.getActionCommand().equals(modeloCo.getVistaCo().btnEliminar.getActionCommand())) {
            if(!eliminarCompra()){
                conector.mensaje("Se elimino la informacion con exito ", "Felicidades", 0);
                limpiar();
            }else{
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
        }else if (e.getActionCommand().equals(modeloCo.getVistaCo().btnBuscarCliente.getActionCommand())) {
            if(!BuscarCliente()){
                conector.mensaje("Se elimino la informacion con exito ", "Felicidades", 0);
                limpiar();
            }else{
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
        }else if (e.getActionCommand().equals(modeloCo.getVistaCo().btnBuscarProducto.getActionCommand())) {
            if(!BuscarProducto()){
                conector.mensaje("Se elimino la informacion con exito ", "Felicidades", 0);
                limpiar();
            }else{
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
        }
        
    }
    
    private void GuardarDatosClientes(JTextField txtNitCompras) {
        try{
            conector.conectar();
            ps = (PreparedStatement) conector.preparar(sql.getValidarClienteCompras());
            ps.setString(1, txtNitCompras.getText());
            this.resultado = ps.executeQuery();
            while(resultado.next()){
                modeloCo.getVistaCo().txtNombrecCompras.setText(resultado.getString(2));
                modeloCo.getVistaCo().txtTelefonoCompras.setText(resultado.getString(5));
                modeloCo.getVistaCo().txtCorreoCompras.setText(resultado.getString(4));
                modeloCo.getVistaCo().txtDireccionCompras.setText(resultado.getString(3));
            }
        }catch(SQLException ex){
        }
        conector.desconectar();
    }
    private void GuardarDatosProducto(JTextField txtCodProducto) {
        try{
            conector.conectar();
            ps = (PreparedStatement) conector.preparar(sql.getValidarProductoCompras());
            ps.setString(1, txtCodProducto.getText());
            this.resultado = ps.executeQuery();
            while(resultado.next()){
                modeloCo.getVistaCo().txtNombrePCompras.setText(resultado.getString(2));
                modeloCo.getVistaCo().txtUniades.setText(resultado.getString(3));
                modeloCo.getVistaCo().txtPrecCosto.setText(resultado.getString(4));
                modeloCo.getVistaCo().txtPrecVenta.setText(resultado.getString(5));
                modeloCo.getVistaCo().txtDescripcion.setText(resultado.getString(6));
            }
        }catch(SQLException ex){
        }
        conector.desconectar();
    }

    private boolean GrabarCompra() {
       return GrabarCompra(); 
    }

    private void limpiar() {
        modeloCo.getVistaCo().txtNitCompras.setText("");
        modeloCo.getVistaCo().txtTelefonoCompras.setText("");
        modeloCo.getVistaCo().txtCorreoCompras.setText("");
        modeloCo.getVistaCo().txtDireccionCompras.setText("");
        modeloCo.getVistaCo().txtNombrePCompras.setText("");
        modeloCo.getVistaCo().txtUniades.setText("");
        modeloCo.getVistaCo().txtPrecCosto.setText("");
        modeloCo.getVistaCo().txtPrecVenta.setText("");
        modeloCo.getVistaCo().txtDescripcion.setText("");
        modeloCo.getVistaCo().txtNitCompras.setText("");
    }

    private boolean actualizarCompra() {
        return GrabarCompra();
    }

    private boolean eliminarCompra() {
        return GrabarCompra();
    }

    private void LlenarProveedor() {
        
    }
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    

    private boolean BuscarCliente() {
        return BuscarCliente();
    }

    private boolean BuscarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String VoyAtomarAgua ;

    

    

    

    
    
}
