
package Modelo;

import Vistas.VistaUsuarios;
import javax.swing.JComboBox;

public class ModelosUsuario {

    
    
  private VistaUsuarios vistaUs;
  
  private String direccion;
  private String telefono;
  private String nombre;
  private String password;  
  private String confirmpass;
  private String usuario;
  private JComboBox<AbstractMethodError>comboBox;

    public ModelosUsuario() {
        
        
        
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public JComboBox<AbstractMethodError> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox<AbstractMethodError> comboBox) {
        this.comboBox = comboBox;
    }
    
    public ModelosUsuario(VistaUsuarios vistaUs) {
        this.vistaUs = vistaUs;
    }

    public VistaUsuarios getVistaUs() {
        return vistaUs;
    }

    public void setVistaUs(VistaUsuarios vistaUs) {
        this.vistaUs = vistaUs;
    }
    
    
          
          
          
          
          
          
          
          
}
