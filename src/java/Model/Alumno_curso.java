/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author maranda
 */
public class Alumno_curso {
    private int id;
    private Alumno alumno;
    private Curso curso;

    public Alumno_curso(int id, Alumno alumno, Curso curso) {
        this.id = id;
        this.alumno = alumno;
        this.curso = curso;
    }

    public Alumno_curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno_curso{" + "id=" + id + ", alumno=" + alumno + ", curso=" + curso + '}';
    }
    
    
    
}
