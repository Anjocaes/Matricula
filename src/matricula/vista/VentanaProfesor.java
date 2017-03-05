package matricula.vista;

import javax.swing.JFrame;
import matricula.control.Control;

public class VentanaProfesor extends JFrame {
    public VentanaProfesor(String titulo, Control cont){
        super(titulo);
        gestor=cont;
        
    }
    
    Control gestor;
}
