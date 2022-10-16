package Modelo;

import Vistas.VistaRol;
import Vistas.VistaMenu;

public class ModeloRol {

    private String CodigoRol;
    private String Descripcion;
    private String cmbNivelRol;

    private VistaRol vistaR;
    private VistaMenu vistaM;
    
    //Recordar trabajar el comobox

    public ModeloRol(){        
    }

    public String getCodigoRol() {
        return CodigoRol;
    }

    public ModeloRol(VistaRol vistaR) { 
        if(vistaR != null)
            this.vistaR = vistaR;
    }
    
     public ModeloRol(VistaMenu vistaM){
        this.vistaM = vistaM;
    }    
        
    public void setCodigorol(String CodigoRol) {
        this.CodigoRol = CodigoRol;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Object getVistaRol() {
       return vistaR;
    }

       public void setVista(VistaRol vistaR) {
        this.vistaR = vistaR;
    }
   
    public String getCmbNivelRol() {
        return cmbNivelRol;
    }

    public void setCmbNivelRol(String cmbNivelRol) {
        this.cmbNivelRol = cmbNivelRol;
    }

    public Object getVistaR() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
}
