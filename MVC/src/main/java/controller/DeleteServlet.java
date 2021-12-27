package controller;

import service.CustomerService;
import service.service_impl.CustomerServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer inToDelete = Integer.parseInt(request.getParameter("idToDelete"));
        String message = customerService.deleteCustomer(inToDelete);
        request.setAttribute("message", message);
        request.getRequestDispatcher("delete.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
