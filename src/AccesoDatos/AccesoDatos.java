package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
  
    //Alumno
    public void addAlumno(Alumno a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s', '%d', '%s')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave(), a.getTipo(), a.getFechaNacimiento());
        int rs = connect.executeUpdate(sql);       
    }
    
    //Profesor
    public void addProfesor(Profesor a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s', '%d', '')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave(), a.getTipo());
        int rs = connect.executeUpdate(sql);       
    }
    
    //Administrativo
     public void addAdministrativo(Administrativo a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s', '%d', '')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave(), a.getTipo());
        int rs = connect.executeUpdate(sql);       
    }
     
    //Matriculador 
     public void addMatriculador(Matriculador a)throws Exception{
        String sql = "insert into persona(Cedula, Nombre, Telefono, Correo, Clave, Tipo, Fecha_Nacimiento)values ('%s','%s','%s','%s','%s', '%d', '')";
        sql=String.format(sql, a.getCedula(), a.getNombre(), a.getTelefono(), a.getCorreo(), a.getClave(), a.getTipo());
        int rs = connect.executeUpdate(sql);       
    }     
     
    //Curso 
     public void addCurso(Curso a, Ciclo x)throws Exception{
        String sql = "insert into curso(Codigo, Nombre, Credito, HSemanal, Ciclo)values ('%s','%s','%d','%d','%s')";
        sql=String.format(sql, a.getCodigo(), a.getNombre(), a.getCredito(), a.getHoraSemanal(), x.getNumero());
        int rs = connect.executeUpdate(sql);       
    }      
     
    //Grupo 
     public void addGrupo(Grupo a, Curso x)throws Exception{
        String sql = "insert into grupo(Numero, Horario, Curso)values ('%d','%s','%s')";
        sql=String.format(sql, a.getNumero(), a.getHorario(), x.getCodigo());
        int rs = connect.executeUpdate(sql);       
    }
    
     //Matricula
     public void matricular(Grupo x, Alumno a)throws Exception{
        String sql = "insert into matricula(CedProfesor, CedAlumno, Grupo, Nota)values ('','%s','%d','%s')";
        sql=String.format(sql, a.getCedula(), x.getNumero(), "");
        int rs = connect.executeUpdate(sql);       
    }
     
    //Pone el profesor
    public void ponerProfesor(Profesor p, Grupo g, Curso c)throws Exception{
        String sql = "update matricula set CedProfesor = '%s' where matricula.Grupo = '%d' and grupo.curso = '%s'";
        sql=String.format(sql, p.getCedula(), g.getNumero(), c.getCodigo());
        int rs = connect.executeUpdate(sql);       
    }
     
    //Pone la nota
    public void ponerNota(Grupo x, Alumno a, int n)throws Exception{
        String sql = "update matricula set nota = '%d' WHERE matricula.cedalumno = '%s' and matricula.grupo = '%d'";
        sql=String.format(sql, n, a.getCedula(), x.getNumero());
        int rs = connect.executeUpdate(sql);       
    }
    
//----------------------------------------Select
    
    //Alumno
    public Alumno alumnoGet(String cedula) throws Exception{
        String sql = "select * from persona where persona.cedula = '%s' and persona.tipo = 0";
        sql = String.format(sql, cedula);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toAlumno(rs);
        }else{
            throw new Exception("Alumno no existe");
        }
    }
    
    public Alumno alumnoGetNombre(String nombre) throws Exception{
        String sql = "select * from persona where persona.nombre = '%s' and persona.tipo = 0";
        sql = String.format(sql, nombre);
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
        String sql = "select * from persona, matricula where matricula.grupo = '%d' and persona.tipo = 0";
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
            Alumno obj= new Alumno("","","","","","",0);
            //String cedula, String nombre, String telefono, String correo, String clave, String fechaNacimiento
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Clave"));
            obj.setTipo(rs.getInt("Tipo"));
            obj.setFechaNacimiento(rs.getString("Fecha_Nacimiento"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Profesor
    public Profesor profesorGet(String cedula) throws Exception{
        String sql = "select * from persona where persona.cedula = '%s' and persona.tipo = 1";
        sql = String.format(sql, cedula);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toProfesor(rs);
        }else{
            throw new Exception("Alumno no existe");
        }
    }

    public Profesor profesorGetNombre(String nombre) throws Exception{
        String sql = "select * from persona where persona.nombre = '%s' and persona.tipo = 1";
        sql = String.format(sql, nombre);
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
        String sql = "select * from persona, matricula where matricula.grupo = '%d' and persona.tipo = 1";
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
            Profesor obj= new Profesor("","","","","",0);
            //String cedula, String nombre, String telefono, String correo, String clave
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Clave"));
            obj.setTipo(rs.getInt("Tipo"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
 
    //Administrativo
    public Administrativo administrativoGet(String cedula) throws Exception{
        String sql = "select * from persona where persona.cedula = '%s' and persona.tipo = 2";
        sql = String.format(sql, cedula);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toAdministrativo(rs);
        }else{
            throw new Exception("Administrativo no existe");
        }
    }
    
    public Administrativo administrativoGetNombre(String nombre) throws Exception{
        String sql = "select * from persona where persona.nombre = '%s' and persona.tipo = 2";
        sql = String.format(sql, nombre);
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
            Administrativo obj= new Administrativo("","","","","",0);
            //String cedula, String nombre, String telefono, String correo, String clave
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Clave"));
            obj.setTipo(rs.getInt("Tipo"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }    
    
    //Matriculador
    public Matriculador matriculadorGet(String cedula) throws Exception{
        String sql = "select * from persona where persona.cedula = '%s' and persona.tipo = 3";
        sql = String.format(sql, cedula);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toMatriculador(rs);
        }else{
            throw new Exception("Matriculador no existe");
        }
    }
    
    public Matriculador matriculadorGetNombre(String nombre) throws Exception{
        String sql = "select * from persona where persona.nombre = '%s' and persona.tipo = 3";
        sql = String.format(sql, nombre);
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
            Matriculador obj= new Matriculador("","","","","",0);
            //String cedula, String nombre, String telefono, String correo, String clave
            obj.setCedula(rs.getString("Cedula"));
            obj.setNombre(rs.getString("Nombre"));
            obj.setTelefono(rs.getString("Telefono"));
            obj.setCorreo(rs.getString("Correo"));
            obj.setClave(rs.getString("Clave"));
            obj.setTipo(rs.getInt("Tipo"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }    
    
    //Curso
    public Curso cursoGet(String codigo) throws Exception{
        String sql = "select * from curso where curso.codigo = '%s'";
        sql = String.format(sql, codigo);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toCurso(rs);
        }else{
            throw new Exception("Curso no existe");
        }
    }
    
    public List<Curso> cursoTotal()throws Exception{
        String sql = "select * from curso";
        sql = String.format(sql);
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Curso obj = toCurso(rs);
            if(obj != null)
                cur.add(obj);
            else
                throw new Exception("No existen Curso");
        }
        return cur;
    }   
    
    private Curso toCurso(ResultSet rs){
        try {
            Curso obj = new Curso("","",0,0);
            //String codigo, String nombre, int credito, int horaSemanal
            obj.setCodigo(rs.getString("Codigo"));
            obj.setNombre(rs.getString("Nombre"));
            System.out.println(""+rs.getString("Nombre"));
            obj.setCredito(rs.getInt("Credito"));
            obj.setHoraSemanal(rs.getInt("HSemanal"));
            obj.setCiclo(new Ciclo(2017,rs.getString("Ciclo"),"07/08/17","13/11/17"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    } 
    
    //Grupo   
    public Grupo grupoGet(int numero) throws Exception{
        String sql = "select * from grupo where grupo.numero = '%d'";
        sql = String.format(sql, numero);
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toGrupo(rs);
        }else{
            throw new Exception("Grupo no existe");
        }
    }
    
    public List<Grupo> grupoTotal()throws Exception{
        String sql = "select * from grupo";
        sql = String.format(sql);
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Grupo obj = toGrupo(rs);
            if(obj != null)
                gru.add(obj);
            else
                throw new Exception("No existen Grupo");
        }
        return gru;
    }
    
    public List<Grupo> grupoCurso(Curso c)throws Exception{
        String sql = "select * from grupo where grupo.curso = '%s'";
        sql = String.format(sql);
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Grupo obj = toGrupo(rs);
            if(obj != null)
                gru.add(obj);
            else
                throw new Exception("No existen Grupo");
        }
        return gru;
    } 
    //Profe ver los cursos que tiene
    
    public List<Grupo> profesorCurso(Profesor a)throws Exception{
        String sql = "select * from grupo, matricula where matricula.CedProfesor = '%s'";
        sql = String.format(sql, a.getCedula());
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Grupo obj = toGrupo(rs);
            if(obj != null)
                gru.add(obj);
            else
                throw new Exception("No existen Grupo");
        }
        return gru;
    }
    
    private Grupo toGrupo(ResultSet rs){
        try {
            Grupo obj = new Grupo(0,"");
            //int numero, String horario
            obj.setNumero(rs.getInt("Numero"));
            obj.setHorario(rs.getString("Horario"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Nota
    public Nota unaNota(Alumno a, Curso c) throws Exception{
        String sql = "select nota from matricula, grupo where matricula.CedAlumno = '%s' and grupo.curso = '%s'";
        sql = String.format(sql, a.getCedula(), c.getCodigo());
        ResultSet rs =  connect.executeQuery(sql);
        if (rs.next()){
            return  toNota(rs);
        }else{
            throw new Exception("Grupo no existe");
        }
    }
    
    public List<Nota> notasCurso(Curso c)throws Exception{
        String sql = "select nota from matricula, grupo where grupo.curso = '%s'";
        sql = String.format(sql, c.getCodigo());
        ResultSet rs =  connect.executeQuery(sql);
        while (rs.next()){
            Nota obj = toNota(rs);
            if(obj != null)
                not.add(obj);
            else
                throw new Exception("No existen Grupo");
        }
        return not;
    }
    
    private Nota toNota(ResultSet rs){
        try {
            Nota obj = new Nota("",0);
            //int numero, String horario
            obj.setCurso(rs.getString("Ciclo"));
            obj.setNota(rs.getInt("Nota"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Eliminar
    
    //Alumno
    public void eliminarAlumno(Alumno a)throws Exception{
        String sql = "delete from persona where persona.cedula = '%s' and persona.tipo = 0";
        sql=String.format(sql, a.getCedula());
        int rs = connect.executeUpdate(sql);          
    }
    
    //Profesor
    public void eliminarProfesor(Profesor a)throws Exception{
        String sql = "delete from persona where persona.cedula = '%s' and persona.tipo = 1";
        sql=String.format(sql, a.getCedula(), a.getTipo());
        int rs = connect.executeUpdate(sql);          
    }
   
    //Administrativo
    public void eliminarAdministrativo(Administrativo a)throws Exception{
        String sql = "delete from persona where persona.cedula = '%s' and persona.tipo = 1";
        sql=String.format(sql, a.getCedula(), a.getTipo());
        int rs = connect.executeUpdate(sql);          
    }    

    //Matriculador
    public void eliminarMatriculador(Matriculador a)throws Exception{
        String sql = "delete from persona where persona.cedula = '%s' and persona.tipo = 1";
        sql=String.format(sql, a.getCedula(), a.getTipo());
        int rs = connect.executeUpdate(sql);          
    }

    //Curso
    public void eliminarCurso(Curso a)throws Exception{
        String sql = "delete from curso where curso.codigo = '%s'";
        sql=String.format(sql, a.getCodigo());
        int rs = connect.executeUpdate(sql);          
    }  
   
    //Grupo
   public  void eliminarGrupo(Grupo a)throws Exception{
        String sql = "delete from grupo where grupo.codigo = '%d'";
        sql=String.format(sql, a.getNumero());
        int rs = connect.executeUpdate(sql);          
    }      

    //Update
    
    //Alumno
    public void actualizarAlumno(Alumno a, String qCambia, String cambio)throws Exception{
        String sql = "update persona set %s = '%s' where persona.cedula = '%s' and persona.tipo = 0";
        sql=String.format(sql, qCambia, cambio, a.getCedula());
        int rs = connect.executeUpdate(sql);       
    }

    //Profesor
    public void actualizarProfesor(Profesor a, String qCambia, String cambio)throws Exception{
        String sql = "update persona set %s = '%s' where persona.cedula = '%s' and persona.tipo = 1";
        sql=String.format(sql, qCambia, cambio, a.getCedula());
        int rs = connect.executeUpdate(sql);       
    }

    //Administrativo
    public void actualizarAdministrativo(Administrativo a, String qCambia, String cambio)throws Exception{
        String sql = "update persona set %s = '%s' where persona.cedula = '%s' and persona.tipo = 1";
        sql=String.format(sql, qCambia, cambio, a.getCedula());
        int rs = connect.executeUpdate(sql);       
    }   
    
    //Matriculador
    public void actualizarMatriculador(Matriculador a, String qCambia, String cambio)throws Exception{
        String sql = "update persona set %s = '%s' where persona.cedula = '%s' and persona.tipo = 1";
        sql=String.format(sql, qCambia, cambio, a.getCedula());
        int rs = connect.executeUpdate(sql);       
    }
    
    //Curso
    public void actualizarCurso(Curso a, String qCambia, String cambio)throws Exception{
        String sql = "update curso set %s = '%s' where curso.codigo = '%s'";
        sql=String.format(sql, qCambia, cambio, a.getCodigo());
        int rs = connect.executeUpdate(sql);       
    } 
    
    //Grupo
    public void actualizarGrupo(Grupo a, String qCambia, String cambio, Curso c)throws Exception{
        String sql = "update grupo set %s = '%s' where grupo.numero = '%d' and grupo.curso = '%s'";
        sql=String.format(sql, qCambia, cambio, a.getNumero(), c.getCodigo());
        int rs = connect.executeUpdate(sql);       
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
