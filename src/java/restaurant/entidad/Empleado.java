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
public class Empleado {
    private int id_empleado;
    private String nombre_emp;
    private String pass;
    private String cargo;
    private String nom_empresa;
    private int cod_empresa;

    public Empleado(int id_empleado, int cod_empresa, String nombre_emp, String pass, String cargo) {
        this.id_empleado = id_empleado;
        this.cod_empresa = cod_empresa;
        this.nombre_emp = nombre_emp;
        this.pass = pass;
        this.cargo = cargo;
    }
    public Empleado(int id_empleado, String nombre_emp, String pass, String cargo, String nom_empresa) {
        this.id_empleado = id_empleado;
        this.nombre_emp = nombre_emp;
        this.pass = pass;
        this.cargo = cargo;
        this.nom_empresa = nom_empresa;
    }
    public Empleado() {
    }

    public int getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(int cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getNom_empresa() {
        return nom_empresa;
    }

    public void setNom_empresa(String nom_empresa) {
        this.nom_empresa = nom_empresa;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_emp() {
        return nombre_emp;
    }

    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
  
}
