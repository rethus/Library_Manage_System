package cs.db.jdbc;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowJdbc {
    public static boolean borrow_book(String id, String username) throws SQLException {
        java.util.Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(date);
        Timestamp timestamp = Timestamp.valueOf(nowTime);


        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql1 = "update book_info set book_num = (book_num - 1) where book_id = ?;";
        String sql2 = "insert into borrow_return_info(borrow_book_id, borrow_date, borrow_username) " +
                " values(?,?,?);";

        Connection conn = null;
        PreparedStatement prst1 = null, prst2 = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);

            prst1 = conn.prepareStatement(sql1);
            prst1.setString(1, id);
            int x = prst1.executeUpdate();

            prst2 = conn.prepareStatement(sql2);
            prst2.setString(1, id);
            prst2.setTimestamp(2, timestamp);
            prst2.setString(3, username);

            int y = prst2.executeUpdate();

            return x != 0 || y != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            if(rs != null) rs.close();
            if(conn != null) conn.close();
            if(prst1 != null) prst1.close();
            if(prst2 != null) prst2.close();
        }
    }

    public static boolean return_book(String id, String username) throws SQLException {
        java.util.Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(date);
        Timestamp timestamp = Timestamp.valueOf(nowTime);


        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql1 = "update book_info set book_num = (book_num + 1) where book_id = ?;";
        String sql2 = "update borrow_return_info set return_date = ? where borrow_book_id = ?;";
        String sql3 = "insert into cost_info (cost_date) values(?);";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);
            prst = conn.prepareStatement(sql1);
            prst.setString(1, id);
            int x = prst.executeUpdate();

            prst = conn.prepareStatement(sql2);
            prst.setTimestamp(1, timestamp);
            prst.setString(2, id);
            int y = prst.executeUpdate();

            prst = conn.prepareStatement(sql3);
            prst.setTimestamp(1, timestamp);
            int z = prst.executeUpdate();

            return x != 0 || y != 0 || z != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            if(rs != null) rs.close();
            if(conn != null) conn.close();
            if(prst != null) prst.close();
        }
    }
}
