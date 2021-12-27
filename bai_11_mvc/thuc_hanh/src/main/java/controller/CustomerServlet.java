package controller;


import bean.Customer;
import responsitory.responsitory_impl.CustomerResponsibility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userChoice = request.getParameter("choice");

        if (userChoice == null) {
            userChoice = "";
        }

        switch (userChoice) {
               case "create":
                request.getRequestDispatcher("create_customer.jsp")
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
            case "display":
                CustomerResponsibility customerResponsibility = new CustomerResponsibility();
                List<Customer> customersList = customerResponsibility.findAll();
                request.setAttribute("ListCustomer", customersList);
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
