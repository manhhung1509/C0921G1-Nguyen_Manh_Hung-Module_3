package controller;

import service.UserService;
import service.impl.UserServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet",urlPatterns = "/CreateServlet")
public class CreateServlet extends HttpServlet {
    private UserService userService = new UserServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userName");
        String email = request.getParameter("email");
        String county = request.getParameter("country");
        String message = userService.save( name, email, county);
        request.setAttribute("message", message);
        request.getRequestDispatcher("create.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
