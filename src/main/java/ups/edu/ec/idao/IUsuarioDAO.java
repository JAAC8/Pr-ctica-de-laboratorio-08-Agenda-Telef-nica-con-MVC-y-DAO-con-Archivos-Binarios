/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.idao;

import java.util.List;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author user
 */
public interface IUsuarioDAO {

    //Metodos CRUD
    public void create(Usuario usuario);

    public Usuario read(String cedula);

    public void update(Usuario usuario);

    public void delete(Usuario usuario);

    public Usuario LeerCorreo(String correo);

    public Usuario login(String correo, String contraseña);
}
