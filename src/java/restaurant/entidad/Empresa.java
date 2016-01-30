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
public class Empresa {
    private int id_restaurant;
    private String nombre;
    private String direccion;
    private String telefono;
    private String administrador;

    public Empresa() {
    }

    public Empresa(int id_restaurant, String nombre, String direccion, String telefono, String administrador) {
        this.id_restaurant = id_restaurant;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.administrador = administrador;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }
    
    
}
