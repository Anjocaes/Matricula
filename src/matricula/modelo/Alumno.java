package matricula.modelo;
public class Alumno extends Usuario{
    public Alumno(String cedula, String nombre, String telefono, String correo, String clave, String carrera, String fechaNacimiento) {
        super(cedula, nombre, telefono, correo, clave);
        this.carrera = carrera;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    String carrera;
    String fechaNacimiento;
}
