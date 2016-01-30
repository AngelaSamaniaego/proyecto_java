/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.entidad;

/**
 *
 * @author Daysi
 */
public class Detalle {

    private int id_detalle;
    private int cantidad = 1;
    private String des_plato;
    private int num_factura;
    private int plato;
    private Double cost_plat;
    private Double precio;

    public Detalle() {
    }

    public Detalle(int id_detalle, int cantidad, Double precio, String des_plato, int num_factura) {
        this.id_detalle = id_detalle;
        this.cantidad = cantidad;
        this.precio = precio;
        this.des_plato = des_plato;
        this.num_factura = num_factura;
    }

    public Detalle(int id_detalle, int cantidad, Double precio, int num_factura, int plato) {
        this.id_detalle = id_detalle;
        this.cantidad = cantidad;
        this.precio = precio;
        this.num_factura = num_factura;
        this.plato = plato;
    }

    public Double getCost_plat() {
        return cost_plat;
    }

    public void setCost_plat(Double cost_plat) {
        this.cost_plat = cost_plat;
    }

    public String getDes_plato() {
        return des_plato;
    }

    public void setDes_plato(String des_plato) {
        this.des_plato = des_plato;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getPlato() {
        return plato;
    }

    public void setPlato(int plato) {
        this.plato = plato;
    }

}
