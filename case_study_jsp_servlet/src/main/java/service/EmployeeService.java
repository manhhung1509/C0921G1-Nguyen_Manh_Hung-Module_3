package service;

import bean.*;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> selectAll();
    public List<Position> selectPosition();
    public List<EducationDegree> selectEducationDegree();
    public List<Devision> selectDevision();
    public List<User> selectUser();
    public Map<String,String> createEmployee(Employee employee);
    public void deleteEmployee(int id);
    public List<Employee> findEmployee(int id, String name, String phone);
    public Employee findById(int id);
    public Map <String, String> updateEmployee(Employee employee);
}
