
package Modelo;

import javax.swing.JTable;

public class ModeloProveedores {
 
    private String NIT;
    private String nombre;
    private String direccion;
    private String correo;
    private int numero;
    private JTable proveedores;

    public ModeloProveedores() {
        
        
        
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public JTable getProveedores() {
        return proveedores;
    }

    public void setProveedores(JTable proveedores) {
        this.proveedores = proveedores;
    }
    
    
    
    
    
    
    
}
