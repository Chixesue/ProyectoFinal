
package Controlador;

import Conector.Conector;
import Conector.SQLInventario;
import Modelo.ModeloInventario;
import Vistas.VistaInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class ControladorInventario implements ActionListener, FocusListener {

    Conector conector = new Conector();
    SQLInventario sql = new SQLInventario();
    ModeloInventario ModeloI;
    VistaInventario VistaI;
    PreparedStatement ps;
    ResultSet resultado;   

    String Codigo;
    JButton boton1;
    
    public ControladorInventario(ModeloInventario ModeloI, VistaInventario VistaI){
        this.ModeloI = ModeloI;
        this.VistaI = VistaI;
    }   
    
    public ControladorInventario(ModeloInventario ModeloI) {
        this.ModeloI = ModeloI;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ModeloI.getVistaI().btnActualizar.getActionCommand())){
            ModeloI.setModeloTabla(llenarModelo());
        } 
        
        if(e.getActionCommand().equals(ModeloI.getVistaI().btnGrabar.getActionCommand())){
            System.out.println("INGRESA AL BOTON");
            if (!GrabarProducto()){
                conector.mensaje("Se agregro correctamente el Producto", "INGRESO EL PRODUCTO", 1);
                Limpiar();
            } else {
                conector.mensaje("Se produjo un Error, intente de nuevo", "ERROR AL GRABAR", 0);
            }                    
        }               
    }
    
    public boolean GrabarProducto(){
        boolean resultado = false;
        try {
            System.out.println("INGRESA AL BOTON GRABAR");
            ps = conector.preparar(sql.getGrabarProducto());
            ps.setString(1, ModeloI.getVistaI().txtCodProd.getText());
            ps.setString(2, ModeloI.getVistaI().txtNomProd.getText());  
            ps.setDouble(3, Double.valueOf(ModeloI.getVistaI().txtUnidades.getText()));
            ps.setDouble(4, Double.valueOf(ModeloI.getVistaI().txtPrecioCosto.getText()));
            ps.setDouble(5, Double.valueOf(ModeloI.getVistaI().txtPrecioVta.getText()));
            ps.setString(6, ModeloI.getVistaI().txtDescrip.getText());
            resultado = ps.execute();
            conector.desconectar();            
            Limpiar();
        } catch (SQLException ex) {
            conector.mensaje("No se puedo grabar el producto, verifique" +  ex.getMessage(), "ERROR GRABAR", 0);
            conector.desconectar(); 
            Limpiar();
        }
        conector.desconectar();
        return resultado;
    }
    
    public DefaultTableModel llenarModelo(){
        DefaultTableModel modeloT = new DefaultTableModel();        
        try {
            modeloT.setColumnIdentifiers(new Object[]{"codigo","Nombre","Unidades","PreCosto","PrecVenta"});
            if(this.ModeloI.getVistaI().txtCodProd.getText().isEmpty()){
                ps = conector.preparar("SELECT Codigo, Nombre, Unidades, PrecCosto, PrecVenta FROM Inventario");
            } else {
                ps = conector.preparar("SELECT * FROM where Codigo LIKE ?");
                ps.setString(1, "%" + this.ModeloI.getVistaI().txtCodProd.getText()+ "%");
            }
            resultado = ps.executeQuery();
            while(resultado.next()){
                modeloT.addRow(new Object[]{resultado.getString(1),resultado.getString(2),
                    resultado.getString(3), resultado.getString(4),resultado.getString(5)});
            }
        } catch (SQLException e) {
            conector.mensaje("No genera Tabla Model" + e.getMessage(), "ERRO TABLA MODEL", 0);
        }        
        return modeloT;        
    }
      
    public void Limpiar(){
        ModeloI.getVistaI().txtCodProd.setText("");
        ModeloI.getVistaI().txtNomProd.setText("");
        ModeloI.getVistaI().txtUnidades.setText("");
        ModeloI.getVistaI().txtPrecioCosto.setText("");
        ModeloI.getVistaI().txtPrecioVta.setText("");
        ModeloI.getVistaI().txtDescrip.setText("");
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getComponent().equals(ModeloI.getVistaI().txtCodProd)){
            this.ModeloI.setModeloTabla(llenarModelo());            
        }
    } 
}
