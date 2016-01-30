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
import restaurant.entidad.Cliente;
import restaurant.modelo.MCliente;

/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class ClienteControlador {

    //Crear los objetos para manipular la vista
    private Cliente objCliente;// st objeto para insertar
    private Cliente selCliente;//st objeto seleccionar
    private ArrayList <Cliente> lstCliente;

    public ClienteControlador() {
        this.objCliente= new Cliente();
        this.selCliente=new Cliente();
        this.lstCliente=new ArrayList<Cliente>();
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public Cliente getSelCliente() {
        return selCliente;
    }
    public void setSelCliente(Cliente selCliente) {
        this.selCliente = selCliente;
    }

    public ArrayList<Cliente> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(ArrayList<Cliente> lstCliente) {
        this.lstCliente = lstCliente;
    }
        
    @PostConstruct
    public void rinit(){
    cargarCliente();//Inicializa metodos
    }
    
    private void cargarCliente()
    {
    try{
        this.lstCliente=MCliente.obtenerCliente();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
    
     public void insertarCliente() {
        try {
            if (MCliente.insertarCliente(objCliente)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertCliente.hide()");
                cargarCliente();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
     
     public void actualizarCliente() {
        try {
            if (MCliente.actualizarCliente(selCliente)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos actualizados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatCliente.hide()");
                this.selCliente=new Cliente();
                cargarCliente();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no actualizados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
     
     public void eliminarCliente() {
        try {
            if (MCliente.eliminarCliente(selCliente)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos eliminados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglDeletCliente.hide()");
                this.selCliente=new Cliente();
                cargarCliente();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no eliminados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
     
     public void buscarClienteC(String cedula) {
        try {
            if (objCliente.getCedula()==cedula) {
                MCliente.obtenerClienteC(cedula);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Si existe el cliente"));
                DefaultRequestContext.getCurrentInstance().execute("wglBuscarCliente.hide()");
                this.selCliente=new Cliente();
                cargarCliente();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("No existe el cliente"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }

}
