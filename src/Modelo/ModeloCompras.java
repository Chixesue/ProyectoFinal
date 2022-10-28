package Modelo;

import Vistas.VistaCompras;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloCompras {
   
    private VistaCompras vistaCo;
    public DefaultTableModel modeloTabla;
    private String NIT;
    private String fecha;
    private String nombreCliente;
    private String correo;
    private String telefono;
    private String direccion;
    private String codProducto;       
    private String unidades;
    private String nombreProducto;
    private String precCosto;
    private String precVenta;
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
        return nombreCliente;
    }

    public void setNombre(String nombre) {
        this.nombreCliente = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

    public String getCodigoproducto() {
        return codProducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codProducto = codigoproducto;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecCosto() {
        return precCosto;
    }

    public void setPrecCosto(String precCosto) {
        this.precCosto = precCosto;
    }

    public String getPrecVenta() {
        return precVenta;
    }

    public void setPrecVenta(String precVenta) {
        this.precVenta = precVenta;
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
