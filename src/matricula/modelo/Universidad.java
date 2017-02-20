package matricula.modelo;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarCarrera(Carrera car){
        carrera.add(car);
    }
    
    public void borrarCarrera(Carrera car){
        carrera.remove(car); 
    }   
    
    public List<Carrera> getCarrera(){
        return carrera;
    }
    
    public void obtenerCiclo(){
        ciclos = x.getCiclo();
    }
    
    List<Carrera> carrera = new ArrayList<>();
    List<Ciclo> ciclos;
    Ciclo x;
    String nombre;
}