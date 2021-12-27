package controller;

import bean.Product;
import service.impl.ProductService;
import service.impl.ProductServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchByNameServlet", urlPatterns = "/SearchByNameServlet")
public class SearchByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ProductService productService = new ProductServiceIMPL();
        List<Product> products = productService.search(name);
        request.setAttribute("products", products);
        request.getRequestDispatcher("search_by_name.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
