/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ProgramCoordinatorRole;

import Business.College.Program;
import Business.Organization.CollegeOrganization;
import Business.Organization.Organization;
import Business.Role.StudentRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author krunal
 */
public class EnrollStudents extends javax.swing.JPanel {

    /**
     * Creates new form EnrollStudents
     */
    JPanel userProcessContainer;
    CollegeOrganization organization;
    UserAccount userAccount;
    Program program;

    public EnrollStudents(JPanel userProcessContainer, Organization organization, Program program, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = (CollegeOrganization)organization;
        this.program = program;
        this.userAccount = userAccount;

        populateTable();
        populateEnroll();
        
        tblStudents.getTableHeader().setFont(new Font("Tahoma",Font.CENTER_BASELINE,18));
        
        tblEnrolled.getTableHeader().setFont(new Font("Tahoma",Font.CENTER_BASELINE,18));


    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0);

        Object[] row = new Object[2];
        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getRole() instanceof StudentRole) {
                if (program.checkStudent(ua)) {
                    continue;
                }

                row[0] = ua;
                row[1] = ua.getEmployee().getName();

                model.addRow(row);
            }
        }

    }

    public void populateEnroll() {
        DefaultTableModel model = (DefaultTableModel) tblEnrolled.getModel();
        model.setRowCount(0);

        Object[] row = new Object[3];
        for (UserAccount ua : program.getStudents()) {
            if (ua.getRole() instanceof StudentRole) {
                row[0] = ua;
                row[1] = ua.getEmployee().getName();
                row[2] = program;
                model.addRow(row);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        btnEnroll = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnrolled = new javax.swing.JTable();
        backbtn = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enroll Students");

        tblStudents.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Username"
            }
        ));
        tblStudents.setRowHeight(20);
        jScrollPane1.setViewportView(tblStudents);

        btnEnroll.setBackground(new java.awt.Color(51, 153, 255));
        btnEnroll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEnroll.setForeground(new java.awt.Color(255, 255, 255));
        btnEnroll.setText("Enroll");
        btnEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrollActionPerformed(evt);
            }
        });

        tblEnrolled.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblEnrolled.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Program"
            }
        ));
        tblEnrolled.setRowHeight(20);
        jScrollPane2.setViewportView(tblEnrolled);

        backbtn.setBackground(new java.awt.Color(51, 153, 255));
        backbtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("<<Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(51, 153, 255));
        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnroll, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnroll)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollActionPerformed
        // TODO add your handling code here:
        int selected = tblStudents.getSelectedRow();
        if (selected >= 0) {
            UserAccount ua = (UserAccount) tblStudents.getValueAt(selected, 0);

            Boolean flag = program.subscribeProgram(ua);
            if (flag) {
                populateEnroll();
                populateTable();
                ua.createFeeds("Congratulations !! You are now enrolled to this Program " + program.getName());

            } else {
                JOptionPane.showMessageDialog(null, "Already Enrolled");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Please select a row");
        }

    }//GEN-LAST:event_btnEnrollActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        
        
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ProgramCoordWorkAreaJPanel panel = (ProgramCoordWorkAreaJPanel) component;
        panel.populateTable(); 
        
    
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
       
    }//GEN-LAST:event_backbtnActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selected = tblEnrolled.getSelectedRow();
        if(selected >=0){
            UserAccount stu = (UserAccount)tblEnrolled.getValueAt(selected, 0);
            program.unsubscribe(stu);
            JOptionPane.showMessageDialog(null, "Student removed");
            stu.createFeeds("You were disenrolled from "+program.getName());
            populateEnroll();
            populateTable();
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton btnEnroll;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEnrolled;
    private javax.swing.JTable tblStudents;
    // End of variables declaration//GEN-END:variables
}