/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.controlador;
import restaurant.modelo.*;
import javax.faces.bean.ManagedProperty;
import restaurant.entidad.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class LoginUsuario {

private Empleado objUsuario;
    //crear la variable de sesion

    @ManagedProperty(value = "#{sesionManager}")
    private SesionUsuarioDataManager sesion;
    public LoginUsuario() {
        this.objUsuario = new Empleado();
    }

    public Empleado getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Empleado objUsuario) {
        this.objUsuario = objUsuario;
    }

    public SesionUsuarioDataManager getSesion() {
        return sesion;
    }

    public void setSesion(SesionUsuarioDataManager sesion) {
        this.sesion = sesion;
    }

    public String login() throws Exception {
        if (MEmpleado.login(objUsuario)!= null) {
            this.sesion.setObjUsuario(objUsuario);
            return "/home";
        } else {
            return "/index";
        }
    }
}

