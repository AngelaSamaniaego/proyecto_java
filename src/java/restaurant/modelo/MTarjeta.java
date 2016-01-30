/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import restaurant.accesodatos.AccesoDatos;
import restaurant.accesodatos.ConjuntoResultado;
import restaurant.accesodatos.Parametro;
import restaurant.entidad.Tarjeta;

/**
 *
 * @author Daysi
 */
public class MTarjeta {

    public static boolean insertarTarjeta(Tarjeta tarjeta) throws Exception {
        boolean respuesta = false;

        try {
            String sql = "SELECT * from restaurant.fn_insert_tarjeta(?,?,?,?,?,?,?,?,?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, tarjeta.getCod_estado()));
            lst.add(new Parametro(5, tarjeta.getCosto()));
            lst.add(new Parametro(2, tarjeta.getFecha_compra()));
            lst.add(new Parametro(3, tarjeta.getFecha_caducidad()));
            lst.add(new Parametro(4, tarjeta.getNum_comidas()));
            lst.add(new Parametro(6, tarjeta.getBono()));
            lst.add(new Parametro(7, tarjeta.getSaldo()));
            lst.add(new Parametro(8, tarjeta.getCod_emp()));
            lst.add(new Parametro(9, tarjeta.getCod_cli()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lst);

            while (rs.next()) {
                if (rs.getBoolean(0) == true) {
                    respuesta = true;
                }
            }
            rs = null;
            lst = null;

        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    //actualizar un dato
    public static boolean actualizarTarjeta(Tarjeta tarjeta) throws Exception {
        boolean respuesta = false;

        try {
            String sql = "select * from restaurant.fn_update_tarjeta(?,?,?,?,?,?,?,?,?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, tarjeta.getId_tarjeta()));
            lst.add(new Parametro(3, tarjeta.getCosto()));
            lst.add(new Parametro(4, tarjeta.getFecha_compra()));
            lst.add(new Parametro(5, tarjeta.getFecha_caducidad()));
            lst.add(new Parametro(6, tarjeta.getNum_comidas()));
            lst.add(new Parametro(7, tarjeta.getBono()));
            lst.add(new Parametro(8, tarjeta.getSaldo()));
            lst.add(new Parametro(9, tarjeta.getNom_cli()));

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lst);

            while (rs.next()) {
                if (rs.getBoolean(0) == true) {
                    respuesta = true;
                }
            }
            rs = null;
            lst = null;

        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    //eliminar un dato
    public static boolean elimninarTarjeta(int id_tarj) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from restaurant.fn_delete_empresa(?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, id_tarj));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lst);
            while (rs.next()) {
                if (rs.getString(0).equals("true")) {
                    respuesta = true;
                }
            }

        } catch (SQLException e) {
            throw e;
        }
        return respuesta;
    }

    /**
     * //este metodo me permite traer de la base de datod todos los registros
     *
     * @return sacara los registros en un arraylist de tipom persona
     * @throws SQLException
     */
    public static ArrayList<Tarjeta> obtenerTarjeta() throws Exception {
        ArrayList<Tarjeta> lst = new ArrayList<Tarjeta>();
        try {
            String sql = "SELECT * from restaurant.fn_listado_tarjeta()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    public static ArrayList<Tarjeta> obtenerTarjetaId(int id) throws Exception {
        ArrayList<Tarjeta> lst = new ArrayList<Tarjeta>();
        try {
            String sql = "SELECT * from restaurant.fn_listado_tarjeta()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            lst = null;
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    public static ArrayList<Tarjeta> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Tarjeta> lst = new ArrayList<Tarjeta>();
        try {
            while (rs.next()) {
                Tarjeta objTarjeta = new Tarjeta(rs.getInt(0),
                        rs.getString(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7));
                lst.add(objTarjeta);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}
