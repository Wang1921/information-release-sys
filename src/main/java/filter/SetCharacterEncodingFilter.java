package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SetCharacterEncodingFilter implements Filter{

    
    
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) arg0;
        
        if (httpRequest.getMethod().equals("POST")) {
            arg0.setCharacterEncoding("utf-8");
        }
        
        arg2.doFilter(arg0, arg1);
    }

}
