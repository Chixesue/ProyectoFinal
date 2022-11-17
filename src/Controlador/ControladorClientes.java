package Controlador;

import Conector.Conector;
import Conector.SQLClientes;
import Modelo.ModeloClientes;
import Vistas.VistaClientes;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class ControladorClientes implements ActionListener, KeyListener, FocusListener{
    
    ModeloClientes modeloC;
    VistaClientes vistaC;
    SQLClientes sql = new SQLClientes();
    Conector conector = new Conector();
    PreparedStatement ps;
    ResultSet resultado;

    public ControladorClientes(ModeloClientes modeloC, VistaClientes vistaC) {
        this.modeloC = modeloC;
        this.vistaC = vistaC;
    }

    public ControladorClientes(ModeloClientes modeloC) {
        this.modeloC = modeloC;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(modeloC.getVistaC().btnBuscar.getActionCommand())){
           modeloC.setModeloTabla(llenarModelo());
       }else if  (e.getActionCommand().equals(modeloC.getVistaC().btnGrabar.getActionCommand())) {
            if (!GrabarCliente()) {
                conector.mensaje("Se grabo la informacion con exito!", "Felicidades", 1);
                limpiar();
       
            } else {
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
        } else if (e.getActionCommand().equals(modeloC.getVistaC().btnActualizar.getActionCommand())) {
            if(!actualizarCliente()){
                conector.mensaje("Se actualizo la informacion con exito!", "Felicidades", 1);
       
                limpiar();
            }else{
                conector.mensaje("Hubo un error en la conexion, intente nuevamente", "Error", 0);
            }
            
        } else if (e.getActionCommand().equals(modeloC.getVistaC().btnLimpiar.getActionCommand())) {
            limpiar();
        }
    }
    
    public DefaultTableModel llenarModelo() {
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            modelo.setColumnIdentifiers(new Object[]{"NIT","Nombre","Direccion","Correo","Telefono"});
            if(this.modeloC.getVistaC().txtNit.getText().isEmpty()){
                ps = (PreparedStatement) conector.preparar("SELECT * FROM Clientes");
            }else{
                ps = (PreparedStatement) conector.preparar("SELECT * FROM Clientes where NIT LIKE ?");
                ps.setString(1, "%" + this.modeloC.getVistaC().txtNit.getText()+ "%");
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

    public boolean GrabarCliente() {
        boolean resultado;
        try{
            conector.conectar();
            ps = (PreparedStatement) conector.preparar(sql.getGrabarCliente());
            ps.setString(1, modeloC.getVistaC().txtNit.getText());
            ps.setString(2, modeloC.getVistaC().txtNombre.getText());
            ps.setString(3, modeloC.getVistaC().txtDireccion.getText());
            ps.setString(4, modeloC.getVistaC().txtCorreo.getText());
            ps.setString(5, modeloC.getVistaC().txtTelefono.getText());
            resultado = ps.execute();
        }catch (SQLException ex){
            resultado = true;
        }
        conector.desconectar();
        return resultado;
    }

    public boolean actualizarCliente() {
        boolean resultado;
        try{
            conector.conectar();
            ps = (PreparedStatement) conector.preparar(sql.getActualizarCliente());
            ps.setString(1, modeloC.getVistaC().txtNombre.getText());
            ps.setString(2, modeloC.getVistaC().txtDireccion.getText());
            ps.setString(3, modeloC.getVistaC().txtCorreo.getText());
            ps.setString(4, modeloC.getVistaC().txtTelefono.getText());
            ps.setString(5, modeloC.getVistaC().txtNit.getText());
            resultado = ps.execute();
        }catch (SQLException ex){
            resultado = true;
        }
        conector.desconectar();
        return resultado;
    }

    public void limpiar() {
        modeloC.getVistaC().txtNit.setText("");
        modeloC.getVistaC().txtNombre.setText("");
        modeloC.getVistaC().txtDireccion.setText("");
        modeloC.getVistaC().txtCorreo.setText("");
        modeloC.getVistaC().txtTelefono.setText("");
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
        if(e.getComponent().equals(modeloC.getVistaC().txtNit)){
            this.modeloC.setModeloTabla(llenarModelo());
        }
    }
}
