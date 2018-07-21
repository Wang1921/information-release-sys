package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Util;

public class AdminLoginCheckFilter implements Filter {
    
    
    
    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String aid = (String)((HttpServletRequest)request).getSession().getAttribute("aid");

        if (Util.isEmpty(aid)) {
            ((HttpServletResponse)response).sendRedirect("adminLogin.jsp");
        }
        else {
            chain.doFilter(request, response);
        }
    }

}
