package matricula;

import matricula.modelo.Universidad;
import matricula.modelo.Carrera;
import java.util.ArrayList;
import java.util.List;
import matricula.control.Control;
import matricula.vista.Vista;

public class Matricula {
    public static void main(String[] args) {
       Control c=new Control();
       Vista v=new Vista("Pagina de Prueba",c);
       v.init();
    }
}
