
import Project.ConnectionProvider;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author bhadoriya
 */
public class quizStudent extends javax.swing.JFrame {

    public int totalMarks = 0;
    public int studentId = 0;
    public int totalQuestion=0;
    public String topicName = "";
    public int questionId = 1;
    public String answer = "";
    public int min = 10;
    public int sec = 0;
    public int marks = 0;
    Timer time;
    ResultSet rsOfQuestion;

    public quizStudent() {
        initComponents();
    }

    public quizStudent(String topic, int sId) {
        initComponents();
        topicName = topic;
        studentId = sId;
        
        //date format
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        quizDate.setText(dFormat.format(date));

        //first question and student Details
        TopicName.setText(topic);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            
            // updating student profile on page
            StudentId.setText(sId + "");
            ResultSet rs1 = st.executeQuery("Select name from Student where sId = '" + sId + "'");
            if (rs1.next()) {
                StudentName.setText(rs1.getString(1));
            }
            
            // updating information of topic and totalquestion on page
            ResultSet rs2 = st.executeQuery("Select count(*) from question where topicId = (select topicId from quiztopic where topicName ='" + topic + "')");
            if (rs2.next()) {
               totalMarks =  totalQuestion = rs2.getInt(1);
            }
             TotalQuestion.setText(totalQuestion+"");
            
            
             // updating question name and options 
            rsOfQuestion = st.executeQuery("Select rownum as num,name,op1,op2,op3,op4,answer from question where topicid = (select topicId from quiztopic where topicName='" + topic + "')");
            if (rsOfQuestion.next()) {
                questionId = rsOfQuestion.getInt(1);
                QuestionNum.setText(questionId + "");
                QuestonName.setText(rsOfQuestion.getString(2));
                radiobtn1.setText(rsOfQuestion.getString(3));
                radiobtn2.setText(rsOfQuestion.getString(4));
                radiobtn3.setText(rsOfQuestion.getString(5));
                radiobtn4.setText(rsOfQuestion.getString(6));
                answer = rsOfQuestion.getString(7);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
        
        //time program
        setLocationRelativeTo(this);
        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sec.setText(String.valueOf(sec));
                Min.setText(String.valueOf(min));
                if (sec == 0) {
                    sec = 60;
                    min--;
                    if (min == 0) {
                        time.stop();
                        answerCheck();
                        submit();
                    }
                }
                sec--;
            }
        });
        time.start();
    }
    
    // checking answer of user ,return on the basis of option select or not 
    public boolean answerCheck() {
        String studentAnswer = "";
        if (radiobtn1.isSelected()) {
            studentAnswer = radiobtn1.getText();
        } else if (radiobtn2.isSelected()) {
            studentAnswer = radiobtn2.getText();
        } else if (radiobtn3.isSelected()) {
            studentAnswer = radiobtn3.getText();
        } else if (radiobtn4.isSelected()) {
            studentAnswer = radiobtn4.getText();
        } else {
            return false;
        }

        // checking choosing answer correct or not
        if (studentAnswer.equals(answer)) {
            marks = marks + 1;
            Marks.setText(marks + "");
            JOptionPane.showMessageDialog(this, "Correct Answer");
        } else {
            JOptionPane.showMessageDialog(this, "InCorrect Answer");
        }

        // clear radioButton
        radiobtn1.setSelected(false);
        radiobtn2.setSelected(false);
        radiobtn3.setSelected(false);
        radiobtn4.setSelected(false);

        //question number change
        questionId++;
        
        //last question hide next button
        if (questionId > totalQuestion) {
             next.setVisible(false);
        }
        return true;
    }

    public void question() {
        try {
            // this will add new question on screen
            if (rsOfQuestion.next()) {
                QuestionNum.setText(rsOfQuestion.getInt(1) + "");
                QuestonName.setText(rsOfQuestion.getString(2));
                radiobtn1.setText(rsOfQuestion.getString(3));
                radiobtn2.setText(rsOfQuestion.getString(4));
                radiobtn3.setText(rsOfQuestion.getString(5));
                radiobtn4.setText(rsOfQuestion.getString(6));
                answer = rsOfQuestion.getString(7);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void submit() {
        answerCheck();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pS = con.prepareStatement("INSERT INTO Marks VALUES(?,?,?,?,sysdate)");
            pS.setString(1, topicName);
            pS.setInt(2, studentId);
            pS.setInt(3, marks);
            pS.setInt(4, totalMarks);
            pS.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
    }

    /**
     * Creates new form quizStudent
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        quizDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Min = new javax.swing.JLabel();
        Sec = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        StudentName = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        TopicName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TotalQuestion = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Marks = new javax.swing.JLabel();
        StudentId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        QuestonName = new javax.swing.JLabel();
        radiobtn1 = new javax.swing.JRadioButton();
        radiobtn2 = new javax.swing.JRadioButton();
        radiobtn3 = new javax.swing.JRadioButton();
        radiobtn4 = new javax.swing.JRadioButton();
        next = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        QuestionNum = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1371, 60, 37, -1));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(102, 255, 51));
        jLabel2.setFont(new java.awt.Font("Algerian", 1, 30)); // NOI18N
        jLabel2.setText("YOUr Quiz Started");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 153), new java.awt.Color(255, 0, 51), java.awt.Color.lightGray, new java.awt.Color(51, 153, 0)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 60));

        quizDate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        quizDate.setText("dd-mm-yyyy");
        jPanel1.add(quizDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 140, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("Time Left:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 70, -1, -1));

        Min.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Min.setForeground(new java.awt.Color(255, 0, 0));
        Min.setText("10");
        jPanel1.add(Min, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 70, -1, 30));

        Sec.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Sec.setForeground(new java.awt.Color(255, 0, 0));
        Sec.setText("00");
        jPanel1.add(Sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 70, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText(":");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 70, 10, 30));

        StudentName.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        StudentName.setText("Name");
        StudentName.setContentAreaFilled(false);
        jPanel1.add(StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 370, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 61, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 100));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setText("Student Id:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 184, -1));

        Topic.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Topic.setText("Topic ");
        jPanel2.add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 184, -1));

        TopicName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TopicName.setText("name");
        jPanel2.add(TopicName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel15.setText("Total Question:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 184, -1));

        TotalQuestion.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TotalQuestion.setText("00");
        jPanel2.add(TotalQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 43, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel19.setText("Your Marks:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 184, -1));

        Marks.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Marks.setText("00");
        jPanel2.add(Marks, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 43, -1));

        StudentId.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        StudentId.setText("00");
        jPanel2.add(StudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 110, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("Student Details");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 190, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 320, 660));

        QuestonName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        QuestonName.setText("Question ");
        getContentPane().add(QuestonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 620, -1));

        radiobtn1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        radiobtn1.setText("Option1");
        radiobtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(radiobtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 680, -1));

        radiobtn2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        radiobtn2.setText("Option2");
        radiobtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(radiobtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 680, -1));

        radiobtn3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        radiobtn3.setText("Option3");
        radiobtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn3ActionPerformed(evt);
            }
        });
        getContentPane().add(radiobtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 680, -1));

        radiobtn4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        radiobtn4.setText("Option4");
        radiobtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtn4ActionPerformed(evt);
            }
        });
        getContentPane().add(radiobtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 680, -1));

        next.setBackground(new java.awt.Color(51, 51, 255));
        next.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 524, 280, -1));

        submit.setBackground(new java.awt.Color(0, 153, 0));
        submit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, 310, -1));

        QuestionNum.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        QuestionNum.setText("00");
        getContentPane().add(QuestionNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 43, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pages background student.jpg"))); // NOI18N
        jLabel22.setText("jLabel22");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 100, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        boolean check = answerCheck(); // check is used for checking user select any Option or not
        if(check)
             question();
        else
            JOptionPane.showMessageDialog(this,"please choose the option ");
    }//GEN-LAST:event_nextActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        int a=0;
        if(questionId <= totalQuestion){
             a = JOptionPane.showConfirmDialog(this, "Do You really want to Submit", "Select", JOptionPane.YES_NO_OPTION);
             if (a == 0) {
               answerCheck();
              }
        }
        if(a == 0){
             submit();
            new successfullySubmitted(marks,studentId).setVisible(true);
        }
        
         
        
        
        
        
    }//GEN-LAST:event_submitActionPerformed

    private void radiobtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn1ActionPerformed
        if (radiobtn1.isSelected()) {
            radiobtn2.setSelected(false);
            radiobtn3.setSelected(false);
            radiobtn4.setSelected(false);
        }

    }//GEN-LAST:event_radiobtn1ActionPerformed

    private void radiobtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn2ActionPerformed
        if (radiobtn2.isSelected()) {
            radiobtn1.setSelected(false);
            radiobtn3.setSelected(false);
            radiobtn4.setSelected(false);
        }

    }//GEN-LAST:event_radiobtn2ActionPerformed

    private void radiobtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn3ActionPerformed
        if (radiobtn3.isSelected()) {
            radiobtn1.setSelected(false);
            radiobtn2.setSelected(false);
            radiobtn4.setSelected(false);
        }

    }//GEN-LAST:event_radiobtn3ActionPerformed

    private void radiobtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtn4ActionPerformed
        if (radiobtn4.isSelected()) {
            radiobtn2.setSelected(false);
            radiobtn3.setSelected(false);
            radiobtn1.setSelected(false);
        }

    }//GEN-LAST:event_radiobtn4ActionPerformed

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
            java.util.logging.Logger.getLogger(quizStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>+

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quizStudent("", 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Marks;
    private javax.swing.JLabel Min;
    private javax.swing.JLabel QuestionNum;
    private javax.swing.JLabel QuestonName;
    private javax.swing.JLabel Sec;
    private javax.swing.JLabel StudentId;
    private javax.swing.JButton StudentName;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel TopicName;
    private javax.swing.JLabel TotalQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton next;
    private javax.swing.JLabel quizDate;
    private javax.swing.JRadioButton radiobtn1;
    private javax.swing.JRadioButton radiobtn2;
    private javax.swing.JRadioButton radiobtn3;
    private javax.swing.JRadioButton radiobtn4;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
