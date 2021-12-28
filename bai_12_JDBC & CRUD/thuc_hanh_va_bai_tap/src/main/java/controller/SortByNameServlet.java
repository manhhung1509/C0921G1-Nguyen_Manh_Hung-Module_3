package controller;

import bean.User;
import service.UserService;
import service.impl.UserServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SortByNameServlet", urlPatterns = "/SortByNameServlet")
public class SortByNameServlet extends HttpServlet {
    private UserService userService = new UserServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.sortByName();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("sort_by_name.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
