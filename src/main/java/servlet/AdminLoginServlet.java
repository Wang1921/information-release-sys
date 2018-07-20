package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String aid = request.getParameter("aid");
        String password = request.getParameter("password");
        
        if (aid.equals("admin") && password.equals("nsfocus")) {
            request.getSession().setAttribute("aid", aid);
            
            try {
                response.sendRedirect("admin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                response.sendRedirect("adminLogin.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
