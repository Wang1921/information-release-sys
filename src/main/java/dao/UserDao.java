package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import utils.DBUtil;

public class UserDao {
    
    private DBUtil db = new DBUtil();
    private Connection conn = db.connect();
    
    public boolean create(String uname, String password) {
        String sql = "insert into user (uname, password) values(?, ?)";
        int count = 0;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, uname);
            statement.setString(2, password);
            count = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return count == 0 ? false : true;
    }
    
    public boolean update(int uid, String uname, String password) {
        String sql = "update user set uname = '" + uname + "' , password = '" + password + "' where uid = " + uid;
        int count = 0;
        
        Statement statement;
        try {
            statement = conn.createStatement();
            count = statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return count == 0 ? false : true;
    }
    
    public boolean updatePassword(int uid, String password) {
        String sql = "update user set password = ? where uid = ?";
        int count = 0;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, password);
            statement.setInt(2, uid);
            count = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return count == 0 ? false : true;
    }
    
    public User findById(int uid) {
        String sql = "select * from user where uid = ?";
        User user = null;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user = null;
        String sql = "select * from user";
        
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setPassword(rs.getString(3));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
    
    public boolean delete(int uid) {
        String sql = "delete from user where uid = ?";
        int count = 0;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, uid);
            count = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return count > 0 ? true : false; 
    }

}
