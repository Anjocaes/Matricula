/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import matricula.control.Control;
import matricula.vista.Modificar.VentanaModAl;
import matricula.vista.Mostar.VerCursos;

/**
 *
 * @author Marko
 */
public class MantGr extends JFrame{
    public MantGr(String titulo, Control cont){
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
        c.setLayout(new BorderLayout());
        JPanel principal=new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //-----------Borde-----------------
        JPanel gen = new JPanel(new BorderLayout() );
        gen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gen.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(13,159,238)), "Mantenimientos"));
        principal.add(gen, BorderLayout.CENTER);
        c.add(principal, BorderLayout.CENTER);
        
        //---------Botones---------------------------------------
        JPanel bt= new JPanel(new GridBagLayout());
        gc=new GridBagConstraints();
        gc.insets=new Insets(6,6,6,6);
        gc.gridx=0;
        gc.gridy=0;
        bt.add(btCu= new JButton("Ver cursos"),gc);
            btCu.setPreferredSize(new Dimension(120,90));
        gc.gridx=1;
        gc.gridy=0;
        bt.add(btP= new JButton("Agregar Profesor"),gc);
                btP.setPreferredSize(new Dimension(120,90));
        gc.gridx=0;
        gc.gridy=1;
        bt.add(btG= new JButton("Ver Grupos"),gc);
                btG.setPreferredSize(new Dimension(120,90));
        gen.add(bt,BorderLayout.CENTER);
        
//-------------------------------------------------
 JPanel btns= new JPanel(new GridBagLayout());
        btns.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        gc=new GridBagConstraints();
        gc.insets=new Insets(4,4,4,4);
        gc.gridx=0;
        gc.gridy=0;
        btns.add(btC=new JButton("Cancelar"),gc);
        gen.add(btns,BorderLayout.PAGE_END);
    }
    public void init(){
        setVisible(true);
    }
    public void confiEventos(){
       this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ew){
                cerrarApp();
            }
        });      
       btC.addActionListener((ActionEvent e) -> {cerrarApp();});
       btCu.addActionListener((ActionEvent e) -> {verC();});
       
      
    }
    public void cerrarApp(){
        if(JOptionPane.showConfirmDialog(this, "Desea salir", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            abrirVSA();
        }
    }
    public void abrirV(){
        v = new Vista("Login",gestor);
        v.init();
        dispose();
    }
    public void abrirVSA(){
        vad = new VentanaAdmin("Administrador",gestor);
        vad.init();
        dispose();
    }
    public void verC(){
        vc=new VerCursos("Ver Cursos",gestor);
        vc.init();
        dispose();
        
    }
    
    Control gestor;
    GridBagConstraints gc;
    //-----Botones-----
    private JButton btD;
    private JButton btP;
    private JButton btG; 
    private JButton btC; 
    private JButton btCu;
    
    //-----Ventanas------
    private Vista v;
    private VentanaAdmin vad;
    private vSAL vsal;
    private VentanaElim vElim;
    private VentanaModAl vMod;
    private VerCursos vc;
}
