package matricula.modelo;

import AccesoDatos.AccesoDatos;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Modelo {
    public Modelo(){
            universidad= new Universidad("Universidad Nacional");
            
            carrera =new Carrera("EIF","Ingenieria en Sistema de infomacion",
                    "Bachillerato y salida lateral de Diplomado en Prgramacion de Aplicaciones Infimaticas");
            universidad.agregarCarrera(carrera);
            ds=new AccesoDatos();
            
    }
    public void createAlumno(String ced, String nom, String tel, 
            String cor, String cla, String car, String f_n){
        try {
            ds.addAlumno(new Alumno(ced,nom,tel,cor,cla,f_n,1));
        } catch (Exception ex) {
            System.out.println("Control -> createAlumno");
        }
    }
    public void createProfesor(String ced, String nom, String tel, 
            String cor, String cla){
        try {
            ds.addProfesor(new Profesor(ced,nom,tel,cor,cla,2));
        } catch (Exception ex) {
             System.out.println("Control -> createProfesor");
        }
    }
    public void createCarrera(){
        
    }
    public void createCurso(String cod, String nom, int cre, int hS){
        //ds.addCurso(new Curso(cod,nom,cre,hS), x);    falta el ciclo 
    }
    public void createGrupo(int n, String h){
        //ds.addGrupo(new Grupo(n,h), x);   como meto el curso
    }
    public void createAdmin(String ced, String nom, String tel, String cor, String cla){
        try {
            ds.addAdministrativo(new Administrativo(ced,nom,tel,cor,cla,0));
        } catch (Exception ex) {
           System.out.println("Control -> createAdmin");
        }
    }
    public void createMatri(String ced, String nom, String tel, String cor, String cla){
        try {
            ds.addMatriculador(new Matriculador(ced,nom,tel,cor,cla,3));
        } catch (Exception ex) {
            System.out.println("Control -> createMatri");
        }
    }
    
    Universidad universidad;
    Carrera carrera;
    AccesoDatos ds;  
}
