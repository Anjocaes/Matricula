package matricula;

import matricula.modelo.Universidad;
import matricula.modelo.Carrera;
import java.util.ArrayList;
import java.util.List;

public class Matricula {
    public static void main(String[] args) {
        List<Carrera> tmp = new ArrayList<Carrera>();      
        Universidad una = new Universidad("UNA");
        Carrera info = new Carrera("abc123","movil","bachiller");
        una.agregarCarrera(info);
        tmp = una.getCarrera();
        tmp.forEach(carrera ->  System.out.println(carrera));
    }
    
}
