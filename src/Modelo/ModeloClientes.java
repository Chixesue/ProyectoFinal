
package Modelo;

import Vistas.VistaClientes;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloClientes {
    
    private VistaClientes vistaC;
    private DefaultTableModel modeloTabla ;
    private String NIT;
    private String nombre;
    private String direccion;
    private String correo;
    private int numero;
    private JTable clientes;

    public ModeloClientes() {     
    }
    
    public ModeloClientes(VistaClientes vistaC){
        this.vistaC = vistaC;
    }

    public VistaClientes getVistaC() {
        return vistaC;
    }

    public void setVistaC(VistaClientes vistaC) {
        this.vistaC = vistaC;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        vistaC.tblClientes.setModel(modeloTabla);
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

    public JTable getClientes() {
        return clientes;
    }

    public void setClientes(JTable clientes) {
        this.clientes = clientes;
    }
    
    
    
    
}
