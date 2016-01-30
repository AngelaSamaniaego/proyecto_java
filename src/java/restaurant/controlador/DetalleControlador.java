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
import restaurant.entidad.Detalle;
import restaurant.modelo.MDetalle;


/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class DetalleControlador {

    private Detalle objDetalle;// st objeto para insertar
    private Detalle selDetalle;//st objeto seleccionar
    private ArrayList<Detalle> lstDetalle;

    public DetalleControlador() {
        this.objDetalle= new Detalle();
        this.selDetalle=new Detalle();
        this.lstDetalle=new ArrayList<Detalle>();
    }

    public Detalle getObjDetalle() {
        return objDetalle;
    }

    public void setObjDetalle(Detalle objDetalle) {
        this.objDetalle = objDetalle;
    }

    public Detalle getSelDetalle() {
        return selDetalle;
    }

    public void setSelDetalle(Detalle selDetalle) {
        this.selDetalle = selDetalle;
    }

    public ArrayList<Detalle> getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(ArrayList<Detalle> lstDetalle) {
        this.lstDetalle = lstDetalle;
    }
    
    @PostConstruct
    public void rinit(){
    cargarDetalle();//Inicializa metodos
    }
    
    private void cargarDetalle()
    {
    try{
        this.lstDetalle=MDetalle.obtenerDetalle();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
    
    public void insertarDetalle() {
        try {
            if (MDetalle.insertarDetalle(objDetalle)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertDetalle.hiden()");
                cargarDetalle();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
}
