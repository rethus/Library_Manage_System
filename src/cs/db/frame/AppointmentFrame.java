package cs.db.frame;

import cs.db.jdbc.AppointmentJdbc;

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

public class AppointmentFrame extends BaseFrame{
    private JFrame frame1;//窗口
    private JPanel panel1, panel2, panel3, panel4;//左上角板子
    private JLabel label1, label2, label3;
    private JTextField text1, text2, text3;
    private JPasswordField password1;
    private JButton button1, button2;
    private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
    private JMenuBar menuBar;
    private JMenuItem menuItem1, menuItem2, menuItem3;
    private JTable table;
    private JTabbedPane tabbedPane;//标签卡片
    private JScrollPane scrollPane;//滚动条

    public AppointmentFrame() {
        setTitle("预约管理");
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
        tabbedPane.addTab("立即预约", null, panel1, null);
        panel1.setLayout(null);
//2.lable
        label1 = new JLabel();
        label1.setText("预约书编号: ");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setBounds(new Rectangle(66, 92, 120, 20));

        label2 = new JLabel();
        label2.setText("预约书名: ");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setBounds(new Rectangle(66, 122, 120, 20));

        label3 = new JLabel();
        label3.setText("预约者名字: ");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setBounds(new Rectangle(66, 152, 120, 20));
//3.text
        text1 = new JTextField();
        text1.setBounds(new Rectangle(186, 92, 100, 20));
        text1.setColumns(8);

        text2 = new JTextField();
        text2.setBounds(new Rectangle(186, 122, 100, 20));
        text2.setColumns(8);

        text3 = new JTextField();
        text3.setBounds(new Rectangle(186, 152, 100, 20));
        text3.setColumns(8);
//4.按钮
        button1 = new JButton("预约");
        button1.setBounds(121, 260, 65, 23);

        button2 = new JButton("返回");
        button2.setBounds(180, 260, 65, 23);
//添加到panel
        panel1.add(text1, null);
        panel1.add(label1, null);
        panel1.add(text2, null);
        panel1.add(label2, null);
        panel1.add(text3, null);
        panel1.add(label3, null);

        panel1.add(button1);
        panel1.add(button2);
//按钮相应
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (appoint_(e))  JOptionPane.showMessageDialog(panel1, "预约成功", "信息", 3);
                    else JOptionPane.showMessageDialog(panel1, "预约失败", "信息", 1);
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

    public void setTabSeq(int index){
        tabbedPane.setSelectedIndex(index);
    }

    private void jTabbedPaneStateChanged(ChangeEvent evt) {
        if(tabbedPane.getSelectedIndex()==0){
//            show();
        }
    }

    private boolean appoint_(ActionEvent e) throws SQLException {
        String id = text1.getText();
        String name = text2.getText();
        String username = text3.getText();
        AppointmentJdbc appointmentJdbc = new AppointmentJdbc();
        return appointmentJdbc.appoint_book(id, name, username);
    }


    public static void main(String[] args) {
        AppointmentFrame x = new AppointmentFrame();
        x.setVisible(true);
    }

}
