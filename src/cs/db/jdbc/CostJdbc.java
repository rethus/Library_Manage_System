package cs.db.jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CostJdbc {
    public static boolean add_cost(String username) throws SQLException {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(date);
        Timestamp timestamp = Timestamp.valueOf(nowTime);

        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
//        String sql1 = "update cost_info,borrow_return_info set cost_name = borrow_username where borrow_date = cost_date;";
        String sql2 = "update cost_info, borrow_return_info set cost_name = borrow_username, cost_totol =  1.5 * (return_date - borrow_date) / 86400000  where return_date = cost_date;";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);

//            prst = conn.prepareStatement(sql1);
//            int x = prst.executeUpdate();

            prst = conn.prepareStatement(sql2);
            int y = prst.executeUpdate();

            return y != 0;
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
