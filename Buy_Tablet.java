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
public class Buy_Tablet extends javax.swing.JFrame {

    /**
     * Creates new form Buy_Tablet
     */
    public Buy_Tablet() {
        initComponents();
    }
String pname1;
    public Buy_Tablet(String pname) {
        initComponents();
        this.pname1 = pname;
    medicinearea.setText( "Welcome " + pname1);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medicinearea = new javax.swing.JLabel();
        returnbutton = new javax.swing.JButton();
        quantityarea = new javax.swing.JTextField();
        tabletarea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buybutton = new javax.swing.JButton();
        limitarea = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        medicinearea.setBackground(new java.awt.Color(200, 118, 35));
        medicinearea.setForeground(new java.awt.Color(9, 12, 232));

        returnbutton.setText("Return to your DashBoard");
        returnbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbuttonActionPerformed(evt);
            }
        });

        tabletarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabletareaActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter tablet You want to Buy:-");

        jLabel2.setText("Enter the quantity:-");

        buybutton.setText("Buy them!");
        buybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buybuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(returnbutton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(buybutton))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(87, 87, 87)
                                    .addComponent(medicinearea, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tabletarea, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(quantityarea, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(limitarea, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(medicinearea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabletarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limitarea, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(buybutton)
                .addGap(18, 18, 18)
                .addComponent(returnbutton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbuttonActionPerformed
        // TODO add your handling code here:
        close();
        p_dashboard P = new p_dashboard(pname1);
        P.setVisible(true);
    }//GEN-LAST:event_returnbuttonActionPerformed

    private void buybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buybuttonActionPerformed
        try {
            // TODO add your handling code here:
            String tablet = tabletarea.getText();
            String qty = quantityarea.getText();
            int qty1=Integer.parseInt(qty);
            Connection myconn=null;
            Statement mystmt=null;
            int count=0;
            ResultSet myrs;
                        
            String dburl="jdbc:mysql://localhost:3306/Hospital";
            String user="sankalp";
            String pass="qwerty";
            
            myconn=DriverManager.getConnection(dburl,user,pass);
            
            mystmt=myconn.createStatement();
            
            count=mystmt.executeUpdate("update medicine set stock = stock - '"+qty1+"' where m_name  = '"+tablet+"';");
            myrs=mystmt.executeQuery("select m_id,price from medicine where m_name = '"+tablet+"';");
            myrs.next();
            float price = myrs.getFloat("price");
            price = price * qty1;
            int m_id1 = myrs.getInt("m_id");
            count=mystmt.executeUpdate("update patient set m_id = '"+m_id1+"' where p_name='"+pname1+"';");
            myrs=mystmt.executeQuery("select * from patient where p_name = '"+pname1+"';");
            myrs.next();
            float fees = myrs.getFloat("p_fees");
            fees = fees + price;
            count=mystmt.executeUpdate("update patient set p_fees = '"+fees+"' where p_name='"+pname1+"';");
            JOptionPane.showMessageDialog(null,"you have successfully buyed tablets");
        } catch (SQLException ex) {
            Logger.getLogger(Buy_Tablet.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_buybuttonActionPerformed

    private void tabletareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabletareaActionPerformed
        try {
            // TODO add your handling code here:
            String tablet = tabletarea.getText();
            Connection myconn=null;
            Statement mystmt=null;
            int count=0;
            ResultSet myrs;
                        
            String dburl="jdbc:mysql://localhost:3306/Hospital";
            String user="sankalp";
            String pass="qwerty";
            
            myconn=DriverManager.getConnection(dburl,user,pass);
            mystmt=myconn.createStatement();
            
            myrs=mystmt.executeQuery("select * from medicine where m_name = '"+tablet+"';");
            myrs.next();
            int stock1 = myrs.getInt("stock");
            limitarea.setText("Enter less than "+ stock1);
            quantityarea.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(Buy_Tablet.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_tabletareaActionPerformed

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
            java.util.logging.Logger.getLogger(Buy_Tablet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buy_Tablet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buy_Tablet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buy_Tablet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buy_Tablet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buybutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel limitarea;
    private javax.swing.JLabel medicinearea;
    private javax.swing.JTextField quantityarea;
    private javax.swing.JButton returnbutton;
    private javax.swing.JTextField tabletarea;
    // End of variables declaration//GEN-END:variables

private void close(){
    WindowEvent winClosing=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
}
}
