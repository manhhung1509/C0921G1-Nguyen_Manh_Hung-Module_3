package controller;

import service.UserService;
import service.impl.UserServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditServlet", urlPatterns = "/EditServlet")
public class EditServlet extends HttpServlet {
    private UserService userService = new UserServiceIMPL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer inToEdit = Integer.parseInt(request.getParameter("idToEdit"));
        String name = request.getParameter("userName");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String message = userService.edit(inToEdit, name, email, country);
        request.setAttribute("message", message);
        request.getRequestDispatcher("edit.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
