package controller;

import bean.User;
import responsibility.UserResponsibility;
import responsibility.impl.UserResponsibilityIMPL;
import service.UserService;
import service.impl.UserServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserControllerServlet", urlPatterns = "/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userChoice = request.getParameter("choice");
        UserService userService = new UserServiceIMPL();
        if (userChoice == null) {
            userChoice = "";
        }

        switch (userChoice) {
            case "create":
                request.getRequestDispatcher("create.jsp")
                        .forward(request, response);
                break;
            case "edit":
                request.getRequestDispatcher("edit.jsp")
                        .forward(request, response);
                break;
            case "delete":
                request.getRequestDispatcher("delete.jsp")
                        .forward(request, response);
                break;
            case "display":
                List<User> users = userService.findAll();
                request.setAttribute("listUser", users);
                request.getRequestDispatcher("display.jsp")
                        .forward(request, response);
                break;
            case "find by country":
                request.getRequestDispatcher("find_by_country.jsp")
                        .forward(request, response);
                break;
            case "sort by name":
                request.getRequestDispatcher("sort_by_name.jsp")
                        .forward(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user_choice.jsp")
                .forward(request, response);
    }
}
