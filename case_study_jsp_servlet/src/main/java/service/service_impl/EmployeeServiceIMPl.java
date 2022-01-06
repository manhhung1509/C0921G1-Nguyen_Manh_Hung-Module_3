package service.service_impl;

import bean.*;
import repository.EmployeeRepository;
import repository.repository_impl.EmployeeRepositoryIMPL;
import service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceIMPl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryIMPL();
    @Override
    public List<Employee> selectAll() {
        List<Employee> employeeList = employeeRepository.selectAll();
        return employeeList;
    }

    @Override
    public List<Position> selectPosition() {
        List<Position> positionList = employeeRepository.selectPosition();
        return positionList;
    }

    @Override
    public List<EducationDegree> selectEducationDegree() {
        List<EducationDegree> educationDegreeList = employeeRepository.selectEducationDegree();
        return educationDegreeList;
    }

    @Override
    public List<Devision> selectDevision() {
        List<Devision> devisionList = employeeRepository.selectDevision();
        return devisionList;
    }

    @Override
    public List<User> selectUser() {
        List<User> userList = employeeRepository.selectUser();
        return userList;
    }

    @Override
    public Map<String, String> createEmployee(Employee employee) {
        Map<String,String> massageMap = new HashMap<>();
        if (!employee.getEmployeeName().matches("[A-Za-z ]+")){
            massageMap.put("name","Invalid Name Format");
//                if ("".equals(customer.getCustomerBirthday())){
//                    massageMap.put("dayOfBirth","Please Input Birthday");
//                }
//            if ("".equals(employee.get())){
//                massageMap.put("gender","Please Select Gender");
//            }
        }
        if (massageMap.isEmpty()){
            employeeRepository.createEmployee(employee);
        }
        return massageMap;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> findEmployee(int id, String name, String phone) {
        List<Employee> employeeList = employeeRepository.findEmployee(id, name, phone);
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = employeeRepository.findById(id);
        return employee;
    }

    @Override
    public Map<String, String> updateEmployee(Employee employee) {
        Map<String,String> massageMap = new HashMap<>();
        if (!employee.getEmployeeName().matches("[A-Za-z ]+")){
            massageMap.put("name","Invalid Name Format");
//            if ("".equals(customer.getCustomerBirthday())){
//                massageMap.put("dayOfBirth","Please Input Birthday");
//            }
//            if ("".equals(employee.getCustomerGender())){
//                massageMap.put("gender","Please Select Gender");
//            }
        }
        if (massageMap.isEmpty()){
            employeeRepository.updateEmployee(employee);
        }
        return massageMap;
    }
}
