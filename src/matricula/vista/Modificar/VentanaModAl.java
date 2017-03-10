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
import matricula.modelo.Alumno;
import matricula.modelo.Curso;
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
            Pro.add(nom2=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Pro.add(new JLabel("Cedula: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Pro.add(ced2=new JTextField(15),gc);
                    ced2.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Pro.add(new JLabel("Telefono: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Pro.add(tel2=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Pro.add(new JLabel("Correo: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Pro.add(cor2=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=4;
            Pro.add(new JLabel("Clave: "),gc);
            gc.gridx=1;
            gc.gridy=4;
            Pro.add(clave2=new JTextField(15),gc);
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
            
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Alu.add(new JLabel("Nombre: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Alu.add(nom1=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Alu.add(new JLabel("Cedula: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Alu.add(ced1=new JTextField(15),gc);
                    ced1.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Alu.add(new JLabel("Telefono: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Alu.add(tel1=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Alu.add(new JLabel("Correo: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Alu.add(cor1=new JTextField(15),gc);
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
            Alu.add(clave1=new JTextField(15),gc);
//-----------------Administrador--------------------
            
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Ad.add(new JLabel("Nombre: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Ad.add(nom3=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Ad.add(new JLabel("Cedula: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Ad.add(ced3=new JTextField(15),gc);
                    ced3.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Ad.add(new JLabel("Telefono: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Ad.add(tel3=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Ad.add(new JLabel("Correo: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Ad.add(cor3=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=4;
            Ad.add(new JLabel("Clave: "),gc);
            gc.gridx=1;
            gc.gridy=4;
            Ad.add(clave3=new JTextField(15),gc);
//----------------Matriculador----------------------
           
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Matri.add(new JLabel("Nombre: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Matri.add(nom4=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=1;
            Matri.add(new JLabel("Cedula: "),gc);
            gc.gridx=1;
            gc.gridy=1;
            Matri.add(ced4=new JTextField(15),gc);
                    ced4.setEditable(false);
            gc.gridx=0;
            gc.gridy=2;
            Matri.add(new JLabel("Telefono: "),gc);
            gc.gridx=1;
            gc.gridy=2;
            Matri.add(tel4=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=3;
            Matri.add(new JLabel("Correo: "),gc);
            gc.gridx=1;
            gc.gridy=3;
            Matri.add(cor4=new JTextField(15),gc);
            gc.gridx=0;
            gc.gridy=4;
            Matri.add(new JLabel("Clave: "),gc);
            gc.gridx=1;
            gc.gridy=4;
            Matri.add(clave4=new JTextField(15),gc);
//--------------------Curso-------------------------
            
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
            gc.gridx=0;
            gc.gridy=4;
            Cur.add(new JLabel("Ciclo: "),gc);
            gc.gridx=1;
            gc.gridy=4;
            Cur.add(ci=new JTextField(15),gc);
                    ci.setEditable(false);
//------------------Grupo---------------------------
           
            gc=new GridBagConstraints();
            gc=new GridBagConstraints();
            gc.insets=new Insets(6,6,6,6);
            gc.gridx=0;
            gc.gridy=0;
            Gru.add(new JLabel("Numero: "),gc);
            gc.gridx=1;
            gc.gridy=0;
            Gru.add(num=new JTextField(15),gc);
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
        btB.addActionListener((ActionEvent e) -> {
            obt();});
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
        String vari=(String) cbm1.getSelectedItem();
        if(!(vari.equals(" Sin Especificar")) || !(id.getText().isEmpty())){
            if(vari.equals(" Alumno")){
                if(! gestor.busqCAl(id.getText()).equals(null)){
                     nom1.setText( gestor.busqCAl(id.getText()).getNombre()); 
                     ced1.setText( gestor.busqCAl(id.getText()).getCedula());
                     tel1.setText( gestor.busqCAl(id.getText()).getTelefono());
                     cor1.setText( gestor.busqCAl(id.getText()).getCorreo());
                     f_nac.setText( gestor.busqCAl(id.getText()).getFechaNacimiento());
                     clave1.setText( gestor.busqCAl(id.getText()).getClave());
                }
            }
            if(vari.equals(" Profesor")){
                if(! gestor.busqCPr(id.getText()).equals(null)){
                     nom2.setText( gestor.busqCPr(id.getText()).getNombre()); 
                     ced2.setText( gestor.busqCPr(id.getText()).getCedula());
                     tel2.setText( gestor.busqCPr(id.getText()).getTelefono());
                     cor2.setText( gestor.busqCPr(id.getText()).getCorreo());
                     clave2.setText( gestor.busqCPr(id.getText()).getClave());
                }
            }
            if(vari.equals(" Administrador")){
                if(! gestor.busqCAd(id.getText()).equals(null)){
                     nom3.setText( gestor.busqCAd(id.getText()).getNombre()); 
                     ced3.setText( gestor.busqCAd(id.getText()).getCedula());
                     tel3.setText( gestor.busqCAd(id.getText()).getTelefono());
                     cor3.setText( gestor.busqCAd(id.getText()).getCorreo());
                     clave3.setText( gestor.busqCAd(id.getText()).getClave());
                }
            }
            if(vari.equals(" Matriculador")){
                if(! gestor.busqCMa(id.getText()).equals(null)){
                     nom4.setText( gestor.busqCMa(id.getText()).getNombre()); 
                     ced4.setText( gestor.busqCMa(id.getText()).getCedula());
                     tel4.setText( gestor.busqCMa(id.getText()).getTelefono());
                     cor4.setText( gestor.busqCMa(id.getText()).getCorreo());
                     clave4.setText( gestor.busqCMa(id.getText()).getClave());
                }
            }
            if(vari.equals(" Curso")){
                //Curso cu=gestor.busCu(id.getText());
                if( gestor.busCu(id.getText()) != null){
                    nom.setText(gestor.busCu(id.getText()).getNombre());
                    cod.setText(gestor.busCu(id.getText()).getCodigo());
                    cre.setText(String.valueOf(gestor.busCu(id.getText()).getCredito()));
                    h_s.setText(String.valueOf(gestor.busCu(id.getText()).getHoraSemanal()));
                    ci.setText(gestor.busCu(id.getText()).getCiclo().getNumero());   
                }
                else{
                    JOptionPane.showMessageDialog(this, "El curso no existe");
                }
            }
            if(vari.equals(" Grupo")){
                //Curso cu=gestor.busCu(id.getText());
                if(! gestor.busGru(Integer.parseInt(id.getText())).equals(null)){
                    num.setText(""+gestor.busGru(Integer.parseInt(id.getText())).getNumero());
                    hor.setText(gestor.busGru(Integer.parseInt(id.getText())).getHorario());
                    cur.setText(gestor.busGru(Integer.parseInt(id.getText())).getCu().getNombre());
                    
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Los campos para la busqueda son incorrectos");
        }
    }
    public void update(){
        String vari=(String) cbm1.getSelectedItem();
            if(JOptionPane.showConfirmDialog(this, "Seguro que desea realizar los cambios", "Confirmar", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                if(vari.equals(" Alumno")){
                    gestor.updateAl(gestor.busqCAl(id.getText()),"nombre", nom1.getText());
                    gestor.updateAl(gestor.busqCAl(id.getText()),"telefono", tel1.getText());
                    gestor.updateAl(gestor.busqCAl(id.getText()),"correo", cor1.getText());
                    gestor.updateAl(gestor.busqCAl(id.getText()),"clave", clave1.getText());
                    gestor.updateAl(gestor.busqCAl(id.getText()),"fecha_nacimiento", f_nac.getText());
                    confirm();
                }
                if(vari.equals(" Profesor")){
                    gestor.updateP(gestor.busqCPr(id.getText()),"nombre", nom2.getText());
                    gestor.updateP(gestor.busqCPr(id.getText()),"telefono", tel2.getText());
                    gestor.updateP(gestor.busqCPr(id.getText()),"correo", cor2.getText());
                    gestor.updateP(gestor.busqCPr(id.getText()),"clave", clave2.getText());
                    confirm();
                }
                if(vari.equals(" Administrativo")){
                    gestor.updateAd(gestor.busqCAd(id.getText()),"nombre", nom3.getText());
                    gestor.updateAd(gestor.busqCAd(id.getText()),"telefono", tel3.getText());
                    gestor.updateAd(gestor.busqCAd(id.getText()),"correo", cor3.getText());
                    gestor.updateAd(gestor.busqCAd(id.getText()),"clave", clave3.getText());
                    confirm();
                }
                if(vari.equals(" Matriculador")){
                    gestor.updateM(gestor.busqCMa(id.getText()),"nombre", nom4.getText());
                    gestor.updateM(gestor.busqCMa(id.getText()),"telefono", tel4.getText());
                    gestor.updateM(gestor.busqCMa(id.getText()),"correo", cor4.getText());
                    gestor.updateM(gestor.busqCMa(id.getText()),"clave", clave4.getText());
                    confirm();
                }
                if(vari.equals(" Curso")){
                    gestor.updateCu(gestor.busCu(id.getText()),"nombre", nom.getText());
                    gestor.updateCu(gestor.busCu(id.getText()),"credito", cre.getText());
                    gestor.updateCu(gestor.busCu(id.getText()),"hsemanal", h_s.getText());
                    confirm();
                }
                if(vari.equals(" Grupo")){
                    gestor.updateGru(gestor.busGru(Integer.parseInt(id.getText())),"numero", num.getText(), gestor.busCu(cur.getText()));
                    gestor.updateGru(gestor.busGru(Integer.parseInt(id.getText())),"horario", hor.getText(), gestor.busCu(cur.getText()));
                    confirm();
                }
            }
        
    }
    public void confirm(){
        vad=new VentanaAdmin("Administracion",gestor);
        vad.init();
        dispose();
    }
    
    
    Control gestor;
    GridBagConstraints gc;
    //-----------------------------
    private JButton btA;
    private JButton btC;
    private JButton btB;
    //--------textField------------
    private JTextField nom1;    //alumno
    private JTextField nom2;    //Profesor
    private JTextField nom3;    //Admin
    private JTextField nom4;    //Matri
    private JTextField nom5;    //Curso
    private JTextField nom;
    private JTextField ced1;    //Alumno
    private JTextField ced2;    //Profesor
    private JTextField ced3;    //Administrador
    private JTextField ced4;    //Matri
    private JTextField ced5;
    private JTextField tel1;
    private JTextField tel2;
    private JTextField tel3;
    private JTextField tel4;
    private JTextField tel5;
    private JTextField cor1;
    private JTextField cor2;
    private JTextField cor3;
    private JTextField cor4;
    private JTextField clave1;
    private JTextField clave2;
    private JTextField clave3;
    private JTextField clave4;
    private JTextField num;
    private JTextField f_nac;
    private JTextField hor;
    private JTextField cod;
    private JTextField cre;
    private JTextField h_s;
    private JTextField id;
    private JTextField ci;
    private JTextField cur;
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
