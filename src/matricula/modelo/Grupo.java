package matricula.modelo;

import java.util.ArrayList;


public class Grupo {

    public Grupo(int numero, String horario) {
        this.numero = numero;
        this.horario = horario;
        this.profesor =new Profesor("---------","P.A","xxxxx-xxxxx","ejemplo@una.ac.cr","1234");
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
    
    private int numero;
    private String horario;
    Profesor profesor;
    ArrayList<Alumno> alumnos;
}
