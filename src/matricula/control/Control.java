package matricula.control;

import matricula.modelo.Administrativo;
import matricula.modelo.Alumno;
import matricula.modelo.Matriculador;
import matricula.modelo.Modelo;
import matricula.modelo.Profesor;

public class Control {
   public Control(){
       datos=new Modelo();
   }
   public void addAlmuno(String ced, String nom, String tel, String cor, String cl, String car, String f_n){
      datos.createAlumno(ced, nom, tel, cor, cl, car, f_n);
   }
   public void addProfesor(String ced, String nom, String tel, String cor, String cl){
      datos.createProfesor(ced, nom, tel, cor, cl);
   }
   public void addAdmin(String ced, String nom, String tel, String cor, String cl){
       datos.createAdmin(ced, nom, tel, cor, cl);
   }
   public void addMatri(String ced, String nom, String tel, String cor, String cl){
       datos.createMatri(ced, nom, tel, cor, cl);
   }
   public void addCurso(String cod, String nom, int cre, int hS, String ciclo){
       datos.createCurso(cod, nom, cre, hS, ciclo);
   }
   public void addGrupo(){
       
   }
   //--------------Busqueda---------------------------------------------
   public Alumno busqCAl(String ced){
       return datos.busCAl(ced);
   }
   public Profesor busqCPr(String ced){
      return datos.busCPr(ced);
   }
   public Matriculador busqCMa(String ced){
       return datos.busCMa(ced);
   }
   public Administrativo busqCAd(String ced){
       return datos.busCAd(ced);
   }
   //----------------Update--------------------------------------------
   public void updateAl(Alumno a, String cambio, String original){
       datos.updateAl(a, cambio, original);
   }
   
    Modelo datos;
    //admin 0
    //alumno 1
    //profesor 2
    //matri 3
}
