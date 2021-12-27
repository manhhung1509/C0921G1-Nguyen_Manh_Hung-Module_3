package controller;

import service.CustomerService;
import service.service_impl.CustomerServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditServlet", urlPatterns = "/EditServlet")
public class EditServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceIMPL();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer inTOEdit = Integer.parseInt(request.getParameter("idToEdit"));
        String name = request.getParameter("customerName");
        String address = request.getParameter("address");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String message = customerService.edit(inTOEdit ,name, id, address, email);
        request.setAttribute("message", message);
        request.getRequestDispatcher("edit.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
