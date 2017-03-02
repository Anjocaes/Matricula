package matricula.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    public Carrera(String codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        
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
//    //----------------------------Ciclos---------------------------------------------------
//    public void obtenerCiclo(){
//        ciclos = ciclo.getCiclo();
//    }
//    
//    public Ciclo escogerCiclo(String num) {// Este metodo se llama despues de crear una carrera xq asi decide como atributo interno el ciclo
//        ciclos.forEach(c->{
//            if(num.equals(c.numero)){
//                ciclo = c;
//            }
//        });
//        return ciclo;
//    }   
    
    //----------------------------Curso--------------------------------------
     public void crearCurso(String codigo, String nombre, int credito, int h_sem){
        cursos.add(new Curso(codigo,nombre,credito,h_sem));
    }
     
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    
    public Curso buqCursoCod(String cod){
     cursos.forEach(c->{
         if(cod.equals(c.codifo))
             curso=c;
     });
     return curso;
    }
    
    //--------------------------Alumnos--------------------------------------
    public void addAlumno(String ced, String nom, String tel, String correo, 
            String clave, String carrera, String fechaNac){
        alumnos.add(new Alumno(ced, nom, tel, correo, clave, carrera, fechaNac));
    }
    
    public ArrayList<Alumno> getAlumnos(){
        return alumnos;
    }

//----------------------------------------------------------------------------    
   List<Ciclo> ciclos; 
   String codigo;
   String nombre;
   String titulo;
   ArrayList<Curso> cursos = new ArrayList<>();
   Curso curso;
   //Ciclo ciclo;
   ArrayList<Alumno> alumnos;
}
