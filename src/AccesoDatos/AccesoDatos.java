package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import matricula.conexion.Conector;
import matricula.modelo.Administrativo;
import matricula.modelo.Alumno;
import matricula.modelo.Curso;
import matricula.modelo.Matriculador;
import matricula.modelo.Profesor;

public class AccesoDatos {
    public AccesoDatos(){
        connect = new Conector(null,null,null);
    }
    public void addAlumno(Alumno a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',%d,'%s')";
        sql=String.format(sql,a.getCedula(),a.getNombre(),a.getTelefono(),a.getCorreo(),a.getClave(),a.getTipo(),a.getFechaNacimiento());
        int rs = connect.executeUpdate(sql);       
    }
    
    public void addProfesor(Profesor a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo)values ('%s','%s','%s','%s','%s',1,'')";
        sql=String.format(sql,a.getCedula(),a.getNombre(),a.getTelefono(),a.getCorreo(),a.getClave());
        int rs = connect.executeUpdate(sql);       
    }
    
     public void addAdministrativo(Administrativo a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo)values ('%s','%s','%s','%s','%s',2,'')";
        sql=String.format(sql,a.getCedula(),a.getNombre(),a.getTelefono(),a.getCorreo(),a.getClave());
        int rs = connect.executeUpdate(sql);       
    }
     
     public void addMatriculador(Matriculador a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo)values ('%s','%s','%s','%s','%s',3,'')";
        sql=String.format(sql,a.getCedula(),a.getNombre(),a.getTelefono(),a.getCorreo(),a.getClave(),a.getTipo());
        int rs = connect.executeUpdate(sql);       
    }     
     
     public void addCurso(Curso a)throws Exception{
        String sql = "insert into curso(Codigo, Nombre, Credito, HSemanal, Grupo)values ('%s','%s','%s','%s','%s')";
        sql=String.format(sql,a.getCodigo(),a.getNombre(),a.getCredito(),a.getHoraSemanal(),"","");
        int rs = connect.executeUpdate(sql);       
    }      
     /*  `Codigo` VARCHAR(12) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Credito` INT NOT NULL,
  `HSemanal` INT NOT NULL,
  `Grupo` INT NOT NULL,*/
     
     public void addCurso(Curso a)throws Exception{
        String sql = "insert into curso(Codigo, Nombre, Credito, HSemanal, Grupo)values ('%s','%s','%s','%s','%s')";
        sql=String.format(sql,a.getCodigo(),a.getNombre(),a.getCredito(),a.getHoraSemanal(),"","");
        int rs = connect.executeUpdate(sql);       
    }
     
    private final Conector connect;
    
}
