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
import restaurant.entidad.Estado_Tarjeta;
import restaurant.modelo.MEstado_Tarjeta;

/**
 *
 * @author Daysi
 */

@ManagedBean
@ViewScoped
public class EstadoTarjetaControlador {
    //Crear los objetos para manipular la vista
    private Estado_Tarjeta objEstadoTarjeta;// st objeto para insertar
    private Estado_Tarjeta selEstadoTarjeta;//st objeto seleccionar
    private ArrayList <Estado_Tarjeta> lstEstadoTarjeta;

    public EstadoTarjetaControlador() {
        this.objEstadoTarjeta = new Estado_Tarjeta();
        this.selEstadoTarjeta = new Estado_Tarjeta();
        this.lstEstadoTarjeta = new ArrayList <Estado_Tarjeta>();
    }

    public Estado_Tarjeta getObjEstado_Tarjeta() {
        return objEstadoTarjeta;
    }

    public void setObjEstado_Tarjeta(Estado_Tarjeta objEstadoTarjeta) {
        this.objEstadoTarjeta = objEstadoTarjeta;
    }

    public Estado_Tarjeta getSelEstado_Tarjeta() {
        return selEstadoTarjeta;
    }

    public void setSelEstado_Tarjeta(Estado_Tarjeta selEstadoTarjeta) {
        this.selEstadoTarjeta = selEstadoTarjeta;
    }

    public ArrayList<Estado_Tarjeta> getLstEstado_Tarjeta() {
        return lstEstadoTarjeta;
    }

    public void setLstEstado_Tarjeta(ArrayList<Estado_Tarjeta> lstEstadoTarjeta) {
        this.lstEstadoTarjeta = lstEstadoTarjeta;
    }
    
              
    @PostConstruct
    public void rinit(){
    cargarEstado_Tarjeta();//Inicializa metodos
    }
    
    private void cargarEstado_Tarjeta()
    {
    try{
        this.lstEstadoTarjeta=MEstado_Tarjeta.obtenerEstadoTarjeta();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
    
    public void insertarEstadoTarjeta() {
        try {
            if (MEstado_Tarjeta.insertarEstadoTarjeta(objEstadoTarjeta)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertEstadoTarjeta.hiden()");
                cargarEstado_Tarjeta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void actualizarEstadoTarjeta() {
        try {
            if (MEstado_Tarjeta.actualizarEstadoTarjeta(selEstadoTarjeta)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatEstadoTarjeta.hiden()");
                this.selEstadoTarjeta=new Estado_Tarjeta();
                cargarEstado_Tarjeta();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no actualizados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void eliminarEstadoTarjeta() {
        try {
            if (MEstado_Tarjeta.eliminarEstadoTarjeta(selEstadoTarjeta.getId_estado())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos eliminados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglDeletEstadoTarjeta.hiden()");
                this.selEstadoTarjeta=new Estado_Tarjeta();
                cargarEstado_Tarjeta();
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
