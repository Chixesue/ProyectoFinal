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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
           BuscarDatosClientes(modeloCo.getVistaCo().txtNitCompras);
        }if(e.getActionCommand().equals(modeloCo.getVistaCo().btnBuscarProducto.getActionCommand())){
           BuscarDatosProducto(modeloCo.getVistaCo().txtCodProducto);
        /*}else if(e.getActionCommand().equals(modeloCo.getVistaCo().btnAgregar.getActionCommand())) {
            modeloCo.setModeloTabla(AgregarTabla());
        }else if(e.getActionCommand().equals(modeloCo.getVistaCo().btnEliminar.getActionCommand())) {
            modeloCo.setModeloTabla(eliminarCompra());*/
        }else if(e.getActionCommand().equals(modeloCo.getVistaCo().btnLimpiar.getActionCommand())) {
            limpiar(); 
        }
        
    }
    
    private void BuscarDatosClientes(JTextField txtNitCompras) {
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
    private void BuscarDatosProducto(JTextField txtCodProducto) {
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

    /*private DefaultTableModel AgregarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        
        String []Encabezado = new String[5];
        String []Detalle = new String[5];
        
        Encabezado[0] = modeloCo.getVistaCo().txtID.getText();
        Encabezado[1] = modeloCo.getVistaCo().txtNoSerie.getText();
        Encabezado[2] = modeloCo.getVistaCo().txtNoFactura.getText();
        Encabezado[3] = modeloCo.getVistaCo().txtFecha.getText();
        Encabezado[4] = modeloCo.getVistaCo().txtNitCompras.getText();
        
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
        
        modelo.addRow(Encabezado);
        modelo.addRow(Detalle);
        
        return modelo;
        
    }
    
    private DefaultTableModel eliminarCompra() {
        DefaultTableModel modelo = new DefaultTableModel();
        int filaSeleccinada = modeloCo.getVistaCo().tblCompras.getSelectedRow();
        if (filaSeleccinada>=0) {
            modelo.removeRow(filaSeleccinada);
        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado fila");
        }
        return modelo;
    }*/

    private void limpiar() {
        modeloCo.getVistaCo().txtID.setText("");
        modeloCo.getVistaCo().txtNoFactura.setText("");
        modeloCo.getVistaCo().txtNoSerie.setText("");
        modeloCo.getVistaCo().txtNitCompras.setText("");
        modeloCo.getVistaCo().txtNombrecCompras.setText("");
        modeloCo.getVistaCo().txtTelefonoCompras.setText("");
        modeloCo.getVistaCo().txtCorreoCompras.setText("");
        modeloCo.getVistaCo().txtDireccionCompras.setText("");
        modeloCo.getVistaCo().txtCodProducto.setText("");
        modeloCo.getVistaCo().txtNombrePCompras.setText("");
        modeloCo.getVistaCo().txtUnidades.setText("");
        modeloCo.getVistaCo().txtPrecCosto.setText("");
        modeloCo.getVistaCo().txtDescripcion.setText("");
        modeloCo.getVistaCo().txtNitCompras.setText("");
        modeloCo.getVistaCo().txtFecha.setText("");
    }

    
    
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    
}
