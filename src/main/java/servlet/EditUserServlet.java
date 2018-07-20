package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;


public class EditUserServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String uid = request.getParameter("uid");
	    UserDao userDao = new UserDao();
	    User user = userDao.findById(Integer.valueOf(uid));
	    request.setAttribute("user", user);
	    request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String uid = request.getParameter("uid");
	    String uname = request.getParameter("uname");
	    String password = request.getParameter("password");
	    UserDao userDao = new UserDao();
	    userDao.update(Integer.valueOf(uid), uname, password);
	    response.sendRedirect("admin");
	}

}
