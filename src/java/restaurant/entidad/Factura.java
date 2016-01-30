/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.entidad;

import java.util.Date;

/**
 *
 * @author Daysi
 */
public class Factura {
    private int id_factura;
    private Date fecha=new Date();
    private Double total;
    private Double iva;
    private String nom_cliente;
    private String direc_clie;
    private String ced_clie;
    private String ruc_clie;

    public Factura() {
    }

    public Factura(int id_factura, Date fecha, Double total, Double iva) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.total = total;
        this.iva = iva;
    }

    public Factura(int id_factura, String nom_cliente, String direc_clie, String ced_clie, String ruc_clie, Date fecha, Double total, Double iva) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.total = total;
        this.iva = iva;
        this.nom_cliente = nom_cliente;
        this.direc_clie = direc_clie;
        this.ced_clie = ced_clie;
        this.ruc_clie = ruc_clie;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getDirec_clie() {
        return direc_clie;
    }

    public void setDirec_clie(String direc_clie) {
        this.direc_clie = direc_clie;
    }

    public String getCed_clie() {
        return ced_clie;
    }

    public void setCed_clie(String ced_clie) {
        this.ced_clie = ced_clie;
    }

    public String getRuc_clie() {
        return ruc_clie;
    }

    public void setRuc_clie(String ruc_clie) {
        this.ruc_clie = ruc_clie;
    }
    
}
