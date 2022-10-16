
package Modelo;

import Vistas.VistaLogin;
import Vistas.VistaMenu;

public class ModeloLogin {
    
    
    private VistaLogin vistaL;
    private VistaMenu vistaM;
    private String Usuario;
    private String contraseña;
    private VistaLogin vista;

    public ModeloLogin() { 
    }
    
    public ModeloLogin(VistaLogin vistaL) { 
        if(vistaL != null)
            this.vistaL = vistaL;
    }
    
    public ModeloLogin(VistaMenu vistaM){
        this.vistaM = vistaM;
    }
    
    public VistaMenu getVistaM() {
        return vistaM;
    }

    public void setVistaM(VistaMenu vistaM) {
        this.vistaM = vistaM;
    }

    public VistaLogin getVistaL() {
        return vistaL;
    }

    public void setVistaL(VistaLogin vistaL) {
        this.vistaL = vistaL;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public VistaLogin getVista() {
        return vista;
    }

    public void setVista(VistaLogin vista) {
        this.vista = vista;
    }
 
    
    
    
    
    
    
}
