package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import utils.Util;

public class DeleteUserServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        UserDao userDao = new UserDao();
        userDao.delete(Integer.valueOf(uid));
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
       doGet(request, response);
    }
}
