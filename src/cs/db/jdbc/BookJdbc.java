package cs.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class BookJdbc{
    public static boolean modify_book(String id, String names, String types, String position, int num) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql="update book_info set book_name = ?, book_type = ?, book_position =?, book_num = ? where book_id = ?;";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);
            prst = conn.prepareStatement(sql);
            prst.setString(1, names);
            prst.setString(2, types);
            prst.setString(3, position);
            prst.setInt(4, num);
            prst.setString(5, id);

            int x = prst.executeUpdate();
            return x != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            if(rs != null) rs.close();
            if(conn != null) conn.close();
            if(prst != null) prst.close();
        }
    }

    public static boolean add_book(String id, String names, String types, String position, int num) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql="insert into book_info() values(?,?,?,?,?,?,?);";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);
            prst = conn.prepareStatement(sql);
            prst.setString(1, id);
            prst.setString(2, names);
            prst.setString(3, types);
            prst.setString(4, position);
            prst.setString(5, "暂无");
            prst.setString(6, "1800-01-01 01:01:01");
            prst.setInt(7, num);

            int x = prst.executeUpdate();
            return x != 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            if(rs != null) rs.close();
            if(conn != null) conn.close();
            if(prst != null) prst.close();
        }
    }

    public static boolean delete_book(String names, int num) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql="update book_info set book_num = (book_num - ?) where book_name = ?;";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);
            prst = conn.prepareStatement(sql);
            prst.setInt(1, num);
            prst.setString(2, names);

            int x = prst.executeUpdate();
            return x != 0;
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
