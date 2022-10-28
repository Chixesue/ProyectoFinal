package Vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo # 1
 */
public class VistaMenu extends javax.swing.JFrame {

    /**
     * Creates new form VistaMenu
     */
    public VistaMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        lblUsuarioM = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        IngUsuarios = new javax.swing.JMenu();
        JmIngresoUsuarios = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JmIngresoInventario = new javax.swing.JMenuItem();
        JmIngresoCllientes = new javax.swing.JMenuItem();
        JmIngresoProveedores = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        JmIngresoCompras = new javax.swing.JMenuItem();
        JmIngresoVentas = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenuItem5.setText("jMenuItem5");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu7.setText("File");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar2.add(jMenu8);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUsuarioM.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuarioM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioM.setText("Usuario:");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logotipo1.0.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(152, 152, 152))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        IngUsuarios.setText("Creacion de Usuario");

        JmIngresoUsuarios.setText("Usuario");
        JmIngresoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIngresoUsuariosActionPerformed(evt);
            }
        });
        IngUsuarios.add(JmIngresoUsuarios);

        jMenuItem2.setText("Rol");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        IngUsuarios.add(jMenuItem2);

        jMenuItem3.setText("Telefono");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        IngUsuarios.add(jMenuItem3);

        jMenuBar1.add(IngUsuarios);

        jMenu3.setText("Ingresos");

        JmIngresoInventario.setText("Inventario");
        JmIngresoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIngresoInventarioActionPerformed(evt);
            }
        });
        jMenu3.add(JmIngresoInventario);

        JmIngresoCllientes.setText("Clientes");
        JmIngresoCllientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIngresoCllientesActionPerformed(evt);
            }
        });
        jMenu3.add(JmIngresoCllientes);

        JmIngresoProveedores.setText("Proveedores");
        JmIngresoProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIngresoProveedoresActionPerformed(evt);
            }
        });
        jMenu3.add(JmIngresoProveedores);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Facturación");

        JmIngresoCompras.setText("Compras");
        JmIngresoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIngresoComprasActionPerformed(evt);
            }
        });
        jMenu4.add(JmIngresoCompras);

        JmIngresoVentas.setText("Ventas");
        JmIngresoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIngresoVentasActionPerformed(evt);
            }
        });
        jMenu4.add(JmIngresoVentas);

        jMenuBar1.add(jMenu4);

        jMenu9.setText("Salida");
        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuarioM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblUsuarioM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JmIngresoProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIngresoProveedoresActionPerformed
   new VistaProveedores().setVisible(true);
    }//GEN-LAST:event_JmIngresoProveedoresActionPerformed

    private void JmIngresoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIngresoUsuariosActionPerformed
    
        new VistaUsuarios().setVisible(true);
    }//GEN-LAST:event_JmIngresoUsuariosActionPerformed

    private void JmIngresoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIngresoInventarioActionPerformed
   new VistaIngresoInventario().setVisible(true);
    }//GEN-LAST:event_JmIngresoInventarioActionPerformed

    private void JmIngresoCllientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIngresoCllientesActionPerformed
  new VistaClientes().setVisible(true);
    }//GEN-LAST:event_JmIngresoCllientesActionPerformed

    private void JmIngresoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIngresoComprasActionPerformed
    new VistaCompras().setVisible(true);
    }//GEN-LAST:event_JmIngresoComprasActionPerformed

    private void JmIngresoVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIngresoVentasActionPerformed
    new VistaVentas().setVisible(true);
    }//GEN-LAST:event_JmIngresoVentasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    new VistaRol().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
   new VistaTelefonos().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu IngUsuarios;
    public javax.swing.JMenuItem JmIngresoCllientes;
    public javax.swing.JMenuItem JmIngresoCompras;
    public javax.swing.JMenuItem JmIngresoInventario;
    public javax.swing.JMenuItem JmIngresoProveedores;
    private javax.swing.JMenuItem JmIngresoUsuarios;
    public javax.swing.JMenuItem JmIngresoVentas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblUsuarioM;
    // End of variables declaration//GEN-END:variables

    private static class JmIngresoUsuarios {

        public JmIngresoUsuarios() {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}