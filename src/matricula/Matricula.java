package matricula;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import matricula.modelo.Universidad;
import matricula.modelo.Carrera;
import java.util.ArrayList;
import java.util.List;
import matricula.conexion.Conector;
import matricula.control.Control;
import matricula.vista.Vista;

public class Matricula {
    public static void main(String[] args) throws SQLException {
        Conector conec = new Conector();
        Connection x = conec.getCon();
        System.out.println("Insertando ...");
        Statement s = x.createStatement();
        String query1 = "insert into carrera(Codigo,Nombre,Titulo) values (\"2\",\"mate\",\"bachi\");";
        s.executeUpdate(query1);
       Control c=new Control();
       Vista v=new Vista("Pagina de Prueba",c);
       v.init();
    }
}
