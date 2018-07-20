package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Util;

public class LoginCheckFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String uid = (String)((HttpServletRequest)request).getSession().getAttribute("uid");
        
        if (Util.isEmpty(uid)) {
            ((HttpServletResponse)response).sendRedirect("login.jsp");
        }
        else {
            chain.doFilter(request, response);
        }
    }

}
