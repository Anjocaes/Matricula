package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import matricula.conexion.Conector;
import matricula.modelo.Administrativo;
import matricula.modelo.Alumno;
import matricula.modelo.Ciclo;
import matricula.modelo.Curso;
import matricula.modelo.Grupo;
import matricula.modelo.Matriculador;
import matricula.modelo.Nota;
import matricula.modelo.Profesor;

public class AccesoDatos {
    public AccesoDatos(){
        connect = new Conector(null,null,null);
    }
    
    //Insert
    
    public void addAlumno(Alumno a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',0 ,'%s')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave(), a.getFechaNacimiento());
        int rs = connect.executeUpdate(sql);       
    }
    
    public void addProfesor(Profesor a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',1 ,'')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave());
        int rs = connect.executeUpdate(sql);       
    }
    
     public void addAdministrativo(Administrativo a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',2 ,'')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave());
        int rs = connect.executeUpdate(sql);       
    }
     
     public void addMatriculador(Matriculador a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s',3 ,'')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave());
        int rs = connect.executeUpdate(sql);       
    }     
     
     public void addCurso(Curso a, Ciclo x)throws Exception{
        String sql = "insert into curso(Codigo, Nombre, Credito, HSemanal, Ciclo)values ('%s','%s','%d','%d','%s')";
        sql=String.format(sql, a.getCodigo(), a.getNombre(), a.getCredito(), a.getHoraSemanal(), x.getCiclo());
        int rs = connect.executeUpdate(sql);       
    }      
     
     public void addGrupo(Grupo a, Curso x)throws Exception{
        String sql = "insert into curso(Numero, Horario, Curso)values ('%d','%s','%s')";
        sql=String.format(sql, a.getNumero(), a.getHorario(), x.getCodigo());
        int rs = connect.executeUpdate(sql);       
    }
     
     public void matricular(Grupo x, Alumno a, Profesor p)throws Exception{
        String sql = "insert into matricula(CedProfesor, CedAlumno, Grupo, Nota)values ('%s','%s','%d','%s')";
        sql=String.format(sql, p.getCedula(), a.getCedula(), x.getNumero(), "");
        int rs = connect.executeUpdate(sql);       
    }

    public void ponerNota(Grupo x, Alumno a, int n)throws Exception{
        String sql = "update matricula set nota = '%d' WHERE matricula.cedalumno = '%s' and matricula.grupo = '%s'";
        sql=String.format(sql, n, a.getCedula(), x.getNumero());
        int rs = connect.executeUpdate(sql);       
    }
    
    //Select
    //Alumno
    public Alumno alumnoGet(String cedula) throws Exception{
        String sql = "select * from persona where persona.cedula = '%s'";
        sql = String.format(sql, cedula);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toAlumno(rs);
        }else{
            throw new Exception("Alumno no existe");
        }
    }
    
    public List<Alumno> alumnoTotal()throws Exception{
        String sql = "select * from persona where persona.tipo = 0";
        sql = String.format(sql);
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Alumno obj = toAlumno(rs);
            if(obj != null)
                alum.add(obj);
            else
                throw new Exception("No existen Alumnos");
        }
        return alum;
    }
    
        public List<Alumno> alumnoGrupo(Grupo grupo)throws Exception{
        String sql = "select * from persona where matricula.grupo = '%d' and persona.tipo = 0";
        sql = String.format(sql,grupo.getNumero());
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Alumno obj = toAlumno(rs);
            if(obj != null)
                alum.add(obj);
            else
                throw new Exception("No existen Alumnos");
        }
        return alum;
    }
    
    private Alumno toAlumno(ResultSet rs){
        try {
            Alumno obj= new Alumno("","","","","","");
            //String cedula, String nombre, String telefono, String correo, String clave, String fechaNacimiento
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Clave"));
            obj.setFechaNacimiento(rs.getString("Fecha_Nacimiento"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Profesor
        public Profesor profesorGet(String cedula) throws Exception{
        String sql = "select * from persona where persona.cedula = '%s'";
        sql = String.format(sql, cedula);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toProfesor(rs);
        }else{
            throw new Exception("Alumno no existe");
        }
    }
    
    public List<Profesor> profesorTotal()throws Exception{
        String sql = "select * from persona where persona.tipo = 1";
        sql = String.format(sql);
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Profesor obj = toProfesor(rs);
            if(obj != null)
                prof.add(obj);
            else
                throw new Exception("No existen Profesor");
        }
        return prof;
    }
    
    public List<Profesor> profesorGrupo(Grupo grupo)throws Exception{
        String sql = "select * from persona where matricula.grupo = '%d' and persona.tipo = 0";
        sql = String.format(sql,grupo.getNumero());
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Profesor obj = toProfesor(rs);
            if(obj != null)
                prof.add(obj);
            else
                throw new Exception("No existen Profesor");
        }
        return prof;
    }
        
    private Profesor toProfesor(ResultSet rs){
        try {
            Profesor obj= new Profesor("","","","","");
            //String cedula, String nombre, String telefono, String correo, String clave
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Clave"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Administrativo

         public Administrativo administrativoGet(String cedula) throws Exception{
        String sql = "select * from persona where persona.cedula = '%s'";
        sql = String.format(sql, cedula);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toAdministrativo(rs);
        }else{
            throw new Exception("Administrativo no existe");
        }
    }
    
    public List<Administrativo> administrativoTotal()throws Exception{
        String sql = "select * from persona where persona.tipo = 2";
        sql = String.format(sql);
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Administrativo obj = toAdministrativo(rs);
            if(obj != null)
                adm.add(obj);
            else
                throw new Exception("No existen Administrativo");
        }
        return adm;
    }   
    
    private Administrativo toAdministrativo(ResultSet rs){
        try {
            Administrativo obj= new Administrativo("","","","","");
            //String cedula, String nombre, String telefono, String correo, String clave
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Clave"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }    
    
    //Administrativo

         public Matriculador matriculadorGet(String cedula) throws Exception{
        String sql = "select * from persona where persona.cedula = '%s'";
        sql = String.format(sql, cedula);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toMatriculador(rs);
        }else{
            throw new Exception("Matriculador no existe");
        }
    }
    
    public List<Matriculador> matriculadorTotal()throws Exception{
        String sql = "select * from persona where persona.tipo = 3";
        sql = String.format(sql);
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Matriculador obj = toMatriculador(rs);
            if(obj != null)
                mat.add(obj);
            else
                throw new Exception("No existen Matriculador");
        }
        return mat;
    }   
    
    private Matriculador toMatriculador(ResultSet rs){
        try {
            Matriculador obj= new Matriculador("","","","","");
            //String cedula, String nombre, String telefono, String correo, String clave
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Clave"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }    
    
    //Curso
    
    public Curso cursoGet(int codigo) throws Exception{
        String sql = "select * from curso where curso.codigo = '%s'";
        sql = String.format(sql, codigo);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toCurso(rs);
        }else{
            throw new Exception("Matriculador no existe");
        }
    }
    
    public List<Curso> cursoTotal()throws Exception{
        String sql = "select * from persona where persona.tipo = 3";
        sql = String.format(sql);
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Curso obj = toCurso(rs);
            if(obj != null)
                cur.add(obj);
            else
                throw new Exception("No existen Matriculador");
        }
        return cur;
    }   
    
    private Curso toCurso(ResultSet rs){
        try {
            Curso obj = new Curso("","",0,0);
            //String codigo, String nombre, int credito, int horaSemanal
            obj.setCodigo(rs.getString("Codigo"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setCredito(rs.getInt("Credito"));
            obj.setHoraSemanal(rs.getInt("HSemanal"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    } 
    
    ArrayList<Alumno> alum = new ArrayList<>();
    ArrayList<Profesor> prof = new ArrayList<>();
    ArrayList<Administrativo> adm = new ArrayList<>();
    ArrayList<Matriculador> mat = new ArrayList<>();
    ArrayList<Curso> cur = new ArrayList<>();
    ArrayList<Grupo> gru = new ArrayList<>();
    ArrayList<Nota> not = new ArrayList<>();
    private final Conector connect;
}
