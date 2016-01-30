/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.controlador;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.DefaultRequestContext;
import restaurant.entidad.Consumo_Tarjeta;
import restaurant.modelo.MConsumo_Tarjeta;

/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class ConsumoTarjetaControlador {

    private Consumo_Tarjeta objConsumoTarjeta;// st objeto para insertar
    private Consumo_Tarjeta selConsumoTarjeta;//st objeto seleccionar
    private ArrayList <Consumo_Tarjeta> lstConsumoTarjeta;
    
    public ConsumoTarjetaControlador() {
        this.objConsumoTarjeta= new Consumo_Tarjeta();
        this.selConsumoTarjeta=new Consumo_Tarjeta();
        this.lstConsumoTarjeta=new ArrayList<Consumo_Tarjeta>();
    }

    public Consumo_Tarjeta getObjConsumoTarjeta() {
        return objConsumoTarjeta;
    }

    public void setObjConsumoTarjeta(Consumo_Tarjeta objConsumoTarjeta) {
        this.objConsumoTarjeta = objConsumoTarjeta;
    }

    public Consumo_Tarjeta getSelConsumoTarjeta() {
        return selConsumoTarjeta;
    }

    public void setSelConsumoTarjeta(Consumo_Tarjeta selConsumoTarjeta) {
        this.selConsumoTarjeta = selConsumoTarjeta;
    }

    public ArrayList<Consumo_Tarjeta> getLstConsumoTarjeta() {
        return lstConsumoTarjeta;
    }

    public void setLstConsumoTarjeta(ArrayList<Consumo_Tarjeta> lstConsumoTarjeta) {
        this.lstConsumoTarjeta = lstConsumoTarjeta;
    }
    
    @PostConstruct
    public void rinit(){
    cargarConsumoTarjeta();//Inicializa metodos
    }
    
    private void cargarConsumoTarjeta()
    {
    try{
        this.lstConsumoTarjeta=MConsumo_Tarjeta.obtenerConsumoTarjeta();
        }catch(Exception e){
            System.out.println("e"+e.getMessage().toString());
    }
    }
    
    public void insertarConsumoTarjeta() {
        try {
            if (MConsumo_Tarjeta.insertarConsumoTarjeta(objConsumoTarjeta)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("Exito", new FacesMessage("Datos insertados correctamente"));
                DefaultRequestContext.getCurrentInstance().execute("wglInsertConsumoTarjeta.hiden()");
                cargarConsumoTarjeta();
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
