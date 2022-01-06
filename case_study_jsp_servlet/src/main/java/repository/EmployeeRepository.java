package repository;

import bean.*;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> selectAll();
    public List<Position> selectPosition();
    public List<EducationDegree> selectEducationDegree();
    public List<Devision> selectDevision();
    public List<User> selectUser();
    public void createEmployee(Employee employee);
    public void deleteEmployee(int id);
    public List<Employee> findEmployee(int id, String name, String phone);
    public Employee findById(int id);
    public void updateEmployee(Employee employee);
}
