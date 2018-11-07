/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conexion;
import Model.Docente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maranda
 */
public class DAO_Docente extends Conexion implements DAO<Docente> {

    public DAO_Docente() throws ClassNotFoundException, SQLException {
        super("alumnosYDocentesEjercicio07112018");
    }

    @Override
    public void create(Docente ob) throws SQLException {
        ejecutar("INSERT INTO docente VALUES(NULL, '"+ob.getNombre()+"' )");
    }

    @Override
    public List<Docente> read() throws SQLException {
        List<Docente> lista= new ArrayList<>();
        
        ResultSet rs=ejecutar("SELECT * FROM docente");
        
        Docente d=null;
        while(rs.next()){
            d=new Docente();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));
            
            lista.add(d);
        }

        close();
        return lista;
    }

    @Override
    public void update(Docente ob) throws SQLException {
        ejecutar("UPDATE docente SET nombre='"+ob.getNombre()+"' ");
    }

    @Override
    public void delete(String id) throws SQLException {
        ejecutar("DELETE FROM docente WHERE id='"+id+"'");
    }
    
}
