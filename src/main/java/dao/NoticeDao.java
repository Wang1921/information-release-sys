package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Notice;
import utils.DBUtil;

public class NoticeDao {
    private DBUtil db = new DBUtil();
    private Connection conn = db.connect();
    
    public boolean create(String title, String content, long time) {
        String sql = "insert into notice (title, content, time) values(?, ?, ?)";
        int count = 0;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setLong(3, time);
            count = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return count == 0 ? false : true;
    }
    
    public boolean update(String title, String content, long time, int nid) {
        String sql = "update notice set title = ?, content = ?, time = ? where nid = ?";
        int count = 0;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setLong(3, time);
            statement.setInt(4, nid);
            count = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return count == 0 ? false : true;
    }
    
    public Notice findById(int nid) {
        String sql = "select * from notice where nid = " + nid;
        //String sql = "select * from notice where nid = ?";
        Notice notice = null;
        
        try {
            Statement statement = conn.createStatement();
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1, nid);
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs.next()) {
                notice = new Notice();
                notice.setNid(rs.getInt(1));
                notice.setTitle(rs.getString(2));
                notice.setContent(rs.getString(3));
                notice.setTime(rs.getLong(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return notice;
    }
    
    public List<Notice> findAll() {
        String sql = "select * from notice";
        List<Notice> notices = new ArrayList<>();
        Notice notice = null;
        ResultSet rs = null;
        
        try {
            Statement stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            
            while(rs.next()) {
                notice = new Notice();
                notice.setNid(rs.getInt(1));
                notice.setTitle(rs.getString(2));
                notice.setContent(rs.getString(3));
                notice.setTime(rs.getLong(4));
                notices.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
       return notices;
    }
    
    public void delete(int nid) {
        String sql = "delete from notice where nid = " + nid;
        
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void close( ) {
        
    }
}
