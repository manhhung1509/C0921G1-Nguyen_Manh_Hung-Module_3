package service.service_impl;

import bean.ContractDetail;
import repository.CustomerUsingRepository;
import repository.repository_impl.CustomerUsingRepositoryIMPL;
import service.CustomerUsingService;

import java.util.List;

public class CustomerUsingIMPL implements CustomerUsingService {
    CustomerUsingRepository customerUsingRepository = new CustomerUsingRepositoryIMPL();
    @Override
    public List<ContractDetail> selectAll() {
        List<ContractDetail> customerList = customerUsingRepository.selectAll();
        return customerList;
    }
}
