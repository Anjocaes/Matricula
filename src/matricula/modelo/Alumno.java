package matricula.modelo;
public class Alumno extends Persona{
    public Alumno(String cedula, String nombre, String telefono, String correo, String clave, String f_n, int tipo) {
        super(cedula, nombre, telefono, correo, clave, tipo);
        this.carrera = "Ingenieria en Sistemas";
        this.fechaNacimiento = fechaNacimiento;
        this.fechaNacimiento = f_n;
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
