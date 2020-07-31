/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import ups.edu.ec.controlador.ControladorTelefono;
import ups.edu.ec.controlador.ControladorUsuario;
import ups.edu.ec.dao.TelefonoDAO;
import ups.edu.ec.dao.UsuarioDAO;

/**
 *
 * @author user
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private VentanaIniciarSesion ventanaIniciarSesion;
    private VentanaRegistrarUsuario ventanaRegistrarUsuario;
    private VentanaGestionTelefono ventanaGestionTelefono;
    private VentanaGestionUsuario ventanaGestionUsuario;
     private VentanaBuscarUsuarios ventanaListar;
    private TelefonoDAO telefonoDAO;
    private UsuarioDAO usuarioDAO;    
    private ControladorTelefono controladorTelefono;
    private ControladorUsuario controladorUsuario;

    /**
     * Creates new form NewMDIApplication
     */
    public VentanaPrincipal() {
        initComponents();
        menuTelefono.setVisible(false);
        menuItemCerrarSesion.setVisible(false);
        
        usuarioDAO = new UsuarioDAO();
        telefonoDAO = new TelefonoDAO();
        controladorUsuario = new ControladorUsuario(usuarioDAO, telefonoDAO);
        controladorTelefono = new ControladorTelefono(telefonoDAO);        
        ventanaIniciarSesion = new VentanaIniciarSesion(controladorUsuario, this);
        ventanaRegistrarUsuario = new VentanaRegistrarUsuario(controladorUsuario);
        ventanaGestionTelefono = new VentanaGestionTelefono(controladorUsuario, controladorTelefono);
        ventanaGestionUsuario = new VentanaGestionUsuario(controladorUsuario);
       ventanaListar = new VentanaBuscarUsuarios(controladorUsuario);
        desktopPane.add(ventanaRegistrarUsuario);
         desktopPane.add(ventanaListar);
    }
    
    public JMenuItem getInicarMenuItem() {
        return InicarMenuItem;
    }
    
    public JMenuItem getRegistarMenuItem() {
        return menuRegistar;
    }
    
    public JMenuItem getMenuItemCerrarSesion() {
        return menuItemCerrarSesion;
    }
    
    public JMenu getMenuTelefono() {
        return menuTelefono;
    }
    
    public JMenu getMenuIniciarS() {
        return menuIniciarS;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuIniciarS = new javax.swing.JMenu();
        InicarMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuRegistar = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        menuItemCerrarSesion = new javax.swing.JMenuItem();
        menuTelefono = new javax.swing.JMenu();
        menuItemGestionTelefono = new javax.swing.JMenuItem();
        menuItemGestionUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        desktopPane.setBackground(new java.awt.Color(0, 255, 255));
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        menuIniciarS.setMnemonic('f');
        menuIniciarS.setText("Inicio");

        InicarMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        InicarMenuItem.setMnemonic('o');
        InicarMenuItem.setText("Iniciar Sesion");
        InicarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicarMenuItemActionPerformed(evt);
            }
        });
        menuIniciarS.add(InicarMenuItem);

        jMenuItem1.setText("Buscar Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuIniciarS.add(jMenuItem1);

        menuRegistar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuRegistar.setMnemonic('s');
        menuRegistar.setText("Registar");
        menuRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistarActionPerformed(evt);
            }
        });
        menuIniciarS.add(menuRegistar);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        menuIniciarS.add(exitMenuItem);

        menuItemCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuItemCerrarSesion.setText("Cerra Sesion");
        menuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarSesionActionPerformed(evt);
            }
        });
        menuIniciarS.add(menuItemCerrarSesion);

        menuBar.add(menuIniciarS);

        menuTelefono.setMnemonic('e');
        menuTelefono.setText("Gestinar");

        menuItemGestionTelefono.setMnemonic('t');
        menuItemGestionTelefono.setText("Telefono");
        menuItemGestionTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionTelefonoActionPerformed(evt);
            }
        });
        menuTelefono.add(menuItemGestionTelefono);

        menuItemGestionUsuario.setMnemonic('y');
        menuItemGestionUsuario.setText("Usuario");
        menuItemGestionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionUsuarioActionPerformed(evt);
            }
        });
        menuTelefono.add(menuItemGestionUsuario);

        menuBar.add(menuTelefono);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void InicarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicarMenuItemActionPerformed
        desktopPane.add(ventanaIniciarSesion);
        cerrarVentanas();
        ventanaIniciarSesion.setVisible(true);
        menuRegistar.setVisible(false);
        
    }//GEN-LAST:event_InicarMenuItemActionPerformed

    private void menuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarSesionActionPerformed
        
        menuTelefono.setVisible(false);
        menuItemCerrarSesion.setVisible(false);
        menuIniciarS.setVisible(true);
        menuRegistar.setVisible(true);
        
    }//GEN-LAST:event_menuItemCerrarSesionActionPerformed

    private void menuRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistarActionPerformed
        
        cerrarVentanas();
        
        ventanaRegistrarUsuario.setVisible(true);
        

    }//GEN-LAST:event_menuRegistarActionPerformed

    private void menuItemGestionTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestionTelefonoActionPerformed
        
        desktopPane.add(ventanaGestionTelefono);
        cerrarVentanas();
        ventanaGestionTelefono.setVisible(true);
        

    }//GEN-LAST:event_menuItemGestionTelefonoActionPerformed

    private void menuItemGestionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestionUsuarioActionPerformed
        cerrarVentanas();
        desktopPane.add(ventanaGestionUsuario);
        ventanaGestionUsuario.setVisible(true);
    }//GEN-LAST:event_menuItemGestionUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ventanaListar.setVisible(true);       
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public void cerrarVentanas() {
        ventanaGestionTelefono.setVisible(false);
        ventanaIniciarSesion.setVisible(false);
//        ventanaListar.setVisible(false);
        ventanaRegistrarUsuario.setVisible(true);
//        ventanaGestionUsuario.setVisible(false);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem InicarMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuIniciarS;
    private javax.swing.JMenuItem menuItemCerrarSesion;
    private javax.swing.JMenuItem menuItemGestionTelefono;
    private javax.swing.JMenuItem menuItemGestionUsuario;
    private javax.swing.JMenuItem menuRegistar;
    private javax.swing.JMenu menuTelefono;
    // End of variables declaration//GEN-END:variables

}
