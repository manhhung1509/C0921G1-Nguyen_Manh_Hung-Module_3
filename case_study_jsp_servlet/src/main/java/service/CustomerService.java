package service;

import bean.Customer;
import bean.CustomerType;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    public List<Customer> selectAll();
    public List<CustomerType> selectCustomerType();
    public Map<String,String> CreateCustomer(Customer customer);
    public void deleteCustomer(int id);
    public List<Customer> findCustomer(int id, String name, String phone);
    public Customer findById(int id);
    public Map <String, String> updateCustomer(Customer customer);
}
