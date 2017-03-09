package matricula.vista;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import matricula.control.Control;

public class VentanaProfesor extends JFrame {
    public VentanaProfesor(String titulo, Control cont){
        super(titulo);
        gestor = cont;
        ajustarComponentes(getContentPane());
        confiEventos();
        //pack();
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    public void ajustarComponentes(Container c){
        
    }
    public void confiEventos(){
        
    }
    public void init(){
        
    }
    
    Control gestor;
}
