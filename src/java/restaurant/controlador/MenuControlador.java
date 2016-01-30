/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Daysi
 */
@ManagedBean
@ViewScoped
public class MenuControlador {
    
    private String ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public void frmCliente()
    {
    this.ruta="faces/Formulario/frmCliente.xhtml";
    }
    
    public  void frmEmpresa()
    {
    this.ruta="faces/Formulario/frmEmpresa.xhtml";
    }
    
    public void frmEmpleado(){
    this.ruta="faces/Formulario/frmEmpleado.xhtml";
    }
    
    public void frmEstadoTarjeta()
    {
    this.ruta="faces/Formulario/frmEstadoTarjeta.xhtml";
    }
    
    public void frmPlato()
    {
    this.ruta="faces/Formulario/frmPlato.xhtml";
    }
    
    public void frmTarjeta()
    {
    this.ruta="faces/Formulario/frmTarjeta.xhtml";
    }
    
    public void frmConsumoTarjeta()
    {
    this.ruta="faces/Formulario/frmConsumoTarjeta.xhtml";
    }
    
    public void frmDetalle()
    {
    this.ruta="faces/Formulario/frmDetalle.xhtml";
    }
    
    public void frmFactura()
    {
    this.ruta="faces/Formulario/frmFactura.xhtml";
    }
    
     /**
     * Creates a new instance of menuControlador
     */
    public MenuControlador() {
    
}
}
