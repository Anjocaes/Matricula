package AccesoDatos;

import java.sql.ResultSet;
import matricula.conexion.Conector;
import matricula.modelo.Alumno;

public class AccesoDatos {
    public AccesoDatos(){
        connect =new Conector();
    }
    public void addAlumno(Alumno a){
        String sql = "insert into persona "
                +"(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)"
                +"values ('"+a.getCedula()+"',"+"'"+a.getNombre()+"',"
                +"'"+a.getTelefono()+"',"+"',"+"'"+a.getCorreo()+"',"
                +"'"+a.getClave()+"',"+"'"+a.getTipo()+"',"+"'"
                +a.getFechaNacimiento()+"'"+")";
       // ResultSet rs = connect.executeUpdateWithKeys(sql);
    }
    private final Conector connect;
    
}
