/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package max.gmail.notify.options;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JTextField;
import max.gmail.notify.Notifier;
import max.gmail.notify.settings.Settings;

final class GmailOptionsPanel extends javax.swing.JPanel {

    private final GmailOptionsPanelController controller;

    GmailOptionsPanel(GmailOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        initGui();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLocationByPlatform(true);
        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new GmailOptionsPanel(null));
        f.setVisible(true);
    }

    private void initGui() {
        jTextField2.setEditable(false);
        jTextField2.getCaret().setVisible(false);
        jTextField2.setBackground(jTextField1.getBackground());

        jTextField2.addKeyListener(new NumberFormatter(jTextField2, NumberFormat.getInstance()));
        jTextField2.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                jTextField2.getCaret().setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                jTextField2.getCaret().setVisible(false);
            }
        });
        FocusListener focus = new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                JTextField f = (JTextField) e.getSource();
                f.setSelectionStart(0);
                f.setSelectionEnd(f.getText().length());
            }
        };
        jTextField1.addFocusListener(focus);
        jTextField2.addFocusListener(focus);
        jTextField3.addFocusListener(focus);
        jPasswordField1.addFocusListener(focus);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "Full user name");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "(user@gmail.com)");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, "Password");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, "Update time");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, "(min)");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, "Check folder");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(layout.createSequentialGroup()
                                .add(jLabel4)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel5))
                            .add(jLabel3)
                            .add(jLabel6))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .add(jPasswordField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel2)
                                .addContainerGap(89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(18, 18, 18)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    void load() {

        Settings set = Settings.load();

        if (set != null && set.getUser() != null) {
            jTextField1.setText(set.getUser());
        }
        if (set != null && set.getPass() != null) {
            jPasswordField1.setText(set.getPass());
        }
        if (set != null && set.getFolderName() != null) {
            jTextField3.setText(set.getFolderName());
        } else {
            jTextField3.setText("inbox");
        }
        if (set != null) {
            jTextField2.setText(String.valueOf(set.getDelay() / 1000 / 60));
        } else {
            jTextField2.setText("0");
        }
    }

    void store() {
        Settings set = new Settings();
        set.setUser(jTextField1.getText());
        set.setPass(new String(jPasswordField1.getPassword()));
        set.setFolderName(jTextField3.getText());
        set.setDelay(Integer.valueOf(jTextField2.getText()) * 60 * 1000);

        Settings.save(set);

        Notifier.stop();
        Notifier.start();
    }

    boolean valid() {
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
