package matricula.modelo;

public class Nota {

    public Nota(String curso, int nota) {
        this.curso = curso;
        this.nota = nota;
    }
    
    public String getCurso() {
        return curso;
    }

    public int getNota() {
        return nota;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    String curso;
    int nota;
}
