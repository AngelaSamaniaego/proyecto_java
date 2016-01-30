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
import restaurant.entidad.Empresa;
import restaurant.modelo.MEmpresa;


/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class EmpresaControlador {
    //Crear los objetos para manipular la vista
    private Empresa objEmpresa;// st objeto para insertar
    private Empresa selEmpresa;//st objeto seleccionar
    private ArrayList <Empresa> lstEmpresa;
    
    public EmpresaControlador() {
        this.objEmpresa= new Empresa();
        this.selEmpresa=new Empresa();
        this.lstEmpresa=new ArrayList<Empresa>();
    }

    public Empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public Empresa getSelEmpresa() {
        return selEmpresa;
    }

    public void setSelEmpresa(Empresa selEmpresa) {
        this.selEmpresa = selEmpresa;
    }

    public ArrayList<Empresa> getLstEmpresa() {
        return lstEmpresa;
    }

    public void setLstEmpresa(ArrayList<Empresa> lstEmpresa) {
        this.lstEmpresa = lstEmpresa;
    }
    
    @PostConstruct
    public void rinit(){
    cargarEmpresa();//Inicializa metodos
    }
    
    private void cargarEmpresa()
    {
    try{
        this.lstEmpresa=MEmpresa.obtenerEmpresa();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
    
    public void insertarEmpresa() {
        try {
            
            if (MEmpresa.insertarEmpresa(objEmpresa)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertEmpresa.hide()");
                cargarEmpresa();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void actualizarEmpresa() {
        try {
            if (MEmpresa.actualizarEmpresa(selEmpresa)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatEmpresa.hide()");
                this.selEmpresa=new Empresa();
                cargarEmpresa();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no actualizados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void eliminarEmpresa() {
        try {
            if (MEmpresa.elimninarEmpresa(selEmpresa.getId_restaurant())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos eliminados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatEmpresa.hide()");
                this.selEmpresa=new Empresa();
                cargarEmpresa();
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
