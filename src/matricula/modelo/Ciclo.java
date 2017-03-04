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
        ciclo = new Ciclo(año, numero, f_Inicio, f_Final);
    }
    
    public String getCiclo() {
        return ciclo.numero;
    }
    
    Ciclo ciclo = new Ciclo(2017, "I ciclo", "12/2/17", "21/6/17");
    int año;
    String numero;
    String fechaIni;
    String fechaFin;
}
