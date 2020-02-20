package Servlet;

import Method.IfUser;
import doMain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZIYANG on 2020/2/19.
 */
@WebServlet("/login")
public class Servlet_login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");

        // 从request中创建user对象
        User request_user = new User();
        request_user.setUsername(request.getParameter("username"));
        request_user.setPassword(request.getParameter("password"));

        // 判断request_user是否是正确的
        User user = IfUser.isUser(request_user);
        if (user == null) { // 没有这个用户，跳转到Servlet fail
            request.getRequestDispatcher("/fail").forward(request, response);
        } else {    // 有这个用户，保存User对象，转到Servlet success
            request.setAttribute("user", user);
            request.getRequestDispatcher("/success").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
