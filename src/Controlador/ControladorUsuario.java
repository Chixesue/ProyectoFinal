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

//@Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand().equals(modelo.getVistaUs().btnGuardarUs.getActionCommand())) {
//            if (modelo.getVistaUs().txtUsuario.getText().isEmpty() || modelo.getVistaUs().txtNombreUs.getText().isEmpty()
//                    || modelo.getVistaUs().txtPassword.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Usuario, Nombre o Password no pueden estar vacios");
//
// 
//
//            } else if (modelo.getVistaUs().txtPassword.getText().equals(modelo.getVistaUs().txtPassword2.getText())) {
//                insertarUsuario();
//                conector.mensaje("Se inserto el usuario " + modelo.getVistaUs().txtUsuario.getText() + " con exito", "Exito!", 1);
//                limpiarCampos();
//            } else {
//                conector.mensaje("Las contraseñas ingresadas no coinciden", "Error", 2);
//            }
//        }
//        if (e.getActionCommand().equals(modelo.getVistaUs().btnEliminar.getActionCommand())) {
//            if (!eliminarUsuario()) {
//                conector.mensaje("Se Elimino el usuario " + modelo.getVistaUs().txtUsuario.getText() + " con exito", "Exito!", 1);
//                limpiarCampos();
//            } else {
//                conector.mensaje("A ocurrido un error, no se elimino el usuario", "Error", 2);
//            }
//        }    
      
    
    
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
        if (e.getActionCommand().equals(modelo.getVistaUs().btnEliminar.getActionCommand())) {
            if (!eliminarUsuario()) {
                conector.mensaje("Se Elimino el usuario " + modelo.getVistaUs().txtUsuario.getText() + " con exito", "Exito!", 1);
                limpiarCampos();
            } else {
                conector.mensaje("A ocurrido un error, no se elimino el usuario", "Error", 2);
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
        String codigo = obtenerCodigo();
        Conector conector = new Conector();
        boolean res;
        try {
            ps = conector.preparar(sql.getInsertarUsuario());
            ps.setString(1,modelo.getVistaUs().txtUsuario.getText());
            ps.setString(2,modelo.getVistaUs().txtNombreUs.getText());
            ps.setString(3,modelo.getVistaUs().txtDireccionUs.getText());
            ps.setString(4,modelo.getVistaUs().txtTelefonoUs.getText());
            ps.setString(5,String.valueOf(modelo.getVistaUs().txtPassword.getPassword()));
            ps.setString(6, codigo);
            res = ps.execute();
            conector.desconectar();
        } catch (SQLException ex) {
            conector.mensaje("ERROR AL INSERTAR USUARIO" +  ex.getMessage(), codigo, 0);
            conector.desconectar();
            res = true;
        }
        conector.desconectar();
        return res;
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
    
    public String obtenerCodigo(){
        Conector conector = new Conector();
        String codigo = "";
        try {           
            ps = conector.preparar(sql.getObtenerCodigo());
            ps.setString(1, modelo.getVistaUs().cmbNivel.getSelectedItem().toString());
            resultado = ps.executeQuery();
            while(resultado.next()){
                codigo = resultado.getString(1);
            }
            conector.desconectar();
        } catch (SQLException ex) {
            conector.mensaje("Error al obtener Código" + ex.getMessage(), "Error", 0);
            conector.desconectar();
        }        
        return codigo;
    }
    
    public boolean eliminarUsuario(){
        boolean resultado;
        try {
            ps = conector.preparar(sql.getEliminarUsuario());
            ps.setString(1, modelo.getVistaUs().txtUsuario.getText());
            resultado = ps.execute();            
        } catch (SQLException ex) {
            conector.mensaje("Usuario no puedo ser eliminado", "Error eliminar Usuario", 0);        
        } 
        conector.desconectar();
        return false;
    }
 
    public void limpiarCampos(){
        modelo.getVistaUs().txtUsuario.setText("");
        modelo.getVistaUs().txtNombreUs.setText("");
        modelo.getVistaUs().txtDireccionUs.setText("");
        modelo.getVistaUs().txtTelefonoUs.setText("");
        modelo.getVistaUs().txtPassword.setText("");        
    }
    
}
