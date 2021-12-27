package service.service_impl;

import bean.Customer;
import responsitory.responsitory_impl.CustomerResponsibility;
import service.CustomerService;

import java.util.List;

public class CustomerServiceIMPL implements CustomerService {

    private CustomerResponsibility customerResponsibility = new CustomerResponsibility();

    @Override
    public List<Customer> findAll() {
        return customerResponsibility.findAll();
    }

    @Override
    public String save(String name, Integer id, String address, String email) {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setId(id);
            customer.setAddress(address);
            customer.setEmail(email);
            customerResponsibility.save(customer);
            return "thêm thành Công";
    }

    @Override
    public String deleteCustomer(Integer id) {
        boolean flag = false;
        List<Customer> customerList = customerResponsibility.findAll();
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)){
                flag = true;
                break;
            }
        }
        if (!flag){
            return "không tìm thấy khách hàng";
        }
        return "Xóa thành công";
    }

    @Override
    public String edit(Integer idKey,String name, Integer id, String address, String email) {
        boolean flag = false;
        List<Customer> customerList = customerResponsibility.findAll();
        for (Customer customer : customerList) {
            if (customer.getId().equals(idKey)){
                flag = true;
                break;
            }
        }
        if (!flag){
            return "Id khách hàng cần chỉnh sửa không đúng";
        }
        Customer customer = new Customer();
        customer.setName(name);
        customer.setId(id);
        customer.setAddress(address);
        customer.setEmail(email);
        customerResponsibility.save(customer);

        return "Sửa thành Công";
    }
}
