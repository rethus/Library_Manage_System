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
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class commonuserFrame extends BaseFrame{


    private JFrame frame1;//窗口
    private JPanel panel1, panel2, panel3, panel4;//左上角板子
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    private JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9;
    private JPasswordField password1;
    private JButton button1, button2, button3, button4, button5, button6;
    private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
    private JMenuBar menuBar;
    private JMenuItem menuItem1, menuItem2, menuItem3;
    private JTable table;
    private JTabbedPane tabbedPane;//标签卡片
    private JScrollPane scrollPane;//滚动条

    private JPasswordField jPasswordField2, jPasswordField3, jPasswordField4, jPasswordField6;

    public commonuserFrame() {
        setTitle("用户管理");
        //窗体属性设置
        setSize(400, 500);
        Toolkit toolkit = getToolkit();                    // 获得Toolkit对象
        Dimension dimension = toolkit.getScreenSize();     // 获得Dimension对象
        int screenHeight = this.getHeight();               // 获得屏幕的高度
        int screenWidth = this.getWidth();                 // 获得屏幕的宽度
        this.setSize(screenWidth, screenHeight);//设置窗体大小
        this.setLocation((dimension.width - screenWidth) / 2, (dimension.height - screenHeight) / 2);//窗体左上角坐标
        this.setVisible(true);//透明
        this.setResizable(true);//窗体可更改大小
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//windows关闭
//panel
        panel1 = new JPanel();
        getContentPane().add(panel1, BorderLayout.CENTER);
        panel1.setOpaque(false);//透明
//tabbedPane
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
//1.tab
        tabbedPane.addTab("修改用户", null, panel1, null);
        panel1.setLayout(null);
//2.lable
        label1 = new JLabel();
        label1.setText("用户名: ");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setBounds(new Rectangle(66, 92, 120, 20));

        label2 = new JLabel();
        label2.setText("原密码: ");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setBounds(new Rectangle(66, 122, 120, 20));

        label3 = new JLabel();
        label3.setText("新密码: ");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setBounds(new Rectangle(66, 152, 120, 20));

        label4 = new JLabel();
        label4.setText("新密码: ");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setHorizontalTextPosition(SwingConstants.CENTER);
        label4.setBounds(new Rectangle(66, 182, 120, 20));

//3.text
        text1 = new JTextField();
        text1.setBounds(new Rectangle(186, 92, 100, 20));
        text1.setColumns(8);

        jPasswordField2 = new JPasswordField();
        jPasswordField2.setBounds(new Rectangle(186, 122, 100, 20));
        jPasswordField2.requestFocus();

        jPasswordField3 = new JPasswordField();
        jPasswordField3.setBounds(new Rectangle(186, 152, 100, 20));
        jPasswordField3.requestFocus();


        jPasswordField4 = new JPasswordField();
        jPasswordField4.setBounds(new Rectangle(186, 182, 100, 20));
        jPasswordField4.requestFocus();

        text9 = new JTextField();
        text9.setBounds(new Rectangle(186, 212, 100, 20));
        text9.setColumns(8);
//4.按钮
        button1 = new JButton("确定修改");
        button1.setBounds(111, 260, 90, 23);

        button2 = new JButton("返回");
        button2.setBounds(200, 260, 65, 23);
//添加到panel
        panel1.add(text1, null);
        panel1.add(label1, null);
        panel1.add(jPasswordField2, null);
        panel1.add(label2, null);
        panel1.add(jPasswordField3, null);
        panel1.add(label3, null);
        panel1.add(jPasswordField4, null);
        panel1.add(label4, null);

        panel1.add(button1);
        panel1.add(button2);

//按钮响应
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(modify_(e)) JOptionPane.showMessageDialog(panel1, "修改成功", "信息", 3);
                    else JOptionPane.showMessageDialog(panel1, "修改失败", "信息", 3);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReturnMainFrame(e);
            }
        });


        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("F:\\A_AAdesktop\\photograph\\9.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

    private boolean modify_(ActionEvent e) throws SQLException {
        String account = text1.getText();
        String  old = String.valueOf(jPasswordField2.getPassword());
        String pass = String.valueOf(jPasswordField3.getPassword());
        String pass_ = String.valueOf(jPasswordField4.getPassword());
        if(pass.equalsIgnoreCase(pass_)) {
            ManagerJdbc managerJdbc = new ManagerJdbc();
            boolean f = managerJdbc.modify_manager(account, pass, "common", old);
            text1.setText(null);
            jPasswordField2.setText(null);
            jPasswordField3.setText(null);
            jPasswordField4.setText(null);
            return f;
        } else {
            text1.setText(null);
            jPasswordField2.setText(null);
            jPasswordField3.setText(null);
            jPasswordField4.setText(null);
            return false;
        }
    }

    public void setTabSeq(int index){
        tabbedPane.setSelectedIndex(index);
    }

    private void jTabbedPaneStateChanged(ChangeEvent evt) {
        if(tabbedPane.getSelectedIndex()==0){
//            show();
        }
    }

    public static void main(String[] args) {
        commonuserFrame x = new commonuserFrame();
        x.setVisible(true);
    }

}
