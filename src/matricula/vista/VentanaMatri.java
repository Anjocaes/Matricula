package matricula.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        //------------------Panel de Salir-------------------------------------
        JPanel sal= new JPanel(new BorderLayout());
        sal.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        sal.add(btD= new JButton("LogOut"),BorderLayout.EAST);
        c.add(sal,BorderLayout.NORTH);
        //--------------Panel de info------------------------------------------
        JPanel inf= new JPanel(new GridBagLayout());
        inf.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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
        gen.add(inf,BorderLayout.CENTER);
        //-----------------------------------------
        JPanel btns= new JPanel(new GridBagLayout());
        btns.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
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
        btC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              clean();
            }
            
        });
         btD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              abrirVL();
            }
            
        });
        
        
    }
    public void init(){
         setVisible(true);
    }
     public void cerrarApp(){
        if(JOptionPane.showConfirmDialog(this, "Desea salir", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
     public void clean(){
          ced.setText("");
          cod.setText("");
     }
     public void abrirVL(){
         v=new Vista("Login",gestor);
         v.init();
         dispose();
     }
    
    Control gestor;
    //-----Panel Info-------
    private GridBagConstraints gc;
    private JComboBox cbm1;
    private JTextField ced;
    private JTextField cod;
    //----Panel botones-----------------
    private JButton btA;
    private JButton btC;
    private JButton btD;
    //-------Panel salir------------
    
    //---Ventanas
    private Vista v;
   
}
