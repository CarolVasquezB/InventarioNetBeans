/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlEmpleado;
import Control.ControlEmpleado_Rol;
import javax.swing.JOptionPane;

/**
 *
 * @author CarolVasquez
 */
public class GUILoginUsuario extends javax.swing.JFrame {
    ControlEmpleado ce = new ControlEmpleado();
    ControlEmpleado_Rol cer = new ControlEmpleado_Rol();
    Object dato[][] = null;
    /**
     * Creates new form GUILoginUsuario
     */
    public GUILoginUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void cosultarRol(int codEmpleado){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtUsuarioLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PswContraseñaLogin = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(570, 350));
        setMinimumSize(new java.awt.Dimension(570, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 360, 10));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));
        getContentPane().add(txtUsuarioLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 120, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Usuario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));
        getContentPane().add(PswContraseñaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 120, -1));

        btnEntrar.setBackground(new java.awt.Color(204, 204, 204));
        btnEntrar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(102, 0, 102));
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/login.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/LogoTirsa.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/FondoLogin.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if(txtUsuarioLogin.getText().length()>0 & PswContraseñaLogin.getText().length()>0){
            GUIPrincipal facturacion = new GUIPrincipal();
            dato = ce.consultarEmpleadoLogin(txtUsuarioLogin.getText());
            if(dato[0][0]==null){
                JOptionPane.showMessageDialog(this, "El usuario no existe");
            }else{
                if(String.valueOf(dato[0][3]).equals("T")){
                    JOptionPane.showMessageDialog(this, "El usuario se encuentra bloqueado, comuníquede con el Administrador"); 
                }else{
                    if(dato[0][2].equals(PswContraseñaLogin.getText())){
                        Object[][] rol = cer.consultarRolEmpleado(Integer.parseInt(String.valueOf(dato[0][0])));
                        facturacion.setVisible(true);
                        facturacion.obtenerEmpleadoyRol(dato[0][0].toString(), rol[0][2].toString());
                        this.setVisible(false);    
                    }else{
                        JOptionPane.showMessageDialog(this, "Contraseña Incorrecta");   
                        ce.insertarAcceso(Integer.parseInt(String.valueOf(dato[0][0])), 1);   
                    }         
                }
            }            
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese Usuario y Contraseña");
        }        
    }//GEN-LAST:event_btnEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(GUILoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILoginUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PswContraseñaLogin;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
