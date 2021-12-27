package controller;

import service.impl.ProductService;
import service.impl.ProductServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.DeleteServlet", urlPatterns = "/controller.DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private ProductService productService = new ProductServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer inToDelete = Integer.parseInt(request.getParameter("idToDelete"));
        String message = productService.deleteProduct(inToDelete);
        request.setAttribute("message", message);
        request.getRequestDispatcher("delete.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
