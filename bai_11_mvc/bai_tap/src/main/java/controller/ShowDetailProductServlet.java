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

@WebServlet(name = "ShowDetailProductServlet", urlPatterns = "/ShowDetailProductServlet")
public class ShowDetailProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ProductService  productService = new ProductServiceIMPL();
        List<Product> productList = productService.showDetail(id);
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("show_detail.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
