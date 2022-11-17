package Controlador;

import Conector.Conector;
import Conector.SQL;
import Modelo.ModelosUsuario;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

public class ControladorUsuario implements ActionListener, WindowListener{
    
    ModelosUsuario modelo;
    SQL sql = new SQL();
    Conector conector = new Conector();
    PreparedStatement ps;
    ResultSet resultado;
    
    public ControladorUsuario(ModelosUsuario modelo){
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(modelo.getVistaUs().btnGuardarUs.getActionCommand())){
            if(!insertarUsuario()){
                conector.mensaje("Se inserto el Usuario", "Exito!", 1);
                limpiarCampos();
            }else {
                conector.mensaje("A ocurrido un error", "Error", 1);
            }

        }   
    } 
    
    @Override
    public void windowOpened(WindowEvent e) {
        if(e.getComponent().equals(modelo.getVistaUs())){
            modelo.getVistaUs().cmbNivel.setModel(mostrarRol());
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
       
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
       
    }
    
    public boolean insertarUsuario(){
        boolean resultado;
        try {
            conector.conectar();
            ps = (PreparedStatement) conector.preparar(sql.getInsertarUsuario());
            ps.setString(1,modelo.getVistaUs().txtUsuario.getText());
            ps.setString(2,modelo.getVistaUs().txtNombreUs.getText());
            ps.setString(3,modelo.getVistaUs().txtDireccionUs.getText());
            ps.setString(4,modelo.getVistaUs().txtTelefonoUs.getText());
            ps.setString(5,modelo.getVistaUs().txtPassword.getText());
            resultado = ps.execute();
            
        } catch (SQLException ex) {
            resultado = true;
            
        }
        conector.desconectar();
        return resultado;
    }
    
    public DefaultComboBoxModel mostrarRol(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();        
        try {
            ps = conector.preparar(sql.getObtenerRol());
            resultado = ps.executeQuery();
            while (resultado.next()){
                modelo.addElement(resultado.getString(1));
            }            
            conector.desconectar();
        } catch (SQLException ex) {
            conector.mensaje("ERROR CARGAR NIVEL DE USUARIOS", "ERROR NIVEL USUARIO", 0);
            conector.desconectar();
        }
        return modelo;
    }
    
    public void limpiarCampos(){
        modelo.getVistaUs().txtUsuario.setText("");
        modelo.getVistaUs().txtNombreUs.setText("");
        modelo.getVistaUs().txtDireccionUs.setText("");
        modelo.getVistaUs().txtTelefonoUs.setText("");
        modelo.getVistaUs().txtPassword.setText("");        
    }
    
}
