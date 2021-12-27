package controller;

import service.impl.ProductService;
import service.impl.ProductServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.EditServlet", urlPatterns = "/controller.EditServlet")
public class EditServlet extends HttpServlet {
    private ProductService productService = new ProductServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer inToEdit = Integer.parseInt(request.getParameter("idToEdit"));
        String name = request.getParameter("productName");
        String address = request.getParameter("address");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String message = productService.edit(inToEdit ,name, id, address, email);
        request.setAttribute("message", message);
        request.getRequestDispatcher("edit.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
