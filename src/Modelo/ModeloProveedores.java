package Modelo;

import Vistas.VistaProveedores;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloProveedores {
 
    
    private VistaProveedores VistaP;
    private DefaultTableModel modeloTabla;
    private String NIT;
    private String nombre;
    private String direccion;
    private String correo;
    private int numero;
    private JTable proveedores;

    public ModeloProveedores(VistaProveedores VistaP) {
               this.VistaP = VistaP;
    }

   

    public VistaProveedores getVistaP() {
        return VistaP;
    }

    public void setVistaP(VistaProveedores VistaP) {
        this.VistaP = VistaP;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
      VistaP.TablaP.setModel(modeloTabla);
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