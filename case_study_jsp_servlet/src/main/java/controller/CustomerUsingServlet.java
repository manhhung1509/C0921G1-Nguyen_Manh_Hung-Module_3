package controller;

import bean.ContractDetail;
import bean.Customer;
import service.CustomerService;
import service.CustomerUsingService;
import service.service_impl.CustomerServiceIMPL;
import service.service_impl.CustomerUsingIMPL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerUsingServlet", urlPatterns = "/customerUsingServlet")
public class CustomerUsingServlet extends HttpServlet {
    private CustomerUsingService customerUsingService = new CustomerUsingIMPL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                try {
                    update(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                showList(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showUpdate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "showList":
                showList(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        customerRepository.delete(id);
//        showList(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = customerRepository.findById(id);
//        List<CustomerType> customerTypeList = customerTypeRepository.selectAll();
//        request.setAttribute("customer", customer);
//        request.setAttribute("customerType", customerTypeList);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("updateCustomer.jsp");
//
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String idCard = request.getParameter("idCard");
//        String phone = request.getParameter("phone");
//        int idCustomerType = Integer.parseInt(request.getParameter("id_customer_type"));
//
//        CustomerType customerType = new CustomerType(idCustomerType);
//        Customer customer = new Customer(id, name, idCard, phone, customerType);
//        customerRepository.update(customer);
//        showList(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
//        List<CustomerType> customerTypeList = customerTypeRepository.selectAll();
//        request.setAttribute("customerType", customerTypeList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("demo_create_customer.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContractDetail> customerList = new ArrayList<>();
        customerList = customerUsingService.selectAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer_using_service_in_resort.jsp");
        dispatcher.forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
//
//        String name = request.getParameter("name");
//        String idCard = request.getParameter("idCard");
//        String phone = request.getParameter("phone");
//
//        int id = Integer.parseInt(request.getParameter("id_customer_type"));
//        Customer customer = new Customer(name, idCard, phone, new CustomerType(id));
//        try {
//            customerRepository.insert(customer);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("demo_create_customer.jsp");
//            request.setAttribute("message", "Da xoa");
//            dispatcher.forward(request, response);
//        } catch (SQLException | ServletException | IOException e) {
//            e.printStackTrace();
        }
}