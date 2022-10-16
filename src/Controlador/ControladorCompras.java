package Controlador;

import Conector.Conector;
import Conector.SQL;
import Modelo.ModeloCompras;
import Vistas.VistaCompras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ControladorCompras implements ActionListener, FocusListener{
    
    ModeloCompras modeloCo;
    VistaCompras vistaCo;
    SQL sql = new SQL();
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
        if(e.getActionCommand().equals(modeloCo.getVistaCo().btnBuscar.getActionCommand())){
           LlenarProveedor();
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
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }

    private DefaultTableModel llenarModelo() {
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            modelo.setColumnIdentifiers(new Object[]{"NIT","Fecha","Nombre","Codigo Producto",
                "Unidades","Descripcion"});
            if(this.modeloCo.getVistaCo().txtNit.getText().isEmpty()){
                ps = (PreparedStatement) conector.preparar("SELECT * FROM Compras");
            }else{
                ps = (PreparedStatement) conector.preparar("SELECT * FROM Compras where NIT LIKE ?");
                ps.setString(1, "%" + this.modeloCo.getVistaCo().txtNit.getText()+ "%");
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

    private boolean GrabarCompra() {
        
    }

    private void limpiar() {
        
    }

    private boolean actualizarCompra() {
        
    }

    private boolean eliminarCompra() {
        
    }

    private void LlenarProveedor() {
        
    }
    
}**/
