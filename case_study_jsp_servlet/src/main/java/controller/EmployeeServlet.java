package controller;

import bean.*;
import service.EmployeeService;
import service.service_impl.EmployeeServiceIMPl;

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

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceIMPl();
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
            case "findEmployee":
                findEmployee(request, response);
                break;
            case "showList":
                showList(request, response);
                break;
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        showList(request, response);
    }

    private void findEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("findEmployeeId"));
        String name = request.getParameter("findEmployeeName");
        String phone = request.getParameter("findEmployeePhone");
        employeeList = employeeService.findEmployee(id,name,phone);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        List<Position> positionList = employeeService.selectPosition();
        List<EducationDegree> educationDegreeList = employeeService.selectEducationDegree();
        List<Devision> devisionList = employeeService.selectDevision();
        List<User> userList = employeeService.selectUser();
        request.setAttribute("employee", employee);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("devisionList", devisionList);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        int id = Integer.parseInt(request.getParameter("eId"));
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("idPosition"));
        int educationId = Integer.parseInt(request.getParameter("idEducation"));
        int devisionId = Integer.parseInt(request.getParameter("idDevision"));
        String userName = request.getParameter("userName");
        Position position = new Position(positionId);
        EducationDegree educationDegree = new EducationDegree(educationId);
        Devision devision = new Devision(devisionId);
        User user = new User(userName);
        Employee employee = new Employee(id,name,birthday,idCard,salary, phone, email,address,position,educationDegree,devision,user);
        employeeService.updateEmployee(employee);
        List<Position> positionList = employeeService.selectPosition();
        List<EducationDegree> educationDegreeList = employeeService.selectEducationDegree();
        List<Devision> devisionList = employeeService.selectDevision();
        List<User> userList = employeeService.selectUser();
        request.setAttribute("customer", employee);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("devisionList", devisionList);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = employeeService.selectPosition();
        List<EducationDegree> educationDegreeList = employeeService.selectEducationDegree();
        List<Devision> devisionList = employeeService.selectDevision();
        List<User> userList = employeeService.selectUser();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("devisionList", devisionList);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create_employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeService.selectAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
        dispatcher.forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("idPosition"));
        int educationId = Integer.parseInt(request.getParameter("idEducation"));
        int devisionId = Integer.parseInt(request.getParameter("idDevision"));
        String userName = request.getParameter("userName");
        Position position = new Position(positionId);
        EducationDegree educationDegree = new EducationDegree(educationId);
        Devision devision = new Devision(devisionId);
        User user = new User(userName);
        Employee employee = new Employee(name,birthday,idCard,salary, phone, email,address,position,educationDegree,devision,user);
        List<Position> positionList = employeeService.selectPosition();
        List<EducationDegree> educationDegreeList = employeeService.selectEducationDegree();
        List<Devision> devisionList = employeeService.selectDevision();
        List<User> userList = employeeService.selectUser();
        Map<String,String> massageMap = employeeService.createEmployee(employee);
        if (!massageMap.isEmpty()){
            request.setAttribute("msgName", massageMap.get("name"));
            request.setAttribute("msgDayOfBirth", massageMap.get("dayOfBirth"));
            request.setAttribute("msgGender", massageMap.get("gender"));
            RequestDispatcher dispatcher = request.getRequestDispatcher("create_employee.jsp");
            dispatcher.forward(request, response);
        }else {
            request.setAttribute("employee", employee);
            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("devisionList", devisionList);
            request.setAttribute("userList", userList);
            request.setAttribute("msgSuccess", "Thêm thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("create_employee.jsp");
            dispatcher.forward(request, response);
        }
    }
}
