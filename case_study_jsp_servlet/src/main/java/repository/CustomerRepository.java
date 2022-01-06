package repository;

import bean.Customer;
import bean.CustomerType;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> selectAll();
    public List<CustomerType> selectCustomerType();
    public void CreateCustomer(Customer customer);
    public void deleteCustomer(int id);
    public List<Customer> findCustomer(int id, String name, String phone);
    public Customer findById(int id);
    public void updateCustomer(Customer customer);
}
