/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Usuario {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private List<Telefono> telefonos;
    public Usuario() {
        telefonos = new ArrayList<>();
    }


    
    public Usuario(String cedula, String nombre, String apellido, String correo, String contraseña) {
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setContraseña(contraseña);

    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula=validarEspacios(cedula,10);
       
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarEspacios(nombre,25);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = validarEspacios(apellido,25);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = validarEspacios(correo,50);
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = validarEspacios(contraseña,8);
    }
    public String validarEspacios(String cadena, int lon){
        if(cadena.length()==lon){
            return cadena;
        }else{
            if(cadena.length()<lon){
                return llenarEspacios(cadena,lon);
            }else{
                return cortarEspacios(cadena,lon);
            }
        }
    }
    public String llenarEspacios(String cadena, int lon){
        return String.format("%-"+lon+"s", cadena);
    }
    public String cortarEspacios(String cadena, int lon){
        return cadena.substring(0,lon);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
    public void agregarTelefono(Telefono telefono){
        telefonos.add(telefono);
    }
//Actualiza el telefono ingresado en la lista telefonos
    public void actualizarTelefono(Telefono telefono) {
        for (int i = 0; i <telefonos.size(); i++) {
            Telefono t =telefonos.get(i);
            if(t.getCodigo()==telefono.getCodigo()){
                telefonos.set(i, telefono);
                break;
            }
        }
    }

    //Elimina el telefono ingresado de la lista telefonos
    public void eliminarTelefono(Telefono telefono) {
        Iterator<Telefono> it = telefonos.iterator();
        while (it.hasNext()) {
            Telefono t = it.next();
            if (t.getCodigo() == telefono.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    //Busca el Telefono correspondiente al codigo ingresado
    public Telefono buscarTelefono(int codigo) {
        return telefonos.get(codigo);
    }

    //debuelve la lista telefonos
    public List<Telefono> listarTelefonos() {
        return telefonos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}
