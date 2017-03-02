package matricula.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import matricula.control.Control;

public class vSAL extends JFrame {
    public vSAL(String titulo, Control cont){
        super(titulo);
        gestor = cont;
        ajustarComponentes(getContentPane());
        confiEventos();
        //pack();
        setMinimumSize(new Dimension(250, 300));
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void ajustarComponentes(Container c){
        c.setLayout(new BorderLayout());
        c.setLayout(new BorderLayout());
        GridBagConstraints gc;
        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        p1.add(l1 = new JLabel("Alumno"), gc);
         l1.setFont(new Font("ComicSands", Font.BOLD, 12));
        gc.gridx = 1;
        gc.gridy = 0;
        p1.add(add1 =new JButton("") , gc);
            ImageIcon iA1=new ImageIcon(getClass().getResource("/images/add.png"));
            add1.setPreferredSize(new Dimension(50, 50));
        add1.setIcon(iA1);
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 1;
        p1.add(l2 = new JLabel("Profesor"), gc);
        l2.setFont(new Font("ComicSands", Font.BOLD, 12));
        gc.gridx = 1;
        gc.gridy = 1;
        p1.add(add2 =new JButton("") , gc);
            ImageIcon iA2=new ImageIcon(getClass().getResource("/images/add.png"));
            add2.setPreferredSize(new Dimension(50, 50));
        add2.setIcon(iA2);
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 2;
        p1.add(l3 = new JLabel("Carrera     "), gc);
         l3.setFont(new Font("ComicSands", Font.BOLD, 12));
        gc.gridx = 1;
        gc.gridy = 2;
        p1.add(add3 =new JButton("") , gc);
         ImageIcon iA3=new ImageIcon(getClass().getResource("/images/add.png"));
         add3.setPreferredSize(new Dimension(50, 50));
        add3.setIcon(iA3);
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 3;
        p1.add(l4 = new JLabel("Curso   "), gc);
        l4.setFont(new Font("ComicSands", Font.BOLD, 12));
        gc.gridx = 1;
        gc.gridy = 3;
        p1.add(add4 =new JButton("") , gc);
         ImageIcon iA4=new ImageIcon(getClass().getResource("/images/add.png"));
         add4.setPreferredSize(new Dimension(50, 50));
        add4.setIcon(iA4);
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 4;
        p1.add(l4 = new JLabel("Grupo   "), gc);
        l4.setFont(new Font("ComicSands", Font.BOLD, 12));
        gc.gridx = 1;
        gc.gridy = 4;
        p1.add(add5 =new JButton("") , gc);
         ImageIcon iA5=new ImageIcon(getClass().getResource("/images/add.png"));
         add5.setPreferredSize(new Dimension(50, 50));
        add5.setIcon(iA4);
        
        c.add(BorderLayout.CENTER,p1);
        JPanel b = new JPanel(new BorderLayout());
        b.add(btC=new JButton("Cancelar"),BorderLayout.CENTER);
        c.add(b,BorderLayout.SOUTH);
    }
    public void confiEventos(){
       btC.addActionListener((ActionEvent e) -> {dispose();});
       add1.addActionListener((ActionEvent e) -> {abrirVaddA();});
       add2.addActionListener((ActionEvent e) -> {abrirVaddP();});
       add3.addActionListener((ActionEvent e) -> {abrirVaddC();});
       add4.addActionListener((ActionEvent e) -> {abrirVaddCu();});
    }
    public void init(){
        setVisible(true);
    }
    public void abrirVaddA(){
        vaddA= new VentanaAddAl("Nuevo Alumno", gestor);
        vaddA.init();
        dispose();
    }
    public void abrirVaddP(){
        vaddP=new VentanaAddPr("Nuevo Profesor",gestor);
        vaddP.init();
        dispose();
    }
    public void abrirVaddC(){
        vaddC=new VentanaAddCar("Nueva Carrera",gestor);
        vaddC.init();
        dispose();
    }
    public void abrirVaddCu(){
        vaddCu=new VentanaAddCur("Nuevo Curso", gestor);
        vaddCu.init();
        dispose();
    }
    
    Control gestor;
    
    private JPanel p1;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JButton add1;
    private JButton add2;
    private JButton add3;
    private JButton add4;
    private JButton add5;
    private JButton btC;
    
    private VentanaAddAl vaddA;
    private VentanaAddPr vaddP;
    private VentanaAddCar vaddC;
    private VentanaAddCur vaddCu;
}
