package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;
import utils.Util;

public class ChangePasswordServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");
        String uid = (String) request.getSession().getAttribute("uid");
        
        //判断用户是否登录
        if (!Util.isEmpty(uid)) {
            UserDao userDao = new UserDao();
            User user = userDao.findById(Integer.valueOf(uid));
            
            if (!Util.isEmpty(oldPassword) && !Util.isEmpty(newPassword1) && !Util.isEmpty(newPassword2)) {
                if (oldPassword.equals(user.getPassword())) {
                    if (newPassword1.equals(newPassword2)) {
                        userDao.updatePassword(user.getUid(), newPassword1);
                        request.getSession().removeAttribute("uid");
                        
                        try {
                            response.sendRedirect("login.jsp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                      //输入的两次密码不一致 
                    }
                } else {
                    //密码输入错误
                }
            } else {
                //输入为空
            }
        } else {
            //未登录
        }
        

    }
}
