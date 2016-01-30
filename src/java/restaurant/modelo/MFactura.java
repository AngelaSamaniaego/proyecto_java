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
import restaurant.entidad.Factura;

/**
 *
 * @author Daysi
 */
public class MFactura {
    public static boolean insertarFactura(Factura factura)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_insert_factura(?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,factura.getFecha()));
            lst.add(new Parametro(2,factura.getTotal()));
            lst.add(new Parametro(3,factura.getIva()));
            
            ConjuntoResultado rs=AccesoDatos.ejecutaQuery(sql, lst);
            
            while(rs.next())
            {
            if(rs.getBoolean(0)==true)
                respuesta=true;
            }
            rs=null;
            lst=null;
                        
        }catch (Exception e){
            throw e;
        }
        return respuesta;
    }
    
    //actualizar un dato
    public static boolean actualizarFactura(Factura factura)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_update_factura(?,?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,factura.getId_factura()));
            lst.add(new Parametro(2,factura.getFecha()));
            lst.add(new Parametro(3,factura.getTotal()));
            lst.add(new Parametro(4,factura.getIva()));
            
            ConjuntoResultado rs=AccesoDatos.ejecutaQuery(sql, lst);
            
            while(rs.next())
            {
            if(rs.getBoolean(0)==true)
                respuesta=true;
            }
            rs=null;
            lst=null;
                        
        }catch (Exception e){
            throw e;
        }
        return respuesta;
    }
    
    //eliminar un dato
     public static boolean elimninarFactura(int id_fact) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from restaurant.fn_delete_empresa(?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, id_fact));
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
     * @return sacara los registros en un arraylist de tipom persona
     * @throws SQLException 
     */
    
    public static ArrayList<Factura> obtenerFactura() throws Exception {
        ArrayList<Factura> lst = new ArrayList<Factura>();
        try {
            String sql = "SELECT * from restaurant.fn_listado_factura()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }
    
    public static ArrayList<Factura> llenarDatos(ConjuntoResultado rs) throws Exception{
       ArrayList<Factura> lst=new ArrayList<Factura>();
    try{
        while(rs.next())
        {
        Factura objFactura=new Factura(rs.getInt(0),
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDate(5),
                rs.getDouble(6),
                rs.getDouble(7));
        lst.add(objFactura);
                }
    }catch (Exception e){
         throw e;
    }
        return lst;
   }
}
