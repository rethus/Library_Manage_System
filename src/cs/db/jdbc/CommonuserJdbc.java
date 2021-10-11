package cs.db.jdbc;

import java.sql.*;

public class CommonuserJdbc {
    public static boolean modify_common(String account, String pass) throws SQLException{
        String url = "jdbc:mysql://127.0.0.1:3306/library_ms?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "a123456";
        String sql="update manager_info set manager_password = ? where manager_account = ?;";

        Connection conn = null;
        PreparedStatement prst = null;
        Statement st = null;
        ResultSet rs = null;//stmt.executeQuery(sql)

        try{
            conn = DriverManager.getConnection(url,user,password);
            prst = conn.prepareStatement(sql);
            prst.setString(1, pass);
            prst.setString(2, account);

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
