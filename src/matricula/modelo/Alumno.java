package matricula.modelo;
public class Alumno extends Persona{
    public Alumno(String cedula, String nombre, String telefono, String correo, String clave, String fechaNacimiento) {
        super(cedula, nombre, telefono, correo, clave);
        this.carrera = "Ingenieria en Sistemas";
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    String carrera;
    String fechaNacimiento;
}
