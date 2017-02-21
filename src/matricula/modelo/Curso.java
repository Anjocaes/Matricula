package matricula.modelo;

public class Curso {
    public Curso(String codifo, String nombre, int credito, int horaSemanal) {
        this.codifo = codifo;
        this.nombre = nombre;
        this.credito = credito;
        this.horaSemanal = horaSemanal;
    }
    
    String codifo;
    String nombre;
    int credito;
    int horaSemanal;
}
