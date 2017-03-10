/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula.vista.Modificar;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import matricula.control.Control;

/**
 *
 * @author Marko
 */
public final class ModGru extends JFrame {
    public ModGru(String titulo, Control cont, int num){
        super(titulo);
        gestor=cont;
        id = num;
        ajustarComponentes(getContentPane());
        confiEventos();
       // pack();
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
        JPanel gen = new JPanel();
        gen.setLayout(new BorderLayout());
        gen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gen.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(13,159,238)), ""));
        principal.add(gen, BorderLayout.CENTER);
        c.add(principal, BorderLayout.CENTER);
            JPanel Gru = new JPanel(new GridBagLayout());
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Gru.add(new JLabel("Numero: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Gru.add(num=new JTextField(15),gc);
                    num.setEditable(false);
            gc.gridx=0;
            gc.gridy=1;
            Gru.add(new JLabel("Horario: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Gru.add(hor= new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=2;
            Gru.add(new JLabel("Curso: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Gru.add(cur=new JTextField(15),gc);
                    cur.setEditable(false);
            gen.add(Gru,BorderLayout.CENTER);
            
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
        btA.addActionListener((ActionEvent e) -> { 
            update(); });
        btC.addActionListener((ActionEvent e) -> { cerrarApp(); });
       
       
    }
    public void update(){
         gestor.updateGru(gestor.busGru(id),"numero", num.getText(), gestor.busCu(cur.getText()));
         gestor.updateGru(gestor.busGru(id),"horario", hor.getText(), gestor.busCu(cur.getText()));
         dispose();
    }
    public void cerrarApp(){
        dispose();
    }
    public void init(){
        setVisible(true);
        llenar(id);
    }
    public void llenar(int id){
        if(gestor.busGru(id) != null){
            num.setText(String.valueOf(gestor.busGru(id).getNumero()));
            hor.setText(gestor.busGru(id).getHorario());
            cur.setText(gestor.busGru(id).getCu().getNombre());
        }
    }
    
    Control gestor;
    int id;
    GridBagConstraints gc;
    private JTextField num;
    private JTextField hor;
    private JTextField cur;
    private JButton btA;
    private JButton btC;
    private JButton btB;
}
