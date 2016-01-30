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
import restaurant.entidad.Estado_Tarjeta;
import restaurant.entidad.Tarjeta;

/**
 *
 * @author Daysi
 */
public class MEstado_Tarjeta {
   public static boolean insertarEstadoTarjeta(Estado_Tarjeta estado)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="SELECT * from restaurant.fn_insert_estado(?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,estado.getDescripcion()));
            
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
    public static boolean actualizarEstadoTarjeta(Estado_Tarjeta estado)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_update_estado(?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,estado.getId_estado()));
            lst.add(new Parametro(2,estado.getDescripcion()));
            
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
    public static boolean eliminarEstadoTarjeta(int id_st) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from restaurant.fn_delete_estado(?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, id_st));
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
    
    public static ArrayList<Estado_Tarjeta> obtenerEstadoTarjeta() throws Exception
    {
        ArrayList<Estado_Tarjeta> lst= new ArrayList<Estado_Tarjeta>();
        try{
            String sql="SELECT * from restaurant.fn_listado_estado_tarjeta()";
            ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs=null;
        }catch (SQLException e){
            throw  e;
        }
        return lst;
    }
    
    public static ArrayList<Estado_Tarjeta> obtenerEstadoTarjetaId( Estado_Tarjeta estado) throws Exception
    {
        ArrayList<Estado_Tarjeta> lst= new ArrayList<Estado_Tarjeta>();
        try{
            String sql="SELECT * from restaurant.fn_listado_estado_tarjeta()";
            ArrayList<Parametro> lsta=new ArrayList<>();
            lsta.add(new Parametro(1,estado.getId_estado()));
            
            ConjuntoResultado rs=AccesoDatos.ejecutaQuery(sql, lsta);
            
            lst = llenarDatos(rs);
            rs=null;
        }catch (SQLException e){
            throw  e;
        }
        return lst;
    }
    
    
    public static ArrayList<Estado_Tarjeta> llenarDatos(ConjuntoResultado rs) {
       ArrayList<Estado_Tarjeta> lst=new ArrayList<Estado_Tarjeta>();
    try{
        while(rs.next())
        {
        Estado_Tarjeta objEstado_Tarjeta=new Estado_Tarjeta(rs.getInt(0),
                rs.getString(1));
        lst.add(objEstado_Tarjeta);
                }
    }catch (Exception e){
    }
        return lst;
   } 
}
