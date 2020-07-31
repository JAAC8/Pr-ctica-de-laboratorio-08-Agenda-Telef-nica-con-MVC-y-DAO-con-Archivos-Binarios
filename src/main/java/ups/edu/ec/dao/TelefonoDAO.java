/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.dao;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ups.edu.ec.controlador.ControladorUsuario;
import ups.edu.ec.idao.ITelefonoDAO;
import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

/**
 * Estructura del archivo telefono.dat
 *
 * private int codigo; (4 bytes) private String numero; (25 bytes) + 2 extras
 * private String tipo; (25 bytes) +2 extras private String operadora; (25 *
 * bytes) + 2 esxtras private Usuario usuario; (cedula ID) -> 10 bytes + 2*
 * extras
 *
 * Total -> 97 bytes por registro
 */
public class TelefonoDAO implements ITelefonoDAO {

    private int codigo;
//    private List<Telefono> listaTelefono;
    private RandomAccessFile archivo;
    private int tamañoRegistro;
    private UsuarioDAO usuarioDAO;
    private ControladorUsuario controladorUsuario;

    public TelefonoDAO() {
        try {
            codigo = 0;
            tamañoRegistro = 97;
            archivo = new RandomAccessFile("datos/telefono.dat", "rw");
            usuarioDAO = new UsuarioDAO();
        } catch (IOException ex) {
            System.out.println("error de lectura y escritura");
            ex.printStackTrace();
        }
    }

//    public List<Telefono> getListaTelefono() {
//        return listaTelefono;
//    }
    @Override
    public void create(Telefono telefono) {
        try {
            codigo++;
            archivo.seek(archivo.length());
            archivo.writeInt(telefono.getCodigo());
            archivo.writeUTF(telefono.getNumero());
            archivo.writeUTF(telefono.getTipo());
            archivo.writeUTF(telefono.getOperadora());
            archivo.writeUTF(telefono.getUsuario().getCedula());
        } catch (IOException ex) {
            System.out.println("Error (create Telefono)");
        }
    }

    @Override
    public Telefono read(int codigo) {
        try {
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (codigoArchivo == codigo) {
                    //retornar telefono
                    Telefono tel = new Telefono(codigo, archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim());
                    Usuario user = controladorUsuario.buscar(archivo.readUTF());
                    tel.setUsuario(user);
                    return tel;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("error en el create TelefonoDAO");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Telefono telefono) {
        int salto = 0;
        int codigo = telefono.getCodigo();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                //revisar
                if (codigo == codigoArchivo) {
                    archivo.writeUTF(telefono.getNumero());
                    archivo.writeUTF(telefono.getOperadora());
                    archivo.writeUTF(telefono.getTipo());
                    break;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(upDate Telefono)");
        }
    }

    @Override
    public void delete(int id) {

        int salto = 0;

        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (id == codigoArchivo) {
                    archivo.seek(salto);
                    archivo.writeInt(0);
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(10));
                    break;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(upDate Telefono)");
        }

    }

    public String llenarEspacios(int espacios) {
        String formato = "";
        return String.format("%-" + espacios + "s", formato);
    }

    @Override
    public List<Telefono> findAll() {
        List<Telefono> listaTelefonos = new ArrayList<>();
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);

                int valor = archivo.readInt();
                if (valor > 0) {
                    Telefono tele = new Telefono(valor, archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim());
                    listaTelefonos.add(tele);
                }

                salto += tamañoRegistro;
            }
            return listaTelefonos;
        } catch (IOException ex) {
            System.out.println("error find all telefono");
        }
        return listaTelefonos;
    }

    @Override
    public int obtenerUltimoCodigo() {
        try {
            if (archivo.length() > tamañoRegistro) {
                archivo.seek(archivo.length() - tamañoRegistro);
//                     System.out.println("si llego aqui");
                codigo = archivo.readInt();
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(obtenerUltimoCodigo:TelefonoDAO)");
            ex.printStackTrace();
        }
        return codigo;
    }

    @Override
    public List<Telefono> telefonosUsuario(String id) {
        List<Telefono> teles = new ArrayList<>();

        try {
            int salto = 85;
            while (salto < archivo.length()) {
                archivo.seek(salto);

                String auxCedula = archivo.readUTF().trim();
//                System.out.println("si llego aqui");
                if (auxCedula.equals(id.trim())) {

                    archivo.seek(salto - 85);
                    int valor = archivo.readInt();
                    if (valor > 0) {
                        Telefono tele = new Telefono(valor, archivo.readUTF().trim(),
                                archivo.readUTF().trim(), archivo.readUTF().trim());
                        teles.add(tele);
                    }

                }
                salto += tamañoRegistro;
            }
            return teles;
        } catch (IOException ex) {
            System.out.println("Error telefonos usuario");
        }

        return teles;
    }

    @Override
    public int codigoTelefono() {

        try {
            if (archivo.length() > 0) {
                int aux = (int) (archivo.length() / tamañoRegistro);
                System.out.println(aux);
                return aux;

            } else {
                return 0;
            }
        } catch (IOException ex) {
            System.out.println("Error codigo(codigoTelefono)");
        }
        return codigo;
    }

}
