package repository.repository_impl;


import bean.Customer;
import bean.CustomerType;
import repository.BaseRepository;
import repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryIMPL implements CustomerRepository {

    private static final String SELECT_ALL = "SELECT * FROM customer join customer_type\n" +
            "on customer_type.customer_type_id= customer.customer_type_id";
    private static final String SELECT_CUSTOMER_TYPE = "SELECT * FROM furama_resort.customer_type";
    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE customer.customer_id = ?;";
    private static final String CREATE_CUSTOMER = "insert into customer (customer_type_id ,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)\n" +
            "values (?,?,?,?,?,?,?,?)";
    private static final String FIND_CUSTOMER = "call find_customer(?,?,?)";
    private static final String FIND_BY_ID = "SELECT * FROM furama_resort.customer\n" +
            "join customer_type on customer.customer_type_id = customer_type.customer_type_id\n" +
            "where customer.customer_id = ?;";
    private static final String UPDATE_CUSTOMER = "call update_customer(?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            Customer customer = null;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                CustomerType customerType = new CustomerType(resultSet.getInt("customer_type_id"), resultSet.getString("customer_type_name"));
                customer.setCustomerType(customerType);
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getDate("customer_birthday"));
                if ("1".equals(resultSet.getString("customer_gender"))) {
                    customer.setCustomerGender("Male");
                } else {
                    customer.setCustomerGender("Female");
                }
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<CustomerType> selectCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CUSTOMER_TYPE);
            CustomerType customerType = null;
            while (resultSet.next()) {
                customerType = new CustomerType();
                customerType.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customerType.setCustomerTypeName(resultSet.getString("customer_type_name"));
                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }

    public void CreateCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(CREATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setDate(3, (java.sql.Date) customer.getCustomerBirthday());
            preparedStatement.setBoolean(4, Boolean.parseBoolean(customer.getCustomerGender()));
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = BaseRepository.connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Customer> findCustomer(int id, String name, String phone) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(FIND_CUSTOMER);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, "%" + name + "%");
            preparedStatement.setString(3, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                CustomerType customerType = new CustomerType(resultSet.getInt("customer_type_id"), resultSet.getString("customer_type_name"));
                customer.setCustomerType(customerType);
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getDate("customer_birthday"));
                if ("1".equals(resultSet.getString("customer_gender"))) {
                    customer.setCustomerGender("Male");
                } else {
                    customer.setCustomerGender("Female");
                }
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                CustomerType customerType = new CustomerType(resultSet.getInt("customer_type_id"), resultSet.getString("customer_type_name"));
                customer.setCustomerType(customerType);
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getDate("customer_birthday"));
                if ("1".equals(resultSet.getString("customer_gender"))) {
                    customer.setCustomerGender("Male");
                } else {
                    customer.setCustomerGender("Female");
                }
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    public void updateCustomer(Customer customer) {
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall(UPDATE_CUSTOMER);
            callableStatement.setInt(1, customer.getCustomerId());
            callableStatement.setInt(2, customer.getCustomerType().getCustomerTypeId());
            callableStatement.setString(3, customer.getCustomerName());
            callableStatement.setDate(4, (java.sql.Date) customer.getCustomerBirthday());
            callableStatement.setBoolean(5, Boolean.parseBoolean(customer.getCustomerGender()));
            callableStatement.setString(6, customer.getCustomerIdCard());
            callableStatement.setString(7, customer.getCustomerPhone());
            callableStatement.setString(8, customer.getCustomerEmail());
            callableStatement.setString(9, customer.getCustomerAddress());
            ResultSet resultSet = callableStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
