package tech.lvjiawen.jdbc.servlet;

import tech.lvjiawen.jdbc.bean.User;
import tech.lvjiawen.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        // 没有用 单例
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathName = request.getServletPath();
        if (Objects.equals("/userInfo.do", pathName)) {
            request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request, response);
        } else if (Objects.equals("/editUserPrompt.do", pathName)) {
            // 1. 从 session 中获取，其实就是与上一个 if 同样的方式
            // 2. 可拓展的使用方式：根据页面 ID 从数据库中查询
            Long id = Long.valueOf(request.getParameter("id"));
            User user = userService.getUserById(id);
            if (null != user) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/views/biz/edit_user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
            }
        } else if (Objects.equals("/editUser.do", pathName)) {
            Long id = Long.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String realName = request.getParameter("realName");
            String birthday = request.getParameter("birthday");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setPassword(password);
            try {
                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
            } catch (ParseException e) {
                System.out.println("格式化 Birthday 字段失败");
                e.printStackTrace();
            }
            user.setPhone(phone);
            user.setAddress(address);
            user.setRealName(realName);
            boolean result = userService.updateUser(user);
            if (result) {
                request.getSession().setAttribute("user", user);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
        }
    }
}
