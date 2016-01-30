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
import restaurant.entidad.Empleado;
import restaurant.modelo.MEmpleado;

/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class EmpleadoControlador {
    //Crear los objetos para manipular la vista
    private Empleado objEmpleado;// st objeto para insertar
    private Empleado selEmpleado;//st objeto seleccionar
    private ArrayList <Empleado> lstEmpleado;
    private int CodEmpresa;
    
    public EmpleadoControlador() {
        this.objEmpleado= new Empleado();
        this.selEmpleado=new Empleado();
        this.lstEmpleado=new ArrayList<Empleado>();
    }

    public Empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(Empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public Empleado getSelEmpleado() {
        return selEmpleado;
    }

    public void setSelEmpleado(Empleado selEmpleado) {
        this.selEmpleado = selEmpleado;
    }

    public ArrayList<Empleado> getLstEmpleado() {
        return lstEmpleado;
    }

    public void setLstEmpleado(ArrayList<Empleado> lstEmpleado) {
        this.lstEmpleado = lstEmpleado;
    }

    public int getCodEmpresa() {
        return CodEmpresa;
    }

    public void setCodEmpresa(int CodEmpresa) {
        this.CodEmpresa = CodEmpresa;
    }

    
          
    @PostConstruct
    public void rinit(){
    cargarEmpleado();//Inicializa metodos
    }
    
    private void cargarEmpleado()
    {
    try{
        this.lstEmpleado=MEmpleado.obtenerEmpleado();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
    
    public void insertarEmpleado() {
        try {
            this.objEmpleado.setCod_empresa(CodEmpresa);
            if (MEmpleado.insertarEmpleado(objEmpleado)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertEmpleado.hiden()");
                cargarEmpleado();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no insertados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void actualizarEmpleado() {
        try {
            if (MEmpleado.actualizarEmpleado(selEmpleado)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos modificados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglUpdatEmpleado.hiden()");
                 this.selEmpleado=new Empleado();
                cargarEmpleado();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Datos no modificados"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
    
    public void eliminarEmpleado() {
        try {
            if (MEmpleado.eliminarEmpleado(selEmpleado.getId_empleado())) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Los datos se eliminaron correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglDeletEmpleado.hiden()");
                this.selEmpleado=new Empleado();
                cargarEmpleado();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Fracaso", new FacesMessage("Los datos se eliminaron"));
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exito", new FacesMessage(e.getMessage()));
        }
    }
}
