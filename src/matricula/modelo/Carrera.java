package matricula.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    public Carrera(String codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public void obtenerCiclo(){
        ciclos = ciclo.getCiclo();
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
   
    //----------------------------Curso----------------------------------------------------
     public void crearCurso(String codigo, String nombre, int credito, int h_sem){
        cursos.add(new Curso(codigo,nombre,credito,h_sem));
    }
   
   List<Ciclo> ciclos; 
   String codigo;
   String nombre;
   String titulo;
   ArrayList<Curso> cursos = new ArrayList<>();
   Ciclo ciclo;
}
