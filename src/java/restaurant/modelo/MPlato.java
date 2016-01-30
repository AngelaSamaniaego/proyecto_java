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
import restaurant.entidad.Plato;

/**
 *
 * @author Daysi
 */
public class MPlato {
    //insertar un plato
    public static boolean insertarPlato(Plato plato)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="SELECT * from restaurant.fn_insert_plato(?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,plato.getNombre()));
            lst.add(new Parametro(2,plato.getDescripcion()));
            lst.add(new Parametro(3,plato.getCosto()));
                                    
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
    public static boolean actualizarPlato(Plato plato)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="SELECT * from restaurant.fn_update_plato(?,?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,plato.getId_plato()));
            lst.add(new Parametro(2,plato.getNombre()));
            lst.add(new Parametro(3,plato.getDescripcion()));
            lst.add(new Parametro(4,plato.getCosto()));
                        
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
    public static boolean eliminarPlato(int id_plato) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from restaurant.fn_delete_plato(?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, id_plato));
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
    
    public static ArrayList<Plato> obtenerPlato() throws Exception
    {
        ArrayList<Plato> lst= new ArrayList<Plato>();
        try{
            String sql="SELECT * from restaurant.fn_listado_plato()";
            ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs=null;
        }catch (SQLException e){
            throw  e;
        }
        return lst;
    }
    
    public static ArrayList<Plato> llenarDatos(ConjuntoResultado rs) throws Exception {
       ArrayList<Plato> lst=new ArrayList<Plato>();
    try{
        while(rs.next())
        {
        Plato objPlato=new Plato(rs.getInt("id"),
                rs.getString(1),
                rs.getString(2),
                rs.getDouble(3));
        lst.add(objPlato);
                }
    }catch (Exception e){
        throw e;
    }
        return lst;
   }
}
