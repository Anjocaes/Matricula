package matricula.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import matricula.control.Control;

public class VentanaMatri extends JFrame {
    public VentanaMatri(String titulo, Control ct){
        super(titulo);
        gestor = ct;
        ajustarComponentes(getContentPane());
        confiEventos();
       // pack();
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void ajustarComponentes(Container c){
        c.setLayout(new BorderLayout());
        JPanel principal=new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //-----------Borde-----------------
          JPanel gen = new JPanel(new BorderLayout() );
        gen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gen.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(13,159,238)), "Usuario: Matriculador"));
        principal.add(gen, BorderLayout.CENTER);
        c.add(principal, BorderLayout.CENTER);
        //--------------Panel de info------------------------------------------
        JPanel inf= new JPanel(new GridBagLayout());
        inf.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        gc=new GridBagConstraints();
        gc.insets=new Insets(4,4,4,4);
        gc.gridx=0;
        gc.gridy=0;
        inf.add(new JLabel("Opción: "),gc);
        gc.gridx=1;
        gc.gridy=0;
        inf.add(cbm1=new JComboBox(),gc);
               cbm1.addItem(" Matricular");
               cbm1.addItem(" Desmatricular ");
               cbm1.setEditable(false);
        gc.gridx=0;
        gc.gridy=1;
        inf.add(new JLabel("Cedula del estudinte: "),gc);
        gc.gridx=1;
        gc.gridy=1;
        inf.add(ced=new JTextField(10),gc);
        gc.gridx=0;
        gc.gridy=2;
        inf.add(new JLabel("Codigo del Curso: "),gc);
        gc.gridx=1;
        gc.gridy=2;
        inf.add(cod=new JTextField(10),gc);
       
        gen.add(inf,BorderLayout.LINE_START);
        
        
    }
    public void confiEventos(){
        
    }
    public void init(){
         setVisible(true);
    }
    
    Control gestor;
    //-----Panel Info-------
    private GridBagConstraints gc;
    private JComboBox cbm1;
    private JTextField ced;
    private JTextField cod;
}
