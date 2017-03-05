
package matricula.vista;

import java.awt.Container;
import javax.swing.JFrame;
import matricula.control.Control;

public class VentanaAlumno extends JFrame {
     public VentanaAlumno(String titulo, Control cont){
        super(titulo);
        gestor=cont;
        
    }
    public void AjustarComponentes(Container c){
        
    }
    public void confiEventos(){
        
    }
    public void init(){
        
    }
    
    Control gestor;
}
