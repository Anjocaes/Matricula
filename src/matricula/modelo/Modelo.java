package matricula.modelo;

import AccesoDatos.AccesoDatos;
import java.util.ArrayList;
import java.util.List;
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
            ds.addAlumno(new Alumno(ced,nom,tel,cor,cla,f_n,0));
        } catch (Exception ex) {
            System.out.println("Modelo -> createAlumno");
        }
    }
    public void createProfesor(String ced, String nom, String tel, 
            String cor, String cla){
        try {
            ds.addProfesor(new Profesor(ced,nom,tel,cor,cla,1));
        } catch (Exception ex) {
             System.out.println("Modelo -> createProfesor");
        }
    }
    public void createCarrera(){
        
    }
    public void createCurso(String cod, String nom, int cre, int hS, String ciclo){
        if(ciclo.equals(" I Ciclo")){
            try{
                ds.addCurso(new Curso(cod,nom,cre,hS), new Ciclo(2017, ciclo, "12/2/17", "21/6/17"));
            }catch(Exception ex){
                System.out.println("No entro el ciclo I");
            }
        }else{
            if(ciclo.equals(" II Ciclo")){
                try{
                    ds.addCurso(new Curso(cod,nom,cre,hS), new Ciclo(2017, ciclo, "07/08/17", "13/11/17"));
                }catch(Exception ex){
                    System.out.println("No entro el ciclo II");
                }
            }
        }
    }
    public void createGrupo(int n, String h,Curso c){
        try {   
            ds.addGrupo(new Grupo(n,h), c);
        } catch (Exception ex) {
            System.out.println("Modelo -> createGrupo");
        }
    }
    public void createAdmin(String ced, String nom, String tel, String cor, String cla){
        try {
            ds.addAdministrativo(new Administrativo(ced,nom,tel,cor,cla,2));
        } catch (Exception ex) {
           System.out.println("Modelo -> createAdmin");
        }
    }
    public void createMatri(String ced, String nom, String tel, String cor, String cla){
        try {
            ds.addMatriculador(new Matriculador(ced,nom,tel,cor,cla,3));
        } catch (Exception ex) {
            System.out.println("Modelo -> createMatri");
        }
    }
    
    //------------------------Busquedas
    public Alumno busCAl(String ced){
        try {
           return ds.alumnoGet(ced);
        } catch (Exception ex) {
            System.out.println("Modelo -> busCAl");
            return null;
        }
        //return null;
    }
    public Profesor busCPr(String ced){
        try {
            return ds.profesorGet(ced);
        } catch (Exception ex) {
            System.out.println("Modelo -> busCPr");
            return null;
        }
        //return null;
    }
    public Administrativo busCAd(String ced){
        try {
            return ds.administrativoGet(ced);
        } catch (Exception ex) {
            System.out.println("Modelo -> busCAd");
            return null;
        }
        //return null;
    }
    public Matriculador busCMa(String ced){
        try {
            return ds.matriculadorGet(ced);
        } catch (Exception ex) {
            System.out.println("Modelo -> busMatriculas");
            return null;
        }
        //return null;
    }
    public Curso busCu(String c){
        try {
            return ds.cursoGet(c);
        } catch (Exception ex) {
            System.out.println("Modelo -> busCu");
            return null;
        }
        //return null;
    }
    public Grupo busGru(int n){
        try {
            return ds.grupoGet(n);
        } catch (Exception ex) {
            System.out.println("Modelo -> busGru");
            return null;
        }
        //return null;
    }
    
    //------------Actualizar----------------------
    public void updateAl(Alumno a, String cambio, String original){
        try {
            ds.actualizarAlumno(a, cambio, original);
        } catch (Exception ex) {
            System.out.println("Modelo -> updateAlumno");
        }
    }
    public void updatePr(Profesor p, String cambio, String original){
        try {
            ds.actualizarProfesor(p, cambio, original);
        } catch (Exception ex) {
            System.out.println("Modelo -> updateProfesor");
        }
    }
    public void updateAd(Administrativo ad, String cambio, String original){
        try {
            ds.actualizarAdministrativo(ad, cambio, original);
        } catch (Exception ex) {
            System.out.println("Modelo -> updateAdmin");
        }
    }
    public void updateMa(Matriculador m, String cambio, String original){
        try {
            ds.actualizarMatriculador(m, cambio, original);
        } catch (Exception ex) {
            System.out.println("Modelo -> updatrMatri");
        }
    }
    public void updateCu(Curso a, String qCambia,String cambio){
        try {
            ds.actualizarCurso(a, qCambia, cambio);
        } catch (Exception ex) {
            System.out.println("Modelo -> updateCurso");
        }
    }
    public void updateGru(Grupo g, String qCambia, String cambio, Curso c){
        try {
            ds.actualizarGrupo(g, qCambia, cambio, c);
        } catch (Exception ex) {
            System.out.println("Modelo -> updateGrupo");
        }
    }
    
//--------------Eliminar
    public void elimAl(Alumno a){
        try {
            ds.eliminarAlumno(a);
        } catch (Exception ex) {
            System.out.println("Modelo -> ElimAl");
        }
    }
    public void elimPr(Profesor p){
        try {
            ds.eliminarProfesor(p);
        } catch (Exception ex) {
            System.out.println("Modelo -> EliPro");
        }
    }
    public void elimAd(Administrativo ad){
        try {
            ds.eliminarAdministrativo(ad);
        } catch (Exception ex) {
            System.out.println("Modelo -> EliAd");
        }
    }
    public void eliMa(Matriculador ma){
        try {
            ds.eliminarMatriculador(ma);
        } catch (Exception ex) {
            System.out.println("Modelo -> EliMa");
        }
    }
    public void eliCur(Curso c){
        try {
            ds.eliminarCurso(c);
        } catch (Exception ex) {
            System.out.println("Modelo -> EliCu");
        }
    }
    public void eliGru(Grupo g){
        try {
            ds.eliminarGrupo(g);
        } catch (Exception ex) {
            System.out.println("Modelo -> EliGru");
        }
    }
    
//---------------Matricula
    public void matricula(Grupo x, Alumno a){
        try {
            ds.matricular(x, a);
        } catch (Exception ex) {
            System.out.println("Modelo -> Matricular");
        }
    }
//--------------Historial------------
    public List<Objeto> getHist(String ced){
        try {
            return ds.alumGrupos(ced);
        } catch (Exception ex) {
            return null;
        }
    }
    public List<Curso> getAllCurso(){
        try {
            return ds.cursoTotal();
        } catch (Exception ex) {
            return null;
        }
    }
    public List<Grupo> getGrupoCurso(String cod){
        try {
            return ds.grupoCurso(cod);
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    Universidad universidad;
    Carrera carrera;
    AccesoDatos ds;  
}
