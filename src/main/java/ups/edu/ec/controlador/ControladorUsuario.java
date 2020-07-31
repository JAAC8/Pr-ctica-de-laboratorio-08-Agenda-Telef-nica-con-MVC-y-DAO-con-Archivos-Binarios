/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.dao.TelefonoDAO;
import ups.edu.ec.dao.UsuarioDAO;
import ups.edu.ec.idao.ITelefonoDAO;
import ups.edu.ec.idao.IUsuarioDAO;
import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author user
 */
public class ControladorUsuario {

    private Usuario usuario;
    private Telefono telefono;

    //Objetos DAO
    private IUsuarioDAO usuarioDAO;
    private ITelefonoDAO telefonoDAO;

    //Constructor sin parametros
    public ControladorUsuario() {

    }

    //Constructor con parametros
    public ControladorUsuario(UsuarioDAO usuarioDAO, TelefonoDAO telefonoDAO) {

        this.usuarioDAO = usuarioDAO;
        this.telefonoDAO = telefonoDAO;
    }

    public void registrar(String cedula, String nombre, String apellido, String correo, String contraseña) {
        usuario = new Usuario(cedula, nombre, apellido, correo, contraseña);
        usuarioDAO.create(usuario);
    }

    public Usuario verificarUsuario() {
        return usuario;
    }

    public void actualizarUsuario(String nombre, String apellido, String cedula, String correo,
            String contraseña) {
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContraseña(contraseña);
        usuario.setCedula(cedula);
        usuarioDAO.update(usuario);

    }

    public void eliminar(String cedula) {
        usuarioDAO.delete(usuario);
    }

    public Usuario buscarUsuariosPorCedula(String cedula) {
        usuario = usuarioDAO.read(cedula);

        return usuario;
    }

    public boolean validarUsuario(String correo, String contraseña) {
        usuario = usuarioDAO.login(correo, contraseña);
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarTelefono(int codigo, String numero, String tipo, String operadora) {
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        telefonoDAO.create(telefono);
    }

    public void actualizarTelefono(int codigo, String numero, String tipo, String operadora) {
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefonoDAO.update(telefono);
    }

    public void eliminarTelefono(int codigo) {
        telefonoDAO.delete(codigo);
    }

//    public List<Telefono> listarTelefonos() {
//
//        return null;
//    }
    public void imprimirTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonoDAO.findAll();

        for (Telefono tele : telefonos) {
            System.out.println(tele.toString());
        }
    }

    public Usuario buscar(String cedula) {
        usuario = usuarioDAO.read(cedula);
        return usuario;
    }

    public Usuario buscarCorreo(String correo) {
        usuario = usuarioDAO.LeerCorreo(correo);
        if (usuario == null) {
            return null;
        } else {
            return usuario;
        }

    }

    public int codigoTelefono() {
        int conta = telefonoDAO.codigoTelefono();
        return (++conta);
    }

    public List<Telefono> listarTelefonosUsuario() {
        String cedula = usuario.getCedula().trim();

        return telefonoDAO.telefonosUsuario(cedula);
    }

    public List<Telefono> listarTelefonosTodos(String cedula) {

        return telefonoDAO.telefonosUsuario(cedula);
    }

    public List<Telefono> listarTodos() {
        return telefonoDAO.findAll();
    }

}
