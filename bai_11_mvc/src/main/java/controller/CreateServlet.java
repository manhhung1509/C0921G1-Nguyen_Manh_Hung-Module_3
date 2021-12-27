package controller;

import bean.Customer;
import service.CustomerService;
import service.service_impl.CustomerServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = "/CreateServlet")
public class CreateServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("customerName");
        String address = request.getParameter("address");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String message = customerService.save(name, id, address, email);
        request.setAttribute("message", message);
        request.getRequestDispatcher("create_customer.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
