import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends javax.swing.JFrame {

   
    public Login() {
        
        setTitle("Login Interface");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hidepass = new javax.swing.JLabel();
        showpass = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnRegistered = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Elephant", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setText("R E S T O R A");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 290, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hi There!! Login");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 220, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 157, 90, 37));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 206, 90, 37));

        hidepass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide.png"))); // NOI18N
        hidepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidepassMouseClicked(evt);
            }
        });
        jPanel2.add(hidepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, 30));

        showpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/show.png"))); // NOI18N
        showpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showpassMouseClicked(evt);
            }
        });
        jPanel2.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, 30));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 157, 180, 37));

        btnLogin.setBackground(new java.awt.Color(0, 255, 255));
        btnLogin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 150, 36));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 206, 180, 37));

        btnRegistered.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRegistered.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistered.setText("Sign Up");
        btnRegistered.setBorder(null);
        btnRegistered.setContentAreaFilled(false);
        btnRegistered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisteredActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistered, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 130, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Don't have an account?");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 180, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/house.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.jpg"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username,password, query, passDB = null;
        String Surl, SUser, SPass;
        Surl = "jdbc:MySQL://localhost:3306/restora";
        SUser = "root";
        SPass = "";
        int notFound = 0;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(Surl, SUser, SPass);
                Statement st = con.createStatement();
                if("".equals(txtUsername.getText())){
                    JOptionPane.showMessageDialog(new JFrame(), "Username is Require", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if("".equals(txtPassword.getText())){
                    JOptionPane.showMessageDialog(new JFrame(), "Password is Require", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else{
                    username = txtUsername.getText();
                    password = txtPassword.getText();
                    
                    
                    query = "SELECT * FROM customer WHERE username = '"+username+"'";
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        passDB = rs.getString("Password");
                        notFound = 1;
                    }
                    if(notFound == 1 && password.equals(passDB)){
                        new UserDashboard().setVisible(true);
                        
                    }else if(username.equals("admin") && password.equals("123")){
                        new AdminDashboard().setVisible(true);
                    }
                    
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Incorrect Email or Password", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                    txtPassword.setText("");
                    txtUsername.setText(null);
                }
            }catch(Exception e){
                System.out.println("Error!"+ e.getMessage());
            }
            
    }//GEN-LAST:event_btnLoginActionPerformed

    
    
    
    private void btnRegisteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisteredActionPerformed
        new Registration().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegisteredActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        new HomePage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void hidepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidepassMouseClicked
        // TODO add your handling code here:
        
        txtPassword.setEchoChar((char) 0);
        hidepass.setVisible(false);
        showpass.setVisible(true);
    }//GEN-LAST:event_hidepassMouseClicked

    private void showpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showpassMouseClicked
        // TODO add your handling code here:
        txtPassword.setEchoChar('*');
        hidepass.setVisible(true);
        showpass.setVisible(false);
    }//GEN-LAST:event_showpassMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistered;
    private javax.swing.JLabel hidepass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel showpass;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
