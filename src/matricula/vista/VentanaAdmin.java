
package matricula.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import matricula.control.Control;
import matricula.vista.Modificar.VentanaModAl;

public class VentanaAdmin extends JFrame {
    public VentanaAdmin(String titulo, Control cont){
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
        //----------Ventana salir--------------------------------
        JPanel sal= new JPanel(new BorderLayout());
        sal.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        sal.add(btD= new JButton("LogOut"),BorderLayout.EAST);
        c.add(sal,BorderLayout.NORTH);
        //---------Botones---------------------------------------
        JPanel bt= new JPanel(new GridBagLayout());
        gc=new GridBagConstraints();
        gc.insets=new Insets(6,6,6,6);
        gc.gridx=0;
        gc.gridy=0;
        bt.add(btP= new JButton("Modificar"),gc);
            btP.setPreferredSize(new Dimension(120,90));
        gc.gridx=1;
        gc.gridy=0;
        bt.add(btA= new JButton("Agregar"),gc);
                btA.setPreferredSize(new Dimension(120,90));
        gc.gridx=0;
        gc.gridy=1;
        bt.add(btE= new JButton("Eliminar"),gc);
                btE.setPreferredSize(new Dimension(120,90));
        gc.gridx=1;
        gc.gridy=1;
        bt.add(btG= new JButton("Mant.Grupos"),gc);
                btG.setPreferredSize(new Dimension(120,90));
                      
        gen.add(bt,BorderLayout.CENTER);
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
       btD.addActionListener((ActionEvent e) -> {
           abrirV();
       });
       btA.addActionListener((ActionEvent e) -> {
           abrirVSA();
       });
       btP.addActionListener((ActionEvent e) -> {abrirMod();});
       btE.addActionListener((ActionEvent e) -> {abrirElim();});
    }
    public void cerrarApp(){
        if(JOptionPane.showConfirmDialog(this, "Desea salir", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            abrirV();
        }
    }
    public void abrirV(){
        v = new Vista("Login",gestor);
        v.init();
        dispose();
    }
    public void abrirVSA(){
        vsal = new vSAL("Seleccion",gestor);
        vsal.init();
    }
    public void abrirMod(){
        vMod=new VentanaModAl("Ventana Modificacion",gestor);
    }
    public void abrirElim(){
        vElim=new VentanaElim("Eliminaciones",gestor);
        vElim.init();
        dispose();
    }
     
    
    Control gestor;
    GridBagConstraints gc;
    //-----Botones-----
    private JButton btD;
    private JButton btP;
    private JButton btA; //
    private JButton btE; //ELIMINAR
    private JButton btG; //GRUPO
    
    //-----Ventanas------
    private Vista v;
    private vSAL vsal;
    private VentanaElim vElim;
    private VentanaModAl vMod;
}
