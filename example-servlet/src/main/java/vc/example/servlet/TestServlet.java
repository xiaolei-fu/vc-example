package vc.example.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 *
 * @author xiaolei.fu
 * @since 2021-02-06 23:24
 */
@WebServlet(urlPatterns = "/test", name = "test")
public class TestServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/plain;charset=UTF-8");
        servletResponse.getWriter().write("test\r\n");
        servletResponse.getWriter().flush();
        servletResponse.getWriter().close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
