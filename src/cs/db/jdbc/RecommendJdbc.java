package cs.db.jdbc;

import java.sql.*;

public class RecommendJdbc {
    public static int ans = 0, _ans = 0, _rand;
    public static String find_name() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";

        String sql = "select * from recommend_info;";
        String temp = "";
        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try {
            conn = DriverManager.getConnection(url, user, password);
            prst = conn.prepareStatement(sql);

            rs = prst.executeQuery();

            while(rs.next()){      //这里必须循环遍历
                ans ++;
            }

            prst = conn.prepareStatement(sql);
            rs = prst.executeQuery();

            _rand = (int)Math.random() * ans + 1;

            while(rs.next()){      //这里必须循环遍历
                _ans ++;
                if(_ans == _rand) {
                    temp += "图书名： " + rs.getString(2) + "，     推荐理由：" +  rs.getString(3);
                }
            }

            return temp;

        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(conn != null) conn.close();
            if(prst != null) prst.close();
        }
        return temp;
    }

    public static String find_reason() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";

        String sql = "select * from recommend_info;";
        String temp = "1";
        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try {
            conn = DriverManager.getConnection(url, user, password);
            prst = conn.prepareStatement(sql);

            rs = prst.executeQuery();

            while(rs.next()){      //这里必须循环遍历
                temp = rs.getString(3);//返回一条记录
                break;
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

}
