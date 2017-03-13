package matricula.control;

import java.util.List;
import matricula.modelo.Administrativo;
import matricula.modelo.Alumno;
import matricula.modelo.Curso;
import matricula.modelo.Grupo;
import matricula.modelo.Matriculador;
import matricula.modelo.Modelo;
import matricula.modelo.Objeto;
import matricula.modelo.Profesor;

public class Control {
   public Control(){
       datos=new Modelo();
   }
//--------------------Añadir----------------------
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
   public void addGrupo(int n, String h, Curso c){
       datos.createGrupo(n, h, c);
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
   public Curso busCu(String cod){
       return datos.busCu(cod);
   }
   public Grupo busGru(int n){
       return datos.busGru(n);
   }
   
//----------------Update--------------------------------------------
   public void updateAl(Alumno a, String cambio, String original){
       datos.updateAl(a, cambio, original);
   }
   public void updateP(Profesor a, String cambio, String original){
       datos.updatePr(a, cambio, original);
   }
   public void updateAd(Administrativo a, String cambio, String original){
       datos.updateAd(a, cambio, original);
   }
   public void updateM(Matriculador a, String cambio, String original){
       datos.updateMa(a, cambio, original);
   }
   public void updateCu(Curso c, String qCambia, String cambio){
       datos.updateCu(c, qCambia, cambio);
   }
   public void updateGru(Grupo g, String qCambia, String cambio, Curso c){
       datos.updateGru(g, qCambia, cambio, c);
   }
   
//-------------Elimiar--------------------
  public void elimAl(Alumno a){
      datos.elimAl(a);
  } 
  public void eliPr(Profesor p){
      datos.elimPr(p);
  }
  public void eliAd(Administrativo ad){
      datos.elimAd(ad);
  }
  public void eliMa(Matriculador ma){
      datos.eliMa(ma);
  }
  public void eliCu(Curso c){
      datos.eliCur(c);
  }
  public void eliGru(Grupo g){
      datos.eliGru(g);
  }
//----------Matricula---------------------------
  public void matricular(Grupo g, Alumno a){
      datos.matricula(g, a);
  }
//------------Historial----------------
  public List<Objeto> historial(String ced){
      return datos.getHist(ced);
  }
  public List<Curso> getAllCursos(){
      return datos.getAllCurso();
  }
  public List<Grupo> grupoCurso(String cod){
      return datos.getCursoPorGrupo(cod);
  }
   
    Modelo datos;
    //admin 0
    //alumno 1
    //profesor 2
    //matri 3
}
