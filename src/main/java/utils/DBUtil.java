package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    
    private Connection conn = null;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("���ݿ���������ʧ�ܡ�����������");
            e.printStackTrace();
        }
    }
    
    public Connection connect() {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "insert2333";
        
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("���ݿ�����ʧ�ܡ�����������");
            e.printStackTrace();
        }
        
        return conn;
    }
    
}
