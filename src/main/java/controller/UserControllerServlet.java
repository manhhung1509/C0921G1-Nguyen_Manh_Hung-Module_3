package controller;

import bean.User;
import service.UserService;
import service.impl.UserServiceIMPL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "UserControllerServlet", urlPatterns = {"","/UserControllerServlet"})
public class UserControllerServlet extends HttpServlet {
    UserService userService = new UserServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserService userService = new UserServiceIMPL();
        String action = request.getParameter("userChoice");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createUser(request, response);
                    break;
                case "update":
                    editUser(request, response);
                case "search":
                    searchUser(request, response);
                case "sort":
                    sortUser(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("userChoice");
        Integer id = null;
        Integer userDeleteId = null;
        try{
             id = Integer.parseInt(request.getParameter("userId"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if (id != null){
            request.setAttribute("userID", id);
            request.getRequestDispatcher("edit.jsp")
                    .forward(request, response);
        }

        try{
            userDeleteId = Integer.parseInt(request.getParameter("userDeleteId"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if (userDeleteId != null){
            userService.deleteUser(userDeleteId);
        }

        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    editUser(request, response);
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
    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String massage = userService.save(name, email,country);

        request.setAttribute("massage", massage);
        request.getRequestDispatcher("create.jsp")
                .forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        userService.edit(id, name, email,country);

        request.setAttribute("massage", "Update thành công");
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> users = userService.sortByName();
        request.setAttribute("listUser", users);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }


    private void searchUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String country = request.getParameter("country");
        List<User> userList = userService.finByCountry(country);
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}