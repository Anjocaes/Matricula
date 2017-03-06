package matricula.modelo;

import java.util.ArrayList;


public class Grupo {

    public Grupo(int numero, String horario) {
        this.numero = numero;
        this.horario = horario;
        cu=null;
    }

    public Curso getCu() {
        return cu;
    }

    public int getNumero() {
        return numero;
    }

    public String getHorario() {
        return horario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public void addAlumno(Alumno e){
        alumnos.add(e);
    }
    
    public Alumno busqAlum(String ced){
        alumnos.forEach(a->{
           if(ced.equals(a.cedula))
               alumno=a;
        });
        return alumno;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setCu(Curso cu) {
        this.cu = cu;
    }
    
    int numero;
    String horario;
    Curso cu;
    Profesor profesor;
    ArrayList<Alumno> alumnos;
    Alumno alumno;
}
