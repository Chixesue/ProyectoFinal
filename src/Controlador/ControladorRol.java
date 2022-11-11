
package Controlador;

import Conector.Conector;
import Conector.SQLRol;
import Modelo.ModeloRol;
import Vistas.VistaRol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControladorRol implements ActionListener{
    
    ModeloRol   ModeloR;
    VistaRol    VistaR;
    Conector    conector = new Conector();
    PreparedStatement ps;
    ResultSet   resultado;
    SQLRol sql = new SQLRol();
    
    //VARIABLES 
    public String Codigo;
    public String Nombre;
    public Integer Nivel;
    public String Nivel_String;
     
    
    public ControladorRol(ModeloRol ModeloR, VistaRol VistaR) {
        this.ModeloR = ModeloR;
        this.VistaR = VistaR;
    }

    public ControladorRol(ModeloRol ModeloR) {
        this.ModeloR = ModeloR;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ModeloR.getVistaR().btnGrabar.getActionCommand())){
            if (GrabarRol()){
                JOptionPane.showMessageDialog(null, "Registro de Rol, exitoso");
            }
        }       
    }
    
    public boolean GrabarRol(){
        boolean resultado = false;
        Nivel  = ModeloR.getVistaR().cmbNivelRol.getSelectedIndex() + 1;
        
        if(Nivel == 1){
            Nivel_String = "Administrador";
        } else if(Nivel == 2){
            Nivel_String = "Supervisor";
        } else if(Nivel == 3){
            Nivel_String = "Operador";
        }       
        
        try {
            ps = conector.preparar(sql.getGrabarRol());
            ps.setString(1, ModeloR.getVistaR().txtCodRol.getText());
            ps.setString(2, ModeloR.getVistaR().txtDescripRol.getText());
            ps.setString(3, Nivel_String);
            resultado = ps.execute();
            Limpiar();            
        } catch (Exception e) {
            System.err.println("ERROR EN REGISTRAR USUARIO" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar el Rol, contacte al Administrador");
        }
        conector.desconectar();
        return resultado;
    }
   
    public boolean ValidarRol(){
        boolean res = false;
        //ASIGNAR VALORES A LAS VARIABLES
        Codigo = ModeloR.getVistaR().txtCodRol.getText();
        Nombre = ModeloR.getVistaR().txtDescripRol.getText();
        Nivel  = ModeloR.getVistaR().cmbNivelRol.getSelectedIndex() + 1;
                
        try {
            ps = conector.preparar(sql.getBuscarRol());
            ps.setString(1, ModeloR.getVistaR().txtCodRol.getText());           
            //ps.setString(2, ModeloR.getVistaR().txtCodRol.getText());
            //ps.setInt(3, ModeloR.getVistaR().cmbNivelRol.getSelectedIndex());
            resultado = ps.executeQuery();
            if (resultado.next()){
                
                res = resultado.getString("Rol").equals(ModeloR.getVistaR().txtCodRol.getText())
                && resultado.getString("Descripcion").equals(ModeloR.getVistaR().txtDescripRol.getText())
                && resultado.getString("Nivel").equals(ModeloR.getVistaR().cmbNivelRol.getAccessibleContext());
                
            } else {
                JOptionPane.showMessageDialog(null, "CODIGO DE ROL NO EXISTE ... ");
                ModeloR.getVistaR().txtCodRol.setText("");
            }
            conector.desconectar();
            return res;
        } catch (Exception e) {
            conector.desconectar();            
            return res;
        }          
    }    

    public String Limpiar(){
        ModeloR.getVistaR().txtCodRol.setText("");
        ModeloR.getVistaR().txtDescripRol.setText("");
        return null;
    }
}
