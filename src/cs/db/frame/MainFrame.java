package cs.db.frame;

import cs.db.jdbc.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends BaseFrame{
    private JFrame frame1;//窗口
    private JPanel panel;//
    private JLabel label1;
    private JTextField text1;
    private JPasswordField password1;
    private JButton button1;
    private JMenu menu1, menu2, menu3, menu4, menu5, menu6;
    private JMenuBar menuBar;
    private JMenuItem menuItem11, menuItem12, menuItem13,
            menuItem21, menuItem22, menuItem23,
            menuItem31, menuItem32, menuItem33,
            menuItem41, menuItem51, menuItem61;
    private JTable table, table_;
    private JScrollPane scrollPane, scrollPane_;
    private DefaultTableModel defaultTableModel, defaultTableModel_;

    public MainFrame mainFrame = null;
    public AppointmentFrame appointmentFrame = null;
    public ManagerFrame managerFrame = null;
    public BookFrame bookFrame = null;
    public BorrowFrame borrowFrame = null;
    public RecommendFrame recommendFrame = null;
    public BuilderFrame builderFrame = null;
    public commonuserFrame commonuserframe = null;

    public static String[] colName = {"图书编号", "图书名", "类别","位置","出版社","印刷日期","数量","  ","缴费序号","缴费人","缴费金额","缴费日期"};
    public static String[][] tableValue = new String[50][20];


    public MainFrame() throws SQLException {
        initFrame();

        scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 30, 800, 330);
        table = new JTable();
        panel.add(scrollPane);
        show_();
        defaultTableModel = new DefaultTableModel(tableValue, colName);
        table.setModel(defaultTableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(table);

//一.
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
//1.
        menu1 = new JMenu("用户管理");
        menuBar.add(menu1);
//(1)
        menuItem11 = new JMenuItem("修改用户");
        menu1.add(menuItem11);
        menuItem11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_11_Action(e);
            }
        });
//(2)
        menuItem12 = new JMenuItem("增添用户");
        menu1.add(menuItem12);
        menuItem12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_12_Action(e);
            }
        });
//(3)
        menuItem13 = new JMenuItem("删除用户");
        menu1.add(menuItem13);
        menuItem13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_13_Action(e);
            }
        });
//2.
        menu2 = new JMenu("图书管理");
        menuBar.add(menu2);
//(1)
        menuItem21 = new JMenuItem("修改图书信息");
        menu2.add(menuItem21);
        menuItem21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_21_Action(e);
            }
        });
//(2)
        menuItem22 = new JMenuItem("购入图书");
        menu2.add(menuItem22);
        menuItem22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_22_Action(e);
            }
        });
//(3)
        menuItem23 = new JMenuItem("丢失图书");
        menu2.add(menuItem23);
        menuItem23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_23_Action(e);
            }
        });
//3.
        menu3 = new JMenu("借阅管理");
        menuBar.add(menu3);
//(1)
        menuItem31 = new JMenuItem("借书");
        menu3.add(menuItem31);
        menuItem31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_31_Action(e);
            }
        });
//(2)
        menuItem32 = new JMenuItem("还书");//还书的时候判断是否付费
        menu3.add(menuItem32);
        menuItem32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_32_Action(e);
            }
        });
//4.
        menu4 = new JMenu("预约管理");
        menuBar.add(menu4);
//(1)
        menuItem41 = new JMenuItem("立即预约");
        menu4.add(menuItem41);
        menuItem41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_41_Action(e);
            }
        });
//5.
        menu5 = new JMenu("推荐书目");
        menuBar.add(menu5);
//(1)
        menuItem51 = new JMenuItem("今日推荐");
        menu5.add(menuItem51);
        menuItem51.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    menuItem_51_Action(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
//6.
        menu6 = new JMenu("创建者");
        menuBar.add(menu6);
//(1)
        menuItem61 = new JMenuItem("创建者信息");
        menu6.add(menuItem61);
        menuItem61.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem_61_Action(e);
            }
        });
    }

    private void initFrame() {
        setTitle("图书馆管理系统");

        Toolkit toolkit = getToolkit();                    // 获得Toolkit对象
        Dimension dimension = toolkit.getScreenSize();     // 获得Dimension对象
        int screenHeight = dimension.height;               // 获得屏幕的高度
        int screenWidth = dimension.width;                 // 获得屏幕的宽度
        this.setSize(screenWidth / 2, screenHeight / 2);//设置窗体大小
        this.setLocation(screenWidth / 4, screenHeight / 4);//窗体左上角坐标
        this.setVisible(true);//透明
        this.setResizable(true);//窗体可更改大小
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//windows关闭

        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);//可自定义
        panel.setOpaque(false);//透明
        setContentPane(panel);//设置面板


        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("F:\\A_AAdesktop\\photograph\\9.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

    private void menuItem_11_Action(ActionEvent e){
        if (managerFrame == null) {
            managerFrame = new ManagerFrame();
        }
        managerFrame.setTabSeq(0);
        managerFrame.setVisible(true);
    }

    private void menuItem_12_Action(ActionEvent e){
        if (managerFrame == null){
            managerFrame = new ManagerFrame();
        }
        managerFrame.setTabSeq(1);
        managerFrame.setVisible(true);
     }

    private void menuItem_13_Action(ActionEvent e){
        if (managerFrame == null) {
            managerFrame = new ManagerFrame();
        }
        managerFrame.setTabSeq(2);
        managerFrame.setVisible(true);
    }

    private void menuItem_21_Action(ActionEvent e){
        if (bookFrame == null){
            bookFrame = new BookFrame();
        }
        bookFrame.setTabSeq(0);
        bookFrame.setVisible(true);
    }

    private void menuItem_22_Action(ActionEvent e){
        if (bookFrame == null){
            bookFrame = new BookFrame();
        }
        bookFrame.setTabSeq(1);
        bookFrame.setVisible(true);
    }

    private void menuItem_23_Action(ActionEvent e){
        if (bookFrame == null){
            bookFrame = new BookFrame();
        }
        bookFrame.setTabSeq(2);
        bookFrame.setVisible(true);
    }

    private void menuItem_31_Action(ActionEvent e){
        if (borrowFrame == null){
            borrowFrame = new BorrowFrame();
        }
        borrowFrame.setTabSeq(0);
        borrowFrame.setVisible(true);
    }

    private void menuItem_32_Action(ActionEvent e){
        if (borrowFrame == null){
            borrowFrame = new BorrowFrame();
        }
        borrowFrame.setTabSeq(1);
        borrowFrame.setVisible(true);
    }

    private void menuItem_41_Action(ActionEvent e){
        if (appointmentFrame == null){
            appointmentFrame = new AppointmentFrame();
        }
        appointmentFrame.setVisible(true);
    }

    private void menuItem_51_Action(ActionEvent e) throws SQLException {
        if (recommendFrame == null){
            recommendFrame = new RecommendFrame();
        }
        recommendFrame.setVisible(true);
    }

    private void menuItem_61_Action(ActionEvent e){
        if (builderFrame == null){
            builderFrame = new BuilderFrame();
        }
        builderFrame.setVisible(true);
    }


    public static void show_() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";

        String sql = "select * from book_info;";
        String sqll = "select * from cost_info;";
        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try {
            conn = DriverManager.getConnection(url, user, password);
            prst = conn.prepareStatement(sql);

            rs = prst.executeQuery();
            int i = 0;
            while(rs.next()){      //这里必须循环遍历
                tableValue[i][0] = rs.getString(1);
                tableValue[i][1] = rs.getString(2);
                tableValue[i][2] = rs.getString(3);
                tableValue[i][3] = rs.getString(4);
                tableValue[i][4] = rs.getString(5);
                tableValue[i][5] = rs.getString(6);
                tableValue[i][6] = Integer.toString(rs.getInt(7));
                ++ i;
            }
            i = 0;
            prst = conn.prepareStatement(sqll);
            rs = prst.executeQuery();
            while(rs.next()){      //这里必须循环遍历
                tableValue[i][8] = Integer.toString(rs.getInt(1));
                tableValue[i][9] = rs.getString(2);
                tableValue[i][10] = rs.getString(3);
                tableValue[i][11] = rs.getString(4);
                ++ i;
            }



        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(conn != null) conn.close();
            if(prst != null) prst.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        MainFrame x = new MainFrame();
        x.setVisible(true);
    }

}
