/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.controlador;
import restaurant.entidad.Empleado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;

/**
 *
 * @author Daysi
 */
@ManagedBean
@SessionScoped
public class SesionUsuarioDataManager implements Serializable{

    private Empleado objUsuario;
    /**
     * Creates a new instance of SesionManager
     */
    public SesionUsuarioDataManager() {
        this.objUsuario= new Empleado();
    }

    public Empleado getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Empleado objUsuario) {
        this.objUsuario = objUsuario;
    }
    
    
}