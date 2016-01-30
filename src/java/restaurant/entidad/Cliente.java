/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.entidad;

/**
 *
 * @author Daysi
 */
public class Cliente {
    private int id_cliente;
    private String cedula;
    private String nombre_cliente;
    private String apellido_cliente;
    private String sexo;
    private String estado_civil;
    private String telefono;
    private String correo;
    private String ruc="9999999999999";
    private String direccion;

    public Cliente() {
    }

    public Cliente(int id_cliente, String cedula, String nombre_cliente, String apellido_cliente, String sexo, String estado_civil, String telefono, String correo, String ruc, String direccion) {
        this.id_cliente = id_cliente;
        this.cedula = cedula;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
        this.telefono = telefono;
        this.correo = correo;
        this.ruc = ruc;
        this.direccion=direccion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
      
   
}
