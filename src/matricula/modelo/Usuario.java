package matricula.modelo;

public class Usuario {

    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    
    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    String correo;
    String clave;  
}
