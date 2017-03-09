/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricula.vista.Mostar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import matricula.modelo.Curso;
import matricula.vista.Agregar.VentanaAddAl;
import matricula.vista.VentanaAdmin;


public class VerCursos extends JFrame{
    public VerCursos(String titulo, Control cont){
        super(titulo);
        gestor=cont;
        modelo = new ModeloTabla2();
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
        sal.add(new JLabel("Oferta Academica: "),gc);
        gc.gridx=1;
        gc.gridy=0;
        sal.add(new JLabel("Carrera"),gc);
        gc.gridx=1;
        gc.gridy=1;
        sal.add(id=new JTextField(15),gc);
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
        btns.add(btA=new JButton("Agregar"),gc);
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
        btA.addActionListener((ActionEvent e) -> {abrirVaddAl();});
        btC.addActionListener((ActionEvent e) -> {cerrarApp();});
        tablaDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()== 2){
                    abrirVG();
                }
            }
        });
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
         cleanRow();
        gestor.getAllCursos().stream().forEach((Curso o) -> {modelo.addRow(new Object[]{o.getCodigo(),o.getNombre(),o.getCiclo().getNumero()});});
     }
     public void cleanRow(){
         for(int i=0;i<tablaDatos.getRowCount();i++){
             modelo.removeRow(i);
             i-=1;
         }
     }
     public void abrirVaddAl(){
         vaddA=new VentanaAddAl("Agregar",gestor);
         vaddA.init();
         dispose();
     }
     public void abrirVG(){
         int i= tablaDatos.getSelectedRow();
         String cod = (String) tablaDatos.getValueAt(i, 0);
         vg= new verGrupos("Grupos: "+cod,gestor,cod);
         vg.init();
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
    private VentanaAddAl vaddA;
    private verGrupos vg;
    
    private JScrollPane desplazamientoTabla;
    private JTable tablaDatos;
    ModeloTabla2 modelo;
    String ced;
}
class ModeloTabla2 extends DefaultTableModel {
        public ModeloTabla2() {
            super(new Object[][]{},
                    new String[]{"Codigo", "Horario","Ciclo"});
        }
        @Override
        public boolean isCellEditable (int filas,int Columnas){
            return false;	
	}
    }
