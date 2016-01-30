/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.entidad;

import java.sql.Date;

/**
 *
 * @author Daysi
 */
public class Tarjeta {
    private int id_tarjeta;
    private Double costo;
    private Date fecha_compra;
    private Date fecha_caducidad;
    private int num_comidas;
    private Double bono;
    private Double saldo;
    private String nom_cli;
    private int cod_estado;
    private int cod_emp;
    private int cod_cli;

    public Tarjeta() {
    }

    public Tarjeta(int id_tarjeta, String nom_cli, Date fecha_compra, Date fecha_caducidad, int num_comidas, Double costo, Double bono, Double saldo) {
        this.id_tarjeta = id_tarjeta;
        this.costo = costo;
        this.fecha_compra = fecha_compra;
        this.fecha_caducidad = fecha_caducidad;
        this.num_comidas = num_comidas;
        this.bono = bono;
        this.saldo = saldo;
        this.nom_cli = nom_cli;
    }

    public Tarjeta(int id_tarjeta, Double costo, Date fecha_compra, Date fecha_caducidad, int num_comidas, Double bono, Double saldo, int cod_estado, int cod_emp, int cod_cli) {
        this.id_tarjeta = id_tarjeta;
        this.costo = costo;
        this.fecha_compra = fecha_compra;
        this.fecha_caducidad = fecha_caducidad;
        this.num_comidas = num_comidas;
        this.bono = bono;
        this.saldo = saldo;
        this.cod_estado = cod_estado;
        this.cod_emp = cod_emp;
        this.cod_cli = cod_cli;
    }
    
    public int getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public int getNum_comidas() {
        return num_comidas;
    }

    public void setNum_comidas(int num_comidas) {
        this.num_comidas = num_comidas;
    }

    public Double getBono() {
        return bono;
    }

    public void setBono(Double bono) {
        this.bono = bono;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public int getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(int cod_estado) {
        this.cod_estado = cod_estado;
    }

    public int getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(int cod_emp) {
        this.cod_emp = cod_emp;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }
    
    
}
