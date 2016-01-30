/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.modelo;

import java.lang.reflect.Parameter;
import java.sql.SQLException;
import java.util.ArrayList;
import restaurant.accesodatos.AccesoDatos;
import restaurant.accesodatos.ConjuntoResultado;
import restaurant.accesodatos.Parametro;
import restaurant.entidad.Cliente;

/**
 *
 * @author Daysi
 */
public class MCliente {

    //insertar un dato

    public static boolean insertarCliente(Cliente cliente) throws Exception {
        boolean respuesta = false;

        try {
            String sql = "SELECT * from restaurant.fn_insert_cliente(?,?,?,?,?,?,?,?,?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, cliente.getCedula()));
            lst.add(new Parametro(2, cliente.getNombre_cliente()));
            lst.add(new Parametro(3, cliente.getApellido_cliente()));
            lst.add(new Parametro(4, cliente.getSexo()));
            lst.add(new Parametro(5, cliente.getEstado_civil()));
            lst.add(new Parametro(6, cliente.getTelefono()));
            lst.add(new Parametro(7, cliente.getCorreo()));
            lst.add(new Parametro(8, cliente.getRuc()));
            lst.add(new Parametro(9, cliente.getDireccion()));

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
    public static boolean actualizarCliente(Cliente cliente) throws Exception {
        boolean respuesta = false;

        try {
            String sql = "select * from restaurant.fn_update_cliente(?,?,?,?,?,?,?,?,?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, cliente.getId_cliente()));
            lst.add(new Parametro(2, cliente.getCedula()));
            lst.add(new Parametro(3, cliente.getNombre_cliente()));
            lst.add(new Parametro(4, cliente.getApellido_cliente()));
            lst.add(new Parametro(5, cliente.getSexo()));
            lst.add(new Parametro(6, cliente.getEstado_civil()));
            lst.add(new Parametro(7, cliente.getTelefono()));
            lst.add(new Parametro(8, cliente.getCorreo()));
            lst.add(new Parametro(9, cliente.getDireccion()));

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
    public static boolean eliminarCliente(Cliente cliente) throws Exception {
        boolean respuesta = false;

        try {
            String sql = "select * from restaurant.fn_delete_cliente(?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, cliente.getId_cliente()));

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

    /**
     * //este metodo me permite traer de la base de datod todos los registros
     *
     * @return sacara los registros en un arraylist de tipom persona
     * @throws SQLException
     */
    public static ArrayList<Cliente> obtenerCliente() throws Exception {
        ArrayList<Cliente> lst = new ArrayList<Cliente>();
        try {
            String sql = "SELECT restaurant.fn_select_cliente();";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    public static Cliente obtenerClienteC(String ced) throws Exception {
        Cliente cli = null;
        try {
            ArrayList<Parametro> lst = new ArrayList<Parametro>();
            String sql = "SELECT * from restaurant.fn_listado_clientes_cedula(?)";
            lst.add(new Parametro(1, ced));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lst);
            cli=new Cliente();
            cli = llenarDatos(rs).get(1);
            rs = null;
        } catch (SQLException e) {
            throw e;
        }
        return cli;
    }

    public static ArrayList<Cliente> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Cliente> lst = new ArrayList<Cliente>();
        try {
            while (rs.next()) {
                Cliente objCliente;
                objCliente = new Cliente(rs.getInt("id"),
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                lst.add(objCliente);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}
