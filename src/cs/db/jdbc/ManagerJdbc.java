package cs.db.jdbc;

import java.sql.*;

public class ManagerJdbc {
    public static boolean add_manager(String account, String pass, String name) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql="insert into manager_info(manager_account, manager_password, manager_name)"
                + " values(?,?,?);";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);
            prst = conn.prepareStatement(sql);
            prst.setString(1, account);
            prst.setString(2, pass);
            prst.setString(3, name);

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

    public static boolean delete_manager(String name) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql="delete from manager_info where manager_account = ?;";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);
            prst = conn.prepareStatement(sql);
            prst.setString(1, name);

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

    public static boolean modify_manager(String account, String pass, String name, String old) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql="update manager_info set manager_password = ?, manager_name = ? where manager_account = ? and manager_password = ?;";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);
            prst = conn.prepareStatement(sql);
            prst.setString(1, pass);
            prst.setString(2, name);
            prst.setString(3, account);
            prst.setString(4, old);

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

    public static String find_manager(String account, String pass) throws  SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";

        String sql = "select * from manager_info where manager_account = ? and manager_password = ?;";
        String temp = "1";
        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try {
            conn = DriverManager.getConnection(url, user, password);
            prst = conn.prepareStatement(sql);
            prst.setString(1, account);
            prst.setString(2, pass);

            rs = prst.executeQuery();

            while(rs.next()){      //这里必须循环遍历
                temp = rs.getString(4);//返回一条记录
            }
        System.out.println(temp);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(conn != null) conn.close();
            if(prst != null) prst.close();
        }
        return temp;
    }

    public static String find_password(String account) throws  SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";

        String sql = "select * from manager_info where manager_account = ?;";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)
        String tempp = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            prst = conn.prepareStatement(sql);
            prst.setString(1, account);

            rs = prst.executeQuery();

            while(rs.next()){      //这里必须循环遍历
                tempp = rs.getString(3);//返回一条记录
            }
            System.out.println(tempp);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(conn != null) conn.close();
            if(prst != null) prst.close();
        }
        return tempp;
    }

}
