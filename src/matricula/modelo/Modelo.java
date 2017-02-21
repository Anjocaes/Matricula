package matricula.modelo;


public class Modelo {
    public Modelo(){
            universidad= new Universidad("Universidad Nacional");
            carrera =new Carrera("EIF","Ingenieria en Sistema de infomacion",
                    "Bachillerato y salida lateral de Diplomado en Prgramacion de Aplicaciones Infimaticas");
            
    }
    //----------------Metodos de carrera-------------------------------------
    public void agregarCurso(String codigo,String nombre,int cred, int h_s){
        carrera.crearCurso(codigo, nombre, cred, h_s);
    }
    public void eliminarCurso(){
        
    }
    public void busqNom(String nombre){
        
    }
     public void busqCod(String codigo){
        
    }
    //-----------------------Curso-------------------------------------------
    public void busqCursoNom(String nom){
        
    }
    public void busqCursoCod(String cod){
        
    }
    public void busqCursoCarrera(String carr){
        
    }
    public void addCurso(){
         
    }
    public void deleteCurso(){
         
    }
    public void OrdenarCurso(){
         
    }
    //----------------------Grupo--------------------------------------------
    
    //--------------------Profesor-------------------------------------------
    public void busqProfNom(String nom){
        
    }
    public void busqProfCed(String ced){
        
    }
    //--------------------Alumno---------------------------------------------
    public void busqAlumNom(String nom){
        
    }
    public void busqAlumCod(String cod){
        
    }
    public void busqAlumCarr(String carr){
        
    }
    public void historial(){
        
    }
    //-----------------------------------------------------------------------
    
    Universidad universidad;
    Carrera carrera;
    
}
