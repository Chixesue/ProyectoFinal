package Controlador;

import Conector.Conector;
import Conector.SQL;
import Modelo.ModeloLogin;
import Vistas.VistaMenu;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;     
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener{
    
    ModeloLogin modelo;
    PreparedStatement ps;
    ResultSet resultado;
    Conector conector = new Conector();
    SQL sql = new SQL();
    public static String user;
    String pass;   

    public ControladorLogin(ModeloLogin modelo) {
        this.modelo = modelo;
    }
    
    public ControladorLogin(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(modelo.getVistaL().btnIngresar.getActionCommand())){
            if(validarDatos()){
                VistaMenu vistaM = new VistaMenu();
                vistaM.lblUsuarioM.setText("Usuario: " + modelo.getVistaL().txtUsuarioLogin.getText());
                vistaM.setVisible(true);
                modelo.getVistaL().dispose();
            }
        }
    }

    public boolean validarDatos() {
        boolean res = false;                 
        try {
            ps = (PreparedStatement) conector.preparar(sql.getValidarUsuario());
            ps.setString(1, modelo.getVistaL().txtUsuarioLogin.getText());
            ps.setString(2, String.valueOf(modelo.getVistaL().txtPassLogin.getPassword()));
            resultado = ps.executeQuery();
            if (resultado.next()) {
                res = resultado.getString("Usuario").equals(modelo.getVistaL().txtUsuarioLogin.getText())
                && resultado.getString("Passw").equals(String.valueOf(modelo.getVistaL().txtPassLogin.getPassword()));
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO O PASSWORD INCORRECTO, VERIFIQUE");                            
                modelo.setUsuario("");
                modelo.setContraseña("");                  
            }
            conector.desconectar();
            return res;
        } catch (SQLException ex) {
            conector.desconectar();
            return res;
        }
    }    
}
