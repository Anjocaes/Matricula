
package matricula.vista.Agregar;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import matricula.control.Control;


public class VentanaAddG extends JFrame {
    public VentanaAddG(String titulo, Control cont){
        super(titulo);
        gestor = cont;
        ajustarComponentes(getContentPane());
        confiEventos();
       // pack();
        setMinimumSize(new Dimension(450, 320));
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
                BorderFactory.createLineBorder(new Color(13,159,238)), "Nuevo Grupo"));
        principal.add(gen, BorderLayout.CENTER);
        c.add(principal, BorderLayout.CENTER);
        //------------------------------------------
        JPanel inf = new JPanel(new GridBagLayout());
        gc=new GridBagConstraints();
        gc=new GridBagConstraints();
        gc.insets=new Insets(6,6,6,6);
        gc.gridx=0;
        gc.gridy=0;
        inf.add(new JLabel("Numero: "),gc);
        gc.gridx=1;
        gc.gridy=0;
        inf.add(nom=new JTextField(15),gc);
        gc.gridx=0;
        gc.gridy=1;
        inf.add(new JLabel("Horario: "),gc);
        gc.gridx=1;
        gc.gridy=1;
        inf.add(tit=new JTextField(15),gc);
        gc.gridx=0;
        gc.gridy=2;
        inf.add(new JLabel("Curso: "),gc);
        gc.gridx=1;
        gc.gridy=2;
        inf.add(cod=new JTextField(15),gc);
        
                     
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
        gen.add(inf,BorderLayout.CENTER);
    }
     public void confiEventos(){
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ew){
                cerrarApp();
            }
        });
        btA.addActionListener((ActionEvent e) -> {addG();});
        btC.addActionListener((ActionEvent e)->{dispose();});
    }
    public void init(){
        setVisible(true);
    }
    public void cerrarApp(){
        if(JOptionPane.showConfirmDialog(this, "Desea salir", "Confirmar", 
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            dispose();
        }
    }
    public boolean vali(){
        if(nom.getText().isEmpty()||cod.getText().isEmpty() || tit.getText().isEmpty()){
            return false;
        }
        return true;
    }
    public void addG(){
        if(vali()){
            if(JOptionPane.showConfirmDialog(this, "Desea añadir el nuevo grupo", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                gestor.addGrupo(Integer.parseInt(nom.getText()),tit.getText(),gestor.busCu(cod.getText())); // falta el busq curso por cod
                dispose();
            }
        }
    }
    
    Control gestor;
    GridBagConstraints gc;
    
    private JButton btA;
    private JButton btC;
    //--------textField------------
    private JTextField cod;
    private JTextField nom;
    private JTextField tit;
    private JTextField cur;
    
}
