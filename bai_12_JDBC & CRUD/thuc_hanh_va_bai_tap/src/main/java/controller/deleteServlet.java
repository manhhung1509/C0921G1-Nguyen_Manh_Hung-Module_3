package controller;

import service.UserService;
import service.impl.UserServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteServlet",urlPatterns = "/deleteServlet")
public class deleteServlet extends HttpServlet {
    private UserService userService = new UserServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer inToDelete = Integer.parseInt(request.getParameter("idToDelete"));
        String message = userService.deleteProduct(inToDelete);
        request.setAttribute("message", message);
        request.getRequestDispatcher("delete.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
