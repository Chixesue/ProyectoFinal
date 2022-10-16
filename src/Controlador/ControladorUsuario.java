package Controlador;

import Conector.Conector;
import Conector.SQL;
import Modelo.ModelosUsuario;
import Vistas.VistaUsuarios;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorUsuario implements ActionListener{
    
    ModelosUsuario modelo;
    VistaUsuarios vista;
    SQL sql = new SQL();
    Conector conector = new Conector();
    PreparedStatement ps;
    ResultSet resultado;

    public ControladorUsuario(ModelosUsuario modelo, VistaUsuarios vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    
    
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
    
    public void limpiarCampos(){
        modelo.getVistaUs().txtUsuario.setText("");
        modelo.getVistaUs().txtNombreUs.setText("");
        modelo.getVistaUs().txtDireccionUs.setText("");
        modelo.getVistaUs().txtTelefonoUs.setText("");
        modelo.getVistaUs().txtPassword.setText("");
        
    }
    
}
