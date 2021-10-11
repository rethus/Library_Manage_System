package cs.db.frame;


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


public class BuilderFrame extends BaseFrame{
    private JFrame frame1;//窗口
    private JPanel panel1, panel2, panel3, panel4;//左上角板子
    private JLabel label1, label2, label3, label4;
    private JTextField text1, text2, text3;
    private JPasswordField password1;
    private JButton button1, button2;
    private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
    private JMenuBar menuBar;
    private JMenuItem menuItem1, menuItem2, menuItem3;
    private JTable table;
    private JTabbedPane tabbedPane;//标签卡片
    private JScrollPane scrollPane;//滚动条

    public BuilderFrame() {
        setTitle("创建者");
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
        tabbedPane.addTab("创建者信息", null, panel1, null);
        panel1.setLayout(null);
//2.lable
        label1 = new JLabel();
        label1.setText("姓名:     陈侠");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setBounds(new Rectangle(66, 92, 120, 20));

        label2 = new JLabel();
        label2.setText("班级:     计科1902");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setBounds(new Rectangle(80, 122, 120, 20));

        label3 = new JLabel();
        label3.setText("学号:     1912190427");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setBounds(new Rectangle(90, 152, 120, 20));

        label4 = new JLabel();
        label4.setText("爱好:     踢足球，打代码");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setHorizontalTextPosition(SwingConstants.CENTER);
        label4.setBounds(new Rectangle(60, 182, 200, 20));

//3.text

//4.按钮
        button1 = new JButton("返回");
        button1.setBounds(150, 260, 65, 23);
//添加到panel
        panel1.add(label1, null);
        panel1.add(label2, null);
        panel1.add(label3, null);
        panel1.add(label4, null);

        panel1.add(button1);
//按钮响应
        button1.addActionListener(new ActionListener() {
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

    public static void main(String[] args) {
        BuilderFrame x = new BuilderFrame();
        x.setVisible(true);
    }

}
