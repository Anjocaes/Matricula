package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import matricula.conexion.Conector;
import matricula.modelo.Alumno;

public class AccesoDatos {
    public AccesoDatos(){
        connect = new Conector(null,null,null);
    }
    public void addAlumno(Alumno a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s','%s','%s')";
        sql=String.format(sql,a.getCedula(),a.getNombre(),a.getTelefono(),a.getCorreo(),a.getClave(),a.getTipo(),a.getFechaNacimiento());
        int rs = connect.executeUpdate(sql);       
    }
    private final Conector connect;
    
}
