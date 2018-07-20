package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import utils.Util;

public class AddUserServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        UserDao userDao = new UserDao();
        String uname = request.getParameter("uname");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        System.out.println(uname);
        if (!Util.isEmpty(uname) && !Util.isEmpty(password2) && !Util.isEmpty(password2)) {
            if (password1.equals(password2)) {
                userDao.create(uname, password1);
            }
            else {
                //�������벻һ��
                response.setStatus(1004);
            }
        }
        else {
            //������ǳ�Ϊ��
            response.setStatus(1005);
        }
        
        try {
            response.sendRedirect("admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
