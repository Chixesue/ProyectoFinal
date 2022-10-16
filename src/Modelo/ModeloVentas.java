package Modelo;

import javax.swing.JTable;

public class ModeloVentas {
   
     private String NIT;
    private String fecha;
    private String nombre;
    private String codigoproducto;       
    private String unidades;
    private String descripcion;
    private JTable ventas; 

    public ModeloVentas() {
        
        
        
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public JTable getVentas() {
        return ventas;
    }

    public void setVentas(JTable ventas) {
        this.ventas = ventas;
    }
    
    
    
    
    
    
}
