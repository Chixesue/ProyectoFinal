package Modelo;

import Vistas.VistaTelefonos;


public class ModeloTelefono {

    
    private VistaTelefonos vistaT;
    private String NIT;
    private String oficina;
    private String casa;
    private String compras;       
    private String celular;
    private String contabilidad;
    private String pagos;

    public ModeloTelefono() {
        
        
        
    }

    public ModeloTelefono(VistaTelefonos aThis) {
      
    }

    public VistaTelefonos getVistaT() {
        return vistaT;
    }

    public void setVistaT(VistaTelefonos vistaT) {
        this.vistaT = vistaT;
    }
 
    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getCompras() {
        return compras;
    }

    public void setCompras(String compras) {
        this.compras = compras;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContabilidad() {
        return contabilidad;
    }

    public void setContabilidad(String contabilidad) {
        this.contabilidad = contabilidad;
    }

    public String getPagos() {
        return pagos;
    }

    public void setPagos(String pagos) {
        this.pagos = pagos;
    }

}