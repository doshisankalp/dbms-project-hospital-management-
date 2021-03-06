/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sankalp
 */
public class p_treatment extends javax.swing.JFrame {
String pname;
    /**
     * Creates new form p_treatment
     */
    public p_treatment() {
        initComponents();
    }

    public p_treatment(String pname1) throws ClassNotFoundException, SQLException {
        initComponents();
        this.pname= pname1;
        String welcome = "Treatment page for "+ pname;
        patientarea.setText(welcome);
        Class.forName("com.mysql.jdbc.Driver");

            Statement mystmt=null;
            ResultSet myrs;
            int count=0;
            Connection myconn=null;
            String dburl="jdbc:mysql://localhost:3306/Hospital";
            String user="sankalp";
            String pass="qwerty";

            myconn=DriverManager.getConnection(dburl,user,pass);

            mystmt=myconn.createStatement();

            myrs=mystmt.executeQuery("select * from treatment;");
            while(myrs.next()){
                String treatment = myrs.getString("T_name");
                treatmentarea.addItem(treatment);
            }
            mystmt.close();
            myconn.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientarea = new javax.swing.JLabel();
        treatmentarea = new javax.swing.JComboBox<>();
        patientarea1 = new javax.swing.JLabel();
        submitbutton = new javax.swing.JButton();
        logoutbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        patientarea1.setText("Select the Treatment:-");

        submitbutton.setText("Submit");
        submitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbuttonActionPerformed(evt);
            }
        });

        logoutbutton.setText("Logout");
        logoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(patientarea, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(patientarea1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(treatmentarea, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutbutton)
                    .addComponent(submitbutton))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(patientarea, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treatmentarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientarea1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(submitbutton)
                .addGap(18, 18, 18)
                .addComponent(logoutbutton)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbuttonActionPerformed
    try {                                             
        try {
            // TODO add your handling code here:
            String treatment1 = (String) treatmentarea.getSelectedItem();
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Statement mystmt=null;
            ResultSet myrs;
            int count=0;
            Connection myconn=null;
            String dburl="jdbc:mysql://localhost:3306/Hospital";
            String user="sankalp";
            String pass="qwerty";
            
            myconn=DriverManager.getConnection(dburl,user,pass);
            
            mystmt=myconn.createStatement();
            
            myrs=mystmt.executeQuery("select * from treatment where T_name='"+treatment1+"';");
            myrs.next();
            int fees1 = myrs.getInt("fees");
            int tid = myrs.getInt("T_id");
            count = mystmt.executeUpdate("update patient set T_id = '"+tid+"' where p_name='"+pname+"';");
            myrs=mystmt.executeQuery("select p_fees from patient where p_name='"+pname+"';");
            myrs.next();
            int org_fees = myrs.getInt("p_fees");
            org_fees = org_fees + fees1;
            count = mystmt.executeUpdate("update patient set p_fees = '"+org_fees+"' where p_name='"+pname+"';");
            JOptionPane.showMessageDialog(null,"Successfully added Treatment!!");
            mystmt.close();
            myconn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(p_treatment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        close();
        p_treatment P = new p_treatment(pname);
        P.setVisible(true);
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(p_treatment.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_submitbuttonActionPerformed

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed
        // TODO add your handling code here:
        close();
        login L = new login();
        L.setVisible(true);
    }//GEN-LAST:event_logoutbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(p_treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(p_treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(p_treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(p_treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new p_treatment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logoutbutton;
    private javax.swing.JLabel patientarea;
    private javax.swing.JLabel patientarea1;
    private javax.swing.JButton submitbutton;
    private javax.swing.JComboBox<String> treatmentarea;
    // End of variables declaration//GEN-END:variables

private void close(){
    WindowEvent winClosing=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
}

}
