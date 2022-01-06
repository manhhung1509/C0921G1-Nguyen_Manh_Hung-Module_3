package controller;

import bean.Customer;
import bean.CustomerType;
import service.CustomerService;
import service.service_impl.CustomerServiceIMPL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceIMPL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
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
            case "findCustomer":
                findCustomer(request, response);
                break;
            case "showList":
                showList(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
        showList(request, response);
    }

    private void findCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("findCustomerId"));
        String name = request.getParameter("findCustomerName");
        String phone = request.getParameter("findCustomerPhone");
        List<Customer> customerList = customerService.findCustomer(id,name,phone);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        List<CustomerType> customerTypeList = customerService.selectCustomerType();
        request.setAttribute("customer", customer);
        request.setAttribute("customerType", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        int id = Integer.parseInt(request.getParameter("cId"));
        int type_id = Integer.parseInt(request.getParameter("id_customer_type"));
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        CustomerType customerType = new CustomerType(type_id);
        Customer customer = new Customer(id,customerType,name,birthday,gender, idCard, phone,email,address);
        customerService.updateCustomer(customer);
        List<CustomerType> customerTypeList = customerService.selectCustomerType();
        request.setAttribute("customer", customer);
        request.setAttribute("customerType", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerService.selectCustomerType();
        request.setAttribute("customerType", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.selectAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer.jsp");
        dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
        String name = request.getParameter("name");
        int customerTypeId = Integer.parseInt(request.getParameter("id_customer_type"));
        Date birthday = null;
        if (!"".equals(request.getParameter("birthday")))
        {
            birthday = Date.valueOf(request.getParameter("birthday"));
        }
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(new CustomerType(customerTypeId),name,birthday,gender, idCard, phone,email,address );
        List<CustomerType> customerTypeList = customerService.selectCustomerType();
        Map<String,String> massageMap = customerService.CreateCustomer(customer);
        if (!massageMap.isEmpty()){
            request.setAttribute("msgName", massageMap.get("rName"));
            request.setAttribute("msgGender", massageMap.get("rGender"));
            request.setAttribute("msgPhone", massageMap.get("rPhone"));
            request.setAttribute("msgAddress", massageMap.get("rAdress"));
            request.setAttribute("msgEmail", massageMap.get("rEmail"));
            request.setAttribute("msgIdCard", massageMap.get("rIdCArd"));
            request.setAttribute("msgCType", massageMap.get("rTypeId"));
            request.setAttribute("msgEmptyName", massageMap.get("rName"));
            request.setAttribute("msgBirthday", massageMap.get("rBirthday"));
            request.setAttribute("customerType", customerTypeList);
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("create_customer.jsp");
            dispatcher.forward(request, response);
        }else {
            request.setAttribute("customer", customer);
            request.setAttribute("customerType", customerTypeList);
            request.setAttribute("msgSuccess", "Thêm thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("create_customer.jsp");
            dispatcher.forward(request, response);
        }
    }

}
