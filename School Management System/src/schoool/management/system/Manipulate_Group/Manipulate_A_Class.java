/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoool.management.system.Manipulate_Group;

import java.awt.event.KeyEvent;
import schoool.management.system.Tool_Group.Checking_Input_Data;
import schoool.management.system.Tool_Group.ConnectionClass;
import schoool.management.system.Menu_Group.Welcome_Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Manipulate_A_Class extends javax.swing.JFrame {
    DefaultTableModel model;
    private static boolean showTime = true;
    /**
     * Creates new form Insert_A_Class
     */
    public Manipulate_A_Class() {
        JLabel background = new JLabel(new ImageIcon("src/images/school theme 3.1.jpg"));
        setContentPane(background);
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public ArrayList<Class> classArrayList(){
        ArrayList<Class> classArrayList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionClass.connection();
            String sql = "SELECT * FROM Class";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Class c;
            while (rs.next()) {
                c = new Class(
                        rs.getString("class_ID"),
                        rs.getString("class_section"));
                classArrayList.add(c);
            }
            connection.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return classArrayList;
    }

    public void show_class() {
        ArrayList<Class>  list = classArrayList();
        model = (DefaultTableModel)tableShowClasses.getModel();
        Object[] row = new Object[3];
        for (int i=0; i<list.size();i++){
            row[0] = list.get(i).getClass_ID();
            row[1] = list.get(i).getClass_section();
            model.addRow(row);
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        comboWhatToDo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtClassID = new javax.swing.JTextField();
        txtClassSection = new javax.swing.JTextField();
        btnRun = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnShowClasses = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableShowClasses = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel1.setText("Manipulate a class");

        comboWhatToDo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboWhatToDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add", "Delete", "Update" }));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel2.setText("What to do:");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel3.setText("Class ID:");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jLabel4.setText("Class Section:");

        txtClassID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtClassID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClassIDKeyPressed(evt);
            }
        });

        txtClassSection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtClassSection.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClassSectionKeyPressed(evt);
            }
        });

        btnRun.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        jLabel5.setText("Note:");

        jLabel6.setText("- When add a Class, the Class ID must be unique in the class list.");

        jLabel7.setText("- Click a \"Show Classes\" button to see which IDs have been created.");

        btnShowClasses.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnShowClasses.setText("Show Classes");
        btnShowClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowClassesActionPerformed(evt);
            }
        });

        tableShowClasses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class ID", "Class Section"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableShowClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableShowClassesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableShowClasses);

        jLabel8.setText("- If you want to delete a class, just fill the correct Class ID and Run.");

        btnMenu.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 10)); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnMenu)
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboWhatToDo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtClassID)
                                    .addComponent(txtClassSection, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(btnShowClasses)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRun)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnMenu))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboWhatToDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtClassID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtClassSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRun)
                            .addComponent(btnShowClasses)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowClassesActionPerformed
        // TODO add your handling code here:
        if (showTime) {
            show_class();
            showTime = false;
        } else {
            model.setRowCount(0);
            show_class();
        }
    }//GEN-LAST:event_btnShowClassesActionPerformed

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
        if (comboWhatToDo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "You need to choose an action!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String doing = comboWhatToDo.getSelectedItem().toString();

        if (doing.equals("Add")){
            if (txtClassID.getText().length() == 0 || txtClassSection.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (Checking_Input_Data.Check("class_ID", txtClassID.getText(), "Class", false)){
                        Connection connection = ConnectionClass.connection();
                        String insertQuery = "INSERT INTO Class VALUES (? ,? )";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setString(1, txtClassID.getText());
                        preparedStatement.setString(2, txtClassSection.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_class();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_class();
                        }
                        JOptionPane.showMessageDialog(null, "Insert completed!");
                        connection.close();
                    } else {
                        txtClassID.selectAll();
                        txtClassID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (doing.equals("Update")){
            if (txtClassID.getText().length() == 0 || txtClassSection.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No field can be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (!Checking_Input_Data.Check("class_ID", txtClassID.getText(), "Class", true)){
                        Connection connection = ConnectionClass.connection();
                        String updateQuery =
                                "UPDATE Class SET class_section = ? WHERE class_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setString(1, txtClassSection.getText());
                        preparedStatement.setString(2, txtClassID.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_class();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_class();
                        }
                        JOptionPane.showMessageDialog(null, "Update completed! Tip: ID cannot be changed.");
                        connection.close();
                    } else {
                        txtClassID.selectAll();
                        txtClassID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else if (doing.equals("Delete")){
            if (txtClassID.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "ID cannot be empty!",
                        "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    if (!Checking_Input_Data.Check("class_ID", txtClassID.getText(), "Class", true)){
                        Connection connection = ConnectionClass.connection();
                        String updateQuery =
                                "DELETE FROM Class WHERE class_ID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setString(1, txtClassID.getText());
                        preparedStatement.executeUpdate();
                        if (showTime) {
                            show_class();
                            showTime = false;
                        } else {
                            model.setRowCount(0);
                            show_class();
                        }
                        JOptionPane.showMessageDialog(null, "Delete completed!");
                        connection.close();
                    } else {
                        txtClassID.selectAll();
                        txtClassID.replaceSelection("");
                    }
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        showTime = true;
        dispose();
        Welcome_Admin.main(new String[]{});
    }//GEN-LAST:event_btnMenuActionPerformed

    private void tableShowClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShowClassesMouseClicked
        // TODO add your handling code here:
        int i = tableShowClasses.getSelectedRow();
        TableModel model = tableShowClasses.getModel();
        txtClassID.setText(model.getValueAt(i, 0).toString());
        txtClassSection.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_tableShowClassesMouseClicked

    private void txtClassSectionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassSectionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnRun.doClick();
        }
    }//GEN-LAST:event_txtClassSectionKeyPressed

    private void txtClassIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassIDKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnRun.doClick();
        }
    }//GEN-LAST:event_txtClassIDKeyPressed

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
            java.util.logging.Logger.getLogger(Manipulate_A_Class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manipulate_A_Class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manipulate_A_Class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manipulate_A_Class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manipulate_A_Class().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnShowClasses;
    private javax.swing.JComboBox<String> comboWhatToDo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableShowClasses;
    private javax.swing.JTextField txtClassID;
    private javax.swing.JTextField txtClassSection;
    // End of variables declaration//GEN-END:variables
}