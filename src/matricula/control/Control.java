package matricula.control;

import matricula.modelo.Modelo;

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
   public void addCurso(String cod, String nom, int cre, int hS){
       datos.createCurso(cod, nom, cre, hS);
   }
   public void addGrupo(){
       
   }
   
    Modelo datos;
    //admin 0
    //alumno 1
    //profesor 2
    //matri 3
}
