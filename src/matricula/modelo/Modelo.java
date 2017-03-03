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
            String cor, String cla, String car, String f_n, int t){
        try {
            ds.addAlumno(new Alumno(ced,nom,tel,cor,cla,car,f_n,t));
        } catch (Exception ex) {
           
        }
    }
    public void createProfesor(String ced, String nom, String tel, 
            String cor, String cla, int t){
        try {
            ds.addProfesor(new Profesor(ced,nom,tel,cor,cla,t));
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void createCarrera(){
        
    }
    public void createGrupo(){
        
    }
    
    Universidad universidad;
    Carrera carrera;
    AccesoDatos ds;  
}
