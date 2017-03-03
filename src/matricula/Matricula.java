package matricula;

import AccesoDatos.AccesoDatos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import matricula.modelo.Universidad;
import matricula.modelo.Carrera;
import java.util.ArrayList;
import java.util.List;
import matricula.conexion.Conector;
import matricula.control.Control;
import matricula.modelo.Alumno;
import matricula.vista.Vista;

public class Matricula {
    public static void main(String[] args) throws SQLException, Exception {
       Control c=new Control();
       Vista v=new Vista("Login",c);
       v.init();
    }
}
