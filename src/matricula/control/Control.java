package matricula.control;

import matricula.modelo.Modelo;

public class Control {
   public Control(){
       datos=new Modelo();
   }
   public void addAlmuno(String ced, String nom, String tel, String cor, 
           String cl, String car, String f_n){
       try {
           datos.createAlumno(ced, nom, tel, cor, cl, car, f_n, 1);
       } catch (Exception ex) {
           System.out.print("Modelo -> addAlumno");
       }
   }
   public void addProfesor(String ced, String nom, String tel, String cor, 
           String cl){
       try {
           datos.createProfesor(ced, nom, tel, cor, cl, 2);
       } catch (Exception ex) {
           System.out.print("Modelo -> addProfe");
       }
   }
   
    Modelo datos;
    //admin 0
    //alumno 1
    //profesor 2
    //matri 3
}
