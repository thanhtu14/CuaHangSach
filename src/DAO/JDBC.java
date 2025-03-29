package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/sach"; // Thay ten_database bằng tên CSDL của bạn
    private static final String USER = "root"; // Thay bằng tên người dùng MySQL của bạn
    private static final String PASSWORD = "3581"; // Thay bằng mật khẩu MySQL của bạn

    public static Connection getJDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, "Lỗi load driver", ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, "Lỗi kết nối CSDL", ex);
        }
        return null;
    }
    
}
