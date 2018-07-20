package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Notice;
import bean.User;
import dao.NoticeDao;
import dao.UserDao;

public class AdminIndexServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        UserDao userDao = new UserDao();
        NoticeDao noticeDao = new NoticeDao();
        List<User> users = userDao.findAll();
        List<Notice> notices = noticeDao.findAll();
        request.setAttribute("users", users);
        request.setAttribute("notices", notices);
        
        try {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
