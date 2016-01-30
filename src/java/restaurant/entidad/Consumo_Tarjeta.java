/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.entidad;

/**import java.sql.Date;*/
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author Daysi
 */
public class Consumo_Tarjeta {
    private int id_consumo;
    private int cantidad;
    private String descripcion;
    private Calendar fecha=Calendar.getInstance();
    private Date fecha_consumo=new Date();

    public Consumo_Tarjeta() {
    }

    public Consumo_Tarjeta(int id_consumo, int cantidad, String descripcion, Date fecha_consumo) {
        this.id_consumo = id_consumo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fecha_consumo = fecha_consumo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
    public int getId_consumo() {
        return id_consumo;
    }

    public void setId_consumo(int id_consumo) {
        this.id_consumo = id_consumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_consumo() {
        return fecha_consumo;
    }

    public void setFecha_consumo(Date fecha_consumo) {
        this.fecha_consumo = fecha_consumo;
    }
    
}
