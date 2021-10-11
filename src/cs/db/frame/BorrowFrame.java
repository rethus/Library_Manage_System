package cs.db.frame;

import cs.db.jdbc.BorrowJdbc;
import cs.db.jdbc.CostJdbc;
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


public class BorrowFrame extends BaseFrame{
    private JFrame frame1;//窗口
    private JPanel panel1, panel2, panel3, panel4;//左上角板子
    private JLabel label1, label2, label3, label4;
    private JTextField text1, text2, text3, text4;
    private JPasswordField password1;
    private JButton button1, button2, button3, button4;
    private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
    private JMenuBar menuBar;
    private JMenuItem menuItem1, menuItem2, menuItem3;
    private JTable table;
    private JTabbedPane tabbedPane;//标签卡片
    private JScrollPane scrollPane;//滚动条

    public BorrowFrame() {
        setTitle("借阅管理");
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
        tabbedPane.addTab("借书", null, panel1, null);
        panel1.setLayout(null);
//2.lable
        label1 = new JLabel();
        label1.setText("图书编号: ");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setBounds(new Rectangle(66, 92, 120, 20));

        label2 = new JLabel();
        label2.setText("借阅者姓名: ");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setBounds(new Rectangle(66, 132, 120, 20));
//3.text
        text1 = new JTextField();
        text1.setBounds(new Rectangle(186, 92, 100, 20));
        text1.setColumns(8);

        text2 = new JTextField();
        text2.setBounds(new Rectangle(186, 132, 100, 20));
        text2.setColumns(8);

//4.按钮
        button1 = new JButton("借阅");
        button1.setBounds(121, 260, 65, 23);

        button2 = new JButton("返回");
        button2.setBounds(180, 260, 65, 23);
//------------------2
//panel
        panel2 = new JPanel();
        getContentPane().add(panel2, BorderLayout.CENTER);
        panel2.setOpaque(false);//透明
//tabbedPane

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
//1.tab
        tabbedPane.addTab("还书", null, panel2, null);
        panel2.setLayout(null);
//2.lable
        label3 = new JLabel();
        label3.setText("图书编号: ");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setBounds(new Rectangle(66, 92, 120, 20));

        label4 = new JLabel();
        label4.setText("归还者者姓名: ");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setHorizontalTextPosition(SwingConstants.CENTER);
        label4.setBounds(new Rectangle(66, 132, 120, 20));
//3.text
        text3 = new JTextField();
        text3.setBounds(new Rectangle(186, 92, 100, 20));
        text3.setColumns(8);

        text4 = new JTextField();
        text4.setBounds(new Rectangle(186, 132, 100, 20));
        text4.setColumns(8);

//4.按钮
        button3 = new JButton("归还");
        button3.setBounds(121, 260, 65, 23);

        button4 = new JButton("返回");
        button4.setBounds(180, 260, 65, 23);

//添加到panel
        panel1.add(text1, null);
        panel1.add(label1, null);
        panel1.add(text2, null);
        panel1.add(label2, null);
        panel1.add(button1);
        panel1.add(button2);

        panel2.add(text3, null);
        panel2.add(label3, null);
        panel2.add(text4, null);
        panel2.add(label4, null);
        panel2.add(button3);
        panel2.add(button4);
//按钮响应
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(borrow_(e)) JOptionPane.showMessageDialog(panel1, "借阅成功", "信息", 3);
                    else JOptionPane.showMessageDialog(panel1, "借阅失败", "信息", 3);
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
                    if(return_(e)) JOptionPane.showMessageDialog(panel2, "归还成功", "信息", 3);
                    else JOptionPane.showMessageDialog(panel2, "借归还失败", "信息", 3);
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

        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("F:\\A_AAdesktop\\photograph\\9.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

    private boolean borrow_(ActionEvent e) throws SQLException{
        String id = text1.getText();
        String user = text2.getText();

        BorrowJdbc borrowJdbc = new BorrowJdbc();
        boolean f = borrowJdbc.borrow_book(id, user);

        text1.setText(null);
        text2.setText(null);

        return f;
    }

    private boolean return_(ActionEvent e) throws SQLException{
        String id = text3.getText();
        String user = text4.getText();

        CostJdbc costJdbc = new CostJdbc();
        BorrowJdbc borrowJdbc = new BorrowJdbc();
        boolean f = borrowJdbc.return_book(id, user), ff = costJdbc.add_cost(user);

        text3.setText(null);
        text4.setText(null);
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
        BorrowFrame x = new BorrowFrame();
        x.setVisible(true);
    }

}
