package service;

import bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    String save(String name, Integer id, String address, String email);

    String deleteCustomer(Integer id);

    String edit(Integer idKey,String name, Integer id, String address, String email);

}
