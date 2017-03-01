/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula.vista;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import matricula.control.Control;

/**
 *
 * @author Marko
 */
public class VentanaAddAl extends JFrame{
    public VentanaAddAl(String titulo, Control cont){
        super(titulo);
        gestor = cont;
        ajustarComponentes(getContentPane());
        confiEventos();
       // pack();
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void ajustarComponentes(Container c){
        
    }
    public void confiEventos(){
        
    }
    public void init(){
        
    }
    
    //--------------
    Control gestor; 
}
