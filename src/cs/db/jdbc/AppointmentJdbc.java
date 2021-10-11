package cs.db.jdbc;

import java.sql.*;
import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Date;

import java.lang.*;

public class AppointmentJdbc {
    public static boolean appoint_book(String id, String name, String username) throws SQLException {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(date);
        Timestamp timestamp = Timestamp.valueOf(nowTime);

        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql = "insert into appointment_info(appointment_book_id, appointment_user, appointment_date, appointment_book_name)"
                + " values(?,?,?,?);";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
                conn = DriverManager.getConnection(url,user,password);
//                st = conn.createStatement();

                prst = conn.prepareStatement(sql);
                prst.setString(1, id);
                prst.setString(2, username);
                prst.setTimestamp(3, timestamp);
                prst.setString(4, name);

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
    //添加预约消息
}
