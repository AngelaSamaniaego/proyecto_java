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
import restaurant.entidad.Empresa;

/**
 *
 * @author Daysi
 */
public class MEmpresa {
    public static boolean insertarEmpresa(Empresa empresa)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="SELECT * from restaurant.fn_insert_empresa(?,?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,empresa.getNombre()));
            lst.add(new Parametro(2,empresa.getDireccion()));
            lst.add(new Parametro(3,empresa.getTelefono()));
            lst.add(new Parametro(4,empresa.getAdministrador()));
            
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
    public static boolean actualizarEmpresa(Empresa empresa)throws Exception
    {
        boolean respuesta=false;
        
        try{
            String sql="select * from restaurant.fn_update_empresa(?,?,?,?,?)";
            ArrayList<Parametro> lst=new ArrayList<>();
            lst.add(new Parametro(1,empresa.getId_restaurant()));
            lst.add(new Parametro(2,empresa.getNombre()));
            lst.add(new Parametro(3,empresa.getDireccion()));
            lst.add(new Parametro(4,empresa.getTelefono()));
            lst.add(new Parametro(5,empresa.getAdministrador()));
            
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
    
    public static ArrayList<Empresa> obtenerEmpresa() throws Exception
    {
        ArrayList<Empresa> lst= new ArrayList<Empresa>();
        try{
            String sql="SELECT * from restaurant.fn_listado_empresa()";
            ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs=null;
        }catch (SQLException e){
            throw  e;
        }
        return lst;
    }
    
    public static boolean elimninarEmpresa(int id_emp) throws Exception {
        boolean respuesta = false;
        try {
            String sql = "SELECT * from restaurant.fn_delete_empresa(?)";
            ArrayList<Parametro> lst = new ArrayList<>();
            lst.add(new Parametro(1, id_emp));
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
    
    public static ArrayList<Empresa> llenarDatos(ConjuntoResultado rs) throws Exception {
       ArrayList<Empresa> lst=new ArrayList<Empresa>();
    try{
        while(rs.next())
        {
        Empresa objEmpresa=new Empresa(rs.getInt("id"),
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4));
        lst.add(objEmpresa);
                }
    }catch (Exception e){
        throw e;
    }
        return lst;
   }
}
