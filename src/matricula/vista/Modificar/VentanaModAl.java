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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import matricula.control.Control;
import matricula.vista.VentanaAdmin;

public class VentanaModAl extends JFrame {
    public VentanaModAl(String titulo, Control cont){
        super(titulo);
        gestor=cont;
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
        gen.setLayout(new BorderLayout());
        gen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gen.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(13,159,238)), ""));
        principal.add(gen, BorderLayout.CENTER);
        c.add(principal, BorderLayout.CENTER);
        //------------------------------------------
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
//-------------Profesor-----------------------------
            Pro.setLayout(new GridBagLayout());
            Pro.setVisible(false);
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Pro.add(new JLabel("Nombre: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Pro.add(nom=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Pro.add(new JLabel("Cedula: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Pro.add(ced=new JTextField(15),gc);
                    ced.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Pro.add(new JLabel("Telefono: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Pro.add(tel=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Pro.add(new JLabel("Correo: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Pro.add(cor=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=4;
            Pro.add(new JLabel("Clave: "),gc);
            gc.gridx=1;
            gc.gridy=4;
            Pro.add(clave=new JTextField(15),gc);
//-----------------------------------------------------------
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
//-----------Alumno--------------------------------------------
            Alu.setLayout(new GridBagLayout());
            Alu.setVisible(false);
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Alu.add(new JLabel("Nombre: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Alu.add(nom=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Alu.add(new JLabel("Cedula: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Alu.add(ced=new JTextField(15),gc);
                    ced.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Alu.add(new JLabel("Telefono: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Alu.add(tel=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Alu.add(new JLabel("Correo: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Alu.add(cor=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=4;
            Alu.add(new JLabel("Fecha de Nacimiento: "),gc);
            gc.gridx=1;
            gc.gridy=4;
            Alu.add(f_nac=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=5;
            Alu.add(new JLabel("Clave: "),gc);
            gc.gridx=1;
            gc.gridy=5;
            Alu.add(clave=new JTextField(15),gc);
//-----------------Administrador--------------------
            Ad.setVisible(false);
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Ad.add(new JLabel("Nombre: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Ad.add(nom=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Ad.add(new JLabel("Cedula: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Ad.add(ced=new JTextField(15),gc);
                    ced.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Ad.add(new JLabel("Telefono: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Ad.add(tel=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Ad.add(new JLabel("Correo: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Ad.add(cor=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=4;
            Ad.add(new JLabel("Clave: "),gc);
            gc.gridx=1;
            gc.gridy=4;
            Ad.add(clave=new JTextField(15),gc);
//----------------Matriculador----------------------
            Matri.setVisible(false);
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Matri.add(new JLabel("Nombre: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Matri.add(nom=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Matri.add(new JLabel("Cedula: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Matri.add(ced=new JTextField(15),gc);
                    ced.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Matri.add(new JLabel("Telefono: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Matri.add(tel=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Matri.add(new JLabel("Correo: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Matri.add(cor=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=4;
            Matri.add(new JLabel("Clave: "),gc);
            gc.gridx=1;
            gc.gridy=4;
            Matri.add(clave=new JTextField(15),gc);
//--------------------Curso-------------------------
            Cur.setVisible(false);
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Cur.add(new JLabel("Nombre: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Cur.add(nom=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Cur.add(new JLabel("Codigo: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Cur.add(cod=new JTextField(15),gc);
                    cod.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Cur.add(new JLabel("Creditos: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Cur.add(cre=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Cur.add(new JLabel("Horas Semanales: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Cur.add(h_s=new JTextField(15),gc);
//------------------Grupo---------------------------
            Gru.setVisible(false);
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Gru.add(new JLabel("Numero: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Gru.add(nom=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Gru.add(new JLabel("Horario: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Gru.add(tit=new JTextField(15),gc);
            
    }
    public void confiEventos(){
         this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ew){
                cerrarApp();
            }
        });
      //btA.addActionListener((ActionEvent e) -> { addAdmin(); });
        btC.addActionListener((ActionEvent e) -> { cerrarApp(); });
        btB.addActionListener((ActionEvent e) -> {
            
        });
        cbm1.addActionListener((ActionEvent e) -> {
            ajusPaneles();
        });
        
    }
    public void init(){
        setVisible(true);
    }
    public void cerrarApp(){
        if(JOptionPane.showConfirmDialog(this, "Desea salir", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            vad=new VentanaAdmin("Administrador",gestor);
            vad.init();
            dispose();
        }
    }
    public void ajusPaneles(){
       String vari=(String) cbm1.getSelectedItem();
       if(vari.equals(" Profesor")){
           Pro.setVisible(true);
           Alu.setVisible(false);
           Ad.setVisible(false);
           Matri.setVisible(false);
           Gru.setVisible(false);
           Cur.setVisible(false);
           gen.add(Pro,BorderLayout.CENTER);           
       }
       if(vari.equals(" Alumno")){
           Pro.setVisible(false);
           Alu.setVisible(true);
           Ad.setVisible(false);
           Matri.setVisible(false);
           Gru.setVisible(false);
           Cur.setVisible(false);
           gen.add(Alu,BorderLayout.CENTER);
       }
       if(vari.equals(" Administrador")){
           Pro.setVisible(false);
           Alu.setVisible(false);
           Ad.setVisible(true);
           Matri.setVisible(false);
           Gru.setVisible(false);
           Cur.setVisible(false);
           gen.add(Ad,BorderLayout.CENTER);
       }
       if(vari.equals(" Matriculador")){
           Pro.setVisible(false);
           Alu.setVisible(false);
           Matri.setVisible(true);
           Ad.setVisible(false);
            Gru.setVisible(true);
            Cur.setVisible(false);
           gen.add(Matri,BorderLayout.CENTER);
       }
        if(vari.equals(" Grupo")){
           Pro.setVisible(false);
           Alu.setVisible(false);
           Matri.setVisible(false);
           Ad.setVisible(false);
           Gru.setVisible(true);
           Cur.setVisible(false);
           gen.add(Gru,BorderLayout.CENTER);
       }
        if(vari.equals(" Curso")){
           Pro.setVisible(false);
           Alu.setVisible(false);
           Matri.setVisible(false);
           Ad.setVisible(false);
           Gru.setVisible(false);
           Cur.setVisible(true);
           gen.add(Cur,BorderLayout.CENTER);
       }
    }
    public void obt(){
        
    }
    
    
    Control gestor;
    GridBagConstraints gc;
    //-----------------------------
    private JButton btA;
    private JButton btC;
    private JButton btB;
    //--------textField------------
    private JTextField nom;
    private JTextField ced;
    private JTextField tel;
    private JTextField cor;
    private JTextField f_nac;
    private JTextField clave;
    private JTextField tit;
    private JTextField cod;
    private JTextField cre;
    private JTextField h_s;
    private JTextField id;
    //------------------------------
    JPanel gen=new JPanel();
    JPanel Pro=new JPanel();
    JPanel Alu=new JPanel();
    JPanel Ad = new JPanel(new GridBagLayout());
    JPanel Matri = new JPanel(new GridBagLayout());
    JPanel Gru = new JPanel(new GridBagLayout());
    JPanel Cur = new JPanel(new GridBagLayout());
    private JComboBox cbm1;
    
    private VentanaAdmin vad;
}
