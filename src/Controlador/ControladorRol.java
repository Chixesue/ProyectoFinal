
package Controlador;

import Conector.Conector;
import Modelo.ModeloRol;
import Vistas.VistaRol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControladorRol implements ActionListener{
    
    ModeloRol   ModeloR;
    VistaRol    VistaR;
    Conector    conector = new Conector();
    PreparedStatement ps;
    ResultSet   resultado;

    public ControladorRol(ModeloRol ModeloR, VistaRol VistaR) {
        this.ModeloR = ModeloR;
        this.VistaR = VistaR;
    }

    public ControladorRol(ModeloRol ModeloR) {
        this.ModeloR = ModeloR;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    
    public void LimpiaRol(){  
        
    }
    
}
