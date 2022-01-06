package repository.repository_impl;

import bean.*;
import repository.BaseRepository;
import repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryIMPL implements EmployeeRepository {
    private static final String SELECT_ALL = "SELECT * FROM employee\n" +
            "join position on position.position_id = employee.position_id\n" +
            "join education_degree on education_degree.education_degree_id = employee.education_degree_id\n" +
            "join devision on devision.devision_id = employee.devision_id\n" +
            "join `user` on `user`.user_name = employee.user_name";
    private static final String SELECT_POSITION = "SELECT * FROM furama_resort.position;";
    private static final String SELECT_EDUCATION = "SELECT * FROM furama_resort.education_degree;";
    private static final String SELECT_DEVISION = "SELECT * FROM furama_resort.devision;";
    private static final String SELECT_USER = "SELECT * FROM furama_resort.user;";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee.employee_id = ?;";
    private static final String CREATE_EMPLOYEE = "insert into employee (employee_name ,employee_birthday,employee_id_card,employee_salary,\n" +
            "employee_phone,employee_email,employee_address,position_id,education_degree_id,devision_id,user_name)\n" +
            "values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_EMPLOYEE = "call find_eemployee(?,?,?);";
    private static final String FIND_BY_ID = "call find_employee_by_id(?);";
    private static final String UPDATE_EMPLOYEE = "call update_employee(?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Employee> selectAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            Employee employee = null;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                Position position = new Position(resultSet.getInt("position_id"), resultSet.getString("position_name"));
                employee.setPosition(position);
                EducationDegree educationDegree = new EducationDegree(resultSet.getInt("education_degree_id"), resultSet.getString("education_degree_name"));
                employee.setEducationDegree(educationDegree);
                Devision devision = new Devision(resultSet.getInt("devision_id"), resultSet.getString("devision_name"));
                employee.setDevision(devision);
                User user = new User(resultSet.getString("user_name"), resultSet.getString("password"));
                employee.setUser(user);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Position> selectPosition() {
        List<Position> positionList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_POSITION);
            Position position = null;
            while (resultSet.next()) {
                position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(resultSet.getString("position_name"));
                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }

    @Override
    public List<EducationDegree> selectEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_EDUCATION);
            EducationDegree educationDegree = null;
            while (resultSet.next()) {
                educationDegree = new EducationDegree();
                educationDegree.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                educationDegree.setEducationDegreeName(resultSet.getString("education_degree_name"));
                educationDegreeList.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }

    @Override
    public List<Devision> selectDevision() {
        List<Devision> devisionList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_DEVISION);
            Devision devision = null;
            while (resultSet.next()) {
                devision = new Devision();
                devision.setDevisionId(resultSet.getInt("devision_id"));
                devision.setDevisionName(resultSet.getString("devision_name"));
                devisionList.add(devision);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return devisionList;
    }

    @Override
    public List<User> selectUser() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_USER);
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public void createEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(CREATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setDate(2, (java.sql.Date) employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPosition().getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegree().getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDevision().getDevisionId());
            preparedStatement.setString(11, employee.getUser().getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = BaseRepository.connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employee> findEmployee(int id, String name, String phone) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall(FIND_EMPLOYEE);
            callableStatement.setString(1, name);
            callableStatement.setString(2, phone);
            callableStatement.setInt(3, id);
            ResultSet resultSet = callableStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                Position position = new Position(resultSet.getInt("position_id"),resultSet.getString("position_name"));
                EducationDegree educationDegree = new EducationDegree(resultSet.getInt("education_degree_id"),resultSet.getString("education_degree_name"));
                Devision devision = new Devision(resultSet.getInt("devision_id"),resultSet.getString("devision_name"));
                User user = new User(resultSet.getString("user_name"),resultSet.getString("password"));
                employee.setPosition(position);
                employee.setEducationDegree(educationDegree);
                employee.setDevision(devision);
                employee.setUser(user);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall(FIND_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                Position position = new Position(resultSet.getInt("position_id"),resultSet.getString("position_name"));
                EducationDegree educationDegree = new EducationDegree(resultSet.getInt("education_degree_id"),resultSet.getString("education_degree_name"));
                Devision devision = new Devision(resultSet.getInt("devision_id"),resultSet.getString("devision_name"));
                User user = new User(resultSet.getString("user_name"),resultSet.getString("password"));
                employee.setPosition(position);
                employee.setEducationDegree(educationDegree);
                employee.setDevision(devision);
                employee.setUser(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall(UPDATE_EMPLOYEE);
            callableStatement.setInt(1, employee.getEmployeeId());
            callableStatement.setString(2, employee.getEmployeeName());
            callableStatement.setDate(3, (java.sql.Date) employee.getEmployeeBirthday());
            callableStatement.setString(4, employee.getEmployeeIdCard());
            callableStatement.setDouble(5, employee.getEmployeeSalary());
            callableStatement.setString(6, employee.getEmployeePhone());
            callableStatement.setString(7, employee.getEmployeeEmail());
            callableStatement.setString(8, employee.getEmployeeAddress());
            callableStatement.setInt(9, employee.getPosition().getPositionId());
            callableStatement.setInt(10, employee.getEducationDegree().getEducationDegreeId());
            callableStatement.setInt(11, employee.getDevision().getDevisionId());
            callableStatement.setString(12, employee.getUser().getUserName());
            callableStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
