
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

    public ControladorRol(ModeloRol ModeloR, VistaRol VistaR) {
        this.ModeloR = ModeloR;
        this.VistaR = VistaR;
    }

    public ControladorRol(ModeloRol ModeloR) {
        this.ModeloR = ModeloR;
    }

    @Override
    public void actionPerformed(ActionEvent e) {       
         if(e.getActionCommand().equals(ModeloR.getVistaR().btnBuscar.getActionCommand())){
             if(ValidarRol()){
                 
             }
         }
       
    }
   
    public boolean ValidarRol(){
        boolean res = false;
        try {
            ps = conector.preparar(sql.getBuscarRol());
            ps.setString(1, ModeloR.getVistaR().txtCodRol.getText());           
            ps.setString(2, ModeloR.getVistaR().txtCodRol.getText());
            ps.setString(3, ModeloR.getVistaR().cmbNivelRol.getUIClassID());
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
}
