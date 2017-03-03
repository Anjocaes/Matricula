package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import matricula.conexion.Conector;
import matricula.modelo.Administrativo;
import matricula.modelo.Alumno;
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
     
    private final Conector connect;
    
}
