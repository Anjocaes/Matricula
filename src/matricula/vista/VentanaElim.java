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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import matricula.control.Control;


public class VentanaElim extends JFrame {
    public VentanaElim(String titulo, Control cont){
        super(titulo);
        gestor=cont;
         ajustarComponentes(getContentPane());
        confiEventos();
       // pack();
        setMinimumSize(new Dimension(400, 350));
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
        JPanel gen=new JPanel();
        gen.setLayout(new BorderLayout());
        gen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gen.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(13,159,238)), ""));
        principal.add(gen, BorderLayout.CENTER);
        c.add(principal, BorderLayout.CENTER);
        //------------------------------------------
        JPanel mensaje = new JPanel(new GridBagLayout());
        gc=new GridBagConstraints();
        gc.insets=new Insets(4,4,4,4);
        gc.gridx=0;
        gc.gridy=0;
        mensaje.add(lb =new JLabel("Hola!"),gc);
        gen.add(mensaje,BorderLayout.CENTER);
        
        JPanel sal= new JPanel(new GridBagLayout());
        gc=new GridBagConstraints();
        gc.insets=new Insets(4,4,4,4);
        gc.gridx=0;
        gc.gridy=0;
        sal.add(new JLabel("Opción: "),gc);
        gc.gridx=1;
        gc.gridy=0;
        sal.add(cbm1=new JComboBox(),gc);
               cbm1.addItem(" Sin Especificar");
               cbm1.addItem(" Profesor");
               cbm1.addItem(" Alumno");
               cbm1.addItem(" Administrador");
               cbm1.addItem(" Matriculador");
               cbm1.addItem(" Curso");
               cbm1.addItem(" Grupo");
               cbm1.setEditable(false);
        gc.gridx=0;
        gc.gridy=1;
        sal.add(new JLabel("ID: "),gc);
        gc.gridx=1;
        gc.gridy=1;
        sal.add(id=new JTextField(10),gc);
        gc.gridx=2;
        gc.gridy=1;
        sal.add(btB=new JButton("Buscar"),gc);
        c.add(sal,BorderLayout.NORTH);
//-------------------------------------------------------------------
        JPanel btns= new JPanel(new GridBagLayout());
        gc=new GridBagConstraints();
        gc.insets=new Insets(4,4,4,4);
        gc.gridx=0;
        gc.gridy=0;
        btns.add(btA=new JButton("Aceptar"),gc);
        gc.gridx=1;
        gc.gridy=0;
        btns.add(btC=new JButton("Cancelar"),gc);
        gen.add(btns,BorderLayout.PAGE_END);
    }
    public void confiEventos(){
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ew){
                cerrarApp();
            }
        });
        btA.addActionListener((ActionEvent e) -> {elim();});
        btC.addActionListener((ActionEvent e) -> {cerrarApp();});
    }
    public void init(){
        setVisible(true);
    }
     public void cerrarApp(){
        if(JOptionPane.showConfirmDialog(this, "Desea salir", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            vAd=new VentanaAdmin("Administrador",gestor);
            vAd.init();
            dispose();
        }
    }
    public void elim(){
        String vari=(String) cbm1.getSelectedItem();
        if(vari.equals(" Alumno")){
            if(gestor.busqCAl(id.getText()) != null){
               if(JOptionPane.showConfirmDialog(this, "Confirma la eliminacion del Alumno", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    gestor.elimAl(gestor.busqCAl(id.getText()));
                    vAd=new VentanaAdmin("Administrador",gestor);
                    vAd.init();
                    dispose();
               }
            }
            
        }
        if(vari.equals(" Profesor")){
            if(gestor.busqCPr(id.getText()) != null){
               if(JOptionPane.showConfirmDialog(this, "Confirma la eliminacion del Alumno", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    gestor.eliPr(gestor.busqCPr(id.getText()));
                    vAd=new VentanaAdmin("Administrador",gestor);
                    vAd.init();
                    dispose();
               }
            }
        }
        if(vari.equals(" Administrador")){
            if(gestor.busqCAd(id.getText()) != null){
               if(JOptionPane.showConfirmDialog(this, "Confirma la eliminacion del Alumno", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    gestor.eliAd(gestor.busqCAd(id.getText()));
                    vAd=new VentanaAdmin("Administrador",gestor);
                    vAd.init();
                    dispose();
               }
            }
        }
        if(vari.equals(" Matriculador")){
            if(gestor.busqCMa(id.getText()) != null){
               if(JOptionPane.showConfirmDialog(this, "Confirma la eliminacion del Alumno", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    gestor.eliMa(gestor.busqCMa(id.getText()));
                    vAd=new VentanaAdmin("Administrador",gestor);
                    vAd.init();
                    dispose();
               }
            }
        }
        if(vari.equals(" Curso")){
            if(gestor.busCu(id.getText()) != null){
               if(JOptionPane.showConfirmDialog(this, "Confirma la eliminacion del Alumno", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    gestor.eliCu(gestor.busCu(id.getText()));
                    vAd=new VentanaAdmin("Administrador",gestor);
                    vAd.init();
                    dispose();
               }
            }
        }
        if(vari.equals(" Grupo")){
            if(gestor.busGru(Integer.parseInt(id.getText())) != null){
               if(JOptionPane.showConfirmDialog(this, "Confirma la eliminacion del Alumno", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    gestor.eliCu(gestor.busCu(id.getText()));
                    vAd=new VentanaAdmin("Administrador",gestor);
                    vAd.init();
                    dispose();
               }
            }
        }
    }
    public void bus(){
        String vari=(String) cbm1.getSelectedItem();
        if(vari.equals(" Alumno")){
            if(gestor.busqCAl(id.getText()) != null){
                System.out.println("Algo");
            }
        } else {
        }
    }
    
    Control gestor;
    
    private JButton btA;
    private JButton btC;
    private JButton btB;
    private JComboBox cbm1;
    private JTextField id;
    private JLabel lb;
    
    GridBagConstraints gc;
    private VentanaAdmin vAd;
}
