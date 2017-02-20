package matricula.modelo;

import java.util.List;

public class Ciclo {
    public Ciclo(int año, String numero, String fechaIni, String fechaFin) {
        this.año = año;
        this.numero = numero;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }
    
    public void agregarCiclo(int año, String numero, String f_Inicio, String f_Final){
        ciclo.add(new Ciclo(año, numero, f_Inicio, f_Final));
    }
    
    public void eliminarCiclo(Ciclo cic){
        ciclo.remove(cic);
    }

    public List<Ciclo> getCiclo() {
        return ciclo;
    }
    
    List<Ciclo> ciclo;
    int año;
    String numero;
    String fechaIni;
    String fechaFin;
}
