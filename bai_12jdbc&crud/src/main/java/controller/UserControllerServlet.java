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
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "UserControllerServlet", urlPatterns = {"userControllerServlet","/"})
public class UserControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userChoice = request.getParameter("choice");
        UserService userService = new UserServiceIMPL();
//        if (userChoice == null) {
//            userChoice = "";
//        }
//
//        switch (userChoice) {
//            case "create":
//                request.getRequestDispatcher("create.jsp")
//                        .forward(request, response);
//                break;
//            case "edit":
//                request.getRequestDispatcher("edit.jsp")
//                        .forward(request, response);
//                break;
//            case "delete":
//                request.getRequestDispatcher("delete.jsp")
//                        .forward(request, response);
//                break;
//            case "display":
//                List<User> users = userService.findAll();
//                request.setAttribute("listUser", users);
//                request.getRequestDispatcher("display.jsp")
//                        .forward(request, response);
//                break;
//            case "find by country":
//                request.getRequestDispatcher("find_by_country.jsp")
//                        .forward(request, response);
//                break;
//            case "sort by name":
//                request.getRequestDispatcher("sort_by_name.jsp")
//                        .forward(request, response);
//                break;
//        }
        String action = request.getParameter("userChoice");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
//                case "edit":
//                    updateUser(request, response);
//                case "search":
//                    search(request, response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("user_choice.jsp")
//                .forward(request, response);
        String action = request.getParameter("userChoice");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "edit":
                    editUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    UserService userService = new UserServiceIMPL();
                    List<User> users = userService.findAll();
                    request.setAttribute("listUser", users);
                    request.getRequestDispatcher("display.jsp").forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(name, email, country);
//        user.insertUserStore(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(name, email, country);
//        user.insertUserStore(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(name, email, country);
//        user.insertUserStore(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
    }
}