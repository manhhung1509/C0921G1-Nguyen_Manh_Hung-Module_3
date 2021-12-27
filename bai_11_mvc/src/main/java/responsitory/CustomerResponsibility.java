package responsitory;

import bean.Customer;

import java.util.List;

public interface CustomerResponsibility {
    List<Customer> findAll();

    void save(Customer customer);

    void deleteCustomer(Integer id);

    void edit(Integer id, Customer customer);
}
