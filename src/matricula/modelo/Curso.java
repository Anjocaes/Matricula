package matricula.modelo;

import java.util.ArrayList;

public class Curso {
    public Curso(String codigo, String nombre, int credito, int horaSemanal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.credito = credito;
        this.horaSemanal = horaSemanal;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCredito() {
        return credito;
    }

    public int getHoraSemanal() {
        return horaSemanal;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public ArrayList<String> getRequerimientos() {
        return requerimientos;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setCodifo(String codifo) {
        this.codigo = codifo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public void setHoraSemanal(int horaSemanal) {
        this.horaSemanal = horaSemanal;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public void setRequerimientos(ArrayList<String> requerimientos) {
        this.requerimientos = requerimientos;
    }
    //-----------------------Requerimientos----------------------------------
    public void addReq(String s){
        requerimientos.add(s);
    }
    //--------------------------------------------------------------
    String codigo;
    String nombre;
    int credito;
    int horaSemanal;
    Ciclo ciclo;
    ArrayList<String> requerimientos =new ArrayList<>(); 
    ArrayList<Grupo> grupos = new ArrayList<>();
}
