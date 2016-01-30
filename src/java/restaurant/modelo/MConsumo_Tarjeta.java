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
import restaurant.entidad.Consumo_Tarjeta;

/**
 *
 * @author Daysi
 */
public class MConsumo_Tarjeta {
    public static boolean insertarConsumoTarjeta(Consumo_Tarjeta consumo)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_insert_consumo(?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,consumo.getCantidad()));
            lst.add(new Parametro(2,consumo.getDescripcion()));
            lst.add(new Parametro(3,consumo.getFecha_consumo()));
                        
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
    public static boolean actualizarConsumoTarjeta(Consumo_Tarjeta consumo)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_update_consumo(?,?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,consumo.getId_consumo()));
            lst.add(new Parametro(2,consumo.getCantidad()));
            lst.add(new Parametro(3,consumo.getDescripcion()));
            lst.add(new Parametro(4,consumo.getFecha_consumo()));
                        
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
    public static boolean eliminarConsumoTarjeta(Consumo_Tarjeta consumo)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_delete_consumo(?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,consumo.getId_consumo()));
            
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
    
    public static ArrayList<Consumo_Tarjeta> obtenerConsumoTarjeta() throws Exception
    {
        ArrayList<Consumo_Tarjeta> lst= new ArrayList<Consumo_Tarjeta>();
        try{
            String sql="select * from restaurant.fn_listado_consumo()";
            ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            lst=null;
        }catch (SQLException e){
            throw  e;
        }
        return lst;
    }
    
    public static ArrayList<Consumo_Tarjeta> llenarDatos(ConjuntoResultado rs) {
       ArrayList<Consumo_Tarjeta> lst=new ArrayList<Consumo_Tarjeta>();
    try{
        while(rs.next())
        {
        Consumo_Tarjeta objConsumo=new Consumo_Tarjeta(rs.getInt(0),
                rs.getInt(1),
                rs.getString(2),
                rs.getDate(3));
        lst.add(objConsumo);
                }
    }catch (Exception e){
    }
        return null;
   }
}
