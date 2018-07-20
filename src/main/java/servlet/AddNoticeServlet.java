package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;

public class AddNoticeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        long time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        
        NoticeDao notice = new NoticeDao();
        notice.create(title, content, time);
        
        try {
            response.sendRedirect("admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
