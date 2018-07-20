package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Notice;
import dao.NoticeDao;

public class EditNoticeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String nid = request.getParameter("nid");
        Notice notice = new NoticeDao().findById(Integer.valueOf(nid));
        request.setAttribute("notice", notice);
        
        try {
            request.getRequestDispatcher("editNotice.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String nid = request.getParameter("nid");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        long time = new Date().getTime();
        new NoticeDao().update(title, content, Long.valueOf(time), Integer.valueOf(nid));
        
        try {
            response.sendRedirect("admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
