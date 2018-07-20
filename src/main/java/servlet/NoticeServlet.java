package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Notice;
import dao.NoticeDao;

public class NoticeServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String nid = request.getParameter("nid");
        NoticeDao noticeDao = new NoticeDao();
        Notice notice = noticeDao.findById(Integer.valueOf(nid));
        request.setAttribute("notice", notice);
        
        try {
            request.getRequestDispatcher("notice.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
