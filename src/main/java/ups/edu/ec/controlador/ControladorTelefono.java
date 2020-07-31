/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.dao.TelefonoDAO;
import ups.edu.ec.modelo.Telefono;

/**
 *
 * @author user
 */
public class ControladorTelefono {
    //Objetos vista

    //Objeto Telefono
    private Telefono telefono;

    //Objetos DAO
    private TelefonoDAO telefonosDAO;

    public ControladorTelefono() {

    }

    //Constructor 
    public ControladorTelefono(TelefonoDAO telefonosDAO) {
        this.telefonosDAO = telefonosDAO;
    }

    public void registrarTelefono(Telefono telefono) {
        telefonosDAO.create(telefono);
    }

    public int obtenerSiguienteCodigo() {
        int codigo = telefonosDAO.obtenerUltimoCodigo();
        return ++codigo;
    }

//    public List<Telefono> verTelefonos() {
//        List<Telefono> telefonos;
//        telefonos = telefonosDAO.findAll();
//        return telefonos;
//
//    }

    public Telefono encontrarTelefono(int codigo) {

        telefono = telefonosDAO.read(codigo);

        return telefono;
    }

}
