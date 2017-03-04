package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import matricula.conexion.Conector;
import matricula.modelo.Administrativo;
import matricula.modelo.Alumno;
import matricula.modelo.Ciclo;
import matricula.modelo.Curso;
import matricula.modelo.Grupo;
import matricula.modelo.Matriculador;
import matricula.modelo.Profesor;

public class AccesoDatos {
    public AccesoDatos(){
        connect = new Conector(null,null,null);
    }
    public void addAlumno(Alumno a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',0 ,'%s')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave(), a.getFechaNacimiento());
        int rs = connect.executeUpdate(sql);       
    }
    
    public void addProfesor(Profesor a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',1 ,'')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave());
        int rs = connect.executeUpdate(sql);       
    }
    
     public void addAdministrativo(Administrativo a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',2 ,'')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave());
        int rs = connect.executeUpdate(sql);       
    }
     
     public void addMatriculador(Matriculador a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',3 ,'')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave());
        int rs = connect.executeUpdate(sql);       
    }     
     
     public void addCurso(Curso a, Ciclo x)throws Exception{
        String sql = "insert into curso(Codigo, Nombre, Credito, HSemanal, Ciclo)values ('%s','%s','%d','%d','%s')";
        sql=String.format(sql, a.getCodigo(), a.getNombre(), a.getCredito(), a.getHoraSemanal(), x.getCiclo());
        int rs = connect.executeUpdate(sql);       
    }      
     
     public void addGrupo(Grupo a, Curso x)throws Exception{
        String sql = "insert into curso(Numero, Horario, Curso)values ('%d','%s','%s')";
        sql=String.format(sql, a.getNumero(), a.getHorario(), x.getCodigo());
        int rs = connect.executeUpdate(sql);       
    }
     
     public void matricular(Grupo x, Alumno a, Profesor p)throws Exception{
        String sql = "insert into matricula(CedProfesor, CedAlumno, Grupo, Nota)values ('%s','%s','%d','%s')";
        sql=String.format(sql, p.getCedula(), a.getCedula(), x.getNumero(), "");
        int rs = connect.executeUpdate(sql);       
    }

    public void ponerNota(Grupo x, Alumno a, int n)throws Exception{
        String sql = "update matricula set nota = '%d' WHERE matricula.cedalumno = '%s' and matricula.grupo = '%s'";
        sql=String.format(sql, n, a.getCedula(), x.getNumero());
        int rs = connect.executeUpdate(sql);       
    }
     
    private final Conector connect;
    
}
