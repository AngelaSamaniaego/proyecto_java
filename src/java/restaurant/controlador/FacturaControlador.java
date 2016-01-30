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
import restaurant.entidad.Factura;
import restaurant.modelo.MFactura;

/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class FacturaControlador {

    private Factura objFactura;// st objeto para insertar
    private Factura selFactura;//st objeto seleccionar
    private ArrayList<Factura> lstFactura;

    public FacturaControlador() {
        this.objFactura= new Factura();
        this.selFactura=new Factura();
        this.lstFactura=new ArrayList<Factura>();
    }

    public Factura getObjFactura() {
        return objFactura;
    }

    public void setObjFactura(Factura objFactura) {
        this.objFactura = objFactura;
    }

    public Factura getSelFactura() {
        return selFactura;
    }

    public void setSelFactura(Factura selFactura) {
        this.selFactura = selFactura;
    }

    public ArrayList<Factura> getLstFactura() {
        return lstFactura;
    }

    public void setLstFactura(ArrayList<Factura> lstFactura) {
        this.lstFactura = lstFactura;
    }
    
    @PostConstruct
    public void rinit(){
    cargarFactura();//Inicializa metodos
    }
    
    private void cargarFactura()
    {
    try{
        this.lstFactura=MFactura.obtenerFactura();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
    
    public void insertarFactura() {
        try {
            if (MFactura.insertarFactura(objFactura)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertFactura.hiden()");
                cargarFactura();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void actualizarFactura() {
        try {
            if (MFactura.actualizarFactura(selFactura)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatFactura.hide()");
                this.selFactura=new Factura();
                cargarFactura();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no iactualizados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void eliminarFactura() {
        try {
            if (MFactura.elimninarFactura(selFactura.getId_factura())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatFactura.hide()");
                this.selFactura=new Factura();
                cargarFactura();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no iactualizados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }

}
