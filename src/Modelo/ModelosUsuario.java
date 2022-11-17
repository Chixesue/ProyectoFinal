
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
  private String puesto;
  private String Nivel;  

    public ModelosUsuario(VistaUsuarios vistaUs) {
        this.vistaUs = vistaUs;
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
    
    public VistaUsuarios getVistaUs() {
        return vistaUs;
    }

    public void setVistaUs(VistaUsuarios vistaUs) {
        this.vistaUs = vistaUs;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }
          
}
