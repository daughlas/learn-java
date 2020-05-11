package tech.lvjiawen.jdbc.servlet;

import tech.lvjiawen.jdbc.bean.User;
import tech.lvjiawen.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转到登录页面 Servlet
 */
public class LoginPromptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request, response);
    }
}
