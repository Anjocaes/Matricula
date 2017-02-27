package matricula.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import matricula.control.Control;

public class Vista extends JFrame {
    public Vista(String titulo, Control cont){
        super(titulo);
        gestor = cont;
        ajustarComponentes(getContentPane());
        confiEventos();
       // pack();
        setMinimumSize(new Dimension(280, 200));
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void ajustarComponentes(Container c){
        c.setLayout(new BorderLayout());
        JPanel principal = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel pl=new JPanel(new FlowLayout(FlowLayout.CENTER));
        pl.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        pl.add(new JLabel("Usuario:      "));
        pl.add(usu=new JTextField(10));
            JLabel l1=new JLabel();
            l1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));
            pl.add(l1);
        pl.add(new JLabel("Clave:          "));
        pl.add(cla=new JTextField(10));
            JLabel l2=new JLabel(" ");
            l2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 65));
            pl.add(l2);
        pl.add(btA=new JButton("Entrar"));
        pl.add(btC=new JButton("Cancelar"));
    
        c.add(pl, BorderLayout.CENTER);  
    }
    public void confiEventos(){
        
    }
    public void init(){
          setVisible(true);
    }
    
    private final Control gestor;
    GridBagConstraints gc;
    //-----------Login------------------
    private JTextField usu;
    private JTextField cla;
    private JButton btA;
    private JButton btC;
}
