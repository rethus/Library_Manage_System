package cs.db.frame;

import cs.db.jdbc.BookJdbc;
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


public class BookFrame extends BaseFrame{
    private JFrame frame1;//窗口
    private JPanel panel1, panel2, panel3, panel4;//左上角板子
    private JLabel label1, label2, label3, label4, label5, label6,
            label7, label8, label9, label10, label11, label12, label13;
    private JTextField text1, text2, text3, text4, text5, text6,
            text7, text8, text9, text10, text11, text12, text13;
    private JPasswordField password1;
    private JButton button1, button2, button3, button4, button5, button6;
    private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
    private JMenuBar menuBar;
    private JMenuItem menuItem1, menuItem2, menuItem3;
    private JTable table;
    private JTabbedPane tabbedPane;//标签卡片
    private JScrollPane scrollPane;//滚动条

    public BookFrame() {
        setTitle("图书管理");
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
        tabbedPane.addTab("修改图书信息", null, panel1, null);
        panel1.setLayout(null);
//2.lable
        label1 = new JLabel();
        label1.setText("图书编号: ");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setBounds(new Rectangle(66, 92, 120, 20));

        label2 = new JLabel();
        label2.setText("图书名: ");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setBounds(new Rectangle(66, 122, 120, 20));

        label3 = new JLabel();
        label3.setText("图书类别: ");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setBounds(new Rectangle(66, 152, 120, 20));

        label4 = new JLabel();
        label4.setText("图书位置: ");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setHorizontalTextPosition(SwingConstants.CENTER);
        label4.setBounds(new Rectangle(66, 182, 120, 20));

        label10 = new JLabel();
        label10.setText("图书数量: ");
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        label10.setHorizontalTextPosition(SwingConstants.CENTER);
        label10.setBounds(new Rectangle(66, 212, 120, 20));
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

        text4 = new JTextField();
        text4.setBounds(new Rectangle(186, 182, 100, 20));
        text4.setColumns(8);

        text10 = new JTextField();
        text10.setBounds(new Rectangle(186, 212, 100, 20));
        text10.setColumns(8);


//4.按钮
        button1 = new JButton("确定修改");
        button1.setBounds(111, 260, 90, 23);

        button2 = new JButton("返回");
        button2.setBounds(200, 260, 65, 23);
//----------------2
//panel
        panel2 = new JPanel();
        getContentPane().add(panel2, BorderLayout.CENTER);
        panel2.setOpaque(false);//透明
//tabbedPane
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
//1.tab
        tabbedPane.addTab("购入图书", null, panel2, null);
        panel2.setLayout(null);
//2.lable
        label5 = new JLabel();
        label5.setText("图书编号: ");
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setHorizontalTextPosition(SwingConstants.CENTER);
        label5.setBounds(new Rectangle(66, 92, 120, 20));

        label6 = new JLabel();
        label6.setText("图书名: ");
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setHorizontalTextPosition(SwingConstants.CENTER);
        label6.setBounds(new Rectangle(66, 122, 120, 20));

        label11 = new JLabel();
        label11.setText("种类: ");
        label11.setHorizontalAlignment(SwingConstants.CENTER);
        label11.setHorizontalTextPosition(SwingConstants.CENTER);
        label11.setBounds(new Rectangle(66, 152, 120, 20));

        label12 = new JLabel();
        label12.setText("位置: ");
        label12.setHorizontalAlignment(SwingConstants.CENTER);
        label12.setHorizontalTextPosition(SwingConstants.CENTER);
        label12.setBounds(new Rectangle(66, 182, 120, 20));


        label7 = new JLabel();
        label7.setText("数量: ");
        label7.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setHorizontalTextPosition(SwingConstants.CENTER);
        label7.setBounds(new Rectangle(66, 212, 120, 20));
//3.text
        text5 = new JTextField();
        text5.setBounds(new Rectangle(186, 92, 100, 20));
        text5.setColumns(8);

        text6 = new JTextField();
        text6.setBounds(new Rectangle(186, 122, 100, 20));
        text6.setColumns(8);

        text11 = new JTextField();
        text11.setBounds(new Rectangle(186, 152, 100, 20));
        text11.setColumns(8);

        text12 = new JTextField();
        text12.setBounds(new Rectangle(186, 182, 100, 20));
        text12.setColumns(8);

        text7 = new JTextField();
        text7.setBounds(new Rectangle(186, 212, 100, 20));
        text7.setColumns(8);
//4.按钮
        button3 = new JButton("确定购入");
        button3.setBounds(111, 260, 90, 23);

        button4 = new JButton("返回");
        button4.setBounds(200, 260, 65, 23);
//--------------------3
//panel
        panel3 = new JPanel();
        getContentPane().add(panel3, BorderLayout.CENTER);
        panel3.setOpaque(false);//透明
//tabbedPane
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
//1.tab
        tabbedPane.addTab("丢失图书", null, panel3, null);
        panel3.setLayout(null);
//2.lable
        label8 = new JLabel();
        label8.setText("图书名: ");
        label8.setHorizontalAlignment(SwingConstants.CENTER);
        label8.setHorizontalTextPosition(SwingConstants.CENTER);
        label8.setBounds(new Rectangle(66, 92, 120, 20));

        label9 = new JLabel();
        label9.setText("数量: ");
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        label9.setHorizontalTextPosition(SwingConstants.CENTER);
        label9.setBounds(new Rectangle(66, 122, 120, 20));


//3.text
        text8 = new JTextField();
        text8.setBounds(new Rectangle(186, 92, 100, 20));
        text8.setColumns(8);

        text9 = new JTextField();
        text9.setBounds(new Rectangle(186, 122, 100, 20));
        text9.setColumns(8);
//4.按钮
        button5 = new JButton("确定丢失");
        button5.setBounds(111, 260, 90, 23);

        button6 = new JButton("返回");
        button6.setBounds(200, 260, 65, 23);
//添加到panel
        panel1.add(text1, null);
        panel1.add(label1, null);
        panel1.add(text2, null);
        panel1.add(label2, null);
        panel1.add(text3, null);
        panel1.add(label3, null);
        panel1.add(text4, null);
        panel1.add(label4, null);
        panel1.add(text10, null);
        panel1.add(label10, null);
        panel1.add(button1);
        panel1.add(button2);

        panel2.add(text5, null);
        panel2.add(label5, null);
        panel2.add(text6, null);
        panel2.add(label6, null);
        panel2.add(text11, null);
        panel2.add(label11, null);
        panel2.add(text12, null);
        panel2.add(label12, null);
        panel2.add(text7, null);
        panel2.add(label7, null);
        panel2.add(button3);
        panel2.add(button4);

        panel3.add(text8, null);
        panel3.add(label8, null);
        panel3.add(text9, null);
        panel3.add(label9, null);
        panel3.add(button5);
        panel3.add(button6);
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

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(add_(e)) JOptionPane.showMessageDialog(panel2, "添加成功", "信息", 3);
                    else JOptionPane.showMessageDialog(panel2, "添加失败", "信息", 3);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReturnMainFrame(e);
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(delete_(e)) JOptionPane.showMessageDialog(panel3, "删除成功", "信息", 3);
                    else JOptionPane.showMessageDialog(panel3, "删除失败", "信息", 3);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        button6.addActionListener(new ActionListener() {
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
        String id = text1.getText();
        String name = text2.getText();
        String types = text3.getText();
        String pos = text4.getText();
        int num = Integer.parseInt(text10.getText());

        BookJdbc bookJdbc = new BookJdbc();
        boolean f = bookJdbc.modify_book(id, name, types, pos, num);

        text1.setText(null);
        text2.setText(null);
        text3.setText(null);
        text4.setText(null);
        text10.setText(null);

        return f;
    }

    private boolean add_(ActionEvent e) throws SQLException{
        String id = text5.getText();
        String name = text6.getText();
        String types = text11.getText();
        String pos = text12.getText();
        int num = Integer.parseInt(text7.getText());

        BookJdbc bookJdbc = new BookJdbc();
        boolean f = bookJdbc.add_book(id, name, types, pos,num);

        text5.setText(null);
        text6.setText(null);
        text11.setText(null);
        text12.setText(null);
        text7.setText(null);
        return f;
    }

    private boolean delete_(ActionEvent e) throws SQLException{
        String id = text8.getText();
        int num = Integer.parseInt(text9.getText());

        BookJdbc bookJdbc = new BookJdbc();
        boolean f = bookJdbc.delete_book(id, num);

        text8.setText(null);
        text9.setText(null);

        return f;
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
        BookFrame x = new BookFrame();
        x.setVisible(true);
    }
}
