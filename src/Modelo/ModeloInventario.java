
package Modelo;

import Vistas.VistaInventario;
import javax.swing.table.DefaultTableModel;

public class ModeloInventario {
    
    //ASIGNA VALOR VARIABLE VISTA INVENTARIO Y MENU
        private VistaInventario VistaI;
    
    //ASIGNA VALOR VARIABLES 
        private String Ccdigo;
        private String Nombre;
        private Double Unidad;
        private Double PreCosto;
        private Double PreVenta;
        private DefaultTableModel modeloTabla ;
        

    public ModeloInventario(VistaInventario VistaI) {
        this.VistaI = VistaI;
    }

    public VistaInventario getVistaI() {
        return VistaI;
    }

    public void setVistaI(VistaInventario VistaI) {
        this.VistaI = VistaI;
    }

    public String getCcdigo() {
        return Ccdigo;
    }

    public void setCcdigo(String Ccdigo) {
        this.Ccdigo = Ccdigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getUnidad() {
        return Unidad;
    }

    public void setUnidad(Double Unidad) {
        this.Unidad = Unidad;
    }

    public Double getPreCosto() {
        return PreCosto;
    }

    public void setPreCosto(Double PreCosto) {
        this.PreCosto = PreCosto;
    }

    public Double getPreVenta() {
        return PreVenta;
    }

    public void setPreVenta(Double PreVenta) {
        this.PreVenta = PreVenta;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    } 
        
}
