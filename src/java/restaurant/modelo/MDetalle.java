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
import restaurant.entidad.Detalle;

/**
 *
 * @author Daysi
 */
public class MDetalle {
    public static boolean insertarDetalle(Detalle detalle)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_insert_detalle(?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,detalle.getCantidad()));
            lst.add(new Parametro(2,detalle.getPrecio()));
            
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
    public static boolean actualizarDetalle(Detalle detalle)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_update_detalle(?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,detalle.getId_detalle()));
            lst.add(new Parametro(2,detalle.getCantidad()));
            lst.add(new Parametro(3,detalle.getPrecio()));
            
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
    public static boolean eliminarCliente(Detalle detalle)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_delete_detalle(?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,detalle.getId_detalle()));
            
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
    
    /**
     * //este metodo me permite traer de la base de datod todos los registros
     * @return sacara los registros en un arraylist de tipom persona
     * @throws SQLException 
     */
    
    public static ArrayList<Detalle> obtenerDetalle() throws Exception
    {
        ArrayList<Detalle> lst= new ArrayList<Detalle>();
        try{
            String sql="select * from restaurant.fn_listado_detalle()";
            ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            lst=null;
        }catch (SQLException e){
            throw  e;
        }
        return lst;
    }
    
    public static ArrayList<Detalle> llenarDatos(ConjuntoResultado rs) {
       ArrayList<Detalle> lst=new ArrayList<Detalle>();
    try{
        while(rs.next())
        {
        Detalle objDetalle=new Detalle(rs.getInt(0),
                rs.getInt(1),
                rs.getDouble(2),
                rs.getString(3),
                rs.getInt(4));
        lst.add(objDetalle);
                }
    }catch (Exception e){
    }
        return null;
   }
}
