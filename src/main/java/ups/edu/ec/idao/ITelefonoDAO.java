/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.idao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import ups.edu.ec.modelo.Telefono;

/**
 *
 * @author user
 */
public interface ITelefonoDAO {

    public void create(Telefono telefono);

    public Telefono read(int codigo);

    public void update(Telefono telefono);

    public void delete(int codigo);

    public List<Telefono> findAll();

    public int obtenerUltimoCodigo();

    public List<Telefono> telefonosUsuario(String id);

    public int codigoTelefono();

}
