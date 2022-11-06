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
            /*if (!AgregarTabla()) {
                conector.mensaje("Se grabo la informacion con exito!", "Felicidades", 1);
                
       
            } else {
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }*/
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
                conector.mensaje("Se busco el cliente con exito ", "Felicidades", 0);
            }else{
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
        }else if (e.getActionCommand().equals(modeloCo.getVistaCo().btnBuscarProducto.getActionCommand())) {
            if(!BuscarProducto()){
                conector.mensaje("Se Buscó el producto con exito ", "Felicidades", 0);
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
                modeloCo.getVistaCo().txtUnidades.setText(resultado.getString(3));
                modeloCo.getVistaCo().txtPrecCosto.setText(resultado.getString(4));
                modeloCo.getVistaCo().txtDescripcion.setText(resultado.getString(6));
            }
        }catch(SQLException ex){
        }
        conector.desconectar();
    }

    private boolean AgregarTabla() {
        /*String []Encabezado = new String[5];
        String []Detalle = new String[5];
        
        Encabezado[0] = modeloCo.getVistaCo().txtID.getText();
        modeloCo.getVistaCo().txtID.setText(null);
        Encabezado[1] = modeloCo.getVistaCo().txtNoSerie.getText();
        modeloCo.getVistaCo().txtNoSerie.setText(null);
        Encabezado[2] = modeloCo.getVistaCo().txtNoFactura.getText();
        modeloCo.getVistaCo().txtNoFactura.setText(null);
        Encabezado[3] = modeloCo.getVistaCo().txtFecha.getText();
        modeloCo.getVistaCo().txtFecha.setText(null);
        Encabezado[4] = modeloCo.getVistaCo().txtNitCompras.getText();
        modeloCo.getVistaCo().txtNitCompras.setText(null);
        
        Detalle[0] = modeloCo.getVistaCo().txtCodProducto.getText();
        modeloCo.getVistaCo().txtCodProducto.setText(null);
        Detalle[1] = modeloCo.getVistaCo().txtNombrePCompras.getText();
        modeloCo.getVistaCo().txtNombrePCompras.setText(null);
        Detalle[2] = modeloCo.getVistaCo().txtUnidades.getText();
        modeloCo.getVistaCo().txtUnidades.setText(null);
        Detalle[3] = modeloCo.getVistaCo().txtPrecCosto.getText();
        modeloCo.getVistaCo().txtPrecCosto.setText(null);
        Detalle[4] = modeloCo.getVistaCo().txtDescripcion.getText();
        modeloCo.getVistaCo().txtDescripcion.setText(null);
        
        modeloCo.modeloTabla.addRow(Encabezado);
        modeloCo.modeloTabla.addRow(Detalle);*/
        return false;
        
    }

    private void limpiar() {
        modeloCo.getVistaCo().txtNitCompras.setText("");
        modeloCo.getVistaCo().txtTelefonoCompras.setText("");
        modeloCo.getVistaCo().txtCorreoCompras.setText("");
        modeloCo.getVistaCo().txtDireccionCompras.setText("");
        modeloCo.getVistaCo().txtNombrePCompras.setText("");
        modeloCo.getVistaCo().txtUnidades.setText("");
        modeloCo.getVistaCo().txtPrecCosto.setText("");
        modeloCo.getVistaCo().txtDescripcion.setText("");
        modeloCo.getVistaCo().txtNitCompras.setText("");
    }

    private boolean actualizarCompra() {
        return AgregarTabla();
    }

    private boolean eliminarCompra() {
        return AgregarTabla();
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
        return false;
    }

    private boolean BuscarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String VoyAtomarAgua ;

    

    

    

    
    
}
