package cs.db.frame;

import cs.db.jdbc.ManagerJdbc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class LoginFrame extends BaseFrame{
    private JLabel jLabel1;
    private JTextField nameTextField;
    private JLabel jLabel2;
    private JPasswordField passwordField;
    private JButton okButton,cancelButton;
    private JPanel panel;
    public LoginFrame() {
        setTitle("系统登录");

        setSize(400, 300);
        Toolkit toolkit = getToolkit();                    // 获得Toolkit对象
        Dimension dimension = toolkit.getScreenSize();     // 获得Dimension对象
        int screenHeight = dimension.height;               // 获得屏幕的高度
        int screenWidth = dimension.width;                 // 获得屏幕的宽度
        int frm_Height = this.getHeight();                 // 获得窗体的高度
        int frm_width = this.getWidth();                   // 获得窗体的宽度
        this.setLocation((screenWidth - frm_width) / 2,
                (screenHeight - frm_Height) / 2);          // 使用窗体居中显示
        setAlwaysOnTop(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
//第一块
        jLabel1 = new JLabel();
        jLabel1.setText("用户名: ");
        jLabel1.setBounds(new Rectangle(106, 52, 60, 20));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(jLabel1);

        nameTextField = new JTextField();
        nameTextField.setBounds(new Rectangle(186, 52, 100, 20));
        nameTextField.setColumns(8);
        panel.add(nameTextField, null);
//第二块
        jLabel2 = new JLabel();
        jLabel2.setText("密    码: ");
        jLabel2.setBounds(new Rectangle(106, 82, 60, 20));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(jLabel2);

        passwordField = new JPasswordField();
        passwordField.setBounds(new Rectangle(186, 82, 100, 20));
        passwordField.requestFocus();
        panel.add(passwordField, null);
//第三块
        okButton = new JButton();
        okButton.setText("确定");
        okButton.setSize(new Dimension(60, 23));
        okButton.setLocation(new Point(106, 130));

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okButtonActionPerformed(e);
            }
        });

        panel.add(okButton, null);

        cancelButton= new JButton();
        cancelButton.setText("取消");
        cancelButton.setSize(new Dimension(60, 23));
        cancelButton.setLocation(new Point(224, 130));


        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                cancelButtonActionPerformed(e);
            }
        });

        panel.add(cancelButton, null);

        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);
        this.setVisible(true);

        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon
                ("F:\\A_AAdesktop\\photograph\\9.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
//button
    private void okButtonActionPerformed(ActionEvent e){
        String name = nameTextField.getText();
        String password = String.valueOf(passwordField.getPassword());
        try {
                option = "1";
                option = ManagerJdbc.find_manager(name, password);
                if (option.equalsIgnoreCase("manager")) {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                    dispose();
                } else if(option.equalsIgnoreCase("common")) {
                    MmainFrame mmainFrame = new MmainFrame();
                    mmainFrame.setVisible(true);
                    dispose();
                } else {
                    nameTextField.setText(null);
                    passwordField.setText(null);
                    JOptionPane.showMessageDialog(panel, "输入的账号或密码错误", "警告面板", 3);
                }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(panel,e1.getMessage(),"输入反馈",JOptionPane.YES_NO_OPTION);
        }

    }

    private void cancelButtonActionPerformed(ActionEvent e){
        nameTextField.setText(null);
        passwordField.setText(null);
    }

    public static void main(String[] args) {
        LoginFrame x = new LoginFrame();
        x.setVisible(true);
    }

}
