/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Alumno;
import Model.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maranda
 */
public class DAO_Alumno extends Conexion implements DAO<Alumno> {

    public DAO_Alumno() throws ClassNotFoundException, SQLException {
        super("alumnosYDocentesEjercicio07112018");
    }

    @Override
    public void create(Alumno ob) throws SQLException {
        ejecutar("INSERT INTO alumno VALUES(NULL, '" + ob.getNombre() + "' )");
    }

    @Override
    public List<Alumno> read() throws SQLException {
        List<Alumno> lista = new ArrayList<>();

        ResultSet rs = ejecutar("SELECT * FROM alumno");

        Alumno d = null;
        while (rs.next()) {
            d = new Alumno();
            d.setId(rs.getInt(1));
            d.setNombre(rs.getString(2));

            lista.add(d);
        }

        close();
        return lista;
    }

    @Override
    public void update(Alumno ob) throws SQLException {
        ejecutar("UPDATE docente SET nombre='" + ob.getNombre() + "' ");

    }

    @Override
    public void delete(String id) throws SQLException {
        ejecutar("DELETE FROM docente WHERE id='" + id + "'");
    }

    public Alumno buscarUnoPorId(int id) throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM alumno WHERE id=" + id + "");
        Alumno a = null;
        if (rs.next()) {
            a = new Alumno();
            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));

        }
        return a;

    }

}
