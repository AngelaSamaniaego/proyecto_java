/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.controlador;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.DefaultRequestContext;
import restaurant.entidad.Tarjeta;
import restaurant.modelo.MTarjeta;

/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class TarjetaControlador {

    private Tarjeta objTarjeta;// st objeto para insertar
    private Tarjeta selTarjeta;//st objeto seleccionar
    private ArrayList<Tarjeta> lstTarjeta;

    public TarjetaControlador() {
        this.objTarjeta= new Tarjeta();
        this.selTarjeta = new Tarjeta();
        this.lstTarjeta = new ArrayList<Tarjeta>();
    }

    public Tarjeta getObjTarjeta() {
        return objTarjeta;
    }

    public void setObjTarjeta(Tarjeta objTarjeta) {
        this.objTarjeta = objTarjeta;
    }

    public Tarjeta getSelTarjeta() {
        return selTarjeta;
    }

    public void setSelTarjeta(Tarjeta selTarjeta) {
        this.selTarjeta = selTarjeta;
    }

    public ArrayList<Tarjeta> getLstTarjeta() {
        return lstTarjeta;
    }

    public void setLstTarjeta(ArrayList<Tarjeta> lstTarjeta) {
        this.lstTarjeta = lstTarjeta;
    }
    
    @PostConstruct
    public void rinit() {
        cargarTarjeta();//Inicializa metodos
    }

    private void cargarTarjeta() {
        try {
            this.lstTarjeta = MTarjeta.obtenerTarjeta();
        } catch (Exception e) {
            System.out.println("e" + e.getMessage().toString());
        }
    }

    public void insertarTarjeta() {
        try {
            if (MTarjeta.insertarTarjeta(objTarjeta)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertTarjeta.hide()");
                cargarTarjeta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void actualizarTarjeta() {
        try {
            if (MTarjeta.actualizarTarjeta(selTarjeta)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatTarjeta.hide()");
                this.selTarjeta=new Tarjeta();
                cargarTarjeta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no actualizados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void eliminarTarjeta() {
        try {
            if (MTarjeta.elimninarTarjeta(selTarjeta.getId_tarjeta())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos eliminados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglDeletTarjeta.hide()");
                this.selTarjeta=new Tarjeta();
                cargarTarjeta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no eliminados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    

}
