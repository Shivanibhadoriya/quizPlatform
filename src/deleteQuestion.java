import java.sql.*;
import Project.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author bhadoriya
 */
public class deleteQuestion extends javax.swing.JFrame {

    /**
     * Creates new form deleteQuestion
     */
    public deleteQuestion() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Option1 = new javax.swing.JTextField();
        Option2 = new javax.swing.JTextField();
        Option3 = new javax.swing.JTextField();
        Option4 = new javax.swing.JTextField();
        Answer = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Change = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(150, 183));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete Question.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 27, -1, 68));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel2.setText("Delete Question");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 344, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 116, 1207, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Question ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 135, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Question :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 182, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setText("Option 1:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 234, 102, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 6, 37, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setText("Option 2:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 283, 102, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setText("Option 3:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 332, 102, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setText("Option 4:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 381, 102, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setText("Answer");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 430, 102, -1));

        Id.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 132, 212, -1));

        Name.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 180, 670, -1));

        Option1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option1ActionPerformed(evt);
            }
        });
        getContentPane().add(Option1, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 231, 670, -1));

        Option2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Option2, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 280, 670, -1));

        Option3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Option3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 670, -1));

        Option4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Option4, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 378, 670, -1));

        Answer.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        getContentPane().add(Answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 427, 670, -1));

        Search.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 132, -1, -1));

        Delete.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 476, -1, -1));

        Change.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear.png"))); // NOI18N
        Change.setText("Clear");
        Change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeActionPerformed(evt);
            }
        });
        getContentPane().add(Change, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 476, -1, -1));

        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close.png"))); // NOI18N
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pages background admin.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
       adminHome.open=0;
       setVisible(false);
    }//GEN-LAST:event_CloseActionPerformed

    private void Option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Option1ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        String id = Id.getText();
         try{
             Connection con=ConnectionProvider.getCon();
             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet  rs = st.executeQuery("Select *from Question where id ='" + id + "'");
            if(rs.first()){
                Name.setText(rs.getString(2));
                Option1.setText(rs.getString(3));
                Option2.setText(rs.getString(4));
                Option3.setText(rs.getString(5));
                Option4.setText(rs.getString(6));
                Answer.setText(rs.getString(7));
                Id.setEditable(false);
            }
            else{
                JFrame jf= new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,"Question Id does not Exist");
            }
        }
        catch(Exception e){
            JFrame jf= new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,e);
           
        }
    }                                      
    // TODO add your handling code here:


    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                     
            
    }//GEN-LAST:event_SearchActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        String id = Id.getText();
           try{
              Connection con= ConnectionProvider.getCon();
               PreparedStatement PS = con.prepareStatement("Delete From Question Where id=?");
               PS.setString(1,id);
               PS.executeUpdate();
               JFrame jf= new JFrame();
               jf.setAlwaysOnTop(true);
               JOptionPane.showMessageDialog(jf,"Successfully deleted");
               setVisible(false);
               new deleteQuestion().setVisible(true); 
           }
           catch(Exception e){
                JFrame jf= new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,e);
           
           }
    }//GEN-LAST:event_DeleteActionPerformed

    private void ChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeActionPerformed
        Id.setText("");
        Name.setText("");
        Option1.setText("");
        Option2.setText("");
        Option3.setText("");
        Option4.setText("");
        Answer.setText("");
        Id.setEditable(true);
    }//GEN-LAST:event_ChangeActionPerformed

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
            java.util.logging.Logger.getLogger(deleteQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deleteQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Answer;
    private javax.swing.JButton Change;
    private javax.swing.JButton Close;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Option1;
    private javax.swing.JTextField Option2;
    private javax.swing.JTextField Option3;
    private javax.swing.JTextField Option4;
    private javax.swing.JButton Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
