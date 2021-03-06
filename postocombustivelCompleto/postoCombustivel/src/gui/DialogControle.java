/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.Controle;
import static model.Controle.resAditivada;
import static model.Controle.resAlcool;
import static model.Controle.resComum;
import static model.Controle.resDiesel;

/**
 *
 * @author Aluno
 */
public class DialogControle extends javax.swing.JDialog {
    
      /**
     * Creates new form DialogControle
     */
    public DialogControle(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         this.tfTotalDiesel.setText(Double.toString(resDiesel.getQtdMaxima()));
         this.tfAtualDiesel.setText(Double.toString(resDiesel.getQtdAtual()));
         this.tfReservaDiesel.setText(Double.toString(resDiesel.getQtdMin()));
         this.tfTotalComum.setText(Double.toString(resComum.getQtdMaxima()));
         this.tfAtualComum.setText(Double.toString(resComum.getQtdAtual()));
         this.tfReservaComum.setText(Double.toString(resComum.getQtdMin()));
         this.tfTotalAditivada.setText(Double.toString(resAditivada.getQtdMaxima()));
         this.tfAtualAditivada.setText(Double.toString(resAditivada.getQtdAtual()));
         this.tfReservaAditivada.setText(Double.toString(resAditivada.getQtdMin()));
         this.tfTotalAlcool.setText(Double.toString(resAlcool.getQtdMaxima()));
         this.tfAtualAlcool.setText(Double.toString(resAlcool.getQtdAtual()));
         this.tfReservaAlcool.setText(Double.toString(resAlcool.getQtdMin()));
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnOleo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTotalDiesel = new javax.swing.JTextField();
        tfAtualDiesel = new javax.swing.JTextField();
        tfReservaDiesel = new javax.swing.JTextField();
        pnComum = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfTotalComum = new javax.swing.JTextField();
        tfAtualComum = new javax.swing.JTextField();
        tfReservaComum = new javax.swing.JTextField();
        pnAlcool = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfTotalAlcool = new javax.swing.JTextField();
        tfAtualAlcool = new javax.swing.JTextField();
        tfReservaAlcool = new javax.swing.JTextField();
        pnAditivada = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfTotalAditivada = new javax.swing.JTextField();
        tfAtualAditivada = new javax.swing.JTextField();
        tfReservaAditivada = new javax.swing.JTextField();
        btOk = new javax.swing.JButton();
        btCompletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnOleo.setBorder(javax.swing.BorderFactory.createTitledBorder("Óleo Diesel"));

        jLabel1.setText("Total:");

        jLabel2.setText("Atual:");

        jLabel3.setText("Reserva:");

        javax.swing.GroupLayout pnOleoLayout = new javax.swing.GroupLayout(pnOleo);
        pnOleo.setLayout(pnOleoLayout);
        pnOleoLayout.setHorizontalGroup(
            pnOleoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOleoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOleoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOleoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTotalDiesel))
                    .addGroup(pnOleoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(tfAtualDiesel))
                    .addGroup(pnOleoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfReservaDiesel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnOleoLayout.setVerticalGroup(
            pnOleoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOleoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnOleoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTotalDiesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnOleoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOleoLayout.createSequentialGroup()
                        .addComponent(tfAtualDiesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnOleoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfReservaDiesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnComum.setBorder(javax.swing.BorderFactory.createTitledBorder("Gasolina Comum"));

        jLabel4.setText("Total:");

        jLabel5.setText("Atual:");

        jLabel6.setText("Reserva:");

        javax.swing.GroupLayout pnComumLayout = new javax.swing.GroupLayout(pnComum);
        pnComum.setLayout(pnComumLayout);
        pnComumLayout.setHorizontalGroup(
            pnComumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnComumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnComumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnComumLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTotalComum))
                    .addGroup(pnComumLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(tfAtualComum))
                    .addGroup(pnComumLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfReservaComum, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnComumLayout.setVerticalGroup(
            pnComumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnComumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnComumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTotalComum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnComumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnComumLayout.createSequentialGroup()
                        .addComponent(tfAtualComum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnComumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfReservaComum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnAlcool.setBorder(javax.swing.BorderFactory.createTitledBorder("Álcool"));

        jLabel7.setText("Total:");

        jLabel8.setText("Atual:");

        jLabel9.setText("Reserva:");

        javax.swing.GroupLayout pnAlcoolLayout = new javax.swing.GroupLayout(pnAlcool);
        pnAlcool.setLayout(pnAlcoolLayout);
        pnAlcoolLayout.setHorizontalGroup(
            pnAlcoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlcoolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAlcoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAlcoolLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTotalAlcool))
                    .addGroup(pnAlcoolLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(tfAtualAlcool))
                    .addGroup(pnAlcoolLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfReservaAlcool, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnAlcoolLayout.setVerticalGroup(
            pnAlcoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAlcoolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAlcoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfTotalAlcool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAlcoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAlcoolLayout.createSequentialGroup()
                        .addComponent(tfAtualAlcool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnAlcoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfReservaAlcool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnAditivada.setBorder(javax.swing.BorderFactory.createTitledBorder("Gasolina Aditivada"));

        jLabel10.setText("Total:");

        jLabel11.setText("Atual:");

        jLabel12.setText("Reserva:");

        javax.swing.GroupLayout pnAditivadaLayout = new javax.swing.GroupLayout(pnAditivada);
        pnAditivada.setLayout(pnAditivadaLayout);
        pnAditivadaLayout.setHorizontalGroup(
            pnAditivadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAditivadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAditivadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAditivadaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTotalAditivada))
                    .addGroup(pnAditivadaLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(tfAtualAditivada))
                    .addGroup(pnAditivadaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfReservaAditivada, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnAditivadaLayout.setVerticalGroup(
            pnAditivadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAditivadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAditivadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfTotalAditivada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAditivadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAditivadaLayout.createSequentialGroup()
                        .addComponent(tfAtualAditivada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnAditivadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfReservaAditivada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        btCompletar.setText("Completar");
        btCompletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnOleo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnAlcool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnComum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnAditivada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btOk)
                        .addGap(18, 18, 18)
                        .addComponent(btCompletar)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnAlcool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnOleo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnComum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnAditivada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOk)
                    .addComponent(btCompletar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btOkActionPerformed

    private void btCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompletarActionPerformed
        // TODO add your handling code here:
        Controle.resDiesel.completar();
        Controle.resAditivada.completar();
        Controle.resComum.completar();
        Controle.resAlcool.completar();
        
         this.tfTotalDiesel.setText(Double.toString(resDiesel.getQtdMaxima()));
         this.tfAtualDiesel.setText(Double.toString(resDiesel.getQtdAtual()));
         this.tfReservaDiesel.setText(Double.toString(resDiesel.getQtdMin()));
         this.tfTotalComum.setText(Double.toString(resComum.getQtdMaxima()));
         this.tfAtualComum.setText(Double.toString(resComum.getQtdAtual()));
         this.tfReservaComum.setText(Double.toString(resComum.getQtdMin()));
         this.tfTotalAditivada.setText(Double.toString(resAditivada.getQtdMaxima()));
         this.tfAtualAditivada.setText(Double.toString(resAditivada.getQtdAtual()));
         this.tfReservaAditivada.setText(Double.toString(resAditivada.getQtdMin()));
         this.tfTotalAlcool.setText(Double.toString(resAlcool.getQtdMaxima()));
         this.tfAtualAlcool.setText(Double.toString(resAlcool.getQtdAtual()));
         this.tfReservaAlcool.setText(Double.toString(resAlcool.getQtdMin()));
        
    }//GEN-LAST:event_btCompletarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogControle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogControle dialog = new DialogControle(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCompletar;
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnAditivada;
    private javax.swing.JPanel pnAlcool;
    private javax.swing.JPanel pnComum;
    private javax.swing.JPanel pnOleo;
    private javax.swing.JTextField tfAtualAditivada;
    private javax.swing.JTextField tfAtualAlcool;
    private javax.swing.JTextField tfAtualComum;
    private javax.swing.JTextField tfAtualDiesel;
    private javax.swing.JTextField tfReservaAditivada;
    private javax.swing.JTextField tfReservaAlcool;
    private javax.swing.JTextField tfReservaComum;
    private javax.swing.JTextField tfReservaDiesel;
    private javax.swing.JTextField tfTotalAditivada;
    private javax.swing.JTextField tfTotalAlcool;
    private javax.swing.JTextField tfTotalComum;
    private javax.swing.JTextField tfTotalDiesel;
    // End of variables declaration//GEN-END:variables
}
