package matricula.modelo;

import java.util.List;

public class Ciclo {
    public Ciclo(int año, String numero, String fechaIni, String fechaFin) {
        this.año = año;
        this.numero = numero;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }
    
    public int getAño() {
        return año;
    }

    public String getNumero() {
        return numero;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void agregarCiclo(int año, String numero, String f_Inicio, String f_Final){
        ciclo = new Ciclo(año, numero, f_Inicio, f_Final);
    }
    
    public String getCiclo() {
        return ciclo.numero;
    }
    Ciclo ciclo = new Ciclo(2017, "I ciclo", "12/2/17", "21/6/17");
    public String getFechaFin() {
        return fechaFin;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    int año;
    String numero;
    String fechaIni;
    String fechaFin;
}
