/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Conexion;
import Model.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maranda
 */
public class DAO_Curso extends Conexion implements DAO<Curso> {

    public DAO_Curso() throws ClassNotFoundException, SQLException {
        super("alumnosYDocentesEjercicio07112018");
    }

    @Override
    public void create(Curso ob) throws SQLException {
        ejecutar("INSERT INTO curso VALUES(NULL, '" + ob.getNombre() + "' )");
    }

    @Override
    public List<Curso> read() throws SQLException {
        List<Curso> lista = new ArrayList<>();

        ResultSet rs = ejecutar("SELECT * FROM curso");

        Curso d = null;
        while (rs.next()) {
            d = new Curso();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));

            lista.add(d);
        }

        close();
        return lista;
    }

    @Override
    public void update(Curso ob) throws SQLException {
        ejecutar("UPDATE curso SET nombre='" + ob.getNombre() + "' ");
    }

    @Override
    public void delete(String id) throws SQLException {
        ejecutar("DELETE FROM curso WHERE id='" + id + "'");

    }

    
        public Curso buscarUnoPorId(int id) throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM curso WHERE id=" + id + "");
        Curso c = null;
        if (rs.next()) {
            c = new Curso();
            c.setId(rs.getInt(1));
            c.setNombre(rs.getString(2));

        }
        return c;

    }
    
    
    
    
    
}
