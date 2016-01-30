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
import restaurant.entidad.Plato;
import restaurant.modelo.MPlato;

/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class PlatoControlador {
  //Crear los objetos para manipular la vista
    private Plato objPlato;// st objeto para insertar
    private Plato selPlato;//st objeto seleccionar
    private ArrayList <Plato> lstPlato;
    
    public PlatoControlador() {
        this.objPlato= new Plato();
        this.selPlato=new Plato();
        this.lstPlato=new ArrayList<Plato>();
    }

    public Plato getObjPlato() {
        return objPlato;
    }

    public void setObjPlato(Plato objPlato) {
        this.objPlato = objPlato;
    }

    public Plato getSelPlato() {
        return selPlato;
    }

    public void setSelPlato(Plato selPlato) {
        this.selPlato = selPlato;
    }

    public ArrayList<Plato> getLstPlato() {
        return lstPlato;
    }

    public void setLstPlato(ArrayList<Plato> lstPlato) {
        this.lstPlato = lstPlato;
    }
    
    @PostConstruct
    public void rinit(){
    cargarPlato();//Inicializa metodos
    }
    
    private void cargarPlato()
    {
    try{
        this.lstPlato=MPlato.obtenerPlato();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
    
    public void insertarPlato() {
        try {
            if (MPlato.insertarPlato(objPlato)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertPlato.hiden()");
                cargarPlato();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
     public void actualizarPlato() {
        try {
            if (MPlato.actualizarPlato(selPlato)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatPlato.hiden()");
                this.selPlato=new Plato();
                cargarPlato();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no actualizados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
     
      public void eliminarPlato() {
        try {
            if (MPlato.eliminarPlato(selPlato.getId_plato())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos eliminados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglDeletPlato.hiden()");
                this.selPlato=new Plato();
                cargarPlato();
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
