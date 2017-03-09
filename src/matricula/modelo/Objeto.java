/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula.modelo;

/**
 *
 * @author Marko
 */
public class Objeto {

    public Objeto(String nomC, int grupo, int nota) {
        this.nomC = nomC;
        this.grupo = grupo;
        this.nota = nota;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomC() {
        return nomC;
    }

    public int getGrupo() {
        return grupo;
    }

    public int getNota() {
        return nota;
    }

    public String getEstado() {
        return estado;
    }
    
    String nomC;
    int grupo;
    int nota;
    String estado;
}
