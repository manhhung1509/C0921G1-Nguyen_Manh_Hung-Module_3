package service.service_impl;

import bean.Customer;
import bean.CustomerType;
import repository.CustomerRepository;
import repository.repository_impl.CustomerRepositoryIMPL;
import service.CustomerService;
import service.vailidate.ValidateService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceIMPL implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryIMPL();
    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = customerRepository.selectAll();
        return customerList;
    }

    @Override
    public List<CustomerType> selectCustomerType() {
        List<CustomerType> customerTypeList = customerRepository.selectCustomerType();
        return customerTypeList;
    }

    @Override
    public Map<String,String> CreateCustomer(Customer customer) {
        Map<String,String> massageMap = new HashMap<>();
        if (ValidateService.checkEmpty(customer.getCustomerName())){
            massageMap.put("rName","vui lòng nhập tên");
        }else if(!ValidateService.checkName(customer.getCustomerName())){
            massageMap.put("rName","Tên không được chứa số và kí tự");
        }

        if (ValidateService.checkEmpty(customer.getCustomerIdCard())){
            massageMap.put("rIdCArd","Vui lòng nhập id card");
        }else if (!ValidateService.checkIdCard(customer.getCustomerIdCard())){
            massageMap.put("rIdCArd","Id card phải là số có 9 hoặc 12 số ");
        }

        if (ValidateService.checkEmpty(customer.getCustomerEmail())){
            massageMap.put("rEmail","Vui lòng nhập email");
        }else if (!ValidateService.checkEmail(customer.getCustomerEmail())){
            massageMap.put("rEmail","Vui lòng nhập đúng định dạng: abc@abc.abc");
        }

        if (ValidateService.checkEmpty(customer.getCustomerAddress())){
            massageMap.put("rAdress","Vui lòng nhập địa chỉ");
        }

        if (ValidateService.checkEmpty(customer.getCustomerPhone())){
            massageMap.put("rPhone","Vui lòng nhập số điện thoại");
        }else if (!ValidateService.checkPhone(customer.getCustomerPhone())){
            massageMap.put("rPhone","Nhập 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }

        if (customer.getCustomerType().getCustomerTypeId() == -1){
            massageMap.put("rTypeId","Vui lòng chọn customer type id");
        }
        if (customer.getCustomerGender() == null){
            massageMap.put("rGender", "Vui lòng chọn giới tính");
        }
        if (customer.getCustomerBirthday() == null){
            massageMap.put("rBirthday", "Vui lòng chọn ngày sinh");
        }


        if (massageMap.isEmpty()){
            customerRepository.CreateCustomer(customer);
        }
        return massageMap;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> findCustomer(int id, String name, String phone) {
        List<Customer> customerList = customerRepository.findCustomer(id, name, phone);
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = customerRepository.findById(id);
        return customer;
    }

    @Override
    public Map<String, String> updateCustomer(Customer customer) {
        Map<String,String> massageMap = new HashMap<>();
        if (!customer.getCustomerName().matches("[A-Za-z ]+")){
            massageMap.put("name","Invalid Name Format");
            if ("".equals(customer.getCustomerGender())){
                massageMap.put("gender","Please Select Gender");
            }
        }
        if (massageMap.isEmpty()){
            customerRepository.updateCustomer(customer);
        }
        return massageMap;
    }
}
