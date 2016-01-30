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
import restaurant.entidad.Empleado;

/**
 *
 * @author Daysi
 */
public class MEmpleado {

    public static boolean insertarEmpleado(Empleado empleado) throws Exception {
        boolean respuesta = false;

        try {
            String sql = "SELECT * from restaurant.fn_insert_empleado(?,?,?,?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(2, empleado.getNombre_emp()));
            lst.add(new Parametro(3, empleado.getPass()));
            lst.add(new Parametro(4, empleado.getCargo()));
            lst.add(new Parametro(1, empleado.getCod_empresa()));

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
    public static boolean actualizarEmpleado(Empleado empleado) throws Exception {
        boolean respuesta = false;

        try {
            String sql = "SELECT * from restaurant.fn_update_empleado(?,?,?,?,?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, empleado.getId_empleado()));
            lst.add(new Parametro(2, empleado.getCod_empresa()));
            lst.add(new Parametro(3, empleado.getNombre_emp()));
            lst.add(new Parametro(4, empleado.getPass()));
            lst.add(new Parametro(5, empleado.getCargo()));

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
    public static boolean eliminarEmpleado(int id_emple) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from restaurant.fn_delete_empleado(?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, id_emple));
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
    public static ArrayList<Empleado> obtenerEmpleado() throws Exception {
        ArrayList<Empleado> lst = new ArrayList<Empleado>();
        try {
            String sql = "SELECT * from restaurant.fn_listado_empleado()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    public static ArrayList<Empleado> obtenerEmpleado2() throws Exception {
        ArrayList<Empleado> lst = new ArrayList<Empleado>();
        try {
            String sql = "SELECT * from restaurant.fn_listado_empleado()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    public static ArrayList<Empleado> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Empleado> lst = new ArrayList<Empleado>();
        try {
            while (rs.next()) {
                Empleado objEmpleado = new Empleado(rs.getInt(0),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(3),
                        rs.getString(1));
                lst.add(objEmpleado);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
    
     public static String login(Empleado user) throws Exception {
        Empleado lst=null;
        String cargos="";
         try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();           
            String sql = "SELECT restaurant.fn_buscar_empleado_log(?,?);";
            lstP.add(new Parametro(1, user.getId_empleado()));
            lstP.add(new Parametro(2, user.getPass()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while(rs.next())
            { 
                if(lst!=null)
                {
                    
                lst= new Empleado(
                    rs.getInt(0),
                    rs.getString(1),
                    rs.getString(2),
                        rs.getString(4),
                        rs.getString(3));
                cargos=rs.getString(3);
                        
            
                }}
    }catch(Exception e){
    throw  e;}
        return cargos;
    }
}
