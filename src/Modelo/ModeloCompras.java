package Modelo;

import Vistas.VistaCompras;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloCompras {
   
    private VistaCompras vistaCo;
    private DefaultTableModel modeloTabla;
    private String NIT;
    private String fecha;
    private String nombre;
    private String codigoproducto;       
    private String unidades;
    private String descripcion;
    private JTable compras; 

    public ModeloCompras() {
    }

    public ModeloCompras(VistaCompras vistaCo) {
        this.vistaCo = vistaCo;
    }

    public VistaCompras getVistaCo() {
        return vistaCo;
    }

    public void setVistaCo(VistaCompras vistaCo) {
        this.vistaCo = vistaCo;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        vistaCo.tblCompras.setModel(modeloTabla);
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

    public JTable getCompras() {
        return compras;
    }

    public void setCompras(JTable compras) {
        this.compras = compras;
    }
    
    
    
    
    
    
    
    
    
}
