package matricula.control;

import java.util.logging.Level;
import java.util.logging.Logger;
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
           System.out.print("aqui");
       }
   }
   
    Modelo datos;
    //admin 0
    //alumno 1
    //profesor 2
    //matri 3
}
