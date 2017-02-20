package matricula.modelo;

import java.util.ArrayList;

public class Carrera {
    public Carrera(String codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //----------------Agregar a la lista de cursos------------------------------------
    public void add(Curso c){
        cursos.add(c);
    }
    
   String codigo;
   String nombre;
   String titulo;
   ArrayList<Curso> cursos = new ArrayList<>();
   Ciclo ciclo;
}
