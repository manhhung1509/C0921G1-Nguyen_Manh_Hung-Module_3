package controller;

import service.impl.ProductService;
import service.impl.ProductServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.CreateServlet", urlPatterns = "/controller.CreateServlet")
public class CreateServlet extends HttpServlet {
    private ProductService productService = new ProductServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("productName");
        String address = request.getParameter("address");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String message = productService.save(name, id, address, email);
        request.setAttribute("message", message);
        request.getRequestDispatcher("create_product.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
