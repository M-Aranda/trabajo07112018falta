/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Alumno;
import Model.Alumno_curso;
import Model.Conexion;
import Model.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maranda
 */
public class DAO_Alumno_curso extends Conexion implements DAO<Alumno_curso> {

    public DAO_Alumno_curso() throws ClassNotFoundException, SQLException {
        super("alumnosYDocentesEjercicio07112018");
    }

    @Override
    public void create(Alumno_curso ob) throws SQLException {

        ejecutar("INSERT INTO alumno_curso VALUES (NULL, " + ob.getAlumno().getId() + "," + ob.getCurso().getId() + "");

    }

    @Override
    public List<Alumno_curso> read() throws SQLException {
        List<Alumno_curso> lista = new ArrayList<>();
        try {

            DAO_Alumno da = new DAO_Alumno();
            DAO_Curso dc = new DAO_Curso();

            List<Alumno> listaAlumnos = da.read();
            List<Curso> listaCursos = dc.read();

            ResultSet rs = ejecutar("SELECT * FROM alumno_curso");
            Alumno_curso ac = null;
            while (rs.next()) {
                ac = new Alumno_curso();
                
                int idAlumno=rs.getInt(1);
                int idCurso=rs.getInt(2);
                
                ac.setId(rs.getInt(1));
                ac.setAlumno(da.buscarUnoPorId(idCurso));
                ac.setCurso(dc.buscarUnoPorId(idCurso));
                

                lista.add(ac);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_Alumno_curso.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
        return lista;
    }

    @Override
    public void update(Alumno_curso ob) throws SQLException {
        ejecutar("UPDATEO alumno_curso SET  fk_alumno=" + ob.getAlumno().getId() + ", fk_curso=" + ob.getCurso().getId() + " WHERE id"
                + "=" + ob.getId() + "");

    }

    @Override
    public void delete(String id) throws SQLException {
        ejecutar("DELETE FROM alumno_curso WHERE id='" + id + "'");
    }

}
