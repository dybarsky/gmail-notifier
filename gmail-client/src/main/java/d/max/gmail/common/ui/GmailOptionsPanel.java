/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package d.max.gmail.common.ui;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTextField;

import d.max.gmail.netbeans.Notifier;
import d.max.gmail.netbeans.NumberFormatter;
import max.gmail.notify.settings.Settings;

final class GmailOptionsPanel extends javax.swing.JPanel {
    
    private NumberFormatter format;
    
    GmailOptionsPanel() {
        initComponents();
        format = new NumberFormatter(timeField, NumberFormat.getInstance(Locale.US));
        initGui();
    }
    
    private void initGui() {
        timeField.setEditable(false);
        timeField.setBorder(userNameField.getBorder());
        timeField.getCaret().setVisible(false);
        timeField.setBackground(userNameField.getBackground());
        
        timeField.addKeyListener(format);
        timeField.addFocusListener(new FocusAdapter() {
            
            @Override
            public void focusGained(FocusEvent e) {
                timeField.getCaret().setVisible(true);
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                timeField.getCaret().setVisible(false);
            }
        });
        FocusListener focus = new FocusAdapter() {
            
            @Override
            public void focusGained(FocusEvent e) {
                JTextField f = (JTextField) e.getSource();
                f.setSelectionStart(0);
                f.setSelectionEnd(f.getText().length());
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                JTextField f = (JTextField) e.getSource();
                f.setSelectionStart(0);
                f.setSelectionEnd(0);
            }
        };
        userNameField.addFocusListener(focus);
        timeField.addFocusListener(focus);
        folderField.addFocusListener(focus);
        passwordField.addFocusListener(focus);
        
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        userNameLabel = new javax.swing.JLabel();
        exampleLabel = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        timeLabel = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();
        minutes = new javax.swing.JLabel();
        folderLabel = new javax.swing.JLabel();
        folderField = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();

        org.openide.awt.Mnemonics.setLocalizedText(userNameLabel, "Full user name");

        exampleLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        exampleLabel.setForeground(new java.awt.Color(153, 153, 153));
        org.openide.awt.Mnemonics.setLocalizedText(exampleLabel, "(user@gmail.com)");

        org.openide.awt.Mnemonics.setLocalizedText(passwordLabel, "Password");

        org.openide.awt.Mnemonics.setLocalizedText(timeLabel, "Update time");

        minutes.setFont(new java.awt.Font("Dialog", 0, 12));
        org.openide.awt.Mnemonics.setLocalizedText(minutes, "(min)");

        org.openide.awt.Mnemonics.setLocalizedText(folderLabel, "Check folder");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(separator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
                .add(12, 12, 12)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(userNameLabel)
                    .add(layout.createSequentialGroup()
                        .add(timeLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(minutes))
                    .add(passwordLabel)
                    .add(folderLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(folderField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .add(timeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .add(userNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(exampleLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(userNameLabel)
                    .add(userNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(exampleLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passwordLabel)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(separator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(timeLabel)
                    .add(minutes)
                    .add(timeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(folderField)
                    .add(folderLabel))
                .add(18, 18, 18)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false))
                .add(34, 34, 34))
        );
    }// </editor-fold>                        
    
    void load() {
        Settings set = Settings.load();
        
        if (set != null && set.getUser() != null) {
            userNameField.setText(set.getUser());
        }
        if (set != null && set.getPass() != null) {
            passwordField.setText(set.getPass());
        }
        if (set != null && set.getFolderName() != null) {
            folderField.setText(set.getFolderName());
        } else {
            folderField.setText("inbox");
        }
        if (set != null) {
            timeField.setText(String.valueOf((double) set.getDelay() / 1000 / 60));
        } else {
            timeField.setText("0");
        }
    }
    
    void store() {
        Settings set = new Settings();
        set.setUser(userNameField.getText());
        set.setPass(new String(passwordField.getPassword()));
        set.setFolderName(folderField.getText());
        set.setDelay((int) (format.getValue().doubleValue() * 60 * 1000));
        
        Settings.save(set);
        
        Notifier.stop();
        Notifier.start();
    }
    
    boolean valid() {
        return true;
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel exampleLabel;
    private javax.swing.JTextField folderField;
    private javax.swing.JLabel folderLabel;
    private javax.swing.JLabel minutes;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField timeField;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration                   
}
