
package matricula.vista.Mostar;

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
import java.util.List;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import matricula.control.Control;
import matricula.modelo.Objeto;
import matricula.vista.VentanaAdmin;

public class VentanaAlumno extends JFrame {
     public VentanaAlumno(String titulo, Control cont,String cedula){
        super(titulo);
        gestor=cont;
        this.ced=cedula;
        modelo = new ModeloTabla();
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
        
         JPanel gen=new JPanel();
        gen.setLayout(new BorderLayout());
        gen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gen.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(13,159,238)), ""));
        principal.add(gen, BorderLayout.CENTER);
        c.add(principal, BorderLayout.CENTER);
        //------------------------------------------
        JPanel pTabla=new JPanel();
        pTabla.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        pTabla.setLayout(new BorderLayout());

        desplazamientoTabla = new JScrollPane(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        tablaDatos = new JTable();
        tablaDatos.setModel(modelo);
        
        tablaDatos.setGridColor(Color.gray);
        desplazamientoTabla.setViewportView(tablaDatos);
        
        pTabla.add(BorderLayout.CENTER, desplazamientoTabla);
        gen.add(pTabla);
        
        JPanel sal= new JPanel(new GridBagLayout());
        gc=new GridBagConstraints();
        gc.insets=new Insets(4,4,4,4);
        gc.gridx=1;
        gc.gridy=0;
        sal.add(new JLabel("Oferta Academica: "),gc);
        gc.gridx=1;
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
         btB.addActionListener((ActionEvent e) -> {
             addRow();});
        btA.addActionListener((ActionEvent e) -> {});
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
     public void addRow(){
         gestor.historial(ced).stream().forEach((Objeto o) -> {modelo.addRow(new Object[]{o.getNomC(),o.getGrupo(),o.getNota(),est(o)});});
     }
     private String est(Objeto o){
         return o.getNota()==0?"Activo":"Completo";
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
    
    private JScrollPane desplazamientoTabla;
    private JTable tablaDatos;
    ModeloTabla modelo;
    String ced;
}
class ModeloTabla extends DefaultTableModel {

        public ModeloTabla() {
            super(new Object[][]{},
                    new String[]{"Curso", "Grupo", "Nota", "Estado"});
        }
    }
