package controller;

import bean.Product;
import reponsitory.ProductResponsibility;
import reponsitory.impl.ProductResponsibilityIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller.ProductServlet", urlPatterns = "/controller.ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userChoice = request.getParameter("choice");

        if (userChoice == null) {
            userChoice = "";
        }

        switch (userChoice) {
            case "create":
                request.getRequestDispatcher("create_product.jsp")
                        .forward(request, response);
                break;
            case "edit":
                request.getRequestDispatcher("edit.jsp")
                        .forward(request, response);
                break;
            case "delete":
                request.getRequestDispatcher("delete.jsp")
                        .forward(request, response);
                break;
            case "showDetail":
                request.getRequestDispatcher("show_detail.jsp")
                        .forward(request, response);
                break;
            case "search":
                request.getRequestDispatcher("search_by_name.jsp")
                        .forward(request, response);
                break;
            case "display":
                ProductResponsibility productResponsibility = new ProductResponsibilityIMPL();
                List<Product> productList = productResponsibility.findAll();
                request.setAttribute("ListProduct", productList);
                request.getRequestDispatcher("display.jsp")
                        .forward(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("customer_choice.jsp")
                .forward(request, response);
    }
}
