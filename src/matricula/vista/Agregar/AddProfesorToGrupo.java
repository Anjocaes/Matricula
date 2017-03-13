package matricula.vista.Agregar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import matricula.control.Control;
import matricula.vista.Modificar.ModGru;
import matricula.vista.Mostar.verGrupos;

public class AddProfesorToGrupo extends JFrame {
    public AddProfesorToGrupo(String titulo, Control cont){
        super(titulo);
        gestor=cont;
        modelo = new ModeloTabla4();
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
        gc.gridx=0;
        gc.gridy=0;
        sal.add(new JLabel("Grupos: "+ced),gc);
        c.add(sal,BorderLayout.NORTH);
//-------------------------------------------------------------------
        JPanel btns= new JPanel(new GridBagLayout());
        gc=new GridBagConstraints();
        gc.insets=new Insets(4,4,4,4);
        gc.gridx=0;
        gc.gridy=0;
        btns.add(btA=new JButton("Agregar"),gc);
        gc.gridx=1;
        gc.gridy=0;
        btns.add(btC=new JButton("Cancelar"),gc);
        gen.add(btns,BorderLayout.PAGE_END);
    }
    public void confiEventos(){
        
    }
    public void init(){
        
    }
    
    Control gestor;
    ModeloTabla4 modelo;
     private JButton btA;
    private JButton btC;
    private JButton btB;
    private JComboBox cbm1;
    private JTextField id;
    private JLabel lb;
    
    GridBagConstraints gc;
    private ModGru mg;
    private verGrupos vg;
    
    
    private JScrollPane desplazamientoTabla;
    private JTable tablaDatos;
    String ced;
    
}
class ModeloTabla4 extends DefaultTableModel {
        public ModeloTabla4() {
            super(new Object[][]{},
                    new String[]{"Numero", "Horario", "Curso"});
        }
        @Override
        public boolean isCellEditable (int filas,int Columnas){
            return false;	
	}
}


