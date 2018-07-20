package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.NoticeDao;
import dao.UserDao;
import utils.Util;

public class LoginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        
        if (!Util.isEmpty(uid) && !Util.isEmpty(password)) {
            User user = userDao.findById(Integer.valueOf(uid));
            
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    request.getSession().setAttribute("uid", uid);
                    
                    try {
                        //request.getRequestDispatcher("index").forward(request, response);
                        response.sendRedirect("index");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    //�������
                    response.setStatus(1001);
                } 
            }
            else {
                //�޴��û�
                response.setStatus(1002);  
            }
        }
        else {
            //ID������Ϊ��
            response.setStatus(1003);
        }
    }
    
}
