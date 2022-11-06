package Modelo;

import Vistas.VistaRol;
import Vistas.VistaMenu;

public class ModeloRol {

    private String CodigoRol;
    private String Descripcion;
    private String cmbNivelRol;

    private VistaRol vistaR;
    private VistaMenu vistaM;

    public ModeloRol(VistaRol vistaR, VistaMenu vistaM) {
        this.vistaR = vistaR;
        this.vistaM = vistaM;
    }
    
    public VistaRol getVistaR() {
        return vistaR;
    }

    public void setVistaR(VistaRol vistaR) {
        this.vistaR = vistaR;
    }

    public VistaMenu getVistaM() {
        return vistaM;
    }

    public void setVistaM(VistaMenu vistaM) {
        this.vistaM = vistaM;
    }

    public String getCodigoRol() {
        return CodigoRol;
    }

    public void setCodigoRol(String CodigoRol) {
        this.CodigoRol = CodigoRol;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCmbNivelRol() {
        return cmbNivelRol;
    }

    public void setCmbNivelRol(String cmbNivelRol) {
        this.cmbNivelRol = cmbNivelRol;
    }
 
    
    
}
