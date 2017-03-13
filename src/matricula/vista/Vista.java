package matricula.vista;

import matricula.vista.Mostar.VentanaAlumno;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import matricula.control.Control;
import matricula.vista.Modificar.VentanaModAl;

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
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
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
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ew){
                cerrarApp();
            }
        });
        btC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarApp();
            }
            
        });
        btA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                selecUsser();
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
    public void selecUsser(){
        String usser=usu.getText();
        String pass=cla.getText();
        if(!usu.getText().isEmpty() || !cla.getText().isEmpty()){        
            if(null != gestor.busqCAl(usser)){
                if(gestor.busqCAl(usser).getClave().equals(pass)){
                    val=new VentanaAlumno("Alumno",gestor,usser);
                    val.init();
                    dispose();
                }
            }
            if(null != gestor.busqCPr(usser)){
                if(gestor.busqCPr(usser).getClave().equals(pass)){
                    vp=new VentanaProfesor("Profesor",gestor, usser);
                    vp.init();
                    dispose();
                }
            }
            if(null != gestor.busqCAd(usser)){
                if(gestor.busqCAd(usser).getClave().equals(pass)){
                    vad= new VentanaAdmin("Administracion",gestor);
                    vad.init();
                    dispose();
                }
            }
            if(null != gestor.busqCMa(usser)){
                if(gestor.busqCMa(usser).getClave().equals(pass)){
                    vm=new VentanaMatri("Matriculador",gestor);
                    vm.init();
                    dispose();
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Los campos solicitados estan vacios");
        }
    }
    
    private final Control gestor;
    GridBagConstraints gc;
    //-----------Login------------------
    private JTextField usu;
    private JTextField cla;
    private JButton btA;
    private JButton btC;
    //----Ventanas
    private VentanaMatri vm;
    private VentanaAdmin vad;
    private VentanaModAl mod;
    private VentanaElim vel;
    private VentanaAlumno val;
    private VentanaProfesor vp;
}
